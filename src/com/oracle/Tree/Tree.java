package com.oracle.Tree;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Tree {

	private Node root;
	
	private static class Node {
		
		int data;
		Node left;
		Node right;
		
		Node (int data){
			this.data=data;
			this.left=null;
			this.right=null;
		}
		
		
	}
	
	public void inOrder() {
	
		inorder(root);
		System.out.println();
	}
	
	public void insert(int data) {
		Node newNode = new Node(data);
		
		if(root ==null)
		{
			root=newNode;
			return;
		}
		Node temp = root;
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.add(temp);
		
		while(!queue.isEmpty()) {
			
			temp = queue.poll();
			if(temp.left==null) {
				temp.left=newNode;
				return;
			}
			else
				queue.add(temp.left);
			
			if(temp.right==null) {
				temp.right=newNode;
				return;
			}
			else
				queue.add(temp.right);
			
			
		}
		
	}
	
	public void delete(int data) {
		
		LinkedList <Node>queue = new LinkedList<Node>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			
			Node temp = queue.poll();
			
			if(temp.right!=null)
			{
				if(temp.right.data==data) {
					temp.right=null;
					return;
				}
				else {
					queue.push(temp.right);
				}
					
			}
			
			if(temp.left!=null)
			{
				if(temp.left.data==data) {
					temp.left=null;
					return;
				}
				else {
					queue.push(temp.left);
				}
					
			}
		}
		
		
		
	}
	private void inorder(Node root) {		
		if(root==null)
			return ;
		inorder(root.left);
		System.out.print(root.data+",");
		inorder(root.right);		
	}
	
	
	private static class HD {
		private Node node;
		private int distance;
		
		HD(Node node, int distance)
		{
			this.node=node;
			this.distance=distance;
		}
		
		public int getDistance()
		{
			return distance;
		}
		
		public Node getNode()
		{
			return node;
		}
		
	}
	public void verticalOrderTraversal() {
		Node temp = this.root;
		
		if(temp==null)
			System.out.println("Empty tree...");
		LinkedList<HD> queue = new LinkedList<HD>();
		queue.add(new HD(temp,0));
		TreeMap<Integer,List<Node>> sortedMap = new TreeMap<Integer,List<Node>>();
		while(!queue.isEmpty())
		{
			HD node = queue.poll();
			
			if(sortedMap.containsKey(node.distance)) {
				sortedMap.get(node.distance).add(node.node);
			}else {
				
				List<Node>list = new ArrayList<Node>();
				list.add(node.node);
				sortedMap.put(node.distance,list);
			
			}
			if(node.getNode().left!=null)
				queue.add(new HD(node.getNode().left,node.getDistance()-1));
			if(node.getNode().right!=null)
				queue.add(new HD(node.getNode().right,node.getDistance()-1));			
			
		}
		
		for(Integer m : sortedMap.keySet()) {
			
		}
		
	}
	
	public void preOrderIterative() {
		Node node = this.root;
		if(node ==null) {
			System.out.println("Empty tree...");
			return;
		}
		LinkedList<Node> stack = new LinkedList<Node>();
		
		while(node!=null  || !stack.isEmpty()) {
			
			if(node!=null) {
				System.out.print(node.data+",");				
				stack.push(node);
				node=node.left;
				
			}else {
				node = stack.pop();
				node = node.right;
				
			}
		}
		
	}
	
	public void postOrderIterative() {
		Node node = this.root;
		if(node ==null) {
			System.out.println("Empty tree...");
			return;
		}
		LinkedList<Node> stack = new LinkedList<Node>();
		LinkedList<Node> stack2 = new LinkedList<Node>();
		
		while(node!=null  || !stack.isEmpty()) {
			
			if(node!=null) {
				stack2.push(node); // its pre-order traversal as Node R L . instead of printing , push the element
				stack.push(node);
				node=node.right;
				
			}else {
				node = stack.pop();
				node = node.left;
				
			}
		}
		
		System.out.println("Post order...");
		while(!stack2.isEmpty())
		{
			node = stack2.pop();
			System.out.print(node.data);
			System.out.print(",");
		}
		
	}
	
	
	public void inOrderIterative() {
		Node node = this.root;
		
		if(node ==null) {
			System.out.println("Empty tree...");
			return;
		}
		
		LinkedList<Node> stack = new LinkedList<Node>();
		while(node!=null ||!stack.isEmpty()) {
			
			if(node!=null)
			{
				stack.push(node);
				node = node.left;
			}else {
				node= stack.pop();
				System.out.print(node.data+",");
				node = node.right;
			}
			
		}
		
		
	}
	
	public void preOrderRecursive() {
		
		preOrderRecursive(root);
	}
	
	private void preOrderRecursive(Node n)
	{
		if(n ==null)
			return;
		System.out.print(n.data+",");
		preOrderRecursive(n.left);
		preOrderRecursive(n.right);
	}
	
	
	
	public int noOfNodes() {
		// TC: O(n), SC: O(n) --> due to recursion call stack.
		return noOfNodes(this.root);
	}
	
	private int noOfNodes(Node root) {
		
		if(root==null)
			return 0;
		else {
			return noOfNodes(root.left)+noOfNodes(root.right)+1;
		}
		
	}
	
	
	public int height() {
		
		// TC: O(n), SC: O(n) --> due to recursion call stack.
		return height(this.root);
	}
	private int height(Node root) {
		
		if(root==null)
			return 0;
		return Math.max(height(root.left), height(root.right))+1;
		
	}
	
	public void spiralOrderTraversal() {
		
		Node node = this.root;
		if(root==null)
			return;
		LinkedList<Node> s1 = new LinkedList<Node>();
		LinkedList<Node> s2 = new LinkedList<Node>();
		s1.push(node);
		while(!s1.isEmpty() || !s2.isEmpty()) {
			
			while(!s1.isEmpty())
			{
			   node = s1.pop();
			   System.out.print(node.data+",");
			   if(node.left!=null)
				   s2.push(node.left);
			   if(node.right!=null)
				   s2.push(node.right);
				   
			  
			}
			
			while(!s2.isEmpty())
			{
			   node = s2.pop();
			   System.out.print(node.data+",");
			   if(node.right!=null)
				   s1.push(node.right);
			   if(node.left!=null)
				   s1.push(node.left);
				   
			  
			}
		}
		
	}
	
