package com.sandboxol.center.router.moduleInfo.pay;

import androidx.databinding.BaseObservable;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ThirdPayResponse extends BaseObservable implements Serializable {
    private String currency;
    private List<PmInfo> payChannel;
    private boolean show;

    public String getCurrency() {
        return this.currency;
    }

    public List<PmInfo> getPayChannel() {
        return this.payChannel;
    }

    public boolean isShow() {
        return this.show;
    }

    public void notifyData(ThirdPayResponse thirdPayResponse) {
        setShow(thirdPayResponse.isShow());
        setCurrency(thirdPayResponse.getCurrency());
        setPayChannel(thirdPayResponse.getPayChannel());
        notifyChange();
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setPayChannel(List<PmInfo> list) {
        this.payChannel = list;
    }

    public void setShow(boolean z) {
        this.show = z;
    }
}
