import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOFileChannel {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src\\1.txt");
        FileChannel inputStreamChannel = fileInputStream.getChannel();
        FileOutputStream fileOutputStream = new FileOutputStream("src\\2.txt");
        FileChannel outputStreamChannel = fileOutputStream.getChannel();
        //缓冲区容量
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        while (true) {
            byteBuffer.clear();
            int read = inputStreamChannel.read(byteBuffer);
            System.out.println("read = " + read);
            if (read == -1) break;
            byteBuffer.flip();
            outputStreamChannel.write(byteBuffer);
        }
        fileInputStream.close();
        fileOutputStream.close();
        outputStreamChannel.close();
        inputStreamChannel.close();
    }
}
