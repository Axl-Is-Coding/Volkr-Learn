package com.android.volley;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: NetworkResponse.java */
/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f4010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f4011c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<g> f4012d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f4013e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f4014f;

    @Deprecated
    public j(int i, byte[] bArr, Map<String, String> map, boolean z, long j) {
        this(i, bArr, map, a(map), z, j);
    }

    private static Map<String, String> a(List<g> list) {
        if (list == null) {
            return null;
        }
        if (list.isEmpty()) {
            return Collections.emptyMap();
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (g gVar : list) {
            treeMap.put(gVar.a(), gVar.b());
        }
        return treeMap;
    }

    public j(int i, byte[] bArr, boolean z, long j, List<g> list) {
        this(i, bArr, a(list), list, z, j);
    }

    @Deprecated
    public j(byte[] bArr, Map<String, String> map) {
        this(200, bArr, map, false, 0L);
    }

    private j(int i, byte[] bArr, Map<String, String> map, List<g> list, boolean z, long j) {
        this.f4009a = i;
        this.f4010b = bArr;
        this.f4011c = map;
        if (list == null) {
            this.f4012d = null;
        } else {
            this.f4012d = Collections.unmodifiableList(list);
        }
        this.f4013e = z;
        this.f4014f = j;
    }

    private static List<g> a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        if (map.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(new g(entry.getKey(), entry.getValue()));
        }
        return arrayList;
    }
}
