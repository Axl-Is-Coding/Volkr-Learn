package com.ironsource.mediationsdk.model;

import com.umeng.analytics.pro.au;

/* JADX INFO: loaded from: classes2.dex */
public enum PlacementCappingType {
    PER_DAY(au.au),
    PER_HOUR("h");

    public String value;

    PlacementCappingType(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }
}
