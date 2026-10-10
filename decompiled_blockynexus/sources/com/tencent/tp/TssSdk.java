package com.tencent.tp;

import android.content.Context;
import com.tencent.tp.TssInfoPublisher;

/* JADX INFO: loaded from: classes5.dex */
public class TssSdk {
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
    public static final String TSS_SDK_VERSION = "5.0.5(2020/11/10)-jar-version";

    public interface ISendDataToSvr {
        int sendDataToSvr(byte[] bArr, int i);
    }

    static {
        System.loadLibrary("tersafe2");
    }

    public static String decTssInfo(String str) {
        return ioctl(String.format("dec_tss_info:%s", str));
    }

    public static byte[] getReportData() {
        TssIOCtlResult tssIOCtlResult = new TssIOCtlResult();
        tssIOCtlResult.cmd = q.a("bzo_mzkjmo_yvov");
        if (getsdkantidata(tssIOCtlResult) != 0) {
            return null;
        }
        return tssIOCtlResult.data;
    }

    public static native int getsdkantidata(TssIOCtlResult tssIOCtlResult);

    public static native int hasMatchRate(int i);

    public static void init(Context context, int i) {
        TssSdkInitInfo tssSdkInitInfo = new TssSdkInitInfo();
        tssSdkInitInfo.game_id = i;
        init(tssSdkInitInfo);
    }

    public static native void init(TssSdkInitInfo tssSdkInitInfo);

    public static String ioctl(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        TssIOCtlResult tssIOCtlResult = new TssIOCtlResult();
        tssIOCtlResult.cmd = str;
        if (getsdkantidata(tssIOCtlResult) != 0) {
            return null;
        }
        return tssIOCtlResult.response;
    }

    public static void onPause() {
        TssSdkGameStatusInfo tssSdkGameStatusInfo = new TssSdkGameStatusInfo();
        tssSdkGameStatusInfo.game_status = 2;
        setgamestatus(tssSdkGameStatusInfo);
    }

    public static void onRecvData(byte[] bArr) {
        senddatatosdk(bArr, bArr.length);
    }

    public static void onResume() {
        TssSdkGameStatusInfo tssSdkGameStatusInfo = new TssSdkGameStatusInfo();
        tssSdkGameStatusInfo.game_status = 1;
        setgamestatus(tssSdkGameStatusInfo);
    }

    public static native void onruntimeinfo(byte[] bArr, int i);

    public static void registTssInfoReceiver(TssInfoPublisher.TssInfoReceiver tssInfoReceiver) {
        TssInfoPublisher.a().a(tssInfoReceiver);
    }

    public static native void senddatatosdk(byte[] bArr, int i);

    public static native void senddatatosvr(byte[] bArr, int i);

    public static void setUserInfo(int i, String str) {
        TssSdkUserInfo tssSdkUserInfo = new TssSdkUserInfo();
        tssSdkUserInfo.entry_id = i;
        tssSdkUserInfo.uin_type = 2;
        tssSdkUserInfo.uin_str = str;
        tssSdkUserInfo.app_id_type = 2;
        tssSdkUserInfo.app_id_str = "";
        setuserinfo(tssSdkUserInfo);
    }

    public static native void setgamestatus(TssSdkGameStatusInfo tssSdkGameStatusInfo);

    public static native void setsenddatatosvrcb(Object obj);

    public static native void setuserinfo(TssSdkUserInfo tssSdkUserInfo);

    public static native void setuserinfoex(TssSdkUserInfoEx tssSdkUserInfoEx);
}
