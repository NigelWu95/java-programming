package cn.net.nigel;

import java.util.stream.Stream;

public class stream {

    public static void main(String[] args) {
        Stream.of(1, 2, 3, 4, 5)
                .peek(integer -> System.out.println("accept:" + integer))
                .forEach(System.out::println)
        ;
    }
}
