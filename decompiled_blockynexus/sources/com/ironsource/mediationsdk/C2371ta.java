package com.ironsource.mediationsdk;

import com.ironsource.mediationsdk.ProgRvSmash;
import java.util.TimerTask;

/* JADX INFO: renamed from: com.ironsource.mediationsdk.ta, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ProgRvSmash.java */
/* JADX INFO: loaded from: classes2.dex */
class C2371ta extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProgRvSmash f15007a;

    C2371ta(ProgRvSmash progRvSmash) {
        this.f15007a = progRvSmash;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        String str;
        int i;
        int i2;
        boolean z;
        synchronized (this.f15007a.B) {
            str = "Rewarded Video - load instance time out";
            if (this.f15007a.f14719f == ProgRvSmash.SMASH_STATE.LOAD_IN_PROGRESS || this.f15007a.f14719f == ProgRvSmash.SMASH_STATE.INIT_IN_PROGRESS) {
                if (this.f15007a.f14719f == ProgRvSmash.SMASH_STATE.LOAD_IN_PROGRESS) {
                    i = 1025;
                } else {
                    i = 1032;
                    str = "Rewarded Video - init instance time out";
                }
                this.f15007a.a(ProgRvSmash.SMASH_STATE.NOT_LOADED);
                i2 = i;
                z = true;
            } else {
                z = false;
                i2 = 510;
            }
        }
        this.f15007a.b(str);
        if (!z) {
            this.f15007a.a(1208, new Object[][]{new Object[]{"errorCode", 1025}, new Object[]{"duration", Long.valueOf(this.f15007a.G())}, new Object[]{"ext1", this.f15007a.f14719f.name()}});
            return;
        }
        this.f15007a.a(1200, new Object[][]{new Object[]{"errorCode", Integer.valueOf(i2)}, new Object[]{"duration", Long.valueOf(this.f15007a.G())}});
        this.f15007a.a(1212, new Object[][]{new Object[]{"errorCode", Integer.valueOf(i2)}, new Object[]{"reason", str}, new Object[]{"duration", Long.valueOf(this.f15007a.G())}});
        InterfaceC2345sa interfaceC2345sa = this.f15007a.g;
        ProgRvSmash progRvSmash = this.f15007a;
        interfaceC2345sa.b(progRvSmash, progRvSmash.s);
    }
}
