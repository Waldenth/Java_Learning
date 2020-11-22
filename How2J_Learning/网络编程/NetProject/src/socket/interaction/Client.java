package socket.interaction;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[]args){
        try{
            Socket s=new Socket("127.0.0.1",8888);
            OutputStream os=s.getOutputStream();
            DataOutputStream dos=new DataOutputStream(os);
            while(true) {
                Scanner sc = new Scanner(System.in);
                String str = sc.next();
                dos.writeUTF(str);
                if(str.equals("q")||str.equals("quit"))
                    break;
            }
            dos.close();
            s.close();
        }catch(UnknownHostException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
