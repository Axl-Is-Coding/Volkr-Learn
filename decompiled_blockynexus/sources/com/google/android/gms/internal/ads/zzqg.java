package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.view.Surface;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzqg {
    private final Handler handler;
    private final zzqd zzbmy;

    public zzqg(Handler handler, zzqd zzqdVar) {
        Handler handler2;
        if (zzqdVar != null) {
            zzoz.checkNotNull(handler);
            handler2 = handler;
        } else {
            handler2 = null;
        }
        this.handler = handler2;
        this.zzbmy = zzqdVar;
    }

    public final void zzb(String str, long j, long j2) {
        if (this.zzbmy != null) {
            this.handler.post(new zzqi(this, str, j, j2));
        }
    }

    public final void zzc(zzjl zzjlVar) {
        if (this.zzbmy != null) {
            this.handler.post(new zzqf(this, zzjlVar));
        }
    }

    public final void zzd(zzjl zzjlVar) {
        if (this.zzbmy != null) {
            this.handler.post(new zzql(this, zzjlVar));
        }
    }

    public final void zzf(int i, long j) {
        if (this.zzbmy != null) {
            this.handler.post(new zzqk(this, i, j));
        }
    }

    public final void zzb(int i, int i2, int i3, float f2) {
        if (this.zzbmy != null) {
            this.handler.post(new zzqj(this, i, i2, i3, f2));
        }
    }

    public final void zzc(zzho zzhoVar) {
        if (this.zzbmy != null) {
            this.handler.post(new zzqh(this, zzhoVar));
        }
    }

    public final void zzb(Surface surface) {
        if (this.zzbmy != null) {
            this.handler.post(new zzqm(this, surface));
        }
    }
}
