package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.b2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2188b2 implements I4 {
    public final Handler A00;

    public C2188b2(Handler handler) {
        this.A00 = handler;
    }

    @Override // com.facebook.ads.redexgen.X.I4
    public final Looper A6b() {
        return this.A00.getLooper();
    }

    @Override // com.facebook.ads.redexgen.X.I4
    public final Message A8t(int i, int i2, int i3) {
        return this.A00.obtainMessage(i, i2, i3);
    }

    @Override // com.facebook.ads.redexgen.X.I4
    public final Message A8u(int i, int i2, int i3, Object obj) {
        return this.A00.obtainMessage(i, i2, i3, obj);
    }

    @Override // com.facebook.ads.redexgen.X.I4
    public final Message A8v(int i, Object obj) {
        return this.A00.obtainMessage(i, obj);
    }

    @Override // com.facebook.ads.redexgen.X.I4
    public final void ACg(int i) {
        this.A00.removeMessages(i);
    }

    @Override // com.facebook.ads.redexgen.X.I4
    public final boolean AD8(int i) {
        return this.A00.sendEmptyMessage(i);
    }

    @Override // com.facebook.ads.redexgen.X.I4
    public final boolean AD9(int i, long j) {
        return this.A00.sendEmptyMessageAtTime(i, j);
    }
}
