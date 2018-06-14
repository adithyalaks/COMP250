
/*
 * Student Name: Adithya Lakshminarayanan
 * Student ID: 260728234
 */

import java.util.Stack;
import java.util.ArrayList;

public class Expression {
	private ArrayList<String> tokenList;

	// Constructor
	/**
	 * The constructor takes in an expression as a string and tokenizes it
	 * (breaks it up into meaningful units) These tokens are then stored in an
	 * array list 'tokenList'.
	 */

	Expression(String expressionString) throws IllegalArgumentException {
		tokenList = new ArrayList<String>();
		StringBuilder token = new StringBuilder();

		// ADD YOUR CODE BELOW HERE
		for (int i = 0; i < expressionString.length(); i++) {
			if ((expressionString.charAt(i) == ' ')) {
				// tokenList.add(token.toString());
				// token.delete(0, token.length());
				continue;
			}

			else if ((expressionString.charAt(i) == '(' || expressionString.charAt(i) == ')'
					|| expressionString.charAt(i) == '[' || expressionString.charAt(i) == ']')) {
				// ((((token.toString()).equals("(")) ) ||
				// ((token.toString()).equals(")"))
				// || ((token.toString()).equals("[")) ||
				// ((token.toString()).equals("]"))){
				if (token.length() > 0) {
					tokenList.add(token.toString());
					token.delete(0, token.length());
				}
				tokenList.add(expressionString.substring(i, i + 1));
				continue;
			}

			else if (((!isInteger(token.toString()) && isInteger(expressionString.substring(i, i + 1)))
					|| (isInteger(token.toString()) && !isInteger(expressionString.substring(i, i + 1))))
					&& token.length() > 0) {
				tokenList.add(token.toString());
				token.delete(0, token.length());
			}

			token.append(expressionString.charAt(i));

		}
		// if (token.length() > 0){
		// tokenList.add(token.toString());
		// }
		// ADD YOUR CODE ABOVE HERE
	}

	/**
	 * This method evaluates the expression and returns the value of the
	 * expression Evaluation is done using 2 stack ADTs, operatorStack to store
	 * operators and valueStack to store values and intermediate results. - You
	 * must fill in code to evaluate an expression using 2 stacks
	 */
	public Integer eval() {
		Stack<String> operatorStack = new Stack<String>();
		Stack<Integer> valueStack = new Stack<Integer>();

		// ADD YOUR CODE BELOW HERE
		for (String t : tokenList) {
			if (t.equals("(") || t.equals("[")) {
				continue;
			} else if (isInteger(t)) {
				valueStack.push(Integer.valueOf(t));
				continue;
			} else {
				operatorStack.push(t);
			}

			if ((!operatorStack.empty())
					&& ((operatorStack.peek()).equals(")") || (operatorStack.peek()).equals("]"))) {
				String bracket = operatorStack.pop();

				if (bracket.equals("]")) {
					if (valueStack.peek() < 0)
						valueStack.push(valueStack.pop() * -1);
					continue;
				}

				else {
					String operator = operatorStack.pop();
					int second = valueStack.pop();
					int result = 0;
					if (operator.equals("++") || operator.equals("--")) {
						result = (operator.equals("++")) ? ++second : --second;
					} else {
						int first = valueStack.pop();
						switch (operator) {
						case "+":
							result = first + second;
							break;
						case "-":
							result = first - second;
							break;
						case "/":
							result = first / second;
							break;
						case "*":
							result = first * second;
							break;
						}
					}
					valueStack.push(result);
				}
			}

		}
		return valueStack.pop();
	}

	// Helper methods
	/**
	 * Helper method to test if a string is an integer Returns true for strings
	 * of integers like "456" and false for string of non-integers like "+" - DO
	 * NOT EDIT THIS METHOD
	 */
	private boolean isInteger(String element) {
		try {
			Integer.valueOf(element);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	/**
	 * Method to help print out the expression stored as a list in tokenList. -
	 * DO NOT EDIT THIS METHOD
	 */

	@Override
	public String toString() {
		String s = new String();
		for (String t : tokenList)
			s = s + "~" + t;
		return s;
	}

}
