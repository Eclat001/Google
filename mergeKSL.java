package GoogleOA;

import java.util.Comparator;
import java.util.PriorityQueue;

import amazon.ListNode;

/* Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity. */

public class mergeKSL {
	//Time complexity O(k*n*log(k)) Space O(k)
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        //override comparator
        Comparator<ListNode> compare = new Comparator<ListNode>() {
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        };
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.length, compare);
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null ){
                heap.offer(lists[i]);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (!heap.isEmpty()) {
            ListNode node = heap.poll();
            head.next = node;
            head = head.next;
            if (node.next != null) {
                heap.offer(node.next);
            }
        }
        return dummy.next;
    }
    public static void main(String[]args){
//    	ListNodeUtils.producePool();
//    	ListNodeUtils.printList(ListNodeUtils.pool);
    	/*
    	ListNode[] nodes = new ListNode[100];
    	ListNode[] input = new ListNode[5];
    	for (int i = 0; i < 100; i++){
    		ListNode n = new ListNode(i);
    		nodes[i] = n;
    	}
    	for(int i = 0; i < 5; i++){
    		input[i] = nodes[i];
    		int j = i;
    		while (j * 7 + 11 < 100) {
    			nodes[i].next = nodes[j * 5 + 7];
    			j = j * 5 + 7;
    			nodes[i] = nodes[i].next;
    		}
    	}
    	ListNode result = mergeKSL.mergeKLists(input);
    	while (result != null) {
    		System.out.print(result.val + ",");
    		result = result.next;
    	}
    	*/
    	ListNode n = new ListNode(1);
    	System.out.println(n.toString());
    }
}
