package first.task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DictionarySelection {
    private static BufferedReader readFromConsole = new BufferedReader(new InputStreamReader(System.in));
    public static String NameDic;

    public static void chooseDic() throws IOException {
        System.out.println("Выберите словарь:");
        String line = readFromConsole.readLine();
        if (line.equals("1")){
            System.out.println("Вы находитесь в первом словаре!");
            NameDic = "first.txt";
        }else if (line.equals("2")){
            System.out.println("Вы находитесь во втором словаре!");
            NameDic = "second.txt";
        } else { System.out.println("Cловарь не найден!"); System.exit(0); }
    }
}
