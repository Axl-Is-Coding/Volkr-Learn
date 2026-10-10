package com.iab.omid.library.ironsrc.walking;

import com.iab.omid.library.ironsrc.walking.a.b;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g implements b.InterfaceC0141b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f14585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.iab.omid.library.ironsrc.walking.a.c f14586b;

    public g(com.iab.omid.library.ironsrc.walking.a.c cVar) {
        this.f14586b = cVar;
    }

    public void a() {
        this.f14586b.b(new com.iab.omid.library.ironsrc.walking.a.d(this));
    }

    @Override // com.iab.omid.library.ironsrc.walking.a.b.InterfaceC0141b
    public void a(JSONObject jSONObject) {
        this.f14585a = jSONObject;
    }

    public void a(JSONObject jSONObject, HashSet<String> hashSet, long j) {
        this.f14586b.b(new com.iab.omid.library.ironsrc.walking.a.f(this, hashSet, jSONObject, j));
    }

    @Override // com.iab.omid.library.ironsrc.walking.a.b.InterfaceC0141b
    public JSONObject b() {
        return this.f14585a;
    }

    public void b(JSONObject jSONObject, HashSet<String> hashSet, long j) {
        this.f14586b.b(new com.iab.omid.library.ironsrc.walking.a.e(this, hashSet, jSONObject, j));
    }
}
