package com.oracle.stack;

public class Stack {

	protected Node top;
	
	private static class Node {
		Node next;
		int data;
		
		Node(int data){
			
			this.next=null;
			this.data=data;
		}
		
	}
	
	
	public int pop() {
		if(top==null)
			throw new NullPointerException();
		Node temp = top.next;
		int data = top.data;;
		top = temp;
		return data;
		
		
	}
	
	
	public void push(int data) {
		Node node = new Node(data);
		if(top==null) {
			top = node;
			return;
		}
		
		node.next=top;
		top = node;
		
	}
	
	public boolean isEmpty() {
		return top==null;
		
	}
	public int peek() {
		if(isEmpty())
			throw new IllegalStateException();
		return top.data;
	}
	
	public Stack sortStack() {
		
		Stack temp = new Stack();
		
		while(!this.isEmpty()) {
			
			int data = this.pop();
			if(temp.isEmpty()) {
				temp.push(data);
				continue;
			}
			
			while(!temp.isEmpty() && data<temp.peek()) {
				this.push(temp.pop());
				
				
			}
			
			temp.push(data);
						
		}
		
		return temp;
	}
	
	public Stack sortedMerge( Stack b ) {
		
		Stack result = new Stack();
		
		while (!this.isEmpty() && !b.isEmpty()) {
			
			if(this.peek() > b.peek()) {				
				result.push(this.pop());
			}
			else {
				result.push(b.pop());
			}
		}
		
		while(!this.isEmpty()) {
			result.push(this.pop());
		}
		
		while(!b.isEmpty()) {
			result.push(b.pop());
		}
		
		return result;
		
	}
	@Override
	public String toString() {
		
		Node node = this.top;
		StringBuilder sb = new StringBuilder();
		while(node!=null)
		{
			sb.append(node.data);
			sb.append(",");
			node = node.next;
		}
		
		return sb.toString();
	}
}
