package com.sandboxol.file.a;

/* JADX INFO: compiled from: BaseFileHandler.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f17538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f17539b = 1;

    public b a(b bVar) {
        b bVar2 = this.f17538a;
        if (bVar2 == null) {
            this.f17538a = bVar;
        } else {
            bVar2.a(bVar);
        }
        return this;
    }

    public void a() {
    }

    public b b() {
        return this.f17538a;
    }

    public int c() {
        return this.f17539b;
    }

    public abstract void d();

    public abstract void e();

    public void a(int i) {
        this.f17539b = i;
    }
}
