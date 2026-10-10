package io.rong.imkit.plugin.location;

import io.rong.imlib.model.UserInfo;

/* JADX INFO: loaded from: classes5.dex */
public interface IUserInfoProvider {

    public interface UserInfoCallback {
        void onGotUserInfo(UserInfo userInfo);
    }

    void getUserInfo(String str, UserInfoCallback userInfoCallback);
}
