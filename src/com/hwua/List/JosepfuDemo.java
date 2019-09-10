package com.hwua.List;

public class JosepfuDemo {
    public static void main(String[] args) {
        CircleList circleList = new CircleList(5);

        circleList.go(2, 2);
    }
}

class CircleList {
    private int size;
    private Node head;
    private Node tail;

    public CircleList(int size) {
        if (size < 1) return;
        this.size = size;
        head = new Node(1);
        Node curr = head;
        for (int i = 2; i <= size; i++) {
            curr.next = new Node(i);
            curr = curr.next;
            tail = curr;
        }
        curr.next = head;
    }

    public void go(int m, int n) {
        for (int i = 0; i < m-1; i++) {
            head = head.next;
            tail = tail.next;
        }

        while (head.next != head) {
            for (int i = 0; i < n - 1; i++) {
                head = head.next;
                tail = tail.next;
            }
            System.out.println(head.no + "出列");
            tail.next = head.next;
            head = head.next;
        }
        System.out.println(head.no+"最后留在圈内");
    }
}