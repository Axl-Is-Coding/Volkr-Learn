package com.sandboxol.decorate.f;

import com.sandboxol.center.router.moduleInfo.decorate.SingleDressInfo;
import com.sandboxol.center.router.moduleInfo.decorate.SuitDressInfo;
import com.sandboxol.decorate.entity.ShopRecommendDecorationInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: DressCompat.java */
/* JADX INFO: loaded from: classes3.dex */
public class b {
    public static void a(List<SingleDressInfo> list) {
        int i;
        if (list == null || list.size() == 0) {
            return;
        }
        int size = list.size() % 4;
        if (size != 0) {
            i = 4 - size;
        } else if (list.size() < 4) {
            size = list.size();
            i = 4 - size;
        } else {
            i = 0;
        }
        for (int i2 = 0; i2 < i; i2++) {
            SingleDressInfo singleDressInfo = new SingleDressInfo();
            singleDressInfo.setId(-3L);
            list.add(singleDressInfo);
        }
    }

    public static void b(List<SuitDressInfo> list) {
        int i;
        if (list == null || list.size() == 0) {
            return;
        }
        int size = list.size() % 4;
        if (size != 0) {
            i = 4 - size;
        } else if (list.size() < 4) {
            size = list.size();
            i = 4 - size;
        } else {
            i = 0;
        }
        for (int i2 = 0; i2 < i; i2++) {
            SuitDressInfo suitDressInfo = new SuitDressInfo();
            suitDressInfo.setSuitId(-3L);
            list.add(suitDressInfo);
        }
    }

    public static void c(List<SingleDressInfo> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        int size = list.size();
        while (true) {
            size--;
            if (size < list.size() - 4) {
                return;
            } else {
                list.get(size).setBlankType(3);
            }
        }
    }

    public static void d(List<SuitDressInfo> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        int size = list.size();
        while (true) {
            size--;
            if (size < list.size() - 4) {
                return;
            } else {
                list.get(size).setBlankType(3);
            }
        }
    }

    public static List<SingleDressInfo> e(List<ShopRecommendDecorationInfo> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<ShopRecommendDecorationInfo> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(a(it.next().getShopDecorationInfo()));
        }
        SingleDressInfo singleDressInfo = new SingleDressInfo();
        singleDressInfo.setId(-1L);
        singleDressInfo.setItemType(1);
        arrayList.add(singleDressInfo);
        g(arrayList);
        return arrayList;
    }

    public static List<SuitDressInfo> f(List<ShopRecommendDecorationInfo> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<ShopRecommendDecorationInfo> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(a(it.next().getShopSuitDecorationInfo()));
        }
        SuitDressInfo suitDressInfo = new SuitDressInfo();
        suitDressInfo.setSuitId(-1L);
        suitDressInfo.setItemType(1);
        arrayList.add(suitDressInfo);
        h(arrayList);
        return arrayList;
    }

    private static void g(List<SingleDressInfo> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        int i = 0;
        while (i < list.size()) {
            SingleDressInfo singleDressInfo = list.get(i);
            if (i == 0) {
                singleDressInfo.setItemType(3);
            }
            if (i > 0 && i < 4) {
                singleDressInfo.setItemType(2);
            }
            i++;
            int i2 = i % 4;
            if (i2 == 0) {
                singleDressInfo.setBlankType(2);
            } else if (i2 == 1) {
                singleDressInfo.setBlankType(1);
            }
        }
    }

    private static void h(List<SuitDressInfo> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        int i = 0;
        while (i < list.size()) {
            SuitDressInfo suitDressInfo = list.get(i);
            if (i == 0) {
                suitDressInfo.setItemType(3);
            }
            if (i > 0 && i < 4) {
                suitDressInfo.setItemType(2);
            }
            i++;
            int i2 = i % 4;
            if (i2 == 0) {
                suitDressInfo.setBlankType(2);
            } else if (i2 == 1) {
                suitDressInfo.setBlankType(1);
            }
        }
    }

    public static SingleDressInfo a(SingleDressInfo singleDressInfo) {
        SingleDressInfo singleDressInfo2 = new SingleDressInfo();
        singleDressInfo2.setDetails(singleDressInfo.getDetails());
        singleDressInfo2.setId(singleDressInfo.getId());
        singleDressInfo2.setTypeId(singleDressInfo.getTypeId());
        singleDressInfo2.setName(singleDressInfo.getName());
        singleDressInfo2.setIconUrl(singleDressInfo.getIconUrl());
        singleDressInfo2.setSex(singleDressInfo.getSex());
        singleDressInfo2.setTag(singleDressInfo.getTag());
        singleDressInfo2.setResourceId(singleDressInfo.getResourceId());
        singleDressInfo2.setExpire(singleDressInfo.getExpire());
        singleDressInfo2.setPrice(singleDressInfo.getPrice());
        singleDressInfo2.setCurrency(singleDressInfo.getCurrency());
        singleDressInfo2.setOccupyPosition(singleDressInfo.getOccupyPosition());
        singleDressInfo2.setIsNew(singleDressInfo.getIsNew());
        singleDressInfo2.setIsRecommend(singleDressInfo.getIsRecommend());
        singleDressInfo2.setSuitPrice(singleDressInfo.getSuitPrice());
        singleDressInfo2.setSuitId(singleDressInfo.getSuitId());
        singleDressInfo2.setIsActivity(singleDressInfo.getIsActivity());
        singleDressInfo2.setActivityFlag(singleDressInfo.getActivityFlag());
        singleDressInfo2.setItemType(1);
        singleDressInfo2.setDressRec(true);
        return singleDressInfo2;
    }

    public static SuitDressInfo a(SuitDressInfo suitDressInfo) {
        SuitDressInfo suitDressInfo2 = new SuitDressInfo();
        suitDressInfo2.setDecorationInfoList(new ArrayList());
        Iterator<SingleDressInfo> it = suitDressInfo.getShopDecorationInfos().iterator();
        while (it.hasNext()) {
            suitDressInfo2.getDecorationInfoList().add(a(it.next()));
        }
        suitDressInfo2.setDetails(suitDressInfo.getDetails());
        suitDressInfo2.setIconUrl(suitDressInfo.getIconUrl());
        suitDressInfo2.setIsNew(suitDressInfo.getIsNew());
        suitDressInfo2.setIsRecommend(suitDressInfo.getIsRecommend());
        suitDressInfo2.setCurrency(suitDressInfo.getCurrency());
        suitDressInfo2.setLimitedTimes(suitDressInfo.getLimitedTimes());
        suitDressInfo2.setIsActivity(suitDressInfo.getIsActivity());
        suitDressInfo2.setActivityFlag(suitDressInfo.getActivityFlag());
        suitDressInfo2.setName(suitDressInfo.getName());
        suitDressInfo2.setStatus(suitDressInfo.getStatus());
        suitDressInfo2.setSuitId(suitDressInfo.getSuitId());
        suitDressInfo2.setItemType(1);
        suitDressInfo2.setDressRec(true);
        return suitDressInfo2;
    }
}
