package com.watsonxyz.kd.helloworld;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.NativeButton;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.textfield.TextField;
import com.watsonxyz.kd.service.PersonService;

@Tag("hello-world")
@NpmPackage(value="@axa-ch/input-text", version = "4.3.11")
@JsModule(("./src/ts/hello-world.ts"))
public class HelloWorld extends LitTemplate {
    @Id("content")
    Div content;
    @Id("first-input")
    TextField firstInput;
    @Id("second-input")
    TextField secondInput;
    @Id("hello-button")
    Button helloButton;

    public HelloWorld(){
        this.setId("hello-world");

        helloButton.addClickListener(event -> {
            System.out.println("Clicked!");
        });
        this.setVisible(true);
        firstInput.setPlaceholder("hello-Placeholder");
        firstInput.getPlaceholder();
        firstInput.setVisible(true);
        firstInput.setLabel("Hello-Label");
        firstInput.setValue("hello-value");
    }
    public void setContent(Component content) {
        this.content.removeAll();
        this.content.add(content);
    }
}
