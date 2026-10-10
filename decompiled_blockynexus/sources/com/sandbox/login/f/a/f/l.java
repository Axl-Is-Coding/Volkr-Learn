package com.sandbox.login.f.a.f;

import android.app.Activity;
import android.content.Context;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import com.sandbox.login.R;
import com.sandbox.login.c.H;
import com.sandbox.login.view.dialog.ProtocolDialog;
import com.sandboxol.center.entity.SetPasswordForm;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.utils.AppToastUtils;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: compiled from: RegisterStep1ViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class l extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Activity f15888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private H f15889b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObservableField<Boolean> f15891d = new ObservableField<>(true);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ReplyCommand f15892e = new ReplyCommand(new Action0() { // from class: com.sandbox.login.f.a.f.g
        @Override // rx.functions.Action0
        public final void call() {
            this.f15883a.h();
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ReplyCommand f15893f = new ReplyCommand(new Action0() { // from class: com.sandbox.login.f.a.f.f
        @Override // rx.functions.Action0
        public final void call() {
            this.f15882a.i();
        }
    });
    public ReplyCommand<String> g = new ReplyCommand<>(new Action1() { // from class: com.sandbox.login.f.a.f.c
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f15879a.c((String) obj);
        }
    });
    public ReplyCommand<String> h = new ReplyCommand<>(new Action1() { // from class: com.sandbox.login.f.a.f.b
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f15878a.b((String) obj);
        }
    });
    public ObservableField<String> i = new ObservableField<>("");
    public ReplyCommand<String> j = new ReplyCommand<>(new Action1() { // from class: com.sandbox.login.f.a.f.e
        @Override // rx.functions.Action1
        public final void call(Object obj) {
            this.f15881a.a((String) obj);
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private SetPasswordForm f15890c = new SetPasswordForm();

    public l(Activity activity, H h) {
        this.f15888a = activity;
        this.f15889b = h;
        h.f15614b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.sandbox.login.f.a.f.d
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.f15880a.a(compoundButton, z);
            }
        });
        h.f15616d.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.sandbox.login.f.a.f.a
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return this.f15877a.a(textView, i, keyEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        H h = this.f15889b;
        if (h != null) {
            a(this.f15888a, h.f15616d);
            a(this.f15888a, this.f15889b.f15617e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (!this.f15891d.get().booleanValue()) {
            AppToastUtils.showLongPositiveTipToast(this.f15888a, R.string.login_agree_tips);
        } else if (this.f15889b.f15618f.getHelperText() == null || !this.f15889b.f15618f.getHelperText().equals(this.f15888a.getString(R.string.base_set_account_exits))) {
            new q().a(this.f15888a, this.f15890c, new i(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        new ProtocolDialog(this.f15888a).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        this.f15890c.setConfirmPassword(str);
        new q().a(this.f15888a, this.f15890c, new k(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        this.f15890c.setPassword(str);
        new q().a(this.f15888a, this.f15890c, new j(this));
    }

    public /* synthetic */ void a(CompoundButton compoundButton, boolean z) {
        this.f15891d.set(Boolean.valueOf(z));
    }

    public /* synthetic */ boolean a(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        h();
        return false;
    }

    public void a(Context context, EditText editText) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        this.f15890c.setAccount(str);
        com.sandbox.login.f.a.a.g.a(this.f15888a, str, this.f15889b.f15618f);
    }
}
