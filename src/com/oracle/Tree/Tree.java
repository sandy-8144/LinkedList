package com.oracle.Tree;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

import com.oracle.list.SingleLinkedList;

public class Tree {

	private Node root;
	private static int maxSum= Integer.MIN_VALUE;
	private static int countX=0;
	private static int even, odd;
	private static int diameter;
	
	private static class Node {
		
		int data;
		Node left;
		Node right;
		
		Node (int data){
			this.data=data;
			this.left=null;
			this.right=null;
		}
		@Override
		public String toString() {
			return new Integer(data).toString();
		}
		
	}
	
	public Tree()
	{
		
	}
	
	public Tree(Node root)
	{
		this.root=root;
	}
	
	public Node getRoot()
	{
		return root;
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
	
	
	public void rightView() {
		Node temp = this.root;
		
		if(temp==null)
			System.out.println("Empty tree...");
		LinkedList<HD> queue = new LinkedList<HD>();
		queue.add(new HD(temp,0));
		TreeMap<Integer,Node> sortedMap = new TreeMap<Integer,Node>();
		int level=0;
		while(!queue.isEmpty())
		{
			int counter = queue.size();
			level++;
			while(counter > 0) {
				
				HD node = queue.poll();
				sortedMap.put(node.distance, node.getNode());
				if(node.getNode().left!=null)
					queue.add(new HD(node.getNode().left,level));
				if(node.getNode().right!=null)
					queue.add(new HD(node.getNode().right,level));
				counter--;
			}
			
			
		}
		System.out.println(sortedMap);
		for(Integer m : sortedMap.keySet()) {
			System.out.print(sortedMap.get(m).data+",");
		}
		
	}
	
	public static boolean isIdentical(Node root1, Node root2)
	{
		// Complexity is O(n)
		
		if(root1==null && root2==null)
			return true;
		if(root1==null || root2==null)
			return false;
		if(root1.data!=root2.data)
			return false;
		
		/*boolean isLeftIdentical = isIdentical(root1.left,root2.left);
		boolean isRightIdentical=isIdentical(root1.right,root2.right);
		
		return isLeftIdentical&&isRightIdentical;*/
		
		return  isIdentical(root1.left,root2.left) && isIdentical(root1.right,root2.right);
	}
	
	public static boolean isIdenticalIterative(Node root1, Node root2) {
		
		if(root1==null && root2==null)
			return true;
		if(root1==null || root2==null)
			return false;
		if(root1.data!=root2.data)
			return false;
		Queue<Node>queue1 = new LinkedList<Node>();
		Queue<Node>queue2 = new LinkedList<Node>();
		queue1.add(root1);
		queue2.add(root2);
		
		while(!queue1.isEmpty()&& !queue2.isEmpty())
		{
		     Node node1= queue1.poll();
		     Node node2 = queue2.poll();
		     if(node1.data!=node2.data)
		    	 return false;
			if(node1.left!=null)
				queue1.add(node1.left);
			if(node1.right!=null)
				queue1.add(node1.right);
			if(node2.left!=null)
				queue2.add(node2.left);
			if(node2.right!=null)
				queue2.add(node2.right);
			
			
			
		}
		
		if(!queue1.isEmpty() || !queue2.isEmpty())
			return false;
		return true;
	}
	
	public void verticalSum() {
		// TC O(nlogn) --> due to treemap. SC O(n)
		
		Node temp = this.root;
		
		if(temp==null)
			System.out.println("Empty tree...");
		LinkedList<HD> queue = new LinkedList<HD>();
		queue.add(new HD(temp,0));
		TreeMap<Integer,Integer> sortedMap = new TreeMap<Integer,Integer>();
		while(!queue.isEmpty())
		{
			HD node = queue.poll();
			int distance = 0;
			if(sortedMap.containsKey(node.distance)) {
				distance = sortedMap.get(node.distance)+node.getNode().data;
				sortedMap.put(node.distance,distance);
			}else {
				
				
				sortedMap.put(node.distance,node.getNode().data);
			
			}
			if(node.getNode().left!=null)
				queue.add(new HD(node.getNode().left,node.getDistance()-1));
			if(node.getNode().right!=null)
				queue.add(new HD(node.getNode().right,node.getDistance()+1));			
			
		}
		//System.out.println("Map:"+sortedMap);
		for(Integer m : sortedMap.keySet()) {
			
			System.out.print(sortedMap.get(m)+",");
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
	
	
	
	public void extremCornerAlternate() {
		Node root = this.root;
		if(root==null)
			return;
		Queue<Node> q = new LinkedList<Node>();
		Map<Integer,Node> sortedMap = new TreeMap<Integer,Node>();
		q.add(root);
		int level=0;
		
		while(!q.isEmpty()) {
			
			int counter = q.size();
			level++;
			
			while(counter > 0) {
				
				Node node = q.poll();
				
				if(level%2==0) {
					if(!sortedMap.containsKey(level))
					   sortedMap.put(level, node);									
				}else {
					sortedMap.put(level, node);	
				}
				
				if(node.left!=null)
					q.add(node.left);
				if(node.right!=null)
					q.add(node.right);
				
				counter--;
				
			}
			
			
		}
		
		for(Integer m : sortedMap.keySet())
			System.out.print(sortedMap.get(m).data+",");
		
	}
	public void levelOrderTraversalRecursion() {
		Node root = this.root;
		
		// O(n^2)
		int height = height(root);
		
		for(int i =1 ; i<=height;i++)
			// worst case if tree is skewed then height =n , and printLevel will be n ==> n^2
			printLevel(root,i);
		
	}
	
	
	private void printLevel(Node n , int i)
	{
		
		// base conditions
		if(n==null)
			return;
		if(i==1) {
			System.out.print(n.data+",");
			return;
		}
		
		printLevel(n.left, i-1);
		printLevel(n.right,i-1);
		
		
		
	}
	
	
	
	public boolean isMirrorRecursive(Node n1 , Node n2) {
		
		if(n1==null && n2==null)
			return true;
		if(n1==null || n2==null)
			return false;
		
		return n1.data==n2.data && isMirrorRecursive(n1.left,n2.right) && isMirrorRecursive(n1.right,n2.left);
	}
	
	public boolean isMirror(Node n1, Node n2)
	{
	  // TC O(n), SC O(n)
		if(n1==null && n2==null)
			return true;
		if(n1==null || n2==null)
			return false;
		
		Queue<Node> q1 = new LinkedList<Node>();
		Queue<Node> q2 = new LinkedList<Node>();
		
		q1.add(n1);
		q2.add(n2);
		while(!q1.isEmpty() && !q2.isEmpty()) {
			Node t1 = q1.poll();
			Node t2 = q2.poll();
			
			if(t1.data!=t2.data)
				return false;
			if(t1.left!=null)
				q1.add(t1.left);
			if(t1.right!=null)
				q1.add(t1.right);
			Node temp = t2.left;
			t2.left=t2.right;
			t2.right=temp;
			
			if(t2.left!=null)
				q2.add(t2.left);
			if(t2.right!=null)
				q2.add(t2.right);
			
		}
		
		if(!q1.isEmpty() || !q2.isEmpty())
			return false;
		
		return true;
		
		
	}
	
	public Tree mirror() {
		// TC: O(n), SC: (n)
		Node root = mirror(this.root);
		return new Tree(root);
	}
	
	private Node mirror(Node node) {
		
		
		if(node==null)
			return null;
		Node left = mirror(node.left);
		Node right = mirror(node.right);
		
		node.left = left;
		node.right=right;
		return node;
		
		
	}
	
	
	public int diameterNew()
	{
		heightNew(this.root);
		return diameter;
	}
	
	private int heightNew(Node n )
	{
		if(n==null)
			return 0;
		
		int lh = heightNew(n.left);
		int lr = heightNew(n.right);
		diameter = Math.max(diameter, lh+lr+1);
		
		return Math.max(lh, lr)+1;
		
		
		
	}
	public int diameter() {
		// TC: O(n^2)
		return diameter(this.root);
	}
	
	private int diameter(Node root) {
		
		// base condition
		if(root==null)
			return 0;
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		
		int leftDia = diameter(root.left);
		int rightDia = diameter(root.right);
		
		return ( Math.max(leftHeight+rightHeight+1, Math.max(leftDia, rightDia)));
		
		
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
		// TC O(n) --- traversing each node once, SC : O(n)
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
	
	
	
	
	public void connectsNodeAtSameLevel()
	{
		Node root = this.root;
		if(root==null)
			return ;
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		
		
		while(!q.isEmpty())
		{
			int counter = q.size();
			Node prev = null;
			
			while(counter > 0) {
				Node n = q.poll();
				if(prev!=null)
					prev.right = n;  // prev.nextRight--> Node
				
				if(n.left!=null)
					q.add(n.left);
				if(n.right!=null)
					q.add(n.right);
				
				
				counter--;
			}
			
		}
		
	}
	public void diagonalOrderTraversal() {
		Node root = this.root;
		if(root==null)
			return;
		Queue<HD> q = new LinkedList<HD>();
		Map<Integer,List<Node>> sortedMap = new TreeMap<Integer,List<Node>>();
		q.add(new HD(root,0));
		
		while(!q.isEmpty())
		{
			HD hd = q.poll();
			
			if(sortedMap.containsKey(hd.distance)) {
				
				sortedMap.get(hd.distance).add(hd.getNode());
			}else {
				List<Node> list = new ArrayList<Node>();
				list.add(hd.getNode());
				sortedMap.put(hd.distance, list);
			}
			
			if(hd.getNode().left!=null)
				q.add(new HD(hd.getNode().left, hd.distance+1));
			if(hd.getNode().right!=null)
				q.add(new HD(hd.getNode().right, hd.distance));
			
		}
		
		System.out.println(sortedMap);
		
		for(Integer m : sortedMap.keySet()) {
			List<Node> list =sortedMap.get(m);
			for(Node n : list)
				System.out.print(n.data+",");
			System.out.println();
		
	}
	}
	
	
	
	public void bottomView() {
		Node root = this.root;
		if(root==null)
			return;
		Queue<HD> q = new LinkedList<HD>();
		Map<Integer,Node> sortedMap = new TreeMap<Integer,Node>();
		q.add(new HD(root,0));
		
		while(!q.isEmpty())
		{
			HD hd = q.poll();
			
			
				sortedMap.put(hd.distance, hd.node);
			
			
			if(hd.node.left!=null)
				q.add(new HD(hd.node.left, hd.distance-1));
			if(hd.getNode().right!=null)
				q.add(new HD(hd.node.right, hd.distance+1));
			
		}
		
		System.out.println(sortedMap);
		
		for(Integer m : sortedMap.keySet()) {			
				System.out.print(sortedMap.get(m).data+",");
			
		
	}
	}
	
	public static Tree createTreeFromList(SingleLinkedList list) {
		
		SingleLinkedList.Node head = list.getHead();
		Node root =new Node(head.data);
		
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.add(root);
		
		head = head.next;
		while(head!=null) {
			
			Node parent = queue.poll();
			Node left = new Node(head.data);
			queue.add(left);
			Node right=null;
			head= head.next;
			if(head!=null)
			{
				right = new Node(head.data);
				queue.add(right);
				head=head.next;
			}
			
			parent.left=left;
			parent.right=right;
		}
		
		
		
		return new Tree(root);
	}
	
	public void constructTreeUsingLevelOrder( int [] a ) {
		// not completed
		int length = a.length;
		Node root=null;
		for(int i=0;i<2*i+2 ; i++)
		{
			root = new Node(a[i]);
			root.left = new Node(a[2*i+1]);
			root.right= new Node(a[2*i+2]);
		}
		
		
	}
	
	public int sumOfRightLeafNodes()
	{
		
		// O(n)
		return sumOfRightLeafNode(this.root);
		
	}
	
	private int sumOfRightLeafNode(Node n) {
		
		if(n==null)
			return 0;
		if(n.right!=null && n.right.left==null && n.right.right==null)
			return n.right.data;
		
		return sumOfRightLeafNode(n.left) + sumOfRightLeafNode(n.right);
		
	}
	
	public int findMaxSumOfSubTree() {
		
		/*
		 * Time Complexity: O(n), where n is number of nodes.
           Auxiliary Space: O(n), function call stack size.
		 * 
		 */
		findMaxSumOfSubTree(this.root,maxSum);
		return maxSum;
	}
	
	private int findMaxSumOfSubTree(Node node, int sum) {
		
		if(node==null)
			return 0;
		
		int count = node.data+findMaxSumOfSubTree(node.left,sum)+findMaxSumOfSubTree(node.right,sum);
		maxSum = Math.max(maxSum, count);
		
		return count;
		
	}
	
	
	public boolean hasPathFromRootToLeaf(int sum) {
		//TC: O(n)
		return hasPathFromRootToLeaf(this.root,sum);
	}
	
	
	public void printKDistanceFromRoot(int distance) {
		// TC O(n). as we are traversing all elements
		Node temp = this.root;
		if(temp==null)
			return;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(temp);
		int level=0;
		while(!queue.isEmpty()) {
			int counter = queue.size();
			
			while(counter > 0)
			{
				Node node = queue.poll();
				if(level==distance)
					System.out.print(node.data+",");
					
				if(node.left!=null)
					queue.add(node.left);
				if(node.right!=null)
					queue.add(node.right);
				counter--;
				
				
				
			}
			
			level++;
			
			
		}
		
		
	}
	private boolean hasPathFromRootToLeaf(Node root , int sum) {
		
		if(root ==null)
			return sum==0;
		
	   sum = sum-root.data;
	   if(sum==0 && root.left==null && root.right==null)
		   return true;
	   
	   boolean isLeftTreeHasPath = hasPathFromRootToLeaf(root.left,sum);
	   boolean isRightTreeHasPath = hasPathFromRootToLeaf(root.right,sum);
	   
	   return isLeftTreeHasPath||isRightTreeHasPath;
		
	}
	
	
	public void printPathFromRootIterative() {
		Node root = this.root;
		if(root==null)
		  return ;
		
		Queue<Node> q = new LinkedList<Node>();
		Map<Node,Node> parentMap = new HashMap<Node,Node>();
		q.add(root);
		parentMap.put(root, null);
		
		while(!q.isEmpty()) {
			
			Node n = q.poll();
			
			if(n.left==null && n.right==null)
			{
				printPath(n,parentMap);
			}
			
			if(n.left!=null)
			{
				q.add(n.left);
				parentMap.put(n.left, n);
			}
			
			if(n.right!=null)
			{
				q.add(n.right);
				parentMap.put(n.right, n);
			}
			
		}
		
		
		
	}
	
	
	public void printPath(Node node , Map<Node,Node> parentMap) {
		
	  LinkedList<Node> stack = new LinkedList<Node>();
	  Node temp=node;
	  
	  while(temp!=null) {
		  stack.push(temp);
		  temp = parentMap.get(temp);		  		  
	  }
	  
	  while(!stack.isEmpty())
	  {
		  System.out.print(stack.pop()+",");
	  }
	  
	  System.out.println();
		
	}
	public void printPathFromRoot() {
		LinkedList<Node> list = new LinkedList<Node>();
		printPathFromRoot(this.root,list);
		
	}
	
	private void printPathFromRoot(Node n , LinkedList<Node> list) {
		
		if(n==null)
			return;
		list.add(n);
		if(n.left==null && n.right==null)
		{
			for(Node p : list)
				   System.out.print(p.data+",");
			System.out.println();
		}
		
		printPathFromRoot(n.left,list);
		   printPathFromRoot(n.right,list);
		list.removeLast();
	}
	
	public void printPathFromRoot(int sum) {
		//TC: O(n)
		LinkedList<Node> stack = new LinkedList<Node>();
		printPathFromRoot(this.root,sum,stack);
	}
	
	private void printPathFromRoot(Node root , int sum, LinkedList<Node> list) {
		
		if(root ==null)
			return ;
		
	   sum = sum-root.data;
	   list.add(root);
	   if(sum==0 ) {
		   
		   for(Node n : list)
			   System.out.println(n.data);
		   
	   }
		   
	   
	   printPathFromRoot(root.left,sum,list);
	   printPathFromRoot(root.right,sum,list);
	   
	   list.removeLast();
		
	}
	
	public int countSubtreeWithSumX( int x) {
		countSubtreeWithSumX(this.root,x );
		return countX;
		
	}
	
	private int countSubtreeWithSumX( Node n , int x ) {
		
		if(n == null)
			return 0;
		
		int ls = countSubtreeWithSumX(n.left,x);
		int rs = countSubtreeWithSumX(n.right,x);
		int sum = ls+rs+n.data;
		if(sum == x)
			countX++;
		return sum;
	}
	
	
	
	public int sumOfBinaryTree()
	{
		
		// O(n)
		return sumOfBinaryTree(this.root);
		
	}
	
	private int sumOfBinaryTree(Node n) {
		
		if(n==null)
			return 0;
		
		
		return sumOfBinaryTree(n.left) + sumOfBinaryTree(n.right)+n.data;
		
	}
	
	public int sumOfLeafNodes()
	{
		
		// O(n)
		return sumOfLeafNode(this.root);
		
	}
	
	private int sumOfLeafNode(Node n) {
		
		if(n==null)
			return 0;
		if(n.left==null && n.right==null)
			return n.data;
		
		return sumOfLeafNode(n.left) + sumOfLeafNode(n.right);
		
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
				
			System.out.print(node.data);
			System.out.print(",");
			
				if(node.left!=null)
					queue.add(node.left);
				if(node.right!=null)
					queue.add(node.right);
								
				counter--;
			}
				System.out.println();
				
			
			
			
			
		}
		
	}
	
	
	public int oddEvenlevelSumDiffIterative() {
		// printing difference of sum between nodes are odd and even level
		Node temp = this.root;
		System.out.println("Level order traversal..");
		
		if(temp==null) {
			System.out.println("Empty tree...");
			return 0;
		}
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.add(temp);
		int odd=0, even =0, level = 0;
		while(!queue.isEmpty()) {
			
			int counter = queue.size();
			level++;
			
			while(counter > 0)	{
			Node node = queue.poll();
				
			if(level%2==0)
				even  = even+node.data;
			else
				odd  = odd+node.data;
				
			
				if(node.left!=null)
					queue.add(node.left);
				if(node.right!=null)
					queue.add(node.right);
								
				counter--;
			}
				
		}
		
		return odd-even;
		
	}

	public Tree cloneTree() {
		
		// TC: o(n), SC: O(n)
		return new Tree (cloneTree(this.root, null));
	}
	
	private Node cloneTree(Node root, Node temp) {
		
		if(root ==null)
			return null;
		
		temp = new Node(root.data);
		if(root.right==null && root.left==null)
			return temp;
		
		temp.left = cloneTree(root.left,temp.left);
		temp.right = cloneTree(root.right,temp.right);
		
		return temp;
		
		
	}
	public int maxLevelSum() {
		// O(n),O(n)
		Node temp = this.root;
		System.out.println("Level order traversal..");
		int maxSum=Integer.MIN_VALUE;
		
		if(temp==null) {
			System.out.println("Empty tree...");
			return 0;
		}
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.add(temp);
		
		while(!queue.isEmpty()) {
			
			int counter = queue.size();
			
			int levelSum=0;
			
			while(counter > 0)	{
			Node node = queue.poll();
				
			levelSum = levelSum+node.data;
				
			
				if(node.left!=null)
					queue.add(node.left);
				if(node.right!=null)
					queue.add(node.right);
								
				counter--;
			}
				
			maxSum = Math.max(maxSum, levelSum);
		}
		
		return maxSum;
		
	}
	
	/*
	 *  pre[] = {10, 30, 20, 5, 15},  preLN[] = {'N', 'N', 'L', 'L', 'L'}
	 *  
	 * Pair constructTreeFromPreOrder(int pre[], char preLN[], int i) {
        Node root = new Node(pre[i]);
        int lastIndex = i;
        if(preLN[i] == 'N') {
            // recurse
            Pair leftPair = constructTree(pre, preLN, i+1);
            root.left = leftPair.getKey();
        
            Pair rightPair = constructTree(pre, preLN, leftPair.getValue()+1);
            root.right = rightPair.getKey();
            
            lastIndex = rightPair.getValue();
        }
        return new Pair(root, lastIndex);
    }
	 * 
	 * 
	 * 
	 */
	
	public int oddEvenlevelSumDiffRecursive() {
		odd=0;even=0;
		oddEvenlevelSumDiffRecursive(this.root,1);
		return odd-even;
	}
	
	private void oddEvenlevelSumDiffRecursive(Node n, int level) {
		
		
		if(n==null)
			return ;
		
		if(level%2==0)
			even = even+n.data;
		else
			odd = odd+n.data;
			
		
		oddEvenlevelSumDiffRecursive(n.left, level+1);
		oddEvenlevelSumDiffRecursive(n.right, level+1);
		
		
		
		
		
	}
	
	
	
	
	
	
	public void printAllLeafNodeFromLeftToRight() {
		Node temp = this.root;
		
		if(temp==null) {
			System.out.println("Empty tree...");
			return;
		}
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.add(temp);
		
		while(!queue.isEmpty()) {
			
			
			Node node = queue.poll();
				if(node.left==null && node.right==null)
				{
					System.out.print(node.data);
					System.out.print(",");
				}
				
				if(node.left!=null)
					queue.add(node.left);
				if(node.right!=null)
					queue.add(node.right);
				
				
			}
				System.out.println();
				
			
			
			
			
		}
		
	}

