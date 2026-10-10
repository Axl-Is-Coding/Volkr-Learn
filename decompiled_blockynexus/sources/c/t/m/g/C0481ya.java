package c.t.m.g;

import com.facebook.internal.ServerProtocol;
import java.util.HashMap;

/* JADX INFO: renamed from: c.t.m.g.ya, reason: case insensitive filesystem */
/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
public final class C0481ya {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f3446a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f3447b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f3448c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f3449d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f3450e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f3451f;
    public static boolean g;
    public static boolean h;
    public static Ma i = Ma.f2962a;

    public static final String a() {
        return "fc4.";
    }

    public static final String a(int i2) {
        if (i2 <= 1) {
            return i2 != 1 ? "" : "https://analytics.map.qq.com/?sf";
        }
        return "https://analytics.map.qq.com/?sf" + i2;
    }

    public static HashMap<String, String> b() {
        HashMap<String, String> map = new HashMap<>();
        map.put("D_CH_ID", "fc_sdk");
        map.put("D_FC_SRC", "209");
        map.put("D_UP_INTERVAL", "1800000");
        map.put("D_UP_USE_HTTPS", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        map.put("D_MAX_1F_SIZE", "102400");
        map.put("D_NUM_UP", "1");
        map.put("D_MAX_BUF_WF", "25600");
        map.put("D_MAX_FOLDER_SIZE", "104857600");
        map.put("D_MAX_DAY_RENAME", "3");
        map.put("D_MAX_DAY_DELETE", "30");
        map.put("D_MAX_SIZE_UP_1DAY", "10485760");
        map.put("D_UP_NET", "w");
        map.put("D_POS_COLL", "false");
        map.put("D_WRITE_MAC", "false");
        map.put("D_UP_WF_INFO", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        map.put("D_CHEJI_ALLOW_UPLOAD_GPS", "0");
        map.put("D_CHEJI_UPLOAD_GPS_INTERVAL", "20000");
        map.put("D_CHEJI_COLL_GPS_INTERVAL", "3000");
        map.put("D_CHEJI_SET_STATUS", "0");
        return map;
    }

    public static final int a(String str) {
        if (str.startsWith("fc4") || str.startsWith("dc4")) {
            return 4;
        }
        if (str.startsWith("fc3") || str.startsWith("dc3")) {
            return 3;
        }
        if (str.startsWith("fc2") || str.startsWith("dc2")) {
            return 2;
        }
        return (str.startsWith("fc1") || str.startsWith("fc") || str.startsWith("dc")) ? 1 : -1;
    }
}
