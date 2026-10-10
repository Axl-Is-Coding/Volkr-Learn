package com.disabngo.blockynexus.e.b.ea;

import android.app.Activity;
import android.content.Context;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.EmailBindForm;
import com.sandboxol.center.entity.SecurityVerifyResponse;
import com.sandboxol.center.entity.VerifyEmailForm;
import com.sandboxol.center.view.dialog.TwoButtonDialog;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.utils.AppToastUtils;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: SecretEmailVerifyViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class k extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f9747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private f f9748b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private EmailBindForm f9749c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private VerifyEmailForm f9750d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ReplyCommand<String> f9751e = new ReplyCommand<>(new Action1() { // from class: com.disabngo.blockynexus.e.b.ea.b
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f9738a.a((String) obj);
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ReplyCommand f9752f = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.ea.c
        @Override // rx.functions.Action0
        public final void call() {
            this.f9739a.h();
        }
    });
    public ObservableField<String> g = new ObservableField<>(BaseApplication.getContext().getResources().getString(R.string.resend));
    public ObservableField<String> h;
    public ObservableField<Boolean> i;
    public ReplyCommand j;

    public k(Context context) {
        this.h = new ObservableField<>(AccountCenter.newInstance().email.get() != null ? String.format(BaseApplication.getContext().getResources().getString(R.string.safe_tips), String.format("%s*****@%s", AccountCenter.newInstance().email.get().split("@")[0].substring(0, 4), AccountCenter.newInstance().email.get().split("@")[1])) : "");
        this.i = new ObservableField<>(true);
        this.j = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.ea.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f9737a.j();
            }
        });
        this.f9747a = context;
        this.f9748b = new f();
        this.f9749c = new EmailBindForm();
        this.f9750d = new VerifyEmailForm();
        this.f9749c.setEmail(AccountCenter.newInstance().email.get());
        this.f9750d.setEmail(AccountCenter.newInstance().email.get());
        f();
    }

    private void f() {
        new g(this, 60000L, 1000L).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        i();
    }

    private void i() {
        f();
        if (this.f9749c.getEmail() == null || "".equals(this.f9749c.getEmail())) {
            if (AccountCenter.newInstance().email.get() == null || "".equals(AccountCenter.newInstance().email.get())) {
                AppToastUtils.showShortPositiveTipToast(this.f9747a, R.string.account_email_is_empty);
                return;
            }
            this.f9749c.setEmail(AccountCenter.newInstance().email.get());
        }
        this.f9748b.a(this.f9747a, this.f9749c.getEmail(), new h(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.f9750d.getEmail() == null || "".equals(this.f9750d.getEmail())) {
            if (AccountCenter.newInstance().email.get() == null || "".equals(AccountCenter.newInstance().email.get())) {
                AppToastUtils.showShortPositiveTipToast(this.f9747a, R.string.account_email_is_empty);
                return;
            }
            this.f9750d.setEmail(AccountCenter.newInstance().email.get());
        }
        if (this.f9750d.getVerifyCode() == null || "".equals(this.f9750d.getVerifyCode())) {
            AppToastUtils.showShortPositiveTipToast(this.f9747a, R.string.bind_phone_code_is_empty);
        } else {
            this.f9748b.a(this.f9747a, this.f9750d, new i(this));
        }
    }

    void onBack() {
        final TwoButtonDialog twoButtonDialog = new TwoButtonDialog(this.f9747a);
        twoButtonDialog.setTitleText(this.f9747a.getResources().getString(R.string.tip));
        twoButtonDialog.setLeftButtonText(R.string.cancel);
        twoButtonDialog.setRightButtonText(R.string.confirm);
        twoButtonDialog.setDetailText(R.string.not_verify_secret_question_tips);
        twoButtonDialog.setListener(new TwoButtonDialog.OnTwoButtonDialogClickListener() { // from class: com.disabngo.blockynexus.e.b.ea.d
            @Override // com.sandboxol.center.view.dialog.TwoButtonDialog.OnTwoButtonDialogClickListener
            public final void onClick() {
                this.f9740a.a(twoButtonDialog);
            }
        });
        twoButtonDialog.show();
    }

    public /* synthetic */ void a(String str) {
        this.f9749c.setVerifyCode(str);
        this.f9750d.setVerifyCode(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SecurityVerifyResponse securityVerifyResponse) {
        this.f9748b.a(this.f9747a, 0, new j(this, securityVerifyResponse));
    }

    public /* synthetic */ void a(TwoButtonDialog twoButtonDialog) {
        twoButtonDialog.dismiss();
        ((Activity) this.f9747a).finish();
    }
}
