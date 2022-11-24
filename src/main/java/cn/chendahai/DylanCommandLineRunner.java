package cn.chendahai;

import org.springframework.boot.CommandLineRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chy
 * @date 2021年07月12日 下午 14:25
 */
public class DylanCommandLineRunner implements CommandLineRunner {

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("b");
        strings.add("c");
        strings.add("d");
        for (String string : strings) {
            System.out.println(string);
            if (string.equals("c")) {
                strings.remove(string);
            }
        }
//        for (int i = 0; i < strings.size(); i++) {
//            System.out.println(strings.get(i));
//        }
    }

    @Override
    public void run(String... args) {
        System.out.println("run:" + Thread.currentThread().getName());
    }
}
