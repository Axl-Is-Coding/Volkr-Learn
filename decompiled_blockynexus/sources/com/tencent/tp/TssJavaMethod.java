package com.tencent.tp;

import android.content.Context;
import android.os.Looper;

/* JADX INFO: loaded from: classes5.dex */
public class TssJavaMethod {
    private static void a(String str) {
        String[] strArrSplit = str.split("\\|");
        if (strArrSplit.length < 3) {
            return;
        }
        boolean z = false;
        boolean z2 = strArrSplit[0].compareTo("1") == 0;
        boolean z3 = strArrSplit[1].compareTo("1") == 0;
        boolean z4 = strArrSplit[2].compareTo("1") == 0;
        if (strArrSplit.length >= 4 && strArrSplit[3].compareTo("1") == 0) {
            z = true;
        }
        w.a(z2, z3, z4, z, strArrSplit.length >= 5 ? strArrSplit[4] : "0");
    }

    private static void b(String str) {
        Context contextC = v.c();
        boolean zB = contextC != null ? v.b(contextC) : false;
        String strA = q.a("pkyvoz_vyw_zivwgzy_jqzm_pnw:%n:0:0");
        Object[] objArr = new Object[1];
        objArr[0] = zB ? "1" : "0";
        r.a(String.format(strA, objArr));
    }

    public static void initialize() {
        v.a();
    }

    public static void scan() {
        w.a(true, false, false, false, "0");
    }

    public static void sendCmd(String str) {
        sendCmdEx(str);
    }

    public static int sendCmdEx(String str) {
        String strA;
        if (str == null) {
            return -1;
        }
        if (str.compareTo(q.a("didodvgduz")) == 0) {
            v.a();
            return 0;
        }
        if (str.startsWith(q.a("ho:"))) {
            MainThreadDispatcher2.SendCmd(str.substring(3));
            return 0;
        }
        if (str.startsWith(q.a("dia_xg:"))) {
            a(str.substring(7));
            return 0;
        }
        if (str.startsWith(q.a("dn_hvdi_gjjkzm"))) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                return 0;
            }
            strA = q.a("DnHvdiOcmzvy");
        } else {
            if (str.startsWith(q.a("hnbwjs:")) || str.startsWith(q.a("cdyz_hnbwjs:"))) {
                g.a().a(str);
                return 0;
            }
            if (str.startsWith(q.a("yg_adgz:"))) {
                return 0;
            }
            if (str.startsWith(q.a("pkyvoz_vyw_zivwgzy_jqzm_pnw:"))) {
                b(str);
                return 0;
            }
            if (str.startsWith(q.a("zszx|"))) {
                return 0;
            }
            strA = "*#07#:" + str;
        }
        r.a(strA);
        return 0;
    }
}
