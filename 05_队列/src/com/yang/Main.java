package com.yang;

import stack.StackQueue;

public class Main {

	public static void main(String[] args) {
		testStackQueue2();
	}
	
	
	static void testStackQueue2() {
		com.yang.StackQueue<Integer> stackQueue = new com.yang.StackQueue<>();
		stackQueue.push(1);
		stackQueue.push(2);
		stackQueue.push(3);
		
		while (!stackQueue.empty()) {
			System.out.println(stackQueue.pop());
		}
	}
	
	
	static void testCircleDequeue() {
		CircleDequeue<Integer> queue = new CircleDequeue<>();
		
		// 5 4 3 2 1 100 101 102 103 104 105 106 8 7 6 
		// 8 7 6 5 4 3 2 1 100 101 102 103 104 105 106 107 108 109 null null 10 9
		
		for (int i = 0; i < 10; i++) {
			queue.enQueueFront(i + 1);
			queue.enQueueRear(i + 100);
		}
		
		// 11 7 6 5 4 3 2 1 100 101 102 103 104 105 106 null null null null null null 12
		for (int i = 0; i < 3; i++) {
			queue.deQueueFront();
			queue.deQueueRear();
		}

		queue.enQueueFront(11);
		queue.enQueueFront(12);
		
		System.out.println(queue);
		
		while (!queue.isEmpty()) {
			System.out.println(queue.deQueueRear());
		}
		
	}
	
	
	
	// 实现一个循环队列
	static void testCircleQueue() {
		
		CircleQueue<Integer> queue = new CircleQueue<Integer>();
		// 0 1 2 3 4 5 6 7 8 9
		for (int i = 0; i < 10; i++) {
			queue.enQueue(i);
		}
		// null null null null null 5 6 7 8 9
		for (int i = 0; i < 5; i++) {
			queue.deQueue();
		}
		// 15 16 17 18 19 5 6 7 8 9
		for (int i = 15; i < 23; i++) {
			queue.enQueue(i);
		}
	
//		while (!queue.isEmpty()) {
//			System.out.println(queue.deQueue());
//		}

		System.out.println(queue);
	}
	
	
	
	
	
	
	
	//实现一个双向队列
	static void testDequeue() {
		DeQueue<Integer> deQueue = new DeQueue<>();
		deQueue.enQueueFront(1);
		deQueue.enQueueFront(2);
		deQueue.enQueueRear(3);
		deQueue.enQueueRear(4);
		
		while (!deQueue.isEmpty()) {
			// 2 1 3 4
			System.out.println(deQueue.deQueueFront());
		}
	}
	

	// 测试 栈实现队列
	static void testStackQueue() {
		
		StackQueue<Integer> stackQueue = new StackQueue<>();
		
		stackQueue.enQueue(1);
		stackQueue.enQueue(2);
		stackQueue.enQueue(3);
		stackQueue.enQueue(4);
		stackQueue.deQueue();
		stackQueue.deQueue();
		stackQueue.deQueue();
		stackQueue.deQueue();
		
		System.out.println(stackQueue.deQueue());
		System.out.println(stackQueue.front());
		System.out.println(stackQueue.isEmpty());
			
		while (!stackQueue.isEmpty()) {
			System.out.println(stackQueue.deQueue());
		}
	}

}
