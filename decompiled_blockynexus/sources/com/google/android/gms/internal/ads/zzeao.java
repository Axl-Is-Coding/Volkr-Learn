package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzefj;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzeao<P> {
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private final Class<P> zzhue;
    private ConcurrentMap<String, List<zzean<P>>> zzhup = new ConcurrentHashMap();
    private zzean<P> zzhuq;

    private zzeao(Class<P> cls) {
        this.zzhue = cls;
    }

    public static <P> zzeao<P> zza(Class<P> cls) {
        return new zzeao<>(cls);
    }

    public final Class<P> zzayk() {
        return this.zzhue;
    }

    public final zzean<P> zzayx() {
        return this.zzhuq;
    }

    public final void zza(zzean<P> zzeanVar) {
        if (zzeanVar == null) {
            throw new IllegalArgumentException("the primary entry must be non-null");
        }
        if (zzeanVar.zzayu() != zzefc.ENABLED) {
            throw new IllegalArgumentException("the primary entry has to be ENABLED");
        }
        List<zzean<P>> listEmptyList = this.zzhup.get(new String(zzeanVar.zzayw(), UTF_8));
        if (listEmptyList == null) {
            listEmptyList = Collections.emptyList();
        }
        if (listEmptyList.isEmpty()) {
            throw new IllegalArgumentException("the primary entry cannot be set to an entry which is not held by this primitive set");
        }
        this.zzhuq = zzeanVar;
    }

    public final zzean<P> zza(P p, zzefj.zzb zzbVar) throws GeneralSecurityException {
        byte[] bArrArray;
        if (zzbVar.zzayu() == zzefc.ENABLED) {
            int i = zzeaa.zzhub[zzbVar.zzayv().ordinal()];
            if (i == 1 || i == 2) {
                bArrArray = ByteBuffer.allocate(5).put((byte) 0).putInt(zzbVar.zzbcm()).array();
            } else if (i == 3) {
                bArrArray = ByteBuffer.allocate(5).put((byte) 1).putInt(zzbVar.zzbcm()).array();
            } else if (i == 4) {
                bArrArray = zzdzx.zzhua;
            } else {
                throw new GeneralSecurityException("unknown output prefix type");
            }
            zzean<P> zzeanVar = new zzean<>(p, bArrArray, zzbVar.zzayu(), zzbVar.zzayv(), zzbVar.zzbcm());
            ArrayList arrayList = new ArrayList();
            arrayList.add(zzeanVar);
            String str = new String(zzeanVar.zzayw(), UTF_8);
            List<zzean<P>> listPut = this.zzhup.put(str, Collections.unmodifiableList(arrayList));
            if (listPut != null) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(listPut);
                arrayList2.add(zzeanVar);
                this.zzhup.put(str, Collections.unmodifiableList(arrayList2));
            }
            return zzeanVar;
        }
        throw new GeneralSecurityException("only ENABLED key is allowed");
    }
}
