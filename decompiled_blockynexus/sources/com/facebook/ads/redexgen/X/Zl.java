package com.facebook.ads.redexgen.X;

import android.net.Uri;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class Zl implements InterfaceC1615Fu {

    @Nullable
    public CD A02;

    @Nullable
    public Object A03;

    @Nullable
    public String A04;
    public boolean A05;
    public final HB A06;
    public int A01 = -1;
    public int A00 = 1048576;

    public Zl(HB hb) {
        this.A06 = hb;
    }

    public final C1498Ao A00(Uri uri) {
        this.A05 = true;
        if (this.A02 == null) {
            this.A02 = new Y8();
        }
        return new C1498Ao(uri, this.A06, this.A02, this.A01, this.A04, this.A00, this.A03);
    }
}
