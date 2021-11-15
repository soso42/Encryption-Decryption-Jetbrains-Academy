package encryptdecrypt.algorythms;

public class UnicodeAlgorythm implements Algorythm {

    @Override
    public String encrypt(String str, int key) {
        StringBuilder sb = new StringBuilder();
        char ch;
        for (int i = 0; i < str.length(); i++) {
            ch = (char)(str.charAt(i) + key);
            sb.append(ch);
        }
        return sb.toString();
    }

    @Override
    public String decrypt(String str, int key) {
        StringBuilder sb = new StringBuilder();
        char ch;
        for (int i = 0; i < str.length(); i++) {
            ch = (char)(str.charAt(i) - key);
            sb.append(ch);
        }
        return sb.toString();
    }
}
