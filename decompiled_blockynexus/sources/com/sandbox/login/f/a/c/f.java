package com.sandbox.login.f.a.c;

import android.os.Build;
import com.sandbox.login.R;
import com.sandbox.login.view.activity.login.y;

/* JADX INFO: compiled from: ConfirmPasswordViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class f implements y.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ g f15791a;

    f(g gVar) {
        this.f15791a = gVar;
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
            this.f15791a.g.f15691a.setHelperTextColor(this.f15791a.f15792a.getColorStateList(R.color.login_tips_color_1));
        }
        this.f15791a.g.f15691a.setHelperText(str);
    }

    @Override // com.sandbox.login.view.activity.login.y.a
    public void onSuccess() {
        this.f15791a.g.f15691a.setHelperText("");
    }
}
