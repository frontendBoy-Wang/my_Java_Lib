package com.泛型.斗地主;

import java.util.ArrayList;
import java.util.Collections;

public class DouDiZhu {
    public static void main(String[] args) {
        //准备洗牌
        //定义一个存储54张牌的ArrayList集合,泛型使用String
        ArrayList<String> poker = new ArrayList<>();
        //定义两个数组存储花色和序号
        String[] colors = {"♠", "♥", "♣", "♦"};
        String[] numbers = {"2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3"};
        //把大王和小王存储到poker集合中
        poker.add("大王");
        poker.add("小王");
        //循环嵌套遍历两个数组,组装52张牌
        for (String number : numbers) {
            for (String color : colors) {
                //System.out.println(color+number);
                //把组装好的牌存储到poker中
                poker.add(color + number);
            }
        }
        //System.out.println(poker);
        /*
        2.洗牌
            使用集合工具类Collections中的方法:
            static void shuffle(list)使用默认随机源对列表进行置换
         */
        Collections.shuffle(poker);
        //System.out.println(poker);

        /*
        3.发牌
         */
        //定义四个集合存储玩家和底牌
        ArrayList<String> player01 = new ArrayList<>();
        ArrayList<String> player02 = new ArrayList<>();
        ArrayList<String> player03 = new ArrayList<>();
        ArrayList<String> diPai = new ArrayList<>();

        /*
        遍历poker,获取每一张牌
        使用poker集合的索引%3给3个玩家轮流发牌
        剩余3张牌
        注意:先判断底牌(i>=51),否则牌就发没了
         */
        for (int i = 0; i < poker.size(); i++) {
            //获取每一张牌
            String p=poker.get(i);
            //轮流发牌
            if(i>=51){
                //给底牌发牌
                diPai.add(p);
            }else if(i%3==0){
                //给玩家1发牌
                player01.add(p);
            }else if(i%3==1){
                //给玩家2发牌
                player02.add(p);
            }else if(i%3==2){
                //给玩家3发牌
                player03.add(p);
            }
        }
        //4.看牌
        System.out.println("刘德华"+player01);
        System.out.println("周星驰"+player02);
        System.out.println("周润发"+player03);
        System.out.println("底牌"+diPai);
    }
}




















