public class Enigma{

    private String rotorInit[] = {"#GNUAHOVBIPWCJQXDKRYELSZFMT",
        "#EJOTYCHMRWAFKPUZDINSXBGLQV",
        "#BDFHJLNPRTVXZACEGIKMOQSUWY",
        "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
        "#TGOWHLIFMCSZYRVXQABUPEJKND"};


    private Rotor rotors[];
        
    public Enigma(int id1, int id2, int id3, String start){

        rotors = new Rotor[3];
        rotors[0] = new Rotor(rotorInit[id1-1], start.charAt(0));
        rotors[1] = new Rotor(rotorInit[id2-1], start.charAt(1));
        rotors[2] = new Rotor(rotorInit[id3-1], start.charAt(2));
        
    }


    public String decrypt(String message){        
        //Find the character on the outer rotor
        String result = "";

        for (int i = 0; i < message.length(); i++) {
            char current = message.charAt(i);
            int outerIdx = rotors[2].indexOf(current);

            char middleLetter = rotors[1].charAt(outerIdx);
            int outerIdx2 = rotors[2].indexOf(middleLetter);
            char finalLetter = rotors[0].charAt(outerIdx2);

            result += finalLetter;

            rotate();

        }
        return result;
        // note the character aligned with it on the middle rotor
        // find that character on the outer rotor 
        // then output the character aligned with it on the inner rotor. 
    }


    
    public String encrypt(String message){
        // find current letter on innermost ring
        String result = "";

        for (int i = 0; i < message.length(); i++) {
            char current = message.charAt(i);
            int innerIdx = rotors[0].indexOf(current);
            char outerLetter = rotors[2].charAt(innerIdx);

            int middleIdx = rotors[1].indexOf(outerLetter);
            char finalLetter = rotors[2].charAt(middleIdx);

            result += finalLetter;

            rotate();


        }
        return result;
        // find letter on outer ring above current letter
        // find letter on outer ring in the middle ring
        // find letter above letter in the middle ring
    }

    
    private void rotate(){
        if(rotors[0].rotate()){
            if(rotors[1].rotate()){
                rotors[2].rotate();
            }
        }
    }
    
}
