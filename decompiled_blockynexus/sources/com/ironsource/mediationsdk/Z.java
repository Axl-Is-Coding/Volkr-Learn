package com.ironsource.mediationsdk;

import com.ironsource.mediationsdk.LWSProgRvSmash;
import java.util.TimerTask;

/* JADX INFO: compiled from: LWSProgRvSmash.java */
/* JADX INFO: loaded from: classes2.dex */
class Z extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ LWSProgRvSmash f14753a;

    Z(LWSProgRvSmash lWSProgRvSmash) {
        this.f14753a = lWSProgRvSmash;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        int i;
        int i2;
        boolean z;
        String str = "Rewarded Video - load instance time out";
        if (this.f14753a.f14685f == LWSProgRvSmash.SMASH_STATE.LOAD_IN_PROGRESS || this.f14753a.f14685f == LWSProgRvSmash.SMASH_STATE.INIT_IN_PROGRESS) {
            if (this.f14753a.f14685f == LWSProgRvSmash.SMASH_STATE.LOAD_IN_PROGRESS) {
                i = 1025;
            } else {
                i = 1032;
                str = "Rewarded Video - init instance time out";
            }
            this.f14753a.a(LWSProgRvSmash.SMASH_STATE.NOT_LOADED);
            i2 = i;
            z = true;
        } else {
            z = false;
            i2 = 510;
        }
        this.f14753a.c(str);
        if (!z) {
            this.f14753a.a(1208, new Object[][]{new Object[]{"errorCode", 1025}, new Object[]{"duration", Long.valueOf(this.f14753a.H())}, new Object[]{"ext1", this.f14753a.f14685f.name()}});
            return;
        }
        this.f14753a.a(1200, new Object[][]{new Object[]{"errorCode", Integer.valueOf(i2)}, new Object[]{"duration", Long.valueOf(this.f14753a.H())}});
        this.f14753a.a(1212, new Object[][]{new Object[]{"errorCode", Integer.valueOf(i2)}, new Object[]{"reason", str}, new Object[]{"duration", Long.valueOf(this.f14753a.H())}});
        this.f14753a.g.b(this.f14753a);
    }
}
