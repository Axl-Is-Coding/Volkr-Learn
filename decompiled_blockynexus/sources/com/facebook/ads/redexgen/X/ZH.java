package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.metadata.Metadata;
import com.facebook.ads.internal.exoplayer2.metadata.emsg.EventMessage;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class ZH implements InterfaceC1561Do {
    @Override // com.facebook.ads.redexgen.X.InterfaceC1561Do
    public final Metadata A4e(C2 c2) {
        ByteBuffer buffer = c2.A01;
        byte[] bArrArray = buffer.array();
        int size = buffer.limit();
        IG ig = new IG(bArrArray, size);
        String strA0R = ig.A0R();
        String strA0R2 = ig.A0R();
        long jA0N = ig.A0N();
        long timescale = IW.A0F(ig.A0N(), 1000000L, jA0N);
        long presentationTimeUs = ig.A0N();
        long id = IW.A0F(presentationTimeUs, 1000L, jA0N);
        return new Metadata(new EventMessage(strA0R, strA0R2, id, ig.A0N(), Arrays.copyOfRange(bArrArray, ig.A07(), size), timescale));
    }
}
