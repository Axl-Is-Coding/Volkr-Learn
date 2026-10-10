package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import com.facebook.ads.internal.exoplayer2.metadata.Metadata;
import java.io.EOFException;
import java.io.IOException;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class CF {
    public final IG A00 = new IG(10);

    @Nullable
    public final Metadata A00(CB cb, @Nullable E0 e0) throws InterruptedException, IOException {
        int i = 0;
        Metadata metadataA0P = null;
        while (true) {
            try {
                cb.ABs(this.A00.A00, 0, 10);
                this.A00.A0Z(0);
                if (this.A00.A0H() != ZJ.A03) {
                    break;
                }
                this.A00.A0a(3);
                int iA0E = this.A00.A0E();
                int i2 = iA0E + 10;
                if (metadataA0P == null) {
                    byte[] bArr = new byte[i2];
                    byte[] id3Data = this.A00.A00;
                    System.arraycopy(id3Data, 0, bArr, 0, 10);
                    cb.ABs(bArr, 10, iA0E);
                    metadataA0P = new ZJ(e0).A0P(bArr, i2);
                } else {
                    cb.A3M(iA0E);
                }
                i += i2;
            } catch (EOFException unused) {
            }
        }
        cb.ACt();
        cb.A3M(i);
        return metadataA0P;
    }
}
