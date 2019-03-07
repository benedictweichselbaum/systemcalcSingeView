package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.About.AboutFrame;
import sample.Logic.CalculatorLogic;
import sample.Logic.ExceptionHandler;
import sample.Logic.Information;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Copyright Benedict Weichselbaum
 */

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

    @FXML
    private Label lblHint;

    private ToggleGroup group2;
    private ToggleGroup group1;
    private Information information;
    private AboutFrame aboutFrame;

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
    void calculate(ActionEvent event) {
        txtSolution.setText("");
        try {
            transferCurrentInformation();
        }catch (Exception e){
            System.out.println("Ein Fehler in transferCurrentInformation()");
            return;
        }

        CalculatorLogic calculatorLogic = new CalculatorLogic(information);
        ExceptionHandler exceptionHandler = new ExceptionHandler(information);

        String checkSystemException = exceptionHandler.checkErrors();
        lblHint.setText(checkSystemException);

        if(checkSystemException != "")
            return;
        txtSolution.setText(calculatorLogic.getSolution());
    }

    private void initLablePic(){
        Image image = new Image(getClass().getResourceAsStream("numbers.png"));
        lblPic.setGraphic(new ImageView(image));
    }

    private void transferCurrentInformation() throws Exception{
        information = new Information();
        String fromID;
        String toID;

        lblHint.setText("");

        if(txtNumber.getText().equals("")){
            lblHint.setText("Bitte gib' eine Nummer ein!");
            throw new Exception();
        }

        try {
            RadioButton rbFrom = (RadioButton) group1.getSelectedToggle();
            fromID = rbFrom.getId();

        }catch (Exception e){
            fromID = "error";
        }

        try{
            RadioButton rbTo = (RadioButton) group2.getSelectedToggle();
            toID = rbTo.getId();
        }catch (Exception e){
            toID = "error";
        }

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
                lblHint.setText("Kein Eingangssystem gewählt!");
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
                lblHint.setText("Kein Ausgangssystem gewählt!");
                throw new Exception();
        }

        information.setNumber(txtNumber.getText());
    }


    @FXML
    void about(ActionEvent event) {
        aboutFrame = new AboutFrame();
        aboutFrame.showAboutPanel();
    }

}

