package com.google.android.datatransport.runtime.d.a;

/* JADX INFO: renamed from: com.google.android.datatransport.runtime.d.a.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AutoValue_PersistedEvent.java */
/* JADX INFO: loaded from: classes.dex */
final class C2219c extends AbstractC2226j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f12888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.android.datatransport.runtime.q f12889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.google.android.datatransport.runtime.l f12890c;

    C2219c(long j, com.google.android.datatransport.runtime.q qVar, com.google.android.datatransport.runtime.l lVar) {
        this.f12888a = j;
        if (qVar == null) {
            throw new NullPointerException("Null transportContext");
        }
        this.f12889b = qVar;
        if (lVar == null) {
            throw new NullPointerException("Null event");
        }
        this.f12890c = lVar;
    }

    @Override // com.google.android.datatransport.runtime.d.a.AbstractC2226j
    public com.google.android.datatransport.runtime.l a() {
        return this.f12890c;
    }

    @Override // com.google.android.datatransport.runtime.d.a.AbstractC2226j
    public long b() {
        return this.f12888a;
    }

    @Override // com.google.android.datatransport.runtime.d.a.AbstractC2226j
    public com.google.android.datatransport.runtime.q c() {
        return this.f12889b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC2226j)) {
            return false;
        }
        AbstractC2226j abstractC2226j = (AbstractC2226j) obj;
        return this.f12888a == abstractC2226j.b() && this.f12889b.equals(abstractC2226j.c()) && this.f12890c.equals(abstractC2226j.a());
    }

    public int hashCode() {
        long j = this.f12888a;
        return this.f12890c.hashCode() ^ ((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.f12889b.hashCode()) * 1000003);
    }

    public String toString() {
        return "PersistedEvent{id=" + this.f12888a + ", transportContext=" + this.f12889b + ", event=" + this.f12890c + "}";
    }
}
