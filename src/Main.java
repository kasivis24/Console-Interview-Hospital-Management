import com.interview.patientmanagementsystem.features.auth.register.RegisterView;

public class Main {
    public static void main(String[] args) {

        System.out.println("Pateint App Starts");

        RegisterView registerView = new RegisterView();
        registerView.init();
    }
}