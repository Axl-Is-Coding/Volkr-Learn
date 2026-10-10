package com.sandboxol.center.router.manager;

import android.app.Activity;
import android.content.Context;
import com.sandboxol.center.entity.LoginRegisterAccountForm;
import com.sandboxol.center.listener.ISuccessListener;
import com.sandboxol.center.router.RouteServiceManager;
import com.sandboxol.center.router.base.OnBaseResponseListener;
import com.sandboxol.center.router.moduleApi.ILoginService;
import com.sandboxol.center.router.path.RouterServicePath;
import com.sandboxol.common.base.dao.OnDaoResponseListener;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.greendao.entity.User;

/* JADX INFO: loaded from: classes3.dex */
public class LoginManager {
    private static ILoginService iLoginService = (ILoginService) RouteServiceManager.provide(RouterServicePath.EventLogin.LOGIN_SERVICE);

    public static void authRelogin(Context context) {
        ILoginService iLoginService2 = iLoginService;
        if (iLoginService2 != null) {
            iLoginService2.authReLogin(context);
        }
    }

    public static void forceReLogin(Context context) {
        ILoginService iLoginService2 = iLoginService;
        if (iLoginService2 != null) {
            iLoginService2.forceReLogin(context);
        }
    }

    public static void initRoleInfo(Context context) {
        ILoginService iLoginService2 = iLoginService;
        if (iLoginService2 != null) {
            iLoginService2.initRoleInfo(context);
        }
    }

    public static void login(Context context, LoginRegisterAccountForm loginRegisterAccountForm, OnBaseResponseListener<String> onBaseResponseListener) {
        ILoginService iLoginService2 = iLoginService;
        if (iLoginService2 != null) {
            iLoginService2.login(context, loginRegisterAccountForm, onBaseResponseListener);
        }
    }

    public static void logoutOnModifyPwd(Context context, long j, boolean z) {
        ILoginService iLoginService2 = iLoginService;
        if (iLoginService2 != null) {
            iLoginService2.logoutOnModifyPwd(context, j, z);
        }
    }

    public static void onClearUserPassword(String str, OnDaoResponseListener onDaoResponseListener) {
        ILoginService iLoginService2 = iLoginService;
        if (iLoginService2 != null) {
            iLoginService2.onClearUserPassword(str, onDaoResponseListener);
        }
    }

    public static void onConfirmPassword(Context context, String str) {
        ILoginService iLoginService2 = iLoginService;
        if (iLoginService2 != null) {
            iLoginService2.onConfirmPassword(context, str);
        }
    }

    public static void onSaveUser(String str, String str2, User user) {
        ILoginService iLoginService2 = iLoginService;
        if (iLoginService2 != null) {
            iLoginService2.onSaveUser(str, str2, user);
        }
    }

    public static void onSetPassword(Context context, String str) {
        ILoginService iLoginService2 = iLoginService;
        if (iLoginService2 != null) {
            iLoginService2.onSetPassword(context, str);
        }
    }

    public static void onSwitchAccount(Activity activity) {
        ILoginService iLoginService2 = iLoginService;
        if (iLoginService2 != null) {
            iLoginService2.onSwitchAccount(activity);
        }
    }

    public static void onUpdateAccount(String str, String str2) {
        ILoginService iLoginService2 = iLoginService;
        if (iLoginService2 != null) {
            iLoginService2.onUpdateAccount(str, str2);
        }
    }

    public static void onUpdatePassword(String str, String str2, String str3) {
        ILoginService iLoginService2 = iLoginService;
        if (iLoginService2 != null) {
            iLoginService2.onUpdatePassword(str, str2, str3);
        }
    }

    public static void onUpdateUser(User user) {
        ILoginService iLoginService2 = iLoginService;
        if (iLoginService2 != null) {
            iLoginService2.onUpdateUser(user);
        }
    }

    public static void paramCheck(Context context, String str, OnResponseListener<Long> onResponseListener) {
        ILoginService iLoginService2 = iLoginService;
        if (iLoginService2 != null) {
            iLoginService2.paramCheck(context, str, onResponseListener);
        }
    }

    public static void showProtocolDialog(Context context) {
        ILoginService iLoginService2 = iLoginService;
        if (iLoginService2 != null) {
            iLoginService2.showProtocolDialog(context);
        }
    }

    public static void showRegisterFinishDialog(Context context, ISuccessListener iSuccessListener, String str) {
        ILoginService iLoginService2 = iLoginService;
        if (iLoginService2 != null) {
            iLoginService2.showRegisterFinishDialog(context, iSuccessListener, str);
        }
    }

    public static void switchAccount(Context context) {
        ILoginService iLoginService2 = iLoginService;
        if (iLoginService2 != null) {
            iLoginService2.switchAccount(context);
        }
    }
}
