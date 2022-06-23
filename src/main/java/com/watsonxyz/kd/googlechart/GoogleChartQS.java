package com.watsonxyz.kd.googlechart;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.template.Id;
import com.vaadin.flow.component.textfield.TextField;

@Tag("google-chartqs")
@JsModule("./src/ts/google-chartqs.ts")
public class GoogleChartQS extends LitTemplate{
    @Id("content")
    Div content;
    @Id("chart-div")
    Div chartDiv;
//    @Id("first-input")
//    TextField firstInput;
//    @Id("second-input")
//    TextField secondInput;
//    @Id("hello-button")
//    Button helloButton;

    public GoogleChartQS() {

//        this.setId("GoogleChartQS");
//
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
        this.content.removeAll();
        this.content.add(content);
    }

}
