package service;

public class Delay {
    Delay() {
    }

    void wait(int milliseconds) {
        try {
            Thread.sleep((long)milliseconds);
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }
}
