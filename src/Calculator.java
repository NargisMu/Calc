import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Calculator extends Operation {

    public final String[] NUM_RIM2 = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV",
    "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XVI", "XVII", "XVIII", "XXIX", "XXX",
    "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII",
    "XLIII","XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI",
    "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII",
    "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV",
    "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII",
    "XCIX", "C"};
    public final String[] NUM_RIM = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    public final String[] NUM_AR = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
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

            for (int i = 0; i < NUM_RIM.length; i++) {
                for (int j = 0; j < NUM_AR.length; j++) {
                    if (list[0].equals(NUM_RIM[i]) && list[2].equals(NUM_AR[j])) throw new Exception();
                    if (list[0].equals(NUM_AR[j]) && list[2].equals(NUM_RIM[i])) throw new Exception();
                }
            }

            for (int i = 0; i < list.length; i++) {
                if (list[i].equals(NUM_RIM[0]) || list[i].equals(NUM_RIM[1]) || list[i].equals(NUM_RIM[2]) || list[i].equals(NUM_RIM[3]) ||
                        list[i].equals(NUM_RIM[4]) || list[i].equals(NUM_RIM[5]) || list[i].equals(NUM_RIM[6]) || list[i].equals(NUM_RIM[7]) ||
                        list[i].equals(NUM_RIM[8]) || list[i].equals(NUM_RIM[9]))
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

             // вывод результа
        for(int i = 0; i < NUM_RIM.length; i++) {
            if (list[i].equals(NUM_RIM[0]) || list[i].equals(NUM_RIM[1]) || list[i].equals(NUM_RIM[2]) || list[i].equals(NUM_RIM[3]) ||
                    list[i].equals(NUM_RIM[4]) || list[i].equals(NUM_RIM[5]) || list[i].equals(NUM_RIM[6]) || list[i].equals(NUM_RIM[7]) ||
                    list[i].equals(NUM_RIM[8]) || list[i].equals(NUM_RIM[9])) {
                System.out.println(NUM_RIM2[Oper(elements.get(0), operation, elements.get(1)) - 1]);
                break;
            }
            else {
                System.out.println(Oper(elements.get(0), operation, elements.get(1)));
                break;
            }

        }

    }

    public int format(String string) {  //преобразование римских в арабские цифры
        int arabNum = 0;
        for(int i = 0; i < 10; i++) {
            if (string.equals(NUM_RIM[i])) {
                arabNum = i + 1;
            }
        }
        return arabNum;
    }
}

