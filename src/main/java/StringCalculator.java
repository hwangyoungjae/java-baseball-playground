import java.util.Scanner;

public class StringCalculator {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String input = scanner.nextLine();
//
//        StringCalculator sc = new StringCalculator(input);
    }

//    public StringCalculator(String input) {
//        String[] inputArray = input.split(" ");
//        for (String s : inputArray) {
//            System.out.println(s);
//        }
//    }

    static Integer calc(String input) {
        String[] inputArray = input.split(" ");
        String opt = "";
        Integer n = 0;
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

    static Integer strToInt(String str) {
        return Integer.parseInt(str);
    }
}
