package com.google.android.datatransport;

/* JADX INFO: compiled from: AutoValue_Event.java */
/* JADX INFO: loaded from: classes.dex */
final class a<T> extends c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Integer f12720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final T f12721b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Priority f12722c;

    a(Integer num, T t, Priority priority) {
        this.f12720a = num;
        if (t == null) {
            throw new NullPointerException("Null payload");
        }
        this.f12721b = t;
        if (priority == null) {
            throw new NullPointerException("Null priority");
        }
        this.f12722c = priority;
    }

    @Override // com.google.android.datatransport.c
    public Integer a() {
        return this.f12720a;
    }

    @Override // com.google.android.datatransport.c
    public T b() {
        return this.f12721b;
    }

    @Override // com.google.android.datatransport.c
    public Priority c() {
        return this.f12722c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        Integer num = this.f12720a;
        if (num != null ? num.equals(cVar.a()) : cVar.a() == null) {
            if (this.f12721b.equals(cVar.b()) && this.f12722c.equals(cVar.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.f12720a;
        return (((((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003) ^ this.f12721b.hashCode()) * 1000003) ^ this.f12722c.hashCode();
    }

    public String toString() {
        return "Event{code=" + this.f12720a + ", payload=" + this.f12721b + ", priority=" + this.f12722c + "}";
    }
}
