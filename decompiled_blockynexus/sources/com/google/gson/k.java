package com.google.gson;

import com.google.gson.internal.C2271a;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.T;
import com.google.gson.internal.bind.TreeTypeAdapter;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: GsonBuilder.java */
/* JADX INFO: loaded from: classes2.dex */
public final class k {
    private String h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Excluder f14252a = Excluder.f14102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LongSerializationPolicy f14253b = LongSerializationPolicy.DEFAULT;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private d f14254c = FieldNamingPolicy.IDENTITY;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<Type, l<?>> f14255d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<y> f14256e = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<y> f14257f = new ArrayList();
    private boolean g = false;
    private int i = 2;
    private int j = 2;
    private boolean k = false;
    private boolean l = false;
    private boolean m = true;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;

    public k a(Type type, Object obj) {
        boolean z = obj instanceof v;
        C2271a.a(z || (obj instanceof o) || (obj instanceof l) || (obj instanceof x));
        if (obj instanceof l) {
            this.f14255d.put(type, (l) obj);
        }
        if (z || (obj instanceof o)) {
            this.f14256e.add(TreeTypeAdapter.a(TypeToken.get(type), obj));
        }
        if (obj instanceof x) {
            this.f14256e.add(T.a(TypeToken.get(type), (x) obj));
        }
        return this;
    }

    public k a(y yVar) {
        this.f14256e.add(yVar);
        return this;
    }

    public j a() {
        List<y> arrayList = new ArrayList<>(this.f14256e.size() + this.f14257f.size() + 3);
        arrayList.addAll(this.f14256e);
        Collections.reverse(arrayList);
        ArrayList arrayList2 = new ArrayList(this.f14257f);
        Collections.reverse(arrayList2);
        arrayList.addAll(arrayList2);
        a(this.h, this.i, this.j, arrayList);
        return new j(this.f14252a, this.f14254c, this.f14255d, this.g, this.k, this.o, this.m, this.n, this.p, this.l, this.f14253b, this.h, this.i, this.j, this.f14256e, this.f14257f, arrayList);
    }

    private void a(String str, int i, int i2, List<y> list) {
        a aVar;
        a aVar2;
        a aVar3;
        if (str != null && !"".equals(str.trim())) {
            a aVar4 = new a(Date.class, str);
            aVar2 = new a(Timestamp.class, str);
            aVar3 = new a(java.sql.Date.class, str);
            aVar = aVar4;
        } else {
            if (i == 2 || i2 == 2) {
                return;
            }
            aVar = new a(Date.class, i, i2);
            a aVar5 = new a(Timestamp.class, i, i2);
            a aVar6 = new a(java.sql.Date.class, i, i2);
            aVar2 = aVar5;
            aVar3 = aVar6;
        }
        list.add(T.a(Date.class, aVar));
        list.add(T.a(Timestamp.class, aVar2));
        list.add(T.a(java.sql.Date.class, aVar3));
    }
}
