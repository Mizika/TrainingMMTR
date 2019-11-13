package first.task;

import java.io.*;
import java.util.Map;
import java.util.HashMap;

import static first.task.ReadAllFromFile.filePath;

public class SearchByKey {
    private static BufferedReader readFromConsole = new BufferedReader(new InputStreamReader(System.in));

    public static void readFromFileByKey(String fileName) throws IOException {
        Map<String, String> hashMap = new HashMap<>();
        File file=new File(filePath + fileName);
        try (BufferedReader readfromFile = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = readfromFile.readLine())!= null){
                String[] tmp = line.split(" ");
                hashMap.put(tmp[0], tmp[1]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Введите ключ для поиска: ");
        String line = readFromConsole.readLine();
        System.out.println(hashMap.getOrDefault(line, "Значение по данному ключу не найдено!"));
    }
}
