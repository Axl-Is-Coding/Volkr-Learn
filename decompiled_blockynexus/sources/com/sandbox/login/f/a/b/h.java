package com.sandbox.login.f.a.b;

import android.content.Context;
import android.text.TextUtils;
import androidx.databinding.ObservableField;
import com.sandbox.login.R;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.ChangePasswordForm;
import com.sandboxol.center.entity.SetPasswordForm;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.utils.AppToastUtils;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: ChangePasswordViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class h extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f15778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f15779b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ChangePasswordForm f15780c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private SetPasswordForm f15781d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObservableField<Boolean> f15782e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ObservableField<Boolean> f15783f;
    public ReplyCommand<String> g;
    public ReplyCommand<String> h;
    public ReplyCommand i;

    public h(Context context, String str) {
        this.f15779b = "";
        this.f15782e = new ObservableField<>(false);
        this.f15783f = new ObservableField<>(false);
        this.g = new ReplyCommand<>(new Action1() { // from class: com.sandbox.login.f.a.b.c
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f15774a.a((String) obj);
            }
        });
        this.h = new ReplyCommand<>(new Action1() { // from class: com.sandbox.login.f.a.b.b
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f15773a.b((String) obj);
            }
        });
        this.i = new ReplyCommand(new Action0() { // from class: com.sandbox.login.f.a.b.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f15772a.f();
            }
        });
        this.f15778a = context;
        this.f15779b = str;
        this.f15780c = new ChangePasswordForm();
        this.f15781d = new SetPasswordForm();
        this.f15783f.set(Boolean.valueOf(!AccountCenter.newInstance().hasPassword.get().booleanValue() || TextUtils.equals(AccountCenter.newInstance().account.get(), context.getString(R.string.base_more_user_no_account))));
    }

    private void h() {
        if (this.f15780c.getOldPassword() == null) {
            AppToastUtils.showShortNegativeTipToast(this.f15778a, R.string.login_change_password_old_empty);
            return;
        }
        if (this.f15780c.getNewPassword() == null) {
            AppToastUtils.showShortNegativeTipToast(this.f15778a, R.string.login_change_password_new_empty);
            return;
        }
        if (this.f15780c.getOldPassword().length() < 6 || this.f15780c.getNewPassword().length() < 6) {
            AppToastUtils.showShortNegativeTipToast(this.f15778a, R.string.login_account_password_less_6);
        } else if (this.f15780c.getNewPassword().equals(this.f15780c.getConfirmPassword())) {
            new e(this.f15780c).loadData(this.f15778a, new f(this));
        } else {
            AppToastUtils.showShortNegativeTipToast(this.f15778a, R.string.login_account_password_not_compare);
        }
    }

    private void i() {
        if (this.f15781d.getPassword() == null) {
            AppToastUtils.showShortNegativeTipToast(this.f15778a, R.string.login_account_confirm_password_empty);
            return;
        }
        if (this.f15781d.getPassword().length() < 6) {
            AppToastUtils.showShortNegativeTipToast(this.f15778a, R.string.login_account_password_less_6);
        } else if (!this.f15781d.getPassword().equals(this.f15781d.getConfirmPassword())) {
            AppToastUtils.showShortNegativeTipToast(this.f15778a, R.string.login_account_password_not_compare);
        } else {
            this.f15781d.setUserId(AccountCenter.newInstance().userId.get());
            com.sandbox.login.web.b.a(this.f15778a, this.f15781d, new g(this));
        }
    }

    public /* synthetic */ void f() {
        if (TextUtils.equals(this.f15779b, this.f15778a.getString(R.string.login_more_set_account))) {
            i();
        } else if (AccountCenter.newInstance().hasPassword.get().booleanValue()) {
            h();
        } else {
            i();
        }
    }

    public /* synthetic */ void a(String str) {
        this.f15781d.setPassword(str);
        this.f15780c.setNewPassword(str);
    }

    public /* synthetic */ void b(String str) {
        this.f15781d.setConfirmPassword(str);
        this.f15780c.setConfirmPassword(str);
    }

    public h(Context context, String str, String str2) {
        this(context, str);
        this.f15780c.setOldPassword(str2);
    }
}
