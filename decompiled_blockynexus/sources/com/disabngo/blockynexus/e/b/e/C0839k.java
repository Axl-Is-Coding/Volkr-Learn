package com.disabngo.blockynexus.e.b.e;

import android.content.Context;
import android.os.Bundle;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.entity.EmailBindForm;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.CommonHelper;
import java.util.ArrayList;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: renamed from: com.disabngo.blockynexus.e.b.e.k, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BindEmailViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class C0839k extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f9731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Bundle f9732b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ArrayList<String> f9734d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f9735e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ObservableField<String> f9736f = new ObservableField<>(BaseApplication.getContext().getResources().getString(R.string.sendCode));
    public ObservableField<Boolean> g = new ObservableField<>(true);
    public ObservableField<Boolean> h = new ObservableField<>(true);
    public ObservableField<Boolean> i = new ObservableField<>(true);
    public ObservableField<Boolean> j = new ObservableField<>(false);
    public ObservableField<String> k = new ObservableField<>("");
    public ReplyCommand l = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.e.c
        @Override // rx.functions.Action0
        public final void call() {
            this.f9724a.i();
        }
    });
    public ReplyCommand m = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.e.b
        @Override // rx.functions.Action0
        public final void call() {
            this.f9723a.f();
        }
    });
    public ReplyCommand<String> n = new ReplyCommand<>(new Action1() { // from class: com.disabngo.blockynexus.e.b.e.e
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f9726a.a((String) obj);
        }
    });
    public ReplyCommand<String> o = new ReplyCommand<>(new Action1() { // from class: com.disabngo.blockynexus.e.b.e.d
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f9725a.b((String) obj);
        }
    });
    public ReplyCommand p = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.e.a
        @Override // rx.functions.Action0
        public final void call() {
            this.f9722a.j();
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private EmailBindForm f9733c = new EmailBindForm();

    public C0839k(Context context, Bundle bundle) {
        this.f9731a = context;
        this.f9732b = bundle;
        initData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        new CountDownTimerC0836h(this, 60000L, 1000L).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.f9733c.getVerifyCode() == null || "".equals(this.f9733c.getVerifyCode())) {
            AppToastUtils.showShortPositiveTipToast(this.f9731a, R.string.bind_phone_code_is_empty);
        } else {
            new C0835g().a(this.f9731a, this.f9735e ? "v2" : "v1", this.f9733c, this.f9734d, new C0838j(this));
        }
    }

    private void initData() {
        Bundle bundle = this.f9732b;
        if (bundle != null) {
            this.f9734d = bundle.getStringArrayList(StringConstant.SECRET_ANSWER);
            ArrayList<String> arrayList = this.f9734d;
            if (arrayList == null || arrayList.size() <= 1) {
                return;
            }
            this.f9735e = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        a(true);
    }

    public /* synthetic */ void f() {
        a(false);
    }

    public /* synthetic */ void a(String str) {
        this.f9733c.setEmail(str);
    }

    public /* synthetic */ void b(String str) {
        this.f9733c.setVerifyCode(str);
    }

    private void a(boolean z) {
        this.j.set(false);
        if (this.f9733c.getEmail() == null) {
            AppToastUtils.showShortPositiveTipToast(this.f9731a, R.string.account_email_is_empty);
            return;
        }
        if (!CommonHelper.isEmail(this.f9733c.getEmail())) {
            AppToastUtils.showShortPositiveTipToast(this.f9731a, R.string.bind_email_pattern_error);
            return;
        }
        if (z) {
            this.h.set(false);
            h();
        }
        new C0835g().a(this.f9731a, this.f9733c.getEmail(), new C0837i(this, z));
    }
}
