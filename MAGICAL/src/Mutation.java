
public class Mutation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//createSeq(20);
		createSeqs(20, 5);
		
		//TODO Mutation Matrix - create mutations down a phylo tree, making sure they are valid parse
	}
	
	//Create a sequence with a length 'size'
	public static void createSeq(int size){
		int remaining = size-1;
		State initial = new State("X");
		State curr = initial;
		//System.out.println(curr.getName() + " " + curr.getType());
		int count = 1;
		
		//Print out states in form name, type#, remainingStates
		while(remaining>0){
			System.out.println(count + ") " + curr.getName() + ", " + curr.getType() + ", " + remaining);
			curr = curr.getNextState(remaining);
			remaining--;
			count++;
		}
		System.out.print(count + ")" + curr.getName() + ", " + curr.getType() + ", " + remaining);
	}
	
	//Create n sequences all of length 'size'
	public static void createSeqs(int size, int n){
		
		for(int i=0; i<n;i++){
			int remaining = size-1;
			State initial = new State("X");
			State curr = initial;
			
			//Print out states in form name, type#, remainingStates
			while(remaining>0){
				System.out.print(curr.getName());
				for(int j = curr.getName().length();j<5;j++)
					System.out.print(" ");
					
				curr = curr.getNextState(remaining);
				remaining--;
				
			}
			System.out.println(curr.getName());
		}
		
	}
	
	//TODO fix cloneTree and cloneNodes
	
	//Clone a tree
	public static Tree cloneTree(Tree toClone){
		
		Tree newTree = new Tree();	
		newTree = toClone;
		
		return newTree;
	}
	
	/*
	public static void cloneNodes(Node toClone){
		
		if(!toClone.hasChildren()){
			return;
		}
		else{
			//call cloneNodes on all children of node
			for(int i = 0; i<toClone.getChildren().length; i++){
				if(toClone.getChildren()[i] != null){
					
					//clone nodes
					cloneNodes(toClone.getChildren()[i]);
				}
				
			}			
		}
		
	}
	*/
	
	
	//Mutate a sequence of trees
	public static void mutateTrees(Tree startTree){
		//mutate through entire species sequence before moving down a level in phylogenic tree
		
	}

}
