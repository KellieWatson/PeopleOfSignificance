package com.watsonxyz.kd.views;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLink;

public class MainLayout extends AppLayout {

    public MainLayout(){
        createHeader();
        createDrawer();
    }

    private void createHeader(){
        H1 logo = new H1("People of Significance");
        logo.addClassNames("text-l", "m-m");
        HorizontalLayout header = new HorizontalLayout( new DrawerToggle(), logo);
        header.setVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        header.setWidth("100%");
        header.addClassNames("py-0", "px-m");
        addToNavbar(header);

    }
    private void createDrawer(){
        RouterLink peopleListLink = new RouterLink("People", PeopleView.class);
        RouterLink dashboardLink = new RouterLink("Dashboard", DashboardView.class);
        RouterLink helloLitWorldLink = new RouterLink("HelloLitWorld", HelloLitWorldView.class);
        RouterLink googleChartQSLink = new RouterLink("GoogleChartQS", GoogleChartQSView.class);

        peopleListLink.setHighlightCondition(HighlightConditions.sameLocation());

        addToDrawer(new VerticalLayout(peopleListLink, dashboardLink, helloLitWorldLink, googleChartQSLink));
    }
}
