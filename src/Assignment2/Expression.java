package Assignment2;

/*
	Student Name: Alexander Harris
	Student ID:   260688155
 */

import java.util.Stack;
import java.util.ArrayList;

public class Expression  {
	private ArrayList<String> tokenList;

	//  Constructor    
	/**
	 * The constructor takes in an expression as a string
	 * and tokenizes it (breaks it up into meaningful units)
	 * These tokens are then stored in an array list 'tokenList'.
	 */

	Expression(String expressionString) throws IllegalArgumentException{
		tokenList = new ArrayList<String>();
		StringBuilder token = new StringBuilder();

		//ADD YOUR CODE BELOW HERE

		String parsedToken;

		for(int i = 0; i < expressionString.length(); i++) {

			if(expressionString.charAt(i) == ' ') {		// Ignores spaces
				continue;
			}

			/* Compares the last character in token to the character at i in the string.
			 * If they are both integers, or both +/-, append it to the token.
			 * If not, add the current token to tokenList and reset token, then append the new character.
			 */

			if(token.length() > 0) {
				if(expressionString.charAt(i) >= 48 && expressionString.charAt(i) <= 57) {
					if(!(token.charAt(token.length() - 1) >= 48 && token.charAt(token.length() - 1) <= 57)) {
						parsedToken = token.toString();
						tokenList.add(parsedToken);
						token.setLength(0);
					}
				}
				else if(expressionString.charAt(i) == 43 || expressionString.charAt(i) == 45) {
					if(!(token.charAt(token.length() - 1) == 45 || token.charAt(token.length() - 1) == 43)) {
						parsedToken = token.toString();
						tokenList.add(parsedToken);
						token.setLength(0);
					}
				}
				else {
					parsedToken = token.toString();
					tokenList.add(parsedToken);
					token.setLength(0);
				}
				token.append(expressionString.charAt(i));
			}
			else {
				token.append(expressionString.charAt(i));		// Adds first character in the string to an empty token
			}
		}
		parsedToken = token.toString();							// Adds last token to tokenList
		tokenList.add(parsedToken);

		//ADD YOUR CODE ABOVE HERE
	}

	/**
	 * This method evaluates the expression and returns the value of the expression
	 * Evaluation is done using 2 stack ADTs, operatorStack to store operators
	 * and valueStack to store values and intermediate results.
	 * - You must fill in code to evaluate an expression using 2 stacks
	 */
	public Integer eval(){
		Stack<String> operatorStack = new Stack<String>();
		Stack<Integer> valueStack = new Stack<Integer>();

		//ADD YOUR CODE BELOW HERE
		
		/* Evaluate each token in the list, push operators onto the operator stack and values onto the value stack.
		 * When a ")" is reached, we pop an operator off the stack and evaluate based on what type it is.
		 * The result is then pushed back onto the stack.
		 * If we encounter a "]", we take the absolute value of the number on top of the value stack and push it back onto the stack.
		 * Finally return whatever is left in the stack.
		 */

		for(String token : tokenList) {

			switch(token) {
			
			case "[":
			case "(":
				break;

			case "+":
			case "-":
			case "++":
			case "--":
			case "*":
			case "/":
				operatorStack.push(token);
				break;
				
			case ")":

				String operator = operatorStack.pop();
				int temp;
				int temp2;

				switch(operator) {
				case "+":
					temp = valueStack.pop() + valueStack.pop();
					valueStack.push(temp);
					break;
				case "-":
					temp = valueStack.pop();
					temp2 = valueStack.pop();
					temp = temp2 - temp;
					valueStack.push(temp);
					break;
				case "*":
					temp = valueStack.pop() * valueStack.pop();
					valueStack.push(temp);
					break;
				case "/":
					temp = valueStack.pop();
					temp2 = valueStack.pop();
					temp = temp2 / temp;
					valueStack.push(temp);
					break;
				case "++":
					temp = valueStack.pop() + 1;
					valueStack.push(temp);
					break;
				case "--":
					temp = valueStack.pop() - 1;
					valueStack.push(temp);
					break;
				}
				break;

			case "]":
				int abs = Math.abs(valueStack.pop());
				valueStack.push(abs);
				break;
			
			default:
				valueStack.push(Integer.parseInt(token));
				break;
			}	
		}

		return valueStack.pop();
		
		//ADD YOUR CODE ABOVE HERE
	}

	//Helper methods
	/**
	 * Helper method to test if a string is an integer
	 * Returns true for strings of integers like "456"
	 * and false for string of non-integers like "+"
	 * - DO NOT EDIT THIS METHOD
	 */
	private boolean isInteger(String element){
		try{
			Integer.valueOf(element);
		}catch(NumberFormatException e){
			return false;
		}
		return true;
	}

	/**
	 * Method to help print out the expression stored as a list in tokenList.
	 * - DO NOT EDIT THIS METHOD    
	 */

	@Override
	public String toString(){	
		String s = new String(); 
		for (String t : tokenList )
			s = s + "~"+  t;
		return s;		
	}

}

