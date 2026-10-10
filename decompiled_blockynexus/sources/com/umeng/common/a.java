package com.umeng.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.utils.UMUtils;

/* JADX INFO: compiled from: EncryptHelper.java */
/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f21014a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f21015b = "umeng+";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f21016c = "ek__id";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f21017d = "ek_key";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f21018e = "1234567890";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f21019f = "";
    private static final String g = "umeng_subprocess_info";
    private static String h = "";
    private static a i;

    private a() {
    }

    public static a a() {
        if (i == null) {
            synchronized (a.class) {
                if (i == null) {
                    i = new a();
                }
            }
        }
        return i;
    }

    private String c(String str) {
        String string = "";
        try {
            String strSubstring = str.substring(1, 9);
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < strSubstring.length(); i2++) {
                char cCharAt = strSubstring.charAt(i2);
                if (!Character.isDigit(cCharAt)) {
                    sb.append(cCharAt);
                } else if (Integer.parseInt(Character.toString(cCharAt)) == 0) {
                    sb.append(0);
                } else {
                    sb.append(10 - Integer.parseInt(Character.toString(cCharAt)));
                }
            }
            string = sb.toString();
            return string + new StringBuilder(string).reverse().toString();
        } catch (Throwable unused) {
            return string;
        }
    }

    public String b(String str) {
        String str2;
        String str3 = null;
        try {
            return TextUtils.isEmpty(f21014a) ? str : new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), f21014a.getBytes()));
        } catch (Exception unused) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败!");
            if (TextUtils.isEmpty(f21019f)) {
                return null;
            }
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，换老秘钥重试");
            try {
                str2 = new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), f21019f.getBytes()));
            } catch (Exception unused2) {
            }
            try {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，换老秘钥重试成功。");
                return str2;
            } catch (Exception unused3) {
                str3 = str2;
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，换老秘钥重试失败。换子进程备份key重试。");
                try {
                    String str4 = new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), h.getBytes()));
                    try {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，子进程备份key重试成功。");
                        return str4;
                    } catch (Throwable unused4) {
                        str3 = str4;
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，子进程备份key重试失败。");
                        return str3;
                    }
                } catch (Throwable unused5) {
                }
            }
        }
    }

    public void a(Context context) {
        try {
            if (TextUtils.isEmpty(f21014a)) {
                String multiProcessSP = UMUtils.getMultiProcessSP(context, f21016c);
                if (!TextUtils.isEmpty(multiProcessSP)) {
                    f21019f = c(multiProcessSP);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>> primaryKey: " + f21019f);
                }
                SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(g, 0);
                if (sharedPreferences != null) {
                    h = sharedPreferences.getString(f21016c, null);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程备份秘钥：主进程key: " + h);
                }
                f21014a = c(f21018e);
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>> 正式秘钥：key: " + f21014a);
            }
        } catch (Throwable unused) {
        }
    }

    public String a(String str) {
        try {
            return TextUtils.isEmpty(f21014a) ? str : Base64.encodeToString(DataHelper.encrypt(str.getBytes(), f21014a.getBytes()), 0);
        } catch (Exception unused) {
            return null;
        }
    }
}
