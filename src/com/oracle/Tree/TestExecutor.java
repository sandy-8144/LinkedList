package com.oracle.Tree;

public class TestExecutor {
	
	public static void main(String [] args) {
		Tree t1 = new Tree();
		t1.insert(6);
		t1.insert(2);
		t1.insert(11);
		t1.insert(5);
		t1.insert(10);
		t1.insert(12);
		System.out.println();
		System.out.println("Inorder iterative..");
		t1.inOrderIterative();
		System.out.println();
		System.out.println("Inorder recursive..");
		t1.inOrder();
		System.out.println();
		System.out.println("pre-order iterative..");
		t1.preOrderIterative();
		System.out.println();
		System.out.println("pre-order recursive..");
		t1.preOrderRecursive();
		System.out.println();
		System.out.println("post order iterative..");
		t1.postOrderIterative();
		System.out.println();
		System.out.println("post order recursive..");
		t1.postOrderRecursive();
		
		//t1.delete(2);
		//t1.inOrder();
		System.out.println();
		t1.levelOrderTraversal();
		System.out.println();
		System.out.println("Printing leaf nodes...");
		t1.printLeafNode();
		System.out.println();
		System.out.println("Spiral order traversal....");
		t1.spiralOrderTraversal();
		System.out.println();
		System.out.println("No of node recusrive:"+t1.noOfNodes());
		System.out.println();
		System.out.println("No of nodes iterative:"+t1.noOfNodeInterative());
		System.out.println();
		System.out.println("Height of tree:"+t1.height());
		System.out.println();
		System.out.println("No of leaf node recusrive:"+t1.noOfLeafNodes());
		System.out.println();
		System.out.println("No of leaf nodes iterative:"+t1.noOfLeafNodeInterative());
		
	}

}
