package com.bumptech.glide.e.a;

/* JADX INFO: compiled from: StateVerifier.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class g {

    /* JADX INFO: compiled from: StateVerifier.java */
    private static class a extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private volatile boolean f4158a;

        a() {
            super();
        }

        @Override // com.bumptech.glide.e.a.g
        public void a(boolean z) {
            this.f4158a = z;
        }

        @Override // com.bumptech.glide.e.a.g
        public void b() {
            if (this.f4158a) {
                throw new IllegalStateException("Already released");
            }
        }
    }

    public static g a() {
        return new a();
    }

    abstract void a(boolean z);

    public abstract void b();

    private g() {
    }
}
