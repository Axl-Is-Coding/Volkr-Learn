package com.tencent.mapsdk.rastercore.b;

/* JADX INFO: loaded from: classes5.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private f f19453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private f f19454b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private double f19455a = Double.MAX_VALUE;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private double f19456b = -1.7976931348623157E308d;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private double f19457c = Double.MAX_VALUE;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private double f19458d = -1.7976931348623157E308d;

        public final a a(f fVar) {
            this.f19455a = Math.min(this.f19455a, fVar.a());
            this.f19456b = Math.max(this.f19456b, fVar.a());
            this.f19458d = Math.max(this.f19458d, fVar.b());
            this.f19457c = Math.min(this.f19457c, fVar.b());
            return this;
        }
    }

    public e(f fVar, f fVar2) {
        a aVarA = new a().a(fVar).a(fVar2);
        this.f19453a = new f(aVarA.f19457c, aVarA.f19455a);
        this.f19454b = new f(aVarA.f19458d, aVarA.f19456b);
    }

    public final f a() {
        return this.f19453a;
    }

    public final f b() {
        return this.f19454b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f19453a.equals(eVar.f19453a) && this.f19454b.equals(eVar.f19454b);
    }

    public final int hashCode() {
        return com.tencent.mapsdk.rastercore.f.b.a(new Object[]{this.f19453a, this.f19454b});
    }

    public final String toString() {
        return com.tencent.mapsdk.rastercore.f.b.a(com.tencent.mapsdk.rastercore.f.b.a("southwest", this.f19453a), com.tencent.mapsdk.rastercore.f.b.a("northeast", this.f19454b));
    }
}
