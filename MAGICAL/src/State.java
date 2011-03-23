import java.util.Random;

public class State {

	public final static int X = 0;
	public final static int E0 = 1;
	public final static int E1 = 2;
	public final static int E2 = 3;
	public final static int I0 = 4;
	public final static int I1 = 5;
	public final static int I1t = 6;
	public final static int I2 = 7;
	public final static int I2ta = 8;
	public final static int I2tg = 9;
	
	public static Random rand = new Random();

	private String name;
	private int type;

	private State next;
	private State prev;
	
	//Constructors
	
	public State(){
		//Default type is intergenic
		type = 0;
		name = "X";
	}
	
	public State(String theName){
		name = theName;
		//Determine type
		if(theName.equals("X"))
			type = X;
		else if(theName.equals("E0"))
			type = E0;
		else if(theName.equals("E1"))
			type = E1;
		else if(theName.equals("E2"))
			type = E2;
		else if(theName.equals("I0"))
			type = I0;
		else if(theName.equals("I1"))
			type = I1;
		else if(theName.equals("I1t"))
			type = I1t;
		else if(theName.equals("I2"))
			type = I2;
		else if(theName.equals("I2ta"))
			type = I2ta;
		else if(theName.equals("I2tg"))
			type = I2tg;
		else
			System.out.println("ERROR IN STATE NAME");
		
	}
	
	//Getters and Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	//next and prev values for sequence of states
	public State getNext() {
		return next;
	}
	public void setNext(State next) {
		this.next = next;
	}
	public State getPrev() {
		return prev;
	}
	public void setPrev(State prev) {
		this.prev = prev;
	}
	
	//Methods
	
	//Get next state in sequence based on current state and remaining number of states 
	public State getNextState(int remaining){
		
		//TODO Do not let function be called with remaining == 0
		
		//default next state as intergenic
		String next = "X";
		
		switch(this.type){
		case X: next = getNextX(remaining); break;
		case E0: next = getNextE0(remaining); break;
		case E1: next = getNextE1(remaining); break;
		case E2: next = getNextE2(remaining); break;
		case I0: next = getNextI0(remaining); break;
		case I1: next = getNextI1(remaining); break;
		case I1t: next = getNextI1t(remaining); break;
		case I2: next = getNextI2(remaining); break;
		case I2ta: next = getNextI2ta(remaining); break;
		case I2tg: next = getNextI2tg(remaining); break;
		}
		
		State nextState = new State(next);
		//System.out.println("Returning state " + nextState.getName());
		return nextState;
	}
	
