package com.yang;

// 使用数组来做
@SuppressWarnings("unchecked")
public class CircleQueue<E> {
	private int size;
	private int front;
	private E[] elements;
	private static final int DEFAULT_CAPACITY = 10;
		
	
	public CircleQueue() {
		elements = (E[]) new Object[DEFAULT_CAPACITY];
	}
	
	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void enQueue(E element) {
		ensureCapacity(size + 1);
		int index = index(size);
		elements[index] = element;
		size++;
	}

	public E deQueue() {
		E frontElement = elements[front];
		elements[front] = null;
		front = index(1);
		size--;
		return frontElement;
	}

	public E front() {
		return elements[front];
	}
	
	
	@Override
	public String toString() {
		
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("size = ").append(size);
		stringBuffer.append(", ");
		stringBuffer.append("front = ").append(front);
		stringBuffer.append(", [");
		for (int i = 0; i < elements.length; i++) {
			if (i != 0) {
				stringBuffer.append(",");
			}
			stringBuffer.append(elements[i]);
		}
		stringBuffer.append("]");
		return stringBuffer.toString();
	}
	
	/**
	 * 保证要有capacity的容量
	 * @param capacity
	 */
	private void ensureCapacity(int capacity) {
		int oldCapacity = elements.length;
		if (oldCapacity >= capacity) return;
			
		// 新容量为旧容量的1.5倍
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		E[] newElements = (E[]) new Object[newCapacity];
		for (int i = 0; i < size; i++) {
			newElements[i] = elements[index(i)];
		}
		elements = newElements;
		front = 0;
	}
	
	
	private int index(int index) {
		return (front + index) % elements.length;
	}
	
}
