package com.ironsource.mediationsdk.utils;

import android.text.TextUtils;
import java.util.ArrayList;

/* JADX INFO: compiled from: TokenSettings.java */
/* JADX INFO: loaded from: classes2.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayList<String> f15054a = new ArrayList<>();

    n() {
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f15054a.add(str);
    }
}