	//Get next state after X (intergenic)
	public String getNextX(int remaining){
		//System.out.println("In x state");
		//Default next state as intergenic
		String nextState = "X";
		int value;
		
		//if there are more than one remaining transitions
		if(remaining > 1){
			value = rand.nextInt(100);
			if(value > 49){
				//next state is intergenic
				nextState = "X";
			}
			else{
				//next state is E0
				nextState = "E0";
			}
		}
		//System.out.println("Returning " + nextState);
		return nextState;	
			
	}
	//Get next state after E0 (exon)
	public String getNextE0(int remaining){
		
		//Default next state as E0
		String nextState = "E0";
		int value;
		
		//if there are more than one remaining transitions
		if(remaining == 1){
			//must go back to intergenic state
			nextState = "X";
		}
		else if (remaining == 2){
			//must either stay in current state or go to intergenic
			value = rand.nextInt(100);
			if(value > 49){
				//next state is intergenic
				nextState = "X";
			}
			else{
				//next state is E0
				nextState = "E0";
			}
		}
		else{
			//value can be exon, intron, or intergenic
			value = rand.nextInt(80);
			if(value > 69){
				//next state is intergenic
				nextState = "X";
			}
			else if(value > 59){
				//next state is E0
				nextState = "E0";
			}
			else if(value > 49){
				//next state is I0
				nextState = "I0";
			}
			else if(value > 39){
				//next state is I1
				nextState = "I1";
			}
			else if(value > 29){
				//next state is I1t
				nextState = "I1t";
			}
			else if(value > 19){
				//next state is I2
				nextState = "I2";
			}
			else if(value > 9){
				//next state is I2ta
				nextState = "I2ta";
			}
			else{
				//next state is I2tg
				nextState = "I2tg";
			}
		}
		return nextState;
	}
	//Get next state after E1 (exon)
	public String getNextE1(int remaining){
		
		//Default next state as E1
		String nextState = "E1";
		int value;
		
		//if there are more than one remaining transitions
		if(remaining == 1){
			//must go back to intergenic state
			nextState = "X";
		}
		else if (remaining == 2){
			//must either stay in current state or go to intergenic
			value = rand.nextInt(100);
			if(value > 49){
				//next state is intergenic
				nextState = "X";
			}
			else{
				//next state is E1
				nextState = "E1";
			}
		}
		else{
			//value can be exon, intron, or intergenic
			value = rand.nextInt(80);
			if(value > 69){
				//next state is intergenic
				nextState = "X";
			}
			else if(value > 59){
				//next state is E1
				nextState = "E1";
			}
			else if(value > 49){
				//next state is I0
				nextState = "I0";
			}
			else if(value > 39){
				//next state is I1
				nextState = "I1";
			}
			else if(value > 29){
				//next state is I1t
				nextState = "I1t";
			}
			else if(value > 19){
				//next state is I2
				nextState = "I2";
			}
			else if(value > 9){
				//next state is I2ta
				nextState = "I2ta";
			}
			else{
				//next state is I2tg
				nextState = "I2tg";
			}
		}
		return nextState;
	}
	//Get next state after E2 (exon)
	public String getNextE2(int remaining){
		
		//Default next state as E2
		String nextState = "E2";
		int value;
		
		//if there are more than one remaining transitions
		if(remaining == 1){
			//must go back to intergenic state
			nextState = "X";
		}
		else if (remaining == 2){
			//must either stay in current state or go to intergenic
			value = rand.nextInt(100);
			if(value > 49){
				//next state is intergenic
				nextState = "X";
			}
			else{
				//next state is E2
				nextState = "E2";
			}
		}
		else{
			//value can be exon, intron, or intergenic
			value = rand.nextInt(80);
			if(value > 69){
				//next state is intergenic
				nextState = "X";
			}
			else if(value > 59){
				//next state is E2
				nextState = "E2";
			}
			else if(value > 49){
				//next state is I0
				nextState = "I0";
			}
			else if(value > 39){
				//next state is I1
				nextState = "I1";
			}
			else if(value > 29){
				//next state is I1t
				nextState = "I1t";
			}
			else if(value > 19){
				//next state is I2
				nextState = "I2";
			}
			else if(value > 9){
				//next state is I2ta
				nextState = "I2ta";
			}
			else{
				//next state is I2tg
				nextState = "I2tg";
			}
		}
		return nextState;
	}
	//Get next state after I0 (intron)
	public String getNextI0(int remaining){
		
		//Default next state as current state
		String nextState = "I0";
		
		if(remaining == 2){
			//must go back to exon state
			nextState = "E0";
		}
		else{
			//State can either stay the same or go to exon state
			int value = rand.nextInt(100);
			if(value > 49){
				//next state is exon
				nextState = "E0";
			}
			else{
				//next state is intron
				nextState = "I0";
			}
		}
		return nextState;
	}
	//Get next state after I1 (intron)
	public String getNextI1(int remaining){
		
		//Default next state as current state
		String nextState = "I1";
		
		if(remaining == 2){
			//must go back to exon state
			nextState = "E1";
		}
		else{
			//State can either stay the same or go to exon state
			int value = rand.nextInt(100);
			if(value > 49){
				//next state is exon
				nextState = "E1";
			}
			else{
				//next state is intron
				nextState = "I1";
			}
		}
		return nextState;
	}
	//Get next state after I1t (intron)
	public String getNextI1t(int remaining){
		
		//Default next state as current state
		String nextState = "I1t";
		
		if(remaining == 2){
			//must go back to exon state
			nextState = "E1";
		}
		else{
			//State can either stay the same or go to exon state
			int value = rand.nextInt(100);
			if(value > 49){
				//next state is exon
				nextState = "E1";
			}
			else{
				//next state is intron
				nextState = "I1t";
			}
		}
		return nextState;
	}
	//Get next state after I2 (intron)
	public String getNextI2(int remaining){
		
		//Default next state as current state
		String nextState = "I2";
		
		if(remaining == 2){
			//must go back to exon state
			nextState = "E2";
		}
		else{
			//State can either stay the same or go to exon state
			int value = rand.nextInt(100);
			if(value > 49){
				//next state is exon
				nextState = "E2";
			}
			else{
				//next state is intron
				nextState = "I2";
			}
		}
		return nextState;
	}
	//Get next state after I2ta (intron)
	public String getNextI2ta(int remaining){
		
		//Default next state as current state
		String nextState = "I2ta";
		
		if(remaining == 2){
			//must go back to exon state
			nextState = "E2";
		}
		else{
			//State can either stay the same or go to exon state
			int value = rand.nextInt(100);
			if(value > 49){
				//next state is exon
				nextState = "E2";
			}
			else{
				//next state is intron
				nextState = "I2ta";
			}
		}
		return nextState;
	}
	//Get next state after I2tg (intron)
	public String getNextI2tg(int remaining){
		
		//Default next state as current state
		String nextState = "I2tg";
		
		if(remaining == 2){
			//must go back to exon state
			nextState = "E2";
		}
		else{
			//State can either stay the same or go to exon state
			int value = rand.nextInt(100);
			if(value > 49){
				//next state is exon
				nextState = "E2";
			}
			else{
				//next state is intron
				nextState = "I2tg";
			}
		}
		return nextState;
	}
	
}
