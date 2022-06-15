package com.watsonxyz.kd.views;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.shared.Registration;
import com.watsonxyz.kd.model.Person;

public class PersonForm extends FormLayout {
    private Person person;
    TextField firstName = new TextField("First Name");
    TextField lastName = new TextField("Last Name");
    EmailField email = new EmailField("Email");

    Binder<Person> binder = new BeanValidationBinder<>(Person.class);

    Button save = new Button("Save");
    Button delete = new Button("Delete");
    Button close = new Button("Close");

    public PersonForm(){
        addClassName("person-form");
        add(firstName, lastName, email, createButtonLayout());
        binder.bindInstanceFields(this);
    }
    private HorizontalLayout createButtonLayout(){
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        save.addClickShortcut(Key.ENTER);
        close.addClickShortcut(Key.ESCAPE);

        save.addClickListener(event -> ValidateAndSave());
        delete.addClickListener(event -> fireEvent(new DeleteEvent(this, person)));
        close.addClickListener((event -> fireEvent(new CloseEvent(this))));

        binder.addStatusChangeListener(e -> save.setEnabled(binder.isValid()));

        return new HorizontalLayout(save, delete, close);
    }
    private void ValidateAndSave(){
        try{
            binder.writeBean(person);
            fireEvent(new SaveEvent(this, person));
        }
        catch (ValidationException validationException){
            validationException.printStackTrace();
        }
    }
    public void setPerson(Person person){
        this.person = person;
        binder.readBean(person);
    }

    public static abstract class PersonFormEvent extends ComponentEvent<PersonForm>{
        private Person person;
        protected PersonFormEvent(PersonForm source, Person person){
            super(source, false);
            this.person = person;
        }

        public Person getPerson() {
            return person;
        }
    }
    public static class SaveEvent extends PersonFormEvent{
        SaveEvent(PersonForm source, Person person){
            super(source, person);
        }
    }
    public static class DeleteEvent extends PersonFormEvent{
        DeleteEvent(PersonForm source, Person person){
            super(source, person);
        }
    }
    public static class CloseEvent extends PersonFormEvent{
        CloseEvent(PersonForm source){
            super(source, null);
        }
    }
    public <T extends ComponentEvent<?>>Registration addListener(Class<T> eventType, ComponentEventListener<T> listner){
        return getEventBus().addListener(eventType, listner);
    }
}
