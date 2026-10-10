package com.tencent.map.geolocation;

import android.os.Bundle;
import android.text.TextUtils;
import c.t.m.g.Fb;

/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes5.dex */
public final class TencentLocationRequest {
    public static final int REQUEST_LEVEL_ADMIN_AREA = 3;
    public static final int REQUEST_LEVEL_GEO = 0;
    public static final int REQUEST_LEVEL_NAME = 1;
    public static final int REQUEST_LEVEL_POI = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f19404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f19405b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f19406c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f19407d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f19408e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f19409f;
    private long g;
    private int h;
    private String i;
    private String j;
    private Bundle k;

    private TencentLocationRequest() {
    }

    public static void copy(TencentLocationRequest tencentLocationRequest, TencentLocationRequest tencentLocationRequest2) {
        tencentLocationRequest.f19404a = tencentLocationRequest2.f19404a;
        tencentLocationRequest.f19405b = tencentLocationRequest2.f19405b;
        tencentLocationRequest.f19407d = tencentLocationRequest2.f19407d;
        tencentLocationRequest.f19408e = tencentLocationRequest2.f19408e;
        tencentLocationRequest.g = tencentLocationRequest2.g;
        tencentLocationRequest.h = tencentLocationRequest2.h;
        tencentLocationRequest.f19409f = tencentLocationRequest2.f19409f;
        tencentLocationRequest.f19406c = tencentLocationRequest2.f19406c;
        tencentLocationRequest.j = tencentLocationRequest2.j;
        tencentLocationRequest.i = tencentLocationRequest2.i;
        tencentLocationRequest.k.clear();
        tencentLocationRequest.k.putAll(tencentLocationRequest2.k);
    }

    public static TencentLocationRequest create() {
        TencentLocationRequest tencentLocationRequest = new TencentLocationRequest();
        tencentLocationRequest.f19404a = 10000L;
        tencentLocationRequest.f19405b = 1;
        tencentLocationRequest.f19407d = true;
        tencentLocationRequest.f19408e = false;
        tencentLocationRequest.f19409f = false;
        tencentLocationRequest.g = Long.MAX_VALUE;
        tencentLocationRequest.h = Integer.MAX_VALUE;
        tencentLocationRequest.f19406c = true;
        tencentLocationRequest.j = "";
        tencentLocationRequest.i = "";
        tencentLocationRequest.k = new Bundle();
        return tencentLocationRequest;
    }

    public final Bundle getExtras() {
        return this.k;
    }

    public final long getInterval() {
        return this.f19404a;
    }

    public final String getPhoneNumber() {
        String string = this.k.getString("phoneNumber");
        return string == null ? "" : string;
    }

    public final String getQQ() {
        return this.j;
    }

    public final int getRequestLevel() {
        return this.f19405b;
    }

    public final String getSmallAppKey() {
        return this.i;
    }

    public final boolean isAllowCache() {
        return this.f19407d;
    }

    public final boolean isAllowDirection() {
        return this.f19408e;
    }

    public final boolean isAllowGPS() {
        return this.f19406c;
    }

    public final boolean isIndoorLocationMode() {
        return this.f19409f;
    }

    public final TencentLocationRequest setAllowCache(boolean z) {
        this.f19407d = z;
        return this;
    }

    public final TencentLocationRequest setAllowDirection(boolean z) {
        this.f19408e = z;
        return this;
    }

    public final TencentLocationRequest setAllowGPS(boolean z) {
        this.f19406c = z;
        return this;
    }

    public final TencentLocationRequest setIndoorLocationMode(boolean z) {
        this.f19409f = z;
        return this;
    }

    public final TencentLocationRequest setInterval(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("interval should >= 0");
        }
        this.f19404a = j;
        return this;
    }

    public final TencentLocationRequest setPhoneNumber(String str) {
        if (str == null) {
            str = "";
        }
        this.k.putString("phoneNumber", str);
        return this;
    }

    public final TencentLocationRequest setQQ(String str) {
        this.j = str;
        return this;
    }

    public final TencentLocationRequest setRequestLevel(int i) {
        if (Fb.a(i)) {
            this.f19405b = i;
            return this;
        }
        throw new IllegalArgumentException("request_level: " + i + " not supported!");
    }

    public final TencentLocationRequest setSmallAppKey(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.i = str;
        }
        return this;
    }

    public final String toString() {
        return "TencentLocationRequest {interval=" + this.f19404a + "ms,level=" + this.f19405b + ",allowCache=" + this.f19407d + ",allowGps=" + this.f19406c + ",allowDirection=" + this.f19408e + ",isIndoorMode=" + this.f19409f + ",QQ=" + this.j + "}";
    }

    public TencentLocationRequest(TencentLocationRequest tencentLocationRequest) {
        this.f19404a = tencentLocationRequest.f19404a;
        this.f19405b = tencentLocationRequest.f19405b;
        this.f19407d = tencentLocationRequest.f19407d;
        this.f19408e = tencentLocationRequest.f19408e;
        this.g = tencentLocationRequest.g;
        this.h = tencentLocationRequest.h;
        this.f19406c = tencentLocationRequest.f19406c;
        this.f19409f = tencentLocationRequest.f19409f;
        this.j = tencentLocationRequest.j;
        this.i = tencentLocationRequest.i;
        this.k = new Bundle();
        this.k.putAll(tencentLocationRequest.k);
    }
}
