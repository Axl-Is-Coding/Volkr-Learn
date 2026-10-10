package com.tencent.mapsdk.rastercore.d;

import android.graphics.Point;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Scroller;
import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.tencentmap.mapsdk.map.CancelableCallback;
import com.tencent.tencentmap.mapsdk.map.TencentMap;

/* JADX INFO: loaded from: classes5.dex */
public final class g implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, View.OnKeyListener {
    private Point B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private f f19534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b f19535b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f19536c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private MotionEvent f19538e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TencentMap.OnMapClickListener f19539f;
    private TencentMap.OnMapLongClickListener g;
    private TencentMap.OnMapCameraChangeListener h;
    private TencentMap.OnInfoWindowClickListener i;
    private TencentMap.InfoWindowAdapter j;
    private TencentMap.OnMarkerDraggedListener k;
    private TencentMap.OnMarkerClickListener l;
    private int t;
    private int u;
    private long v;
    private float w;
    private float x;
    private float y;
    private float z;
    private float m = 1.0f;
    private float n = 1.0f;
    private float o = 1.0f;
    private boolean p = false;
    private boolean q = false;
    private boolean r = false;
    private long A = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private GestureDetector f19537d = new GestureDetector(f.a().getApplicationContext(), this);
    private Scroller s = new Scroller(f.a());

    public g(f fVar) {
        this.t = 0;
        this.u = 0;
        this.f19534a = fVar;
        this.f19535b = fVar.c();
        this.f19536c = fVar.e();
        new DisplayMetrics();
        DisplayMetrics displayMetrics = f.a().getApplicationContext().getResources().getDisplayMetrics();
        this.t = displayMetrics.widthPixels / 2;
        this.u = displayMetrics.heightPixels / 2;
    }

    static /* synthetic */ boolean a(g gVar, boolean z) {
        gVar.q = false;
        return false;
    }

    private static float c(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        StringBuilder sb = new StringBuilder("event0.x:");
        sb.append(motionEvent.getX(0));
        sb.append(",event0.y:");
        sb.append(motionEvent.getY(0));
        sb.append(";  event1.x:");
        sb.append(motionEvent.getX(1));
        sb.append(",event1.y:");
        sb.append(motionEvent.getY(1));
        return (float) Math.sqrt((x * x) + (y * y));
    }

    public final void a() {
        if (this.s.computeScrollOffset()) {
            int currX = this.s.getCurrX() - this.t;
            int currY = this.s.getCurrY() - this.u;
            this.t = this.s.getCurrX();
            this.u = this.s.getCurrY();
            this.f19535b.scrollBy(currX, currY);
            if (this.s.isFinished()) {
                if (this.h != null) {
                    a(true);
                }
            } else if (Math.abs(currX) < 6) {
                Math.abs(currY);
            }
            this.f19534a.a(false, false);
        }
    }

    public final void a(TencentMap.InfoWindowAdapter infoWindowAdapter) {
        this.j = infoWindowAdapter;
    }

    public final void a(TencentMap.OnInfoWindowClickListener onInfoWindowClickListener) {
        this.i = onInfoWindowClickListener;
    }

    public final void a(TencentMap.OnMapCameraChangeListener onMapCameraChangeListener) {
        this.h = onMapCameraChangeListener;
    }

    public final void a(TencentMap.OnMapClickListener onMapClickListener) {
        this.f19539f = onMapClickListener;
    }

    public final void a(TencentMap.OnMapLongClickListener onMapLongClickListener) {
        this.g = onMapLongClickListener;
    }

    public final void a(TencentMap.OnMarkerClickListener onMarkerClickListener) {
        this.l = onMarkerClickListener;
    }

    public final void a(TencentMap.OnMarkerDraggedListener onMarkerDraggedListener) {
        this.k = onMarkerDraggedListener;
    }

