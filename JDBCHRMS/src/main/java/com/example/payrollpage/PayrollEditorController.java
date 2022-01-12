package com.example.payrollpage;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.*;


public class PayrollEditorController {
    //****************************************
    //***************Variables****************
    //****************************************
    //Initialize Constants
    final double medInsurancePrice = 335.86;
    final double denInsurancePrice = 226.54;
    final double visInsurancePrice = 91.21;

    //Initialize Print Values
    private double salary = 0;
    private double taxRate = 0.0;
    private double fzokRate = 0.0;
    private boolean medInsurance = false;
    private boolean denInsurance = false;
    private boolean visInsurance = false;
    private double totalDeductions = 0;
    private double totalSalaryVal = 0;
    private int UserID = 0;
    private String lastName = "";
    private String firstName = "";
    //Initialize Misc Values
    private boolean isChanged = false;
    private boolean invalidFzok = false;
    private boolean screenEntry = true;
    //TODO pull logged in user data from the login screen
    private int loggedInUser = 3;


    //****************************************
    //*****************Fields*****************
    //****************************************
    @FXML
    private JFXButton closeButton;
    @FXML
    private JFXButton updateButton;
    @FXML
    private JFXButton searchButton;
    @FXML
    private JFXCheckBox medInsuranceCB;
    @FXML
    private JFXCheckBox denInsuranceCB;
    @FXML
    private JFXCheckBox visInsuranceCB;
    @FXML
    private TextField salaryTextField;
    @FXML
    private TextField taxTextField;
    @FXML
    private TextField fzokTextField;
    @FXML
    private TextField totalDeductionsField;
    @FXML
    private TextField totalSalaryField;
    @FXML
    private TextField searchUIDField;
    @FXML
    private Text uidNameLiteral;

