package stack;

import java.util.Stack;

public class StackQueue<E> {
	private int size;
	private Stack<E> inStack = new Stack<>();
	private Stack<E> outStack = new Stack<>();
	
	public int size() {
		return size;
	}

	public boolean isEmpty() {
		if (size == 0) return true; 
		return false;
	}

	// 入队
	public void enQueue(E element) {
		inStack.push(element);
		size++;
	}
	
	// 出队
	public E deQueue() {
		if (inStack.isEmpty() && outStack.isEmpty()) {
			return null;
		}
		size--;
		checkOutStack();
		return outStack.pop();
	}
	
	// 队头
	public E front() {
		if (inStack.isEmpty() && outStack.isEmpty()) return null;
		checkOutStack();
		return outStack.peek();
	}

	public void clear() {
		size = 0;
		inStack = null;
		outStack = null;
	}
	
	private void checkOutStack() {
		if (outStack.isEmpty()) {
			while (!inStack.isEmpty()) {
				 E element = inStack.pop();
				 outStack.push(element);
			}
		}
	}
}
