package CipherSolver.AES;
import java.security.SecureRandom;

public class AESKey {
    public final byte[] data;
    public final KeySize keySize;

    public AESKey(KeySize keySize){
        this.keySize = keySize;
        data = new byte[keySize.getWords() * AES.WORD_SIZE];
        randomise();
    }
    public AESKey(KeySize keySize, String keyFormatted){
        this.keySize = keySize;
        data = new byte[keySize.getWords() * AES.WORD_SIZE];
        for (int i = 0; i < keySize.getWords() * AES.WORD_SIZE; i++)
            data[i] = (byte) (16 * AES.hexToDecimal(keyFormatted.charAt(i * 2)) + AES.hexToDecimal(keyFormatted.charAt(i * 2 + 1)));
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < AES.WORD_SIZE * keySize.getWords(); i++)
            stringBuilder.append(AES.decimalToHex(data[i]));
        return stringBuilder.toString();
    }
    public void randomise(){
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(data);
    }
}