package com.sandbox.login.f.a.f;

import android.os.Build;
import com.sandbox.login.R;
import com.sandbox.login.f.a.f.q;

/* JADX INFO: compiled from: RegisterStep1ViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class i implements q.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ l f15885a;

    i(l lVar) {
        this.f15885a = lVar;
    }

    @Override // com.sandbox.login.f.a.f.q.a
    public void a(String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.f15885a.f15889b.f15618f.setHelperTextColor(this.f15885a.f15888a.getColorStateList(R.color.login_tips_color_1));
        }
        this.f15885a.f15889b.f15618f.setHelperText(str);
    }

    @Override // com.sandbox.login.f.a.f.q.a
    public void b(String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.f15885a.f15889b.g.setHelperTextColor(this.f15885a.f15888a.getColorStateList(R.color.login_tips_color_1));
        }
        this.f15885a.f15889b.g.setHelperText(str);
    }

    @Override // com.sandbox.login.f.a.f.q.a
    public void c(String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.f15885a.f15889b.h.setHelperTextColor(this.f15885a.f15888a.getColorStateList(R.color.login_tips_color_1));
        }
        this.f15885a.f15889b.h.setHelperText(str);
    }

    @Override // com.sandbox.login.f.a.f.q.a
    public void onSuccess() {
        com.sandbox.login.web.b.a(this.f15885a.f15888a, this.f15885a.f15890c.getAccount(), 0L, "2", new h(this));
    }
}
