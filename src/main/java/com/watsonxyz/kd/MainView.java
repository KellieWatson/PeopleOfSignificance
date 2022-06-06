package com.watsonxyz.kd;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import javax.annotation.security.PermitAll;

@PermitAll
@Route("")
public class MainView extends VerticalLayout {
    public MainView() {
        TextField hello = new TextField();
        add(hello);
    }
}
