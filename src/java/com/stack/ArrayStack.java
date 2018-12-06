package com.stack;

public class ArrayStack {
    private long[] arr;//容器
    private int size; //大小
    private int top; //栈顶

    public ArrayStack(int maxSize) {
        this.size = maxSize;
        this.arr = new long[size];
        this.top = -1;
    }

    public boolean isEmpty() {
        /**
         * 是否为空
         */
        return this.top == -1;
    }

    public boolean isFull() {
        /**
         * 是否满
         */
        return this.top == this.size - 1;
    }

    public int size() {
        /**
         * 栈大小
         */
        return this.top + 1;
    }

    public void push(long value) {
        /**
         * 入栈
         */
        if (isFull()) {
            System.out.println("入栈失败 栈已经满");
            return;
        }
        arr[++top] = value;
    }

    public Long pop() {
        /**
         * 出栈
         */
        if (isEmpty()) {
            System.out.println("出栈失败，栈为空");
            return null;
        }
        return arr[top--];
    }

    public Long peek() {
        /**
         * 返回栈顶
         */
        if (isEmpty()) {
            System.out.println("返回栈顶失败，栈为空");
            return null;
        }
        return arr[top];
    }

    public void display() {
        System.out.println("------- start show stack---------");
        for (int i = top; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n-------start show stack---------");
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        stack.push(1L);
        stack.display();
        stack.push(4L);
        stack.display();
        stack.push(5L);
        stack.display();
        stack.push(2L);
        stack.display();
        stack.push(1L);
        stack.display();
        stack.push(0L);
        stack.display();
        System.out.println(stack.pop());
        stack.display();
    }
}
