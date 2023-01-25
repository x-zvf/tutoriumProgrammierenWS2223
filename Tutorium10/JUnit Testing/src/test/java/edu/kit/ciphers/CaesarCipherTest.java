package edu.kit.ciphers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CaesarCipherTest {
    private static final String PLAIN_TEXT = "abcXYZ1!";
    private static final String CIPHER_TEXT = "fghCDE1!";
    private static final int KEY = 5;

    private CaesarCipher caesarCipher;
    @BeforeEach
    void setup() {
        caesarCipher = new CaesarCipher(KEY);
    }
    @Test
    void testCipher() {
        assertEquals(CIPHER_TEXT, caesarCipher.cipher(PLAIN_TEXT));
    }
    @Test
    void testDecipher() {
        assertEquals(PLAIN_TEXT, caesarCipher.decipher(CIPHER_TEXT));
    }
    @Test
    void testIdentity() {
        caesarCipher.setKey(0);
        assertEquals(PLAIN_TEXT, caesarCipher.cipher(PLAIN_TEXT));
        assertEquals(CIPHER_TEXT, caesarCipher.decipher(CIPHER_TEXT));
    }
}