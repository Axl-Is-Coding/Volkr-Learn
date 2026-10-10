package com.ta.utdid2.b.a;

import android.annotation.TargetApi;
import android.util.Base64;

/* JADX INFO: compiled from: Base64Helper.java */
/* JADX INFO: loaded from: classes5.dex */
public class c {
    @TargetApi(8)
    public static String encodeToString(byte[] bArr, int i) {
        return Base64.encodeToString(bArr, i);
    }
}
