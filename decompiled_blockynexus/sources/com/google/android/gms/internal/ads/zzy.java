package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzy {
    public final List<zzu> allHeaders;
    public final byte[] data;
    public final int statusCode;
    public final Map<String, String> zzam;
    public final boolean zzan;
    private final long zzao;

    /* JADX WARN: Illegal instructions before constructor call */
    @Deprecated
    public zzy(int i, byte[] bArr, Map<String, String> map, boolean z, long j) {
        List arrayList;
        if (map == null) {
            arrayList = null;
        } else if (map.isEmpty()) {
            arrayList = Collections.emptyList();
        } else {
            arrayList = new ArrayList(map.size());
            for (Map.Entry<String, String> entry : map.entrySet()) {
                arrayList.add(new zzu(entry.getKey(), entry.getValue()));
            }
        }
        this(i, bArr, map, arrayList, z, j);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public zzy(int i, byte[] bArr, boolean z, long j, List<zzu> list) {
        Map treeMap;
        if (list == null) {
            treeMap = null;
        } else if (list.isEmpty()) {
            treeMap = Collections.emptyMap();
        } else {
            treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            for (zzu zzuVar : list) {
                treeMap.put(zzuVar.getName(), zzuVar.getValue());
            }
        }
        this(i, bArr, treeMap, list, z, j);
    }

    @Deprecated
    public zzy(byte[] bArr, Map<String, String> map) {
        this(200, bArr, map, false, 0L);
    }

    private zzy(int i, byte[] bArr, Map<String, String> map, List<zzu> list, boolean z, long j) {
        this.statusCode = i;
        this.data = bArr;
        this.zzam = map;
        if (list == null) {
            this.allHeaders = null;
        } else {
            this.allHeaders = Collections.unmodifiableList(list);
        }
        this.zzan = z;
        this.zzao = j;
    }
}
