package first.task;

import java.io.*;
import java.util.Map;


public class SearchByKey {
    private static BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

    public static void readFromFileByKey(String fileName) throws IOException {

        DictionaryReader read = new DictionaryReader(Const.PATH, fileName);
        Map<String, String> data = read.readerFromFile();

        System.out.println("Введите ключ для поиска: ");
        String line = Console.readLine();
        System.out.println(data.getOrDefault(line, Const.NOT_FOUND));
    }
}