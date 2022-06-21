package com.watsonxyz.kd.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.watsonxyz.kd.helloworld.HelloWorld;
import com.watsonxyz.kd.service.PersonService;

import javax.annotation.security.PermitAll;

@PermitAll
@Route(value= "hellolitworld", layout = MainLayout.class)
public class HelloLitWorldView extends VerticalLayout {
    private final PersonService personService;
    public HelloLitWorldView(PersonService personService){
        this.personService = personService;
        this.setVisible(true);
        this.setEnabled(true);

        HelloWorld hello = new HelloWorld();
        hello.setContent(new Label("Hello From HelloLitWorldView"));
        Div helloDiv = new Div();
        helloDiv.add(hello);
        this.add(helloDiv, getStatistics());

    }
    private Component getStatistics(){
        TextField statistics = new TextField(personService.countPersons() + " Persons");
        return statistics;
    }

}
