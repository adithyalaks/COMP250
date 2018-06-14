
public class Testing123 {

	public static void main(String[] args) {
		String expression = "( ( 29 - ( ( ( 55 - [ ( ( 23 - 69 ) + ( 84 * 7 ) ) ] ) + 55 ) * ( ( 98 - ( 10 - ( ( ++ 48 ) - 91 ) ) ) - ( -- ( 36 * ( 43 - ( -- 72 ) ) ) ) ) ) ) - ( ( 87 + ( ++ ( ( -- ( ( -- 64 ) + [62 ]) ) * 86 ) ) ) * 40))";
		System.out.println(expression);
		Expression test = new Expression(expression);
		System.out.println(test.eval());

	}

}
