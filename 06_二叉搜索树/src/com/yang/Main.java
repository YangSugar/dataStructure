package com.yang;

import java.util.Comparator;

import com.yang.files.Files;
import com.yang.printer.BinaryTreeInfo;
import com.yang.printer.BinaryTrees;

public class Main {
	
	public static void main(String[] args) {
		test1();
	}
	
	static void test1() {
		
		Integer data[] = new Integer[] {
//				7, 4, 9, 2, 5, 8, 11, 3, 12, 1
				7, 4, 9
		};

		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		for (int i = 0; i < data.length; i++) {
			bst.add(data[i]);
		}
		
		bst.preOrderTraversal();
	}
	
	
	static void test2() {
		
		Integer data[] = new Integer[] { 
				7, 4, 9, 2, 5, 8, 11, 3, 12, 1
		};
		
		BinarySearchTree<Person> bst = new BinarySearchTree<>(new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.getAge() - o2.getAge();
			} 
		});
		
		for (int i = 0; i < data.length; i++) {
			bst.add(new Person(data[i]));
		}
		
		BinaryTrees.println(bst);
	}
	
	static void test3() {
		
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		
		for (int i = 0; i < 30; i++) {
			bst.add((int)(Math.random() * 100));
		}
		
		BinaryTrees.println(bst);
//		String string = BinaryTrees.printString(bst);
//		Files.writeToFile("", string);
	}
	

}
