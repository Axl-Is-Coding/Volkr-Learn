package com.google.gson;

import com.google.gson.internal.LinkedTreeMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: JsonObject.java */
/* JADX INFO: loaded from: classes2.dex */
public final class r extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinkedTreeMap<String, p> f14260a = new LinkedTreeMap<>();

    public void a(String str, p pVar) {
        if (pVar == null) {
            pVar = q.f14259a;
        }
        this.f14260a.put(str, pVar);
    }

    public m b(String str) {
        return (m) this.f14260a.get(str);
    }

    public t c(String str) {
        return (t) this.f14260a.get(str);
    }

    public Set<Map.Entry<String, p>> entrySet() {
        return this.f14260a.entrySet();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof r) && ((r) obj).f14260a.equals(this.f14260a));
    }

    public int hashCode() {
        return this.f14260a.hashCode();
    }

    public Set<String> m() {
        return this.f14260a.keySet();
    }

    public void a(String str, String str2) {
        a(str, a((Object) str2));
    }

    private p a(Object obj) {
        return obj == null ? q.f14259a : new t(obj);
    }

    public p a(String str) {
        return this.f14260a.get(str);
    }
}
