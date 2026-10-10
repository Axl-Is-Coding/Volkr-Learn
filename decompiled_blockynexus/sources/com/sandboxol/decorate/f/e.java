package com.sandboxol.decorate.f;

import com.sandboxol.center.router.moduleInfo.decorate.SuitDressInfo;
import java.util.Comparator;

/* JADX INFO: compiled from: DressSuitDefaultComparator.java */
/* JADX INFO: loaded from: classes3.dex */
public class e implements Comparator<SuitDressInfo> {
    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(SuitDressInfo suitDressInfo, SuitDressInfo suitDressInfo2) {
        if (suitDressInfo.getHasPurchase() < suitDressInfo2.getHasPurchase()) {
            return -1;
        }
        if (suitDressInfo.getHasPurchase() == suitDressInfo2.getHasPurchase()) {
            if (suitDressInfo.getIsRecommend() > suitDressInfo2.getIsRecommend()) {
                return -1;
            }
            if (suitDressInfo.getIsRecommend() == suitDressInfo2.getIsRecommend()) {
                if (suitDressInfo.getIsNew() > suitDressInfo2.getIsNew()) {
                    return -1;
                }
                if (suitDressInfo.getIsNew() == suitDressInfo2.getIsNew() && suitDressInfo.getSuitId() > suitDressInfo2.getSuitId()) {
                    return -1;
                }
            }
        }
        return 1;
    }
}
