//Name: Yaser Azfar
//ID: 1350368
import java.io.File;
import java.util.Scanner;
import java.io.*;

class MTFencoder
{
    public static void main(String[] args) throws Exception
    {
        WordList mruList = new WordList();

        if(args.length != 1){
            System.err.println("Usage:  java TestRead <filename>");
            return;
        }      

        try{
            PrintWriter writer = new PrintWriter("newFile.txt");
            Scanner sc = new Scanner(new File(args[0]));
            String line;
            while (sc.hasNext()){
                line = sc.nextLine();
                String [] arrayOfLine = line.split(" ");

                for (String a:arrayOfLine){
                    if(mruList.has(a)){
                        int hasIndex = mruList.hasIndex(a);
                        System.out.println(hasIndex);
                        writer.println(hasIndex);
                        mruList.remove(a);
                    }
                    else{
                        System.out.println('0' + " " + a);
                        writer.println('0' + " " + a);
                    }
                    mruList.add(a);
                }
                if(mruList.has("/n")){
                    int hasIndex = mruList.hasIndex("/n"); 
                    System.out.println(hasIndex);
                    writer.println(hasIndex);
                    mruList.remove("/n");
                }
                else{
                    System.out.println('0' + " " + "/n");
                    writer.println('0' + " " + "/n");
                }
                mruList.add("/n");
            }
            writer.close();
        } catch(Exception e){
            //TODO: handle exception
        }
    }
}
