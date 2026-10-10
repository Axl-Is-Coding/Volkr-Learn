package com.sandboxol.center.router.moduleInfo.decorate;

import androidx.databinding.BaseObservable;
import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public class LimitedTimes extends BaseObservable implements Serializable {
    private int day;
    private int price;

    public int getDay() {
        return this.day;
    }

    public int getPrice() {
        return this.price;
    }

    public void setDay(int i) {
        this.day = i;
    }

    public void setPrice(int i) {
        this.price = i;
    }
}
