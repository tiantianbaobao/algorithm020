package com.tiantianbaobao.algorithm;

/***
 * @description Main引导类
 * @author <h>tiantianbaobao</h>
 * @date 2020-11-13 15:59
 * @since V1.0.0
 */
public class Bootstrap {

    private static String wrong_think = "只做一遍";
    private static String break_up = "拆分知识点";
    private static String deliberate_practice = "刻意练习:1h、1d、1w、1m";
    private static String feedback = "及时反馈【主动反馈、被动反馈】";

    public static void main(String[] args) {
        System.err.println("错误的思考方式 ：" + wrong_think);
        System.out.println("正确的处理思路：1、" + break_up + "  " +
                "2、" + deliberate_practice + "  " +
                "3、" + feedback);
        System.out.println("Hi~ This is my homework about algorithm for training camp week 1");
    }
}
