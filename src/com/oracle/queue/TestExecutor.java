package com.oracle.queue;

public class TestExecutor {

	public static void main(String [] args) {
		
		QueueFromStacks queue = new QueueFromStacks();
		queue.enqueue(4);
		queue.enqueue(5);
		queue.enqueue(1);
		queue.enqueue(8);
		System.out.println("dequeue:"+queue.dequeue());
		System.out.println("dequeue:"+queue.dequeue());
		queue.enqueue(9);
		System.out.println("dequeue:"+queue.dequeue());
		System.out.println("dequeue:"+queue.dequeue());
		System.out.println("dequeue:"+queue.dequeue());
		queue.enqueue(10);
		queue.enqueue(12);
		System.out.println("dequeue:"+queue.dequeue());
	}
}
