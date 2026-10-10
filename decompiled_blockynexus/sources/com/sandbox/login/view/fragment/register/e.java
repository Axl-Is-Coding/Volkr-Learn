package com.sandbox.login.view.fragment.register;

import androidx.databinding.ObservableField;
import androidx.fragment.app.AbstractC0336n;
import androidx.fragment.app.F;
import com.sandbox.login.R;
import com.sandbox.login.f.a.d.s;
import com.sandbox.login.f.a.f.m;
import com.sandboxol.center.entity.SetPasswordForm;
import com.sandboxol.common.base.app.BaseActivity;
import com.sandboxol.common.base.app.BaseFragment;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.messenger.Messenger;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: RegisterViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class e extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BaseActivity f15996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private m f15997b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private s f15998c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private BaseFragment f15999d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObservableField<Boolean> f16000e = new ObservableField<>(false);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ReplyCommand f16001f = new ReplyCommand(new Action0() { // from class: com.sandbox.login.view.fragment.register.b
        @Override // rx.functions.Action0
        public final void call() {
            this.f15993a.onBack();
        }
    });

    public e(BaseActivity baseActivity) {
        this.f15996a = baseActivity;
        j();
        initMessenger();
    }

    private void initMessenger() {
        Messenger.getDefault().register(this, "token.do.next.step", SetPasswordForm.class, new Action1() { // from class: com.sandbox.login.view.fragment.register.c
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f15994a.a((SetPasswordForm) obj);
            }
        });
        Messenger.getDefault().register(this, "token.do.last.step", new Action0() { // from class: com.sandbox.login.view.fragment.register.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f15992a.h();
            }
        });
    }

    private void j() {
        AbstractC0336n supportFragmentManager = this.f15996a.getSupportFragmentManager();
        F fA = supportFragmentManager.a();
        if (this.f15997b == null) {
            this.f15997b = new m();
            if (supportFragmentManager.a("StepFragment") == null) {
                fA.a(R.id.fl_frg, this.f15997b, "StepFragment");
                fA.e(this.f15997b);
            }
        }
        fA.b();
        this.f15999d = this.f15997b;
        new d(this, 1000L, 1000L).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onBack() {
        if (this.f16000e.get().booleanValue()) {
            a(this.f15997b);
            this.f16000e.set(false);
            return;
        }
        BaseActivity baseActivity = this.f15996a;
        if (baseActivity == null || baseActivity.isFinishing()) {
            return;
        }
        this.f15996a.finish();
    }

    public boolean f() {
        return this.f16000e.get().booleanValue();
    }

    public /* synthetic */ void h() {
        a(this.f15997b);
        this.f15999d = this.f15997b;
        this.f16000e.set(false);
    }

    public void i() {
        a(this.f15997b);
        this.f16000e.set(false);
    }

    public /* synthetic */ void a(SetPasswordForm setPasswordForm) {
        a(this.f15998c);
        this.f15999d = this.f15998c;
        this.f16000e.set(true);
        this.f15998c.a(setPasswordForm);
    }

    private void a(BaseFragment baseFragment) {
        F fA = this.f15996a.getSupportFragmentManager().a();
        fA.a(0);
        BaseFragment baseFragment2 = this.f15999d;
        if (baseFragment2 != null) {
            fA.c(baseFragment2);
        }
        fA.e(baseFragment);
        fA.b();
    }
}
