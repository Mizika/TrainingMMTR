package first.task;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static first.task.ReadAllFromFile.filePath;

public class AddValuesToFile {

    private static BufferedReader readFromConsole = new BufferedReader(new InputStreamReader(System.in));
    private static Pattern number = Pattern.compile("\\d{5}");
    private static Pattern letters = Pattern.compile("\\D{4}");
    private static Matcher fileReg;
    private static String value;

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
            if (fileName.equals("second.txt")) {
                System.out.println("Значение может состоять только из 5 цифр!");
                value = readFromConsole.readLine();
                fileReg = number.matcher(value);
            }
            else if (fileName.equals("first.txt")) {
                System.out.println("Значение может состоять только из 4 латинских букв!");
                value = readFromConsole.readLine();
                fileReg = letters.matcher(value);
            }
            if (fileReg.matches()) {
                FileWriter fstream = new FileWriter(file);
                BufferedWriter out = new BufferedWriter(fstream);
                hashMap.put(key, value);
                System.out.println("Значение \"" + key + " " + value + "\" было добавленно!");
                for (Map.Entry entry : hashMap.entrySet()) {
                    out.write(entry.getKey() + " " + entry.getValue() + "\n");
                }
                out.close();
            } else { System.out.println("Введено не корректное значение!"); }
        }else { System.out.println("Значение с данным ключом уже создано!"); }
    }
}
