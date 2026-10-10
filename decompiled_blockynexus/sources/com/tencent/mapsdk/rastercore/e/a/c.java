package com.tencent.mapsdk.rastercore.e.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.os.Build;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import cn.qqtheme.framework.widget.WheelView;
import com.tencent.mapsdk.raster.model.BitmapDescriptor;
import com.tencent.mapsdk.raster.model.BitmapDescriptorFactory;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mapsdk.raster.model.MarkerOptions;
import com.tencent.mapsdk.rastercore.d.g;
import com.tencent.tencentmap.mapsdk.map.MapView;

/* JADX INFO: loaded from: classes5.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f19556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static BitmapDescriptor f19557b;
    private Animation A;
    private int B;
    private Object C;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.tencent.mapsdk.rastercore.d.f f19558c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private g f19560e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private MapView f19561f;
    private View g;
    private View h;
    private Animation i;
    private Animation j;
    private GestureDetector k;
    private boolean m;
    private boolean n;
    private float q;
    private float r;
    private boolean s;
    private float t;
    private float u;
    private String v;
    private LatLng w;
    private String x;
    private String y;
    private Animation z;
    private BitmapDescriptor l = null;
    private boolean o = false;
    private boolean p = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Context f19559d = com.tencent.mapsdk.rastercore.d.f.a();

    public c(com.tencent.mapsdk.rastercore.d.f fVar, MarkerOptions markerOptions) {
        this.i = null;
        this.j = null;
        this.m = false;
        this.n = false;
        this.q = 0.5f;
        this.r = 1.0f;
        this.s = true;
        this.t = WheelView.DividerConfig.FILL;
        this.u = 1.0f;
        this.B = 25;
        this.f19558c = fVar;
        this.f19561f = fVar.d();
        this.f19560e = fVar.h();
        this.n = markerOptions.isGps();
        if (markerOptions.getPosition() != null) {
            if (this.n) {
                try {
                    double[] dArrA = e.a(markerOptions.getPosition().getLongitude(), markerOptions.getPosition().getLatitude());
                    new LatLng(dArrA[1], dArrA[0]);
                } catch (Exception unused) {
                    markerOptions.getPosition();
                }
            }
            this.w = markerOptions.getPosition();
        }
        a(markerOptions.getIcon());
        this.g = markerOptions.getMarkerView();
        this.q = markerOptions.getAnchorU();
        this.r = markerOptions.getAnchorV();
        this.u = markerOptions.getAlpha();
        this.t = markerOptions.getRotation();
        this.s = markerOptions.isVisible();
        this.v = markerOptions.getSnippet();
        this.x = markerOptions.getTitle();
        this.m = markerOptions.isDraggable();
        this.y = m();
        this.j = markerOptions.getInfoWindowHideAnimation();
        this.i = markerOptions.getInfoWindowShowAnimation();
        this.z = markerOptions.getShowingAnination();
        this.A = markerOptions.getHidingAnination();
        this.C = markerOptions.getTag();
        this.B = (int) (this.B * this.f19559d.getResources().getDisplayMetrics().density);
        this.k = new GestureDetector(this.f19559d, new GestureDetector.OnGestureListener() { // from class: com.tencent.mapsdk.rastercore.e.a.c.1
            @Override // android.view.GestureDetector.OnGestureListener
            public final boolean onDown(MotionEvent motionEvent) {
                return true;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final void onLongPress(MotionEvent motionEvent) {
                if (c.this.m) {
                    float x = c.this.f19560e.c().getX();
                    float y = c.this.f19560e.c().getY();
                    c.this.o = true;
                    c cVar = c.this;
                    cVar.p = cVar.e();
                    if (c.this.p) {
                        c.this.g();
                    }
                    c.a(c.this, x, y - r1.B);
                    if (c.this.f19560e.e() != null) {
                        c.this.f19560e.e().onMarkerDragStart(new Marker(c.this));
                    }
                }
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                if (c.this.m && c.this.o) {
                    return true;
                }
                c.this.f19561f.requestDisallowInterceptTouchEvent(false);
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final void onShowPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public final boolean onSingleTapUp(MotionEvent motionEvent) {
                c.this.n();
                if (c.this.f19560e.d() != null) {
                    c.this.f19560e.d().onMarkerClick(new Marker(c.this));
                    return true;
                }
                if (c.this.e()) {
                    c.this.g();
                } else {
                    c.this.f();
                }
                return true;
            }
        });
        q();
    }

    static /* synthetic */ void a(c cVar, float f2, float f3) {
        cVar.a(cVar.f19558c.b().a((int) f2, (int) f3));
    }

    private static boolean a(float f2, float f3, float f4) {
        return f2 > f3 && f2 <= f4;
    }

    static /* synthetic */ View b(c cVar, View view) {
        cVar.h = null;
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (this.g == null) {
            if (this.l == null) {
                if (f19557b == null) {
                    f19557b = BitmapDescriptorFactory.defaultMarker();
                }
                this.l = f19557b;
            }
            this.g = new ImageView(this.f19559d);
            ((ImageView) this.g).setImageBitmap(this.l.getBitmap());
        }
        this.g.measure(0, 0);
        b(this.u);
        a(this.t);
        this.f19561f.addView(this.g, s());
        if (!this.s || this.z == null) {
            r();
            return;
        }
        this.g.clearAnimation();
        this.z.setAnimationListener(new a() { // from class: com.tencent.mapsdk.rastercore.e.a.c.2
            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationEnd(Animation animation) {
                c.this.z.setAnimationListener(null);
                c.this.r();
            }
        });
        this.g.startAnimation(this.z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        this.g.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mapsdk.rastercore.e.a.c.3
            /* JADX WARN: Removed duplicated region for block: B:19:0x007a  */
            @Override // android.view.View.OnTouchListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final boolean onTouch(android.view.View r4, android.view.MotionEvent r5) {
                /*
                    Method dump skipped, instruction units count: 224
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mapsdk.rastercore.e.a.c.AnonymousClass3.onTouch(android.view.View, android.view.MotionEvent):boolean");
            }
        });
    }

    private MapView.LayoutParams s() {
        PointF pointFT = t();
        return new MapView.LayoutParams(-2, -2, this.w, -((int) pointFT.x), -((int) pointFT.y), 0);
    }

    private PointF t() {
        PointF pointF = new PointF();
        pointF.x = this.g.getMeasuredWidth() * this.q;
        pointF.y = this.g.getMeasuredHeight() * this.r;
        return pointF;
    }

    private PointF u() {
        PointF pointF = new PointF();
        PointF pointF2 = a(this.t, 45.0f, 135.0f) ? new PointF(WheelView.DividerConfig.FILL, this.g.getMeasuredHeight() * 0.5f) : a(this.t, 135.0f, 225.0f) ? new PointF(this.g.getMeasuredWidth() * 0.5f, this.g.getMeasuredHeight()) : a(this.t, 225.0f, 315.0f) ? new PointF(this.g.getMeasuredWidth(), this.g.getMeasuredHeight() * 0.5f) : new PointF(this.g.getMeasuredWidth() * 0.5f, WheelView.DividerConfig.FILL);
        PointF pointFT = t();
        float f2 = pointF2.x - pointFT.x;
        float f3 = (-pointF2.y) + pointFT.y;
        float fSqrt = (float) Math.sqrt((f2 * f2) + (f3 * f3));
        double dAtan = Math.atan(f2 / f3);
        if ((f2 > WheelView.DividerConfig.FILL && f3 < WheelView.DividerConfig.FILL) || (f2 < WheelView.DividerConfig.FILL && f3 < WheelView.DividerConfig.FILL)) {
            dAtan += 3.141592653589793d;
        }
        double d2 = this.t / 180.0f;
        Double.isNaN(d2);
        double d3 = dAtan + (d2 * 3.141592653589793d);
        double d4 = fSqrt;
        double dSin = Math.sin(d3);
        Double.isNaN(d4);
        pointF.x = (float) (dSin * d4);
        double dCos = Math.cos(d3);
        Double.isNaN(d4);
        pointF.y = -((float) (d4 * dCos));
        return pointF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        if (e()) {
            this.h.clearAnimation();
            this.f19561f.removeView(this.h);
            PointF pointFU = u();
            this.f19561f.addView(this.h, this.f19561f.indexOfChild(this.g) + 1, new MapView.LayoutParams(-2, -2, this.w, (int) pointFU.x, (int) pointFU.y, 81));
        }
    }

    private void w() {
        if (e()) {
            View view = this.h;
            if (view instanceof b) {
                ((b) view).a(this.x, this.v);
            }
        }
    }

    public final View a() {
        return this.g;
    }

    @SuppressLint({"NewApi"})
    public final void a(float f2) {
        float f3 = (f2 + 360.0f) % 360.0f;
        if (Build.VERSION.SDK_INT < 11) {
            RotateAnimation rotateAnimation = new RotateAnimation(this.t, f3, 1, this.q, 1, this.r);
            rotateAnimation.setFillAfter(true);
            rotateAnimation.setDuration(0L);
            this.g.clearAnimation();
            this.g.startAnimation(rotateAnimation);
        } else {
            PointF pointFT = t();
            this.g.setPivotX(pointFT.x);
            this.g.setPivotY(pointFT.y);
            this.g.setRotation(f3);
        }
        this.t = f3;
        v();
    }

    public final void a(float f2, float f3) {
        if (this.q == f2 && this.r == f3) {
            return;
        }
        this.q = f2;
        this.r = f3;
        this.g.setLayoutParams(s());
        a(this.t);
        v();
    }

    public final void a(final View view) {
        View view2 = this.g;
        if (view2 != null) {
            Animation animation = this.A;
            if (animation != null) {
                animation.setAnimationListener(new a() { // from class: com.tencent.mapsdk.rastercore.e.a.c.4
                    @Override // android.view.animation.Animation.AnimationListener
                    public final void onAnimationEnd(Animation animation2) {
                        new Handler().post(new Runnable() { // from class: com.tencent.mapsdk.rastercore.e.a.c.4.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                c.this.f19561f.removeView(c.this.g);
                                c.this.A.setAnimationListener(null);
                                AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                                c.this.g = view;
                                c.this.q();
                                c.this.v();
                            }
                        });
                    }
                });
                this.g.setOnTouchListener(null);
                this.g.startAnimation(this.A);
                return;
            }
            this.f19561f.removeView(view2);
        }
        this.g = view;
        q();
        v();
    }

    public final void a(Animation animation) {
        this.i = animation;
    }

    public final void a(BitmapDescriptor bitmapDescriptor) {
        this.l = bitmapDescriptor;
        View view = this.g;
        if (view == null || !(view instanceof ImageView)) {
            return;
        }
        ((ImageView) view).setImageBitmap(this.l.getBitmap());
        this.g.measure(0, 0);
        this.g.setLayoutParams(s());
    }

    public final void a(LatLng latLng) {
        if (latLng == null) {
            return;
        }
        this.w = latLng;
        ((MapView.LayoutParams) this.g.getLayoutParams()).setPoint(latLng);
        this.f19561f.layout(this.g);
        View view = this.h;
        if (view != null) {
            ((MapView.LayoutParams) view.getLayoutParams()).setPoint(latLng);
            this.f19561f.layout(this.h);
        }
    }

    public final void a(Object obj) {
        this.C = obj;
    }

    public final void a(String str) {
        this.v = str;
        w();
    }

    public final void a(boolean z) {
        this.g.setVisibility(z ? 0 : 8);
        if (!z && e()) {
            g();
        }
        this.s = z;
    }

    public final void b() {
        this.f19558c.e().c(m());
    }

    public final void b(float f2) {
        if (f2 < WheelView.DividerConfig.FILL) {
            f2 = WheelView.DividerConfig.FILL;
        } else if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        if (Build.VERSION.SDK_INT < 11) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(this.u, f2);
            alphaAnimation.setFillAfter(true);
            alphaAnimation.setDuration(0L);
            this.g.clearAnimation();
            this.g.startAnimation(alphaAnimation);
        } else {
            this.g.setAlpha(f2);
        }
        this.u = f2;
    }

    public final void b(Animation animation) {
        this.j = animation;
    }

    public final void b(String str) {
        this.x = str;
        w();
    }

    public final void b(boolean z) {
        this.m = z;
    }

    public final void c() {
        Animation animation = this.A;
        if (animation == null) {
            this.f19561f.removeView(this.g);
            this.f19561f.removeView(this.h);
        } else {
            animation.setAnimationListener(new a() { // from class: com.tencent.mapsdk.rastercore.e.a.c.5
                @Override // android.view.animation.Animation.AnimationListener
                public final void onAnimationEnd(Animation animation2) {
                    new Handler().post(new Runnable() { // from class: com.tencent.mapsdk.rastercore.e.a.c.5.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            c.this.f19561f.removeView(c.this.g);
                            c.this.f19561f.removeView(c.this.h);
                            c.this.A.setAnimationListener(null);
                        }
                    });
                }
            });
            this.g.setOnTouchListener(null);
            this.g.clearAnimation();
            this.g.startAnimation(this.A);
        }
    }

    public final boolean d() {
        return this.m;
    }

    public final boolean e() {
        View view = this.h;
        return (view == null || view.getParent() == null) ? false : true;
    }

    public final boolean equals(Object obj) {
        return obj != null && (obj instanceof c) && obj.hashCode() == hashCode() && ((c) obj).m().equals(m());
    }

    public final void f() {
        String str;
        String str2;
        View bVar;
        if (e()) {
            return;
        }
        if ((this.f19560e.g() == null || this.f19560e.g().getInfoWindow(new Marker(this)) == null) && (((str = this.x) == null || str.isEmpty()) && ((str2 = this.v) == null || str2.isEmpty()))) {
            return;
        }
        if (this.f19560e.g() != null) {
            bVar = this.f19560e.g().getInfoWindow(new Marker(this));
            if (bVar == null) {
                bVar = new b(this.f19559d, this.x, this.v);
            }
        } else {
            bVar = new b(this.f19559d, this.x, this.v);
        }
        this.h = bVar;
        t();
        PointF pointFU = u();
        StringBuilder sb = new StringBuilder();
        sb.append(pointFU.x);
        sb.append(", ");
        sb.append(pointFU.y);
        this.f19561f.addView(this.h, this.f19561f.indexOfChild(this.g) + 1, new MapView.LayoutParams(-2, -2, this.w, (int) pointFU.x, (int) pointFU.y, 81));
        Animation animation = this.i;
        Animation animation2 = animation;
        if (animation == null) {
            AnimationSet animationSet = new AnimationSet(false);
            ScaleAnimation scaleAnimation = new ScaleAnimation(WheelView.DividerConfig.FILL, 1.1f, WheelView.DividerConfig.FILL, 1.1f, 1, 0.5f, 1, 1.0f);
            scaleAnimation.setDuration(150L);
            scaleAnimation.setInterpolator(new AccelerateInterpolator());
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.0f, 0.9f, 1.0f, 0.9f, 1, 0.5f, 1, 1.0f);
            scaleAnimation2.setDuration(100L);
            scaleAnimation2.setInterpolator(new DecelerateInterpolator());
            scaleAnimation2.setStartOffset(150L);
            animationSet.addAnimation(scaleAnimation);
            animationSet.addAnimation(scaleAnimation2);
            animation2 = animationSet;
        }
        this.h.startAnimation(animation2);
        this.h.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mapsdk.rastercore.e.a.c.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (c.this.f19560e.f() != null) {
                    c.this.f19560e.f().onInfoWindowClick(new Marker(c.this));
                }
            }
        });
    }

    public final void g() {
        if (e()) {
            this.h.clearAnimation();
            Animation animation = this.j;
            Animation animation2 = animation;
            if (animation == null) {
                AnimationSet animationSet = new AnimationSet(true);
                animationSet.setInterpolator(new AccelerateInterpolator());
                animationSet.addAnimation(new AlphaAnimation(1.0f, WheelView.DividerConfig.FILL));
                animationSet.addAnimation(new ScaleAnimation(1.0f, WheelView.DividerConfig.FILL, 1.0f, WheelView.DividerConfig.FILL, 1, 0.5f, 1, 1.0f));
                animationSet.setDuration(100L);
                animation2 = animationSet;
            }
            animation2.setAnimationListener(new a() { // from class: com.tencent.mapsdk.rastercore.e.a.c.7
                @Override // android.view.animation.Animation.AnimationListener
                public final void onAnimationEnd(Animation animation3) {
                    new Handler().post(new Runnable() { // from class: com.tencent.mapsdk.rastercore.e.a.c.7.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            c.this.f19561f.removeView(c.this.h);
                            if (c.this.f19560e.g() != null) {
                                c.this.f19558c.h().g().onInfoWindowDettached(new Marker(c.this), c.this.h);
                            }
                            c.b(c.this, (View) null);
                        }
                    });
                }
            });
            this.h.startAnimation(animation2);
        }
    }

    public final String h() {
        return this.x;
    }

    public final int hashCode() {
        return m().hashCode();
    }

    public final String i() {
        return this.v;
    }

    public final float j() {
        return this.t;
    }

    public final boolean k() {
        return this.s;
    }

    public final LatLng l() {
        return this.w;
    }

    public final String m() {
        if (this.y == null) {
            f19556a++;
            this.y = "Marker" + f19556a;
        }
        return this.y;
    }

    public final void n() {
        if (Build.VERSION.SDK_INT < 11) {
            this.g.clearAnimation();
        }
        this.f19561f.removeView(this.g);
        this.f19561f.addView(this.g);
        v();
    }

    public final float o() {
        return this.u;
    }

    public final Object p() {
        return this.C;
    }
}
