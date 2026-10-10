package com.disabngo.blockynexus.d;

import android.text.TextUtils;
import android.util.Log;
import androidx.databinding.ObservableMap;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.clothes.EchoesGLSurfaceView;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ViewModelUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class K {
    public static String a(List<String> list) {
        StringBuilder sb = new StringBuilder();
        if (list != null) {
            for (String str : list) {
                if (!"".equals(sb.toString()) || str == null || "".equals(str)) {
                    sb.append(" | ");
                    sb.append(str);
                } else {
                    sb = new StringBuilder(str);
                }
            }
        }
        return sb.toString();
    }

    public static void a(ObservableMap<Long, String> observableMap) {
        observableMap.put(2L, StringConstant.CUSTOM_HAIR_1);
        observableMap.put(12L, StringConstant.CUSTOM_GLASSES_0);
        observableMap.put(4L, StringConstant.CUSTOM_FACE_1);
        observableMap.put(5L, StringConstant.CUSTOM_IDLE_0);
        observableMap.put(6L, StringConstant.CUSTOM_SKIN_0);
        observableMap.put(7L, StringConstant.CUSTOM_BG_0);
        observableMap.put(8L, StringConstant.CLOTHES_TOPS_1);
        observableMap.put(9L, StringConstant.CLOTHES_PANTS_1);
        observableMap.put(10L, StringConstant.CUSTOM_SHOES_1);
        observableMap.put(11L, StringConstant.CUSTOM_HAT_0);
        observableMap.put(13L, StringConstant.CUSTOM_SCARF_0);
        observableMap.put(14L, StringConstant.CUSTOM_WING_0);
        observableMap.put(15L, StringConstant.CUSTOM_CROWN_0);
        observableMap.put(16L, StringConstant.CUSTOM_SUITS_0);
    }

    public static String a(String str) {
        if (str.contains("hair")) {
            return StringConstant.CUSTOM_HAIR_1;
        }
        if (str.contains("glass")) {
            return StringConstant.CUSTOM_GLASSES_0;
        }
        if (str.contains("face")) {
            return StringConstant.CUSTOM_FACE_1;
        }
        if (str.contains("idle")) {
            return StringConstant.CUSTOM_IDLE_0;
        }
        if (str.contains("-")) {
            return StringConstant.CUSTOM_SKIN_0;
        }
        if (str.contains("_bg")) {
            return StringConstant.CUSTOM_BG_0;
        }
        if (str.contains("tops")) {
            return StringConstant.CLOTHES_TOPS_1;
        }
        if (str.contains("pants")) {
            return StringConstant.CLOTHES_PANTS_1;
        }
        if (str.contains("shoes")) {
            return StringConstant.CUSTOM_SHOES_1;
        }
        if (str.contains("hat")) {
            return StringConstant.CUSTOM_HAT_0;
        }
        if (str.contains("scarf")) {
            return StringConstant.CUSTOM_SCARF_0;
        }
        if (str.contains("wing")) {
            return StringConstant.CUSTOM_WING_0;
        }
        if (str.contains("_action")) {
            return StringConstant.CUSTOM_ACTION_0;
        }
        if (str.contains("crown")) {
            return StringConstant.CUSTOM_CROWN_0;
        }
        if (str.contains("suits")) {
            return StringConstant.CUSTOM_SUITS_0;
        }
        return null;
    }

    public static void a(EchoesGLSurfaceView echoesGLSurfaceView, String str) {
        if (echoesGLSurfaceView == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String[] strArrSplit = str.split("\\.");
            if (strArrSplit.length == 2) {
                if (!str.contains("idle") && !str.contains("_action")) {
                    echoesGLSurfaceView.changeParts(strArrSplit[0], strArrSplit[1]);
                } else {
                    echoesGLSurfaceView.changeChangeDefaultIdle(Integer.valueOf(strArrSplit[1]).intValue());
                }
            } else if (strArrSplit.length == 1) {
                String[] strArrSplit2 = str.split("-");
                echoesGLSurfaceView.changeSkinColor(A.a(strArrSplit2[0]), A.a(strArrSplit2[1]), A.a(strArrSplit2[2]), A.a(strArrSplit2[3]));
            }
        } catch (Exception e2) {
            Log.e("clothTypes", "clothTypes: " + e2.toString());
            e2.printStackTrace();
        }
    }

    public static void a(EchoesGLSurfaceView echoesGLSurfaceView, String str, String str2) {
        if (echoesGLSurfaceView == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String[] strArrSplit = str.split("\\.");
            if (strArrSplit.length == 2) {
                if (!str.contains("idle") && !str.contains("_action")) {
                    echoesGLSurfaceView.changePartsOtherPlayer(strArrSplit[0], strArrSplit[1], str2);
                } else {
                    echoesGLSurfaceView.changeChangeDefaultIdleOtherPlayer(Integer.valueOf(strArrSplit[1]).intValue(), str2);
                }
            } else if (strArrSplit.length == 1) {
                String[] strArrSplit2 = str.split("-");
                echoesGLSurfaceView.changeSkinColorOtherPlayer(A.a(strArrSplit2[0]), A.a(strArrSplit2[1]), A.a(strArrSplit2[2]), A.a(strArrSplit2[3]), str2);
            }
        } catch (Exception e2) {
            Log.e("clothTypes", "clothTypes: " + e2.toString());
            e2.printStackTrace();
        }
    }

    public static Long a(Map<Long, String> map, String str) {
        Long l = null;
        for (Long l2 : map.keySet()) {
            if (map.get(l2).equals(str)) {
                l = l2;
            }
        }
        return l;
    }
}
