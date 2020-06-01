package com.devglan.linkedlist;

public class LinkedListRunner {

    public static void main(String [] args){
        /*CustomLinkedList customLinkedList = new CustomLinkedList();
        customLinkedList.insert(5);
        customLinkedList.insert(6);
        customLinkedList.insert(3);
        customLinkedList.insert(8);
        customLinkedList.insert(9);

        customLinkedList.display();


        CustomLinkedList customLinkedList1 = new CustomLinkedList();
        customLinkedList1.insert(8);
        customLinkedList1.insert(4);
        customLinkedList1.insert(2);
        customLinkedList1.insert(3);
        customLinkedList1.insert(1);
        customLinkedList1.display();

        Node result = customLinkedList.findSum(customLinkedList.get(), customLinkedList1.get());
        Node sumHead = result;
        while (sumHead != null){
            System.out.print(sumHead.getData() + " ");
            sumHead = sumHead.getNextNode();
        }
*/
        Node commonNodes = null;
        int[] commonData = {80, 90, 100};
        for (int i = 0; i < commonData.length; i++){
            Node node = new Node(commonData[i]);
            node.setNextNode(commonNodes);
            commonNodes = node;
        }

        Node node1 = commonNodes;
        int[] firstListData = {1, 2, 3};
        for (int i = 0; i < firstListData.length; i++){
            Node node = new Node(firstListData[i]);
            node.setNextNode(node1);
            node1 = node;
        }

        Node node2 = commonNodes;
        int[] secondListData = {4, 5};
        for (int i = 0; i < secondListData.length; i++){
            Node node = new Node(secondListData[i]);
            node.setNextNode(node2);
            node2 = node;
        }

        CustomLinkedList customLinkedList1 = new CustomLinkedList();
        Node intersectionNode = customLinkedList1.findIntersection(node1, node2);
        System.out.println(intersectionNode.getData());

    }
}
