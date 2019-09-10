package com.hwua.List;

public class StackDemo {
    public static void main(String[] args) {
        MyStack myStack = new MyStack(4);

        myStack.push(10);
        myStack.push(20);
        myStack.push(30);
        myStack.push(40);
        myStack.push(50);

        myStack.show();
        int pop = myStack.pop();
        System.out.println(pop);
        myStack.show();
    }
}

class MyStack {
    private int maxsize;
    private int[] array;
    private int top;

    public MyStack(int maxsize) {
        this.maxsize = maxsize;
        array = new int[maxsize];
        top = -1;
    }

    //入栈
    public void push(int num) {
        if (top == maxsize - 1) {
            System.out.println("栈满");
            return;
        }
        top++;
        array[top] = num;
    }

    //出栈
    public int pop() {
        if (top == -1) {
            throw new RuntimeException("栈空");
        }
        int i = array[top];
        top--;
        return i;
    }

    //打印
    public void show() {
        for (int i = top; i >= 0; i--) {
            System.out.println(array[i]);
        }
    }
}