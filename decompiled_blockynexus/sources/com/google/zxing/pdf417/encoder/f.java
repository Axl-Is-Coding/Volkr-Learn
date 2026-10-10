package com.google.zxing.pdf417.encoder;

/* JADX INFO: compiled from: PDF417HighLevelEncoder.java */
/* JADX INFO: loaded from: classes2.dex */
/* synthetic */ class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f14509a = new int[Compaction.values().length];

    static {
        try {
            f14509a[Compaction.TEXT.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f14509a[Compaction.BYTE.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f14509a[Compaction.NUMERIC.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
