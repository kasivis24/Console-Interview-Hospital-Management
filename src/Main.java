

import com.interview.patientmanagementsystem.features.menu.MainView;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        new MainView().start();
    }
}