package com.umeng.analytics.filter;

import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;

/* JADX INFO: compiled from: EventBlackList.java */
/* JADX INFO: loaded from: classes5.dex */
public class a extends EventList {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d f20595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object f20596b;

    public a(String str, String str2) {
        super(str, str2);
        this.f20596b = new Object();
    }

    @Override // com.umeng.analytics.filter.EventList
    protected void eventListChange() {
        if (TextUtils.isEmpty(this.mEventList)) {
            return;
        }
        synchronized (this.f20596b) {
            this.f20595a = null;
            this.f20595a = new d(false, this.mEventList);
        }
    }

    @Override // com.umeng.analytics.filter.EventList
    public boolean matchHit(String str) {
        boolean zA;
        if (TextUtils.isEmpty(this.mEventList)) {
            return false;
        }
        synchronized (this.f20596b) {
            if (this.f20595a == null) {
                this.f20595a = new d(false, this.mEventList);
            }
            zA = this.f20595a.a(str);
        }
        return zA;
    }

    @Override // com.umeng.analytics.filter.EventList
    public void setMD5ClearFlag(boolean z) {
        AnalyticsConfig.CLEAR_EKV_BL = z;
    }
}
