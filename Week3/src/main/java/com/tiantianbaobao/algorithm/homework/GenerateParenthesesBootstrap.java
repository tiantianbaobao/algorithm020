package com.tiantianbaobao.algorithm.homework;

import java.util.ArrayList;
import java.util.List;

/***
 * @description generate parentheses  by recursion
 * @author <h>cuitao@aixuexi.com</h>
 * @date 2020-12-05 22:48
 * @since V1.0.0
 */
public class GenerateParenthesesBootstrap {
    private static List<String> result = new ArrayList<>();
    public static void main(String[] args) {
        _generateParentheses(0, 0,3, "");
        System.err.println(result);
    }

    /***
     * recursion create
     * 误区：不要人肉递归，简言之递归的话暂时先不要考虑下一层，只考虑当前这一层要干什么，同时准备好下次的请求参数
     * 抽象出方法的主要逻辑：
     * 1、当总的括号数够了就不创建了，把结果返回
     * 2、process -> 追加括号
     * 3、当左括号还没满时我随意增加
     * 4、当且左括号比右括号的数据多时才能创建右括号
     * @param left
     * @param right
     * @param n
     * @param str
     */
    public static void  _generateParentheses(int left, int right, int n, String str){
        //terminator 当left和right同时为n时才表明处理完成并返回
        if (left == n && right == n){
            result.add(str);
            return;
        }
        //processing

        //drill down
        //只要left还小于总数，就可以继续随意添加（
        if (left < n) {
            _generateParentheses(left + 1, right, n, str + "(");
        }
        //当且仅当left > right时才可以进行右括号的追加，当然前提是left不能超越n
        if (left > right) {
            _generateParentheses(left, right + 1, n, str + ")");
        }
        //reverse
    }
}
