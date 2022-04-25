package com.example.crime;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static com.example.crime.Dashboard.idV;

public class PopEdit {
    @FXML
    public Label lb;

    @FXML
    public TextArea text;

    @FXML
    public void UpdateReq(ActionEvent actionEvent) throws SQLException, IOException {
        if (text.getText().trim().isEmpty()){
            lb.setText("Blank");
        }
        else{

            String a = text.getText();
            lb.setText("");
            int b = idV;

            DatabaseConnection con = new DatabaseConnection();
            Connection conBD = con.getConnection();
            Statement statement = conBD.createStatement();

            String q = "UPDATE `crime`.`data` SET `detail` = '"+a+"' WHERE (`id` = '"+idV+"');";

            statement.executeUpdate(q);

            Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
            Scene scene = new Scene(root);
            Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        }
    }
}
