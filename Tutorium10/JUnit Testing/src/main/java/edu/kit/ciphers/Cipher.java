package edu.kit.ciphers;

public abstract class Cipher<T, K> {
    public void setKey(K key) {
        this.key = key;
    }
    protected K key;
    public Cipher(K key) {
        this.key = key;
    }
    abstract T cipher(T input);
    abstract T decipher(T code);
}
