package com.google.android.ads.mediationtestsuite.dataobjects;

import com.google.gson.a.c;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CLDResponse {

    @c("ad_unit_settings")
    private List<AdUnitResponse> adUnitSettings;

    public List<AdUnitResponse> getAdUnitSettings() {
        return this.adUnitSettings;
    }

    public void setAdUnitSettings(List<AdUnitResponse> list) {
        this.adUnitSettings = list;
    }
}
