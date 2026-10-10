package com.ironsource.mediationsdk;

import com.ironsource.mediationsdk.ProgIsSmash;
import java.util.Date;
import java.util.TimerTask;

/* JADX INFO: renamed from: com.ironsource.mediationsdk.oa, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ProgIsSmash.java */
/* JADX INFO: loaded from: classes2.dex */
class C2338oa extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProgIsSmash f14957a;

    C2338oa(ProgIsSmash progIsSmash) {
        this.f14957a = progIsSmash;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f14957a.c("timed out state=" + this.f14957a.f14713f.name() + " isBidder=" + this.f14957a.y());
        if (this.f14957a.f14713f == ProgIsSmash.SMASH_STATE.INIT_IN_PROGRESS && this.f14957a.y()) {
            this.f14957a.a(ProgIsSmash.SMASH_STATE.NO_INIT);
            return;
        }
        this.f14957a.a(ProgIsSmash.SMASH_STATE.LOAD_FAILED);
        this.f14957a.g.a(com.ironsource.mediationsdk.utils.g.c("timed out"), this.f14957a, new Date().getTime() - this.f14957a.l);
    }
}
