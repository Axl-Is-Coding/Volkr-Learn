package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzos extends IOException {
    private final int type;
    private final zzon zzbio;

    public zzos(String str, zzon zzonVar, int i) {
        super(str);
        this.zzbio = zzonVar;
        this.type = 1;
    }

    public zzos(IOException iOException, zzon zzonVar, int i) {
        super(iOException);
        this.zzbio = zzonVar;
        this.type = i;
    }

    public zzos(String str, IOException iOException, zzon zzonVar, int i) {
        super(str, iOException);
        this.zzbio = zzonVar;
        this.type = 1;
    }
}
