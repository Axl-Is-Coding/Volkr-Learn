package com.sandboxl.library.libmobclickagent;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.google.android.gms.plus.PlusShare;
import com.sandboxol.center.router.module_application.BaseModuleApp;
import com.sandboxol.common.interfaces.IReportData;
import com.tendcloud.tenddata.TCAgent;
import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ReportMobclickAgent extends HandlerThread implements IReportData {
    private Handler handler;

    public ReportMobclickAgent() {
        super("Handler-ReportAgent");
        start();
        this.handler = new Handler(getLooper());
    }

    static /* synthetic */ void a(Context context) throws Throwable {
        UMConfigure.init(context, BaseModuleApp.getBaseModuleApp().getMetaDataUmKey(), "Channel ID", 1, "");
        MobclickAgent.setPageCollectionMode(MobclickAgent.PageMode.AUTO);
        TCAgent.init(context, BaseModuleApp.getBaseModuleApp().getMetaDataTalkingDataKey(), "play.google.com");
        TCAgent.setReportUncaughtExceptions(true);
    }

    static /* synthetic */ void b(Context context) throws Throwable {
        MobclickAgent.onPause(context);
        TCAgent.onPause((Activity) context);
    }

    static /* synthetic */ void c(Context context) throws Throwable {
        MobclickAgent.onResume(context);
        TCAgent.onResume((Activity) context);
    }

    @Override // com.sandboxol.common.interfaces.IReportData
    public void init(final Context context) {
        this.handler.post(new Runnable() { // from class: com.sandboxl.library.libmobclickagent.g
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                ReportMobclickAgent.a(context);
            }
        });
    }

    @Override // com.sandboxol.common.interfaces.IReportData
    public void onError(final Context context, final Throwable th) {
        this.handler.post(new Runnable() { // from class: com.sandboxl.library.libmobclickagent.a
            @Override // java.lang.Runnable
            public final void run() {
                TCAgent.onError(context, th);
            }
        });
    }

    @Override // com.sandboxol.common.interfaces.IReportData
    public void onEvent(final Context context, final String str) {
        this.handler.post(new Runnable() { // from class: com.sandboxl.library.libmobclickagent.d
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                ReportMobclickAgent.a(context, str);
            }
        });
    }

    @Override // com.sandboxol.common.interfaces.IReportData
    public void onPause(final Context context) {
        this.handler.post(new Runnable() { // from class: com.sandboxl.library.libmobclickagent.b
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                ReportMobclickAgent.b(context);
            }
        });
    }

    @Override // com.sandboxol.common.interfaces.IReportData
    public void onResume(final Context context) {
        this.handler.post(new Runnable() { // from class: com.sandboxl.library.libmobclickagent.c
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                ReportMobclickAgent.c(context);
            }
        });
    }

    @Override // com.sandboxol.common.interfaces.IReportData
    public void onEvent(final Context context, final String str, final String str2) {
        this.handler.post(new Runnable() { // from class: com.sandboxl.library.libmobclickagent.e
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                ReportMobclickAgent.a(context, str, str2);
            }
        });
    }

    @Override // com.sandboxol.common.interfaces.IReportData
    public void onEvent(final Context context, final String str, final Map map) {
        this.handler.post(new Runnable() { // from class: com.sandboxl.library.libmobclickagent.f
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                MobclickAgent.onEvent(context, str, (Map<String, String>) map);
            }
        });
    }

    @Override // com.sandboxol.common.interfaces.IReportData
    public void onEvent(final Context context, final String str, final String str2, final Map map) {
        this.handler.post(new Runnable() { // from class: com.sandboxl.library.libmobclickagent.h
            @Override // java.lang.Runnable
            public final void run() {
                TCAgent.onEvent(context, str, str2, map);
            }
        });
    }

    static /* synthetic */ void a(Context context, String str) throws Throwable {
        MobclickAgent.onEvent(context, str);
        TCAgent.onEvent(context, str);
    }

    static /* synthetic */ void a(Context context, String str, String str2) throws Throwable {
        MobclickAgent.onEvent(context, str, str2);
        HashMap map = new HashMap();
        map.put(PlusShare.KEY_CALL_TO_ACTION_LABEL, str2);
        TCAgent.onEvent(context, str, str2, map);
    }
}
