package com.ironsource.mediationsdk.utils;

import android.text.TextUtils;

/* JADX INFO: compiled from: ErrorBuilder.java */
/* JADX INFO: loaded from: classes2.dex */
public class g {
    public static com.ironsource.mediationsdk.logger.b a(String str, String str2, String str3) {
        String str4;
        StringBuilder sb = new StringBuilder();
        sb.append("Init Fail - ");
        sb.append(str);
        sb.append(" value ");
        sb.append(str2);
        sb.append(" is not valid");
        if (TextUtils.isEmpty(str3)) {
            str4 = "";
        } else {
            str4 = " - " + str3;
        }
        sb.append(str4);
        return new com.ironsource.mediationsdk.logger.b(506, sb.toString());
    }

    public static com.ironsource.mediationsdk.logger.b b(String str, String str2) {
        return new com.ironsource.mediationsdk.logger.b(509, str + " Show Fail - " + str2);
    }

    public static com.ironsource.mediationsdk.logger.b c(String str, String str2) {
        return new com.ironsource.mediationsdk.logger.b(502, "Mediation - Unable to retrieve configurations from IronSource server, using cached configurations with appKey:" + str + " and userId:" + str2);
    }

    public static com.ironsource.mediationsdk.logger.b d(String str) {
        return new com.ironsource.mediationsdk.logger.b(509, str + " Show Fail - No ads to show");
    }

    public static com.ironsource.mediationsdk.logger.b e(String str) {
        return new com.ironsource.mediationsdk.logger.b(501, "" + str + " Init Fail - Unable to retrieve configurations from the server");
    }

    public static com.ironsource.mediationsdk.logger.b f(String str) {
        return new com.ironsource.mediationsdk.logger.b(520, "" + str + " Show Fail - No Internet connection");
    }

    public static com.ironsource.mediationsdk.logger.b g(String str) {
        return new com.ironsource.mediationsdk.logger.b(527, str + " The requested instance does not exist");
    }

    public static com.ironsource.mediationsdk.logger.b h(String str) {
        return new com.ironsource.mediationsdk.logger.b(616, str + " unsupported banner size");
    }

    public static com.ironsource.mediationsdk.logger.b b(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        String str4 = "";
        sb.append("");
        sb.append(str);
        sb.append(" Load Fail");
        if (!TextUtils.isEmpty(str2)) {
            str4 = " " + str2;
        }
        sb.append(str4);
        sb.append(" - ");
        String string = sb.toString();
        if (TextUtils.isEmpty(str3)) {
            str3 = "unknown error";
        }
        return new com.ironsource.mediationsdk.logger.b(510, string + str3);
    }

    public static com.ironsource.mediationsdk.logger.b c(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "Load failed due to an unknown error";
        } else {
            str2 = "Load failed - " + str;
        }
        return new com.ironsource.mediationsdk.logger.b(510, str2);
    }

    public static com.ironsource.mediationsdk.logger.b a(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str)) {
            str3 = str2 + " init failed due to an unknown error";
        } else {
            str3 = str2 + " - " + str;
        }
        return new com.ironsource.mediationsdk.logger.b(508, str3);
    }

    public static com.ironsource.mediationsdk.logger.b b(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "An error occurred";
        }
        return new com.ironsource.mediationsdk.logger.b(510, str);
    }

    public static com.ironsource.mediationsdk.logger.b a(String str) {
        return new com.ironsource.mediationsdk.logger.b(524, str);
    }
}
