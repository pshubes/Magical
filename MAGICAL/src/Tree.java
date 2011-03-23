
public class Tree {
	
	private Node root;
	private Tree next;
	private Tree prev;
	private int treeSize;
	
	//GETTERS and SETTERS
	public Node getRoot() {
		return root;
	}
	public void setRoot(Node root) {
		this.root = root;
	}
	public Tree getNext() {
		return next;
	}
	public void setNext(Tree next) {
		this.next = next;
	}
	public Tree getPrev() {
		return prev;
	}
	public void setPrev(Tree prev) {
		this.prev = prev;
	}
	
	//CONSTRUCTORS
	public Tree(){
		root = null;
		prev = null;
		next = null;
		treeSize = 0;
	}

	public Tree(Node theRoot){
		root = theRoot;
		treeSize = 1;
		prev = null;
		next = null;
	}
	
	//METHODS
	
	//Initialize all values in a tree based on its root node
	public void initialize(){
		
		//First generation
		root.setTreeIndex(0);
		Node firstGen1 = new Node(root.getType(), 1);
		Node firstGen2 = new Node(root.getType(), 2);
		firstGen1.setParent(root);
		firstGen2.setParent(root);
		root.addChild(firstGen1);
		root.addChild(firstGen2);
		
		//Second generation
		Node secondGen1 = new Node(root.getType(), 3);
		Node secondGen2 = new Node(root.getType(), 4);
		secondGen1.setParent(firstGen1);
		secondGen2.setParent(firstGen1);
		firstGen1.addChild(secondGen1);
		firstGen1.addChild(secondGen2);
		
		//"Evidence" generation
		Node evidence11 = new Node(root.getType(), 8);
		Node evidence12 = new Node(root.getType(), 9);
		Node evidence13 = new Node(root.getType(), 10);
		evidence11.setParent(secondGen1);
		evidence12.setParent(secondGen1);
		evidence13.setParent(secondGen1);
		secondGen1.addChild(evidence11);
		secondGen1.addChild(evidence12);
		secondGen1.addChild(evidence13);
		
		Node evidence21 = new Node(root.getType(), 11);
		Node evidence22 = new Node(root.getType(), 12);
		Node evidence23 = new Node(root.getType(), 13);
		evidence21.setParent(secondGen2);
		evidence22.setParent(secondGen2);
		evidence23.setParent(secondGen2);
		secondGen2.addChild(evidence21);
		secondGen2.addChild(evidence22);
		secondGen2.addChild(evidence23);
		
		Node evidence31 = new Node(root.getType(), 5);
		Node evidence32 = new Node(root.getType(), 6);
		Node evidence33 = new Node(root.getType(), 7);
		evidence31.setParent(firstGen2);
		evidence32.setParent(firstGen2);
		evidence33.setParent(firstGen2);
		firstGen2.addChild(evidence31);
		firstGen2.addChild(evidence32);
		firstGen2.addChild(evidence33);
		
		treeSize = 14;
	}
	
	//Get a Node at a given index
	public Node getNode(int index){
		
		//check if index is valid
		if(index >= treeSize){
			System.out.println("Index out of tree bounds");
			return null;
		}
		Node currNode = getNode(root, index);
		
		return currNode;
	}
	
	//recursive function for getNode(int)
	private Node getNode(Node parent, int index){
		//TODO node search is currently depth first. Breadth first may be more efficient
		
		Node currNode = parent;
		//Check if index matches current node
		if(index == parent.getTreeIndex()){
			currNode = parent;
		}
		else{
			//else, check if index matches any children nodes
			for(int i = 0; i<parent.numChildren();i++){
				currNode = getNode(parent.getChildren()[i], index);
				if(currNode.getTreeIndex() == index){
					break;
				}
			}
			
		}
		
		return currNode;
	}
	
	//Propagate a mutation down from a specific node in a tree
	public void propagate(Node curr, State type){
		
		curr.setType(type);
		if(curr.getChildren() == null){
			return;
		}
		
		int i = 0;
		while(curr.getChildren()[i]!=null){
			propagate(curr.getChildren()[i], type);
			i++;
		}
		return;
	}
	
	//Mutate (with probability) a given node in a tree
	public void mutate(Node mutatee){
		
	}
	
	//TODO change print to work for variable tree structures
	public void printTree(){
		Node curr = root;
		System.out.println(curr.getTreeIndex() + ": " + curr.print() + "--> " + curr.getChildren()[0].print() + ", " + curr.getChildren()[1].print());
		curr = root.getChildren()[0];
		System.out.println(curr.getTreeIndex() + ": " + curr.print() + "--> " + curr.getChildren()[0].print() + ", " + curr.getChildren()[1].print());
		curr = root.getChildren()[1];
		System.out.println(curr.getTreeIndex() + ": " + curr.print() + "--> " + curr.getChildren()[0].print() + ", " + curr.getChildren()[1].print() + ", " + curr.getChildren()[2].print());
		curr = root.getChildren()[0].getChildren()[0];
		System.out.println(curr.getTreeIndex() + ": " + curr.print() + "--> " + curr.getChildren()[0].print() + ", " + curr.getChildren()[1].print() + ", " + curr.getChildren()[2].print());
		curr = root.getChildren()[0].getChildren()[1];
		System.out.println(curr.getTreeIndex() + ": " + curr.print() + "--> " + curr.getChildren()[0].print() + ", " + curr.getChildren()[1].print() + ", " + curr.getChildren()[2].print());
		
	}
}
