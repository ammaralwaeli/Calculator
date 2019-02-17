package application;

import java.util.ArrayList;
import java.util.Arrays;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainController {

    Suffix suf ;
    Evaluation ev;

    //add FXML connector
    @FXML
    private Label Number, result;

    private ArrayList<String> k;

    @FXML
    public void clickButton(javafx.event.ActionEvent event) {
        char s = event.getSource().toString().charAt(event.getSource().toString().length() - 2);
        Number.setText(Number.getText() + s);
    }

    public void clickClear(javafx.event.ActionEvent event) {

        Number.setText("");
        result.setText("");
        suf=new Suffix();
        ev=new Evaluation();
    }

    public void clickBack(javafx.event.ActionEvent event) {

        if (!Number.getText().equals("")) {
            Number.setText(Number.getText().substring(0, Number.getText().length() - 1));
        }
    }

    public void clickResult(javafx.event.ActionEvent event) {

        suf= new Suffix();
        ev =new Evaluation();
        suf.setInput(Number.getText());

        k = new ArrayList<>();

        String[] t = suf.getInput().split("(?=[-+*/()])|(?<=[^-+*/][-+*/])|(?<=[()])");

        k.addAll(Arrays.asList(t));
        suf.s.push("#");
        suf.Suffix(k);
        result.setText(ev.Evaluatepostfix(suf.out, suf.k) + "");

    }

}
