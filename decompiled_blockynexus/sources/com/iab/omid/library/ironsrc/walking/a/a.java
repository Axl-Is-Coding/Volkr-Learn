package com.iab.omid.library.ironsrc.walking.a;

import com.iab.omid.library.ironsrc.walking.a.b;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final HashSet<String> f14560c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final JSONObject f14561d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final long f14562e;

    public a(b.InterfaceC0141b interfaceC0141b, HashSet<String> hashSet, JSONObject jSONObject, long j) {
        super(interfaceC0141b);
        this.f14560c = new HashSet<>(hashSet);
        this.f14561d = jSONObject;
        this.f14562e = j;
    }
}
