package Security;
import javax.swing.JTextField;

public class Generator {
    
    public static String encryptor(String encryptedstring){
        
        return Encript.encrypteme(encryptedstring);
    }
    
    public static String decryptor(String dencryptedstring){
        return Decript.decrypt(dencryptedstring);
    }

    public static void main(String[] args) {
    }
}
