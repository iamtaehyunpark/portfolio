/**
 * Name: Taehyun Park
 * SBUID: 115242740
 */
enum OPER{PLUS, MINUS, TIMES, DIV, POW}; // Just for your reference. Don't need to use this.

public class HW4 {

	Stackable<String> stack; // Don't change this
	
	public HW4() {	
		stack = new MyStack();
	}
	
	/*
	 * These methods should return the converted infix/postfix. 
	 * If there is a syntax error, return an empty string.
	 * State the big-O (w.r.t. the length of input string) and explain why.
	 */

	//O(n), since there is a single for-loop that takes amounts of characters as much as the length of the input string
	 // while-loop can be dismissed since it has smaller or same big-O as for-loop
	public String infix2Postfix(String infix) {
		if(infix.charAt(infix.length()-1) < 48) return ""; //If infix equation end up with the operator, syntax is wrongly typed; return empty

		String postfix = "";
		for(int i=0;i<infix.length();i++){
			if(i % 2 == 0 && infix.charAt(i)<48) return "";    //even index of infix equation must be operands, if not, syntax is  wrongly typed;return empty
			if(infix.charAt(i) == '+'|| infix.charAt(i) == '-') {
				while(stack.peek() != null) postfix+=stack.pop();
				stack.push(""+infix.charAt(i));
				continue;
			}
			if(infix.charAt(i) == '*'|| infix.charAt(i) == '/'|| infix.charAt(i) == '^') {
				if(stack.peek().equals("*")|| stack.peek().equals('/')||
				 stack.peek().equals('^')) postfix+=stack.pop();  //if same priority operator is already stored, pop first
				
				stack.push(""+infix.charAt(i));
				continue;
			}
			postfix += infix.charAt(i);
		}
	

		while(stack.peek() != null) postfix+=stack.pop();

		return postfix;
	}
	
		 //O(n), since there is a single for-loop that takes amounts of characters as much as the length of the input string

	public String postfix2Infix(String postfix) {
		if(postfix.charAt(postfix.length()-1) > 48) return ""; //If post equation end up with the operand, syntax is wrongly typed; return empty

		String infix = "";
		for(int i=0;i<postfix.length();i++){
			if(postfix.charAt(i) == '*'|| postfix.charAt(i) == '/'|| postfix.charAt(i) == '^' 
			|| postfix.charAt(i) == '+'|| postfix.charAt(i) == '-') {
				try{
				String temp1 = stack.pop();
				String temp2 = stack.pop();
				String temp = temp2 + postfix.charAt(i) + temp1;
				stack.push(temp);
				}catch(Exception indexOutOfBouException){     //If there's not sufficient operands to pop, syntax is wrongly typed
					return "";   //return empty string
				}
			}else{
				stack.push(""+postfix.charAt(i));
			}
		}
		infix = stack.pop();

		if(stack.peek() != null) return ""; //if stack is not null after the operations, syntax is wrongly typed
	
		return infix;
	}


		
	public static void main(String[] args) {
		// The following are just test codes, which you can change all you want.
		HW4 hw = new HW4();
		String infix = "a+k-c*d";
		String postfix = "ak+cd*-";
		if(hw.infix2Postfix(infix).equals(postfix)) System.out.println("Success1");
		if(hw.postfix2Infix(postfix).equals(infix)) System.out.println("Success2");
		
		String badInfix = "a+b*b-a";
		String badPostfix = "abb*+a-";
		if(hw.infix2Postfix(badInfix).equals("")) System.out.println("Success3");
		if(hw.postfix2Infix(badPostfix).equals("")) System.out.println("Success4");
		
	}
}

/**
 * Your stack should use the following interface. You may use any of the data structures
 * that we looked at in class so far, but the time complexity for each of the required
 * methods should be minimal.
 * Note: Having more than one classes/interfaces in the same file is generally undesirable.
 * But we'll just keep it this way for the sake of simplicity.
 */
interface Stackable<E> {
	public E peek();
	public void push(E obj);
	public E pop();

}

class MyStack implements Stackable{
	public Object[] ary = new Object[30];   //making array operating as stack
	public int count = 0;   //making counter so that we can see actual number of objects inside the stack
	@java.lang.Override
	public java.lang.Object peek() {
		try{
		return ary[count-1];  //shows the last object inside the stack
		} catch(Exception ArrayIndexOutOfBoundsException){   //catch exception when the user checks the index in which the object doesn't exist
			return null; //instead gives null
		}
	}

	@java.lang.Override
	public void push(java.lang.Object obj) {
		if(ary.length<=count) {    //grow capacity if not sufficient
			Object[] temp = new Object[ary.length + 30];
			for (int i = 0; i < ary.length; i++) temp[i] = ary[i];
			ary = temp;
		}
		ary[count] = obj;  //put obj into last index
		count++;  //increase counter
	}

	@java.lang.Override
	public java.lang.Object pop(){
	try{
		Object obj = peek();  //return popping value (the last obj)
		ary[count-1] = null; 
		count--;  //decrease counter
		return obj;
	}catch (Exception ArrayIndexOutOfBoundsException){return null;}  // catch exception when there's nothing to eliminate --
	}
}

