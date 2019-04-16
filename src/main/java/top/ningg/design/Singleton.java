package top.ningg.design;

/**
 * 单例模式: 懒汉模式.(延迟加载对象)
 *
 * 参考： https://www.cnblogs.com/garryfu/p/7976546.html
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

    // 改进并发度：获取实例
    public static Singleton getInstanceHighPerformance() {
        // 双重检查
        if (null == singleton) {
            synchronized (Singleton.class) {
                singleton = new Singleton();
            }
        }

        return singleton;
    }
}


