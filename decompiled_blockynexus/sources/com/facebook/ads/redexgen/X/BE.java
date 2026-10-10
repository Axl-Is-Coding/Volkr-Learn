package com.facebook.ads.redexgen.X;

import android.media.AudioTrack;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class BE extends Thread {
    public final /* synthetic */ AudioTrack A00;
    public final /* synthetic */ C2059Xi A01;

    public BE(C2059Xi c2059Xi, AudioTrack audioTrack) {
        this.A01 = c2059Xi;
        this.A00 = audioTrack;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A00.release();
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
