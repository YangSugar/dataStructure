package com.yang;

import list.LinkedList;

public class Queue<E> {
	
	LinkedList<E> list = new LinkedList<>();
	
	public int size() {
		return list.size();
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public void enQueue(E element) {
		list.add(element);
	}
	
	public E deQueue() {
		return list.remove(0);
	}
	
	public E front() {
		return null;
	}
	
	public void clear() {
		list.clear();
	}
	
	
}
