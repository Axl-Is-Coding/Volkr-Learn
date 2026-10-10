package com.tencent.map.geolocation;

import android.text.TextUtils;

/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes5.dex */
public class TencentLocationManagerOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f19402a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f19403b = "";

    public static String getKey() {
        return f19403b;
    }

    public static boolean isLoadLibraryEnabled() {
        return f19402a;
    }

    public static boolean setKey(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        f19403b = str;
        return true;
    }

    public static void setLoadLibraryEnabled(boolean z) {
        f19402a = z;
    }
}
