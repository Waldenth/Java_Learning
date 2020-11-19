import java.io.File;

public class Traversefile{
    static long min=Integer.MAX_VALUE;
    static long max=0;
    static File maxFile=null;
    static File minFile=null;
    public static void main(String[]args){
        String targetPath="D:/Edge Download";
        File p=new File(targetPath);
        
        File[]files=p.listFiles();
        Get_MAX_MIN_File(files);
        try {
            System.out.println("The min file name is "+minFile.getName()+" it's size is "+minFile.length());
            System.out.println("The max file name is "+maxFile.getName()+" it's size is "+maxFile.length());
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }
    private static void Get_MAX_MIN_File(File[] files){
        for(File tmp:files){
            if(tmp.length()==0)
                continue;
            if(tmp.length()<min){
                minFile=tmp;
                min=tmp.length();
            }
            if(tmp.length()>max){
                maxFile=tmp;
                max=tmp.length();
            }
        }
    }
}