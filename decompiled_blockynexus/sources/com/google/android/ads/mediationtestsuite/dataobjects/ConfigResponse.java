package com.google.android.ads.mediationtestsuite.dataobjects;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ConfigResponse {
    private final List<AdUnit> adUnits;
    private final List<Network> networks;

    public ConfigResponse(List<AdUnit> list, List<Network> list2) {
        this.adUnits = list;
        this.networks = list2;
    }

    public List<AdUnit> getAdUnits() {
        return this.adUnits;
    }

    public List<Network> getNetworks() {
        return this.networks;
    }
}
