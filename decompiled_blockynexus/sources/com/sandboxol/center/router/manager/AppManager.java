package com.sandboxol.center.router.manager;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.apkfuns.logutils.c;
import com.sandboxol.center.router.moduleInfo.game.GameBroadcastType;
import com.sandboxol.center.view.activity.TemplateActivity;
import com.sandboxol.common.base.app.SingleTemplateActivity;
import com.sandboxol.messager.MessagerClient;
import java.util.Stack;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes.dex */
public class AppManager {
    private static final String TAG = "com.sandboxol.center.router.manager.AppManager";
    private static Stack<Activity> mActivityStack = new Stack<>();
    private static Stack<Activity> mActivitys = new Stack<>();
    private static int mFinalCount;

    static /* synthetic */ int access$108() {
        int i = mFinalCount;
        mFinalCount = i + 1;
        return i;
    }

    static /* synthetic */ int access$110() {
        int i = mFinalCount;
        mFinalCount = i - 1;
        return i;
    }

    public static void clearActivityStack() {
        for (Activity activity : mActivitys) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }

    public static Stack<Activity> getActivityStack() {
        return mActivityStack;
    }

    public static void registerAppForScrapAnim(Application application) {
        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.sandboxol.center.router.manager.AppManager.2
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                c.a(AppManager.TAG).d(activity + "onActivityCreated");
                if ((activity instanceof TemplateActivity) || (activity instanceof SingleTemplateActivity)) {
                    AppManager.mActivityStack.add(activity);
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                c.a(AppManager.TAG).d(activity + "onActivityDestroyed");
                if ((activity instanceof TemplateActivity) || (activity instanceof SingleTemplateActivity)) {
                    AppManager.mActivityStack.remove(activity);
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                if (activity != null && activity.getClass().getName().contains("BlockManEchoesActivity") && activity.isFinishing()) {
                    MessagerClient.getIns().sendMsg0(GameBroadcastType.BROADCAST_SHOW_SCRAP_ANIM);
                }
                c.a(AppManager.TAG).d(activity + "onActivityPaused");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                c.a(AppManager.TAG).d(activity + "onActivityResumed");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                c.a(AppManager.TAG).d(activity + "onActivitySaveInstanceState");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                c.a(AppManager.TAG).d(activity + "onActivityStarted");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                c.a(AppManager.TAG).d(activity + "onActivityStopped");
            }
        });
    }

    public static void registerAppInBackground(Application application, final Action0 action0, final Action0 action02) {
        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.sandboxol.center.router.manager.AppManager.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                c.a(AppManager.TAG).c(activity + "onActivityCreated");
                AppManager.mActivitys.add(activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                c.a(AppManager.TAG).c(activity + "onActivityDestroyed");
                AppManager.mActivitys.remove(activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                c.a(AppManager.TAG).c(activity + "onActivityPaused");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                c.a(AppManager.TAG).c(activity + "onActivityResumed");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                c.a(AppManager.TAG).c(activity + "onActivitySaveInstanceState");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                Action0 action03;
                c.a(AppManager.TAG).c(">>>>>>>>>>>>>>>>>>>切到前台  lifecycle");
                AppManager.access$108();
                if (AppManager.mFinalCount != 1 || (action03 = action0) == null) {
                    return;
                }
                action03.call();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                Action0 action03;
                c.a(AppManager.TAG).c(">>>>>>>>>>>>>>>>>>>切到后台  lifecycle");
                AppManager.access$110();
                if (AppManager.mFinalCount != 0 || (action03 = action02) == null) {
                    return;
                }
                action03.call();
            }
        });
    }
}
