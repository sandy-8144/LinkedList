package com.oracle.Tree;

import com.oracle.list.SingleLinkedList;

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
		
		
		SingleLinkedList slist = new SingleLinkedList();
		slist.add(1);
		slist.add(3);
		slist.add(7);
		slist.add(2);
		slist.add(11);
		slist.add(-2);
		slist.add(8);
		slist.add(5);
		
		Tree t2 = Tree.createTreeFromList(slist);
		System.out.println("Level order..");
		t2.levelOrderTraversal();
		System.out.println("In order..");
		t2.inOrderIterative();
		System.out.println("Sum of leaf..."+t2.sumOfLeafNodes());
		
		System.out.println("Sum of right leaves..."+t2.sumOfRightLeafNodes());
		System.out.println("Sum of binary tree..."+t2.sumOfBinaryTree());
		System.out.println("Sum of max sub-tree..."+t2.findMaxSumOfSubTree());
		System.out.println("Count subtree:"+t2.countSubtreeWithSumX(11));
		
		System.out.println("has path:"+t2.hasPathFromRootToLeaf(6));
		t2.printPathFromRoot(6);
		System.out.println("printing leaf node iterative from left to right.");
		t2.printAllLeafNodeFromLeftToRight();// not correct solution
		System.out.println("printing odd-even :"+t2.oddEvenlevelSumDiffIterative());
		System.out.println("printing odd-even recursive:"+t2.oddEvenlevelSumDiffRecursive());
		System.out.println("Max level sum:"+t2.maxLevelSum());
		Tree t3 = t2.cloneTree();
		t3.levelOrderTraversal();
		t3.levelOrderTraversalRecursion();
		t3.printKDistanceFromRoot(2);
		System.out.println("Vertical sum.");
		t3.verticalSum();
		//t3.insert(9);
		System.out.println();
		System.out.println("Is identical:"+Tree.isIdentical(t2.getRoot(), t3.getRoot()));
		System.out.println("Is identical iterative:"+Tree.isIdenticalIterative(t2.getRoot(), t3.getRoot()));
		t3.rightView();
		System.out.println();
		System.out.println("Diameter of tree:"+t3.diameter());
		System.out.println("Diameter of tree new:"+t3.diameterNew());
		System.out.println();
		t3.extremCornerAlternate();
		System.out.println();
		t3.diagonalOrderTraversal();
		System.out.println();
		t3.bottomView();
		System.out.println();
		t3.printPathFromRoot();
		System.out.println();
		t3.printPathFromRootIterative();
		
		t3.levelOrderTraversal();
		System.out.println("convert to sum tree");
		t3.convertToSumTree();
		t3.levelOrderTraversal();
		
		System.out.println();
		
		Tree newtree = Tree.getTree();
		newtree.levelOrderTraversal();
		newtree.printNodesWhichDoesntHaveSibling();
		System.out.println();
		t3.printNodesHavingKLeafs(2);
		

		  int [] pre = {50,40,30,20,35,45,42,48,55,52,60,56,65};
		Tree t4 = Tree.constructBSTUsingPreOrder(pre);
		t4.levelOrderTraversal();
		t4.postOrderRecursive();
		System.out.println();
		System.out.println("in-order bst..");
		t4.inOrder();
		System.out.println();
		
		t4.findLCA(56,48);
		System.out.println();
		t4.postOrderRecursive();
		System.out.println();
		t4.serialize();
		System.out.println();
		Tree t5 = Tree.deSerilize(t4.serialize());
		t5.postOrderIterative();
		System.out.println();
		t3.createBinaryToBST();
		System.out.println();
		t3.postOrderIterative();
		System.out.println();
		t3.inOrder();
		System.out.println();
		t3.levelOrderTraversal();
		System.out.println();
		t3.convertIntoInorderArray();
		
		int sort [] = {20,30,35,40,42,45,48,50,52,55,56,60,65};
		Tree t6 = Tree.createBSTFromAnSortedArray(sort);
		System.out.println();
		t6.levelOrderTraversal();
		System.out.println();
		t6.postOrderIterative();
		System.out.println();
		Tree t7 = Tree.getTree();
		System.out.println(" is sum tree: "+t7.checkIfBinaryTreeIsSumTree());
		
		System.out.println();
		
		t7.mergeTwoBST(Tree.getTree1().getRoot());
		System.out.println();
		t7.levelOrderTraversal();
		
		Tree bst = Tree.getBST();
		bst.successorInBST(15);
		bst.successorInBST(18);
		bst.successorInBST(20);
		bst.preInBST(15);
		bst.preInBST(13);
		bst.preInBST(20);
		
	}

}
