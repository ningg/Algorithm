package top.ningg.design;

/**
 * 单例模式: 懒汉模式.(需要的时候, 采取实例化)
 */
public class Singleton {

    // 构造方法: 私有
    private Singleton() {

    }

    // 对象实例: 不创建
    private static Singleton singleton = null;

    // 对外方法: 加锁
    public static synchronized Singleton getInstance() {
        if (null == singleton) {
            singleton = new Singleton();
        }

        return singleton;
    }
}


