package com.tendcloud.tenddata;

import android.content.Context;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public class n {
    public static final String A = "TDadditionalVersionCode";
    private static final String B = "TDtime_set_collect_net";
    private static final String C = "TDdeep_link_url";
    private static final String D = "TDtd_role_id";
    private static final String E = "TDpref.accountid.key";
    private static final String F = "TDpref.accountgame.key";
    private static final String G = "TDpref.missionid.key";
    private static final String H = "TDpref.game.session.startsystem.key";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f20035a = "TDpref.profile.key";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f20036b = "TDpref.session.key";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f20037c = "TDpref.session.backup.key";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f20038d = "TDpref.lastactivity.key";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f20039e = "TDpref.start.key";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f20040f = "TDpref.init.key";
    public static final String g = "TDpref.init.flag";
    public static final String h = "TDpref.actstart.key";
    public static final String i = "TDpref.end.key";
    public static final String j = "TDpref.ip";
    public static final String k = "TD_CHANNEL_ID";
    public static final String l = "TDappcontext_push";
    public static final String m = "TDpref.tokensync.key";
    public static final String n = "TDpref.push.msgid.key";
    public static final String o = "TDpref.running.app.key";
    public static final String p = "activities";
    public static final String q = "handHolding";
    public static final String r = "pref_antiCheatingData";
    public static final String s = "TDpref_longtime";
    public static final String t = "TDpref_shorttime";
    public static final String u = "TDaes_key";
    public static final String v = "TDpref_game";
    public static final String w = "TD_push_pref_file";
    static final String x = "TDisAppQuiting";
    public static final String y = "TDpref.last.sdk.check";
    public static final String z = "TDadditionalVersionName";

    public static String a() {
        Context context = ab.g;
        if (context == null) {
            return null;
        }
        try {
            return w.b(context, s, u, (String) null);
        } catch (Throwable th) {
            bp.postSDKError(th);
            return null;
        }
    }

    public static void b(String str, a aVar) {
        Context context = ab.g;
        if (context == null || aVar == null) {
            return;
        }
        try {
            w.a(context, s + aVar.index(), f20037c, str);
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    public static boolean c() {
        Context context = ab.g;
        if (context == null) {
            return false;
        }
        try {
            return context.getSharedPreferences("TD_CHANNEL_ID", 0).getBoolean("location_called", false);
        } catch (Throwable th) {
            bp.postSDKError(th);
            return false;
        }
    }

    public static String d() {
        Context context = ab.g;
        if (context == null) {
            return "";
        }
        try {
            return w.b(context, t, f20038d, "");
        } catch (Throwable unused) {
            return "";
        }
    }

    public static long e(a aVar) {
        Context context = ab.g;
        if (context != null && aVar != null) {
            try {
                return w.b(context, s + aVar.index(), g, 1L);
            } catch (Throwable unused) {
            }
        }
        return 1L;
    }

    public static long f() {
        Context context = ab.g;
        if (context == null) {
            return 0L;
        }
        try {
            return w.b(context, t, h, 0L);
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static long g() {
        Context context = ab.g;
        if (context == null) {
            return 0L;
        }
        try {
            return w.b(context, s, o, 0L);
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static String h() {
        Context context = ab.g;
        if (context == null) {
            return null;
        }
        try {
            return w.b(context, s, z, (String) null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static long i() {
        Context context = ab.g;
        if (context == null) {
            return -1L;
        }
        try {
            return w.b(context, s, A, -1L);
        } catch (Throwable unused) {
            return -1L;
        }
    }

    public static int j() {
        try {
            return i() != -1 ? Integer.parseInt(String.valueOf(i())) : l.a().b(ab.g);
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static String k() {
        try {
            return h() != null ? h() : l.a().c(ab.g);
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    public static String l() {
        Context context = ab.g;
        if (context == null) {
            return null;
        }
        try {
            return w.b(context, t, D, (String) null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static long m() {
        Context context = ab.g;
        if (context == null) {
            return 0L;
        }
        try {
            return w.b(context, t, B, 0L);
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static String n() {
        Context context = ab.g;
        if (context == null) {
            return null;
        }
        try {
            return w.b(context, t, C, (String) null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String o() {
        Context context = ab.g;
        if (context == null) {
            return "";
        }
        try {
            return w.b(context, v, E, "");
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String p() {
        Context context = ab.g;
        if (context == null) {
            return "";
        }
        try {
            return w.b(context, v, G, "");
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void q() {
        Context context = ab.g;
        if (context == null) {
            return;
        }
        try {
            w.a(context, v, H, System.currentTimeMillis());
        } catch (Throwable unused) {
        }
    }

    public static String r() {
        Context context = ab.g;
        if (context == null) {
            return "";
        }
        try {
            return w.b(context, w, l, "");
        } catch (Throwable unused) {
            return "";
        }
    }

    public static long s() {
        Context context = ab.g;
        if (context == null) {
            return 0L;
        }
        try {
            return w.b(context, w, m, 0L);
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static void setAESKey(String str) {
        Context context = ab.g;
        if (context == null) {
            return;
        }
        try {
            w.a(context, s, u, str);
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    public static void setAccountId(String str) {
        Context context = ab.g;
        if (context == null) {
            return;
        }
        try {
            w.a(context, v, E, str);
        } catch (Throwable unused) {
        }
    }

    public static void setActivityStartTime(long j2) {
        Context context = ab.g;
        if (context == null) {
            return;
        }
        try {
            w.a(context, t, h, j2);
        } catch (Throwable unused) {
        }
    }

    public static void setAdditionalVersionCode(long j2) {
        Context context = ab.g;
        if (context == null) {
            return;
        }
        try {
            w.a(context, s, A, j2);
        } catch (Throwable unused) {
        }
    }

    public static void setAdditionalVersionName(String str) {
        Context context = ab.g;
        if (context == null) {
            return;
        }
        try {
            w.a(context, s, z, str);
        } catch (Throwable unused) {
        }
    }

    public static void setCollectNetInfoTime(long j2) {
        Context context = ab.g;
        if (context == null) {
            return;
        }
        try {
            w.a(context, t, B, j2);
        } catch (Throwable unused) {
        }
    }

    public static void setCollectRunningTime(long j2) {
        try {
            w.a(ab.g, s, o, j2);
        } catch (Throwable unused) {
        }
    }

    public static void setDeepLink(String str) {
        Context context = ab.g;
        if (context == null) {
            return;
        }
        try {
            w.a(context, t, C, str);
        } catch (Throwable unused) {
        }
    }

    public static void setInitTime(long j2) {
        Context context = ab.g;
        if (context == null) {
            return;
        }
        try {
            w.a(context, s, f20040f, j2);
        } catch (Throwable unused) {
        }
    }

    public static void setLastActivity(String str) {
        Context context = ab.g;
        if (context == null) {
            return;
        }
        try {
            w.a(context, t, f20038d, str);
        } catch (Throwable unused) {
        }
    }

    public static void setLastRoleName(String str) {
        Context context = ab.g;
        if (context == null) {
            return;
        }
        try {
            w.a(context, t, D, str);
        } catch (Throwable unused) {
        }
    }

    public static void setMissionId(String str) {
        Context context = ab.g;
        if (context == null) {
            return;
        }
        try {
            w.a(context, v, G, str);
        } catch (Throwable unused) {
        }
    }

    public static void setPostProfile(boolean z2) {
        try {
            w.a(ab.g, s, f20035a, z2 ? 1L : 0L);
        } catch (Throwable unused) {
        }
    }

    public static void setPushAppContext(String str) {
        Context context = ab.g;
        if (context == null) {
            return;
        }
        try {
            w.a(context, w, l, str);
        } catch (Throwable unused) {
        }
    }

    public static void setPushLastMsgId(String str) {
        Context context = ab.g;
        if (context == null) {
            return;
        }
        try {
            w.a(context, w, n, str);
        } catch (Throwable unused) {
        }
    }

    public static void setPushSyncTokenLastTime(long j2) {
        Context context = ab.g;
        if (context == null) {
            return;
        }
        try {
            w.a(context, w, m, j2);
        } catch (Throwable unused) {
        }
    }

    public static String t() {
        Context context = ab.g;
        if (context == null) {
            return "";
        }
        try {
            return w.b(context, w, n, "");
        } catch (Throwable unused) {
            return "";
        }
    }

    public static long d(a aVar) {
        Context context = ab.g;
        if (context != null && aVar != null) {
            try {
                return w.b(context, s + aVar.index(), f20040f, 0L);
            } catch (Throwable unused) {
            }
        }
        return 0L;
    }

    public static long e() {
        Context context = ab.g;
        if (context == null) {
            return 0L;
        }
        try {
            return w.b(context, s, f20040f, 0L);
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static long f(a aVar) {
        Context context = ab.g;
        if (context != null && aVar != null) {
            try {
                return w.b(context, t + aVar.index(), i, 0L);
            } catch (Throwable unused) {
            }
        }
        return 0L;
    }

    public static String a(a aVar) {
        Context context = ab.g;
        if (context != null && aVar != null) {
            try {
                return w.b(context, s + aVar.index(), f20036b, (String) null);
            } catch (Throwable th) {
                bp.postSDKError(th);
            }
        }
        return null;
    }

    public static String b(a aVar) {
        Context context = ab.g;
        if (context != null && aVar != null) {
            try {
                return w.b(context, s + aVar.index(), f20037c, (String) null);
            } catch (Throwable th) {
                bp.postSDKError(th);
            }
        }
        return null;
    }

    public static long c(a aVar) {
        Context context = ab.g;
        if (context != null && aVar != null) {
            try {
                return w.b(context, s + aVar.index(), f20039e, 0L);
            } catch (Throwable unused) {
            }
        }
        return 0L;
    }

    public static void a(String str, a aVar) {
        Context context = ab.g;
        if (context == null || aVar == null) {
            return;
        }
        try {
            w.a(context, s + aVar.index(), f20036b, str);
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    public static void b() {
        Context context = ab.g;
        if (context == null) {
            return;
        }
        try {
            context.getSharedPreferences("TD_CHANNEL_ID", 0).edit().putBoolean("location_called", true).commit();
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    public static void c(long j2, a aVar) {
        Context context = ab.g;
        if (context == null || aVar == null) {
            return;
        }
        try {
            w.a(context, t + aVar.index(), i, j2);
        } catch (Throwable unused) {
        }
    }

    public static String c(String str) {
        Context context = ab.g;
        if (context == null) {
            return "";
        }
        try {
            return w.b(context, v, str + F, "");
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void a(long j2, a aVar) {
        Context context = ab.g;
        if (context == null || aVar == null) {
            return;
        }
        try {
            w.a(context, s + aVar.index(), f20039e, j2);
        } catch (Throwable unused) {
        }
    }

    public static void b(long j2, a aVar) {
        Context context = ab.g;
        if (context == null || aVar == null) {
            return;
        }
        try {
            w.a(context, s + aVar.index(), f20040f, j2);
        } catch (Throwable unused) {
        }
    }

    public static void c(String str, String str2) {
        Context context = ab.g;
        if (context == null) {
            return;
        }
        try {
            w.a(context, v, str + F, str2);
        } catch (Throwable unused) {
        }
    }

    public static void a(boolean z2, a aVar) {
        Context context = ab.g;
        if (context == null || aVar == null) {
            return;
        }
        try {
            w.a(context, s + aVar.index(), g, z2 ? 1L : 0L);
        } catch (Throwable unused) {
        }
    }

    public static void b(String str, String str2) {
        Context context = ab.g;
        if (context == null) {
            return;
        }
        try {
            w.a(context, t, str, str2);
        } catch (Throwable unused) {
        }
    }

    public static void a(String str, String str2) {
        Context context = ab.g;
        if (context == null) {
            return;
        }
        try {
            w.a(context, t, str, str2);
        } catch (Throwable unused) {
        }
    }

    public static String b(String str) {
        Context context = ab.g;
        if (context == null) {
            return null;
        }
        try {
            return w.b(context, t, str, (String) null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String a(String str) {
        Context context = ab.g;
        if (context == null) {
            return null;
        }
        try {
            return w.b(context, t, str, (String) null);
        } catch (Throwable unused) {
            return null;
        }
    }
}
