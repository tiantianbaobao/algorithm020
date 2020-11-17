package com.tiantianbaobao.algorithm.practise;

/***
 * @description check given target node {@link Node} has a recycle
 * @author <h>cuitao@aixuexi.com</h>
 * @date 2020-11-16 15:32
 * @since V1.0.0
 */
public class RecycleBootstrap {
    public static void main(String[] args) {
        System.err.println("has recycle ? " + _check(_buildTestObj()));
    }

    /**
     * build test case
     * @return
     */
    private static Node _buildTestObj() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node1.tail = node2;
        node2.tail = node3;
        node3.tail = node4;
        node4.tail = node5;
        //return true when open this
//        node5.tail = node3;
        return node1;
    }

    /***
     * check given listed-object has a recycle
     * @param target
     * @return has or not
     */
    private static boolean _check(Node target) {
        Node slow = target;
        Node fast = target.tail;
        if (slow == null || fast == null) {
            return false;
        }
        while(slow.equals(fast)) {
            if (slow == null || fast == null) {
                return false;
            }
            slow = slow.tail;
            fast = fast.tail.tail;
        }
        return true;
    }

    private static class Node {
        private Node prev;
        private Integer value;
        private Node tail;
        public Node(Integer value) {
            this.value = value;
        }
    }
}
