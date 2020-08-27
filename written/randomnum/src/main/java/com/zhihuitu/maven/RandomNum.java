package com.zhihuitu.maven;

import java.util.*;

/**
 * @Author : RenChunMing
 * @Date : 2020/8/27 12:59.
 */
public class RandomNum {
    public static void main(String[] args) {
        //test1(500000);//效率低
       test2(100000);//效率高
    }
    /*
    * 效率较低
    * */
    public static void test1(int count1){

        long startTime = System.currentTimeMillis(); //开始时间
        //创建随机对象
        Random r = new Random();
        //创建集合对象
        ArrayList<Integer> array = new ArrayList<Integer>();
        //产生随机数
        int count = 0;
        while (count<100000){
            //产生随机数
            int number = r.nextInt(count1);
            //判断是否重复
            if(!array.contains(number)){
                //如果集合不存在这个数字，添加该随机数
                array.add(number);
                count++;
            }
        }
        //遍历
        for (Integer i : array){
            System.out.println(i);
        }
        long endTime = System.currentTimeMillis(); //获取结束时间
        System.out.println("运行时间： " + (endTime - startTime) + "ms");
    }

    /*
    * 效率较高
    * */
    public static void test2(int count){
        long startTime = System.currentTimeMillis(); //开始时间
        Object[] values = new Object[count];
        Random random = new Random();
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>(100000);
        // 生成随机数字并存入HashMap
        System.out.println(values.length+"-----------------------");
        for(int i = 0;i < values.length;i++){
            int number = random.nextInt(values.length);
            hashMap.put(number, i);
        }
        values=hashMap.keySet().toArray();
        // 遍历数组并打印数据
        for(int i = 0;i < values.length;i++){
            System.out.println(values[i]);
        }

        long endTime = System.currentTimeMillis(); //获取结束时间
        System.out.println("运行时间： " + (endTime - startTime) + "ms");
    }
}
