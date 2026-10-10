package io.reactivex.internal.util;

/* JADX INFO: compiled from: Pow2.java */
/* JADX INFO: loaded from: classes5.dex */
public final class j {
    public static int a(int i) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i - 1));
    }
}
