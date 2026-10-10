package com.sandboxol.center;

import android.content.Context;
import com.sandboxol.center.entity.LoginRegisterAccountForm;
import com.sandboxol.common.entity.AuthTokenResponse;
import com.sandboxol.greendao.entity.User;

/* JADX INFO: loaded from: classes.dex */
public interface IAccountManager {
    void onLoginFinish(Context context, LoginRegisterAccountForm loginRegisterAccountForm, User user);

    void onNewAccountCreated(AuthTokenResponse authTokenResponse);

    void onRegisterFinish(Context context, User user);

    void onUnLoginFinish();

    void onUpdateAccount(Context context, User user);
}
