package com.sandboxol.center.router.moduleInfo.pay;

import androidx.databinding.BaseObservable;
import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public class PmInfo extends BaseObservable implements Serializable {
    private String currency;
    private boolean isFirst;
    private String name;
    private String pmId;
    private String url;

    public String getCurrency() {
        return this.currency;
    }

    public String getName() {
        return this.name;
    }

    public String getPmId() {
        return this.pmId;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isFirst() {
        return this.isFirst;
    }

    public void notifyData(PmInfo pmInfo) {
        setPmId(pmInfo.getPmId());
        setUrl(pmInfo.getUrl());
        setCurrency(pmInfo.getCurrency());
        setName(pmInfo.getName());
        notifyChange();
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setFirst(boolean z) {
        this.isFirst = z;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPmId(String str) {
        this.pmId = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
