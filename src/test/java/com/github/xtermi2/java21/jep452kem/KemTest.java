package com.github.xtermi2.java21.jep452kem;

import org.junit.jupiter.api.Test;

import javax.crypto.DecapsulateException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static org.assertj.core.api.Assertions.assertThat;

class KemTest {
    @Test
    void send_and_receive_secret() throws NoSuchAlgorithmException, DecapsulateException, InvalidKeyException {
        final KemReceiver receiver = new KemReceiver();
        final KemSender sender = new KemSender(receiver);

        sender.sendSecretToReceiver();

        System.out.println(STR."secret='\{sender.getLastSendSecret()}'");

        assertThat(sender.getLastSendSecret())
                .as("send secret and received secret should be equals")
                .isEqualTo(receiver.getLastReceivedSecret())
                .isNotBlank();
    }
}