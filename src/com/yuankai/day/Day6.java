package com.yuankai.day;

import java.util.Stack;

public class Day6 {

    /**
     * 用两个栈实现队列
     * https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
     */
    class CQueue {

        private Stack<Integer> stack;
        private Stack<Integer> tmp;

        public CQueue() {
            stack = new Stack<>();
            tmp = new Stack<>();
        }

        public void appendTail(int value) {
            stack.push(value);
        }

        public int deleteHead() {
            if(tmp.isEmpty()){
                if(stack.isEmpty()){
                    return -1;
                }
                while(!stack.isEmpty()){
                    tmp.add(stack.pop());
                }
                return tmp.pop();
            }else{
                return tmp.pop();
            }
        }
    }
}
