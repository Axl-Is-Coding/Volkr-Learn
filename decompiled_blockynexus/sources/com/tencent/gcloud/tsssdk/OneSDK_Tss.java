package com.tencent.gcloud.tsssdk;

import android.content.Context;
import com.tencent.tp.TssSdk;

/* JADX INFO: loaded from: classes5.dex */
public class OneSDK_Tss {
    public static final int ENTRT_ID_FACEBOOK = 3;
    public static final int ENTRY_ID_APPLE = 11;
    public static final int ENTRY_ID_GAMECENTER = 7;
    public static final int ENTRY_ID_GARENA = 14;
    public static final int ENTRY_ID_GOOGLEPLAY = 8;
    public static final int ENTRY_ID_HUAWEI = 15;
    public static final int ENTRY_ID_KUAISHOU = 10;
    public static final int ENTRY_ID_LINE = 5;
    public static final int ENTRY_ID_MICROSOFT = 19;
    public static final int ENTRY_ID_MM = 2;
    public static final int ENTRY_ID_NAVER = 13;
    public static final int ENTRY_ID_NEXON = 12;
    public static final int ENTRY_ID_NINTENDO = 17;
    public static final int ENTRY_ID_OTHERS = 99;
    public static final int ENTRY_ID_PSN = 18;
    public static final int ENTRY_ID_QQ = 1;
    public static final int ENTRY_ID_RIOT = 16;
    public static final int ENTRY_ID_TWITTER = 4;
    public static final int ENTRY_ID_VK = 9;
    public static final int ENTRY_ID_WHATSAPP = 6;

    public static byte[] getReportData() {
        return TssSdk.getReportData();
    }

    public static void init(Context context, int i) {
        TssSdk.init(context, i);
    }

    public static String ioctl(String str) {
        return TssSdk.ioctl(str);
    }

    public static void onPause() {
        TssSdk.onPause();
    }

    public static void onRecvData(byte[] bArr) {
        TssSdk.onRecvData(bArr);
    }

    public static void onResume() {
        TssSdk.onResume();
    }

    public static void setUserInfo(int i, String str) {
        TssSdk.setUserInfo(i, str);
    }
}
