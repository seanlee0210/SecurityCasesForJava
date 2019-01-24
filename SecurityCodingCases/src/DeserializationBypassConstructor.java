import java.io.*;

public class DeserializationBypassConstructor {

    public static void main(String[] args) {
        try {
            System.out.println("Creating...");
            Child c = new Child(1);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            System.out.println("Serializing...");
            oos.writeObject(c);
            oos.flush();
            baos.flush();
            oos.close();
            baos.close();
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            System.out.println("Deserializing...");
            Child c1 = (Child) ois.readObject();
            System.out.println("c1.i=" + c1.getI());
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }


    public static class Child implements Serializable {
        protected int i;

        public Child(){
            System.out.println("Child::No param Constructor");
        }

        public Child(int i) {
            this.i = i;
            System.out.println("Child::Constructor");
        }

        public int getI() {
            return i;
        }
    }
}