package com.alibaba.sdk.android.feedback.xblink.d;

import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static boolean a(String str) {
        return str != null && new File(str).exists();
    }
}
