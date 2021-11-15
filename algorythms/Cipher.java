package encryptdecrypt.algorythms;

public class Cipher {

    private Algorythm algorythm;

    public void setAlgorythm(Algorythm algorythm) {
        this.algorythm = algorythm;
    }

    public String encrypt(String str, int key) {
        return algorythm.encrypt(str, key);
    }

    public String decrypt(String str, int key) {
        return algorythm.decrypt(str, key);
    }

}
