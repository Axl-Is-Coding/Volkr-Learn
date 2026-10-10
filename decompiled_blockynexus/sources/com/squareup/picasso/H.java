package com.squareup.picasso;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: compiled from: Stats.java */
/* JADX INFO: loaded from: classes5.dex */
class H {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final HandlerThread f19238a = new HandlerThread("Picasso-Stats", 10);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final InterfaceC2756k f19239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Handler f19240c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    long f19241d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    long f19242e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    long f19243f;
    long g;
    long h;
    long i;
    long j;
    long k;
    int l;
    int m;
    int n;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: Stats.java */
    static class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final H f19244a;

        public a(Looper looper, H h) {
            super(looper);
            this.f19244a = h;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                this.f19244a.d();
                return;
            }
            if (i == 1) {
                this.f19244a.e();
                return;
            }
            if (i == 2) {
                this.f19244a.b(message.arg1);
                return;
            }
            if (i == 3) {
                this.f19244a.c(message.arg1);
            } else if (i != 4) {
                Picasso.f19259a.post(new G(this, message));
            } else {
                this.f19244a.a((Long) message.obj);
            }
        }
    }

    H(InterfaceC2756k interfaceC2756k) {
        this.f19239b = interfaceC2756k;
        this.f19238a.start();
        P.a(this.f19238a.getLooper());
        this.f19240c = new a(this.f19238a.getLooper(), this);
    }

    void a(Bitmap bitmap) {
        a(bitmap, 2);
    }

    void b(Bitmap bitmap) {
        a(bitmap, 3);
    }

    void c() {
        this.f19240c.sendEmptyMessage(1);
    }

    void d() {
        this.f19241d++;
    }

    void e() {
        this.f19242e++;
    }

    void a(long j) {
        Handler handler = this.f19240c;
        handler.sendMessage(handler.obtainMessage(4, Long.valueOf(j)));
    }

    void b() {
        this.f19240c.sendEmptyMessage(0);
    }

    void c(long j) {
        this.n++;
        this.h += j;
        this.k = a(this.m, this.h);
    }

    void a(Long l) {
        this.l++;
        this.f19243f += l.longValue();
        this.i = a(this.l, this.f19243f);
    }

    void b(long j) {
        this.m++;
        this.g += j;
        this.j = a(this.m, this.g);
    }

    I a() {
        return new I(this.f19239b.a(), this.f19239b.size(), this.f19241d, this.f19242e, this.f19243f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, System.currentTimeMillis());
    }

    private void a(Bitmap bitmap, int i) {
        int iA = P.a(bitmap);
        Handler handler = this.f19240c;
        handler.sendMessage(handler.obtainMessage(i, iA, 0));
    }

    private static long a(int i, long j) {
        return j / ((long) i);
    }
}
