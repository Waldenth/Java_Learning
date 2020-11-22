package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestAvailableIP {
    public static void pingAll(){
        List<String> IPs=new ArrayList<String>();
        String OwnIP="";
        try {
            OwnIP = getOwnIP();
            //截取OwnIP为前当前网段 "XX.XX.XX."
            OwnIP = OwnIP.substring(0,OwnIP.lastIndexOf('.')+1);
        }catch(UnknownHostException e){
            e.printStackTrace();
        }
        //构建线程池100，最多150，等待5s没有活的线程回收
        ThreadPoolExecutor tpe=new ThreadPoolExecutor(100,150,5, TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>());
        for(int i=1;i<=255;i++){
            final int j=i;
            String finalOwnIP = OwnIP;
            tpe.execute(new Runnable() {
                @Override
                public void run() {
                   Process p;
                   try{
                       System.out.println("正在测试 "+finalOwnIP+j);
                       p=Runtime.getRuntime().exec("ping "+ finalOwnIP + j);
                       BufferedReader br=new BufferedReader(new InputStreamReader(p.getInputStream(),"GBK"));
                       String temp=br.readLine();
                       boolean flag=false;
                       while(temp!=null){
                           if(temp.contains("TTL")){
                               flag=true;
                               break;
                           }
                           temp=br.readLine();
                       }
                       if(flag)
                           System.out.println("网段可用IP地址: "+ finalOwnIP +j);
                   }catch (IOException e){
                       e.printStackTrace();
                   }
                }
            });
        }
        tpe.shutdown();
    }
    public static String getOwnIP()throws UnknownHostException{
        InetAddress host=InetAddress.getLocalHost();
        String ip=host.getHostAddress();
        System.out.println("成功获取本机IP: "+ip);
        return ip;
    }
    public static void main(String[]args){
        pingAll();
    }
}
