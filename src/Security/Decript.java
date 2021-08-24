package Security;

public class Decript {
    static int i,remove = 0;
    static char character;
    static String decript = "", characters = "";
    
    static String decrypt(String message){

        characters = "";
        decript = "";

        int length = message.length()-1;

        characters = ""+message.charAt(length/2);

        remove = Integer.parseInt(characters);
        message = getEncriptedString(message, length/2);
//        System.out.println(getEncriptedString(message, length/2));
        
        for(i = 0; i <= message.length() - 1; i++){

            character = message.charAt(i);
            character -= remove;
            decript = decript+""+character;
        }
        
        return decript;
    }
    
    static String getEncriptedString(String str, int index){
        return str.substring(0, index) + str.substring(index + 1);  
    }
    
    public static void main(String args[]){;
        System.out.println(decrypt("uuffxx5||twwii"));
    }
}
