package socket.interaction.multithread;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ReceiveThread extends Thread{
    private Socket s;

    public ReceiveThread(Socket s){
        this.s=s;
    }
    public void run(){
        try{
            InputStream is=s.getInputStream();
            DataInputStream dis=new DataInputStream(is);
            while(true){
                String msg=dis.readUTF();
                System.out.println(msg);
                if(msg.equals("q")||msg.equals("quit")) {
                    break;
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("对方终止了会话");
    }
}
