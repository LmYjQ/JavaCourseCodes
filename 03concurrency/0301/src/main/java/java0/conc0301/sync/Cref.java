package java0.conc0301.sync;

public class Cref {
    public static void main(String[] args) {
        // 反编译，常量和变量不同,常量线程安全
        int x = 10;
        int y = Counter.B;
    }
}
