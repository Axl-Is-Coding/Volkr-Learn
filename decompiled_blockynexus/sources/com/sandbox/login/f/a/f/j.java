package com.sandbox.login.f.a.f;

import android.os.Build;
import com.sandbox.login.R;
import com.sandbox.login.f.a.f.q;

/* JADX INFO: compiled from: RegisterStep1ViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class j implements q.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ l f15886a;

    j(l lVar) {
        this.f15886a = lVar;
    }

    @Override // com.sandbox.login.f.a.f.q.a
    public void a(String str) {
        this.f15886a.f15889b.g.setHelperText("");
    }

    @Override // com.sandbox.login.f.a.f.q.a
    public void b(String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.f15886a.f15889b.g.setHelperTextColor(this.f15886a.f15888a.getColorStateList(R.color.login_tips_color_1));
        }
        this.f15886a.f15889b.g.setHelperText(str);
    }

    @Override // com.sandbox.login.f.a.f.q.a
    public void c(String str) {
        this.f15886a.f15889b.g.setHelperText("");
    }

    @Override // com.sandbox.login.f.a.f.q.a
    public void onSuccess() {
        this.f15886a.f15889b.g.setHelperText("");
    }
}
