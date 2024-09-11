module ph.edu.dlsu.lbycpei.finalprojectjavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires javafx.graphics;

    opens ph.edu.dlsu.lbycpei.finalprojectjavafx to javafx.fxml;
    exports ph.edu.dlsu.lbycpei.finalprojectjavafx;
    exports ph.edu.dlsu.lbycpei.finalprojectjavafx.objects;
    opens ph.edu.dlsu.lbycpei.finalprojectjavafx.objects to javafx.fxml;
    exports ph.edu.dlsu.lbycpei.finalprojectjavafx.controllers;
    opens ph.edu.dlsu.lbycpei.finalprojectjavafx.controllers to javafx.fxml;
    exports ph.edu.dlsu.lbycpei.finalprojectjavafx.controllers.med;
    opens ph.edu.dlsu.lbycpei.finalprojectjavafx.controllers.med to javafx.fxml;
    opens ph.edu.dlsu.lbycpei.finalprojectjavafx.controllers.appoint to javafx.fxml;
}