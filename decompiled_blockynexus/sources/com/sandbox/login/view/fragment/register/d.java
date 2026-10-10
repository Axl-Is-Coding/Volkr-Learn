package com.sandbox.login.view.fragment.register;

import android.os.CountDownTimer;
import androidx.fragment.app.AbstractC0336n;
import androidx.fragment.app.F;
import com.sandbox.login.R;
import com.sandbox.login.f.a.d.s;

/* JADX INFO: compiled from: RegisterViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class d extends CountDownTimer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ e f15995a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    d(e eVar, long j, long j2) {
        super(j, j2);
        this.f15995a = eVar;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        AbstractC0336n supportFragmentManager = this.f15995a.f15996a.getSupportFragmentManager();
        F fA = supportFragmentManager.a();
        if (this.f15995a.f15998c == null) {
            this.f15995a.f15998c = new s();
            if (supportFragmentManager.a("MakeRoleFragment") == null) {
                fA.a(R.id.fl_frg, this.f15995a.f15998c, "MakeRoleFragment");
                fA.c(this.f15995a.f15998c);
            }
            this.f15995a.f15998c.a(false);
            fA.b();
        }
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
    }
}
