package sample.Logic;

public class CalculatorLogic {

    private Information information;

    public CalculatorLogic(Information info){
        this.information = info;
    }

    public String getSolution(){
        if(information.getFrom() == 'd' && information.getTo() == 'd'){
            return dualToDual(information.getNumber());
        }else if(information.getFrom() == 'd' && information.getTo() == 'z'){
            return dualToDecimal(information.getNumber());
        }else if(information.getFrom() == 'd' && information.getTo() == 'o'){
            return dualToOctal(information.getNumber());
        }else if(information.getFrom() == 'd' && information.getTo() == 'h'){
            return dualToHex(information.getNumber());
        }else if(information.getFrom() == 'z' && information.getTo() == 'd'){
            return decimalToDual(information.getNumber());
        }else if(information.getFrom() == 'z' && information.getTo() == 'z'){
            return decimalToDecimal(information.getNumber());
        }else if(information.getFrom() == 'z' && information.getTo() == 'o'){
            return decimalToOctal(information.getNumber());
        }else if(information.getFrom() == 'z' && information.getTo() == 'h'){
            return decimalToHex(information.getNumber());
        }else if(information.getFrom() == 'o' && information.getTo() == 'd'){
            return octalToDual(information.getNumber());
        }else if(information.getFrom() == 'o' && information.getTo() == 'z'){
            return octalToDecimal(information.getNumber());
        }else if(information.getFrom() == 'o' && information.getTo() == 'o'){
            return octalToOctal(information.getNumber());
        }else if(information.getFrom() == 'o' && information.getTo() == 'h'){
            return octalToHex(information.getNumber());
        }else if(information.getFrom() == 'h' && information.getTo() == 'd'){
            return hexToDual(information.getNumber());
        }else if(information.getFrom() == 'h' && information.getTo() == 'z'){
            return hexToDecimal(information.getNumber());
        }else if(information.getFrom() == 'h' && information.getTo() == 'o'){
            return hexToOctal(information.getNumber());
        }else if(information.getFrom() == 'h' && information.getTo() == 'h'){
            return hexToHex(information.getNumber());
        }else{
            return "Error";
        }
    }

    private String octalToOctal(String input){
        return input;
    }

    private String decimalToDecimal(String input){
        return input;
    }

    private String dualToDual(String input){
        return input;
    }

    private String hexToHex(String input){
        return input;
    }



    private String dualToDecimal(String input){

    }

    private String dualToOctal(String input){
        return input;
    }

    private String dualToHex(String input){
        return input;
    }

    private String decimalToDual(String input){
        return input;
    }

    private String decimalToOctal(String input){
        return input;
    }

    private String decimalToHex(String input){
        return input;
    }

    private String octalToDual(String input){
        return input;
    }

    private String octalToDecimal(String input){
        return input;
    }

    private String octalToHex(String input){
        return input;
    }

    private String hexToDual(String input){
        return input;
    }

    private String hexToDecimal(String input){
        return input;
    }

    private String hexToOctal(String input){
        return input;
    }

    private String toDecimal(int system, String input){
        int[] number = new int[input.length()];

        for(int i = 0; i < input.length(); i++){
            number[i] = input.charAt(0);
            input = input.substring(1);
        }

        int solution = 0;

        for(int i = 0; i < number.length; i++){
            solution = solution + number[i] * system^i;
        }

        return Integer.toString(solution); 
    }
}
