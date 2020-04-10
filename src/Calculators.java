import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculators {
    private static final String MESS1="Оба числа должны быть или арабскими, или римскими!";
    private static final String MESS2="Числа переходят границы от 1 до 10";
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = new String[3];
        System.out.print("Input: ");
        Calculator calculator = new Calculator(new StringBuilder(reader.readLine()));
        try {
            arr = calculator.getArr();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        if (Helper.isNumber(arr[0])) {
            if (Helper.isNumber(arr[2])) {

                if ( Integer.parseInt(arr[0]) > 10 || Integer.parseInt(arr[0]) < 1 ||
                     Integer.parseInt(arr[2]) > 10 || Integer.parseInt(arr[2]) < 1)
                    System.out.println(MESS2);
                else System.out.println(calculator.calculate(arr[0], arr[2], arr[1]));

            } else System.out.println(MESS1);
        }else {
            Roman roman = new Roman();
            int  a,b;
            try {
                a=roman.romanToArabic(arr[0]);
                b=roman.romanToArabic(arr[2]);
                if ( a > 10 || a < 1 || b > 10 || b < 1) System.out.println(MESS2);
                else {
                    int res = calculator.calculate(String.valueOf(a), String.valueOf(b), arr[1]);
                    System.out.println(roman.arabicToRoman(res));
                }
            }catch (IOException e){
                System.out.println(MESS1);
            }

        }
    }
}
