package com.disabngo.blockynexus.b;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.d.D;
import com.disabngo.blockynexus.web.CampaignApi;
import com.sandboxol.blockmango.entity.ChristmasLevel;
import com.sandboxol.center.config.ActivityType;
import com.sandboxol.center.router.module_application.BaseModuleApp;
import com.sandboxol.common.interfaces.OnDataListener;
import java.io.Serializable;

/* JADX INFO: compiled from: CampaignControl.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static b f7164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f7165b = false;

    private b() {
    }

    public static b a() {
        if (f7164a == null) {
            f7164a = new b();
        }
        return f7164a;
    }

    public void b(Context context, ObservableField<Integer> observableField) {
        if (this.f7165b) {
            a(context, observableField);
            this.f7165b = false;
        }
    }

    public void c(Context context, ObservableField<Boolean> observableField) {
        observableField.set(Boolean.valueOf(a(BaseModuleApp.getBaseModuleApp().getMetaDataActivityId())));
    }

    public void d(Context context, ObservableField<Integer> observableField) {
        a(context, observableField);
    }

    public void a(Context context, ObservableField<Integer> observableField) {
        if (!a(BaseModuleApp.getBaseModuleApp().getMetaDataActivityId()) || BaseModuleApp.getBaseModuleApp().getMetaDataActivityId().equals("")) {
            return;
        }
        if (BaseModuleApp.getBaseModuleApp().getMetaDataActivityId().equals(ActivityType.SLOT_MACHINE) || BaseModuleApp.getBaseModuleApp().getMetaDataActivityId().equals(ActivityType.LUCKY_2020)) {
            CampaignApi.getTurntableRedPoint(context, BaseModuleApp.getBaseModuleApp().getMetaDataActivityId(), new a(this, observableField, context));
        }
        BaseModuleApp.getBaseModuleApp().getMetaDataActivityId().equals(ActivityType.DRAGON_BALL);
    }

    public void a(Context context, String str) {
        D.a(context, str);
        this.f7165b = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(java.lang.String r7) {
        /*
            r6 = this;
            com.sandboxol.center.entity.AppInfoCenter r0 = com.sandboxol.center.entity.AppInfoCenter.newInstance()
            com.sandboxol.center.entity.AppConfig r0 = r0.getAppConfig()
            int r1 = r7.hashCode()
            r2 = -1669147477(0xffffffff9c82d4ab, float:-8.657652E-22)
            r3 = 2
            r4 = 0
            r5 = 1
            if (r1 == r2) goto L33
            r2 = 501479174(0x1de3f706, float:6.0341816E-21)
            if (r1 == r2) goto L29
            r2 = 1235317602(0x49a17362, float:1322604.2)
            if (r1 == r2) goto L1f
            goto L3d
        L1f:
            java.lang.String r1 = "Christmas"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L3d
            r7 = 2
            goto L3e
        L29:
            java.lang.String r1 = "slot_machine"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L3d
            r7 = 0
            goto L3e
        L33:
            java.lang.String r1 = "dragon_ball"
            boolean r7 = r7.equals(r1)
            if (r7 == 0) goto L3d
            r7 = 1
            goto L3e
        L3d:
            r7 = -1
        L3e:
            if (r7 == 0) goto L5d
            if (r7 == r5) goto L5d
            if (r7 == r3) goto L45
            return r4
        L45:
            if (r0 == 0) goto L5c
            boolean r7 = r0.isShowActivity()
            if (r7 == 0) goto L5c
            com.sandboxol.common.base.app.BaseApplication r7 = com.sandboxol.common.base.app.BaseApplication.getApp()
            int r7 = r7.getMetaDataAppVersion()
            int r0 = r0.getActivityVersionCode()
            if (r7 < r0) goto L5c
            r4 = 1
        L5c:
            return r4
        L5d:
            if (r0 == 0) goto L74
            boolean r7 = r0.isShowUniversalActivity()
            if (r7 == 0) goto L74
            com.sandboxol.common.base.app.BaseApplication r7 = com.sandboxol.common.base.app.BaseApplication.getApp()
            int r7 = r7.getMetaDataAppVersion()
            int r0 = r0.getUniversalActivityVersionCode()
            if (r7 < r0) goto L74
            r4 = 1
        L74:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.b.b.a(java.lang.String):boolean");
    }

    public void a(Context context, Serializable serializable, OnDataListener onDataListener) {
        if (a(ActivityType.CHRISTMAS)) {
            try {
                if (((ChristmasLevel) serializable) != null) {
                    return;
                }
                onDataListener.onSuccess(null);
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                onDataListener.onSuccess(null);
                return;
            }
        }
        onDataListener.onSuccess(null);
    }
}
