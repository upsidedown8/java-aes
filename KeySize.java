package CipherSolver.AES;

public enum KeySize {
    AES128{
        public int getWords(){
            return 4;
        }
    },
    AES192{
        public int getWords(){
            return 6;
        }
    },
    AES256{
        public int getWords(){
            return 8;
        }
    };

    public abstract int getWords();
}
