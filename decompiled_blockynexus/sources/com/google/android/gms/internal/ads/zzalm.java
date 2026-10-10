package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzalm extends zzbcn<zzaki> {
    private zzbad<zzaki> zzdhh;
    private final Object lock = new Object();
    private boolean zzdic = false;
    private int zzdid = 0;

    public zzalm(zzbad<zzaki> zzbadVar) {
        this.zzdhh = zzbadVar;
    }

    private final void zztn() {
        synchronized (this.lock) {
            Preconditions.checkState(this.zzdid >= 0);
            if (this.zzdic && this.zzdid == 0) {
                zzayp.zzei("No reference is left (including root). Cleaning up engine.");
                zza(new zzaln(this), new zzbcl());
            } else {
                zzayp.zzei("There are still references to the engine. Not destroying.");
            }
        }
    }

    public final zzali zztk() {
        zzali zzaliVar = new zzali(this);
        synchronized (this.lock) {
            zza(new zzall(this, zzaliVar), new zzalo(this, zzaliVar));
            Preconditions.checkState(this.zzdid >= 0);
            this.zzdid++;
        }
        return zzaliVar;
    }

    protected final void zztl() {
        synchronized (this.lock) {
            Preconditions.checkState(this.zzdid > 0);
            zzayp.zzei("Releasing 1 reference for JS Engine");
            this.zzdid--;
            zztn();
        }
    }

    public final void zztm() {
        synchronized (this.lock) {
            Preconditions.checkState(this.zzdid >= 0);
            zzayp.zzei("Releasing root reference. JS Engine will be destroyed once other references are released.");
            this.zzdic = true;
            zztn();
        }
    }
}
