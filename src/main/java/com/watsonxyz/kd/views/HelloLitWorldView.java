package com.watsonxyz.kd.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
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
        setVisible(true);
        HelloWorld hello = new HelloWorld();
        Div helloWorld = new Div();
        helloWorld.add(hello);
        add(helloWorld);

    }
    private Component getStatistics(){
        TextField statistics = new TextField(personService.countPersons() + " Persons");
        return statistics;
    }
}
