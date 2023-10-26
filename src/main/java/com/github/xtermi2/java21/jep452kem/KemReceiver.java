package com.github.xtermi2.java21.jep452kem;

import javax.crypto.DecapsulateException;
import javax.crypto.KEM;
import javax.crypto.SecretKey;
import java.security.*;
import java.util.Base64;

public class KemReceiver {

    private final KeyPair kp;
    private String lastReceivedSecret;

    public KemReceiver() throws NoSuchAlgorithmException {
        KeyPairGenerator g = KeyPairGenerator.getInstance("X25519");
        kp = g.generateKeyPair();
    }

    public void receiveMsg(byte[] encapsulation, String algorithm) throws NoSuchAlgorithmException, InvalidKeyException, DecapsulateException {
        KEM kem = KEM.getInstance(algorithm);
        final KEM.Decapsulator decapsulator = kem.newDecapsulator(kp.getPrivate());
        final SecretKey secret = decapsulator.decapsulate(encapsulation);
        lastReceivedSecret = Base64.getEncoder().encodeToString(secret.getEncoded());
    }

    public PublicKey getPublicKey() {
        return kp.getPublic();
    }

    public String getLastReceivedSecret() {
        return lastReceivedSecret;
    }
}
