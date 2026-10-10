package com.sandbox.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.sandbox.login.d.t;
import com.sandbox.login.view.activity.login.LoginActivity;
import com.sandbox.login.view.activity.login.y;
import com.sandbox.login.view.activity.makerole.MakeRoleActivity;
import com.sandbox.login.view.dialog.ProtocolDialog;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.LoginRegisterAccountForm;
import com.sandboxol.center.listener.ISuccessListener;
import com.sandboxol.center.router.base.OnBaseResponseListener;
import com.sandboxol.center.router.moduleApi.ILoginService;
import com.sandboxol.center.router.path.RouterServicePath;
import com.sandboxol.center.view.dialog.LoadingDialog;
import com.sandboxol.common.base.dao.OnDaoResponseListener;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.TemplateHelper;
import com.sandboxol.greendao.entity.User;
import java.util.List;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes2.dex */
@Route(path = RouterServicePath.EventLogin.LOGIN_SERVICE)
public class LoginService implements ILoginService {
    private void a(Activity activity, boolean z) {
        if (!AccountCenter.newInstance().hasPassword.get().booleanValue() || AccountCenter.newInstance().userId.get().longValue() == 0) {
            new LoadingDialog(activity).show();
            com.sandbox.login.web.b.b(activity, "1", new k(this, activity, z));
            ReportDataAdapter.onEvent(activity, EventConstant.ENTER_TIPSPAGE);
        } else if (z) {
            new LoginService().switchAccount(activity);
        } else {
            TemplateHelper.startTemplateForResult(activity, com.sandbox.login.f.a.e.h.class, activity.getString(R.string.login_switch_account), 0);
        }
    }

    @Override // com.sandboxol.center.router.moduleApi.ILoginService
    public void authReLogin(Context context) {
        com.sandbox.login.web.b.a(context, new i(this, context));
    }

    @Override // com.sandboxol.center.router.moduleApi.ILoginService
    public void forceReLogin(Context context) {
        Intent intent = new Intent(context, (Class<?>) LoginActivity.class);
        intent.putExtra("key.is.with.back.btn", false);
        intent.putExtra("key.is.with.register", true);
        context.startActivity(intent);
    }

    @Override // com.sandboxol.center.router.moduleApi.IBaseService, com.alibaba.android.arouter.facade.template.IProvider
    public void init(Context context) {
    }

    @Override // com.sandboxol.center.router.moduleApi.ILoginService
    public void initRoleInfo(Context context) {
        context.startActivity(new Intent(context, (Class<?>) MakeRoleActivity.class));
    }

    @Override // com.sandboxol.center.router.moduleApi.ILoginService
    public void login(Context context, LoginRegisterAccountForm loginRegisterAccountForm, OnBaseResponseListener<String> onBaseResponseListener) {
        new y().a(context, loginRegisterAccountForm, onBaseResponseListener);
    }

    @Override // com.sandboxol.center.router.moduleApi.ILoginService
    public void logoutOnModifyPwd(Context context, long j, boolean z) {
        new y().a(context, j, z);
    }

    @Override // com.sandboxol.center.router.moduleApi.ILoginService
    public void onClearUserPassword(String str, OnDaoResponseListener onDaoResponseListener) {
        t.a().a(str, onDaoResponseListener);
    }

    @Override // com.sandboxol.center.router.moduleApi.ILoginService
    public void onConfirmPassword(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("confirm.fragment.title", str);
        TemplateHelper.startTemplate(context, com.sandbox.login.f.a.c.c.class, str, bundle);
    }

    @Override // com.sandboxol.center.router.moduleApi.ILoginService
    public void onSaveUser(String str, String str2, User user) {
        t.a().a(str, str2, user);
    }

    @Override // com.sandboxol.center.router.moduleApi.ILoginService
    public void onSetPassword(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("confirm.fragment.title", str);
        TemplateHelper.startTemplate(context, com.sandbox.login.f.a.b.d.class, str, bundle);
    }

    @Override // com.sandboxol.center.router.moduleApi.ILoginService
    public void onSwitchAccount(final Activity activity) {
        com.sandbox.login.a.b.a().a(new Action1() { // from class: com.sandbox.login.f
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f15756a.a(activity, (List) obj);
            }
        });
    }

    @Override // com.sandboxol.center.router.moduleApi.ILoginService
    public void onUpdateAccount(String str, String str2) {
        t.a().a(str, str2);
    }

    @Override // com.sandboxol.center.router.moduleApi.ILoginService
    public void onUpdatePassword(String str, String str2, String str3) {
        t.a().a(str, str2, str3);
    }

    @Override // com.sandboxol.center.router.moduleApi.ILoginService
    public void onUpdateUser(User user) {
        t.a().a(user);
    }

    @Override // com.sandboxol.center.router.moduleApi.ILoginService
    public void paramCheck(Context context, String str, OnResponseListener<Long> onResponseListener) {
        com.sandbox.login.web.b.b(context, str, onResponseListener);
    }

    @Override // com.sandboxol.center.router.moduleApi.ILoginService
    public void showProtocolDialog(Context context) {
        new ProtocolDialog(context).show();
    }

    @Override // com.sandboxol.center.router.moduleApi.ILoginService
    public void showRegisterFinishDialog(Context context, ISuccessListener iSuccessListener, String str) {
        new com.sandbox.login.view.dialog.f(context, iSuccessListener, str).show();
    }

    @Override // com.sandboxol.center.router.moduleApi.ILoginService
    public void switchAccount(Context context) {
        Intent intent = new Intent(context, (Class<?>) LoginActivity.class);
        intent.putExtra("key.is.with.back.btn", true);
        intent.putExtra("key.is.with.register", true);
        context.startActivity(intent);
    }

    public /* synthetic */ void a(Activity activity, List list) {
        if (list.size() > 1) {
            a(activity, false);
        } else {
            a(activity, true);
        }
    }
}
