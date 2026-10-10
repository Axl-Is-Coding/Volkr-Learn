package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzepd<T> implements zzeoy<Set<T>> {
    private static final zzeoy<Set<Object>> zziut = zzeox.zzba(Collections.emptySet());
    private final List<zzeph<T>> zziuu;
    private final List<zzeph<Collection<T>>> zziuv;

    private zzepd(List<zzeph<T>> list, List<zzeph<Collection<T>>> list2) {
        this.zziuu = list;
        this.zziuv = list2;
    }

    public static <T> zzepf<T> zzar(int i, int i2) {
        return new zzepf<>(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        int size = this.zziuu.size();
        ArrayList arrayList = new ArrayList(this.zziuv.size());
        int size2 = this.zziuv.size();
        int size3 = size;
        for (int i = 0; i < size2; i++) {
            Collection<T> collection = this.zziuv.get(i).get();
            size3 += collection.size();
            arrayList.add(collection);
        }
        HashSet hashSetZzhz = zzeot.zzhz(size3);
        int size4 = this.zziuu.size();
        for (int i2 = 0; i2 < size4; i2++) {
            T t = this.zziuu.get(i2).get();
            zzepe.checkNotNull(t);
            hashSetZzhz.add(t);
        }
        int size5 = arrayList.size();
        for (int i3 = 0; i3 < size5; i3++) {
            for (Object obj : (Collection) arrayList.get(i3)) {
                zzepe.checkNotNull(obj);
                hashSetZzhz.add(obj);
            }
        }
        return Collections.unmodifiableSet(hashSetZzhz);
    }
}
