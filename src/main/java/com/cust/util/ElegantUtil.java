package com.cust.util;

import com.cust.domain.vo.ElegantUpdates;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;

public class ElegantUtil {

    String algorithm = "DESede";
    Key key;
    Cipher cipher;
    public static final String[] UPDATED = {"country","salesperson","product","supplier","customer","purbill","salebill"};

    public ElegantUtil() {
        try {
            key = KeyGenerator.getInstance(algorithm).generateKey();
            cipher = Cipher.getInstance(algorithm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        ElegantUtil z = new ElegantUtil();
        File xmlSavedFile = new File("c:/iConfig/alarmconfig/alarmconfig11.xml");
        String testString = z.readStringFromFile(xmlSavedFile);
        byte[] encryptionBytes = z.encrypt("Inderjit:pwd");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < encryptionBytes.length; i++) {
            if ((encryptionBytes[i] & 0xff) < 0x10) {
                sb.append("0");
            }
            sb.append(Long.toString(encryptionBytes[i] & 0xff, 16));
        }
        System.out.println("Encrypted : " + sb.toString());
        System.out.println("Recovered: " + z.decrypt(encryptionBytes));
    }

    public byte[] encrypt(String input) throws InvalidKeyException,
            BadPaddingException, IllegalBlockSizeException {
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] inputBytes = input.getBytes();
        return cipher.doFinal(inputBytes);
    }

    public String decrypt(byte[] encryptionBytes)
            throws InvalidKeyException, BadPaddingException,
            IllegalBlockSizeException {
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] recoveredBytes = cipher.doFinal(encryptionBytes);
        String recovered = new String(recoveredBytes);
        return recovered;
    }

    String readStringFromFile(File fileName) {
        String xmlReadFromFile = "";
        BufferedReader br = null;
        try {

            String sCurrentLine;

            br = new BufferedReader(new FileReader(fileName));

            while ((sCurrentLine = br.readLine()) != null) {
                xmlReadFromFile += sCurrentLine;
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return xmlReadFromFile;
    }
    public static ElegantUpdates createUpdateVO(String updated) {
        ElegantUpdates elegantUpdates = new ElegantUpdates();
        elegantUpdates.setID(0);
        if (updated==UPDATED[0]) elegantUpdates.setCountryUpdated(1);
        if (updated==UPDATED[1]) elegantUpdates.setSalesManUpdated(1);        
        if (updated==UPDATED[2]) elegantUpdates.setProductUpdated(1);
        if (updated==UPDATED[3]) elegantUpdates.setSupplierUpdated(1);
        if (updated==UPDATED[4]) elegantUpdates.setCustomerUpdated(1);
        if (updated==UPDATED[5]) elegantUpdates.setPurchaseUpdated(1);
        if (updated==UPDATED[6]) elegantUpdates.setSalesUpdated(1);
        return elegantUpdates;
    }
}
