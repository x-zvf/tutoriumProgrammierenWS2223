package edu.kit.ciphers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubstitutionCipherTest {
    private static final String PLAIN_TEXT = "abcXYZ1!";
    private static final String CIPHER_TEXT = "QbcaYZ2?";
    private static final String BASE = "aX1!";
    private static final String SUBSTITUTE = "Qa2?";

    private static final String INVALID_SUBSITUTE = "invalid";



    private SubstitutionCipher cipher;
    @BeforeEach
    void setUp() {
        cipher = SubstitutionCipher.fromKeyAlphabet(BASE, SUBSTITUTE);
    }

    @Test
    void fromKeyAlphabet() {
        assertThrows(NullPointerException.class, () -> SubstitutionCipher.fromKeyAlphabet(null,null));
        assertThrows(IllegalArgumentException.class, () -> SubstitutionCipher.fromKeyAlphabet(BASE, INVALID_SUBSITUTE));
    }

    @Test
    void cipher() {
        assertEquals(CIPHER_TEXT, cipher.cipher(PLAIN_TEXT));

    }

    @Test
    void decipher() {
        assertEquals(PLAIN_TEXT, cipher.decipher(CIPHER_TEXT));
    }
}