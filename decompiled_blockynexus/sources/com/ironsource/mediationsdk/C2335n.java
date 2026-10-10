package com.ironsource.mediationsdk;

import android.text.TextUtils;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.utils.CappingManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: renamed from: com.ironsource.mediationsdk.n, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BannerUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class C2335n {

    /* JADX INFO: renamed from: com.ironsource.mediationsdk.n$a */
    /* JADX INFO: compiled from: BannerUtils.java */
    interface a {
        void a(Map<String, Object> map, List<String> list, StringBuilder sb);
    }

    /* JADX INFO: renamed from: com.ironsource.mediationsdk.n$b */
    /* JADX INFO: compiled from: BannerUtils.java */
    interface b {
        void a(String str);

        void success();
    }

    static boolean a(IronSourceBannerLayout ironSourceBannerLayout) {
        return (ironSourceBannerLayout == null || ironSourceBannerLayout.isDestroyed()) ? false : true;
    }

    static void a(IronSourceBannerLayout ironSourceBannerLayout, com.ironsource.mediationsdk.model.f fVar, b bVar) {
        String str;
        if (a(ironSourceBannerLayout)) {
            str = null;
        } else {
            Object[] objArr = new Object[1];
            objArr[0] = ironSourceBannerLayout == null ? "banner is null" : "banner is destroyed";
            str = String.format("can't load banner - %s", objArr);
        }
        if (fVar == null || TextUtils.isEmpty(fVar.c())) {
            Object[] objArr2 = new Object[1];
            objArr2[0] = fVar == null ? "placement is null" : "placement name is empty";
            str = String.format("can't load banner - %s", objArr2);
        }
        if (TextUtils.isEmpty(str)) {
            bVar.success();
        } else {
            IronLog.INTERNAL.error(str);
            bVar.a(str);
        }
    }

    static long a(long j, long j2) {
        return j2 - (new Date().getTime() - j);
    }

    static void a(String str, ConcurrentHashMap<String, ProgBannerSmash> concurrentHashMap, a aVar) {
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        if (!CappingManager.d(com.ironsource.mediationsdk.utils.c.c().b(), str)) {
            for (ProgBannerSmash progBannerSmash : concurrentHashMap.values()) {
                if (progBannerSmash.y()) {
                    Map<String, Object> mapZ = progBannerSmash.z();
                    if (mapZ != null) {
                        map.put(progBannerSmash.r(), mapZ);
                        sb.append("2" + progBannerSmash.r() + ",");
                    }
                } else if (!progBannerSmash.y()) {
                    arrayList.add(progBannerSmash.r());
                    sb.append("1" + progBannerSmash.r() + ",");
                }
            }
        }
        aVar.a(map, arrayList, sb);
    }
}
