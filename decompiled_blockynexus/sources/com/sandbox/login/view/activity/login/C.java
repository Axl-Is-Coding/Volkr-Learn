package com.sandbox.login.view.activity.login;

import android.os.Build;
import com.sandbox.login.R;
import com.sandbox.login.view.activity.login.y;

/* JADX INFO: compiled from: LoginViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class C implements y.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ D f15923a;

    C(D d2) {
        this.f15923a = d2;
    }

    @Override // com.sandbox.login.view.activity.login.y.a
    public void a() {
    }

    @Override // com.sandbox.login.view.activity.login.y.a
    public void a(String str) {
    }

    @Override // com.sandbox.login.view.activity.login.y.a
    public void b(String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.f15923a.f15925b.j.setHelperTextColor(this.f15923a.f15924a.getColorStateList(R.color.login_tips_color_1));
        }
        this.f15923a.f15925b.j.setHelperText(str);
    }

    @Override // com.sandbox.login.view.activity.login.y.a
    public void onSuccess() {
        this.f15923a.f15925b.j.setHelperText("");
    }
}
