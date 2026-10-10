package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzejz;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzejm {
    private static volatile boolean zzify = false;
    private static boolean zzifz = true;
    private static volatile zzejm zziga;
    private static volatile zzejm zzigb;
    private static final zzejm zzigc = new zzejm(true);
    private final Map<zza, zzejz.zzf<?, ?>> zzigd;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
    static final class zza {
        private final int number;
        private final Object object;

        zza(Object obj, int i) {
            this.object = obj;
            this.number = i;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zzaVar = (zza) obj;
            return this.object == zzaVar.object && this.number == zzaVar.number;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.object) * 65535) + this.number;
        }
    }

    zzejm() {
        this.zzigd = new HashMap();
    }

    public static zzejm zzbft() {
        zzejm zzejmVar = zziga;
        if (zzejmVar == null) {
            synchronized (zzejm.class) {
                zzejmVar = zziga;
                if (zzejmVar == null) {
                    zzejmVar = zzigc;
                    zziga = zzejmVar;
                }
            }
        }
        return zzejmVar;
    }

    public static zzejm zzbfu() {
        zzejm zzejmVar = zzigb;
        if (zzejmVar != null) {
            return zzejmVar;
        }
        synchronized (zzejm.class) {
            zzejm zzejmVar2 = zzigb;
            if (zzejmVar2 != null) {
                return zzejmVar2;
            }
            zzejm zzejmVarZzc = zzejx.zzc(zzejm.class);
            zzigb = zzejmVarZzc;
            return zzejmVarZzc;
        }
    }

    public final <ContainingType extends zzelj> zzejz.zzf<ContainingType, ?> zza(ContainingType containingtype, int i) {
        return (zzejz.zzf) this.zzigd.get(new zza(containingtype, i));
    }

    private zzejm(boolean z) {
        this.zzigd = Collections.emptyMap();
    }
}
