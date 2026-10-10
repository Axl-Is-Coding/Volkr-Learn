package com.sandboxol.decorate.f;

import com.sandboxol.center.router.moduleInfo.decorate.SingleDressInfo;
import java.util.Comparator;

/* JADX INFO: compiled from: DressPriceComparator.java */
/* JADX INFO: loaded from: classes3.dex */
public class d implements Comparator<SingleDressInfo> {
    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(SingleDressInfo singleDressInfo, SingleDressInfo singleDressInfo2) {
        if (singleDressInfo.getHasPurchase() < singleDressInfo2.getHasPurchase()) {
            return -1;
        }
        if (singleDressInfo.getHasPurchase() == singleDressInfo2.getHasPurchase()) {
            if (singleDressInfo.getCurrency() < singleDressInfo2.getCurrency()) {
                return -1;
            }
            if (singleDressInfo.getCurrency() == singleDressInfo2.getCurrency()) {
                if (singleDressInfo.getPrice() < singleDressInfo2.getPrice()) {
                    return -1;
                }
                if (singleDressInfo.getPrice() == singleDressInfo2.getPrice() && singleDressInfo.getId() > singleDressInfo2.getId()) {
                    return -1;
                }
            }
        }
        return 1;
    }
}
