package com.tencent.mapsdk.rastercore.b;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f19442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f19443b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<a> f19444c;

    public b(int i, int i2, List<a> list) {
        this.f19442a = i;
        this.f19443b = i2;
        this.f19444c = list;
        Collections.sort(list, new Comparator<a>(this) { // from class: com.tencent.mapsdk.rastercore.b.b.1
            @Override // java.util.Comparator
            public final /* synthetic */ int compare(a aVar, a aVar2) {
                return aVar2.a() - aVar.a();
            }
        });
    }

    public final int a() {
        return this.f19442a;
    }

    public final String[] a(c cVar) {
        for (a aVar : this.f19444c) {
            if (aVar.a(cVar)) {
                return new String[]{aVar.b(), aVar.c()};
            }
        }
        return null;
    }

    public final int b() {
        return this.f19443b;
    }
}
