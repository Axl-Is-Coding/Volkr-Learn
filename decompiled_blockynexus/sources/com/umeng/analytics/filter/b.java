package com.umeng.analytics.filter;

import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;

/* JADX INFO: compiled from: EventWhiteList.java */
/* JADX INFO: loaded from: classes5.dex */
public class b extends EventList {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d f20597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object f20598b;

    public b(String str, String str2) {
        super(str, str2);
        this.f20598b = new Object();
    }

    @Override // com.umeng.analytics.filter.EventList
    protected void eventListChange() {
        if (TextUtils.isEmpty(this.mEventList)) {
            return;
        }
        synchronized (this.f20598b) {
            this.f20597a = null;
            this.f20597a = new d(true, this.mEventList);
        }
    }

    @Override // com.umeng.analytics.filter.EventList
    public boolean matchHit(String str) {
        boolean zA;
        if (TextUtils.isEmpty(this.mEventList)) {
            return true;
        }
        synchronized (this.f20598b) {
            if (this.f20597a == null) {
                this.f20597a = new d(true, this.mEventList);
            }
            zA = this.f20597a.a(str);
        }
        return zA;
    }

    @Override // com.umeng.analytics.filter.EventList
    public void setMD5ClearFlag(boolean z) {
        AnalyticsConfig.CLEAR_EKV_WL = z;
    }
}
