import java.io.IOException;

public class Calculator {
    private final StringBuilder s;
    private final String[] data= {"","",""}; //инициализация

    Calculator(StringBuilder s) {
        this.s = s;
    }

    private void pars() throws IOException {
        int dIndex=0;
        char l;
        for (int i = 0; i <s.length() ; i++) {
            l=Character.toUpperCase(s.charAt(i));
            if (Character.isDigit(l) || l=='I'||l=='V'||l=='X') data[dIndex]+=l;
            else if (l == '+' || l == '-' || l == '*' || l == '/')
                    if (++dIndex < 2) {
                        data[dIndex] = String.valueOf(l);
                        dIndex++;
                    } else throw new IOException("Некорректные данные в строке " + s);
                 else throw new IOException("Некорректные данные "+ l +" в позиций "+(i+1));
        } //for
    }
    public Integer calculate(String a, String b, String oper){
        int na=Integer.parseInt(a);
        int nb=Integer.parseInt(b);
        switch (oper){
            case "+": return na+nb;
            case "-": return na-nb;
            case "*": return na*nb;
            case "/":return na/nb;
            default:return null;
        }
    }
    public String[] getArr() throws IOException {
        pars();
        return data;
    }
}
