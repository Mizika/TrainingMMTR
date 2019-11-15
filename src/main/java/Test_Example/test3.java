package Test_Example;

import java.util.Collections;


public class test3 {
    public static void main(String[] args) {
//        test2.setFileName("second.txt");
//        test2.setFilePath("C:\\Training\\dictionaries\\");
//        System.out.println(Collections.singletonList(test2.readerFromFile()));

        test2 asd = new test2("C:\\Training\\dictionaries\\","second.txt" );
        System.out.println(Collections.singletonList(asd.readerFromFile()));
    }

}
