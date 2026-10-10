package com.sandboxol.decorate.f;

import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.router.manager.DressManager;
import com.sandboxol.center.router.moduleInfo.decorate.SingleDressInfo;
import com.sandboxol.decorate.manager.q;

/* JADX INFO: compiled from: ResLib.java */
/* JADX INFO: loaded from: classes3.dex */
public class j {
    public static String a(long j) {
        switch ((int) j) {
            case 2:
                return StringConstant.CUSTOM_HAIR_1;
            case 3:
            default:
                return "";
            case 4:
                return StringConstant.CUSTOM_FACE_1;
            case 5:
                return StringConstant.CUSTOM_ACTION_0;
            case 6:
                return StringConstant.CUSTOM_SKIN_0;
            case 7:
                return StringConstant.CUSTOM_BG_0;
            case 8:
                return StringConstant.CLOTHES_TOPS_1;
            case 9:
                return StringConstant.CLOTHES_PANTS_1;
            case 10:
                return StringConstant.CUSTOM_SHOES_1;
            case 11:
                return StringConstant.CUSTOM_HAT_0;
            case 12:
                return StringConstant.CUSTOM_GLASSES_0;
            case 13:
                return StringConstant.CUSTOM_SCARF_0;
            case 14:
                return StringConstant.CUSTOM_WING_0;
            case 15:
                return StringConstant.CUSTOM_CROWN_0;
            case 16:
                return StringConstant.CUSTOM_SUITS_0;
        }
    }

    public static void a(SingleDressInfo singleDressInfo) {
        if (singleDressInfo == null || singleDressInfo.getResourceId() == null) {
            return;
        }
        if (singleDressInfo.getTypeId() == 6) {
            q.a(singleDressInfo.getResourceId(), true);
        }
        b(singleDressInfo);
    }

    public static String b(long j) {
        int i = (int) j;
        if (i == 2) {
            return StringConstant.CUSTOM_HAIR_0;
        }
        if (i == 4) {
            return StringConstant.CUSTOM_FACE_0;
        }
        switch (i) {
            case 8:
                return StringConstant.CLOTHES_TOPS_0;
            case 9:
                return StringConstant.CLOTHES_PANTS_0;
            case 10:
                return StringConstant.CUSTOM_SHOES_0;
            default:
                return a(j);
        }
    }

    private static void b(SingleDressInfo singleDressInfo) {
        long typeId = singleDressInfo.getTypeId();
        if (typeId == 5) {
            String strC = q.c(singleDressInfo.getResourceId());
            if (strC != null) {
                DressManager.checkRes(2, strC, "");
                return;
            }
            return;
        }
        if (typeId == 7) {
            String strD = q.d(singleDressInfo.getResourceId());
            if (strD != null) {
                DressManager.checkRes(3, strD, "");
                return;
            }
            return;
        }
        String[] strArrE = q.e(singleDressInfo.getResourceId());
        if (strArrE == null || strArrE.length != 2) {
            return;
        }
        DressManager.checkRes(1, strArrE[0], strArrE[1]);
    }
}
