package com.oracle.list;

import com.oracle.stack.Stack;

public class TestExecutor {

	public static void main(String [] args) {
		SingleLinkedList slist = new SingleLinkedList();
		slist.add(1);
		slist.add(2);
		slist.add(2);
		slist.add(4);	
		slist.add(5);
		slist.add(6);
		slist.add(6);
		slist.add(7);
		slist.add(12);
		slist.add(15);
		/*System.out.println(slist);	
		slist.reverseList();
		System.out.println(slist);
		slist.delete(10);		
		System.out.println(slist);
		slist.delete(5);
		System.out.println(slist);
		slist.delete(1);
		System.out.println(slist);*/
		System.out.println(slist);
		slist.removeDuplicates();
		System.out.println(slist);
		slist.addInSortedList(11);
		slist.addInSortedList(16);
		System.out.println(slist);
		System.out.println(slist.getMiddle());
		
		SingleLinkedList slist1 = new SingleLinkedList();
		slist.add(1);
		slist.add(3);
		slist.add(7);
		slist.add(2);
		
		SingleLinkedList slist2 = new SingleLinkedList();
		slist.add(1);
		slist.add(3);
		slist.add(7);
		slist.add(2);
		
		System.out.println("l-1&l-2"+slist1.compareList(slist2.getHead()));
		System.out.println("l-1&l"+slist1.compareList(slist.getHead()));
		
		
		
		
		
		
		DoubleLinkedList dlist = new DoubleLinkedList();
		dlist.add(6);
		dlist.add(13);
		dlist.add(9);
		dlist.add(1);
		System.out.println(dlist);
		dlist.delete(13);
		System.out.println(dlist);
		System.out.println(dlist.traverserList());
		
		
		
		
		
	}
}
