package socket.interaction.multithread;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[]args){
        try{
            Socket s=new Socket("127.0.0.1",8888);

            new SendThread(s).start();
            new ReceiveThread(s).start();
        }catch (UnknownHostException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
