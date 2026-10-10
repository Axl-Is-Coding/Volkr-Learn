package com.tendcloud.tenddata;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public final class bn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static Handler f19869a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static HandlerThread f19870b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile bn f19871c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f19872d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f19873e = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f19874f = 3;

    /* JADX INFO: compiled from: td */
    final class a extends BroadcastReceiver {
        private String action = null;

        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            try {
                this.action = intent.getAction();
                if ("android.intent.action.SCREEN_ON".equals(this.action)) {
                    bn.a().c().sendEmptyMessage(1);
                } else if ("android.intent.action.SCREEN_OFF".equals(this.action)) {
                    bn.a().c().sendEmptyMessage(2);
                } else if ("android.intent.action.USER_PRESENT".equals(this.action)) {
                    bn.a().c().sendEmptyMessage(3);
                }
            } catch (Throwable th) {
                bp.postSDKError(th);
            }
        }
    }

    static {
        try {
            ag.a().register(a());
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    private bn() {
        f19870b = new HandlerThread("lockScreenThread", 10);
        f19870b.start();
        f19869a = new Handler(f19870b.getLooper()) { // from class: com.tendcloud.tenddata.bn.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                try {
                    int i = message.what;
                    if (i == 1) {
                        bn.this.f();
                    } else if (i == 2) {
                        bn.this.e();
                    } else if (i == 3) {
                        bn.this.d();
                    }
                } catch (Throwable th) {
                    bp.postSDKError(th);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        try {
            bx bxVar = new bx();
            bxVar.f19906b = "env";
            bxVar.f19907c = "screenOff";
            bxVar.f19905a = com.tendcloud.tenddata.a.ENV;
            ag.a().post(bxVar);
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        try {
            bx bxVar = new bx();
            bxVar.f19906b = "env";
            bxVar.f19907c = "screenOn";
            bxVar.f19905a = com.tendcloud.tenddata.a.ENV;
            ag.a().post(bxVar);
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    public static bn a() {
        if (f19871c == null) {
            synchronized (bn.class) {
                if (f19871c == null) {
                    f19871c = new bn();
                }
            }
        }
        return f19871c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler c() {
        return f19869a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        try {
            bx bxVar = new bx();
            bxVar.f19906b = "env";
            bxVar.f19907c = "userPresent";
            bxVar.f19905a = com.tendcloud.tenddata.a.ENV;
            ag.a().post(bxVar);
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    public void b() {
        try {
            if (ab.g != null) {
                a aVar = new a();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
                intentFilter.addAction("android.intent.action.USER_PRESENT");
                ab.g.registerReceiver(aVar, intentFilter);
            }
        } catch (Throwable unused) {
        }
    }
}
