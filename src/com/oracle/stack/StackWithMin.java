package com.oracle.stack;

public class StackWithMin extends Stack{

 private Stack minStack;
 
 public StackWithMin() {
	 minStack = new Stack();
 }
 
 @Override
 public void push(int data) {
	 
	 if( data < min())
		 minStack.push(data);
	 super.push(data);
 }
 
 @Override
 public int pop() {
	 
	 int data = super.peek();
	 if(data == min())
		 minStack.pop();
	return super.pop();
	 
 }
 
 public int min() {
	 
	 if(minStack.isEmpty())
		 return Integer.MAX_VALUE;
	 return minStack.peek();
 }
}
