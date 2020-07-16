import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator extends Operation {

    public final String[] num = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    public final String[] Num = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    BufferedReader reader; // буферизованный читатель строки из некоего потока
    List<Integer> elements = new ArrayList<>();
    String[] list = new String[3];
    String operation = null;

    Calculator(InputStreamReader input) {
        reader = new BufferedReader(input); //создаем буффер-читателя вокруг переданного потока-читателя
        try {
            String s = reader.readLine();
            calculate(s);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void calculate(String s) throws Exception {
        String[] ariphmetic = new String[]{"+", "-", "*", "/"};
        String[] list = s.split(" "); //разделяем строку на массив

            for (int i = 0; i < num.length; i++) {
                for (int j = 0; j < Num.length; j++) {
                    if (list[0].equals(num[i]) && list[2].equals(Num[j])) throw new Exception();
                    if (list[0].equals(Num[j]) && list[2].equals(num[i])) throw new Exception();
                }
            }

            for (int i = 0; i < list.length; i++) {
                if (list[i].equals(num[0]) || list[i].equals(num[1]) || list[i].equals(num[2]) || list[i].equals(num[3]) ||
                        list[i].equals(num[4]) || list[i].equals(num[5]) || list[i].equals(num[6]) || list[i].equals(num[7]) ||
                        list[i].equals(num[8]) || list[i].equals(num[9]))
                    elements.add(format(list[i]));  // проверка на римские цифры

                else if (!(list[i].equals("+") || list[i].equals("-") || list[i].equals("*") || list[i].equals("/"))) {
                    elements.add(Integer.parseInt(list[i])); // проверка на арифметические операции
                } else if (list[i].equals("+") || list[i].equals("-") || list[i].equals("*") || list[i].equals("/")) {
                    operation = list[i]; // проверка на арабские цифры

                }

            }

            for (int i = 0; i < elements.size(); i++) {
                if (elements.get(i) > 10) throw new Exception();//выброс исключения, еои цифры > 10
                }

            if (!operation.equals(ariphmetic[0]) && !operation.equals(ariphmetic[1]) && !operation.equals(ariphmetic[2])
                    && !operation.equals(ariphmetic[3]))  throw new Exception(); //выбрасывается исключение, если иная операция

            System.out.println(Oper(elements.get(0), operation, elements.get(1))); // вывод результа
    }
    public int format(String string) {  //преобразование римских в арабские цифры
        int arabNum = 0;
        for(int i = 0; i < 10; i++) {
            if (string.equals(num[i])) {
                arabNum = i + 1;
            }
        }
        return arabNum;
    }
}

