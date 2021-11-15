package encryptdecrypt.algorythms;

public class ShiftingAlgorythm implements Algorythm {

    private static final int ALPHABET_SIZE = 26;

    @Override
    public String encrypt(String str, int key) {
        StringBuilder sb = new StringBuilder();
        char ch;
        int offset;
        for (int i = 0; i < str.length(); i++) {

            ch = str.charAt(i);

            if (Character.isLetter(ch)) {
                offset = key % ALPHABET_SIZE;

                if (Character.isLowerCase(ch)) {
                    int originalAlphabetPosition = ch - 'a';
                    int newAlphabetPosition = (originalAlphabetPosition + offset) % 26;
                    char newCharacter = (char) ('a' + newAlphabetPosition);
                    sb.append(newCharacter);
                } else {
                    int originalAlphabetPosition = ch - 'A';
                    int newAlphabetPosition = (originalAlphabetPosition + offset) % 26;
                    char newCharacter = (char) ('A' + newAlphabetPosition);
                    sb.append(newCharacter);
                }

            } else {
                sb.append(ch);
            }

        }
        return sb.toString();
    }

    @Override
    public String decrypt(String str, int key) {
        int offset = key % ALPHABET_SIZE;
        return encrypt(str, 26 - (offset % 26));
    }
}
