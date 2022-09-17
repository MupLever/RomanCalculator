import java.util.Scanner;
public class Main {
    public static boolean isRomanNumber(String string) { 
	    String [] romanNumbers = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
	    for (int i = 0; i < 10; ++i) {
	        if (string.equals(romanNumbers[i]))
	            return true;
	    }
	    return false;
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
        }
        return 0;
    }
}
