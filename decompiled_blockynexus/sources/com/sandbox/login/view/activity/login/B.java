package com.sandbox.login.view.activity.login;

import android.os.Build;
import com.sandbox.login.R;
import com.sandbox.login.view.activity.login.y;

/* JADX INFO: compiled from: LoginViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class B implements y.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f15921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ D f15922b;

    B(D d2, String str) {
        this.f15922b = d2;
        this.f15921a = str;
    }

    @Override // com.sandbox.login.view.activity.login.y.a
    public void a() {
    }

    @Override // com.sandbox.login.view.activity.login.y.a
    public void a(String str) {
        if (str.equals(this.f15922b.f15924a.getString(R.string.login_guest_password_tips))) {
            this.f15922b.H();
            this.f15922b.e(this.f15921a);
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            this.f15922b.f15925b.h.setHelperTextColor(this.f15922b.f15924a.getColorStateList(R.color.login_tips_color_1));
        }
        this.f15922b.f15925b.h.setHelperText(str);
        this.f15922b.I();
        this.f15922b.E();
    }

    @Override // com.sandbox.login.view.activity.login.y.a
    public void b(String str) {
        this.f15922b.f15925b.h.setHelperText("");
        this.f15922b.I();
        if (this.f15922b.b(this.f15921a)) {
            this.f15922b.e(this.f15921a);
        } else {
            this.f15922b.E();
        }
    }

    @Override // com.sandbox.login.view.activity.login.y.a
    public void onSuccess() {
        this.f15922b.f15925b.h.setHelperText("");
        this.f15922b.I();
        if (this.f15922b.b(this.f15921a)) {
            this.f15922b.e(this.f15921a);
        } else {
            this.f15922b.E();
        }
    }
}
