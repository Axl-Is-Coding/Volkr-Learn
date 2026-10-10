package com.sandboxol.center;

import android.content.Context;
import com.sandboxol.center.entity.LoginRegisterAccountForm;
import com.sandboxol.common.entity.AuthTokenResponse;
import com.sandboxol.greendao.entity.User;

/* JADX INFO: loaded from: classes.dex */
public class AccountManager {
    private static AccountManager sAccountManager = new AccountManager();
    private IAccountManager accountManagerImpl = null;

    private AccountManager() {
    }

    public static AccountManager getInstance() {
        return sAccountManager;
    }

    public void onLoginFinish(Context context, LoginRegisterAccountForm loginRegisterAccountForm, User user) {
        IAccountManager iAccountManager = this.accountManagerImpl;
        if (iAccountManager != null) {
            iAccountManager.onLoginFinish(context, loginRegisterAccountForm, user);
        }
    }

    public void onNewAccountCreated(AuthTokenResponse authTokenResponse) {
        IAccountManager iAccountManager = this.accountManagerImpl;
        if (iAccountManager != null) {
            iAccountManager.onNewAccountCreated(authTokenResponse);
        }
    }

    public void onRegisterFinish(Context context, User user) {
        IAccountManager iAccountManager = this.accountManagerImpl;
        if (iAccountManager != null) {
            iAccountManager.onRegisterFinish(context, user);
        }
    }

    public void onUnLoginFinish() {
        IAccountManager iAccountManager = this.accountManagerImpl;
        if (iAccountManager != null) {
            iAccountManager.onUnLoginFinish();
        }
    }

    public void onUpdateAcount(Context context, User user) {
        IAccountManager iAccountManager = this.accountManagerImpl;
        if (iAccountManager != null) {
            iAccountManager.onUpdateAccount(context, user);
        }
    }

    public void setAccountManagerImpl(IAccountManager iAccountManager) {
        this.accountManagerImpl = iAccountManager;
    }
}
