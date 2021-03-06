package first.task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Action implements IAction {
    Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    private int ActionNumber;

    private static String actionWithDic = "\nВозможные действия:\n"+
            "1. Чтение списка пар из файла.\n"+
            "2. Удаление записи по ключу.\n"+
            "3. Поиск записи по ключу.\n"+
            "4. Добавление записей.\n"+
            "5. Выход из приложения.\n"+
            "6. Просмотр доступных действий.\n"+
            "7. Выбрать другой словарь.\n";

    public void action() throws IOException {
        SearchDictionary.searchFiles();
        DictionarySelection.chooseDic();
        System.out.println(actionWithDic);

        for (; ;)
        {
            try {
                ActionNumber = Integer.parseInt(scanner.nextLine());
            }catch (Exception err){
                System.out.println("Введён некорректный символ!"); }

            if (ActionNumber == 1) { System.out.println(ReadAllFromFile.readAllFromFile(DictionarySelection.NameDic)); System.out.println(actionWithDic);}

            else if (ActionNumber == 2 ) {DeleteByKey.removeFromFileByKey(DictionarySelection.NameDic); System.out.println(actionWithDic);}

            else if (ActionNumber == 3) {SearchByKey.readFromFileByKey(DictionarySelection.NameDic); System.out.println(actionWithDic);}

            else if (ActionNumber == 4) {AddValuesToFile.removeFromFileByKey(DictionarySelection.NameDic); System.out.println(actionWithDic);}

            else if (ActionNumber == 5) {break;}

            else if (ActionNumber == 6) {System.out.println(actionWithDic);}

            else if (ActionNumber == 7) {SearchDictionary.searchFiles(); DictionarySelection.chooseDic(); System.out.println(actionWithDic);}

            else {System.out.println("Действие не найденно!"); }

        }
    }
}
