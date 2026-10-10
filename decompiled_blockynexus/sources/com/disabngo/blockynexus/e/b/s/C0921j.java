package com.disabngo.blockynexus.e.b.s;

import android.content.Context;
import android.os.CountDownTimer;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.e.b.e.C0835g;
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

/* JADX INFO: renamed from: com.disabngo.blockynexus.e.b.s.j, reason: case insensitive filesystem */
/* JADX INFO: compiled from: EmailViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class C0921j extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f10162a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private CountDownTimer f10164c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObservableField<Boolean> f10165d = new ObservableField<>(true);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObservableField<Boolean> f10166e = new ObservableField<>(false);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ReplyCommand f10167f = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.s.b
        @Override // rx.functions.Action0
        public final void call() {
            this.f10156a.f();
        }
    });
    public ReplyCommand g = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.s.c
        @Override // rx.functions.Action0
        public final void call() {
            this.f10157a.k();
        }
    });
    public ObservableField<String> j = new ObservableField<>(BaseApplication.getContext().getResources().getString(R.string.resend));
    public ObservableField<String> k = new ObservableField<>("");
    public ObservableField<Boolean> l = new ObservableField<>(true);
    public ReplyCommand m = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.s.d
        @Override // rx.functions.Action0
        public final void call() {
            this.f10158a.i();
        }
    });
    public ReplyCommand<String> n = new ReplyCommand<>(new Action1() { // from class: com.disabngo.blockynexus.e.b.s.a
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f10155a.a((String) obj);
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private C0917f f10163b = new C0917f();
    private EmailBindForm h = new EmailBindForm();
    private VerifyEmailForm i = new VerifyEmailForm();

    public C0921j(Context context) {
        this.f10162a = context;
        this.h.setEmail(AccountCenter.newInstance().email.get());
        this.i.setEmail(AccountCenter.newInstance().email.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.f10165d.set(false);
        j();
    }

    private void h() {
        this.f10164c = new CountDownTimerC0918g(this, 60000L, 1000L);
        this.f10164c.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        j();
    }

    private void j() {
        this.f10166e.set(false);
        if (this.h.getEmail() == null) {
            AppToastUtils.showShortPositiveTipToast(this.f10162a, R.string.account_email_is_empty);
        } else if (!CommonHelper.isEmail(this.h.getEmail())) {
            AppToastUtils.showShortPositiveTipToast(this.f10162a, R.string.bind_email_pattern_error);
        } else {
            h();
            new C0835g().b(this.f10162a, this.h.getEmail(), new C0919h(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.i.getEmail() == null) {
            return;
        }
        if (this.i.getVerifyCode() == null || "".equals(this.i.getVerifyCode())) {
            AppToastUtils.showShortNegativeTipToast(this.f10162a, R.string.bind_phone_code_is_empty);
        } else {
            this.f10163b.a(this.f10162a, this.i.getEmail(), this.i.getVerifyCode(), new C0920i(this));
        }
    }

    public /* synthetic */ void a(String str) {
        this.h.setVerifyCode(str);
        this.i.setVerifyCode(str);
    }
}
