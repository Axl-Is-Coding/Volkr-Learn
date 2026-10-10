package com.sandboxol.decorate.view.fragment.dress;

import android.os.CountDownTimer;
import java.util.Iterator;

/* JADX INFO: compiled from: DressViewModel.java */
/* JADX INFO: loaded from: classes3.dex */
class ra extends CountDownTimer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ va f17456a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ra(va vaVar, long j, long j2) {
        super(j, j2);
        this.f17456a = vaVar;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        Iterator<Long> it = com.sandboxol.decorate.manager.v.b().f17213b.keySet().iterator();
        while (it.hasNext()) {
            com.sandboxol.decorate.manager.g.a(com.sandboxol.decorate.manager.v.b().f17213b.get(Long.valueOf(it.next().longValue())));
        }
        this.f17456a.l.set(true);
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
    }
}
