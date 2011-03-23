
public class Sequence {

	private int seqSize;
	private Tree first;
	private Tree last;
	
	//GETTERS and SETTERS
	public int getSeqSize(){
		return seqSize;
	}
	
	//CONSTRUCTORS
	
	//create an empty sequence
	public Sequence(){
		seqSize = 0;
		first = null;
		last = null;
	}
	
	//create a sequence with one element
	public Sequence(Tree root){
		seqSize = 1;
		first = root;
		first.setPrev(null);
		first.setNext(last);
	}
	
	//create a sequence from an array of trees
	public Sequence(Tree[] trees){
		seqSize = trees.length;
		
		for(int i =0; i<(seqSize - 1);i++){
			trees[i].setNext(trees[i+1]);
			trees[i+1].setPrev(trees[i]);
		}
		
		//set the ends of the sequence to null
		first = trees[0];
		first.setPrev(null);
		last = trees[seqSize-1];
		last.setNext(null);
	}
	
	//TODO create insert and remove functions
	
	//METHODS
	
	//print the sequence
	public void printSequence(){
		Tree currTree = first;
		
		while(currTree != null){
			System.out.print(currTree.getRoot().print());
			currTree = currTree.getNext();
		}
		System.out.println();
	}
	
	//return a tree at a specific index
	public Tree getTreeAt(int index){
		
		//check for valid index
		if(index >= getSeqSize()){
			return null;
		}
		else{
			Tree currTree = first;
			
			for(int i = 0; index > i; i++){
				currTree = currTree.getNext();
			}
			return currTree;
		}
	}
	
	//add state to end of sequence
	public void appendTree(Tree toAdd){
		if(seqSize == 0){
			first = toAdd;
			first.setNext(last);
			first.setPrev(null);
			seqSize++;
		}
		else if(seqSize == 1){
			last = toAdd;
			last.setPrev(first);
			first.setNext(last);
			
			seqSize++;
		}
		else{
			last.setNext(toAdd);
			Tree temp = last;
			last = toAdd;
			last.setPrev(temp);
			last.setNext(null);
			seqSize++;
		}
	}
	
	//insert state into sequence at specified index
	public void insert(Tree toAdd, int index){
		
		//check for valid index
		if(index >= getSeqSize()){
			System.out.println("Index outside of sequence bounds");
			return;
		}
		
		Tree currTree = first;
		for(int i = 0; index > i; i++){
			currTree = currTree.getNext();
		}
		
		//Insert tree after tree at specified index
		
		toAdd.setNext(currTree.getNext());
		currTree.getNext().setPrev(toAdd);
		toAdd.setPrev(currTree);
		currTree.setNext(toAdd);
		
		//increment sequence size
		seqSize++;
		
	}
}
