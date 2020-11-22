package socket.interaction.multithread;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class SendThread extends Thread{
    private Socket s;

    public SendThread(Socket s){
        this.s=s;
    }
    public void run(){
        try{
            OutputStream os=s.getOutputStream();
            DataOutputStream dos=new DataOutputStream(os);
            while(true) {
                Scanner sc = new Scanner((System.in));
                String str = sc.nextLine();
                dos.writeUTF(str);
                if (str.equals("q") || str.equals("quit"))
                    break;
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("你终止了会话");
    }
}
