package com.google.android.gms.internal.ads;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbb {
    private final int zzcr;
    private final List<zzu> zzcs;
    private final int zzct;
    private final InputStream zzcu;

    public zzbb(int i, List<zzu> list) {
        this(i, list, -1, null);
    }

    public final InputStream getContent() {
        return this.zzcu;
    }

    public final int getContentLength() {
        return this.zzct;
    }

    public final int getStatusCode() {
        return this.zzcr;
    }

    public final List<zzu> zzq() {
        return Collections.unmodifiableList(this.zzcs);
    }

    public zzbb(int i, List<zzu> list, int i2, InputStream inputStream) {
        this.zzcr = i;
        this.zzcs = list;
        this.zzct = i2;
        this.zzcu = inputStream;
    }
}
