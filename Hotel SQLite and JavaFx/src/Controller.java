import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.text.Normalizer;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;


public class Controller implements Initializable {

    Scanner load =  new Scanner(System.in);

    public TextField input;
    public Label lblinput;

    public TextField tfname;
    public TextField tfsurname;
    public TextField tfpesel;


    public void initialize(URL url, ResourceBundle rb) {
    }

    public void loginButtonClicked(){
        System.out.println("User logged in...");
    }

    public void settingsButtonClicked(){
        System.out.println("Settings");
    }

    public void menuFileCloseClicked(){
        Platform.exit();
    }

    public void buttonShowEmployees() {
        Hotel h = new Hotel();

        List<Employee> employee = h.selectEmployee();
        System.out.println("Lista pracowników:");
        for(Employee y: employee)
            System.out.println(y);
    }

    public void buttonShowGuest() {
        Hotel h = new Hotel();

        List<Guest> guests = h.selectGuest();
        System.out.println("Lista gości: ");
        for(Guest x:guests)
            System.out.println(x);
    }

    public void buttonAddEmployee() {
        Hotel h = new Hotel();

        System.out.println("Podaj imię Pracownika:");
        String nick = load.nextLine();

        h.insertEmployee(nick);
    }

    public void buttonSomething(javafx.event.ActionEvent actionEvent) {
        String something = Normalizer.normalize(input.getText(), Normalizer.Form.NFD);
        //something = something.replaceAll("[^\\p{ASCII}]", "");
        System.out.println("Wpisałeś: " + something);
        lblinput.setText(input.getText());
    }

    public void buttonAddGuest(javafx.event.ActionEvent actionEvent) {
        Hotel h = new Hotel();

        String name = Normalizer.normalize(tfname.getText(), Normalizer.Form.NFD);
        String surname = Normalizer.normalize(tfsurname.getText(), Normalizer.Form.NFD);
        String pesel = Normalizer.normalize(tfpesel.getText(), Normalizer.Form.NFD);
        //something = something.replaceAll("[^\\p{ASCII}]", "");
        System.out.println("Wpisałeś: " + name + surname + pesel);
        //lblinput.setText(input.getText());

        h.insertGuest(name, surname, pesel);
    }




    public void labelEmployeeName() {
        Hotel h = new Hotel();
        String nick = load.nextLine();

        h.insertEmployee(nick);
    }

    public void showData() {
    }

    public void buttonTest() {
    }

}
