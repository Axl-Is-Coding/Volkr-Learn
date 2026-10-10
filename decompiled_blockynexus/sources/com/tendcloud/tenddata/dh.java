package com.tendcloud.tenddata;

import com.tencent.map.geolocation.TencentLocationListener;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public enum dh {
    WIFI(TencentLocationListener.WIFI),
    CELLULAR("cellular"),
    BLUETOOTH("bluetooth");


    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f20008d;

    dh(String str) {
        this.f20008d = str;
    }

    public String a() {
        return this.f20008d;
    }
}