    //****************************************
    //***********Action Listener**************
    //****************************************
    //Set medInsurance based on selection
    @FXML
    protected void onMedInsuranceSelection(){
        if (medInsuranceCB.isSelected() != medInsurance){
            medInsurance = medInsuranceCB.isSelected();
            isChanged = true;
            updateTotal();
            System.out.println("medInsurance = " + medInsurance);
        }
    }
    //Set denInsurance based on selection
    @FXML
    protected void onDenInsuranceSelection(){
        if (denInsuranceCB.isSelected() != denInsurance){
            denInsurance = denInsuranceCB.isSelected();
            isChanged = true;
            updateTotal();
            System.out.println("denInsurance = " + denInsurance);
        }
    }
    //Set visInsurance based on selection
    @FXML
    protected void onVisInsuranceSelection(){
        if (visInsuranceCB.isSelected() != visInsurance){
            visInsurance = visInsuranceCB.isSelected();
            isChanged = true;
            updateTotal();
            System.out.println("visInsurance = " + visInsurance);
        }
    }
    //Close Screen on Close Button Press
    @FXML
    protected void onCancelButtonClick(){
        if (!isChanged) {
            Stage stage = (Stage) closeButton.getScene().getWindow();
            stage.close();
        }
        else{
            System.out.println("prompting");
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Current project is modified");
            alert.setContentText("Would you like to save your changes?");
            ButtonType okButton = new ButtonType("Yes", ButtonBar.ButtonData.YES);
            ButtonType noButton = new ButtonType("No", ButtonBar.ButtonData.NO);
            ButtonType cancelButton = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
            alert.getButtonTypes().setAll(okButton, noButton, cancelButton);
            alert.showAndWait().ifPresent(type -> {
                if (type ==  okButton){
                    try {
                        onUpdateButtonClick();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else if (type == noButton){
                    Stage stage = (Stage) closeButton.getScene().getWindow();
                    stage.close();
                }
                else if(type == cancelButton){
                    return;
                }
            });
        }
    }
    //Update and Close Screen on Update Button Press
    @FXML
    protected void onUpdateButtonClick(){
        //Validate Total Salary Amount
        if(totalSalaryVal < 0.0){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("CAN'T UPDATE RECORD");
            alert.setHeaderText("Your Salary Does Not Add Up");
            alert.setContentText("You have entered values that resulted in an invalid salary, please fix any improper changes.");
            alert.showAndWait().ifPresent(rs -> {});
            return;
        }
        //If Inputs are valid and changes are made, update
        if (isChanged && !invalidFzok) {
            try{
                String url = "jdbc:mysql://localhost:3306/mcmillain";
                Connection connection = DriverManager.getConnection (url, "root", "Password1!");
                System.out.println("Connection Established");
                String query = "update payroll set Pay = ?, Medical_Insurance = ? ,Vision_Insurance = ?, Dental_Insurance = ?, 401k = ? where User_ID = ?";
                PreparedStatement preparedStmt = connection.prepareStatement(query);
                preparedStmt.setDouble(1,salary);
                if(medInsurance)
                    preparedStmt.setDouble(2, medInsurancePrice);
                else
                    preparedStmt.setDouble(2, 0.0);
                if(visInsurance)
                    preparedStmt.setDouble(3, visInsurancePrice);
                else
                    preparedStmt.setDouble(3, 0.0);
                if(denInsurance)
                    preparedStmt.setDouble(4, denInsurancePrice);
                else
                    preparedStmt.setDouble(4, 0.0);
                preparedStmt.setDouble(5, fzokRate);
                preparedStmt.setInt(6, UserID);
                preparedStmt.executeUpdate();
                connection.close();
                Stage stage = (Stage) updateButton.getScene().getWindow();
                stage.close();
                isChanged = false;
                System.out.println("Updated");
            }
            catch (Exception e){
                System.out.println("Could not update: "+e);
            }

        }
        //If input is invalid dont update
        else if(invalidFzok){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("CAN'T UPDATE RECORD");
            alert.setHeaderText("Can Not Update Record");
            alert.setContentText("You have entered an invalid 401k value");
            alert.showAndWait().ifPresent(rs -> {});
            return;
        }
        //If no changes are made do not do anything
        else{
            Stage stage = (Stage) updateButton.getScene().getWindow();
            stage.close();
        }
    }
    //Reflexes for search
    @FXML
    protected void onSearchButtonClick() throws Exception{
        getRecords();
        displayFields();
        setAttr();
    }

    //****************************************
    //*************Initialization*************
    //****************************************
    public void initialize(){
        //Action Listener for Searches
        searchUIDField.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                //Check for Valid Entry
                if(!searchUIDField.getText().equals("") && !searchUIDField.getText().equals(" ") && !searchUIDField.getText().equals("0") && !Double.toString(UserID).equals(searchUIDField.getText())){
                    System.out.println("Validating UID");
                    double tempUserID = UserID;
                    //Check Legality
                    try{
                        UserID = Integer.parseInt(searchUIDField.getText());
                    }
                    catch (Exception e){
                        System.out.println("Invalid Input Try Again");
                        UserID = 0;
                        return;
                    }
                    System.out.println("UID Validated");
                }
            }
        });
        //Action Listener for Salary
        salaryTextField.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                //Check for Valid Entry
                if(!salaryTextField.getText().equals("") && !salaryTextField.getText().equals(" ") && !salaryTextField.getText().equals("0") && !Double.toString(salary).equals(salaryTextField.getText())){
                    System.out.println("Validating Salary");
                    //Check Legality
                    try{
                        salary = Double.parseDouble(salaryTextField.getText().substring(1));
                    }
                    catch (Exception e){
                        System.out.println("Invalid Salary Try Again: "+ e);
                        salary = 0;
                        return;
                    }
                    System.out.println("Salary validated");
                    isChanged = true;

                }
            }
        });
        //401k Rate Action Listener checking for changes
        fzokTextField.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                //Check for valid entry
                if((!fzokTextField.getText().equals(" ") && !fzokTextField.getText().equals("")) && !Double.toString(fzokRate).equals(fzokTextField.getText())){
                    System.out.println("Validating Entry");
                    double tempFzokRate = fzokRate;
                    //Check for Entry Legality
                    try {
                        fzokRate = Double.parseDouble(fzokTextField.getText());
                    }
                    //If Illegal Entry break
                    catch(Exception e){
                        System.out.println("Invalid fzok Try Again");
                        invalidFzok = true;
                        return;
                    }
                    //If legal Double Input check for amt legality
                    if(fzokRate >= 100 || fzokRate < 0.0) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("INVALID 401K");
                        alert.setHeaderText("Please Enter Valid 401k");
                        alert.setContentText("You have entered an invalid 401k value");
                        alert.showAndWait().ifPresent(rs -> {});
                        System.out.println("Invalid Rate = " + fzokRate);
                        fzokRate = tempFzokRate;
                        fzokTextField.setText(Double.toString(fzokRate));
                        return;
                    }
                    //If Entry is validated continue
                    invalidFzok = false;
                    isChanged = true;
                    BigDecimal bd =new BigDecimal(fzokRate).setScale(2, RoundingMode.HALF_DOWN);
                    fzokRate = bd.doubleValue();
                    fzokTextField.setText(Double.toString(fzokRate));
                    System.out.println("new 401k rate " + fzokRate);
                    updateTotal();
                }
            }
        });
    }

    //****************************************
    //**************Misc Methods**************
    //****************************************
    //Set Field Attributes
    public void setAttr(){
        //If current user selected themselves, enable editable fields
        if (UserID > 0 && currUID()){
            salaryTextField.setEditable(false);
            salaryTextField.setDisable(true);
            fzokTextField.setDisable(false);
            fzokTextField.setEditable(true);
            medInsuranceCB.setDisable(false);
            denInsuranceCB.setDisable(false);
            visInsuranceCB.setDisable(false);
        }
        //If user is selected and it is not current user, disable some fields and enable others
        else if(UserID > 0){
            fzokTextField.setDisable(true);
            fzokTextField.setEditable(false);
            medInsuranceCB.setDisable(true);
            denInsuranceCB.setDisable(true);
            visInsuranceCB.setDisable(true);
            salaryTextField.setEditable(true);
            salaryTextField.setDisable(false);
        }
        //If not UserID is selected disable fields
        else{
            fzokTextField.setDisable(true);
            fzokTextField.setEditable(false);
            medInsuranceCB.setDisable(true);
            denInsuranceCB.setDisable(true);
            visInsuranceCB.setDisable(true);
            salaryTextField.setEditable(false);
            salaryTextField.setDisable(true);
        }
    }
    //Check if current User selected themselves
    public boolean currUID(){
        return loggedInUser == UserID;
    }
    //Display Fields on screen entry after search
    public void displayFields(){
        salaryTextField.setText("$" + salary);
        taxTextField.setText(Double.toString(taxRate));
        fzokTextField.setText(Double.toString(fzokRate));
        medInsuranceCB.setSelected(medInsurance);
        denInsuranceCB.setSelected(denInsurance);
        visInsuranceCB.setSelected(visInsurance);
        uidNameLiteral.setText(lastName+ ", "+firstName);
        updateTotal();
    }
    //Update Total Salary
    public void updateTotal(){
        totalDeductions = (salary*taxRate/100);
        totalDeductions += (salary-totalDeductions)*(fzokRate/100);
        if(medInsurance)
            totalDeductions += medInsurancePrice;
        if(denInsurance)
            totalDeductions += denInsurancePrice;
        if(visInsurance)
            totalDeductions += visInsurancePrice;
        totalSalaryVal = salary - totalDeductions;
        BigDecimal TD =new BigDecimal(totalDeductions).setScale(2, RoundingMode.HALF_DOWN);
        BigDecimal TS =new BigDecimal(totalSalaryVal).setScale(2, RoundingMode.HALF_DOWN);
        totalDeductions = TD.doubleValue();
        totalSalaryVal = TS.doubleValue();
        totalDeductionsField.setText("$"+totalDeductions);
        totalSalaryField.setText("$"+totalSalaryVal);
    }
    //Connect to Database
    public void getRecords() throws Exception{
        try{
            //Set up Connection
            String url = "jdbc:mysql://localhost:3306/mcmillain";
            Connection connection = DriverManager.getConnection (url, "root", "Password1!");
            System.out.println("Connection Established");
            Statement statement = connection.createStatement();
            //Get Payroll Data
            ResultSet resultSet = statement.executeQuery("select * from payroll where User_ID = "+UserID);
            resultSet.next();
            salary = Double.parseDouble(resultSet.getString("Pay"));
            taxRate = Double.parseDouble(resultSet.getString("Tax"));
            fzokRate = Double.parseDouble(resultSet.getString("401k"));
            if(Double.parseDouble(resultSet.getString("Medical_Insurance")) > 0)
                medInsurance = true;
            if(Double.parseDouble(resultSet.getString("Dental_Insurance")) > 0)
                denInsurance = true;
            if(Double.parseDouble(resultSet.getString("Vision_Insurance")) > 0)
                visInsurance = true;
            //Get personnel data
            resultSet = statement.executeQuery("select * from employee_personal_record where User_ID = "+UserID);
            resultSet.next();
            firstName = resultSet.getString("First_Name");
            lastName = resultSet.getString("Last_Name");
            connection.close();
        }
        catch (Exception e){
            System.out.println("Could not Connect to server: "+e);
            return;
        }
    }
}