    public final void a(boolean z) {
        if (this.h != null) {
            CameraPosition cameraPositionD = this.f19534a.b().d();
            if (z) {
                this.h.onCameraChangeFinish(cameraPositionD);
                this.r = false;
            } else {
                this.h.onCameraChange(cameraPositionD);
                this.r = true;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0259  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(android.view.MotionEvent r24) {
        /*
            Method dump skipped, instruction units count: 615
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mapsdk.rastercore.d.g.a(android.view.MotionEvent):boolean");
    }

    public final void b() {
        this.s.abortAnimation();
    }

    public final void b(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = this.f19538e;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        this.f19538e = motionEvent;
        if (this.f19538e.getAction() == 0) {
            if (this.B == null) {
                this.B = new Point();
            }
            this.B.x = (int) this.f19538e.getX();
            this.B.y = (int) this.f19538e.getY();
        }
    }

    public final MotionEvent c() {
        return this.f19538e;
    }

    public final TencentMap.OnMarkerClickListener d() {
        return this.l;
    }

    public final TencentMap.OnMarkerDraggedListener e() {
        return this.k;
    }

    public final TencentMap.OnInfoWindowClickListener f() {
        return this.i;
    }

    public final TencentMap.InfoWindowAdapter g() {
        return this.j;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTap(MotionEvent motionEvent) {
        if (!this.f19534a.f().i()) {
            return true;
        }
        this.f19535b.d().a(this.f19534a.f().a() >= 3 && (this.f19534a.f().b() > 1.0f ? 1 : (this.f19534a.f().b() == 1.0f ? 0 : -1)) > 0 ? 1.3d : 1.0d);
        if (this.f19535b.d().a() < this.f19534a.b().i().a()) {
            this.f19535b.a(new PointF(motionEvent.getX(), motionEvent.getY()), true, (CancelableCallback) null);
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent motionEvent) {
        this.p = false;
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        this.p = false;
        if (!this.f19534a.f().h()) {
            return true;
        }
        Scroller scroller = this.s;
        int i = this.t;
        int i2 = this.u;
        double d2 = -f2;
        Double.isNaN(d2);
        double d3 = -f3;
        Double.isNaN(d3);
        scroller.fling(i, i2, (int) (d2 * 0.6d), (int) (d3 * 0.6d), -2147483647, Integer.MAX_VALUE, -2147483647, Integer.MAX_VALUE);
        this.f19534a.a(false, false);
        return true;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        switch (i) {
            case 19:
                this.f19535b.scrollBy(0, -10);
                return true;
            case 20:
                this.f19535b.scrollBy(0, 10);
                return true;
            case 21:
                this.f19535b.scrollBy(-10, 0);
                return true;
            case 22:
                this.f19535b.scrollBy(10, 0);
                return true;
            default:
                return false;
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent motionEvent) {
        this.p = false;
        LatLng latLngA = this.f19534a.b().a((int) motionEvent.getX(), (int) motionEvent.getY());
        this.f19536c.a(com.tencent.mapsdk.rastercore.f.b.a(latLngA), motionEvent);
        TencentMap.OnMapLongClickListener onMapLongClickListener = this.g;
        if (onMapLongClickListener != null) {
            onMapLongClickListener.onMapLongClick(latLngA);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        if (!this.f19534a.f().h()) {
            this.p = false;
            return true;
        }
        if (this.q || motionEvent2.getEventTime() - this.A < 30) {
            return true;
        }
        this.p = true;
        int x = (int) this.f19538e.getX();
        int y = (int) this.f19538e.getY();
        Point point = this.B;
        if (point == null) {
            this.B = new Point();
            Point point2 = this.B;
            point2.x = x;
            point2.y = y;
        } else {
            this.f19535b.scrollBy(point.x - x, point.y - y);
            Point point3 = this.B;
            point3.x = x;
            point3.y = y;
            a(false);
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        this.p = false;
        try {
            LatLng latLngA = this.f19534a.b().a((int) motionEvent.getX(), (int) motionEvent.getY());
            if (!this.f19536c.a(com.tencent.mapsdk.rastercore.f.b.a(latLngA)) && this.f19539f != null) {
                this.f19539f.onMapClick(latLngA);
                this.f19534a.d().setFocusable(true);
                this.f19534a.d().setFocusableInTouchMode(true);
                this.f19534a.d().requestFocus();
                InputMethodManager inputMethodManager = (InputMethodManager) f.a().getSystemService("input_method");
                if (inputMethodManager.isActive()) {
                    inputMethodManager.hideSoftInputFromWindow(this.f19534a.d().getWindowToken(), 0);
                }
            }
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return true;
        }
    }
}
