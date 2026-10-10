package com.bytedance.sdk.adnet.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: NetworkResponse.java */
/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f5525b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f5526c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Header> f5527d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f5528e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f5529f;

    @Deprecated
    public i(int i, byte[] bArr, Map<String, String> map, boolean z, long j) {
        this(i, bArr, map, a(map), z, j);
    }

    private static Map<String, String> a(List<Header> list) {
        if (list == null) {
            return null;
        }
        if (list.isEmpty()) {
            return Collections.emptyMap();
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (Header header : list) {
            treeMap.put(header.getName(), header.getValue());
        }
        return treeMap;
    }

    public i(int i, byte[] bArr, boolean z, long j, List<Header> list) {
        this(i, bArr, a(list), list, z, j);
    }

    @Deprecated
    public i(byte[] bArr, Map<String, String> map) {
        this(200, bArr, map, false, 0L);
    }

    private i(int i, byte[] bArr, Map<String, String> map, List<Header> list, boolean z, long j) {
        this.f5524a = i;
        this.f5525b = bArr;
        this.f5526c = map;
        if (list == null) {
            this.f5527d = null;
        } else {
            this.f5527d = Collections.unmodifiableList(list);
        }
        this.f5528e = z;
        this.f5529f = j;
    }

    private static List<Header> a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        if (map.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(new Header(entry.getKey(), entry.getValue()));
        }
        return arrayList;
    }
}
