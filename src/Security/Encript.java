package Security;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Encript {
    static Random random = new Random();
    static int i= 0 ,incrementer = 0 ,length, detecter;
    static char character, c, c1;
    static String encripted = "",finalMessage;
    
    static String encrypteme(String message) {
        encripted = "";
        detecter = random.nextInt(20);
        incrementer = random.nextInt(9);

        for(i = 0; i <= message.length() - 1; i++){
            character = message.charAt(i);
            character += incrementer;
            encripted = encripted+""+character;
        }

        if(encripted.equals(message))
            encrypteme(message);
            
        
        length = message.length() / 2;
        int length2 = message.length() / 4;

        
        if(incrementer == 0)
            encrypteme(message);
        c = (char)(incrementer+'0');
        
        
        if(!Character.isDigit(c) ){
            System.out.println("if in C :- "+c);
            encrypteme(message);
        }

        else{
//            System.out.println("if out C :- "+c);



//            addChar(encripted, c, length);
            
//            c1 = '4';
//            addChar(encripted, c1, length - 1);
//            c1 = '5';
//            addChar(encripted, c1, length + 1);

//            System.out.println(length - length2);
            
//            char insertDigit = 'a';
//            
//            while(!Character.isDigit(insertDigit)){
//                insertDigit = (char)(random.nextInt(20)+'0');
//                System.out.println(insertDigit);
//            }
//            
//            if(Integer.parseInt(""+c)%2 == 0)
//                return addChar(encripted, c, length - length2);
//            else
//                return addChar(encripted, c, length + length2);
            ///addChar(encripted, c1, length + 1)
        }  
        return addChar(encripted, c, length);
    }
    
    static boolean checkChar(String str){
        Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(str);
        return m.find();
    }
    
    static String addChar(String str, char ch, int position) {
    /*
        *****************************************************************************************************
            int len = str.length();
            char[] updatedArr = new char[len + 1];
            str.getChars(0, position, updatedArr, 0);
            updatedArr[position] = ch;
            str.getChars(position, len, updatedArr, position + 1);
            return new String(updatedArr);
        
        *****************************************************************************************************/
            str = str.substring(0, position).toString() + ch + str.substring(position).toString();
//            System.out.println(str);
            return str;
        /*****************************************************************************************************
            
            public String addChar(String str, char ch, int position) {
            StringBuilder sb = new StringBuilder(str);
            sb.insert(position, ch);
            return sb.toString();
}
        *****************************************************************************************************
    */   
        
//        StringBuilder sb = new StringBuilder(str);
//        sb.insert(position, ch);
//        finalMessage = sb.toString();
//        System.out.println("Encrepted :- "+finalMessage);
////        System.out.println("Decripted msg is :- "+Decript.decript(finalMessage));
//        
//        return finalMessage;
    }
    
    
    static char covertChar(int number){
        char character =(char)(number+'0');
        System.out.println(character);
        if(!Character.isDigit(character)){
            covertChar(number);
        }
        return character;
    }
    
    
    static int getPosition(int number){
        if(number %2 == 0)
            return number / 2;
        else
            return number + 2; // shold check length of string then add 
    }
    
    public static void main(String args[]){
        System.out.println(encrypteme("tech Mahindra"));
        
//        System.out.println(covertChar(9));
    }
}
