package java0.conc0301.op;

public class Join {
    
    public static void main(String[] args) {
        Object oo = new Object();
    
        MyThread thread1 = new MyThread("thread1 -- ");
        thread1.setOo(oo);
        thread1.start();
        synchronized (thread1) {         // 如果这里是oo
            for (int i = 0; i < 100; i++) {
                if (i == 20) {
                    try {
                        thread1.join();  // join释放锁的方式
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " -- " + i);
            }
        }
    }
    
}

class MyThread extends Thread {

    private String name;
    private Object oo;
    
    public void setOo(Object oo) {
        this.oo = oo;
    }
    
    public MyThread(String name) {
        this.name = name;
    }
    
    @Override
    public void run() {
        synchronized (this) {  // 如果这里也是oo，会卡在main -- 19。说明join没有释放锁
            for (int i = 0; i < 100; i++) {
                System.out.println(name + i);
            }
        }
    }
    
}