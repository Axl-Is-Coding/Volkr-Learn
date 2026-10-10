package com.tendcloud.tenddata;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public final class at {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static byte[] f19802a = new byte[0];

    private at() {
    }

    public static byte[] a(byte[] bArr) {
        try {
            ax.a();
            return av.a(bArr);
        } catch (Throwable th) {
            bp.postSDKError(th);
            return f19802a;
        }
    }

    public static byte[] b(byte[] bArr) {
        try {
            ax.a();
            return av.b(bArr);
        } catch (Throwable th) {
            bp.postSDKError(th);
            return f19802a;
        }
    }
}
