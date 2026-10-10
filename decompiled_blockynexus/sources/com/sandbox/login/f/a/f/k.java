package com.sandbox.login.f.a.f;

import android.os.Build;
import com.sandbox.login.R;
import com.sandbox.login.f.a.f.q;

/* JADX INFO: compiled from: RegisterStep1ViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class k implements q.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ l f15887a;

    k(l lVar) {
        this.f15887a = lVar;
    }

    @Override // com.sandbox.login.f.a.f.q.a
    public void a(String str) {
        this.f15887a.f15889b.h.setHelperText("");
    }

    @Override // com.sandbox.login.f.a.f.q.a
    public void b(String str) {
    }

    @Override // com.sandbox.login.f.a.f.q.a
    public void c(String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.f15887a.f15889b.h.setHelperTextColor(this.f15887a.f15888a.getColorStateList(R.color.login_tips_color_1));
        }
        this.f15887a.f15889b.h.setHelperText(str);
    }

    @Override // com.sandbox.login.f.a.f.q.a
    public void onSuccess() {
        this.f15887a.f15889b.h.setHelperText("");
    }
}
