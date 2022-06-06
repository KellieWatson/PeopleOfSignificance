package com.watsonxyz.kd;


import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("login")
@PageTitle("Login | People Of Significance")
public class LoginView extends VerticalLayout {
    public LoginView() {
        TextField userTextField = new TextField("UserName: ");
        add(userTextField);
    }
}
