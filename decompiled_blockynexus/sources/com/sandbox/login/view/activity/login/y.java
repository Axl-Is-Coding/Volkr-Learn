package com.sandbox.login.view.activity.login;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.sandbox.login.R;
import com.sandbox.login.entity.UserRecord;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.LoginRegisterAccountForm;
import com.sandboxol.center.router.base.OnBaseResponseListener;
import com.sandboxol.center.web.UserApi;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.utils.DateUtils;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.greendao.entity.User;
import java.util.Map;

/* JADX INFO: compiled from: LoginModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class y {

    /* JADX INFO: compiled from: LoginModel.java */
    public interface a {
        void a();

        void a(String str);

        void b(String str);

        void onSuccess();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context) {
        SharedUtils.putInt(context, SharedConstant.PASSWORD_WRONG_TIMES, SharedUtils.getInt(context, SharedConstant.PASSWORD_WRONG_TIMES) + 1);
        SharedUtils.putString(context, SharedConstant.PASSWORD_WRONG_TIMES_DATE, DateUtils.timeStamp2Date(System.currentTimeMillis(), "yyyy-MM-dd HH"));
        SharedUtils.putLong(context, SharedConstant.PASSWORD_WRONG_ONE_HOUR_RETRY, System.currentTimeMillis());
    }

    public static void a(Context context, String str, a aVar) {
        if (context == null || str == null || aVar == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            aVar.b(context.getString(R.string.login_account_password_empty));
        } else if (TextUtils.isEmpty(str) || str.length() < 6) {
            aVar.b(context.getString(R.string.login_account_password_less_6));
        } else {
            aVar.onSuccess();
        }
    }

    public static void a(Context context, LoginRegisterAccountForm loginRegisterAccountForm, Map<String, UserRecord> map, a aVar) {
        if (context == null || loginRegisterAccountForm == null || aVar == null) {
            return;
        }
        if (TextUtils.isEmpty(loginRegisterAccountForm.getUid())) {
            aVar.a(context.getString(R.string.login_account_account_empty));
            return;
        }
        if (map != null && map.containsKey(loginRegisterAccountForm.getUid()) && map.get(loginRegisterAccountForm.getUid()) != null && !map.get(loginRegisterAccountForm.getUid()).isHasPassword()) {
            aVar.a(context.getString(R.string.login_guest_password_tips));
            return;
        }
        if (TextUtils.isEmpty(loginRegisterAccountForm.getPassword())) {
            aVar.b(context.getString(R.string.login_account_password_empty));
        } else if (!TextUtils.isEmpty(loginRegisterAccountForm.getPassword()) && loginRegisterAccountForm.getPassword().length() >= 6) {
            aVar.onSuccess();
        } else {
            aVar.b(context.getString(R.string.login_account_password_less_6));
        }
    }

    public void a(Context context, LoginRegisterAccountForm loginRegisterAccountForm, OnBaseResponseListener onBaseResponseListener) {
        a(context, loginRegisterAccountForm, new s(this, context, onBaseResponseListener));
    }

    public void a(Context context, long j, boolean z) {
        if (AccountCenter.newInstance().userId.get().longValue() != 0 && j != AccountCenter.newInstance().userId.get().longValue()) {
            ((Activity) context).finish();
        } else {
            UserApi.logout(context, new u(this, z, context));
        }
    }

    public void a(Context context, LoginRegisterAccountForm loginRegisterAccountForm, a aVar) {
        if (context == null || loginRegisterAccountForm == null || aVar == null) {
            return;
        }
        if (TextUtils.isEmpty(loginRegisterAccountForm.getUid())) {
            aVar.a(context.getString(R.string.login_account_account_empty));
            return;
        }
        if (TextUtils.isEmpty(loginRegisterAccountForm.getPassword())) {
            aVar.b(context.getString(R.string.login_account_password_empty));
            return;
        }
        if (loginRegisterAccountForm.getPassword().length() < 6) {
            aVar.b(context.getString(R.string.login_account_password_less_6));
            return;
        }
        v vVar = new v(this, context, loginRegisterAccountForm, aVar);
        if (loginRegisterAccountForm.getPlatform() != null && loginRegisterAccountForm.getPlatform().contains(StringConstant.THIRD_PART_LOGIN_FB)) {
            com.sandbox.login.web.b.a(loginRegisterAccountForm, vVar);
        } else if (a(context)) {
            aVar.a(context.getString(R.string.login_too_quick));
        } else {
            com.sandbox.login.web.b.a(context, loginRegisterAccountForm, vVar);
        }
    }

    public void a(Context context, User user, LoginRegisterAccountForm loginRegisterAccountForm, a aVar) {
        a(user);
        AccountCenter.newInstance().hasPassword.set(true);
        UserApi.updateUserInfo(context, new x(this, context, loginRegisterAccountForm, aVar));
    }

    public void a(User user) {
        AccountCenter.newInstance().setUserId(user.getUserId());
        AccountCenter.newInstance().setToken(user.getAccessToken());
        BaseApplication.getApp().setAccessToken(user.getAccessToken());
        BaseApplication.getApp().setUserId(user.getUserId());
        AccountCenter.putAccountInfo();
    }

    private boolean a(Context context) {
        if (SharedUtils.getInt(context, SharedConstant.PASSWORD_WRONG_TIMES) > 10) {
            if (DateUtils.timeStamp2Date(System.currentTimeMillis(), "yyyy-MM-dd HH").equals(SharedUtils.getString(context, SharedConstant.PASSWORD_WRONG_TIMES_DATE))) {
                return true;
            }
            SharedUtils.putInt(context, SharedConstant.PASSWORD_WRONG_TIMES, 0);
            SharedUtils.putString(context, SharedConstant.PASSWORD_WRONG_TIMES_DATE, DateUtils.timeStamp2Date(System.currentTimeMillis(), "yyyy-MM-dd HH"));
            SharedUtils.putLong(context, SharedConstant.PASSWORD_WRONG_ONE_HOUR_RETRY, 0L);
        }
        return false;
    }
}
