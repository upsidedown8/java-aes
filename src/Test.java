package CipherSolver.AES;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Key standard: AES");
        int keyStandard = scanner.nextInt();
        KeySize keySize = keyStandard == 128 ? KeySize.AES128 : (keyStandard == 192 ? KeySize.AES192 : KeySize.AES256);
        AES aes = new AES(keySize);
        AESKey aesKey = new AESKey(keySize);
        System.out.println("Standard: AES" + keyStandard);
        System.out.println("Key: " + aesKey);

        while(true){
            for (int i = 0; i < 80; i++)
                System.out.print('=');
            System.out.print("\n[E]ncrypt or [D]ecrypt: ");
            boolean isEncrypt = Character.toUpperCase(scanner.next().charAt(0)) == 'E';

            String terminate = "{END}";
            System.out.print("Enter " + (isEncrypt ? "plaintext" : "ciphertext") + " (Terminate with " + terminate + "): ");
            StringBuilder input = new StringBuilder(); String line = scanner.nextLine();
            while(!line.equals(terminate)){
                input.append(line).append('\n');
                line = scanner.nextLine();
            }
            String inputText = input.toString().replace("\\n", "\n");
            String outputText = isEncrypt ? aes.encrypt(inputText, aesKey) : aes.decrypt(inputText, aesKey);
            System.out.println("\n" + (isEncrypt ? "Ciphertext" : "Plaintext") + ": " + outputText);
        }
    }

    static void outputWord(Word word){
        System.out.print(word.toString());
    }
    static void outputRoundKeys(Word[] rKeys, KeySize keySize){
        for (int round = 0; round < keySize.getWords() + 7; round++) {
            System.out.print("Round: "+ (round < 10 ? "0" : "") + round + " ");
            for (int word = 0; word < 4; word++) {
                outputWord(rKeys[round*4+word]);
                if (word < 3)
                    System.out.print(", ");
            }
            System.out.println();
        }
    }
}
