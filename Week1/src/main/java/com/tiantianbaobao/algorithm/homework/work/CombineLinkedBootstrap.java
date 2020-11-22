package com.tiantianbaobao.algorithm.homework.work;

/***
 * @description combine two linked list and keep ordered
 * @author <h>tiantianbaobao</h>
 * @date 2020-11-22 15:59
 * @since V1.0.0
 */
public class CombineLinkedBootstrap {
    public static void main(String[] args) {
        Node node1 = createOneNode();
        Node node2 = createTwoNode();
        Node resultNode = _combineNodes(node1, node2);
        _serr(resultNode);
    }

    /***
     * serr each data
     * @param resultNode
     * @return
     */
    private static void _serr(Node resultNode) {
       while(resultNode!=null) {
           System.err.println("current value is " + resultNode.value);
            resultNode = resultNode.next;
        }
    }

    /**
     * combine two node, and keep their ordered
     * @param node1
     * @param node2
     */
    private static Node _combineNodes(Node node1, Node node2) {
         if (node1 == null) {
             return node2;
         }
         if (node2 == null) {
             return node1;
         }
         if (node1.value < node2.value) {
             node1.next = _combineNodes(node1.next, node2);
             return node1;
         }else {
             node2.next = _combineNodes(node1, node2.next);
             return node2;
         }
    }


    private static Node createOneNode(){
        Node node = new Node(1);
        Node node1 = new Node(3);
        Node node2 = new Node(5);
        Node node3 = new Node(7);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        return node;
    }

    private static Node createTwoNode(){
        Node node = new Node(2);
        Node node1 = new Node(4);
        Node node2 = new Node(6);
        Node node3 = new Node(8);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        return node;
    }


    private static class Node {
        private Node prev;
        private Integer value;
        private Node next;
        public Node(Integer value) {
            this.value = value;
        }

        public Node(){

        }
    }
}
