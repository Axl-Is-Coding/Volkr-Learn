package com.disabngo.blockynexus.d;

import android.content.Context;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.common.interfaces.ReportDataAdapter;

/* JADX INFO: compiled from: FollowFriendEventUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class n {
    public static void a(Context context) {
        ReportDataAdapter.onEvent(context, EventConstant.FOLLOW_CLICK_ADD);
    }

    public static void b(Context context, boolean z) {
        if (z) {
            ReportDataAdapter.onEvent(context, EventConstant.FOLLOW_CLICK_HOMEPARTY);
        }
    }

    public static void c(Context context) {
        ReportDataAdapter.onEvent(context, EventConstant.FOLLOW_JION);
    }

    public static void d(Context context) {
        ReportDataAdapter.onEvent(context, EventConstant.FOLLOW_CLICK_HOMEJOIN);
    }

    public static void e(Context context) {
        ReportDataAdapter.onEvent(context, EventConstant.FOLLOW_JIONSTARGAME);
    }

    public static void f(Context context) {
        ReportDataAdapter.onEvent(context, EventConstant.FOLLOW_CLICK_CHAT);
    }

    public static void g(Context context) {
        ReportDataAdapter.onEvent(context, EventConstant.FOLLOW_CLICK_VIEWINFO);
    }

    public static void h(Context context) {
        ReportDataAdapter.onEvent(context, EventConstant.FOLLOW_USEINFO_CLICKJOIN);
    }

    public static void i(Context context) {
        ReportDataAdapter.onEvent(context, EventConstant.FOLLOW_CLICK_ICON);
    }

    public static void j(Context context) {
        ReportDataAdapter.onEvent(context, EventConstant.FOLLOW_FRIENDLIST_CLICKJOIN);
    }

    public static void k(Context context) {
        ReportDataAdapter.onEvent(context, EventConstant.FOLLOW_CLICK_GAMEICON);
    }

    public static void l(Context context) {
        ReportDataAdapter.onEvent(context, EventConstant.FOLLOW_CLICK_ALL);
    }

    public static void m(Context context) {
        ReportDataAdapter.onEvent(context, EventConstant.FOLLOW_FRIENDLIST);
    }

    public static void n(Context context) {
        ReportDataAdapter.onEvent(context, EventConstant.FOLLOW_GAMETIME);
    }

    public static void a(Context context, boolean z) {
        if (z) {
            ReportDataAdapter.onEvent(context, EventConstant.FOLLOW_CLICK_HOMEGAME);
        }
    }

    public static void b(Context context) {
        ReportDataAdapter.onEvent(context, EventConstant.FOLLOW_CLICK_CANCEL);
    }

    public static void a(Context context, String str) {
        ReportDataAdapter.onEvent(context, EventConstant.FOLLOW_JIONGAMEFAIL, str);
    }
}
