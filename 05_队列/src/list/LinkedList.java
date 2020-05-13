package list;


public class LinkedList<E> extends AbstractList<E> {
	private Node<E> first;
	private Node<E> last;
	
	private static class Node<E> {
		E element;
		Node<E> next;
		Node<E> prev;
		
		public Node(Node<E> prev, E element, Node<E> next) {
			this.prev = prev;
			this.element = element;
			this.next = next;
		}
		
		@Override
		protected void finalize() throws Throwable {
			System.out.println("LinkedList finalize");
			super.finalize();
		}
		
		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer();
			if (prev != null) {
				sb.append(prev.element);
			} else {
				sb.append("null");
			}
			sb.append("_").append(element).append("_");
			
			if (next != null) {
				sb.append(next.element);
			} else {
				sb.append("null");
			}
			return sb.toString();
		}
		
	}
	
	@Override
	public void clear() {
		size = 0;
		first = null;
		last = null;
	}

	@Override
	public E get(int index) {
		return node(index).element;
	}
	
	@Override
	public void add(E element) {
		add(size, element);
	}


	@Override
	public E set(int index, E element) {
		
		Node<E> node = node(index);
		E oldE = node.element;
		node.element = element;
		return oldE;
	}

	@Override
	public void add(int index, E element) {

		if (index == size) { // 添加最后一个元素
			Node<E> oldLast = last;
			last = new Node<E>(oldLast, element, null);
			if (oldLast == null) {
				first = last;
			} else {
				oldLast.next = last;
			}
			
		} else {
			Node<E> next = node(index);
			Node<E> prev = next.prev;
			Node<E> node = new Node<E>(prev, element, next);
			
			if (prev == null) { // 插入第一个
				first = node;
			} else {
				prev.next = node;
			}
			next.prev = node;
		}
		size++;
	}

	@Override
	public E remove(int index) {

		Node<E> node = node(index);
		Node<E> prev = node.prev;
		Node<E> next = node.next;
		
		if (prev == null) {
			first = next;
		} else {
			prev.next = next;
		}
	
		if (next == null) {
			last = prev;
		} else {
			next.prev = prev;
		}
		size--;
		return node.element;
	}

	@Override
	public int indexOf(E element) {
		Node<E> node = first;
		if (element == null) {
			for (int i = 0; i < size; i++) {
				if (node.element == null) return i;
				node = node.next;
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (node.element.equals(element)) return i;
				node = node.next;
			}
		}
		return ELEMENT_NOT_FOUND;
	}
	
	
	// 获取index对应的节点对象
		// 如果小于 size >> 1 从头遍历
		// 如果大于 size >> 1 从后遍历
		private Node<E> node(int index) {
			rangeCheck(index);
			
			if (index < (size >> 1)) {
				Node<E> node = first;
				for (int i = 0; i < index; i++) {
					node = node.next;
				}
				return node;
			} else {
				Node<E> node = last;
				for (int i = size - 1; i > index; i--) {
					node = node.prev;
				}
				return node;
			}
		}
		
		@Override
		public String toString() {
			
			StringBuffer sb = new StringBuffer();
			sb.append("size = ").append(size);
			sb.append(" [");
		
			for (int i = 0; i < size; i++) {
				Node<E> node = node(i);
				if (i != 0) {
					sb.append(", ");	
				}
				sb.append(node);
			}
			sb.append("]");
			return sb.toString();
		}
}
