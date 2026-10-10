package com.tbruyelle.rxpermissions2;

import io.reactivex.p;
import java.util.List;

/* JADX INFO: compiled from: Permission.java */
/* JADX INFO: loaded from: classes5.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f19383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f19384b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f19385c;

    public e(String str, boolean z, boolean z2) {
        this.f19383a = str;
        this.f19384b = z;
        this.f19385c = z2;
    }

    private Boolean a(List<e> list) {
        return p.fromIterable(list).all(new c(this)).b();
    }

    private String b(List<e> list) {
        return ((StringBuilder) p.fromIterable(list).map(new b(this)).collectInto(new StringBuilder(), new a(this)).b()).toString();
    }

    private Boolean c(List<e> list) {
        return p.fromIterable(list).any(new d(this)).b();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        if (this.f19384b == eVar.f19384b && this.f19385c == eVar.f19385c) {
            return this.f19383a.equals(eVar.f19383a);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f19383a.hashCode() * 31) + (this.f19384b ? 1 : 0)) * 31) + (this.f19385c ? 1 : 0);
    }

    public String toString() {
        return "Permission{name='" + this.f19383a + "', granted=" + this.f19384b + ", shouldShowRequestPermissionRationale=" + this.f19385c + '}';
    }

    public e(List<e> list) {
        this.f19383a = b(list);
        this.f19384b = a(list).booleanValue();
        this.f19385c = c(list).booleanValue();
    }
}
