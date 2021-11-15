package encryptdecrypt.algorythms;

public interface Algorythm {
    String encrypt(String str, int key);
    String decrypt(String str, int key);
}
