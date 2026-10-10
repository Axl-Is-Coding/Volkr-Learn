package com.apkfuns.logutils;

/* JADX INFO: compiled from: LogConfigImpl.java */
/* JADX INFO: loaded from: classes.dex */
class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f4070a;

    private b() {
    }

    static b a() {
        if (f4070a == null) {
            synchronized (b.class) {
                if (f4070a == null) {
                    f4070a = new b();
                }
            }
        }
        return f4070a;
    }

    @Override // com.apkfuns.logutils.a
    public a a(String str) {
        return this;
    }

    @Override // com.apkfuns.logutils.a
    public a a(boolean z) {
        return this;
    }
}
