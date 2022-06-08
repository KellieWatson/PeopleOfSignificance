package com.watsonxyz.kd.views;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;

public class PersonForm extends FormLayout {
    TextField firstName = new TextField("First Name");
    TextField lastName = new TextField("Last Name");
    EmailField email = new EmailField("Email");

    Button save = new Button("Save");
    Button delete = new Button("Delete");
    Button close = new Button("Close");

    public PersonForm(){
        addClassName("person-form");
        add(firstName, lastName, email, createButtonLayout());
    }
    private HorizontalLayout createButtonLayout(){
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        save.addClickShortcut(Key.ENTER);
        close.addClickShortcut(Key.ESCAPE);

        return new HorizontalLayout(save, delete, close);
    }

}
