package androidx.appcompat.widget;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: TooltipCompatHandler.java */
/* JADX INFO: loaded from: classes.dex */
class qa implements View.OnAttachStateChangeListener, View.OnHoverListener, View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static qa f687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static qa f688b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final View f689c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CharSequence f690d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f691e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Runnable f692f = new oa(this);
    private final Runnable g = new pa(this);
    private int h;
    private int i;
    private ra j;
    private boolean k;

    private qa(View view, CharSequence charSequence) {
        this.f689c = view;
        this.f690d = charSequence;
        this.f691e = androidx.core.view.A.a(ViewConfiguration.get(this.f689c.getContext()));
        c();
        this.f689c.setOnLongClickListener(this);
        this.f689c.setOnHoverListener(this);
    }

    public static void a(View view, CharSequence charSequence) {
        qa qaVar = f687a;
        if (qaVar != null && qaVar.f689c == view) {
            a((qa) null);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            new qa(view, charSequence);
            return;
        }
        qa qaVar2 = f688b;
        if (qaVar2 != null && qaVar2.f689c == view) {
            qaVar2.a();
        }
        view.setOnLongClickListener(null);
        view.setLongClickable(false);
        view.setOnHoverListener(null);
    }

    private void b() {
        this.f689c.removeCallbacks(this.f692f);
    }

    private void c() {
        this.h = Integer.MAX_VALUE;
        this.i = Integer.MAX_VALUE;
    }

    private void d() {
        this.f689c.postDelayed(this.f692f, ViewConfiguration.getLongPressTimeout());
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.j != null && this.k) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f689c.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                c();
                a();
            }
        } else if (this.f689c.isEnabled() && this.j == null && a(motionEvent)) {
            a(this);
        }
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.h = view.getWidth() / 2;
        this.i = view.getHeight() / 2;
        a(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        a();
    }

    void a(boolean z) {
        long j;
        int longPressTimeout;
        long j2;
        if (ViewCompat.B(this.f689c)) {
            a((qa) null);
            qa qaVar = f688b;
            if (qaVar != null) {
                qaVar.a();
            }
            f688b = this;
            this.k = z;
            this.j = new ra(this.f689c.getContext());
            this.j.a(this.f689c, this.h, this.i, this.k, this.f690d);
            this.f689c.addOnAttachStateChangeListener(this);
            if (this.k) {
                j2 = 2500;
            } else {
                if ((ViewCompat.v(this.f689c) & 1) == 1) {
                    j = 3000;
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                } else {
                    j = 15000;
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                }
                j2 = j - ((long) longPressTimeout);
            }
            this.f689c.removeCallbacks(this.g);
            this.f689c.postDelayed(this.g, j2);
        }
    }

    void a() {
        if (f688b == this) {
            f688b = null;
            ra raVar = this.j;
            if (raVar != null) {
                raVar.a();
                this.j = null;
                c();
                this.f689c.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f687a == this) {
            a((qa) null);
        }
        this.f689c.removeCallbacks(this.g);
    }

    private static void a(qa qaVar) {
        qa qaVar2 = f687a;
        if (qaVar2 != null) {
            qaVar2.b();
        }
        f687a = qaVar;
        qa qaVar3 = f687a;
        if (qaVar3 != null) {
            qaVar3.d();
        }
    }

    private boolean a(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (Math.abs(x - this.h) <= this.f691e && Math.abs(y - this.i) <= this.f691e) {
            return false;
        }
        this.h = x;
        this.i = y;
        return true;
    }
}
