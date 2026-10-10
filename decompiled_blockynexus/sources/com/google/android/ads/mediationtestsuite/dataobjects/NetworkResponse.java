package com.google.android.ads.mediationtestsuite.dataobjects;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class NetworkResponse {
    private List<String> adapters;
    private Map<String, String> data;

    public List<String> getAdapters() {
        return this.adapters;
    }

    public String getClassName() {
        List<String> list = this.adapters;
        if (list == null || list.size() == 0) {
            return null;
        }
        return this.adapters.get(0);
    }

    public Map<String, String> getData() {
        return this.data;
    }

    public boolean hasValidMediationAdapter() {
        String className = getClassName();
        if (className == null) {
            return false;
        }
        return this.data != null || className.equals(AdUnit.GOOGLE_ADAPTER_CLASS);
    }

    public boolean isCustomEventAdapter() {
        return getClassName() != null && getClassName().equals(AdUnit.CUSTOM_EVENT_ADAPTER_CLASS);
    }

    public void setAdapters(List<String> list) {
        this.adapters = list;
    }

    public void setData(Map<String, String> map) {
        this.data = map;
    }
}
