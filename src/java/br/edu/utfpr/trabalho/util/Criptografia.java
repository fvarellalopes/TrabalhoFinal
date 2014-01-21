/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.utfpr.trabalho.util;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.BASE64Encoder;

public class Criptografia {
    
    public static String encripta(String senha) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.update(senha.getBytes());
            BASE64Encoder encoder = new BASE64Encoder();
            return encoder.encode(digest.digest());
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Criptografia.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}

