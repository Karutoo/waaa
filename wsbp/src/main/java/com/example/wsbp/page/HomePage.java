package com.example.wsbp.page;

import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;
import org.wicketstuff.annotation.mount.MountPath;
import com.example.wsbp.service.ISampleService;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

@WicketHomePage
@MountPath("Home")
public class HomePage extends WebPage {

    @SpringBean
    private ISampleService service;

    public HomePage() {
        var youModel = Model.of("Wicket-Spring-Boot");
        var youLabel = new Label("you", youModel);
        add(youLabel);

        var shimeiModel = Model.of("大平友翔");
        var shimeiLabel = new Label("shimei", shimeiModel);
        add(shimeiLabel);

        var timeModel = Model.of(service.makeCurrentHMS());
        var timeLabel = new Label("time", timeModel);
        add(timeLabel);

        var toUserMakerLink = new BookmarkablePageLink<>("toUserMaker", UserMakerPage.class);
        add(toUserMakerLink);

        var toUserDeleteLink = new BookmarkablePageLink<>("toUserDeleter", UserDeletePage.class);
        add(toUserDeleteLink);
    }

}