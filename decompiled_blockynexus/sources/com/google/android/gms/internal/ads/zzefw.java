package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzejz;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public final class zzefw extends zzejz<zzefw, zza> implements zzell {
    private static volatile zzelw<zzefw> zzel;
    private static final zzefw zzibh;
    private String zzibf = "";
    private zzekk<zzefi> zzibg = zzejz.zzbgk();

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    public static final class zza extends zzejz.zzb<zzefw, zza> implements zzell {
        private zza() {
            super(zzefw.zzibh);
        }

        /* synthetic */ zza(zzefy zzefyVar) {
            this();
        }
    }

    static {
        zzefw zzefwVar = new zzefw();
        zzibh = zzefwVar;
        zzejz.zza((Class<zzefw>) zzefw.class, zzefwVar);
    }

    private zzefw() {
    }

    public static zzefw zzbdg() {
        return zzibh;
    }

    @Override // com.google.android.gms.internal.ads.zzejz
    protected final Object zza(int i, Object obj, Object obj2) {
        zzefy zzefyVar = null;
        switch (zzefy.zzdv[i - 1]) {
            case 1:
                return new zzefw();
            case 2:
                return new zza(zzefyVar);
            case 3:
                return zzejz.zza(zzibh, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"zzibf", "zzibg", zzefi.class});
            case 4:
                return zzibh;
            case 5:
                zzelw<zzefw> zzaVar = zzel;
                if (zzaVar == null) {
                    synchronized (zzefw.class) {
                        zzaVar = zzel;
                        if (zzaVar == null) {
                            zzaVar = new zzejz.zza<>(zzibh);
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

    public final List<zzefi> zzbdf() {
        return this.zzibg;
    }
}
