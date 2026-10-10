package com.facebook.ads.redexgen.X;

import android.content.Context;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.aV, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2155aV implements HB {
    public final Context A00;
    public final HB A01;
    public final HX<? super HC> A02;

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.HX != com.facebook.ads.internal.exoplayer2.upstream.TransferListener<? super com.facebook.ads.internal.exoplayer2.upstream.DataSource> */
    public C2155aV(Context context, HX<? super HC> hx, HB hb) {
        this.A00 = context.getApplicationContext();
        this.A02 = hx;
        this.A01 = hb;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.HX != com.facebook.ads.internal.exoplayer2.upstream.TransferListener<? super com.facebook.ads.internal.exoplayer2.upstream.DataSource> */
    public C2155aV(Context context, String str, HX<? super HC> hx) {
        this(context, hx, new C2Y(str, hx));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.HB
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final C2154aU A4D() {
        return new C2154aU(this.A00, this.A02, this.A01.A4D());
    }
}
