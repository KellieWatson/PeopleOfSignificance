package com.watsonxyz.kd.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.dependency.JavaScript;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.watsonxyz.kd.helloworld.HelloWorld;
import com.watsonxyz.kd.service.PersonService;

import javax.annotation.security.PermitAll;

@JavaScript("./src/js/googlechartqs.js")
@PermitAll
@Route(value = "dashboard", layout = MainLayout.class)
public class DashboardView extends VerticalLayout {
    private final PersonService personService;
    public DashboardView(PersonService personService){
        this.personService = personService;
        addClassName("dashboard-view");
        add(getStatistics());
    }
    private Component getStatistics(){
        TextField statistics = new TextField(personService.countPersons() + " Persons");
        return statistics;
    }


}
