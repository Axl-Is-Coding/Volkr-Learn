package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public interface zzom {
    void close() throws IOException;

    Uri getUri();

    int read(byte[] bArr, int i, int i2) throws IOException;

    long zza(zzon zzonVar) throws IOException;
}
