package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzejz;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzefu extends zzejz<zzefu, zza> implements zzell {
    private static volatile zzelw<zzefu> zzel;
    private static final zzefu zziax;
    private String zziav = "";
    private zzefe zziaw;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    public static final class zza extends zzejz.zzb<zzefu, zza> implements zzell {
        private zza() {
            super(zzefu.zziax);
        }

        /* synthetic */ zza(zzeft zzeftVar) {
            this();
        }
    }

    static {
        zzefu zzefuVar = new zzefu();
        zziax = zzefuVar;
        zzejz.zza((Class<zzefu>) zzefu.class, zzefuVar);
    }

    private zzefu() {
    }

    public static zzefu zzbdd() {
        return zziax;
    }

    public static zzefu zzw(zzeip zzeipVar, zzejm zzejmVar) throws zzekj {
        return (zzefu) zzejz.zza(zziax, zzeipVar, zzejmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzejz
    protected final Object zza(int i, Object obj, Object obj2) {
        zzeft zzeftVar = null;
        switch (zzeft.zzdv[i - 1]) {
            case 1:
                return new zzefu();
            case 2:
                return new zza(zzeftVar);
            case 3:
                return zzejz.zza(zziax, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\t", new Object[]{"zziav", "zziaw"});
            case 4:
                return zziax;
            case 5:
                zzelw<zzefu> zzaVar = zzel;
                if (zzaVar == null) {
                    synchronized (zzefu.class) {
                        zzaVar = zzel;
                        if (zzaVar == null) {
                            zzaVar = new zzejz.zza<>(zziax);
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

    public final String zzbdb() {
        return this.zziav;
    }

    public final zzefe zzbdc() {
        zzefe zzefeVar = this.zziaw;
        return zzefeVar == null ? zzefe.zzbbz() : zzefeVar;
    }
}
