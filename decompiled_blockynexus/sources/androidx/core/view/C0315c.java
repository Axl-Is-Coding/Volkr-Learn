package androidx.core.view;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: renamed from: androidx.core.view.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: GestureDetectorCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0315c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f1247a;

    /* JADX INFO: renamed from: androidx.core.view.c$a */
    /* JADX INFO: compiled from: GestureDetectorCompat.java */
    interface a {
        boolean onTouchEvent(MotionEvent motionEvent);
    }

    /* JADX INFO: renamed from: androidx.core.view.c$b */
    /* JADX INFO: compiled from: GestureDetectorCompat.java */
    static class b implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final int f1248a = ViewConfiguration.getLongPressTimeout();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final int f1249b = ViewConfiguration.getTapTimeout();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final int f1250c = ViewConfiguration.getDoubleTapTimeout();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f1251d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f1252e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f1253f;
        private int g;
        private final Handler h;
        final GestureDetector.OnGestureListener i;
        GestureDetector.OnDoubleTapListener j;
        boolean k;
        boolean l;
        private boolean m;
        private boolean n;
        private boolean o;
        MotionEvent p;
        private MotionEvent q;
        private boolean r;
        private float s;
        private float t;
        private float u;
        private float v;
        private boolean w;
        private VelocityTracker x;

        b(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            if (handler != null) {
                this.h = new a(handler);
            } else {
                this.h = new a();
            }
            this.i = onGestureListener;
            if (onGestureListener instanceof GestureDetector.OnDoubleTapListener) {
                a((GestureDetector.OnDoubleTapListener) onGestureListener);
            }
            a(context);
        }

        private void a(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null");
            }
            if (this.i == null) {
                throw new IllegalArgumentException("OnGestureListener must not be null");
            }
            this.w = true;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
            int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
            this.f1253f = viewConfiguration.getScaledMinimumFlingVelocity();
            this.g = viewConfiguration.getScaledMaximumFlingVelocity();
            this.f1251d = scaledTouchSlop * scaledTouchSlop;
            this.f1252e = scaledDoubleTapSlop * scaledDoubleTapSlop;
        }

        private void b() {
            this.h.removeMessages(1);
            this.h.removeMessages(2);
            this.h.removeMessages(3);
            this.x.recycle();
            this.x = null;
            this.r = false;
            this.k = false;
            this.n = false;
            this.o = false;
            this.l = false;
            if (this.m) {
                this.m = false;
            }
        }

        private void c() {
            this.h.removeMessages(1);
            this.h.removeMessages(2);
            this.h.removeMessages(3);
            this.r = false;
            this.n = false;
            this.o = false;
            this.l = false;
            if (this.m) {
                this.m = false;
            }
        }

        @Override // androidx.core.view.C0315c.a
        public boolean onTouchEvent(MotionEvent motionEvent) {
            boolean zOnDoubleTap;
            MotionEvent motionEvent2;
            boolean zOnFling;
            GestureDetector.OnDoubleTapListener onDoubleTapListener;
            int action = motionEvent.getAction();
            if (this.x == null) {
                this.x = VelocityTracker.obtain();
            }
            this.x.addMovement(motionEvent);
            int i = action & 255;
            boolean z = i == 6;
            int actionIndex = z ? motionEvent.getActionIndex() : -1;
            int pointerCount = motionEvent.getPointerCount();
            float x = WheelView.DividerConfig.FILL;
            float y = WheelView.DividerConfig.FILL;
            for (int i2 = 0; i2 < pointerCount; i2++) {
                if (actionIndex != i2) {
                    x += motionEvent.getX(i2);
                    y += motionEvent.getY(i2);
                }
            }
            float f2 = z ? pointerCount - 1 : pointerCount;
            float f3 = x / f2;
            float f4 = y / f2;
            if (i == 0) {
                if (this.j == null) {
                    zOnDoubleTap = false;
                } else {
                    boolean zHasMessages = this.h.hasMessages(3);
                    if (zHasMessages) {
                        this.h.removeMessages(3);
                    }
                    MotionEvent motionEvent3 = this.p;
                    if (motionEvent3 == null || (motionEvent2 = this.q) == null || !zHasMessages || !a(motionEvent3, motionEvent2, motionEvent)) {
                        this.h.sendEmptyMessageDelayed(3, f1250c);
                        zOnDoubleTap = false;
                    } else {
                        this.r = true;
                        zOnDoubleTap = this.j.onDoubleTap(this.p) | false | this.j.onDoubleTapEvent(motionEvent);
                    }
                }
                this.s = f3;
                this.u = f3;
                this.t = f4;
                this.v = f4;
                MotionEvent motionEvent4 = this.p;
                if (motionEvent4 != null) {
                    motionEvent4.recycle();
                }
                this.p = MotionEvent.obtain(motionEvent);
                this.n = true;
                this.o = true;
                this.k = true;
                this.m = false;
                this.l = false;
                if (this.w) {
                    this.h.removeMessages(2);
                    this.h.sendEmptyMessageAtTime(2, this.p.getDownTime() + ((long) f1249b) + ((long) f1248a));
                }
                this.h.sendEmptyMessageAtTime(1, this.p.getDownTime() + ((long) f1249b));
                return zOnDoubleTap | this.i.onDown(motionEvent);
            }
            if (i == 1) {
                this.k = false;
                MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                if (this.r) {
                    zOnFling = this.j.onDoubleTapEvent(motionEvent) | false;
                } else {
                    if (this.m) {
                        this.h.removeMessages(3);
                        this.m = false;
                    } else if (this.n) {
                        boolean zOnSingleTapUp = this.i.onSingleTapUp(motionEvent);
                        if (this.l && (onDoubleTapListener = this.j) != null) {
                            onDoubleTapListener.onSingleTapConfirmed(motionEvent);
                        }
                        zOnFling = zOnSingleTapUp;
                    } else {
                        VelocityTracker velocityTracker = this.x;
                        int pointerId = motionEvent.getPointerId(0);
                        velocityTracker.computeCurrentVelocity(1000, this.g);
                        float yVelocity = velocityTracker.getYVelocity(pointerId);
                        float xVelocity = velocityTracker.getXVelocity(pointerId);
                        if (Math.abs(yVelocity) > this.f1253f || Math.abs(xVelocity) > this.f1253f) {
                            zOnFling = this.i.onFling(this.p, motionEvent, xVelocity, yVelocity);
                        }
                    }
                    zOnFling = false;
                }
                MotionEvent motionEvent5 = this.q;
                if (motionEvent5 != null) {
                    motionEvent5.recycle();
                }
                this.q = motionEventObtain;
                VelocityTracker velocityTracker2 = this.x;
                if (velocityTracker2 != null) {
                    velocityTracker2.recycle();
                    this.x = null;
                }
                this.r = false;
                this.l = false;
                this.h.removeMessages(1);
                this.h.removeMessages(2);
            } else {
                if (i != 2) {
                    if (i == 3) {
                        b();
                        return false;
                    }
                    if (i == 5) {
                        this.s = f3;
                        this.u = f3;
                        this.t = f4;
                        this.v = f4;
                        c();
                        return false;
                    }
                    if (i != 6) {
                        return false;
                    }
                    this.s = f3;
                    this.u = f3;
                    this.t = f4;
                    this.v = f4;
                    this.x.computeCurrentVelocity(1000, this.g);
                    int actionIndex2 = motionEvent.getActionIndex();
                    int pointerId2 = motionEvent.getPointerId(actionIndex2);
                    float xVelocity2 = this.x.getXVelocity(pointerId2);
                    float yVelocity2 = this.x.getYVelocity(pointerId2);
                    for (int i3 = 0; i3 < pointerCount; i3++) {
                        if (i3 != actionIndex2) {
                            int pointerId3 = motionEvent.getPointerId(i3);
                            if ((this.x.getXVelocity(pointerId3) * xVelocity2) + (this.x.getYVelocity(pointerId3) * yVelocity2) < WheelView.DividerConfig.FILL) {
                                this.x.clear();
                                return false;
                            }
                        }
                    }
                    return false;
                }
                if (this.m) {
                    return false;
                }
                float f5 = this.s - f3;
                float f6 = this.t - f4;
                if (this.r) {
                    return false | this.j.onDoubleTapEvent(motionEvent);
                }
                if (!this.n) {
                    if (Math.abs(f5) < 1.0f && Math.abs(f6) < 1.0f) {
                        return false;
                    }
                    boolean zOnScroll = this.i.onScroll(this.p, motionEvent, f5, f6);
                    this.s = f3;
                    this.t = f4;
                    return zOnScroll;
                }
                int i4 = (int) (f3 - this.u);
                int i5 = (int) (f4 - this.v);
                int i6 = (i4 * i4) + (i5 * i5);
                if (i6 > this.f1251d) {
                    zOnFling = this.i.onScroll(this.p, motionEvent, f5, f6);
                    this.s = f3;
                    this.t = f4;
                    this.n = false;
                    this.h.removeMessages(3);
                    this.h.removeMessages(1);
                    this.h.removeMessages(2);
                } else {
                    zOnFling = false;
                }
                if (i6 > this.f1251d) {
                    this.o = false;
                }
            }
            return zOnFling;
        }

        /* JADX INFO: renamed from: androidx.core.view.c$b$a */
        /* JADX INFO: compiled from: GestureDetectorCompat.java */
        private class a extends Handler {
            a() {
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i = message.what;
                if (i == 1) {
                    b bVar = b.this;
                    bVar.i.onShowPress(bVar.p);
                    return;
                }
                if (i == 2) {
                    b.this.a();
                    return;
                }
                if (i != 3) {
                    throw new RuntimeException("Unknown message " + message);
                }
                b bVar2 = b.this;
                GestureDetector.OnDoubleTapListener onDoubleTapListener = bVar2.j;
                if (onDoubleTapListener != null) {
                    if (bVar2.k) {
                        bVar2.l = true;
                    } else {
                        onDoubleTapListener.onSingleTapConfirmed(bVar2.p);
                    }
                }
            }

            a(Handler handler) {
                super(handler.getLooper());
            }
        }

        public void a(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
            this.j = onDoubleTapListener;
        }

        private boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
            if (!this.o || motionEvent3.getEventTime() - motionEvent2.getEventTime() > f1250c) {
                return false;
            }
            int x = ((int) motionEvent.getX()) - ((int) motionEvent3.getX());
            int y = ((int) motionEvent.getY()) - ((int) motionEvent3.getY());
            return (x * x) + (y * y) < this.f1252e;
        }

        void a() {
            this.h.removeMessages(3);
            this.l = false;
            this.m = true;
            this.i.onLongPress(this.p);
        }
    }

    /* JADX INFO: renamed from: androidx.core.view.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: GestureDetectorCompat.java */
    static class C0018c implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final GestureDetector f1255a;

        C0018c(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            this.f1255a = new GestureDetector(context, onGestureListener, handler);
        }

        @Override // androidx.core.view.C0315c.a
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return this.f1255a.onTouchEvent(motionEvent);
        }
    }

    public C0315c(Context context, GestureDetector.OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
    }

    public boolean a(MotionEvent motionEvent) {
        return this.f1247a.onTouchEvent(motionEvent);
    }

    public C0315c(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        if (Build.VERSION.SDK_INT > 17) {
            this.f1247a = new C0018c(context, onGestureListener, handler);
        } else {
            this.f1247a = new b(context, onGestureListener, handler);
        }
    }
}
