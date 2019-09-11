package com.hwua.List;

public class ListDemo {

    public static void main(String args[]) {
        NodeList node = new NodeList();
        node.add(new Node(1));
        node.add(new Node(2));
        node.add(new Node(3));
        node.add(new Node(4));

        node.show();
        //  node.reversePrint(node.getHead());
        node.reverseList(node.getHead());
        node.show();

    }
}
