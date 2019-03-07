package com.oracle.queue;

import com.oracle.stack.Stack;

public class QueueFromStacks {

	private final Stack s1;
	private final Stack s2;
	
	public QueueFromStacks() {
		this.s1= new Stack();
		this.s2= new Stack();
	}
	
	public void enqueue(int data) {
		s1.push(data);
		
	}
	
	public int dequeue () {
		
		if(s2.isEmpty()) {
			while(!s1.isEmpty()) {
				s2.push(s1.pop());
			}
		}
		return s2.pop();
	}
	
}
