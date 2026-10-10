package com.sandboxol.decorate.f;

import com.sandboxol.center.router.moduleInfo.decorate.SuitDressInfo;
import java.util.Comparator;

/* JADX INFO: compiled from: DressSuitPriceComparator.java */
/* JADX INFO: loaded from: classes3.dex */
public class f implements Comparator<SuitDressInfo> {
    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(SuitDressInfo suitDressInfo, SuitDressInfo suitDressInfo2) {
        if (suitDressInfo.getHasPurchase() < suitDressInfo2.getHasPurchase()) {
            return -1;
        }
        if (suitDressInfo.getHasPurchase() == suitDressInfo2.getHasPurchase()) {
            if (suitDressInfo.getCurrency() < suitDressInfo2.getCurrency()) {
                return -1;
            }
            if (suitDressInfo.getCurrency() == suitDressInfo2.getCurrency()) {
                if (suitDressInfo.getLimitedTimes() != null && suitDressInfo.getLimitedTimes().size() > 0 && suitDressInfo2.getLimitedTimes() != null && suitDressInfo2.getLimitedTimes().size() > 0) {
                    if (suitDressInfo.getLimitedTimes().get(0).getPrice() < suitDressInfo2.getLimitedTimes().get(0).getPrice()) {
                        return -1;
                    }
                    return (suitDressInfo.getLimitedTimes().get(0).getPrice() != suitDressInfo2.getLimitedTimes().get(0).getPrice() || suitDressInfo.getSuitId() <= suitDressInfo2.getSuitId()) ? 1 : -1;
                }
                if (suitDressInfo.getSuitId() > suitDressInfo2.getSuitId()) {
                    return -1;
                }
            }
        }
        return 1;
    }
}
