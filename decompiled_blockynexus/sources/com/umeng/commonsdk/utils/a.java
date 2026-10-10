package com.umeng.commonsdk.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* JADX INFO: compiled from: CountDownTimer.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f21323e = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f21324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f21325b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f21326c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private HandlerThread f21328f;
    private Handler g;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f21327d = false;
    private Handler.Callback h = new Handler.Callback() { // from class: com.umeng.commonsdk.utils.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            synchronized (a.this) {
                if (a.this.f21327d) {
                    return true;
                }
                long jElapsedRealtime = a.this.f21326c - SystemClock.elapsedRealtime();
                if (jElapsedRealtime <= 0) {
                    a.this.c();
                    if (a.this.f21328f != null) {
                        a.this.f21328f.quit();
                    }
                } else if (jElapsedRealtime < a.this.f21325b) {
                    a.this.g.sendMessageDelayed(a.this.g.obtainMessage(1), jElapsedRealtime);
                } else {
                    long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                    a.this.a(jElapsedRealtime);
                    long jElapsedRealtime3 = (jElapsedRealtime2 + a.this.f21325b) - SystemClock.elapsedRealtime();
                    while (jElapsedRealtime3 < 0) {
                        jElapsedRealtime3 += a.this.f21325b;
                    }
                    a.this.g.sendMessageDelayed(a.this.g.obtainMessage(1), jElapsedRealtime3);
                }
                return false;
            }
        }
    };

    public a(long j, long j2) {
        this.f21324a = j;
        this.f21325b = j2;
        if (d()) {
            this.g = new Handler(this.h);
            return;
        }
        this.f21328f = new HandlerThread("CountDownTimerThread");
        this.f21328f.start();
        this.g = new Handler(this.f21328f.getLooper(), this.h);
    }

    public abstract void a(long j);

    public abstract void c();

    private boolean d() {
        return Looper.getMainLooper().getThread().equals(Thread.currentThread());
    }

    public final synchronized void a() {
        this.f21327d = true;
        this.g.removeMessages(1);
    }

    public final synchronized a b() {
        this.f21327d = false;
        if (this.f21324a <= 0) {
            c();
            return this;
        }
        this.f21326c = SystemClock.elapsedRealtime() + this.f21324a;
        this.g.sendMessage(this.g.obtainMessage(1));
        return this;
    }
}
