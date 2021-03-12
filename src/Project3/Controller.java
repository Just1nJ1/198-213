package Project3;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.PrintWriter;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Controller implements Initializable{
    private static final Employee NOTPASS = null;
    private static final int EMPTY = 0;
    private Company company;

    @FXML
    private TextField inputName;

    @FXML
    private RadioButton isIT;

    @FXML
    private ToggleGroup department;

    @FXML
    private RadioButton isCS;

    @FXML
    private RadioButton isECE;

    @FXML
    private DatePicker inputDate;

    @FXML
    private ChoiceBox<String> inputType;

    @FXML
    private CheckBox isManager;

    @FXML
    private ChoiceBox<String> inputManagement;

    @FXML
    private Label textSalary;

    @FXML
    private Label textRate;

    @FXML
    private TextField inputSalary;

    @FXML
    private Label textHour;

    @FXML
    private TextField inputHour;

    @FXML
    private TextArea outputArea;

    @FXML
    void add(ActionEvent event) {
        Employee employee = inputCheck();
        if (employee != NOTPASS){
            if (!company.add(employee)){
                outputArea.appendText("Employee is already in the list.\n");
                return;
            }
            outputArea.appendText("Employee added.\n");
            selectChanged("Clear");
        }
    }

    @FXML
    void clearOutput(ActionEvent event){
        outputArea.clear();
    }

    @FXML
    void calculate(ActionEvent event){
        if (employeeEmptyCheck()){ return; }
        company.processPayments();
        outputArea.appendText("Calculation of employee payments is done.\n");
    }

    @FXML
    void print(ActionEvent event){
        if (employeeEmptyCheck()){ return; }
        outputArea.appendText("--Printing earning statements for all employees--\n");
        outputArea.appendText(company.print());
    }

    @FXML
    void printByDate(ActionEvent event){
        if (employeeEmptyCheck()){ return; }
        outputArea.appendText("--Printing earning statements by date hired--\n");
        company.sortByDate();
        outputArea.appendText(company.print());
    }

    @FXML
    void printByDepartment(ActionEvent event){
        if (employeeEmptyCheck()){ return; }
        outputArea.appendText("--Printing earning statements by department--\n");
        company.sortByDepartment();
        outputArea.appendText(company.print());
    }

    @FXML
    void importFromFile(ActionEvent event) {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open Source File for the Import");
        chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                new FileChooser.ExtensionFilter("All Files", "*.*"));
        Stage stage = new Stage();
        File sourceFile = chooser.showOpenDialog(stage); //get the reference of the source file
        try (Scanner input = new Scanner(sourceFile)){
            while (input.hasNext()){
                String nextLine = input.nextLine();
                StringTokenizer tokenizer = new StringTokenizer(nextLine, ",");
                if (!tokenizer.hasMoreTokens()){ continue; }
                String type = tokenizer.nextToken();

                if (((type.equals("P") || type.equals("F")) && tokenizer.countTokens() == 4)
                || (type.equals("M") && tokenizer.countTokens() == 5)) {
                    String name = tokenizer.nextToken();
                    String department = tokenizer.nextToken();
                    Date date = new Date(tokenizer.nextToken());

                    if (!date.isValid()){
                        outputArea.appendText("Invalid date: " + date + "\n");
                        continue;
                    }
                    String tempSalary = tokenizer.nextToken();

                    if (type.equals("F")){
                        int salary;
                        try {
                            salary = Integer.parseInt(tempSalary);
                        } catch (Exception e){
                            outputArea.appendText("Invalid salary: " + tempSalary + "\n");
                            continue;
                        }
                        if (!company.add(new Fulltime(new Profile(name, department, date), salary))){
                            outputArea.appendText("Employee is already in the list.\n");
                        } else {
                            outputArea.appendText("Employee added.\n");
                        }
                    } else if (type.equals("M")){
                        String tempRoles = tokenizer.nextToken();
                        int salary, roles;
                        try {
                            salary = Integer.parseInt(tempSalary);
                            roles = Integer.parseInt(tempRoles);
                        } catch (Exception e){
                            outputArea.appendText("Invalid salary or management code: " + tempSalary + ", " + tempRoles + "\n");
                            continue;
                        }
                        if (!company.add(new Management(new Profile(name, department, date), salary, roles))){
                            outputArea.appendText("Employee is already in the list.\n");
                        } else {
                            outputArea.appendText("Employee added.\n");
                        }
                    } else {
                        double payRate;
                        try {
                            payRate = Double.parseDouble(tempSalary);
                        } catch (Exception e){
                            outputArea.appendText("Invalid Pay Rate: " + tempSalary + ", " + "\n");
                            continue;
                        }
                        if (!company.add(new Parttime(new Profile(name, department, date), payRate))){
                            outputArea.appendText("Employee is already in the list.\n");
                        } else {
                            outputArea.appendText("Employee added.\n");
                        }
                    }
                } else {
                    outputArea.appendText("Invalid input: " + nextLine + "\n");
                }
            }
        } catch (Exception e){
            outputArea.appendText("Import Failed: " + e.getMessage() + "\n");
        }

    }

    @FXML
    void exportToFile(ActionEvent event) {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open Target File for the Export");
        chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                new FileChooser.ExtensionFilter("All Files", "*.*"));
        Stage stage = new Stage();
        File targeFile = chooser.showSaveDialog(stage); //get the reference of the target file
        try (PrintWriter printWriter = new PrintWriter(targeFile)){
            printWriter.print(company.print());
        } catch (Exception e){
            outputArea.appendText("Export Failed: " + e.getMessage() + "\n");
        }
    }

    @FXML
    void remove(ActionEvent event) {
        if (employeeEmptyCheck()){ return; }
        Employee employee = inputCheck(false, true);
        if (employee != NOTPASS){
            if (!company.remove(employee)){
                outputArea.appendText("Employee does not exist.\n");
                return;
            }
            outputArea.appendText("Employee removed.\n");
            selectChanged("Clear");
        }
    }

    @FXML
    void setHour(ActionEvent event) {
        if (employeeEmptyCheck()){ return; }
        Employee employee = inputCheck(true, false);
        if (employee != NOTPASS){
            if (!company.setHours(employee)){
                outputArea.appendText("Employee does not exist.\n");
                return;
            }
            outputArea.appendText("Working hours set.\n");
            selectChanged("Clear");
        }
    }

    @FXML
    void quit(ActionEvent event){
        ((Stage)((Node)event.getSource()).getScene().getWindow()).close();
    }

    @FXML
    void clearInput(ActionEvent event){
        selectChanged("Clear");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        company = new Company();
        inputType.getItems().addAll("Part Time", "Full Time");
        inputManagement.getItems().addAll("Manager", "Department Head", "Director");
        addListener();
        selectChanged("Clear");
    }

    private void selectChanged(String selected){
        switch (selected){
            case "Clear":
                inputName.clear();
                inputHour.clear();
                inputSalary.clear();
                inputDate.setValue(null);
                inputDate.getEditor().clear();
                inputType.setValue("");
                inputManagement.setValue(null);
                isManager.setSelected(false);
                isIT.setSelected(false);
                isCS.setSelected(false);
                isECE.setSelected(false);

                isManager.setVisible(false);
                inputManagement.setVisible(false);
                textHour.setVisible(false);
                textSalary.setVisible(false);
                textRate.setVisible(false);
                inputSalary.setVisible(false);
                inputHour.setVisible(false);
                break;
            case "Part Time":
                textRate.setVisible(true);
                textHour.setVisible(true);
                inputSalary.setVisible(true);
                inputHour.setVisible(true);
                textSalary.setVisible(false);
                isManager.setVisible(false);
                isManager.setSelected(false);
                inputManagement.setVisible(false);
                break;
            case "Full Time":
                textSalary.setVisible(true);
                inputSalary.setVisible(true);
                isManager.setVisible(true);
                inputManagement.setVisible(false);
                textRate.setVisible(false);
                textHour.setVisible(false);
                inputHour.setVisible(false);
                break;
        }
    }

    private void addListener(){
        isManager.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                inputManagement.setVisible(t1);
                inputManagement.setValue("Manager");
            }
        });
        inputType.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                selectChanged(t1);
            }
        });
    }

    private boolean employeeEmptyCheck(){
        if (company.getNumEmployee() == EMPTY) {
            outputArea.appendText("Employee database is empty.\n");
            return true;
        }
        return false;
    }

    private Employee inputCheck(){
        return inputCheck(false, false);
    }

    private Employee inputCheck(boolean setHour, boolean remove){
        String name = inputName.getText();
        if (inputName.getText().equals("")){
            outputArea.appendText("Enter a name\n");
            return NOTPASS;
        }
        String department = "";
        if (isIT.isSelected()){
            department = "IT";
        } else if (isCS.isSelected()){
            department = "CS";
        } else if (isECE.isSelected()){
            department = "ECE";
        } else {
            outputArea.appendText("Select a department\n");
            return NOTPASS;
        }
        if (inputDate.getValue() == null){
            outputArea.appendText("Select a date\n");
            return NOTPASS;
        }
        LocalDate date = inputDate.getValue();
        Date dateHired = new Date(date.getMonthValue() + "/" + date.getDayOfMonth() + "/" + date.getYear());
        if (!dateHired.isValid()){
            outputArea.appendText("Invalid Date: " + dateHired +
                    ", the date must be between 1900-1-1 and " + LocalDate.now() + "\n");
            inputDate.setValue(LocalDate.now());
            return NOTPASS;
        }

        if (remove){
            return new Employee(new Profile(name, department, dateHired));
        }

        String type = inputType.getValue();
        if (type.equals("")) {
            outputArea.appendText("Select a type\n");
            return NOTPASS;
        }
        if (type.equals("Part Time")){
            double payRate = 0;
            int hours = 0;
            if (!setHour) {
                try {
                    payRate = Double.parseDouble(inputSalary.getText());
                } catch (Exception e) {
                    outputArea.appendText("Rate should be a double number\n");
                    return NOTPASS;
                }
                if (payRate < 0) {
                    outputArea.appendText("Pay rate cannot be negative.\n");
                    return NOTPASS;
                }
            }
            if (setHour || !inputHour.getText().equals("")) {
                try {
                    hours = Integer.parseInt(inputHour.getText());
                } catch (Exception e){
                    outputArea.appendText("Working hours should be an integer\n");
                    return NOTPASS;
                }
                if (hours < 0){
                    outputArea.appendText("Working hours cannot be negative.\n");
                    return NOTPASS;
                }
                if (hours > 100){
                    outputArea.appendText("Invalid Hours: over 100.\n");
                    return NOTPASS;
                }
            }
            return new Parttime(new Profile(name, department, dateHired), payRate, hours);
        } else {
            int salary = 0;
            try {
                salary = Integer.parseInt(inputSalary.getText());
            } catch (Exception e){
                outputArea.appendText("Salary should be an integer number\n");
                return NOTPASS;
            }
            if (salary < 0){
                outputArea.appendText("Salary cannot be negative.\n");
                return NOTPASS;
            }
            if (!isManager.isSelected()){
                return new Fulltime(new Profile(name, department, dateHired), salary);
            } else {
                return new Management(new Profile(name, department, dateHired), salary, inputManagement.getValue());
            }
        }
    }
}
