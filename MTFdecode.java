//Name: Yaser Azfar
//ID: 1350368
import java.io.File;
import java.util.Scanner;
import java.io.*;

class MTFdecode{
    public static void main(String[] args) throws Exception 
    {

        WordList mruList = new WordList();

        if(args.length != 1){
            System.err.println("Usage:  java TestRead <filename>");
            return;
        }      

        try {
            Scanner sc = new Scanner(new File(args[0]));
            String line;
            while (sc.hasNext()){
                line = sc.nextLine();
                String first;
                String second;

                if((line.startsWith("0")) && (line.length() > 1)){
                    String lineSplit[] = line.split(" ");
                    first = lineSplit[0];
                    second = lineSplit[1];
                    if(second.equals("/n")){
                        System.out.print("\n");
                    }
                    else{
                        System.out.print(second + " ");
                    }
                    mruList.add(second);
                }

                else{ 
                    int indexOfWord = Integer.parseInt(line);
                    second = mruList.indexWord(indexOfWord);
                    if(second.equals("/n")){
                        System.out.print("\n");
                    }
                    else{
                        System.out.print(second + " ");
                    }
                    mruList.remove(second);
                    mruList.add(second);
                }

            }
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}