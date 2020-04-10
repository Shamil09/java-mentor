import java.io.IOException;
import java.util.TreeMap;

public class Roman {
    private final TreeMap<Integer, String> romanMap = new TreeMap<>();
    { //инициализая
        romanMap.put(100, "C");
        romanMap.put(90, "XC");
        romanMap.put(50, "L");
        romanMap.put(40, "XL");
        romanMap.put(10, "X");
        romanMap.put(9, "IX");
        romanMap.put(5, "V");
        romanMap.put(4, "IV");
        romanMap.put(1, "I");
    }

    public  String arabicToRoman(int number) {
        if (number==0) return "0";
        int l =  romanMap.floorKey(number);
        if ( number == l )  return romanMap.get(number);
        return romanMap.get(l) + arabicToRoman(number-l);
    }

    public int romanToArabic(String strRoman) throws IOException {
        int dec = 0;
        int lastNum = 0;
        for (int c=strRoman.length()-1; c>=0; c--){
            switch (strRoman.charAt(c))
            {
                case 'I':
                case 'i':
                    dec=lastNum>1?dec-1:dec+1;
                    lastNum = 1;
                    break;
                case 'V':
                case 'v':
                    dec=lastNum>5?dec-5:dec+5;
                    lastNum = 5;
                    break;
                case 'X':
                case 'x':
                    dec=lastNum>10?dec-10:dec+10;
                    lastNum = 10;
                    break;
                case 'L':
                case 'l':
                    dec=lastNum>50?dec-50:dec+50;
                    lastNum = 50;
                    break;
                case 'C':
                case 'c':
                    dec=lastNum>100?dec-100:dec+100;
                    lastNum = 100;
                    break;
                default:throw new IOException("Некорректные данные в выражении "+strRoman);
            }
        }
        return dec;
    }
    
}
