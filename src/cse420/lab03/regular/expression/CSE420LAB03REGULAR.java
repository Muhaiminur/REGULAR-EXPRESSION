/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse420.lab03.regular.expression;

/**
 *
 * @author 12301019
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
//import java.util.regex.Pattern;
public class CSE420LAB03REGULAR {
    static String[]reg;
    static String[]test;
    //static String[]regstar;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            BufferedReader br = new BufferedReader(new FileReader("REGULAR EXPRESSION INPUT.txt"));
            String line;
            reg=new String[Integer.parseInt(br.readLine())];
            //System.out.println("ok==="+reg.length);
            /*while ((line = br.readLine()) != null){
                //System.out.println(line);
                StringTokenizer st = new StringTokenizer(line);
                while (st.hasMoreElements()){
                    String s=(String)st.nextElement();
                    //System.out.println(s);
                }
            }*/
            for (int i = 0; i <reg.length; i++) {
                reg[i]=br.readLine();
                
                //System.out.println(reg[i]);
            }
            test=new String[Integer.parseInt(br.readLine())];
            for (int i = 0; i <test.length; i++) {
                test[i]=br.readLine();
                //System.out.println(test[i]);
            }
            
            for (int i = 0; i < reg.length; i++) {
                String regstars="regstar"+(i+1);
                String[]regstar=star(reg[i]);
                String[]regplus=plus(reg[i]);
                System.out.println("====="+regstars+"====");
                for (int j = 0; j < regstar.length; j++) {
                    System.out.println(regstar[j]);
                    System.out.println(regplus[j]);
                }
                
            }
            for (int i = 0; i < test.length; i++) {
                System.out.println(check(test[i]));
                
            }
            //match("xabh");
        } catch (Exception e) {
        }
    }
    public static void checkstar(String[] ss,String s,String n){
        
    }
    public static String[] star(String s){
        ArrayList<String> ss = new ArrayList<String>();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if(charArray[i]=='*'){
                String s2="";
                for (int j = i+1; j < charArray.length; j++) {
                    if(charArray[j]=='('||charArray[j]==')'||charArray[j]=='+'||charArray[j]=='?'||charArray[j]=='['||charArray[j]==']'||charArray[j]=='-'||charArray[j]=='^'||charArray[j]=='*'){
                        
                    }else{
                        s2=s2+Character.toString(charArray[j]);
                    }
                    
                    
                }
                ss.add(Character.toString(charArray[i-1])+s2);
                ss.add(s2);
            }
        }
        String[] stringArray = ss.toArray(new String[0]);
        return stringArray;
    }
    public static String[] plus(String s){
        ArrayList<String> ss = new ArrayList<String>();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if(charArray[i]=='+'){
                String s2="";
                for (int j = i+1; j < charArray.length; j++) {
                    if(charArray[j]=='('||charArray[j]==')'||charArray[j]=='+'||charArray[j]=='?'||charArray[j]=='['||charArray[j]==']'||charArray[j]=='-'||charArray[j]=='^'||charArray[j]=='*'){
                        
                    }else{
                        s2=s2+Character.toString(charArray[j]);
                    }
                    
                    
                }
                ss.add(Character.toString(charArray[i-1])+s2);
                ss.add(s2);
            }
        }
        String[] stringArray = ss.toArray(new String[0]);
        return stringArray;
    }
    public static String[] que(String s){
        ArrayList<String> ss = new ArrayList<String>();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if(charArray[i]=='?'){
                String s2="";
                for (int j = i+1; j < charArray.length; j++) {
                    if(charArray[j]=='('||charArray[j]==')'||charArray[j]=='+'||charArray[j]=='?'||charArray[j]=='['||charArray[j]==']'||charArray[j]=='-'||charArray[j]=='^'||charArray[j]=='*'){
                        
                    }else{
                        s2=s2+Character.toString(charArray[j]);
                    }
                    
                    
                }
                ss.add(Character.toString(charArray[i-1])+s2);
                ss.add(s2);
            }
        }
        String[] stringArray = ss.toArray(new String[0]);
        return stringArray;
    }
    public static void match(String s){
        String regex = "[a-c]{3}cab+(da)*f";
        //boolean isMatch = Pattern.matches(regex,"dbbbbamkgh");
        //System.out.println(isMatch);
    }
    public static String check(String s){
        boolean isMatch=false;
        for (int i = 0; i < reg.length; i++) {
            String regex =reg[i];
            //isMatch = Pattern.matches(regex,s);
            if (isMatch){
                return "yes"+(i+1);
            }
        }
        return "no0";
    }
    
}