package com.watsonxyz.kd;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import com.watsonxyz.kd.model.Person;
import com.watsonxyz.kd.service.PersonService;
import com.watsonxyz.kd.views.PersonForm;
import org.atmosphere.interceptor.AtmosphereResourceStateRecovery;

import javax.annotation.security.PermitAll;

@PermitAll
@Route("")
public class MainView extends VerticalLayout {
    private Grid<Person> peopleGrid = new Grid<>(Person.class);
    private TextField filterPeople = new TextField();
    private PersonForm personForm;
    PersonService personService;

    public MainView(PersonService personService) {
        this.personService = personService;
        addClassName("main-view");
        setSizeFull();
        configurePeopleGrid();
        configurePersonForm();
        add(getToolBar(), getContent());
        updateList();
    }
    private Component getContent(){
        HorizontalLayout content = new HorizontalLayout(peopleGrid, personForm);
        content.setFlexGrow(2, peopleGrid);
        content.setFlexGrow(1, personForm);
        content.addClassName("content");
        content.setSizeFull();
        return content;
    }
    private void configurePeopleGrid(){
        peopleGrid.addClassName("people-grid");
        peopleGrid.setSizeFull();
        peopleGrid.setColumns("id", "firstName", "lastName", "email");
        peopleGrid.getColumns().forEach(col -> col.setAutoWidth(true));
    }
    private void configurePersonForm(){
        personForm = new PersonForm();
        personForm.setWidth("25em");
    }

    private HorizontalLayout getToolBar(){
        filterPeople.setPlaceholder("Filter By name...");
        filterPeople.setClearButtonVisible(true);
        filterPeople.setValueChangeMode(ValueChangeMode.LAZY);
        filterPeople.addValueChangeListener(e -> updateList());
        Button addPerson = new Button("Add New Person of Significance");
        HorizontalLayout toolBar = new HorizontalLayout(addPerson, filterPeople);
        toolBar.addClassName("toolBar");
        return toolBar;

    }
    private void updateList() {
        peopleGrid.setItems(personService.findAllPersons(filterPeople.getValue()));
    }
}
