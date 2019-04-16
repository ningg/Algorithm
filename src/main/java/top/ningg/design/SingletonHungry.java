package top.ningg.design;

/**
 * 单例模式: 饿汉模式(立即创建实例)
 */
public class SingletonHungry {

    // 构造方法私有
    private SingletonHungry() {

    }

    // 饿汉: 提前创建对象
    private static final SingletonHungry singleton = new SingletonHungry();

    // 提供方法: 获取对象
    public static SingletonHungry getInstance() {
        return singleton;
    }

}
