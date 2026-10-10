package com.tencent.tp;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes5.dex */
public class MainThreadDispatcher2 {

    static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f19679a;

        public a(String str) {
            this.f19679a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            MainThreadDispatcher2.doOnCmd(this.f19679a);
        }
    }

    public static void SendCmd(String str) {
        if (str.startsWith(q.a("npw:"))) {
            doOnCmd(str.substring(4));
        } else if (str.startsWith(q.a("pkyvoz_vyw_zivwgzy_jqzm_pnw:"))) {
            doOnCmd(str);
        } else {
            new Handler(Looper.getMainLooper()).post(onCmdRunnable(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void doOnCmd(String str) {
        TssJavaMethod.sendCmd(str);
    }

    private static Runnable onCmdRunnable(String str) {
        return new a(str);
    }
}
