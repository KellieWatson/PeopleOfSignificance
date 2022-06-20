package com.watsonxyz.kd.views;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.watsonxyz.kd.helloworld.HelloWorld;

public class HelloLitWorldView extends VerticalLayout {
    public HelloLitWorldView(){
        HelloWorld hello = new HelloWorld();
        Div helloWorld = new Div();
        helloWorld.add(hello);
        add(helloWorld);

    }
}
