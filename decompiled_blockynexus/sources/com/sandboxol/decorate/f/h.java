package com.sandboxol.decorate.f;

import com.sandboxol.center.router.moduleInfo.decorate.SingleDressInfo;
import java.util.Comparator;

/* JADX INFO: compiled from: DressTimeComparator.java */
/* JADX INFO: loaded from: classes3.dex */
public class h implements Comparator<SingleDressInfo> {
    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(SingleDressInfo singleDressInfo, SingleDressInfo singleDressInfo2) {
        if (singleDressInfo.getHasPurchase() < singleDressInfo2.getHasPurchase()) {
            return -1;
        }
        if (singleDressInfo.getHasPurchase() == singleDressInfo2.getHasPurchase()) {
            if (singleDressInfo.getReleaseTime() > singleDressInfo2.getReleaseTime()) {
                return -1;
            }
            if (singleDressInfo.getReleaseTime() == singleDressInfo2.getReleaseTime() && singleDressInfo.getId() > singleDressInfo2.getId()) {
                return -1;
            }
        }
        return 1;
    }
}
