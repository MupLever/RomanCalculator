import java.util.Scanner;
public class Main {
    // Преобразование строки в римское число(строку)
    public static int romanNumberToInt(String string) throws
	Exception {
	    String [] romanNumbers = {"I","II","III","IV","V","VI","VII","VIII","IX","X"};
	    boolean flag = true;
	    for (int i = 0; i < 10 && flag; i++) {
	        if (string.equals(romanNumbers[i])) {
	            flag = false;	            
	            return ++i;
	        }
	    }
	    if (flag)
	    throw new
	        Exception("Ошибка! Число либо неположительно, либо больше 10");
	   return Integer.parseInt(string);
	}
    // Преобразование строки в арабское число с учетом исключения
    public static int StrToIntNumber(String string) throws
	Exception {
	    int number = Integer.parseInt(string);
	    if (number < 0 || number > 10)
	    throw new
	        Exception("Ошибка! Число либо неположительно, либо больше 10");
	    else
			return number;
	}
	//Проверка, является ли число римским
    public static boolean isRomanNumber(String string) { 
	    String [] romanNumbers = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
	    for (int i = 0; i < 10; ++i) {
	        if (string.equals(romanNumbers[i]))
	            return true;
	    }
	    return false;
	}
	public static String IntToRomanNumbe(int number) {

    }

    public static void main(String[] args) {
        System.out.println("Введите выражение, состоящее из двух арабских или римских чисел от 1 до 10 и операции между ними.");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        String[] operands = string.split("[-+/*]");
        if (operands.length != 2) {
            System.out.println("Ошибка! Количество операндов не равно двум.");
        } else {
            boolean flag1 = isRomanNumber(operands[0]);
            boolean flag2 = isRomanNumber(operands[1]);
            int value1 = flag1 ? romanNumberToInt(operands[0]) : StrToIntNumber(operands[0]);
            int value2 = flag2 ? romanNumberToInt(operands[1]) : StrToIntNumber(operands[1]);
            String[] operations = string.split("[A-Z0-9]{1,}"); //Парсим нашу строку, чтобы найти оператор. Он находится в массиве под номером 1.
            int result = 0;
            switch(operations[1]) {
                case "+":
                    result = value1 + value2;
                    break;
                case "-":
                    result = value1 - value2;
                    break;
                case "*":
                    result = value1 * value2;
                    break;
                case "/":
                    result = value1 / value2;
                    break;
            }
            // если оба числа являются римскими, то выводим ответ 
            if (flag1 && flag2) {
                System.out.println(IntToRomanNumbe(result));
            } else if (!(flag1 || flag2)) {
                // если оба числа являются арабскими, то выводим ответ
                System.out.println(result);
            } else {
                // иначе выводим исключение
                System.out.println("Ошибка! Смешение арабских и римских чисел в выражении.");
            }                
        }
        return 0;
    }
}
