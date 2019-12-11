package cn.net.nigel.file;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class RandomAccessTest {

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/wubingheng/Downloads/redis-work.md");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        System.out.println(reader.readLine());
//        System.out.println(file.exists());
        RandomAccessFile accessFile = new RandomAccessFile("/Users/wubingheng/Downloads/redis-work.md", "r");
        System.out.println("length: " + accessFile.length());
        String line;
//        accessFile.seek(accessFile.length() - 10);

//        System.out.println(accessFile.readLine());
        byte[] bytes = new byte[1];
//        accessFile.seek(1);
//        accessFile.read(bytes);
//        System.out.println(new String(bytes));
        long pos = accessFile.length() - 1;
        accessFile.seek(--pos);
        accessFile.read(bytes);
        String s = new String(bytes);
        accessFile.seek(--pos);
        while (pos > 0 && accessFile.read(bytes) != -1 && "\n".equals(s)) {
            accessFile.seek(--pos);
            s = new String(bytes);
        }
        while (pos > 0 && accessFile.read(bytes) != -1 && !"\n".equals(s)) {
            accessFile.seek(--pos);
            s = new String(bytes);
//            System.out.println(s);
//            System.out.println("\n".equals(s));
        }
        if (pos > 0) accessFile.seek(pos + 2);
//        accessFile.read(bytes);
//        System.out.println(s);
        System.out.println(accessFile.readLine());
//        line = accessFile.readLine();
//        line = new String(line.getBytes(StandardCharsets.ISO_8859_1));
//        System.out.println(new String(line.getBytes(StandardCharsets.ISO_8859_1)));
//        System.out.println("### 4.在华为云 redis 服务中购买一个4.0集群，使用 webcli 连接并执行 cluster 的相关命令（选做）".equals(line));
//        while ((line = accessFile.readLine()) != null) {
//
//        }
    }
}
