package com.tencent.mapsdk.rastercore.g;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.view.animation.AlphaAnimation;
import cn.qqtheme.framework.widget.WheelView;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.util.GmsVersion;
import com.sandboxol.vip.entity.VipDiamond;
import com.tencent.mapsdk.rastercore.d.f;
import io.rong.imkit.plugin.LocationConst;

/* JADX INFO: loaded from: classes5.dex */
public final class a extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private f f19603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f19604b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f19605c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f19606d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f19607e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f19608f;
    private Paint g;
    private Paint h;
    private Paint i;
    private Rect j;
    private String k;
    private int l;
    private int m;
    private int n;
    private double o;
    private int p;
    private int q;
    private int r;
    private Paint s;
    private AlphaAnimation t;
    private AlphaAnimation u;

    public a(f fVar) {
        super(f.a());
        this.f19604b = new int[]{12000000, GmsVersion.VERSION_MANCHEGO, 3000000, 1500000, 800000, 400000, 200000, 100000, 50000, 25000, 12000, LocationConst.DISTANCE, AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS, ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED, VipDiamond.MVP, 400, 200, 100, 50, 25, 17, 8, 4};
        this.f19605c = 0;
        this.f19606d = "";
        this.f19607e = 0;
        this.f19608f = 0;
        this.l = 10;
        this.m = 0;
        this.n = 10;
        this.o = 80.0d;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.t = null;
        this.u = null;
        this.f19603a = fVar;
        this.h = new Paint();
        this.h.setAntiAlias(true);
        this.h.setColor(-16777216);
        this.h.setStrokeWidth(fVar.f().b() * 6.0f);
        this.h.setStyle(Paint.Style.STROKE);
        this.i = new Paint();
        this.i.setAntiAlias(true);
        this.i.setColor(Color.rgb(100, 100, 100));
        this.i.setStrokeWidth(fVar.f().b() * 10.0f);
        this.i.setStyle(Paint.Style.STROKE);
        this.s = new Paint();
        this.s.setAntiAlias(true);
        this.s.setColor(Color.rgb(255, 255, 255));
        this.s.setStrokeWidth(fVar.f().b() * 7.0f);
        this.s.setStyle(Paint.Style.STROKE);
        this.g = new Paint();
        this.g.setAntiAlias(true);
        this.g.setColor(-16777216);
        this.g.setTextSize(fVar.f().b() * 25.0f);
        this.j = new Rect();
    }

    public static void b() {
    }

    public static void c() {
    }

    public final void a() {
        clearAnimation();
        this.h = null;
        this.g = null;
        this.j = null;
        this.f19606d = null;
        this.i = null;
    }

    public final void a(int i) {
        this.f19605c = i;
    }

    public final void d() {
        if (isShown()) {
            clearAnimation();
            this.u = new AlphaAnimation(1.0f, WheelView.DividerConfig.FILL);
            this.u.setDuration(2000L);
            this.u.setFillAfter(true);
            startAnimation(this.u);
        }
    }

    public final void e() {
        clearAnimation();
        this.t = new AlphaAnimation(WheelView.DividerConfig.FILL, 1.0f);
        this.t.setDuration(500L);
        this.t.setFillAfter(true);
        startAnimation(this.t);
    }

    @Override // android.view.View
    protected final void onDraw(Canvas canvas) {
        String str;
        boolean z;
        int i;
        float f2;
        float f3;
        float fB;
        float f4;
        Paint paint;
        double dE = this.f19603a.b().e();
        int iA = this.f19603a.c().d().a();
        this.q = this.f19603a.c().getWidth();
        double d2 = this.q;
        double d3 = this.n;
        Double.isNaN(d3);
        Double.isNaN(d2);
        if ((d2 - (d3 * 2.0d)) - this.o < 0.0d) {
            z = false;
        } else {
            int i2 = this.f19604b[iA];
            double d4 = i2;
            Double.isNaN(d4);
            double d5 = d4 / dE;
            while (true) {
                double d6 = this.q;
                Double.isNaN(d6);
                if (d5 >= d6 / 5.0d) {
                    break;
                }
                d5 *= 2.0d;
                i2 *= 2;
            }
            while (true) {
                double d7 = this.q;
                double d8 = this.n;
                Double.isNaN(d8);
                Double.isNaN(d7);
                if (d5 <= (d7 - (d8 * 2.0d)) - this.o) {
                    break;
                }
                d5 /= 2.0d;
                double d9 = i2;
                Double.isNaN(d9);
                i2 = (int) (d9 / 2.0d);
            }
            this.f19608f = (int) d5;
            if (i2 > 2000) {
                i2 /= 1000;
                str = "km";
            } else {
                str = "m";
            }
            this.f19606d = i2 + str;
            StringBuilder sb = new StringBuilder();
            int i3 = i2 / 2;
            sb.append(i3);
            this.k = sb.toString();
            this.f19607e = i3;
            z = true;
        }
        if (!z || this.f19606d.equals("") || this.f19608f == 0) {
            return;
        }
        Paint paint2 = this.g;
        String str2 = this.f19606d;
        paint2.getTextBounds(str2, 0, str2.length(), this.j);
        this.p = (int) ((getHeight() - 8) - this.h.getStrokeWidth());
        this.q = this.f19603a.c().getWidth();
        int i4 = this.f19605c;
        if (i4 == 1) {
            int i5 = this.q;
            int i6 = this.f19608f;
            this.l = (i5 / 2) - (i6 / 2);
            i = (i5 / 2) + (i6 / 2);
        } else if (i4 == 2) {
            int i7 = this.q;
            int i8 = this.n;
            this.l = (i7 - i8) - this.f19608f;
            i = i7 - i8;
        } else {
            int i9 = this.n;
            this.l = i9;
            i = i9 + this.f19608f;
        }
        this.m = i;
        int i10 = this.l;
        int i11 = this.m;
        this.r = (i10 + i11) / 2;
        float f5 = i10;
        int i12 = this.p;
        canvas.drawLine(f5, i12, i11, i12, this.i);
        float fB2 = this.l + (this.f19603a.f().b() * 4.0f);
        int i13 = this.p;
        canvas.drawLine(fB2, i13, this.r, i13, this.h);
        canvas.drawText("0", this.l - (this.f19603a.f().b() * 6.0f), this.p - this.n, this.g);
        canvas.drawText(this.f19606d, this.m - ((r0.length() * 6) * this.f19603a.f().b()), this.p - this.n, this.g);
        if (this.f19607e != 0) {
            canvas.drawText(this.k, this.r - ((r0.length() * 6) * this.f19603a.f().b()), this.p - 10, this.g);
            f2 = this.r;
            f3 = this.p;
            fB = this.m - (this.f19603a.f().b() * 4.0f);
            f4 = this.p;
            paint = this.s;
        } else {
            f2 = this.r;
            f3 = this.p;
            fB = this.m - (this.f19603a.f().b() * 4.0f);
            f4 = this.p;
            paint = this.h;
        }
        canvas.drawLine(f2, f3, fB, f4, paint);
    }
}
