import java.util.Random;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		//TODO generate a linked list of trees
		
		State rootState = new State("X");
		Node rootNode = new Node(rootState);
		Tree theTree = new Tree(rootNode);
		theTree.initialize();
		Sequence theSeq = new Sequence(theTree);
		theTree.printTree();
		
		
			int remaining = 19;
			State curr = rootState;
			System.out.print(curr.getName());
			
			//Print out states in form name, type#, remainingStates
			while(remaining>0){
				curr = curr.getNextState(remaining);
				System.out.print(curr.getName());
				rootNode = new Node(curr);
				theTree = new Tree(rootNode);
				theTree.initialize();
				theSeq.appendTree(theTree);
					
				remaining--;
			}
			System.out.println("\n" + theSeq.getSeqSize());
			theSeq.printSequence();
			
			//Generic tests
			System.out.println(theSeq.getTreeAt(3).getNode(5).print());

	}
}
