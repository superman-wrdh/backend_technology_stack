package com.queen;

public class RoundQueue {
    private long[] arr;
    private int size;
    private int nItems;//实际存储数量
    private int front;//头
    private int rear;//尾

    public RoundQueue(int maxSize) {
        this.size = maxSize;
        this.arr = new long[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    private boolean isFull() {
        return nItems == size;
    }

    private boolean isEmpty() {
        return nItems == 0;
    }

    public int size() {
        return nItems;
    }

    public void insert(long value) {
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
        rear = ++rear % size;
        arr[rear] = value;
        nItems++;
    }

    public Long remove() {
        if (isEmpty()) {
            System.out.println("队列空，删除失败");
            return null;
        }
        nItems--;
        front = front % size;
        return arr[front++];
    }

    public void display() {
        System.out.println("------ show ---------");
        if (isEmpty()) {
            System.out.println("队列为空！");
            return;
        }
        int item = front;
        for (int i = 0; i < nItems; i++) {
            System.out.print(arr[item++ % size] + " ");
        }
        System.out.println("\n ----- show ----------");
    }

    public long peek() {
        if (isEmpty()) {
            System.out.println("队列为空！");
            return 0;
        }
        return arr[front];
    }

    public static void main(String[] args) {
        RoundQueue queue = new RoundQueue(5);
        queue.insert(1L);
        queue.display();
        queue.insert(5);
        queue.display();
        queue.insert(6);
        queue.display();
        queue.remove();
        queue.display();
        queue.insert(8);
        queue.display();
        queue.insert(9);
        queue.display();
        queue.insert(12);
        queue.display();
        queue.insert(66);
        queue.display();
    }
}
