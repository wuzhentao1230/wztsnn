package thread.threadlocal;

public class TestThreadLocal {
    // 定义匿名子类创建ThreadLocal的变量为什么是静态的，不管你new多少个这个类，ThreadLocal只有一个
    private static ThreadLocal<Integer> tl = new ThreadLocal<Integer>() {
        // 覆盖初始化方法,泛型指定什么类型就返回什么类型，方法名不变自动调用。
        public Integer initialValue() {
            System.out.println("初始化了");
            return 0;
        }
    };

    public int get() {
        return tl.get();
    }

    public void set() {
        tl.set(tl.get() + 1);
    }
}
