public class Rotor {

    
    private String rotorValues;
    private char startChar;
        
    public Rotor(String v, char c){
        this.rotorValues = new String(v);
        this.startChar = c;
        
        while(!this.rotate());
            
    }
    
    public boolean rotate(){
        char[] rotorChars = new char[rotorValues.length()];
        char temp = rotorChars[0];

        for (int i = 0; i < rotorChars.length - 1; i++) {
            rotorChars[i] = rotorChars[i+1];
        }

        rotorChars[0] = temp;
        rotorValues = String.valueOf(rotorChars);

        if (temp == startChar) {
            return true;
        } else {
            return false;
        }

            
    }
    

    public int indexOf(char c){
        for (int i = 0; i < rotorValues.length(); i++) {
            if (rotorValues.charAt(i) == c) {
                return i;
            }
        }

        return -1;
    }

    public char charAt(int idx){
        return rotorValues.charAt(idx);
    }
}
    
