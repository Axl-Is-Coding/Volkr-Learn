package com.google.protobuf;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: Internal.java */
/* JADX INFO: loaded from: classes2.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Charset f14375a = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final Charset f14376b = Charset.forName("ISO-8859-1");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte[] f14377c = new byte[0];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ByteBuffer f14378d = ByteBuffer.wrap(f14377c);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C2301g f14379e = C2301g.a(f14377c);

    /* JADX INFO: compiled from: Internal.java */
    public interface a extends h<Boolean> {
        @Override // com.google.protobuf.r.h
        h<Boolean> a(int i);
    }

    /* JADX INFO: compiled from: Internal.java */
    public interface b extends h<Double> {
        @Override // com.google.protobuf.r.h
        h<Double> a(int i);
    }

    /* JADX INFO: compiled from: Internal.java */
    public interface c {
    }

    /* JADX INFO: compiled from: Internal.java */
    public interface d<T extends c> {
    }

    /* JADX INFO: compiled from: Internal.java */
    public interface e extends h<Float> {
        @Override // com.google.protobuf.r.h
        h<Float> a(int i);
    }

    /* JADX INFO: compiled from: Internal.java */
    public interface f extends h<Integer> {
        @Override // com.google.protobuf.r.h
        h<Integer> a(int i);

        void b(int i);

        int getInt(int i);

        int setInt(int i, int i2);
    }

    /* JADX INFO: compiled from: Internal.java */
    public interface g extends h<Long> {
        @Override // com.google.protobuf.r.h
        h<Long> a(int i);
    }

    /* JADX INFO: compiled from: Internal.java */
    public interface h<E> extends List<E>, RandomAccess {
        h<E> a(int i);

        void b();

        boolean d();
    }

    static int a(int i, byte[] bArr, int i2, int i3) {
        int i4 = i;
        for (int i5 = i2; i5 < i2 + i3; i5++) {
            i4 = (i4 * 31) + bArr[i5];
        }
        return i4;
    }

    public static int a(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static int a(boolean z) {
        return z ? 1231 : 1237;
    }
}
