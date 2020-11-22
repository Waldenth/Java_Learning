package socket.interaction;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[]args){
        try{
            ServerSocket ss=new ServerSocket(8888);
            System.out.println("服务器监听端口8888");
            Socket s=ss.accept();

            InputStream is=s.getInputStream();

            //输入流封装在DataInputStream
            DataInputStream dis=new DataInputStream(is);
            //使用readUTF读取
            while(true) {
                String msg = dis.readUTF();
                System.out.println(msg);
                if(msg.equals("q")||msg.equals("quit"))
                    break;
            }
            dis.close();
            s.close();
            ss.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
