package suanfa.com.nio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

public class PlainOioServer {

    public static void main(String[] args) throws IOException {
        PlainOioServer server = new PlainOioServer();
        server.serve(5555);
    }
    //1.绑定服务器到指定的端口。
    //
    //2.接受一个连接。
    //
    //3.创建一个新的线程来处理连接。
    //
    //4.将消息发送到连接的客户端。
    //
    //5.一旦消息被写入和刷新时就 关闭连接。
    //
    //6.启动线程。

    public static void serve(int port) throws IOException {
        final ServerSocket socket = new ServerSocket(port);     //1
        try {
            int i=0;
            for (int j=0;j<=5;j++) {
                System.out.println("Accepted connection from j= " + j);
                i++;
                final Socket clientSocket = socket.accept();    //2
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Accepted connection from " + clientSocket);

                new Thread(new Runnable() {                        //3
                    @Override
                    public void run() {
                        OutputStream out;
                        try {
                            out = clientSocket.getOutputStream();
                            out.write("Hi!\r\n".getBytes(Charset.forName("UTF-8")));                            //4
                            out.flush();
                            clientSocket.close();                //5

                        } catch (IOException e) {
                            e.printStackTrace();
                            try {
                                clientSocket.close();
                            } catch (IOException ex) {
                                // ignore on close
                            }
                        }
                    }
                }).start();                                        //6
                if(i==5)
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
