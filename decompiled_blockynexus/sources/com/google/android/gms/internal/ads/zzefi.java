package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzejz;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public final class zzefi extends zzejz<zzefi, zza> implements zzell {
    private static volatile zzelw<zzefi> zzel;
    private static final zzefi zziae;
    private int zziab;
    private boolean zziac;
    private String zziaa = "";
    private String zzhzh = "";
    private String zziad = "";

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    public static final class zza extends zzejz.zzb<zzefi, zza> implements zzell {
        private zza() {
            super(zzefi.zziae);
        }

        /* synthetic */ zza(zzefh zzefhVar) {
            this();
        }
    }

    static {
        zzefi zzefiVar = new zzefi();
        zziae = zzefiVar;
        zzejz.zza((Class<zzefi>) zzefi.class, zzefiVar);
    }

    private zzefi() {
    }

    @Override // com.google.android.gms.internal.ads.zzejz
    protected final Object zza(int i, Object obj, Object obj2) {
        zzefh zzefhVar = null;
        switch (zzefh.zzdv[i - 1]) {
            case 1:
                return new zzefi();
            case 2:
                return new zza(zzefhVar);
            case 3:
                return zzejz.zza(zziae, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u000b\u0004\u0007\u0005Ȉ", new Object[]{"zziaa", "zzhzh", "zziab", "zziac", "zziad"});
            case 4:
                return zziae;
            case 5:
                zzelw<zzefi> zzaVar = zzel;
                if (zzaVar == null) {
                    synchronized (zzefi.class) {
                        zzaVar = zzel;
                        if (zzaVar == null) {
                            zzaVar = new zzejz.zza<>(zziae);
                            zzel = zzaVar;
                        }
                        break;
                    }
                }
                return zzaVar;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final String zzbbt() {
        return this.zzhzh;
    }

    public final String zzbcb() {
        return this.zziaa;
    }

    public final int zzbcc() {
        return this.zziab;
    }

    public final boolean zzbcd() {
        return this.zziac;
    }

    public final String zzbce() {
        return this.zziad;
    }
}
