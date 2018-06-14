public class ExpressionGenerator {

    private ExpressionGenerator(){}

    public static String getExpression() {
        return generateExpression(3);
    }

    public static String getExpression(int maxDepth) {
        if (maxDepth < 1)
            return "[1]";

        if (maxDepth >= 50)
            maxDepth = 50;

        return generateExpression(maxDepth);
    }

    private static String generateExpression(int maxDepth) {
        if (maxDepth == 1) {
            int option = getRand(0, 6);
            int a = getRand(0, 99);
            int b = getRand(0, 99);

            switch (option) {
                case 0:
                    return "[ " + a + " ]";
                case 1:
                    return "( ++ " + a + " )";
                case 2:
                    return "( -- " + a + " )";
                case 3:
                    return "( " + a + " + " + b + " )";
                case 4:
                    return "( " + a + " - " + b + " )";
                case 5:
                    return "( " + a + " * " + b + " )";
                case 6:
                    return "( " + a + " / " + b + " )";
            }
        } else {
            int option = getRand(0, 20);
            int a = getRand(0, 99);

            switch (option) {
                case 0:
                    return "( " + generateExpression(maxDepth - 1) + " + " + a + " )";
                case 1:
                    return "( " + generateExpression(maxDepth - 1) + " - " + a + " )";
                case 2:
                    return "( " + generateExpression(maxDepth - 1) + " * " + a + " )";
                case 3:
                    return "( " + generateExpression(maxDepth - 1) + " / " + a + " )";
                case 4:
                    return "( " + a + " + " + generateExpression(maxDepth - 1) + " )";
                case 5:
                    return "( " + a + " - " + generateExpression(maxDepth - 1) + " )";
                case 6:
                    return "( " + a + " * " + generateExpression(maxDepth - 1) + " )";
                case 7:
                    return "( " + a + " / " + generateExpression(maxDepth - 1) + " )";
                case 8:
                    return "( " + generateExpression(maxDepth - 1) + " + " + generateExpression(maxDepth - 1) + " )";
                case 9:
                    return "( " + generateExpression(maxDepth - 1) + " - " + generateExpression(maxDepth - 1) + " )";
                case 10:
                    return "( " + generateExpression(maxDepth - 1) + " * " + generateExpression(maxDepth - 1) + " )";
                case 11:
                    return "( " + generateExpression(maxDepth - 1) + " / " + generateExpression(maxDepth - 1) + " )";
                case 12:
                    return "( ++ " + generateExpression(maxDepth - 1) + " )";
                case 13:
                    return "( -- " + generateExpression(maxDepth - 1) + " )";
                case 14:
                    return "[ " + generateExpression(maxDepth - 1) + " ]";
                default:
                    return generateExpression(maxDepth - 1);
            }
        }

        return "[1]";
    }

    private static int getRand(int low, int hi) {
        return (int) ((Math.random() * (hi - low + 1) + low));
    }

}