package com.github.xtermi2.java21.jep452kem;

import javax.crypto.DecapsulateException;
import javax.crypto.KEM;
import javax.crypto.SecretKey;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class KemSender {

    /**
     * DH-Based KEM as defined in RFC 9180.
     * <a href="https://docs.oracle.com/en/java/javase/21/docs/specs/security/standard-names.html#kem-algorithms">available kem-algorithms</a>
     */
    public static final String KEM_ALGORITHM = "DHKEM";
    private final KemReceiver receiver;
    private String lastSendSecret;

    public KemSender(KemReceiver receiver) {
        this.receiver = receiver;
    }

    public void sendSecretToReceiver() throws NoSuchAlgorithmException, InvalidKeyException, DecapsulateException {
        KEM kem = KEM.getInstance(KEM_ALGORITHM);
        KEM.Encapsulator sender = kem.newEncapsulator(receiver.getPublicKey());
        KEM.Encapsulated encapsulated = sender.encapsulate();
        final SecretKey secret = encapsulated.key();

        receiver.receiveMsg(encapsulated.encapsulation(), kem.getAlgorithm());

        lastSendSecret = Base64.getEncoder().encodeToString(secret.getEncoded());
    }

    public String getLastSendSecret() {
        return lastSendSecret;
    }
}
