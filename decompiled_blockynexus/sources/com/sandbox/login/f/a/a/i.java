package com.sandbox.login.f.a.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.databinding.ObservableField;
import com.sandbox.login.R;
import com.sandbox.login.c.F;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.utils.AppToastUtils;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: SetAccountViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class i extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f15766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f15767b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObservableField<Boolean> f15768c = new ObservableField<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ReplyCommand<String> f15769d = new ReplyCommand<>(new Action1() { // from class: com.sandbox.login.f.a.a.c
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f15760a.a((String) obj);
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ReplyCommand f15770e = new ReplyCommand(new Action0() { // from class: com.sandbox.login.f.a.a.b
        @Override // rx.functions.Action0
        public final void call() {
            this.f15759a.f();
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private F f15771f;

    public i(F f2, Context context) {
        this.f15766a = context;
        this.f15771f = f2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (TextUtils.isEmpty(this.f15767b)) {
            AppToastUtils.showShortPositiveTipToast(this.f15766a, R.string.base_set_account_empty);
            return;
        }
        if (this.f15767b.length() < 6) {
            AppToastUtils.showShortPositiveTipToast(this.f15766a, R.string.base_set_account_less_6);
        } else if (com.sandbox.login.e.e.a(this.f15767b)) {
            com.sandbox.login.web.b.a(this.f15766a, this.f15767b, AccountCenter.newInstance().userId.get().longValue(), "2", new h(this));
        } else {
            AppToastUtils.showShortPositiveTipToast(this.f15766a, R.string.base_set_account_error);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        this.f15767b = str;
        g.a(this.f15766a, str, this.f15771f.f15607a);
    }
}
