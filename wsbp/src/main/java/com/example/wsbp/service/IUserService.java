package com.example.wsbp.service;

import com.example.wsbp.data.AuthUser;
import com.example.wsbp.data.dwdawdw;

import java.util.List;

public interface IUserService {

    public void registerUser(String userName, String userPass);

    public void insertChat(String userName, String time, String msg);

    public void removeUser(String userName);

    /**
     * ユーザ名とパスワードをデータベースに照合する
     *
     * @param userName ユーザー名
     * @param userPass パスワード
     * @return 照合成功であれば<code>true</code>, 照合失敗は<code>false</code>
     */
    public boolean existsUser(String userName, String userPass);

    public List<AuthUser> findAuthUsers();

    public List<dwdawdw> findMsg(String ff);
}