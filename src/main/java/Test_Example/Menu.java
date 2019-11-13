package Test_Example;

import java.io.*;
import java.util.*;

public class Menu implements IMenu {

    private static String filePath = "C:\\Training\\dictionaries\\";
    private static String NameDic;
    private static String action;
    private static String actionWithDic = "\nВозможные действия:\n"+ "1. Чтение списка пар из файла.\n"+ "2. Удаление записи по ключу.\n"+ "3. Поиск записи по ключу.\n"+ "4. Добавление записей.\n"+"5. Просмотр всех значений.";
    private static int numDictionary;
    private static int numAction;
    private static Scanner numberOfDic = new Scanner(System.in);


    public void outFromConsole() {
        searchFiles();

        int numAction = numberOfDic.nextInt();
        if (numAction == 5){
            readAllFromFile(NameDic);
        }else if (numAction == 3){
            String keyToSearch = numberOfDic.next();
            searchInFile(keyToSearch);
        }else{
            System.out.println("Действие не реализованно");
        }

        //readFromFile();

    }

    //Поиск словарей
    private static void searchFiles() {
        System.out.println("Найденные словари:");
        File dic = new File(filePath);
        int i = 1;
        if(dic.isDirectory()){
            for(File item : dic.listFiles()){
                System.out.println(i++ +". " +item.getName());
            }
        }
        System.out.println("Выберите словарь: ");
        int numDictionary = numberOfDic.nextInt();
        if (numDictionary == 1){
            System.out.println("Вы находитесь в первом словаре!"+actionWithDic);
            NameDic = "first.txt";
        }else{
            System.out.println("Вы находитесь во втором словаре!"+actionWithDic);
            NameDic = "second.txt";
        }

    }

    //Чтение всего из файла
    private static void readAllFromFile(String NameOfDic) {
        File file=new File(filePath + NameOfDic);
        try{
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()) {
                String result = sc.nextLine();
                System.out.println(result);
            }
            sc.close();
        }catch (Exception err){
            System.out.println(err.getMessage());
        }

    }

    //Чтение из файла
    private static void readFromFile() {
        File file=new File(filePath + "first.txt");
        Map <String, String> hashMap = new HashMap<>();
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
            System.out.println(Collections.singletonList(hashMap));
            String value = hashMap.get("55");
            System.out.println(value);

            sc.close();
        }catch (Exception err){
            System.out.println(err.getMessage());
        }

    }

    private static void deleteFromFile() {}

    private static void searchInFile(String search) {
        System.out.print("Найденное значение: ");
        File file=new File(filePath +NameDic);
        Map <String, String> hashMap = new HashMap<String, String>();
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
            String value = hashMap.get(search);
            System.out.println(value);

            sc.close();
        }catch (Exception err){
            System.out.println("Не удается найти значение или словарь ! "+err.getMessage());
        }
    }

    private static void  addInFile() {}
}
