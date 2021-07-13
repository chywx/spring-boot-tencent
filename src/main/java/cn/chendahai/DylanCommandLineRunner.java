package cn.chendahai;

import org.springframework.boot.CommandLineRunner;

/**
 * @author chy
 * @date 2021年07月12日 下午 14:25
 */
public class DylanCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... args) {
        System.out.println("run:" + Thread.currentThread().getName());
    }
}
