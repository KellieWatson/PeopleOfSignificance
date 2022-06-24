package com.watsonxyz.kd.googlechart;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Page;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.dom.Element;

@JsModule("./src/js/googlechartqs.js")
public class GoogleChartQS extends VerticalLayout {

     Div chartDiv;
//    @Id("first-input")
//    TextField firstInput;
//    @Id("second-input")
//    TextField secondInput;
//    @Id("hello-button")
//    Button helloButton;

    public GoogleChartQS() {


//        this.setId("GoogleChartQS");
//        helloButton.addClickListener(event -> {
//            System.out.println("GS Clicked!");
//        });
//        this.setVisible(true);
//        firstInput.setPlaceholder("hello-Placeholder");
//        firstInput.getPlaceholder();
//        firstInput.setVisible(true);
//        firstInput.setLabel("Hello-Label");
//        firstInput.setValue("hello-value");
   }
    public void setContent(Component content) {

    }

}
