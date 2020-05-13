package com.yang;

import java.util.LinkedList;

// 栈是一种 后进先出（last in - first out， LIFO）的数据结构
// 队列中元素只能从 后端（rear）入队（push），然后从 前端（front）端出队（pop）

public class StackQueue<E> {

  	private LinkedList<Integer> inQueue;
  	private LinkedList<Integer> outQueue;
	
	/** Initialize your data structure here. */
    public StackQueue() {
    	inQueue = new LinkedList<>();
    	outQueue = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
    	inQueue.add(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
    	if (outQueue.isEmpty()) {
    		while (!inQueue.isEmpty()) {
    			outQueue.add(inQueue.pop());
			}
    		return outQueue.poll();
		}
    	return outQueue.poll();
    }
    
    /** Get the top element. */
    public int top() {
    	if (outQueue.isEmpty()) {
    		while (!inQueue.isEmpty()) {
    			outQueue.add(inQueue.pop());
			}
    		return outQueue.peek();
		}
    	return outQueue.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
    	return (inQueue.isEmpty() && outQueue.isEmpty());
    }

}
