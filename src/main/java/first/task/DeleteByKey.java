package first.task;

import java.io.*;
import java.util.Map;
import java.util.HashMap;

import static first.task.ReadAllFromFile.filePath;

public class DeleteByKey {
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
        if (hashMap.get(line) != null) {
                FileWriter fstream = new FileWriter(file);
                BufferedWriter out = new BufferedWriter(fstream);
                System.out.println("Значение \"" + hashMap.remove(line) + "\" было удалено!");
                for (Map.Entry entry : hashMap.entrySet()) {
                    out.write(entry.getKey() + " " + entry.getValue() + "\n");
                }
                out.close();
            }else {
                System.out.println("Значение по данному ключу не найдено!");
            }
        }
    }
