package com.ironsource.mediationsdk.utils;

import android.content.Context;
import android.text.TextUtils;
import com.ironsource.mediationsdk.model.PlacementCappingType;
import java.util.Calendar;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes2.dex */
public class CappingManager {

    public enum ECappingStatus {
        CAPPED_PER_DELIVERY,
        CAPPED_PER_COUNT,
        CAPPED_PER_PACE,
        NOT_CAPPED
    }

    public static synchronized void a(Context context, com.ironsource.mediationsdk.model.i iVar) {
        if (context == null || iVar == null) {
            return;
        }
        com.ironsource.mediationsdk.model.n nVarA = iVar.a();
        if (nVarA == null) {
            return;
        }
        a(context, "Interstitial", iVar.c(), nVarA);
    }

    public static synchronized void b(Context context, com.ironsource.mediationsdk.model.i iVar) {
        if (iVar != null) {
            a(context, "Interstitial", iVar.c());
        }
    }

    public static synchronized ECappingStatus c(Context context, com.ironsource.mediationsdk.model.i iVar) {
        if (context != null && iVar != null) {
            if (iVar.a() != null) {
                return b(context, "Interstitial", iVar.c());
            }
        }
        return ECappingStatus.NOT_CAPPED;
    }

    public static synchronized boolean d(Context context, String str) {
        return b(context, "Banner", str) != ECappingStatus.NOT_CAPPED;
    }

    public static synchronized boolean e(Context context, String str) {
        return b(context, "Interstitial", str) != ECappingStatus.NOT_CAPPED;
    }

    public static synchronized boolean f(Context context, String str) {
        return b(context, "Rewarded Video", str) != ECappingStatus.NOT_CAPPED;
    }

    public static synchronized void b(Context context, String str) {
        a(context, "Interstitial", str);
    }

    public static synchronized ECappingStatus c(Context context, com.ironsource.mediationsdk.model.l lVar) {
        if (context != null && lVar != null) {
            if (lVar.a() != null) {
                return b(context, "Rewarded Video", lVar.c());
            }
        }
        return ECappingStatus.NOT_CAPPED;
    }

    public static synchronized void b(Context context, com.ironsource.mediationsdk.model.l lVar) {
        if (lVar != null) {
            a(context, "Rewarded Video", lVar.c());
        }
    }

    public static synchronized void a(Context context, com.ironsource.mediationsdk.model.l lVar) {
        if (context == null || lVar == null) {
            return;
        }
        com.ironsource.mediationsdk.model.n nVarA = lVar.a();
        if (nVarA == null) {
            return;
        }
        a(context, "Rewarded Video", lVar.c(), nVarA);
    }

    private static ECappingStatus b(Context context, String str, String str2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!j.a(context, a(str, "CappingManager.IS_DELIVERY_ENABLED", str2), true)) {
            return ECappingStatus.CAPPED_PER_DELIVERY;
        }
        if (j.a(context, a(str, "CappingManager.IS_PACING_ENABLED", str2), false)) {
            if (jCurrentTimeMillis - j.a(context, a(str, "CappingManager.TIME_OF_THE_PREVIOUS_SHOW", str2), 0L) < j.a(context, a(str, "CappingManager.SECONDS_BETWEEN_SHOWS", str2), 0) * 1000) {
                return ECappingStatus.CAPPED_PER_PACE;
            }
        }
        if (j.a(context, a(str, "CappingManager.IS_CAPPING_ENABLED", str2), false)) {
            int iA = j.a(context, a(str, "CappingManager.MAX_NUMBER_OF_SHOWS", str2), 0);
            String strA = a(str, "CappingManager.CURRENT_NUMBER_OF_SHOWS", str2);
            int iA2 = j.a(context, strA, 0);
            String strA2 = a(str, "CappingManager.CAPPING_TIME_THRESHOLD", str2);
            if (jCurrentTimeMillis >= j.a(context, strA2, 0L)) {
                j.b(context, strA, 0);
                j.b(context, strA2, 0L);
            } else if (iA2 >= iA) {
                return ECappingStatus.CAPPED_PER_COUNT;
            }
        }
        return ECappingStatus.NOT_CAPPED;
    }

    public static synchronized void c(Context context, String str) {
        a(context, "Rewarded Video", str);
    }

    public static synchronized void a(Context context, com.ironsource.mediationsdk.model.f fVar) {
        if (context == null || fVar == null) {
            return;
        }
        com.ironsource.mediationsdk.model.n nVarA = fVar.a();
        if (nVarA == null) {
            return;
        }
        a(context, "Banner", fVar.c(), nVarA);
    }

    public static synchronized void a(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            a(context, "Banner", str);
        }
    }

    private static String a(String str, String str2, String str3) {
        return str + "_" + str2 + "_" + str3;
    }

    private static void a(Context context, String str, String str2) {
        int i = 0;
        if (j.a(context, a(str, "CappingManager.IS_PACING_ENABLED", str2), false)) {
            j.b(context, a(str, "CappingManager.TIME_OF_THE_PREVIOUS_SHOW", str2), System.currentTimeMillis());
        }
        if (j.a(context, a(str, "CappingManager.IS_CAPPING_ENABLED", str2), false)) {
            j.a(context, a(str, "CappingManager.MAX_NUMBER_OF_SHOWS", str2), 0);
            String strA = a(str, "CappingManager.CURRENT_NUMBER_OF_SHOWS", str2);
            int iA = j.a(context, strA, 0);
            if (iA == 0) {
                String strC = j.c(context, a(str, "CappingManager.CAPPING_TYPE", str2), PlacementCappingType.PER_DAY.toString());
                PlacementCappingType placementCappingType = null;
                PlacementCappingType[] placementCappingTypeArrValues = PlacementCappingType.values();
                int length = placementCappingTypeArrValues.length;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    PlacementCappingType placementCappingType2 = placementCappingTypeArrValues[i];
                    if (placementCappingType2.value.equals(strC)) {
                        placementCappingType = placementCappingType2;
                        break;
                    }
                    i++;
                }
                j.b(context, a(str, "CappingManager.CAPPING_TIME_THRESHOLD", str2), a(placementCappingType));
            }
            j.b(context, strA, iA + 1);
        }
    }

    private static long a(PlacementCappingType placementCappingType) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        int i = b.f15019a[placementCappingType.ordinal()];
        if (i == 1) {
            calendar.set(14, 0);
            calendar.set(13, 0);
            calendar.set(12, 0);
            calendar.set(11, 0);
            calendar.add(6, 1);
        } else if (i == 2) {
            calendar.set(14, 0);
            calendar.set(13, 0);
            calendar.set(12, 0);
            calendar.add(11, 1);
        }
        return calendar.getTimeInMillis();
    }

    private static void a(Context context, String str, String str2, com.ironsource.mediationsdk.model.n nVar) {
        boolean zE = nVar.e();
        j.b(context, a(str, "CappingManager.IS_DELIVERY_ENABLED", str2), zE);
        if (zE) {
            boolean zD = nVar.d();
            j.b(context, a(str, "CappingManager.IS_CAPPING_ENABLED", str2), zD);
            if (zD) {
                j.b(context, a(str, "CappingManager.MAX_NUMBER_OF_SHOWS", str2), nVar.b());
                j.f(context, a(str, "CappingManager.CAPPING_TYPE", str2), nVar.a().toString());
            }
            boolean zF = nVar.f();
            j.b(context, a(str, "CappingManager.IS_PACING_ENABLED", str2), zF);
            if (zF) {
                j.b(context, a(str, "CappingManager.SECONDS_BETWEEN_SHOWS", str2), nVar.c());
            }
        }
    }
}