public void postOrderRecursive() {
		
		postOrderRecursive(root);
	}
	
	private void postOrderRecursive(Node n)
	{
		if(n ==null)
			return;
		
		postOrderRecursive(n.left);
		postOrderRecursive(n.right);
		System.out.print(n.data+",");
	}
	
	
	public void printLeafNode() {
		// TC: O(n)-- as all nodes are traversed, SC: O(n) due to recursion call stack
		
		printLeafNode(this.root);
		
	}
	
	private void printLeafNode(Node root) {
		
		if(root==null)
			return;
		if(root.left==null&&root.right==null)
		{
			System.out.print(root.data+",");
		}else {
			printLeafNode(root.left);
			printLeafNode(root.right);
			
		}
	}
	
	public int noOfNodeInterative() {
		Node node = this.root;
		if(node==null)
			return 0;
		LinkedList<Node> queue = new LinkedList<Node>();
		int count=0;
		queue.add(node);
		while(!queue.isEmpty()) {
			
			node = queue.poll();
			count++;
			
			if(node.left!=null)
				queue.add(node.left);
			
			if(node.right!=null)
				queue.add(node.right);
				
			
		}
		
		return count;
		
	}
	
	
	public int noOfLeafNodeInterative() {
		Node node = this.root;
		if(node==null)
			return 0;
		LinkedList<Node> queue = new LinkedList<Node>();
		int count=0;
		queue.add(node);
		while(!queue.isEmpty()) {
			
			node = queue.poll();
			if(node.left==null && node.right==null)
			    count++;
			
			if(node.left!=null)
				queue.add(node.left);
			
			if(node.right!=null)
				queue.add(node.right);
				
			
		}
		
		return count;
		
	}
	
	public int noOfLeafNodes() {
		// TC: O(n)-- as all nodes are traversed, SC: O(n) due to recursion call stack
		return noOfLeafNodes(this.root);
		
	}
	
	public int noOfLeafNodes(Node root)
	{
		if(root==null)
			return 0;
		if(root.left==null && root.right==null)
			return 1;
		else {
			return noOfLeafNodes(root.left)+noOfLeafNodes(root.right);
		}
		
		
	}
	
	
	public void diagonalOrderTraversal() {
		
		
	}
	
	public void levelOrderTraversal() {
		Node temp = this.root;
		System.out.println("Level order traversal..");
		
		if(temp==null) {
			System.out.println("Empty tree...");
			return;
		}
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.add(temp);
		
		while(!queue.isEmpty()) {
			
			int counter = queue.size();
			while(counter > 0)	{
			Node node = queue.poll();
				
				
				if(node.left!=null)
					queue.add(node.left);
				if(node.right!=null)
					queue.add(node.right);
				
				/*if(counter > 0)
				{
					System.out.print(node.data);
					System.out.print(",");
					counter--;
				}*/
				
				System.out.print(node.data);
				System.out.print(",");
				counter--;
			}
				System.out.println();
				
			
			
			
			
		}
		
	}
}
