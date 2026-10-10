package androidx.media;

import java.util.Arrays;

/* JADX INFO: renamed from: androidx.media.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AudioAttributesImplBase.java */
/* JADX INFO: loaded from: classes.dex */
class C0347c implements InterfaceC0345a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f1700a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f1701b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f1702c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f1703d = -1;

    C0347c() {
    }

    public int a() {
        return this.f1701b;
    }

    public int b() {
        int i = this.f1702c;
        int iC = c();
        if (iC == 6) {
            i |= 4;
        } else if (iC == 7) {
            i |= 1;
        }
        return i & 273;
    }

    public int c() {
        int i = this.f1703d;
        return i != -1 ? i : AudioAttributesCompat.a(false, this.f1702c, this.f1700a);
    }

    public int d() {
        return this.f1700a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0347c)) {
            return false;
        }
        C0347c c0347c = (C0347c) obj;
        return this.f1701b == c0347c.a() && this.f1702c == c0347c.b() && this.f1700a == c0347c.d() && this.f1703d == c0347c.f1703d;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f1701b), Integer.valueOf(this.f1702c), Integer.valueOf(this.f1700a), Integer.valueOf(this.f1703d)});
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.f1703d != -1) {
            sb.append(" stream=");
            sb.append(this.f1703d);
            sb.append(" derived");
        }
        sb.append(" usage=");
        sb.append(AudioAttributesCompat.a(this.f1700a));
        sb.append(" content=");
        sb.append(this.f1701b);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.f1702c).toUpperCase());
        return sb.toString();
    }
}
