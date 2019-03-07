package sample.Logic;

public class CalculatorLogic {

    private Information information;

    public CalculatorLogic(Information info) {
        this.information = info;
    }

    public String getSolution() {

        if (information.getFrom() == 'd' && information.getTo() == 'd') {
            return dualToDual(information.getNumber());
        } else if (information.getFrom() == 'd' && information.getTo() == 'z') {
            return dualToDecimal(information.getNumber());
        } else if (information.getFrom() == 'd' && information.getTo() == 'o') {
            return dualToOctal(information.getNumber());
        } else if (information.getFrom() == 'd' && information.getTo() == 'h') {
            return dualToHex(information.getNumber());
        } else if (information.getFrom() == 'z' && information.getTo() == 'd') {
            return decimalToDual(information.getNumber());
        } else if (information.getFrom() == 'z' && information.getTo() == 'z') {
            return decimalToDecimal(information.getNumber());
        } else if (information.getFrom() == 'z' && information.getTo() == 'o') {
            return decimalToOctal(information.getNumber());
        } else if (information.getFrom() == 'z' && information.getTo() == 'h') {
            return decimalToHex(information.getNumber());
        } else if (information.getFrom() == 'o' && information.getTo() == 'd') {
            return octalToDual(information.getNumber());
        } else if (information.getFrom() == 'o' && information.getTo() == 'z') {
            return octalToDecimal(information.getNumber());
        } else if (information.getFrom() == 'o' && information.getTo() == 'o') {
            return octalToOctal(information.getNumber());
        } else if (information.getFrom() == 'o' && information.getTo() == 'h') {
            return octalToHex(information.getNumber());
        } else if (information.getFrom() == 'h' && information.getTo() == 'd') {
            return hexToDual(information.getNumber());
        } else if (information.getFrom() == 'h' && information.getTo() == 'z') {
            return hexToDecimal(information.getNumber());
        } else if (information.getFrom() == 'h' && information.getTo() == 'o') {
            return hexToOctal(information.getNumber());
        } else if (information.getFrom() == 'h' && information.getTo() == 'h') {
            return hexToHex(information.getNumber());
        } else {
            return "Error";
        }
    }

    private String octalToOctal(String input) {
        return input;
    }

    private String decimalToDecimal(String input) {
        return input;
    }

    private String dualToDual(String input) {
        return input;
    }

    private String hexToHex(String input) {
        return input;
    }


    private String dualToDecimal(String input) {
        return toDecimal(2, input);
    }

    private String dualToOctal(String input) {
        String bufferSolution = toDecimal(2, input);
        return decimalTo(8, bufferSolution);
    }

    private String dualToHex(String input) {
        String bufferSolution = toDecimal(2, input);
        return decimalTo(16, bufferSolution);
    }

    private String decimalToDual(String input) {
        return decimalTo(2, input);
    }

    private String decimalToOctal(String input) {
        return decimalTo(8, input);
    }

    private String decimalToHex(String input) {
        return decimalTo(16, input);
    }

    private String octalToDual(String input) {
        String bufferSolution = toDecimal(8, input);
        return decimalTo(2, bufferSolution);
    }

    private String octalToDecimal(String input) {
        return toDecimal(8, input);
    }

    private String octalToHex(String input) {
        String bufferSolution = toDecimal(8, input);
        return decimalTo(16, bufferSolution);
    }

    private String hexToDual(String input) {
        String bufferSolution = toDecimal(16, input);
        return decimalTo(2, bufferSolution);
    }

    private String hexToDecimal(String input) {
        return toDecimal(16, input);
    }

    private String hexToOctal(String input) {
        String bufferSolution = toDecimal(16, input);
        return decimalTo(8, bufferSolution);
    }

    private String toDecimal(int system, String input) {
        String inputBuffer = input;
        int[] number = new int[inputBuffer.length()];

        if (system == 16) {
            for (int i = input.length() - 1; i >= 0; i--) {

                if (inputBuffer.charAt(0) == 'A' || inputBuffer.charAt(0) == 'a') {
                    number[i] = 10;
                    inputBuffer = inputBuffer.substring(1);
                } else if (inputBuffer.charAt(0) == 'B' || inputBuffer.charAt(0) == 'b') {
                    number[i] = 11;
                    inputBuffer = inputBuffer.substring(1);
                } else if (inputBuffer.charAt(0) == 'C' || inputBuffer.charAt(0) == 'c') {
                    number[i] = 12;
                    inputBuffer = inputBuffer.substring(1);
                } else if (inputBuffer.charAt(0) == 'D' || inputBuffer.charAt(0) == 'd') {
                    number[i] = 13;
                    inputBuffer = inputBuffer.substring(1);
                } else if (inputBuffer.charAt(0) == 'E' || inputBuffer.charAt(0) == 'e') {
                    number[i] = 14;
                    inputBuffer = inputBuffer.substring(1);
                } else if (inputBuffer.charAt(0) == 'F' || inputBuffer.charAt(0) == 'f') {
                    number[i] = 15;
                    inputBuffer = inputBuffer.substring(1);
                } else {
                    number[i] = Character.getNumericValue(inputBuffer.charAt(0));
                    inputBuffer = inputBuffer.substring(1);
                }
            }
        }else{
            for (int i = input.length() - 1; i >= 0; i--) {
                number[i] = Character.getNumericValue(inputBuffer.charAt(0));
                inputBuffer = inputBuffer.substring(1);
            }
        }
        int solution = 0;

        for(int i = 0; i < number.length; i++){
            solution = solution + number[i] * power(system, i);
        }

        return Integer.toString(solution); 
    }

    private String decimalTo(int system, String input){
        int intInput = Integer.parseInt(input);
        String ergebnis;

        if(intInput/system == 0){
            if (system == 16) {
                return hexHelp(intInput);
            }
            return input;
        }else{
            String div = Integer.toString(intInput/system);
            String mod = modWithHex(system, intInput);
            ergebnis = decimalTo(system, div) + mod;
            return ergebnis;
        }
    }

    private int power(int base, int expo){
        int solution = 1;
        if(expo == 0){
            return solution;
        }else{
            for(int i = 1; i <= expo; i++){
                solution = solution*base;
            }
            return solution;
        }
    }

    private String modWithHex(int system, int input){
        if(system == 16){
            int mod;
            mod = input%system;

            return hexHelp(mod);
        }else{
            return Integer.toString(input%system);
        }
    }

    private String hexHelp(int hexNumber){
        switch (hexNumber){
            case 10:
                return "A";
            case 11:
                return "B";
            case 12:
                return "C";
            case 13:
                return "D";
            case 14:
                return "E";
            case 15:
                return "F";
        }

        return Integer.toString(hexNumber);
    }
}
