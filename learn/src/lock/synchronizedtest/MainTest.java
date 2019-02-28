package lock.synchronizedtest;


/***
 * https://blog.csdn.net/sinat_32588261/article/details/72880159
 */
public class MainTest {
    public synchronized void methodFunction(){
        // todo
    }

    public void methodBody()
    {
        synchronized(this) {
            // todo
        }
    }

    public static void main(String[] args) {

    }
}
