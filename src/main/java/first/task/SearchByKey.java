package first.task;

import java.io.*;
import java.util.Map;

import static first.task.ReadAllFromFile.filePath;

public class SearchByKey {
    private static BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

    public static void readFromFileByKey(String fileName) throws IOException {

        DictionaryReader read = new DictionaryReader(filePath, fileName);
        Map<String, String> data = read.readerFromFile();

        System.out.println("Введите ключ для поиска: ");
        String line = Console.readLine();
        System.out.println(data.getOrDefault(line, "Значение по данному ключу не найдено!"));
    }
}