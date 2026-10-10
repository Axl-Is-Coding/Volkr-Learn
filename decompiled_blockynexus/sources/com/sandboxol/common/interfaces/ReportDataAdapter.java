package com.sandboxol.common.interfaces;

import android.content.Context;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class ReportDataAdapter {
    private static Set<IReportData> reportDatas = new HashSet();

    public static void onError(Context context, Throwable th) {
        Iterator<IReportData> it = reportDatas.iterator();
        while (it.hasNext()) {
            it.next().onError(context, th);
        }
    }

    public static void onEvent(Context context, String str) {
        Iterator<IReportData> it = reportDatas.iterator();
        while (it.hasNext()) {
            it.next().onEvent(context, str);
        }
    }

    public static void onPause(Context context) {
        Iterator<IReportData> it = reportDatas.iterator();
        while (it.hasNext()) {
            it.next().onPause(context);
        }
    }

    public static void onResume(Context context) {
        Iterator<IReportData> it = reportDatas.iterator();
        while (it.hasNext()) {
            it.next().onResume(context);
        }
    }

    public static synchronized void registerReportAdapter(Context context, IReportData iReportData) {
        reportDatas.add(iReportData);
        iReportData.init(context);
    }

    public static synchronized void unRegisterAll() {
        reportDatas.clear();
    }

    public static synchronized void unRegisterReportAdapter(IReportData iReportData) {
        reportDatas.remove(iReportData);
    }

    public static void onEvent(Context context, String str, String str2) {
        Iterator<IReportData> it = reportDatas.iterator();
        while (it.hasNext()) {
            it.next().onEvent(context, str, str2);
        }
    }

    public static void onEvent(Context context, String str, String str2, Map map) {
        Iterator<IReportData> it = reportDatas.iterator();
        while (it.hasNext()) {
            it.next().onEvent(context, str, str2, map);
        }
    }
}
