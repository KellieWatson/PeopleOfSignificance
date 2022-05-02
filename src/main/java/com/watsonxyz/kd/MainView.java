package com.watsonxyz.kd;


import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends VerticalLayout {
    public MainView() {
        TextField userTextField = new TextField("UserName: ");
        add(userTextField);
    }
}
