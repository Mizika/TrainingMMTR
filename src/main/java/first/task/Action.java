package first.task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Action implements IAction {
    Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

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
            int ActionNumber = Integer.parseInt(scanner.nextLine());

            if (ActionNumber == 1) { System.out.println(ReadAllFromFile.readAllFromFile(DictionarySelection.NameDic));}

            else if (ActionNumber == 2 ) {DeleteByKey.removeFromFileByKey(DictionarySelection.NameDic);}

            else if (ActionNumber == 3){ SearchByKey.readFromFileByKey(DictionarySelection.NameDic);}

            else if (ActionNumber == 4) {AddValuesToFile.removeFromFileByKey(DictionarySelection.NameDic);}

            else if (ActionNumber == 5){break;}

            else if (ActionNumber == 6) { System.out.println(actionWithDic);}

            else { System.out.println("Действие не найденно!"); }

        }
    }
}
