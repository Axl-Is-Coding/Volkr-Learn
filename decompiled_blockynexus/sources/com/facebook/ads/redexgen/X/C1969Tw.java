package com.facebook.ads.redexgen.X;

import android.os.Build;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Tw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1969Tw implements C6Y {
    public final /* synthetic */ U1 A00;

    public C1969Tw(U1 u1) {
        this.A00 = u1;
    }

    @Override // com.facebook.ads.redexgen.X.C6Y
    public final AbstractC14046n A58() {
        if (Build.VERSION.SDK_INT < 9) {
            return this.A00.A08(EnumC14006j.A05);
        }
        if (this.A00.A01 != null) {
            U1 u1 = this.A00;
            return u1.A09(u1.A01.nativeLibraryDir);
        }
        return this.A00.A08(EnumC14006j.A07);
    }
}
