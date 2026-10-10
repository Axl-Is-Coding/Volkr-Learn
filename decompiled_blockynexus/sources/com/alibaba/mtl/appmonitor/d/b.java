package com.alibaba.mtl.appmonitor.d;

import android.text.TextUtils;
import java.util.Set;

/* JADX INFO: compiled from: AccurateSampleCondition.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f3583a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Set<String> f3584c;

    /* JADX INFO: compiled from: AccurateSampleCondition.java */
    private enum a {
        IN,
        NOT_IN
    }

    public boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        boolean zContains = this.f3584c.contains(str);
        return this.f3583a == a.IN ? zContains : !zContains;
    }
}
