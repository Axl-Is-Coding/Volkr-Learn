package com.apkfuns.logutils;

/* JADX INFO: compiled from: Logger.java */
/* JADX INFO: loaded from: classes.dex */
class d implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile d f4071a;

    private d() {
    }

    static d a() {
        if (f4071a == null) {
            synchronized (d.class) {
                if (f4071a == null) {
                    f4071a = new d();
                }
            }
        }
        return f4071a;
    }

    @Override // com.apkfuns.logutils.e
    public void a(Object obj) {
    }

    @Override // com.apkfuns.logutils.e
    public void a(String str, Object... objArr) {
    }

    @Override // com.apkfuns.logutils.e
    public void b(Object obj) {
    }

    @Override // com.apkfuns.logutils.e
    public void c(Object obj) {
    }

    @Override // com.apkfuns.logutils.e
    public void d(Object obj) {
    }
}
