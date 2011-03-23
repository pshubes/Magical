
public class Node {

	private State type;
	private Node parent;
	private Node[] children; //Array of children, order must be kept
	private int treeIndex; //Node index value in tree
	
	public static final int DERIVED = 0; //Designate a derived node
	public static final int EVIDENCE = 1; //Designates an evidence (leaf) node
	
//getters and setters	
	public State getType() {
		return type;
	}
	public void setType(State type) {
		this.type = type;
	}
	public Node getParent() {
		return parent;
	}
	public void setParent(Node parent) {
		this.parent = parent;
	}
	public Node[] getChildren() {
		return children;
	}
	public void setChildren(Node[] children) {
		this.children = children;
	}
	public int getTreeIndex(){
		return treeIndex;
	}
	public void setTreeIndex(int treeIndex){
		this.treeIndex = treeIndex;
	}
	
	//Constructors
	public Node(){
		type = null;
		parent = null;
		children = new Node[2];
	}
	
	public Node(State state){
		type = state;
		parent = null;
		children = new Node[2];
	}
	
	public Node(State state, int index){
		type = state;
		parent = null;
		children = new Node[2];
		treeIndex = index;
	}
	
	//Methods
	public String print(){
		return type.getName();
	}
	
	//return true if the node has children
	public boolean hasChildren(){
		boolean result = false;
		if(getChildren()[0] != null){
			result = true;
		}
		
		return result;
	}
	
	//return number of children
	public int numChildren(){
		int num =0;
		if(!hasChildren()){
			return num;
		}
		else{
			int i = 0;
			while(getChildren()[i] != null){
				i++;
				if(i >= getChildren().length){
					break;
				}
			}
			return i;
		}
	}
	
	//Add child to a node
	public void addChild(Node toAdd){
		
		boolean added = false;
		
		// If there is empty space in the array, add child to the end of array
		for(int i = 0; i<getChildren().length; i++){
			 if(getChildren()[i] == null){
				 getChildren()[i] = toAdd;
				 added = true;
				 break;
			 }
		}
		
		// If array is full, need to allocate more space in array
		if(!added){
			int newSize = getChildren().length + 5;
			Node[] newChildren = new Node[newSize];
			for(int j = 0; j<getChildren().length; j++){
				newChildren[j] = getChildren()[j];
			}
			newChildren[getChildren().length] = toAdd;
			setChildren(newChildren);
			added = true;
		}
		
	}
	
}
