package com.sandboxol.center.utils;

import android.util.Log;
import androidx.databinding.ObservableList;
import com.sandboxol.center.entity.ScrapTreasureBoxInfo;
import com.sandboxol.center.view.widget.FloatCircleView;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class GameUtils {
    public static void changeMillisInFuture(XCountDownTimer xCountDownTimer, long j) {
        xCountDownTimer.cancel();
        xCountDownTimer.setMillisInFuture(j);
        xCountDownTimer.start();
    }

    public static Map<String, String> functionData(String str) {
        HashMap map = new HashMap();
        String[] strArrSplit = str.split("&");
        if (strArrSplit.length >= 2) {
            for (String str2 : strArrSplit) {
                String[] strArrSplit2 = str2.split("=");
                if (strArrSplit2.length >= 2) {
                    map.put(strArrSplit2[0], strArrSplit2[1]);
                }
            }
        }
        return map;
    }

    public static String getSystemProperty(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "");
        } catch (Exception e2) {
            Log.e("getSystemProperty", "key = " + str + ", error = " + e2.getMessage());
            return str2;
        }
    }

    public static void setAvailableScrap(FloatCircleView floatCircleView, int i, ObservableList<ScrapTreasureBoxInfo> observableList, io.reactivex.b.a aVar) {
        if (floatCircleView != null) {
            if (i <= 0 || observableList.size() <= 0) {
                floatCircleView.setRedPoint(4, "");
                return;
            }
            int i2 = 0;
            for (ScrapTreasureBoxInfo scrapTreasureBoxInfo : observableList) {
                if (scrapTreasureBoxInfo.getOpenStatus() == 0 && i >= scrapTreasureBoxInfo.getDuration() * 60) {
                    i2++;
                }
            }
            if (i2 <= 0) {
                floatCircleView.setRedPoint(4, "");
                return;
            }
            floatCircleView.setRedPoint(0, String.valueOf(i2));
            try {
                aVar.run();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
