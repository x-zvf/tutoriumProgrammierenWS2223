package edu.kit.ciphers;

import java.util.stream.Collectors;

public class CaesarCipher extends Cipher<CharSequence, Integer> {

    private static final int alphabetLength = 26;

    public CaesarCipher(Integer key) {
        super(key);
    }

    @Override
    CharSequence cipher(CharSequence input) {
        return rotateString(this.key, input);
    }

    @Override
    CharSequence decipher(CharSequence code) {
        return rotateString(-this.key, code);
    }

    private CharSequence rotateString(int amount, CharSequence chipherString) {
        return chipherString
                .chars()
                .mapToObj(c -> (char) c)
                .map(c -> rotateCharacter(c, amount))
                .map(Object::toString)
                .collect(Collectors.joining());
    }

    private char rotateCharacter(char toRotate, int amount) {
        if (toRotate >= 'a' && toRotate <= 'z')
            return rotateFrom(toRotate, amount,'a');
        if (toRotate >= 'A' && toRotate <= 'Z')
            return rotateFrom(toRotate, amount,'A');
        return toRotate;
    }

    private char rotateFrom(char toRotate, int amount, char base) {
        // 2 modulus necessary for negative numbers
        return (char) (((((toRotate - base + amount) % alphabetLength) + alphabetLength) % alphabetLength) + base);
    }
}
