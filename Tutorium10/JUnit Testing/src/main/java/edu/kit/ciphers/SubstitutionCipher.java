package edu.kit.ciphers;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class SubstitutionCipher extends Cipher<CharSequence, Map<Character, Character>>{
    private static final String INVALID_SUBSTITUTE_LENGTH = "You have to provide a subsitution for each base Character";

    public SubstitutionCipher(Map<Character, Character> key) {
        super(key);
    }

    public static SubstitutionCipher fromKeyAlphabet(String base, String substitutes) {
        Objects.requireNonNull(base);
        Objects.requireNonNull(substitutes);

        var baseChars = base.toCharArray();
        var substitueChars = substitutes.toCharArray();

        if(baseChars.length != substitueChars.length)
            throw new IllegalArgumentException(INVALID_SUBSTITUTE_LENGTH);

        var map = new HashMap<Character, Character>();

        for(int i = 0; i < baseChars.length; i++)
            map.put(baseChars[i], substitueChars[i]);
        return new SubstitutionCipher(map);
    }

    @Override
    CharSequence cipher(CharSequence input) {
        return substitute(input, key);
    }

    private String substitute(CharSequence input, Map<Character, Character> subitutions) {
        return input
                .chars()
                .mapToObj(c -> (char) c)
                .map(c -> subitutions.getOrDefault(c,c))
                .map(Object::toString)
                .collect(Collectors.joining());
    }

    @Override
    CharSequence decipher(CharSequence code) {
        return substitute(code, getInvertedSubstitutions());
    }

    private Map<Character, Character> getInvertedSubstitutions() {
        var inverted = new HashMap<Character, Character>();
        for(var entry : key.entrySet()){
            inverted.put(entry.getValue(), entry.getKey());
        }
        return inverted;
    }
}
