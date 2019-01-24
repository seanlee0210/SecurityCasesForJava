public class ThreadRunAndStart {
    public static void main(String[] args) {
        System.out.println("The main thread is:" + Thread.currentThread().getId());
        Foo foo = new Foo();
        System.out.print("The actually running thread for 'run' is:");
        new Thread(foo).run();

        System.out.print("The actually running thread for 'start' is:");
        new Thread(foo).start();
    }
}

class Foo implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getId());
    }
}
