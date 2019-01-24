import java.nio.CharBuffer;
import java.nio.IntBuffer;
import java.nio.ReadOnlyBufferException;

public class NakedBuffer {
    public static void main(String[] args) {

        /***
         *  Wrap primitive array into buffer
         */
        System.out.println("=====Wrap=====");
        Wrapper wrapper = new Wrapper();
        CharBuffer cb = wrapper.getBufferWrapper();
        char[] origin = wrapper.cb;
        CharBuffer sub = cb.subSequence(0, 1);
        System.out.println("buffer before:" + cb.toString());
        System.out.println("origin before:" + origin[0] + origin[1]);
        System.out.println("sub before :" + sub.toString());
        cb.put(0, 'n');
        cb.put(1, 's');
        System.out.println("buffer after:" + cb.toString());
        System.out.println("origin after:" + origin[0] + origin[1]);
        System.out.println("sub after :" + sub.toString());

        try{
            cb = wrapper.getSecuredBufferWrapper();
            cb.put(1, 'n');
            cb.put(0, 's');
        }catch (ReadOnlyBufferException ex){
            System.out.println("secured buffer after:" + cb.toString());
            System.out.println("secured origin after:" + origin[0] + origin[1]);
        }

        System.out.println("=====Duplicate=====");
        /***
         * Duplicate the buffer
         */
        Duplicator duplicator = new Duplicator();
        IntBuffer intBuffer = duplicator.getBufferCopy();
        IntBuffer originIB = duplicator.intBuffer;
        System.out.println("buffer before:" + intBuffer.get(0));
        System.out.println("origin before:" + originIB.get(0));
        intBuffer.put(0, 9);
        System.out.println("buffer after:" + intBuffer.get(0));
        System.out.println("origin after:" + originIB.get(0));

        System.out.println("Now you know it's all the same inside buffer.");
    }
}

class Wrapper {
    public char[] cb = null;
    public Wrapper(){
        cb = new char[]{'a','q'};
    }

    public CharBuffer getBufferWrapper(){
        return CharBuffer.wrap(cb);
    }

    public CharBuffer getSecuredBufferWrapper(){
        return CharBuffer.wrap(cb).asReadOnlyBuffer();
    }
}


class Duplicator {
    public IntBuffer intBuffer = null;
    public Duplicator(){
        intBuffer = IntBuffer.allocate(1);
        intBuffer.put(0, 1);
    }

    public IntBuffer getBufferCopy(){
        return intBuffer.duplicate();
    }

    public IntBuffer getSecuredBufferCopy(){
        return intBuffer.asReadOnlyBuffer();
    }
}
