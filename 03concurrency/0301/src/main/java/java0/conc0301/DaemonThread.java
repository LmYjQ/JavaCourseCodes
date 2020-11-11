package java0.conc0301;

public class DaemonThread {
    
    public static void main(String[] args) {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Thread t = Thread.currentThread();
                System.out.println("当前线程:" + t.getName());
            }
        };
        Thread thread = new Thread(task);
        thread.setName("test-thread-1");
        // 如果只有一个线程，还设置为守护线程，那么里面的逻辑不会执行
        thread.setDaemon(false);
        thread.start();
    }
    
    
}
