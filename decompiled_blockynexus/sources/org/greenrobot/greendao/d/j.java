package org.greenrobot.greendao.d;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.d.k;

/* JADX INFO: compiled from: WhereCollector.java */
/* JADX INFO: loaded from: classes5.dex */
class j<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final org.greenrobot.greendao.a<T, ?> f23617a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<k> f23618b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f23619c;

    j(org.greenrobot.greendao.a<T, ?> aVar, String str) {
        this.f23617a = aVar;
        this.f23619c = str;
    }

    void a(k kVar, k... kVarArr) {
        a(kVar);
        this.f23618b.add(kVar);
        for (k kVar2 : kVarArr) {
            a(kVar2);
            this.f23618b.add(kVar2);
        }
    }

    k a(String str, k kVar, k kVar2, k... kVarArr) {
        StringBuilder sb = new StringBuilder("(");
        ArrayList arrayList = new ArrayList();
        a(sb, arrayList, kVar);
        sb.append(str);
        a(sb, arrayList, kVar2);
        for (k kVar3 : kVarArr) {
            sb.append(str);
            a(sb, arrayList, kVar3);
        }
        sb.append(')');
        return new k.c(sb.toString(), arrayList.toArray());
    }

    void a(StringBuilder sb, List<Object> list, k kVar) {
        a(kVar);
        kVar.a(sb, this.f23619c);
        kVar.a(list);
    }

    void a(k kVar) {
        if (kVar instanceof k.b) {
            a(((k.b) kVar).f23623d);
        }
    }

    void a(org.greenrobot.greendao.f fVar) {
        org.greenrobot.greendao.a<T, ?> aVar = this.f23617a;
        if (aVar != null) {
            org.greenrobot.greendao.f[] properties = aVar.getProperties();
            int length = properties.length;
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (fVar == properties[i]) {
                    z = true;
                    break;
                }
                i++;
            }
            if (z) {
                return;
            }
            throw new DaoException("Property '" + fVar.f23632c + "' is not part of " + this.f23617a);
        }
    }

    void a(StringBuilder sb, String str, List<Object> list) {
        ListIterator<k> listIterator = this.f23618b.listIterator();
        while (listIterator.hasNext()) {
            if (listIterator.hasPrevious()) {
                sb.append(" AND ");
            }
            k next = listIterator.next();
            next.a(sb, str);
            next.a(list);
        }
    }

    boolean a() {
        return this.f23618b.isEmpty();
    }
}
