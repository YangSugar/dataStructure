package list;


@SuppressWarnings("unchecked")
public class ArrayList<E> extends AbstractList<E> {
	// 所有的元素
	private E[] elements;
	private static final int DEFAULT_CAPACITY = 10;
	

	public ArrayList(int capaticy) {
		capaticy = (capaticy < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capaticy;
		elements = (E[]) new Object[capaticy];
	}
	
	public ArrayList() {
		this(DEFAULT_CAPACITY);
	}
	
	// 清除所有元素
	public void clear() {
		for (int i = 0; i < size; i++) {
			elements[i] = null;
		}
		size = 0;
	}
	
	// 元素的数量
	public int size() {
		return size;
	}
	
	// 是否包含某个元素
	public boolean contains(E element) {
	 	return indexOf(element) != ELEMENT_NOT_FOUND;
	}
	
	// 获取index位置的元素
	public E get(int index) {
		rangeCheck(index);
		return elements[index];
	}
	
	// 设置index位置的元素
	public E set(int index, E element) {
		rangeCheck(index);
		E old = elements[index];
		elements[index] = element;
		return old;
	}
	
	// 查看元素的索引
	public int indexOf(E element) {
		if (element == null) {
			for (int i = 0; i < size; i++) {
				if (element == null) return i;
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (elements[i].equals(element)) return i;
			}
		}
		return ELEMENT_NOT_FOUND;
	}
	
	// 添加元素到尾部
	public void add(E element) {
//		elements[size] = element;
//		size++;
		add(size, element);
	}
	
	// 在index位置插入一个元素
	public void add(int index, E element) {
		// 安全检查
		// 等于size也可以插入 意味着插入最后
		rangeCheckForAdd(index);
		// 扩容
		ensureCapacity(size + 1);
		
		for (int i = size - 1; i >= index; i--) {
			elements[i + 1] = elements[i];
		}
		elements[index] = element;
		size++;
	}
	
	// 删除index位置的元素
	public E remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index" + index + ", Size:" + size);
		}
		
		E old = elements[index];
		
//		// 我的写法
//		for (int i = index; i < size; i++) {
//			if (i != size - 1) {
//				elements[i] = elements[i + 1];
//			}
//		}
		
		for (int i = index + 1; i < size; i++) {
			elements[i - 1] = elements[i]; 
		}
		
		size--;
		return old;
	}
	
	@Override
	public String toString() {
		// // size=3, [99, 88, 77]
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("size=").append(size).append(", [");
		for (int i = 0; i < size; i++) {
			if (i != 0) {
				stringBuffer.append(",");
			}
			stringBuffer.append(elements[i]);
		}
		stringBuffer.append("]");
		return stringBuffer.toString();
	}
	
	// 保证要有capacity的容量
	private void ensureCapacity(int capacity) {
		int oldCapacity = elements.length;
		if (oldCapacity >= capacity) return;
		
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		E[] newElements = (E[]) new Object[newCapacity];
		
		for (int i = 0; i < size; i++) {
			newElements[i] = elements[i];
		}
		elements = newElements;
		
		System.out.println(oldCapacity + "扩容为" + newCapacity);
	}
	
	
	
}
