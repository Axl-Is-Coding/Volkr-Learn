package com.bytedance.sdk.openadsdk.utils;

import java.util.List;

/* JADX INFO: compiled from: ListUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class m {
    public static boolean a(List<?> list) {
        return list == null || list.size() == 0;
    }

    public static boolean b(List<?> list) {
        return !a(list);
    }
}
