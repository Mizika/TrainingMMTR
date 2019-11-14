package first.task;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import static first.task.ReadAllFromFile.filePath;

public class AddValuesToFile {

    private static BufferedReader readFromConsole = new BufferedReader(new InputStreamReader(System.in));

    public static void removeFromFileByKey(String fileName) throws IOException {
        Map<String, String> hashMap = new HashMap<>();
        File file = new File(filePath + fileName);
        try (BufferedReader readfromFile = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = readfromFile.readLine()) != null) {
                String[] tmp = line.split(" ");
                hashMap.put(tmp[0], tmp[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Введите ключ для добавления:");
        String key = readFromConsole.readLine();
        if (hashMap.get(key) == null) {
            System.out.println("Введите значения для добавления:");
            String value = readFromConsole.readLine();
            FileWriter fstream = new FileWriter(file);
            BufferedWriter out = new BufferedWriter(fstream);
            hashMap.put(key, value);
            System.out.println("Значение \"" + key + " " + value + "\" было добавленно!");
            for (Map.Entry entry : hashMap.entrySet()) {
                out.write(entry.getKey() + " " + entry.getValue() + "\n");
            }
            out.close();
        } else {
            System.out.println("Значение с данным ключом уже создано!");

        }
    }
}
