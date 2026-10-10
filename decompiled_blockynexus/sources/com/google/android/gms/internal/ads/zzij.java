package com.google.android.gms.internal.ads;

import android.os.Handler;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzij {
    private final Handler handler;
    private final zzig zzaje;

    public zzij(Handler handler, zzig zzigVar) {
        Handler handler2;
        if (zzigVar != null) {
            zzoz.checkNotNull(handler);
            handler2 = handler;
        } else {
            handler2 = null;
        }
        this.handler = handler2;
        this.zzaje = zzigVar;
    }

    public final void zzb(String str, long j, long j2) {
        if (this.zzaje != null) {
            this.handler.post(new zzil(this, str, j, j2));
        }
    }

    public final void zzc(zzjl zzjlVar) {
        if (this.zzaje != null) {
            this.handler.post(new zzii(this, zzjlVar));
        }
    }

    public final void zzd(zzjl zzjlVar) {
        if (this.zzaje != null) {
            this.handler.post(new zzim(this, zzjlVar));
        }
    }

    public final void zzy(int i) {
        if (this.zzaje != null) {
            this.handler.post(new zzip(this, i));
        }
    }

    public final void zzb(int i, long j, long j2) {
        if (this.zzaje != null) {
            this.handler.post(new zzin(this, i, j, j2));
        }
    }

    public final void zzc(zzho zzhoVar) {
        if (this.zzaje != null) {
            this.handler.post(new zzik(this, zzhoVar));
        }
    }
}
