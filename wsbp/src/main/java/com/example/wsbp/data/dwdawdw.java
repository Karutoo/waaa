package com.example.wsbp.data;

import java.io.Serializable;

public class dwdawdw implements Serializable {

    private final String userName;  // auth_userテーブルのuser_name列のデータ
    private final String msgBody;  // auth_userテーブルのuser_pass列のデータ

    public dwdawdw(String userName, String msgBody) {
            this.userName = userName;
            this.msgBody = msgBody;
    }

        public String getUserName() {
            return userName;
        }

        public String getUserPass() {
            return msgBody;
        }
    }
