package com.umeng.analytics.vshelper;

/* JADX INFO: loaded from: classes5.dex */
public class PageNameMonitor implements com.umeng.analytics.vshelper.a {
    private static String currentActivity;
    private static String currentCustomPage;
    private static Object lock = new Object();

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final PageNameMonitor f21005a = new PageNameMonitor();

        private a() {
        }
    }

    public static PageNameMonitor getInstance() {
        return a.f21005a;
    }

    @Override // com.umeng.analytics.vshelper.a
    public void activityPause(String str) {
        synchronized (lock) {
            currentActivity = null;
        }
    }

    @Override // com.umeng.analytics.vshelper.a
    public void activityResume(String str) {
        synchronized (lock) {
            currentActivity = str;
        }
    }

    @Override // com.umeng.analytics.vshelper.a
    public void customPageBegin(String str) {
        synchronized (lock) {
            currentCustomPage = str;
        }
    }

    @Override // com.umeng.analytics.vshelper.a
    public void customPageEnd(String str) {
        synchronized (lock) {
            currentCustomPage = null;
        }
    }

    public String getCurrenPageName() {
        synchronized (lock) {
            if (currentCustomPage != null) {
                return currentCustomPage;
            }
            if (currentActivity == null) {
                return null;
            }
            return currentActivity;
        }
    }

    private PageNameMonitor() {
    }
}
