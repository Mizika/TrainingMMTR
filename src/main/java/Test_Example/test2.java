package Test_Example;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static first.task.ReadAllFromFile.filePath;


public class test2 {

    public static void main(String[] args) throws IOException {
        removeFromFileByKey("first.txt");
    }

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
        System.out.println("Введите ключ для удаления: ");
        String line = readFromConsole.readLine();
        for (String key : hashMap.keySet()) {
            if (key.equals(line)) {
                FileWriter fstream = new FileWriter(file);
                BufferedWriter out = new BufferedWriter(fstream);
                System.out.println("Значение \"" + hashMap.remove(line) + "\" было удалено!");
                for (Map.Entry entry : hashMap.entrySet()) {
                    out.write(entry.getKey() + " " + entry.getValue() + "\n");
                }
                out.close();
                break;
            }else {
                System.out.println("Значение по данному ключу не найдено!");
                break;
            }
        }
    }
}