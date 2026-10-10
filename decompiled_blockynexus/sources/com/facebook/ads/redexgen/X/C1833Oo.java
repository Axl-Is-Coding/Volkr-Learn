package com.facebook.ads.redexgen.X;

import android.database.ContentObserver;
import android.os.Handler;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Oo, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1833Oo extends ContentObserver {
    public final C1717Jy A00;

    public C1833Oo(Handler handler, C1717Jy c1717Jy) {
        super(handler);
        this.A00 = c1717Jy;
    }

    @Override // android.database.ContentObserver
    public final boolean deliverSelfNotifications() {
        return false;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        this.A00.A0a();
    }
}
