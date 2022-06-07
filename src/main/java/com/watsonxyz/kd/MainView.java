package com.watsonxyz.kd;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import com.watsonxyz.kd.model.Person;
import org.atmosphere.interceptor.AtmosphereResourceStateRecovery;

import javax.annotation.security.PermitAll;

@PermitAll
@Route("")
public class MainView extends VerticalLayout {
    private Grid<Person> peopleGrid = new Grid<>(Person.class);
    private TextField filterPeople = new TextField();

    public MainView() {
        addClassName("main-view");
        setSizeFull();
        configurePeopleGrid();
        add(getToolBar(), peopleGrid);
    }
    private void configurePeopleGrid(){
        peopleGrid.addClassName("people-grid");
        peopleGrid.setSizeFull();
        peopleGrid.setColumns("firstName", "lastName", "email");
        peopleGrid.getColumns().forEach(col -> col.setAutoWidth(true));
    }

    private HorizontalLayout getToolBar(){
        filterPeople.setPlaceholder("Filter By name...");
        filterPeople.setClearButtonVisible(true);
        filterPeople.setValueChangeMode(ValueChangeMode.LAZY);
        Button addPerson = new Button("Add New Person of Significance");
        HorizontalLayout toolBar = new HorizontalLayout(addPerson, filterPeople);
        toolBar.addClassName("toolBar");
        return toolBar;

    }
}
