package com.tao.wztsnn.jdk8.FunctionalInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        /**
         * 1、lambda表达式
         * 这种形式最为直观，lambda表达式，接收一个String类型的参数，返回一个String类型的结果。
         * 完全符合函数式接口FunctionInterfaceTest的定义
         */
        FunctionInterfaceTest functionInterfaceTest1 = item -> item+1;
        System.out.println(functionInterfaceTest1.getInfo("1:"));

        /**
         * 2、方法引用
         * Main方法当中的getInstance和getMessage方法接收一个参数，返回一个结果。符合函数式接口
         * FunctionInterfaceTest的定义。
         * 函数式接口只是定义了个方法的约定（接收一个String类型的参数，返回一个String类型的结果），
         * 而对于方法内部进行何种操作则并没有做任何的限制。在这点上，跟java以前的版本中的实现类与接口之间的
         * 关系很类似。不同的是，函数式接口更偏重于计算过程，约束了一个计算过程的输入和输出。
         * 这种约束计算过程的输入和输出的形式的好处可以看一下joinStr方法。
         */
        FunctionInterfaceTest functionInterfaceTest2 = Main::getInstance;  //方法引用
        FunctionInterfaceTest functionInterfaceTest3 = Main::getMessage;  //方法引用

        String msg1 = joinStr("你好",functionInterfaceTest2); //输出：你好！世界
        String msg2 = joinStr("你好",functionInterfaceTest3); //输出：世界，你好！
        System.out.println(msg1);
        System.out.println(msg2);

        //还有更简单的写法,高度抽象化，具体处理由使用者自己决定
        String msg3 = joinStr("你好",item ->item+"！世界"); //输出：你好！世界
        String msg4 = joinStr("你好",item ->"世界,"+ item+"!"); //输出：世界，你好！
        System.out.println(msg3);
        System.out.println(msg4);

        /**
         * 3、构造方法引用
         * 构造函数的结构：接收输入参数，然后返回一个对象。这种约束跟函数式接口的约束很像。
         * 所以只要“输入参数类型”与“输出参数类型”跟FunctionInterfaceTest中的方法约束相同，
         * 就可以创建出FunctionInterfaceTest接口的实例，如下，String的构造方法中有
         * new String(str)的构造方法，所以可以得到实例。
         * 这里存在一个类型推断的问题，JDK的编译器已经帮我们自动找到了只有一个参数，且是String类型的构造方法。
         * 这就是我们直接String::new，没有指定使用哪一个构造方法，却可以创建实例的原因
         */
        FunctionInterfaceTest functionInterfaceTest4 = String::new; //方法引用


        /**
         * 如果函数当成参数的话
         *
         */
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        //forEach传参Consumer接口类中的 void accept(T t)方法(有参数无返回结果的函数式接口)  则可以直接写
        list.stream().filter(n->true).forEach(System.out::println);

        //sort 调用了 Comparator接口类中的 int compare(T o1, T o2);
        List<String> names1 = new ArrayList<String>();
        names1.add("Google ");
        names1.add("Runoob ");
        names1.add("Taobao ");
        names1.add("Baidu ");
        names1.add("Sina ");
        Collections.sort(names1, (s1, s2) -> s1.compareTo(s2));
    }

    public static String getInstance(String item){
        return item+"！世界";
    }

    public static String getMessage(String massage){
        return "世界,"+ massage+"!";
    }

    public  static String joinStr(String str,FunctionInterfaceTest functionTest){
        return functionTest.getInfo(str);
    }
}
