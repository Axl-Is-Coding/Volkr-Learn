package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzeks {
    private static final zzejm zzief = zzejm.zzbft();
    private zzeip zzikw;
    private volatile zzelj zzikx;
    private volatile zzeip zziky;

    private final zzelj zzm(zzelj zzeljVar) {
        if (this.zzikx == null) {
            synchronized (this) {
                if (this.zzikx == null) {
                    try {
                        this.zzikx = zzeljVar;
                        this.zziky = zzeip.zzier;
                    } catch (zzekj unused) {
                        this.zzikx = zzeljVar;
                        this.zziky = zzeip.zzier;
                    }
                }
            }
        }
        return this.zzikx;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzeks)) {
            return false;
        }
        zzeks zzeksVar = (zzeks) obj;
        zzelj zzeljVar = this.zzikx;
        zzelj zzeljVar2 = zzeksVar.zzikx;
        return (zzeljVar == null && zzeljVar2 == null) ? zzbdw().equals(zzeksVar.zzbdw()) : (zzeljVar == null || zzeljVar2 == null) ? zzeljVar != null ? zzeljVar.equals(zzeksVar.zzm(zzeljVar.zzbgn())) : zzm(zzeljVar2.zzbgn()).equals(zzeljVar2) : zzeljVar.equals(zzeljVar2);
    }

    public int hashCode() {
        return 1;
    }

    public final zzeip zzbdw() {
        if (this.zziky != null) {
            return this.zziky;
        }
        synchronized (this) {
            if (this.zziky != null) {
                return this.zziky;
            }
            if (this.zzikx == null) {
                this.zziky = zzeip.zzier;
            } else {
                this.zziky = this.zzikx.zzbdw();
            }
            return this.zziky;
        }
    }

    public final int zzbgh() {
        if (this.zziky != null) {
            return this.zziky.size();
        }
        if (this.zzikx != null) {
            return this.zzikx.zzbgh();
        }
        return 0;
    }

    public final zzelj zzn(zzelj zzeljVar) {
        zzelj zzeljVar2 = this.zzikx;
        this.zzikw = null;
        this.zziky = null;
        this.zzikx = zzeljVar;
        return zzeljVar2;
    }
}
