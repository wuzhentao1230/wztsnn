package thread.threadlocal;

public class ThreadTest implements Runnable {

    TestThreadLocal testThreadLocal;

    public ThreadTest(TestThreadLocal paramThread) {
        testThreadLocal = paramThread;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            testThreadLocal.set();
            System.out.println(Thread.currentThread() + "" + testThreadLocal.get());
        }
    }
}
