package com.codecart;

import org.junit.jupiter.api.Test;

public class ThreadLocalTest {
    @Test
    public void test() {
        ThreadLocal t1 = new ThreadLocal();
        new Thread(()->{t1.set("1");
            System.out.println(Thread.currentThread().getName()+":"+t1.get());
            System.out.println(Thread.currentThread().getName()+":"+t1.get());
            System.out.println(Thread.currentThread().getName()+":"+t1.get());
            },"thread1")
                .start();
        new Thread(()->{t1.set("2");
            System.out.println(Thread.currentThread().getName()+":"+t1.get());
            System.out.println(Thread.currentThread().getName()+":"+t1.get());
            System.out.println(Thread.currentThread().getName()+":"+t1.get());},"thread2")
                .start();
    }
}
