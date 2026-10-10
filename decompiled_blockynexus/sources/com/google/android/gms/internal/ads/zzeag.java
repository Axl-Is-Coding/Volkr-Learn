package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzefb;
import com.google.android.gms.internal.ads.zzelj;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzeag<KeyProtoT extends zzelj> {
    private final Class<KeyProtoT> zzhuf;
    private final Map<Class<?>, zzeai<?, KeyProtoT>> zzhug;
    private final Class<?> zzhuh;

    @SafeVarargs
    protected zzeag(Class<KeyProtoT> cls, zzeai<?, KeyProtoT>... zzeaiVarArr) {
        this.zzhuf = cls;
        HashMap map = new HashMap();
        for (zzeai<?, KeyProtoT> zzeaiVar : zzeaiVarArr) {
            if (map.containsKey(zzeaiVar.zzayk())) {
                String strValueOf = String.valueOf(zzeaiVar.zzayk().getCanonicalName());
                throw new IllegalArgumentException(strValueOf.length() != 0 ? "KeyTypeManager constructed with duplicate factories for primitive ".concat(strValueOf) : new String("KeyTypeManager constructed with duplicate factories for primitive "));
            }
            map.put(zzeaiVar.zzayk(), zzeaiVar);
        }
        if (zzeaiVarArr.length > 0) {
            this.zzhuh = zzeaiVarArr[0].zzayk();
        } else {
            this.zzhuh = Void.class;
        }
        this.zzhug = Collections.unmodifiableMap(map);
    }

    public abstract String getKeyType();

    public final <P> P zza(KeyProtoT keyprotot, Class<P> cls) throws GeneralSecurityException {
        zzeai<?, KeyProtoT> zzeaiVar = this.zzhug.get(cls);
        if (zzeaiVar != null) {
            return (P) zzeaiVar.zzag(keyprotot);
        }
        String canonicalName = cls.getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 41);
        sb.append("Requested primitive class ");
        sb.append(canonicalName);
        sb.append(" not supported.");
        throw new IllegalArgumentException(sb.toString());
    }

    public final Class<KeyProtoT> zzayn() {
        return this.zzhuf;
    }

    public abstract zzefb.zza zzayo();

    public final Set<Class<?>> zzayp() {
        return this.zzhug.keySet();
    }

    final Class<?> zzayq() {
        return this.zzhuh;
    }

    public zzeaf<?, KeyProtoT> zzayr() {
        throw new UnsupportedOperationException("Creating keys is not supported.");
    }

    public abstract void zze(KeyProtoT keyprotot) throws GeneralSecurityException;

    public abstract KeyProtoT zzr(zzeip zzeipVar) throws zzekj;
}
