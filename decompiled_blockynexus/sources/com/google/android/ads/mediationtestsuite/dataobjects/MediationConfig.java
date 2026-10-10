package com.google.android.ads.mediationtestsuite.dataobjects;

import com.google.gson.a.c;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MediationConfig {

    @c("ad_networks")
    private List<NetworkResponse> adNetworks;

    @c("mediation_group_name")
    private String mediationGroupName;

    public List<NetworkResponse> getAdNetworks() {
        return this.adNetworks;
    }

    public String getMediationGroupName() {
        return this.mediationGroupName;
    }
}
