package com.sxzhongf.daily.question.july;

/**
 * Ask20190718_ParentAndChildThread for Please check {@link ClassInitializedOrder}
 *
 * @author <a href="mailto:magicianisaac@gmail.com">Isaac.Zhang | 若初</a>
 * @since 2019/7/18
 */
public class Ask20190718_ParentAndChildThread {

    private static boolean initialized = false;

    static {
        println("static 代码块执行。");
        Thread thread = new Thread(() -> initialized = true);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        println("main 函数执行。");
        System.out.println("initialized = " + initialized);
    }

    private static void println(Object o) {
        System.out.println(o);
    }
}
