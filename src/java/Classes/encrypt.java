package Classes;

import Classes.e;

public class encrypt {

    public static void main(String[] args) throws Exception {

        String password = "mypassword";
        String passwordEnc = e.encrypt(password);
        String passwordDec = e.decrypt(passwordEnc);

        System.out.println("Plain Text : " + password);
        System.out.println("Encrypted Text : " + passwordEnc);
        System.out.println("Decrypted Text : " + passwordDec);
    }
}