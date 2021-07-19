package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Checker {
    private final String file_name;
    private final String type;
    private final String user_type;
    private final boolean equal;

    public Checker(String file_name1) throws IOException, InterruptedException {
        file_name = file_name1;
        type = this.type_getter();
        user_type = this.user_type_getter();
        equal = this.type.equals(this.user_type);
    }
    private String user_type_getter(){
        String user_type = extract_type(file_name, ".");
        user_type = get_precise_type_user(user_type);
        return user_type;
    }
    private String type_getter() throws IOException, InterruptedException {
        Process p = Runtime.getRuntime().exec("file src/main/resources/" + this.file_name);
        BufferedReader br = new BufferedReader(
                new InputStreamReader(p.getInputStream()));
        String s;
        s = br.readLine();
        p.waitFor();
        p.destroy();

        String type2 = extract_type(s,":");


        type2 = get_precise_type(type2);

        return type2;
    }


    private static String extract_type(String s, String separator){
        String[] segments;
        if(separator.equals(".")){
            segments = s.split("\\.");
        }else{
            segments = s.split(separator);
        }

        if(segments.length == 0){
            throw new IllegalArgumentException("There is no .extension, pls add it, because I don't know what to do :,)");
        }
        segments[segments.length - 1] = segments[segments.length - 1].replaceAll("\\s+","");
        return segments[segments.length - 1];
    }

    private static String get_precise_type(String type){
        if(type.contains("empty") || type.contains("ASCII")){
            type = "TXT";
        }
        else if(type.contains("JPEG")){
            type = "JPEG";
        }
        else if(type.contains("GIF")){
            type = "GIF";
        }
        else{
            type = "NONE";
        }
        return type;
    }

    private static String get_precise_type_user(String type){
        if(type.contains("txt")){
            type = "TXT";
        }
        else if(type.contains("jpeg")){
            type = "JPEG";
        }
        else if(type.contains("gif")){
            type = "GIF";
        }
        else{
            type = "NONE";
        }
        return type;
    }

    // getters:
    public String getFile_name(){
        return this.file_name;
    }
    public String getType(){
        return this.type;
    }
    public String getUser_type(){
        return this.user_type;
    }

    public boolean getEqual(){
        return this.equal;
    }
}










