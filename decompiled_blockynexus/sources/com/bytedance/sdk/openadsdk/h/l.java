package com.bytedance.sdk.openadsdk.h;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: compiled from: Urls.java */
/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Set<String> f6973a = new HashSet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<String> f6974b = new HashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayList<a> f6975c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f6976d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f6977e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f6978f;
    private final int g;

    /* JADX INFO: compiled from: Urls.java */
    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f6979a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f6980b;

        a(String str) {
            this.f6979a = str;
        }

        void a() {
            l.f6973a.add(this.f6979a);
        }

        void b() {
            l.f6974b.add(this.f6979a);
        }

        public String toString() {
            return this.f6979a;
        }
    }

    l(List<String> list) {
        this.f6977e = -1;
        if (list.isEmpty()) {
            throw new IllegalArgumentException("urls can't be empty");
        }
        this.f6976d = list.size();
        this.f6975c = new ArrayList<>(this.f6976d);
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        for (String str : list) {
            a aVar = new a(str);
            if (f6973a.contains(str)) {
                arrayList2 = arrayList2 == null ? new ArrayList() : arrayList2;
                arrayList2.add(aVar);
            } else if (f6974b.contains(str)) {
                arrayList = arrayList == null ? new ArrayList() : arrayList;
                arrayList.add(aVar);
            } else {
                this.f6975c.add(aVar);
            }
        }
        if (arrayList != null) {
            this.f6975c.addAll(arrayList);
        }
        if (arrayList2 != null) {
            this.f6975c.addAll(arrayList2);
        }
        Integer num = e.i;
        this.g = (num == null || num.intValue() <= 0) ? this.f6976d >= 2 ? 1 : 2 : num.intValue();
    }

    boolean a() {
        return this.f6978f < this.g;
    }

    a b() {
        if (!a()) {
            throw new NoSuchElementException();
        }
        int i = this.f6977e + 1;
        if (i >= this.f6976d - 1) {
            this.f6977e = -1;
            this.f6978f++;
        } else {
            this.f6977e = i;
        }
        a aVar = this.f6975c.get(i);
        aVar.f6980b = (this.f6978f * this.f6976d) + this.f6977e;
        return aVar;
    }

    l(String str) {
        this.f6977e = -1;
        this.f6975c = new ArrayList<>(1);
        this.f6975c.add(new a(str));
        this.f6976d = 1;
        this.g = 1;
    }
}
