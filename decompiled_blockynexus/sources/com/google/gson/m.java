package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: JsonArray.java */
/* JADX INFO: loaded from: classes2.dex */
public final class m extends p implements Iterable<p> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<p> f14258a = new ArrayList();

    public void a(p pVar) {
        if (pVar == null) {
            pVar = q.f14259a;
        }
        this.f14258a.add(pVar);
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof m) && ((m) obj).f14258a.equals(this.f14258a));
    }

    @Override // com.google.gson.p
    public String h() {
        if (this.f14258a.size() == 1) {
            return this.f14258a.get(0).h();
        }
        throw new IllegalStateException();
    }

    public int hashCode() {
        return this.f14258a.hashCode();
    }

    @Override // java.lang.Iterable
    public Iterator<p> iterator() {
        return this.f14258a.iterator();
    }

    @Override // com.google.gson.p
    public int a() {
        if (this.f14258a.size() == 1) {
            return this.f14258a.get(0).a();
        }
        throw new IllegalStateException();
    }
}
