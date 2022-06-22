package com.watsonxyz.kd.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import com.watsonxyz.kd.model.Person;
import com.watsonxyz.kd.service.PersonService;

import javax.annotation.security.PermitAll;

@CssImport("./styles/styles.css")
@PermitAll
@Route(value="", layout = MainLayout.class)
public class PeopleView extends VerticalLayout {
    private final Grid<Person> peopleGrid = new Grid<>(Person.class);
    private final TextField filterPeople = new TextField();
    private PersonForm personForm;
    PersonService personService;

    public PeopleView(PersonService personService) {
        this.personService = personService;
        addClassName("main-view");
        setSizeFull();
        configurePeopleGrid();
        configurePersonForm();
        add(getToolBar(), getContent());
        updateList();
        closeEditor();
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
        peopleGrid.setSelectionMode(Grid.SelectionMode.SINGLE);
        peopleGrid.asSingleSelect().addValueChangeListener(event -> editPerson(event.getValue()));
    }
    private void configurePersonForm(){
        personForm = new PersonForm();
        personForm.setWidth("25em");
        personForm.addListener(PersonForm.SaveEvent.class, this::savePerson);
        personForm.addListener(PersonForm.DeleteEvent.class, this::deletePerson);
        personForm.addListener(PersonForm.CloseEvent.class, e -> closeEditor());
    }

    private HorizontalLayout getToolBar(){
        filterPeople.setPlaceholder("Filter By name...");
        filterPeople.setClearButtonVisible(true);
        filterPeople.setValueChangeMode(ValueChangeMode.LAZY);
        filterPeople.addValueChangeListener(e -> updateList());
        Button addPerson = new Button("Add New Person of Significance");
        addPerson.addClickListener(click -> addPerson());
        HorizontalLayout toolBar = new HorizontalLayout(addPerson, filterPeople);
        toolBar.addClassName("toolBar");
        return toolBar;

    }
    public void editPerson(Person person){
        if(person == null){
            closeEditor();
        }
        else {
            personForm.setPerson(person);
            personForm.setVisible(true);
            addClassName("editing");
        }
    }
    private void closeEditor(){
        personForm.setPerson(null);
        personForm.setVisible(false);
        removeClassName("editing");
    }
    private void savePerson(PersonForm.SaveEvent event){
        personService.savePerson(event.getPerson());
        updateList();
        closeEditor();
    }
    private void deletePerson(PersonForm.DeleteEvent event){
        personService.deletePerson(event.getPerson());
        updateList();
        closeEditor();
    }
    private void addPerson(){
        peopleGrid.asSingleSelect().clear();
        editPerson(new Person());
    }
    private void updateList() {
        peopleGrid.setItems(personService.findAllPersons(filterPeople.getValue()));
    }
}
