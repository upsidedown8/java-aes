package CipherSolver.AES;

public class Word {
    byte[] bytes;

    public Word(){
        bytes = new byte[4];
    }
    public Word(byte b0, byte b1, byte b2, byte b3){
        this.bytes = new byte[4];
        setBytes(b0, b1, b2, b3);
    }
    public Word(Word word){
        this.bytes = new byte[4];
        this.bytes[0] = word.bytes[0];
        this.bytes[1] = word.bytes[1];
        this.bytes[2] = word.bytes[2];
        this.bytes[3] = word.bytes[3];
    }

    public Word copy(){
        return new Word(this);
    }
    public void setBytes(byte b0, byte b1, byte b2, byte b3){
        this.bytes[0] = b0;
        this.bytes[1] = b1;
        this.bytes[2] = b2;
        this.bytes[3] = b3;
    }
    public Word xorWith(Word w){
        Word tempWord = new Word();
        tempWord.setBytes(
            (byte)((this.bytes[0] & 0xFF) ^ (w.bytes[0] & 0xFF)),
            (byte)((this.bytes[1] & 0xFF) ^ (w.bytes[1] & 0xFF)),
            (byte)((this.bytes[2] & 0xFF) ^ (w.bytes[2] & 0xFF)),
            (byte)((this.bytes[3] & 0xFF) ^ (w.bytes[3] & 0xFF))
        );
        return tempWord;
    }
}
