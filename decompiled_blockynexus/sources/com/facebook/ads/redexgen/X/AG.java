package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import com.facebook.ads.internal.exoplayer2.source.TrackGroup;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AG extends AbstractC2143aJ {
    public final int A00;

    @Nullable
    public final Object A01;

    public AG(TrackGroup trackGroup, int i) {
        this(trackGroup, i, 0, null);
    }

    public AG(TrackGroup trackGroup, int i, int i2, @Nullable Object obj) {
        super(trackGroup, i);
        this.A00 = i2;
        this.A01 = obj;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1643Gy
    public final int A71() {
        return 0;
    }
}
