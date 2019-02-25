package com.oracle.stack;

public class TestExecutor {

	public static void main(String [] args) {
		
		Stack stack = new Stack();
		stack.push(5);
		stack.push(9);
		stack.push(4);
		stack.push(2);
		System.out.println("Printing Stack.....");
		System.out.println(stack);
		System.out.println("pop:"+stack.pop());
		System.out.println("peek:"+stack.peek());
		System.out.println(stack);
		
		
		StackWithMin minStack = new StackWithMin();
		minStack.push(5);
		minStack.push(9);
		minStack.push(4);
		minStack.push(2);
		System.out.println("Printing Stack.....");
		System.out.println(minStack);
		System.out.println("min:"+minStack.min());
		System.out.println("pop:"+minStack.pop());
		System.out.println("min:"+minStack.min());
		System.out.println(minStack);
		
	}
}
