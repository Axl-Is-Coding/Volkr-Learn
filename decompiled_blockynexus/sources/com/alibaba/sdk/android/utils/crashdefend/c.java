package com.alibaba.sdk.android.utils.crashdefend;

import android.util.Log;

/* JADX INFO: compiled from: CrashDefendSDKInfo.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3953a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f91a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f93a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3954b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f94b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f95b;
    public int crashCount;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3955c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f3956d = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SDKMessageCallback f92a = null;

    public Object clone() {
        try {
            return (c) super.clone();
        } catch (CloneNotSupportedException e2) {
            Log.e("CrashSDK", "clone fail:", e2);
            return null;
        }
    }
}
