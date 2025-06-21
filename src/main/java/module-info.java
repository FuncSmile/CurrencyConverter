module com.currency_convert {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.currency_convert to javafx.fxml;
    exports com.currency_convert;
}
