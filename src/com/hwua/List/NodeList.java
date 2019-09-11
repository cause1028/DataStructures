package com.hwua.List;

import java.util.Stack;

public class NodeList {
    private Node node = null;

    public NodeList() {
        node = new Node(0);
    }

    public void add(Node newNode) {
        Node temp = node;

        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    //用栈来反向打印链表
    public void reversePrint(Node headNode) {
        Stack<Node> stack = new Stack<>();
        Node node = headNode;
        while (node != null) {
            stack.push(node);
            node = node.next;
        }

        while (stack.size() > 0) {
            Node pop = stack.pop();
            System.out.println(pop.no);
        }
    }

    //翻转链表
    public void reverseList(Node headNode) {
        Node cur = headNode.next;
        Node next = null;
        Node reverseHead = new Node(0);
        while (cur != null) {
            next = cur.next;//先暂时保存当前节点的下一个节点，因为后面需要使用
            cur.next = reverseHead.next;//将cur的下一个节点指向新的链表的最前端
            reverseHead.next = cur; //将cur 连接到新的链表上
            cur = next;//让cur后移
        }
        headNode.next = reverseHead.next;
    }

    public void show() {
        Node temp = node;
        if (temp.next == null) {
            System.out.println("链表为空");
            return;
        }
        while (temp.next != null) {
            temp = temp.next;
            System.out.println(temp.no);
        }
    }

    public Node getHead() {
        if (node.next == null) {
            System.out.println("链表为空");
            return null;
        }
        return node;
    }

    public Node get(int i) {
        if (node == null || node.next == null) {
            System.out.println("链表为空");
            return null;
        }
        while (node != null) {
            if (node.no == i) {
                return node;
            }
            node = node.next;
        }
        return node;
    }

    public int size() {
        int i = 0;
        while (node.next != null) {
            node = node.next;
            i++;
        }
        return i;
    }
}
