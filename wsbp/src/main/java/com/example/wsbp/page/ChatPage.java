package com.example.wsbp.page;


import com.example.wsbp.MySession;
import com.example.wsbp.data.AuthUser;
import com.example.wsbp.page.signed.SignedPage;
import com.example.wsbp.service.IUserService;
import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.wicketstuff.annotation.mount.MountPath;

@AuthorizeInstantiation(Roles.USER)
@MountPath("ChatPage")
public class ChatPage extends WebPage {

    //IUserService を IoC/DI する
    @SpringBean
    private IUserService userService;

    public ChatPage(){
        var name = Model.of(MySession.get().getUserName());
        var userNameModel = Model.of("");
        var satiModel = Model.of("");

        //var authUsersModel = Model.ofList(userService.findMsg("1!1!1!"));

        var userInfoForm = new Form<>("ChatInfo") {
            @Override
            protected void onSubmit() {
                var userName = userNameModel.getObject();
                // b1992490...の定数で照合していたものを、DB経由に変更
                /*if (service.existsUser(userName, userPass)) {
                    MySession.get().sign(userName);
                }
                setResponsePage(new SignedPage());*/
                userService.insertChat(name.getObject().toString(), userName, "aaa");
                System.out.println(name.toString()+ userName);
            }
        };
        add(userInfoForm);

        var userFindInfoForm = new Form<>("ChatFindInfo") {
            @Override
            protected void onSubmit() {
                var userName = satiModel.getObject();
                // b1992490...の定数で照合していたものを、DB経由に変更
                /*if (service.existsUser(userName, userPass)) {
                    MySession.get().sign(userName);
                }
                setResponsePage(new SignedPage());*/
                setResponsePage(new ChatResultCompPage(userName));
            }
        };
        add(userFindInfoForm);

        var userNameField = new TextField<>("userName", userNameModel);
        userInfoForm.add(userNameField);

        var satiField = new TextField<>("sati", satiModel);
        userFindInfoForm.add(satiField);
    }
}
