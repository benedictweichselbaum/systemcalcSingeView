package sample.Logic;

public class ExceptionHandler {

    Information information;

    public ExceptionHandler(Information info){
        this.information = info;
    }

    public String checkErrors(){
        String number = information.getNumber();
        char system = information.getFrom();

        switch (system){
            case 'd':
                return checkBySystem(number, 'd', "01");
            case 'z':
                return checkBySystem(number, 'z', "0123456789");
            case 'o':
                return checkBySystem(number, 'o', "01234567");
            case 'h':
                return checkBySystem(number, 'h', "0123456789ABCDEFabcdef");
            default:
                return "Es ist ein unbekannter Fehler aufgetreten";
        }
    }

    private String checkBySystem(String number, char system, String abc){
        String bufferNumber = number;
        String[] numberToArray = new String[number.length()];

        for(int i = 0; i < number.length(); i++){
            numberToArray[i] = Character.toString(bufferNumber.charAt(0));
            bufferNumber = bufferNumber.substring(1);
        }

        for(String c: numberToArray){
            if(!abc.contains(c))
                return errorBySystem(system);
        }

        return "";
    }

    private String errorBySystem(char system){
        switch (system){
            case 'd':
               return "Die eingegebene Zahl ist keine Dualzahl";
            case 'z':
                return "Die eingegebene Zahl ist keine Dezimalzahl";
            case 'o':
                return "Die eingegebene Zahl ist keine Oktalzahl";
            case 'h':
                return "Die eingegebene Zahl ist keine Hexadezimalzahl";
            default:
                return "Es ist ein unbekannter Fehler aufgetreten";
        }
    }
}
