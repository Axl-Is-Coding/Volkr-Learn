package kotlin.collections;

import java.util.RandomAccess;

/* JADX INFO: compiled from: _ArraysJvm.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class g extends AbstractC2931b<Byte> implements RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ byte[] f22815a;

    g(byte[] bArr) {
        this.f22815a = bArr;
    }

    public boolean a(byte b2) {
        return i.a(this.f22815a, b2);
    }

    public int b(byte b2) {
        return i.b(this.f22815a, b2);
    }

    public int c(byte b2) {
        return i.c(this.f22815a, b2);
    }

    @Override // kotlin.collections.AbstractC2930a, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Byte) {
            return a(((Number) obj).byteValue());
        }
        return false;
    }

    @Override // kotlin.collections.AbstractC2931b, kotlin.collections.AbstractC2930a
    public int getSize() {
        return this.f22815a.length;
    }

    @Override // kotlin.collections.AbstractC2931b, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof Byte) {
            return b(((Number) obj).byteValue());
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractC2930a, java.util.Collection
    public boolean isEmpty() {
        return this.f22815a.length == 0;
    }

    @Override // kotlin.collections.AbstractC2931b, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof Byte) {
            return c(((Number) obj).byteValue());
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractC2931b, java.util.List
    public Byte get(int i) {
        return Byte.valueOf(this.f22815a[i]);
    }
}
