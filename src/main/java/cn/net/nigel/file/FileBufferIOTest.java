package cn.net.nigel.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileBufferIOTest {

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/wubingheng/Downloads/FileBufferIOTest.txt");
        file.createNewFile();
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (int i = 0; i < 10; i++) {
//            fileWriter.write("1");
//            fileWriter.flush();
            bufferedWriter.newLine();
            bufferedWriter.write("1");
            bufferedWriter.flush();
            System.out.println(file.length());
        }
        fileWriter.close();
        System.out.println(new File("/Users/wubingheng/Downloads/test.json").length());
    }
}
