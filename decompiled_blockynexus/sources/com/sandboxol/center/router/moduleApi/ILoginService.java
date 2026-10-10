package com.sandboxol.center.router.moduleApi;

import android.app.Activity;
import android.content.Context;
import com.sandboxol.center.entity.LoginRegisterAccountForm;
import com.sandboxol.center.listener.ISuccessListener;
import com.sandboxol.center.router.base.OnBaseResponseListener;
import com.sandboxol.common.base.dao.OnDaoResponseListener;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.greendao.entity.User;

/* JADX INFO: loaded from: classes3.dex */
public interface ILoginService extends IBaseService {
    void authReLogin(Context context);

    void forceReLogin(Context context);

    void initRoleInfo(Context context);

    void login(Context context, LoginRegisterAccountForm loginRegisterAccountForm, OnBaseResponseListener<String> onBaseResponseListener);

    void logoutOnModifyPwd(Context context, long j, boolean z);

    void onClearUserPassword(String str, OnDaoResponseListener onDaoResponseListener);

    void onConfirmPassword(Context context, String str);

    void onSaveUser(String str, String str2, User user);

    void onSetPassword(Context context, String str);

    void onSwitchAccount(Activity activity);

    void onUpdateAccount(String str, String str2);

    void onUpdatePassword(String str, String str2, String str3);

    void onUpdateUser(User user);

    void paramCheck(Context context, String str, OnResponseListener<Long> onResponseListener);

    void showProtocolDialog(Context context);

    void showRegisterFinishDialog(Context context, ISuccessListener iSuccessListener, String str);

    void switchAccount(Context context);
}
