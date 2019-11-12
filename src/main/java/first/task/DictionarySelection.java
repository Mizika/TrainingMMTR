package first.task;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class DictionarySelection {
    private static Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    public static String NameDic;

    public static void chooseDic() {
        System.out.println("Выберите словарь:");
        int lineNumber = scanner.nextInt();
        switch(lineNumber){
            case 1:
                System.out.println("Вы находитесь в первом словаре!");
                NameDic = "first.txt";
                break;
            case 2:
                System.out.println("Вы находитесь во втором словаре!");
                NameDic = "second.txt";
                break;
            default:
                System.out.println("Cловарь не найден!");
                System.exit(0);
        }
    }
}
