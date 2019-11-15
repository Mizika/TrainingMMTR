package Test_Example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class test {
    public static void main(String[] args) throws IOException {
        BufferedReader readFromConsole = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите значения для добавления:");
        String value = readFromConsole.readLine();
        //цифры в value
        Pattern sybol = Pattern.compile("\\d{5}|[а-яА-ЯёЁ]");
        //буквы в value
        Pattern bukvi = Pattern.compile("\\D{4}|[а-яА-ЯёЁ]");

        Matcher matcher = bukvi.matcher(value);

        if (matcher.matches()) {
            System.out.println("Выражение подходит!");
        }else {
            System.out.println("Введено не корректное значение!");
        }
    }
}
