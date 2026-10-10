package com.ironsource.mediationsdk;

import com.ironsource.mediationsdk.logger.IronSourceLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class AuctionHistory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<String, ArrayList<ISAuctionPerformance>> f14609a = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f14610b;

    public enum ISAuctionPerformance {
        ISAuctionPerformanceDidntAttemptToLoad,
        ISAuctionPerformanceFailedToLoad,
        ISAuctionPerformanceLoadedSuccessfully,
        ISAuctionPerformanceFailedToShow,
        ISAuctionPerformanceShowedSuccessfully,
        ISAuctionPerformanceNotPartOfWaterfall
    }

    public AuctionHistory(List<String> list, int i) {
        this.f14610b = i;
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            this.f14609a.put(it.next(), new ArrayList<>());
        }
    }

    public void a(ConcurrentHashMap<String, ISAuctionPerformance> concurrentHashMap) {
        if (this.f14610b == 0) {
            return;
        }
        for (String str : this.f14609a.keySet()) {
            ISAuctionPerformance iSAuctionPerformance = ISAuctionPerformance.ISAuctionPerformanceNotPartOfWaterfall;
            if (concurrentHashMap.containsKey(str)) {
                iSAuctionPerformance = concurrentHashMap.get(str);
            }
            ArrayList<ISAuctionPerformance> arrayList = this.f14609a.get(str);
            if (this.f14610b != -1 && arrayList.size() == this.f14610b) {
                arrayList.remove(0);
            }
            arrayList.add(iSAuctionPerformance);
        }
    }

    public String a(String str) {
        ArrayList<ISAuctionPerformance> arrayList = this.f14609a.get(str);
        String str2 = "";
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<ISAuctionPerformance> it = arrayList.iterator();
            str2 = "" + it.next().ordinal();
            while (it.hasNext()) {
                str2 = (str2 + ",") + it.next().ordinal();
            }
            com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.INTERNAL, str + " stored performance: : " + str2, 1);
        }
        return str2;
    }
}
