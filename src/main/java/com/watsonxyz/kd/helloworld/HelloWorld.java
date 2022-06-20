package com.watsonxyz.kd.helloworld;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.littemplate.LitTemplate;

@Tag("helllo-world")
@NpmPackage(value="@axa-ch/input-text", version = "4.3.11")
@JsModule(("./src/ts/hello-world.ts"))
public class HelloWorld extends LitTemplate {
    public HelloWorld(){

    }
}
