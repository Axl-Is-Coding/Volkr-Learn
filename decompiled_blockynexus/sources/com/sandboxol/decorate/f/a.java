package com.sandboxol.decorate.f;

import com.sandboxol.center.router.moduleInfo.decorate.SingleDressInfo;
import java.util.Comparator;

/* JADX INFO: compiled from: DressAllComparator.java */
/* JADX INFO: loaded from: classes3.dex */
public class a implements Comparator<SingleDressInfo> {
    private int a(int i) {
        if (i == 0) {
            return 16;
        }
        if (i == 2) {
            return 10;
        }
        if (i == 31) {
            return 15;
        }
        switch (i) {
            case 4:
                return 9;
            case 5:
                return 3;
            case 6:
                return 2;
            case 7:
                return 1;
            case 8:
                return 13;
            case 9:
                return 12;
            case 10:
                return 11;
            case 11:
                return 7;
            case 12:
                return 8;
            case 13:
                return 6;
            case 14:
                return 5;
            case 15:
                return 4;
            case 16:
                return 14;
            default:
                return 0;
        }
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(SingleDressInfo singleDressInfo, SingleDressInfo singleDressInfo2) {
        if (a((int) singleDressInfo.getTypeId()) > a((int) singleDressInfo2.getTypeId())) {
            return -1;
        }
        return (a((int) singleDressInfo.getTypeId()) != a((int) singleDressInfo2.getTypeId()) || singleDressInfo.getId() <= singleDressInfo2.getId()) ? 1 : -1;
    }
}
