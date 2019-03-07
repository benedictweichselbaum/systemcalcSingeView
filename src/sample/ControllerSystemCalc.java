package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.Logic.CalculatorLogic;
import sample.Logic.Information;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerSystemCalc implements Initializable {

    @FXML
    private RadioButton rbTOctal;

    @FXML
    private RadioButton rbTDual;

    @FXML
    private RadioButton rbTDecimal;

    @FXML
    private RadioButton rbTHex;

    @FXML
    private RadioButton rbFDecimal;

    @FXML
    private TextField txtNumber;

    @FXML
    private Menu aboutMB;

    @FXML
    private MenuItem informationenMBUM;

    @FXML
    private RadioButton rbFHex;

    @FXML
    private RadioButton rbFDual;

    @FXML
    private MenuBar menuBar;

    @FXML
    private TextField txtSolution;

    @FXML
    private Button btnCalc;

    @FXML
    private RadioButton rbFOctal;

    @FXML
    private Label lblPic;

    private ToggleGroup group2;
    private ToggleGroup group1;
    private Information information;
    private CalculatorLogic calculatorLogic;

    @Override
    @SuppressWarnings(value = "all")
    public void initialize(URL location, ResourceBundle resources) {

        group1 = new ToggleGroup();
        rbFDecimal.setToggleGroup(group1);
        rbFDual.setToggleGroup(group1);
        rbFHex.setToggleGroup(group1);
        rbFOctal.setToggleGroup(group1);

        group2 = new ToggleGroup();
        rbTDecimal.setToggleGroup(group2);
        rbTDual.setToggleGroup(group2);
        rbTHex.setToggleGroup(group2);
        rbTOctal.setToggleGroup(group2);

        initLablePic();
    }

    @FXML
    void about(ActionEvent event) {

    }

    @FXML
    void calculate(ActionEvent event) {
        try {
            transferCurrentInformation();
        }catch (Exception e){
            System.out.println("Ein Fehler in transferCurrentInformation()");
        }

        calculatorLogic = new CalculatorLogic(information);

        txtSolution.setText(calculatorLogic.getSolution());
    }

    private void initLablePic(){
        Image image = new Image(getClass().getResourceAsStream("numbers.png"));
        lblPic.setGraphic(new ImageView(image));
    }

    private void transferCurrentInformation() throws Exception{
        information = new Information();

        RadioButton rbFrom = (RadioButton) group1.getSelectedToggle();
        RadioButton rbTo = (RadioButton) group2.getSelectedToggle();

        String fromID = rbFrom.getId();
        String toID = rbTo.getId();

        switch (fromID){
            case "rbFDual":
                information.setFrom('d');
                break;
            case "rbFDecimal":
                information.setFrom('z');
                break;
            case "rbFOctal":
                information.setFrom('o');
                break;
            case "rbFHex":
                information.setFrom('h');
                break;
            default:
                throw new Exception();
        }

        switch (toID){
            case "rbTDual":
                information.setTo('d');
                break;
            case "rbTDecimal":
                information.setTo('z');
                break;
            case "rbTOctal":
                information.setTo('o');
                break;
            case "rbTHex":
                information.setTo('h');
                break;
            default:
                throw new Exception();
        }

        information.setNumber(txtNumber.getText());
    }

}

