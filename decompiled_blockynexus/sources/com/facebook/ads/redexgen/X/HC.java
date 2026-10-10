package com.facebook.ads.redexgen.X;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public interface HC {
    @Nullable
    Uri A7J();

    long ABi(HG hg) throws IOException;

    void close() throws IOException;

    int read(byte[] bArr, int i, int i2) throws IOException;
}
