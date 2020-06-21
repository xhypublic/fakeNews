package io.renren.utils;

public class IDUtils {
    private static byte[] lock = new byte[0];

    // 位数，默认是8位
    private final static long w = 100000000;

    public static Long createID() {
        long r = 0;
        synchronized (lock) {
            r = (long) ((Math.random() + 1) * w);
        }

        return System.currentTimeMillis();
    }
}