package com.sandboxol.decorate.f;

import com.sandboxol.center.router.moduleInfo.decorate.SingleDressInfo;
import java.util.Comparator;

/* JADX INFO: compiled from: DressDefaultComparator.java */
/* JADX INFO: loaded from: classes3.dex */
public class c implements Comparator<SingleDressInfo> {
    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(SingleDressInfo singleDressInfo, SingleDressInfo singleDressInfo2) {
        if (singleDressInfo.getHasPurchase() < singleDressInfo2.getHasPurchase()) {
            return -1;
        }
        if (singleDressInfo.getHasPurchase() == singleDressInfo2.getHasPurchase()) {
            if (singleDressInfo.getIsRecommend() > singleDressInfo2.getIsRecommend()) {
                return -1;
            }
            if (singleDressInfo.getIsRecommend() == singleDressInfo2.getIsRecommend()) {
                if (singleDressInfo.getIsNew() > singleDressInfo2.getIsNew()) {
                    return -1;
                }
                if (singleDressInfo.getIsNew() == singleDressInfo2.getIsNew()) {
                    if (singleDressInfo.getSuitId() > singleDressInfo2.getSuitId()) {
                        return -1;
                    }
                    if (singleDressInfo.getSuitId() == singleDressInfo2.getSuitId() && singleDressInfo.getId() > singleDressInfo2.getId()) {
                        return -1;
                    }
                }
            }
        }
        return 1;
    }
}
