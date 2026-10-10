package com.iab.omid.library.ironsrc.adsession;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Owner f14527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Owner f14528b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f14529c;

    private c(Owner owner, Owner owner2, boolean z) {
        this.f14527a = owner;
        if (owner2 == null) {
            this.f14528b = Owner.NONE;
        } else {
            this.f14528b = owner2;
        }
        this.f14529c = z;
    }

    public static c a(Owner owner, Owner owner2, boolean z) {
        b.e.a.a.a.d.e.a(owner, "Impression owner is null");
        b.e.a.a.a.d.e.a(owner);
        return new c(owner, owner2, z);
    }

    public boolean a() {
        return Owner.NATIVE == this.f14527a;
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        b.e.a.a.a.d.b.a(jSONObject, "impressionOwner", this.f14527a);
        b.e.a.a.a.d.b.a(jSONObject, "videoEventsOwner", this.f14528b);
        b.e.a.a.a.d.b.a(jSONObject, "isolateVerificationScripts", Boolean.valueOf(this.f14529c));
        return jSONObject;
    }
}
