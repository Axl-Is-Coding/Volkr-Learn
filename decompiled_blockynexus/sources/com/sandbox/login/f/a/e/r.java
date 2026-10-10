package com.sandbox.login.f.a.e;

import android.app.Activity;
import android.content.Intent;
import androidx.databinding.ObservableField;
import com.sandbox.login.R;
import com.sandbox.login.view.activity.login.LoginActivity;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import rx.functions.Action0;

/* JADX INFO: compiled from: AccountRecordViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class r extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Activity f15872a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public o f15875d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ObservableField<String> f15873b = new ObservableField<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public n f15874c = new n();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ReplyCommand f15876e = new ReplyCommand(new Action0() { // from class: com.sandbox.login.f.a.e.g
        @Override // rx.functions.Action0
        public final void call() {
            this.f15856a.f();
        }
    });

    public r(Activity activity) {
        this.f15872a = activity;
        this.f15875d = new o(activity, this.f15873b, R.string.login_account_no_data);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Intent intent = new Intent(this.f15872a, (Class<?>) LoginActivity.class);
        intent.putExtra("key.is.with.back.btn", true);
        intent.putExtra("key.is.with.register", true);
        intent.putExtra("key.is.fill.default.account.info", false);
        this.f15872a.startActivity(intent);
    }
}
