package first.task;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DeleteByKey {
    private static String filePath = "C:\\Training\\dictionaries\\";
    private static BufferedReader readFromConsole = new BufferedReader(new InputStreamReader(System.in));


    public static void removeFromFileByKey(String fileName) throws IOException {

        File file=new File(filePath + fileName);

        FileWriter fstream = new FileWriter(file);
        BufferedWriter out = new BufferedWriter(fstream);

        Map<String, String> hashMap = new HashMap<>();
        hashMap.clear();

        try{
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()) {
                String result = sc.nextLine();
                String[] ar = result.split(" ");
                String num = ar[0];
                String word = ar[1];
                hashMap.put(num, word);
            }
            System.out.println("Введите ключ для удаления: ");
            String line = readFromConsole.readLine();

            for (String key : hashMap.keySet()) {
                if (key.equals(line)){
                    System.out.println(hashMap.remove(line));
                    System.out.println("Значение было удаленно!");
                    for (Map.Entry entry : hashMap.entrySet()){
                        out.write(entry.getKey() + " "+ entry.getValue() + "\n");
                    }
                    out.close();
                    break;
                }
                else {
                    System.out.println("Значение по данному ключу не найдено!");
                    break;
                }
            }
            sc.close();
        }catch (Exception err){
            System.out.println(err.getMessage());
        }
    }
}
