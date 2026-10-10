package com.sandboxol.greendao.b;

import android.text.TextUtils;
import com.sandboxol.greendao.entity.UserGameCareerTotalData;

/* JADX INFO: compiled from: UserGameCareerConverter.java */
/* JADX INFO: loaded from: classes3.dex */
public class o implements org.greenrobot.greendao.a.a<UserGameCareerTotalData, String> {
    public UserGameCareerTotalData a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (UserGameCareerTotalData) new com.google.gson.j().a(str, UserGameCareerTotalData.class);
    }

    public String a(UserGameCareerTotalData userGameCareerTotalData) {
        if (userGameCareerTotalData == null) {
            return null;
        }
        return new com.google.gson.j().a(userGameCareerTotalData);
    }
}
