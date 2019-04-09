package top.ningg.algo.thread;

/**
 * * 题目：
 * 1. 定义一个 Task；
 * 2. 使用 3 个线程启动，每个传入1，2，3；
 * 3. 线程 1，只能输出 1；
 * 4. 线程 2，只能输出 2；
 * 5. 线程 3，只能输出 3；
 * 6. 3 个线程，交替输出 1，2，3， 共计 5 次；
 *
 * 分析：
 * 1. 一个 Task
 * 2. 线程之间有序
 * 3. 使用一把锁，同时，由锁来标识当前输出哪个数即可。
 */
public class ThreeThread {


    static class Task extends Thread {

        // 共享锁
        private static volatile Integer OUTPUT_LOCK = 1;
        // 控制输出次数
        private static volatile int TIMES = 5;

        // 传入的参数标记
        private int value;

        public Task(int value) {
            this.value = value;
        }

        @Override
        public void run() {
            while (true) {
                // 1. 线程监听过程: 内部判断结束条件
                if (TIMES <= 0) {
                    return;
                }

                // 2. 获取锁
                synchronized (OUTPUT_LOCK) {

                    // 3. 根据锁中携带的信息, 进行线程间协作
                    switch (OUTPUT_LOCK) {
                        case 1:
                            if (OUTPUT_LOCK == this.value) {
                                System.out.println(this.value);
                                OUTPUT_LOCK = 2;
                            }
                            break;
                        case 2:
                            if (OUTPUT_LOCK == this.value) {
                                System.out.println(this.value);
                                OUTPUT_LOCK = 3;
                            }
                            break;
                        case 3:
                            if (OUTPUT_LOCK == this.value) {
                                System.out.println(this.value);
                                OUTPUT_LOCK = 1;
                                TIMES--;
                            }
                            break;
                        default:
                            break;
                    }
                }

            }
        }
    }

    public static void main(String[] args) {
        Task task1 = new Task(1);
        Task task2 = new Task(2);
        Task task3 = new Task(3);

        task1.start();
        task2.start();
        task3.start();
    }

}
