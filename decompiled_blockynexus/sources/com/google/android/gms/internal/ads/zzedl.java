package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzejz;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzedl extends zzejz<zzedl, zza> implements zzell {
    private static volatile zzelw<zzedl> zzel;
    private static final zzedl zzhxg;
    private int zzhwu;
    private zzedm zzhxe;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    public static final class zza extends zzejz.zzb<zzedl, zza> implements zzell {
        private zza() {
            super(zzedl.zzhxg);
        }

        /* synthetic */ zza(zzedk zzedkVar) {
            this();
        }
    }

    static {
        zzedl zzedlVar = new zzedl();
        zzhxg = zzedlVar;
        zzejz.zza((Class<zzedl>) zzedl.class, zzedlVar);
    }

    private zzedl() {
    }

    public static zzedl zzazw() {
        return zzhxg;
    }

    public static zzedl zzh(zzeip zzeipVar, zzejm zzejmVar) throws zzekj {
        return (zzedl) zzejz.zza(zzhxg, zzeipVar, zzejmVar);
    }

    public final int getKeySize() {
        return this.zzhwu;
    }

    @Override // com.google.android.gms.internal.ads.zzejz
    protected final Object zza(int i, Object obj, Object obj2) {
        zzedk zzedkVar = null;
        switch (zzedk.zzdv[i - 1]) {
            case 1:
                return new zzedl();
            case 2:
                return new zza(zzedkVar);
            case 3:
                return zzejz.zza(zzhxg, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", new Object[]{"zzhxe", "zzhwu"});
            case 4:
                return zzhxg;
            case 5:
                zzelw<zzedl> zzaVar = zzel;
                if (zzaVar == null) {
                    synchronized (zzedl.class) {
                        zzaVar = zzel;
                        if (zzaVar == null) {
                            zzaVar = new zzejz.zza<>(zzhxg);
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

    public final zzedm zzazs() {
        zzedm zzedmVar = this.zzhxe;
        return zzedmVar == null ? zzedm.zzazz() : zzedmVar;
    }
}
