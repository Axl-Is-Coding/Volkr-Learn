package com.google.zxing.d.a;

import com.google.zxing.qrcode.decoder.Mode;

/* JADX INFO: compiled from: Encoder.java */
/* JADX INFO: loaded from: classes2.dex */
/* synthetic */ class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f14438a = new int[Mode.values().length];

    static {
        try {
            f14438a[Mode.NUMERIC.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f14438a[Mode.ALPHANUMERIC.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f14438a[Mode.BYTE.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f14438a[Mode.KANJI.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
