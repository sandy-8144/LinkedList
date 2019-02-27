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
		System.out.println("Sorted Printing Stack.....");
	//	System.out.println(stack.sortStack());
		System.out.println("pop:"+stack.pop());
		System.out.println("peek:"+stack.peek());
		System.out.println(stack);
		
		Stack stack1 = new Stack();
		stack1.push(5);
		stack1.push(9);
		stack1.push(4);
		stack1.push(2);
		System.out.println("Printing Stack1.....");
		System.out.println(stack1);
		
		Stack stack2 = new Stack();
		stack2.push(1);
		stack2.push(9);
		stack2.push(8);
		stack2.push(11);
		stack2.push(2);
		stack2.push(2);
		System.out.println("Printing Stack2.....");
		System.out.println(stack2);
		stack1= stack1.sortStack();
		System.out.println(stack1);
		stack2= stack2.sortStack();
		System.out.println(stack2);
		System.out.println("Sorted merge:"+stack1.sortedMerge(stack2));
		
		
		
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
