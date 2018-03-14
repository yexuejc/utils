package com.yexuejc.util.example.design_mode.single;
/**
 * 单例模式 v1
 * @author yexue
 * @expl http://www.cnblogs.com/zuoxiaolong/p/pattern2.html
 * @time 2017年8月30日 下午12:02:29
 */
public class Singleton {

    //一个静态的实例
    private static Singleton singleton;
    //私有化构造函数
    private Singleton(){}
    //给出一个公共的静态方法返回一个单一实例
    public static Singleton getInstance(){
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}