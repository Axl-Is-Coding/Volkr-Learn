package org.greenrobot.greendao;

import org.greenrobot.greendao.d.k;

/* JADX INFO: compiled from: Property.java */
/* JADX INFO: loaded from: classes5.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f23630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<?> f23631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f23632c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f23633d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f23634e;

    public f(int i, Class<?> cls, String str, boolean z, String str2) {
        this.f23630a = i;
        this.f23631b = cls;
        this.f23632c = str;
        this.f23633d = z;
        this.f23634e = str2;
    }

    public k a(Object obj) {
        return new k.b(this, "=?", obj);
    }
}
