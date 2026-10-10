package com.disabngo.blockynexus.e.b.ga;

import android.content.Context;
import android.os.CountDownTimer;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.EmailBindForm;
import com.sandboxol.center.entity.VerifyEmailForm;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.CommonHelper;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: SecretQuestionUnbindViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class j extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f9795a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private CountDownTimer f9798d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObservableField<Boolean> f9799e = new ObservableField<>(true);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ObservableField<String> f9800f = new ObservableField<>(BaseApplication.getContext().getResources().getString(R.string.resend));
    public ObservableField<String> g = new ObservableField<>("");
    public ObservableField<Boolean> h = new ObservableField<>(true);
    public ObservableField<Boolean> i = new ObservableField<>(false);
    public ReplyCommand k = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.ga.a
        @Override // rx.functions.Action0
        public final void call() {
            this.f9788a.j();
        }
    });
    public ReplyCommand l = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.ga.c
        @Override // rx.functions.Action0
        public final void call() {
            this.f9790a.h();
        }
    });
    public ReplyCommand<String> m = new ReplyCommand<>(new Action1() { // from class: com.disabngo.blockynexus.e.b.ga.b
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f9789a.a((String) obj);
        }
    });
    public ReplyCommand n = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.ga.d
        @Override // rx.functions.Action0
        public final void call() {
            this.f9791a.f();
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private f f9796b = new f();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private EmailBindForm f9797c = new EmailBindForm();
    private VerifyEmailForm j = new VerifyEmailForm();

    public j(Context context) {
        this.f9795a = context;
        this.f9797c.setEmail(AccountCenter.newInstance().email.get());
        this.j.setEmail(AccountCenter.newInstance().email.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.j.getVerifyCode() == null || "".equals(this.j.getVerifyCode())) {
            AppToastUtils.showShortNegativeTipToast(this.f9795a, R.string.bind_phone_code_is_empty);
        } else {
            this.f9796b.a(this.f9795a, this.j, new h(this));
        }
    }

    private void i() {
        this.f9798d = new i(this, 60000L, 1000L);
        this.f9798d.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        k();
    }

    private void k() {
        this.f9799e.set(false);
        this.i.set(false);
        if (this.f9797c.getEmail() == null) {
            AppToastUtils.showShortPositiveTipToast(this.f9795a, R.string.account_email_is_empty);
        } else if (!CommonHelper.isEmail(this.f9797c.getEmail())) {
            AppToastUtils.showShortPositiveTipToast(this.f9795a, R.string.bind_email_pattern_error);
        } else {
            i();
            this.f9796b.a(this.f9795a, this.f9797c.getEmail(), new g(this));
        }
    }

    public /* synthetic */ void f() {
        if ("".equals(AccountCenter.newInstance().email.get()) || AccountCenter.newInstance().email.get() == null) {
            AppToastUtils.showShortNegativeTipToast(this.f9795a, R.string.bind_secret_question_tips);
        } else {
            k();
        }
    }

    public /* synthetic */ void a(String str) {
        this.f9797c.setVerifyCode(str);
        this.j.setVerifyCode(str);
    }
}
