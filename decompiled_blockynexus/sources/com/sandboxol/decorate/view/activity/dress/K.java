package com.sandboxol.decorate.view.activity.dress;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.router.moduleInfo.decorate.LimitedTimes;
import com.sandboxol.center.router.moduleInfo.decorate.SingleDressInfo;
import com.sandboxol.center.router.moduleInfo.decorate.SuitDressInfo;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.FirebaseUtils;
import com.sandboxol.decorate.R;
import com.sandboxol.decorate.entity.ShopRecommendDecorationInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import rx.Observable;
import rx.functions.Action1;

/* JADX INFO: compiled from: DressShopModel.java */
/* JADX INFO: loaded from: classes3.dex */
public class K {
    public void a(ObservableField<Long> observableField, ObservableField<Long> observableField2) {
        int price;
        int price2;
        ArrayList arrayList = new ArrayList();
        long suitPrice = 0;
        long suitPrice2 = 0;
        for (ShopRecommendDecorationInfo shopRecommendDecorationInfo : com.sandboxol.decorate.manager.v.b().f17217f.values()) {
            SingleDressInfo shopDecorationInfo = shopRecommendDecorationInfo.getShopDecorationInfo();
            SuitDressInfo shopSuitDecorationInfo = shopRecommendDecorationInfo.getShopSuitDecorationInfo();
            if (shopDecorationInfo != null) {
                if (shopDecorationInfo.getIsActivity() == 1) {
                    return;
                }
                if (shopDecorationInfo.getQuantity() != -1 && shopDecorationInfo.getHasPurchase() == 0) {
                    if (shopDecorationInfo.getSuitId() == 0) {
                        List<LimitedTimes> limitedTimes = shopDecorationInfo.getLimitedTimes();
                        if (limitedTimes != null && !limitedTimes.isEmpty()) {
                            Collections.sort(limitedTimes, new Comparator() { // from class: com.sandboxol.decorate.view.activity.dress.h
                                @Override // java.util.Comparator
                                public final int compare(Object obj, Object obj2) {
                                    return K.a((LimitedTimes) obj, (LimitedTimes) obj2);
                                }
                            });
                            if (shopDecorationInfo.getCurrency() == 1 || shopDecorationInfo.getCurrency() == 0) {
                                price = limitedTimes.get(limitedTimes.size() - 1).getPrice();
                                suitPrice2 += (long) price;
                            } else {
                                price2 = limitedTimes.get(limitedTimes.size() - 1).getPrice();
                                suitPrice += (long) price2;
                            }
                        } else if (shopDecorationInfo.getCurrency() == 1 || shopDecorationInfo.getCurrency() == 0) {
                            price = shopDecorationInfo.getPrice();
                            suitPrice2 += (long) price;
                        } else {
                            price2 = shopDecorationInfo.getPrice();
                            suitPrice += (long) price2;
                        }
                    } else if (!arrayList.contains(Long.valueOf(shopDecorationInfo.getSuitId()))) {
                        if (shopDecorationInfo.getCurrency() == 1 || shopDecorationInfo.getCurrency() == 0) {
                            suitPrice2 += shopDecorationInfo.getSuitPrice();
                        } else {
                            suitPrice += shopDecorationInfo.getSuitPrice();
                        }
                        arrayList.add(Long.valueOf(shopDecorationInfo.getSuitId()));
                    }
                }
            } else if (shopSuitDecorationInfo == null) {
                continue;
            } else {
                if (shopSuitDecorationInfo.getIsActivity() == 1) {
                    return;
                }
                for (SingleDressInfo singleDressInfo : shopSuitDecorationInfo.getShopDecorationInfos()) {
                    if (singleDressInfo.getQuantity() != -1 && singleDressInfo.getHasPurchase() == 0) {
                        if (singleDressInfo.getCurrency() == 1 || singleDressInfo.getCurrency() == 0) {
                            suitPrice2 += (long) singleDressInfo.getPrice();
                        } else {
                            suitPrice += (long) singleDressInfo.getPrice();
                        }
                    }
                }
            }
        }
        observableField.set(Long.valueOf(suitPrice));
        observableField2.set(Long.valueOf(suitPrice2));
    }

    static /* synthetic */ int a(LimitedTimes limitedTimes, LimitedTimes limitedTimes2) {
        return limitedTimes.getPrice() - limitedTimes2.getPrice();
    }

    public void a(Context context, Map<Long, ShopRecommendDecorationInfo> map) {
        ArrayList arrayList = new ArrayList(map.values());
        final ArrayList arrayList2 = new ArrayList();
        final ArrayList arrayList3 = new ArrayList();
        Observable.from(arrayList).subscribe(new Action1() { // from class: com.sandboxol.decorate.view.activity.dress.i
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                K.a(arrayList3, arrayList2, (ShopRecommendDecorationInfo) obj);
            }
        });
        if (arrayList3.isEmpty()) {
            if (arrayList2.isEmpty()) {
                AppToastUtils.showShortNegativeTipToast(context, R.string.decorate_new_dress_not_select_good);
            } else {
                new com.sandboxol.decorate.view.dialog.a.E(context, arrayList2).show();
            }
        } else {
            com.sandboxol.decorate.web.w.a(context, arrayList3, new J(this, arrayList2, context));
        }
        ReportDataAdapter.onEvent(context, EventConstant.CLICK_CART);
        FirebaseUtils.onEvent(context, EventConstant.CLICK_CART);
    }

    static /* synthetic */ void a(ArrayList arrayList, List list, ShopRecommendDecorationInfo shopRecommendDecorationInfo) {
        SingleDressInfo shopDecorationInfo = shopRecommendDecorationInfo.getShopDecorationInfo();
        if (shopDecorationInfo == null || shopDecorationInfo.getHasPurchase() != 0) {
            return;
        }
        if (shopDecorationInfo.getSuitId() != 0) {
            if (arrayList.contains(Long.valueOf(shopDecorationInfo.getSuitId()))) {
                return;
            }
            arrayList.add(Long.valueOf(shopDecorationInfo.getSuitId()));
            return;
        }
        list.add(new ShopRecommendDecorationInfo(shopDecorationInfo));
    }
}
