package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import com.google.android.gms.common.util.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@TargetApi(14)
public final class zzqq implements Application.ActivityLifecycleCallbacks, View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    private static final long zzbri = ((Long) zzwm.zzpx().zzd(zzabb.zzcpu)).longValue();
    private final Context zzaai;
    private final PowerManager zzaaj;
    private final KeyguardManager zzaak;
    private WeakReference<ViewTreeObserver> zzaam;
    private final WindowManager zzbrj;

    @VisibleForTesting
    private BroadcastReceiver zzbrk;
    private WeakReference<View> zzbrl;
    private zzqt zzbrm;
    private final Rect zzbrq;
    private final DisplayMetrics zzxd;
    private Application zzyh;
    private zzbaw zzbrn = new zzbaw(zzbri);
    private boolean zzbro = false;
    private int zzaaq = -1;
    private final HashSet<zzqu> zzbrp = new HashSet<>();

    public zzqq(Context context, View view) {
        this.zzaai = context.getApplicationContext();
        this.zzbrj = (WindowManager) context.getSystemService("window");
        this.zzaaj = (PowerManager) this.zzaai.getSystemService("power");
        this.zzaak = (KeyguardManager) context.getSystemService("keyguard");
        Context context2 = this.zzaai;
        if (context2 instanceof Application) {
            this.zzyh = (Application) context2;
            this.zzbrm = new zzqt((Application) context2, this);
        }
        this.zzxd = context.getResources().getDisplayMetrics();
        this.zzbrq = new Rect();
        this.zzbrq.right = this.zzbrj.getDefaultDisplay().getWidth();
        this.zzbrq.bottom = this.zzbrj.getDefaultDisplay().getHeight();
        WeakReference<View> weakReference = this.zzbrl;
        View view2 = weakReference != null ? weakReference.get() : null;
        if (view2 != null) {
            view2.removeOnAttachStateChangeListener(this);
            zzg(view2);
        }
        this.zzbrl = new WeakReference<>(view);
        if (view != null) {
            if (com.google.android.gms.ads.internal.zzp.zzkt().isAttachedToWindow(view)) {
                zzf(view);
            }
            view.addOnAttachStateChangeListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzbu(int i) {
        WeakReference<View> weakReference;
        boolean z;
        boolean z2;
        if (this.zzbrp.size() == 0 || (weakReference = this.zzbrl) == null) {
            return;
        }
        View view = weakReference.get();
        boolean z3 = i == 1;
        boolean z4 = view == null;
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        Rect rect3 = new Rect();
        Rect rect4 = new Rect();
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        if (view != null) {
            boolean globalVisibleRect = view.getGlobalVisibleRect(rect2);
            boolean localVisibleRect = view.getLocalVisibleRect(rect3);
            view.getHitRect(rect4);
            try {
                view.getLocationOnScreen(iArr);
                view.getLocationInWindow(iArr2);
            } catch (Exception e2) {
                zzbbq.zzc("Failure getting view location.", e2);
            }
            rect.left = iArr[0];
            rect.top = iArr[1];
            rect.right = rect.left + view.getWidth();
            rect.bottom = rect.top + view.getHeight();
            z = globalVisibleRect;
            z2 = localVisibleRect;
        } else {
            z = false;
            z2 = false;
        }
        List<Rect> listEmptyList = (!((Boolean) zzwm.zzpx().zzd(zzabb.zzcpx)).booleanValue() || view == null) ? Collections.emptyList() : zzi(view);
        int windowVisibility = view != null ? view.getWindowVisibility() : 8;
        int i2 = this.zzaaq;
        if (i2 != -1) {
            windowVisibility = i2;
        }
        boolean z5 = !z4 && com.google.android.gms.ads.internal.zzp.zzkr().zza(view, this.zzaaj, this.zzaak) && z && z2 && windowVisibility == 0;
        if (z3 && !this.zzbrn.tryAcquire() && z5 == this.zzbro) {
            return;
        }
        if (z5 || this.zzbro || i != 1) {
            zzqr zzqrVar = new zzqr(com.google.android.gms.ads.internal.zzp.zzky().elapsedRealtime(), this.zzaaj.isScreenOn(), view != null && com.google.android.gms.ads.internal.zzp.zzkt().isAttachedToWindow(view), view != null ? view.getWindowVisibility() : 8, zza(this.zzbrq), zza(rect), zza(rect2), z, zza(rect3), z2, zza(rect4), this.zzxd.density, z5, listEmptyList);
            Iterator<zzqu> it = this.zzbrp.iterator();
            while (it.hasNext()) {
                it.next().zza(zzqrVar);
            }
            this.zzbro = z5;
        }
    }

    private final int zzbv(int i) {
        return (int) (i / this.zzxd.density);
    }

    private final void zzct() {
        zzayu.zzeba.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzqp
            private final zzqq zzbrh;

            {
                this.zzbrh = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzbrh.zzlx();
            }
        });
    }

    private final void zzf(View view) {
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            this.zzaam = new WeakReference<>(viewTreeObserver);
            viewTreeObserver.addOnScrollChangedListener(this);
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        if (this.zzbrk == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            this.zzbrk = new zzqs(this);
            com.google.android.gms.ads.internal.zzp.zzlm().zza(this.zzaai, this.zzbrk, intentFilter);
        }
        Application application = this.zzyh;
        if (application != null) {
            try {
                application.registerActivityLifecycleCallbacks(this.zzbrm);
            } catch (Exception e2) {
                zzbbq.zzc("Error registering activity lifecycle callbacks.", e2);
            }
        }
    }

    private final void zzg(View view) {
        try {
            if (this.zzaam != null) {
                ViewTreeObserver viewTreeObserver = this.zzaam.get();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnScrollChangedListener(this);
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                this.zzaam = null;
            }
        } catch (Exception e2) {
            zzbbq.zzc("Error while unregistering listeners from the last ViewTreeObserver.", e2);
        }
        try {
            ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            if (viewTreeObserver2.isAlive()) {
                viewTreeObserver2.removeOnScrollChangedListener(this);
                viewTreeObserver2.removeGlobalOnLayoutListener(this);
            }
        } catch (Exception e3) {
            zzbbq.zzc("Error while unregistering listeners from the ViewTreeObserver.", e3);
        }
        if (this.zzbrk != null) {
            try {
                com.google.android.gms.ads.internal.zzp.zzlm().zza(this.zzaai, this.zzbrk);
            } catch (IllegalStateException e4) {
                zzbbq.zzc("Failed trying to unregister the receiver", e4);
            } catch (Exception e5) {
                com.google.android.gms.ads.internal.zzp.zzkv().zza(e5, "ActiveViewUnit.stopScreenStatusMonitoring");
            }
            this.zzbrk = null;
        }
        Application application = this.zzyh;
        if (application != null) {
            try {
                application.unregisterActivityLifecycleCallbacks(this.zzbrm);
            } catch (Exception e6) {
                zzbbq.zzc("Error registering activity lifecycle callbacks.", e6);
            }
        }
    }

    private final List<Rect> zzi(View view) {
        try {
            ArrayList arrayList = new ArrayList();
            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                View view2 = (View) parent;
                Rect rect = new Rect();
                if (view2.isScrollContainer() && view2.getGlobalVisibleRect(rect)) {
                    arrayList.add(zza(rect));
                }
            }
            return arrayList;
        } catch (Exception e2) {
            com.google.android.gms.ads.internal.zzp.zzkv().zza(e2, "PositionWatcher.getParentScrollViewRects");
            return Collections.emptyList();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(activity, 0);
        zzbu(3);
        zzct();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        zzbu(3);
        zzct();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        zza(activity, 4);
        zzbu(3);
        zzct();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        zza(activity, 0);
        zzbu(3);
        zzct();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zzbu(3);
        zzct();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        zza(activity, 0);
        zzbu(3);
        zzct();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        zzbu(3);
        zzct();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        zzbu(2);
        zzct();
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        zzbu(1);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.zzaaq = -1;
        zzf(view);
        zzbu(3);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.zzaaq = -1;
        zzbu(3);
        zzct();
        zzg(view);
    }

    public final void zza(zzqu zzquVar) {
        this.zzbrp.add(zzquVar);
        zzbu(3);
    }

    public final void zzb(zzqu zzquVar) {
        this.zzbrp.remove(zzquVar);
    }

    public final void zzen(long j) {
        this.zzbrn.zzfb(j);
    }

    public final void zzlw() {
        this.zzbrn.zzfb(zzbri);
    }

    final /* synthetic */ void zzlx() {
        zzbu(3);
    }

    private final void zza(Activity activity, int i) {
        Window window;
        if (this.zzbrl == null || (window = activity.getWindow()) == null) {
            return;
        }
        View viewPeekDecorView = window.peekDecorView();
        View view = this.zzbrl.get();
        if (view == null || viewPeekDecorView == null || view.getRootView() != viewPeekDecorView.getRootView()) {
            return;
        }
        this.zzaaq = i;
    }

    private final Rect zza(Rect rect) {
        return new Rect(zzbv(rect.left), zzbv(rect.top), zzbv(rect.right), zzbv(rect.bottom));
    }
}
