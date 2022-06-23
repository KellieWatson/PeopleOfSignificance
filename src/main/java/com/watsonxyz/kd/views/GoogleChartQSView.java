package com.watsonxyz.kd.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.watsonxyz.kd.googlechart.GoogleChartQS;
import com.watsonxyz.kd.helloworld.HelloWorld;
import com.watsonxyz.kd.service.PersonService;

import javax.annotation.security.PermitAll;

@PermitAll
@Route(value= "googlechartqs", layout = MainLayout.class)
public class GoogleChartQSView extends VerticalLayout {

    private final PersonService personService;
    public GoogleChartQSView(PersonService personService){
        this.personService = personService;
        this.setVisible(true);
        this.setEnabled(true);

        GoogleChartQS googleChartQS = new GoogleChartQS();
        googleChartQS.setContent(new Label("Hello From GoogleChartQSView"));
        Div googleChartQSDiv = new Div();
        googleChartQSDiv.add(googleChartQS);
        this.add(googleChartQSDiv, getStatistics());

    }
    private Component getStatistics(){
        TextField statistics = new TextField(personService.countPersons() + " Persons");
        return statistics;
    }
}
