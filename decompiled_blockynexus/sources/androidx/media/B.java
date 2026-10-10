package androidx.media;

import android.text.TextUtils;

/* JADX INFO: compiled from: MediaSessionManagerImplBase.java */
/* JADX INFO: loaded from: classes.dex */
class B implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f1659a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1660b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f1661c;

    B(String str, int i, int i2) {
        this.f1659a = str;
        this.f1660b = i;
        this.f1661c = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof B)) {
            return false;
        }
        B b2 = (B) obj;
        return TextUtils.equals(this.f1659a, b2.f1659a) && this.f1660b == b2.f1660b && this.f1661c == b2.f1661c;
    }

    public int hashCode() {
        return androidx.core.f.c.a(this.f1659a, Integer.valueOf(this.f1660b), Integer.valueOf(this.f1661c));
    }
}
