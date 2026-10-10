package com.bumptech.glide.load.engine.b;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import cn.qqtheme.framework.widget.WheelView;
import io.grpc.internal.GrpcUtil;

/* JADX INFO: compiled from: MemorySizeCalculator.java */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f4520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f4521b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f4522c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f4523d;

    /* JADX INFO: compiled from: MemorySizeCalculator.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final int f4524a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Context f4525b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        ActivityManager f4526c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        c f4527d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        float f4529f;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        float f4528e = 2.0f;
        float g = 0.4f;
        float h = 0.33f;
        int i = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;

        static {
            f4524a = Build.VERSION.SDK_INT < 26 ? 4 : 1;
        }

        public a(Context context) {
            this.f4529f = f4524a;
            this.f4525b = context;
            this.f4526c = (ActivityManager) context.getSystemService("activity");
            this.f4527d = new b(context.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT < 26 || !j.a(this.f4526c)) {
                return;
            }
            this.f4529f = WheelView.DividerConfig.FILL;
        }

        public j a() {
            return new j(this);
        }
    }

    /* JADX INFO: compiled from: MemorySizeCalculator.java */
    private static final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final DisplayMetrics f4530a;

        b(DisplayMetrics displayMetrics) {
            this.f4530a = displayMetrics;
        }

        @Override // com.bumptech.glide.load.engine.b.j.c
        public int a() {
            return this.f4530a.heightPixels;
        }

        @Override // com.bumptech.glide.load.engine.b.j.c
        public int b() {
            return this.f4530a.widthPixels;
        }
    }

    /* JADX INFO: compiled from: MemorySizeCalculator.java */
    interface c {
        int a();

        int b();
    }

    j(a aVar) {
        this.f4522c = aVar.f4525b;
        this.f4523d = a(aVar.f4526c) ? aVar.i / 2 : aVar.i;
        int iA = a(aVar.f4526c, aVar.g, aVar.h);
        float fB = aVar.f4527d.b() * aVar.f4527d.a() * 4;
        int iRound = Math.round(aVar.f4529f * fB);
        int iRound2 = Math.round(fB * aVar.f4528e);
        int i = iA - this.f4523d;
        int i2 = iRound2 + iRound;
        if (i2 <= i) {
            this.f4521b = iRound2;
            this.f4520a = iRound;
        } else {
            float f2 = i;
            float f3 = aVar.f4529f;
            float f4 = aVar.f4528e;
            float f5 = f2 / (f3 + f4);
            this.f4521b = Math.round(f4 * f5);
            this.f4520a = Math.round(f5 * aVar.f4529f);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Calculation complete, Calculated memory cache size: ");
            sb.append(a(this.f4521b));
            sb.append(", pool size: ");
            sb.append(a(this.f4520a));
            sb.append(", byte array size: ");
            sb.append(a(this.f4523d));
            sb.append(", memory class limited? ");
            sb.append(i2 > iA);
            sb.append(", max size: ");
            sb.append(a(iA));
            sb.append(", memoryClass: ");
            sb.append(aVar.f4526c.getMemoryClass());
            sb.append(", isLowMemoryDevice: ");
            sb.append(a(aVar.f4526c));
            Log.d("MemorySizeCalculator", sb.toString());
        }
    }

    public int a() {
        return this.f4523d;
    }

    public int b() {
        return this.f4520a;
    }

    public int c() {
        return this.f4521b;
    }

    private static int a(ActivityManager activityManager, float f2, float f3) {
        float memoryClass = activityManager.getMemoryClass() * 1024 * 1024;
        if (a(activityManager)) {
            f2 = f3;
        }
        return Math.round(memoryClass * f2);
    }

    private String a(int i) {
        return Formatter.formatFileSize(this.f4522c, i);
    }

    @TargetApi(19)
    static boolean a(ActivityManager activityManager) {
        if (Build.VERSION.SDK_INT >= 19) {
            return activityManager.isLowRamDevice();
        }
        return true;
    }
}
