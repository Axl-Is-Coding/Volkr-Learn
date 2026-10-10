package com.tencent.mapsdk.rastercore.b;

import com.sandboxol.center.config.StringConstant;

/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f19437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f19438b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f19439c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f19440d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f19441e;

    public a(int i, int i2, String str, String str2, String str3) {
        this.f19437a = 0;
        this.f19438b = 0;
        this.f19439c = StringConstant.PARTY_GAME_CATEGORY_DEFAULT;
        this.f19440d = "";
        this.f19441e = "";
        this.f19437a = i;
        this.f19438b = i2;
        this.f19440d = str;
        this.f19441e = str2;
        this.f19439c = str3;
    }

    public final int a() {
        return (this.f19437a * 10) + this.f19438b;
    }

    public final boolean a(c cVar) {
        int i = this.f19437a;
        if (i == 0) {
            if (StringConstant.PARTY_GAME_CATEGORY_DEFAULT.equals(this.f19439c)) {
                return true;
            }
            if (cVar == null) {
                return false;
            }
            f fVarA = cVar.a();
            com.tencent.mapsdk.rastercore.d.e.a();
            return com.tencent.mapsdk.rastercore.d.e.a(fVarA, com.tencent.mapsdk.rastercore.d.e.c(this.f19439c));
        }
        if (i != 1) {
            return false;
        }
        if (StringConstant.PARTY_GAME_CATEGORY_DEFAULT.equals(this.f19439c)) {
            return true;
        }
        if (cVar == null) {
            return false;
        }
        com.tencent.mapsdk.rastercore.d.e.a();
        return com.tencent.mapsdk.rastercore.d.e.a(cVar.b(), com.tencent.mapsdk.rastercore.d.e.c(this.f19439c));
    }

    public final String b() {
        return this.f19440d;
    }

    public final String c() {
        return this.f19441e;
    }
}
