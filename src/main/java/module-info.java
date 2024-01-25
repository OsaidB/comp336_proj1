module com.example.comp336_3 {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.comp336_proj1 to javafx.fxml;
    exports com.example.comp336_proj1;
}