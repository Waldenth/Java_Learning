package multiplethread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestThreadPoolJava {
    public static void main(String[] args) throws InterruptedException {
           
        ThreadPoolExecutor threadPool= new ThreadPoolExecutor(10, 15, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
           
        threadPool.execute(new Runnable(){
   
            public void run() {
                // TODO Auto-generated method stub
                System.out.println("任务1");
            }
               
        });
   
    }
}
