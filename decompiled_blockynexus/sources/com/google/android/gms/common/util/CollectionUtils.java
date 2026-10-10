package com.google.android.gms.common.util;

import a.a.b;
import a.a.d;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* JADX INFO: loaded from: classes.dex */
@KeepForSdk
public final class CollectionUtils {
    private CollectionUtils() {
    }

    @KeepForSdk
    public static boolean isEmpty(Collection<?> collection) {
        if (collection == null) {
            return true;
        }
        return collection.isEmpty();
    }

    @KeepForSdk
    @Deprecated
    public static <T> List<T> listOf() {
        return Collections.emptyList();
    }

    @KeepForSdk
    public static <K, V> Map<K, V> mapOf(K k, V v, K k2, V v2, K k3, V v3) {
        Map mapZzb = zzb(3, false);
        mapZzb.put(k, v);
        mapZzb.put(k2, v2);
        mapZzb.put(k3, v3);
        return Collections.unmodifiableMap(mapZzb);
    }

    @KeepForSdk
    public static <K, V> Map<K, V> mapOfKeyValueArrays(K[] kArr, V[] vArr) {
        if (kArr.length != vArr.length) {
            int length = kArr.length;
            int length2 = vArr.length;
            StringBuilder sb = new StringBuilder(66);
            sb.append("Key and values array lengths not equal: ");
            sb.append(length);
            sb.append(" != ");
            sb.append(length2);
            throw new IllegalArgumentException(sb.toString());
        }
        int length3 = kArr.length;
        if (length3 == 0) {
            return Collections.emptyMap();
        }
        if (length3 == 1) {
            return Collections.singletonMap(kArr[0], vArr[0]);
        }
        Map mapZzb = zzb(kArr.length, false);
        for (int i = 0; i < kArr.length; i++) {
            mapZzb.put(kArr[i], vArr[i]);
        }
        return Collections.unmodifiableMap(mapZzb);
    }

    @KeepForSdk
    public static <T> Set<T> mutableSetOfWithSize(int i) {
        return i == 0 ? new d() : zza(i, true);
    }

    @KeepForSdk
    @Deprecated
    public static <T> Set<T> setOf(T t, T t2, T t3) {
        Set setZza = zza(3, false);
        setZza.add(t);
        setZza.add(t2);
        setZza.add(t3);
        return Collections.unmodifiableSet(setZza);
    }

    private static <T> Set<T> zza(int i, boolean z) {
        return i <= (z ? 128 : 256) ? new d(i) : new HashSet(i, z ? 0.75f : 1.0f);
    }

    private static <K, V> Map<K, V> zzb(int i, boolean z) {
        return i <= 256 ? new b(i) : new HashMap(i, 1.0f);
    }

    @KeepForSdk
    @Deprecated
    public static <T> List<T> listOf(T t) {
        return Collections.singletonList(t);
    }

    @KeepForSdk
    @Deprecated
    public static <T> List<T> listOf(T... tArr) {
        int length = tArr.length;
        if (length == 0) {
            return listOf();
        }
        if (length != 1) {
            return Collections.unmodifiableList(Arrays.asList(tArr));
        }
        return listOf(tArr[0]);
    }

    @KeepForSdk
    public static <K, V> Map<K, V> mapOf(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6) {
        Map mapZzb = zzb(6, false);
        mapZzb.put(k, v);
        mapZzb.put(k2, v2);
        mapZzb.put(k3, v3);
        mapZzb.put(k4, v4);
        mapZzb.put(k5, v5);
        mapZzb.put(k6, v6);
        return Collections.unmodifiableMap(mapZzb);
    }

    @KeepForSdk
    @Deprecated
    public static <T> Set<T> setOf(T... tArr) {
        int length = tArr.length;
        if (length == 0) {
            return Collections.emptySet();
        }
        if (length == 1) {
            return Collections.singleton(tArr[0]);
        }
        if (length == 2) {
            T t = tArr[0];
            T t2 = tArr[1];
            Set setZza = zza(2, false);
            setZza.add(t);
            setZza.add(t2);
            return Collections.unmodifiableSet(setZza);
        }
        if (length == 3) {
            return setOf(tArr[0], tArr[1], tArr[2]);
        }
        if (length != 4) {
            Set setZza2 = zza(tArr.length, false);
            Collections.addAll(setZza2, tArr);
            return Collections.unmodifiableSet(setZza2);
        }
        T t3 = tArr[0];
        T t4 = tArr[1];
        T t5 = tArr[2];
        T t6 = tArr[3];
        Set setZza3 = zza(4, false);
        setZza3.add(t3);
        setZza3.add(t4);
        setZza3.add(t5);
        setZza3.add(t6);
        return Collections.unmodifiableSet(setZza3);
    }
}
