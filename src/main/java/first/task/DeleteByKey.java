package first.task;

import java.io.*;
import java.util.Map;

import static first.task.ReadAllFromFile.filePath;

public class DeleteByKey {
    private static BufferedReader Console = new BufferedReader(new InputStreamReader(System.in));

    public static void removeFromFileByKey(String fileName) throws IOException {
        DictionaryReader read = new DictionaryReader(filePath, fileName);
        Map<String, String> data = read.readerFromFile();

        System.out.println("Введите ключ для удаления: ");
        String line = Console.readLine();
        if (data.get(line) != null) {
                FileWriter fstream = new FileWriter(filePath + fileName);
                BufferedWriter out = new BufferedWriter(fstream);
                System.out.println("Значение \"" + data.remove(line) + "\" было удалено!");
                for (Map.Entry entry : data.entrySet()) {
                    out.write(entry.getKey() + " " + entry.getValue() + "\n");
                }
                out.close();
            }else {
                System.out.println("Значение по данному ключу не найдено!");
            }
        }
    }
