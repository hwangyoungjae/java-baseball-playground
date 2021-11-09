import java.util.Scanner;

public class StringCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        System.out.println(StringCalculator.calc(input));
    }

    static Integer calc(String input) {
        String[] inputArray = input.split(" ");
        String opt = "";
        int n = 0;
        for (String s : inputArray) {
            if ("+-*/".contains(s)) {
                opt = s;
            } else {
                switch (opt) {
                    case "+":
                        n += strToInt(s);
                        break;
                    case "-":
                        n -= strToInt(s);
                        break;
                    case "*":
                        n *= strToInt(s);
                        break;
                    case "/":
                        n /= strToInt(s);
                        break;
                    default:
                        n = strToInt(s);
                        break;
                }
            }
        }
        return n;
    }

    static int strToInt(String str) {
        return Integer.parseInt(str);
    }
}
