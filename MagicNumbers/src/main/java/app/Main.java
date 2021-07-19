package app;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    // psvm
    public static void main(String[] args) throws IOException, InterruptedException {
        /*
        started coding: 1.02
        ended coding: 2.37


        Unix file command which tells you what a file is: file name_of_the_file


         */
        int argc = args.length;

        System.out.println("We got " + argc + " arguments: "+ Arrays.toString(args));
        System.out.println("------");

        for(int i = 0; i < argc; i++){
            Checker api = new Checker(args[i]);
            if(api.getType().equals("NONE") || api.getUser_type().equals("NONE")){
                throw new IllegalArgumentException(api.getFile_name() +  " <- file doesn't exists or I don't have this extension in my db");
            }
            if(api.getEqual()){
                System.out.println(api.getFile_name() + " is " + api.getType() + " file");
            }else {
                System.out.println(api.getFile_name()+" <- Extension is " +  api.getUser_type() + " while actually it's: " + api.getType() + " file");
            }
            System.out.println("------");

        }


    }

}
