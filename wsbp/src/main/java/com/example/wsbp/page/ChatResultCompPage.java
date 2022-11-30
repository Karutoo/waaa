package com.example.wsbp.page;

import com.example.wsbp.data.AuthUser;
import com.example.wsbp.data.dwdawdw;
import com.example.wsbp.service.IUserService;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.wicketstuff.annotation.mount.MountPath;

@AuthorizeInstantiation(Roles.USER)
@MountPath("ChatResultCompPage")
public class ChatResultCompPage  extends WebPage {
    // Service を IoC/DI する
    @SpringBean
    private IUserService userService;

    public ChatResultCompPage(String aa){
        System.out.println("BBBBBBBBBB");
        var authUsersModel = Model.ofList(userService.findMsg(aa));
        System.out.println("AAAAAAAAAA");
        // List型のモデルを表示する ListView
        var usersLV = new ListView<>("users", authUsersModel) {
            @Override
            protected void populateItem(ListItem<dwdawdw> listItem) {
                // List型のモデルから、 <li>...</li> ひとつ分に分けられたモデルを取り出す
                var itemModel = listItem.getModel();
                var authUser = itemModel.getObject(); // 元々のListの n 番目の要素

                // インスタンスに入れ込まれたデータベースの検索結果を、列（＝フィールド変数）ごとにとりだして表示する
                // add する先が listItem になることに注意。
                var userNameModel = Model.of(authUser.getUserName());
                var userNameLabel = new Label("userName", userNameModel);
                listItem.add(userNameLabel);

                var userPassModel = Model.of(authUser.getUserPass());
                var userPassLabel = new Label("userPass", userPassModel);
                listItem.add(userPassLabel);
            }
        };
        add(usersLV);
    }
}
