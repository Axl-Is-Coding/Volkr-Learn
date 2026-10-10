package com.sandbox.login.f.a.c;

import android.content.Context;
import android.text.TextUtils;
import androidx.databinding.ObservableField;
import com.sandbox.login.R;
import com.sandbox.login.c.x;
import com.sandbox.login.view.activity.login.y;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.utils.AppToastUtils;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: ConfirmPasswordViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class g extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f15792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f15793b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f15794c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObservableField<Boolean> f15795d = new ObservableField<>(false);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ReplyCommand<String> f15796e = new ReplyCommand<>(new Action1() { // from class: com.sandbox.login.f.a.c.b
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f15785a.a((String) obj);
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ReplyCommand f15797f = new ReplyCommand(new Action0() { // from class: com.sandbox.login.f.a.c.a
        @Override // rx.functions.Action0
        public final void call() {
            this.f15784a.f();
        }
    });
    private x g;

    public g(Context context, String str, x xVar) {
        this.f15792a = context;
        this.f15793b = str;
        this.g = xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (TextUtils.isEmpty(this.f15794c)) {
            AppToastUtils.showShortNegativeTipToast(this.f15792a, R.string.login_account_password_empty);
        } else if (this.f15794c.length() < 6) {
            AppToastUtils.showShortNegativeTipToast(this.f15792a, R.string.login_account_password_less_6);
        } else {
            new e().a(this.f15792a, this.f15794c, this.f15795d, this.f15793b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        this.f15794c = str;
        y.a(this.f15792a, str, new f(this));
    }
}
