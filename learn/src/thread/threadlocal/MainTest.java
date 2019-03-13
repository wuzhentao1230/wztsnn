package thread.threadlocal;

public class MainTest {
    public static void main(String[] args) throws InterruptedException {
        TestThreadLocal testThreadLocal = new TestThreadLocal();
        ThreadTest threadTest = new ThreadTest(testThreadLocal);

        Thread t1 = new Thread(threadTest);
        Thread t2 = new Thread(threadTest);
        t1.start();
        t2.start();
        //join等上诉线程运行完之后才往下运行
        t1.join();
        t2.join();
        System.out.println("end");
//        System.out.println(testThreadLocal.get());
    }

}
