package com.google.android.gms.internal.ads;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzely {
    private static final zzely zzimi = new zzely();
    private final ConcurrentMap<Class<?>, zzemf<?>> zzimk = new ConcurrentHashMap();
    private final zzemi zzimj = new zzela();

    private zzely() {
    }

    public static zzely zzbic() {
        return zzimi;
    }

    public final <T> zzemf<T> zzaw(T t) {
        return zzh(t.getClass());
    }

    public final <T> zzemf<T> zzh(Class<T> cls) {
        zzekb.zza(cls, "messageType");
        zzemf<T> zzemfVar = (zzemf) this.zzimk.get(cls);
        if (zzemfVar != null) {
            return zzemfVar;
        }
        zzemf<T> zzemfVarZzg = this.zzimj.zzg(cls);
        zzekb.zza(cls, "messageType");
        zzekb.zza(zzemfVarZzg, "schema");
        zzemf<T> zzemfVar2 = (zzemf) this.zzimk.putIfAbsent(cls, zzemfVarZzg);
        return zzemfVar2 != null ? zzemfVar2 : zzemfVarZzg;
    }
}
