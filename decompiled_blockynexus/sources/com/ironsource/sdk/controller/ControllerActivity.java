package com.ironsource.sdk.controller;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import b.f.d.a.g;
import com.facebook.internal.ServerProtocol;
import com.ironsource.sdk.controller.WebController;
import com.ironsource.sdk.data.SSAEnums$ProductType;
import io.rong.common.LibStorageUtils;

/* JADX INFO: loaded from: classes2.dex */
public class ControllerActivity extends Activity implements b.f.d.g.g, InterfaceC2398ha {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f15129a = "ControllerActivity";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f15130b = "removeWebViewContainerView | mContainer is null";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f15131c = "removeWebViewContainerView | view is null";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f15132d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private WebController f15134f;
    private RelativeLayout g;
    private FrameLayout h;
    private String n;
    private com.ironsource.sdk.data.c o;
    private boolean p;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f15133e = -1;
    private boolean i = false;
    private Handler j = new Handler();
    private final Runnable k = new RunnableC2389d(this);
    final RelativeLayout.LayoutParams l = new RelativeLayout.LayoutParams(-1, -1);
    private boolean m = false;

    private void e() {
        runOnUiThread(new RunnableC2395g(this));
    }

    private void f() {
        if (this.f15134f != null) {
            com.ironsource.sdk.utils.f.c(f15129a, "clearWebviewController");
            this.f15134f.setState(WebController.State.Gone);
            this.f15134f.removeVideoEventsListener();
            this.f15134f.notifyLifeCycle(this.n, "onDestroy");
        }
    }

    private void g() {
        requestWindowFeature(1);
    }

    private void h() {
        getWindow().setFlags(1024, 1024);
    }

    private void i() {
        Intent intent = getIntent();
        a(intent.getStringExtra("orientation_set_flag"), intent.getIntExtra("rotation_set_flag", 0));
    }

    private boolean j() {
        return this.f15132d == null;
    }

    private void k() {
        runOnUiThread(new RunnableC2393f(this));
    }

    private void l() {
        int iD = com.ironsource.environment.b.d(this);
        com.ironsource.sdk.utils.f.c(f15129a, "setInitiateLandscapeOrientation");
        if (iD == 0) {
            com.ironsource.sdk.utils.f.c(f15129a, "ROTATION_0");
            setRequestedOrientation(0);
            return;
        }
        if (iD == 2) {
            com.ironsource.sdk.utils.f.c(f15129a, "ROTATION_180");
            setRequestedOrientation(8);
        } else if (iD == 3) {
            com.ironsource.sdk.utils.f.c(f15129a, "ROTATION_270 Right Landscape");
            setRequestedOrientation(8);
        } else if (iD != 1) {
            com.ironsource.sdk.utils.f.c(f15129a, "No Rotation");
        } else {
            com.ironsource.sdk.utils.f.c(f15129a, "ROTATION_90 Left Landscape");
            setRequestedOrientation(0);
        }
    }

    private void m() {
        int iD = com.ironsource.environment.b.d(this);
        com.ironsource.sdk.utils.f.c(f15129a, "setInitiatePortraitOrientation");
        if (iD == 0) {
            com.ironsource.sdk.utils.f.c(f15129a, "ROTATION_0");
            setRequestedOrientation(1);
            return;
        }
        if (iD == 2) {
            com.ironsource.sdk.utils.f.c(f15129a, "ROTATION_180");
            setRequestedOrientation(9);
        } else if (iD == 1) {
            com.ironsource.sdk.utils.f.c(f15129a, "ROTATION_270 Right Landscape");
            setRequestedOrientation(1);
        } else if (iD != 3) {
            com.ironsource.sdk.utils.f.c(f15129a, "No Rotation");
        } else {
            com.ironsource.sdk.utils.f.c(f15129a, "ROTATION_90 Left Landscape");
            setRequestedOrientation(1);
        }
    }

    @Override // com.ironsource.sdk.controller.InterfaceC2398ha
    public void d() {
        a(true);
    }

    @Override // b.f.d.g.g
    public boolean onBackButtonPressed() {
        onBackPressed();
        return true;
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        com.ironsource.sdk.utils.f.c(f15129a, "onBackPressed");
        if (b.f.d.f.b.a().a(this)) {
            return;
        }
        super.onBackPressed();
    }

    @Override // b.f.d.g.g
    public void onCloseRequested() {
        finish();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            com.ironsource.sdk.utils.f.c(f15129a, "onCreate");
            g();
            h();
            this.f15134f = (WebController) b.f.d.c.p.c(this).a().f();
            this.f15134f.getLayout().setId(1);
            this.f15134f.setOnWebViewControllerChangeListener(this);
            this.f15134f.setVideoEventsListener(this);
            Intent intent = getIntent();
            this.n = intent.getStringExtra("productType");
            this.i = intent.getBooleanExtra("immersive", false);
            this.f15132d = intent.getStringExtra("adViewId");
            this.p = false;
            if (this.i) {
                getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new ViewOnSystemUiVisibilityChangeListenerC2391e(this));
                runOnUiThread(this.k);
            }
            if (!TextUtils.isEmpty(this.n) && SSAEnums$ProductType.OfferWall.toString().equalsIgnoreCase(this.n)) {
                if (bundle != null) {
                    com.ironsource.sdk.data.c cVar = (com.ironsource.sdk.data.c) bundle.getParcelable(ServerProtocol.DIALOG_PARAM_STATE);
                    if (cVar != null) {
                        this.o = cVar;
                        this.f15134f.restoreState(cVar);
                    }
                    finish();
                } else {
                    this.o = this.f15134f.getSavedState();
                }
            }
            this.g = new RelativeLayout(this);
            setContentView(this.g, this.l);
            this.h = a(this.f15132d);
            if (this.g.findViewById(1) == null && this.h.getParent() != null) {
                this.m = true;
                finish();
            }
            i();
        } catch (Exception e2) {
            e2.printStackTrace();
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        com.ironsource.sdk.utils.f.c(f15129a, "onDestroy");
        if (this.m) {
            b(true);
        }
        if (this.p) {
            return;
        }
        com.ironsource.sdk.utils.f.c(f15129a, "onDestroy | destroyedFromBackground");
        f();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.f15134f.inCustomView()) {
            this.f15134f.hideCustomView();
            return true;
        }
        if (this.i && (i == 25 || i == 24)) {
            this.j.removeCallbacks(this.k);
            this.j.postDelayed(this.k, 500L);
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // b.f.d.g.g
    public void onOrientationChanged(String str, int i) {
        a(str, i);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        com.ironsource.sdk.utils.f.c(f15129a, "onPause");
        boolean zIsFinishing = isFinishing();
        ((AudioManager) getSystemService(LibStorageUtils.AUDIO)).abandonAudioFocus(null);
        WebController webController = this.f15134f;
        if (webController != null) {
            webController.unregisterConnectionReceiver(this);
            this.f15134f.pause();
            this.f15134f.viewableChange(false, "main");
        }
        b(zIsFinishing);
        if (zIsFinishing) {
            this.p = true;
            com.ironsource.sdk.utils.f.c(f15129a, "onPause | isFinishing");
            f();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        com.ironsource.sdk.utils.f.c(f15129a, "onResume");
        this.g.addView(this.h, this.l);
        WebController webController = this.f15134f;
        if (webController != null) {
            webController.registerConnectionReceiver(this);
            this.f15134f.resume();
            this.f15134f.viewableChange(true, "main");
        }
        ((AudioManager) getSystemService(LibStorageUtils.AUDIO)).requestAudioFocus(null, 3, 2);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (TextUtils.isEmpty(this.n) || !SSAEnums$ProductType.OfferWall.toString().equalsIgnoreCase(this.n)) {
            return;
        }
        this.o.c(true);
        bundle.putParcelable(ServerProtocol.DIALOG_PARAM_STATE, this.o);
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        com.ironsource.sdk.utils.f.c(f15129a, "onUserLeaveHint");
    }

    @Override // com.ironsource.sdk.controller.InterfaceC2398ha
    public void onVideoStopped() {
        a(false);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.i && z) {
            runOnUiThread(this.k);
        }
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i) {
        if (this.f15133e != i) {
            com.ironsource.sdk.utils.f.c(f15129a, "Rotation: Req = " + i + " Curr = " + this.f15133e);
            this.f15133e = i;
            super.setRequestedOrientation(i);
        }
    }

    private FrameLayout a(String str) {
        return (str == null || str.isEmpty() || str.equals(Integer.toString(1))) ? com.ironsource.sdk.utils.k.a(getApplicationContext(), this.f15134f.getLayout()) : com.ironsource.sdk.utils.k.a(getApplicationContext(), b.f.d.b.a.a().a(str));
    }

    private void b(boolean z) {
        try {
            if (j() || !z) {
                if (this.g == null) {
                    throw new Exception(f15130b);
                }
                ViewGroup viewGroup = (ViewGroup) this.h.getParent();
                View viewA = a(viewGroup);
                if (viewA == null) {
                    throw new Exception(f15131c);
                }
                if (z) {
                    ((ViewGroup) viewA.getParent()).removeView(viewA);
                }
                viewGroup.removeView(this.h);
            }
        } catch (Exception e2) {
            g.a aVar = b.f.d.a.g.q;
            b.f.d.a.a aVar2 = new b.f.d.a.a();
            aVar2.a("callfailreason", e2.getMessage());
            b.f.d.a.e.a(aVar, aVar2.a());
            com.ironsource.sdk.utils.f.c(f15129a, "removeWebViewContainerView fail " + e2.getMessage());
        }
    }

    @Override // com.ironsource.sdk.controller.InterfaceC2398ha
    public void c() {
        a(false);
    }

    private void a(String str, int i) {
        if (str != null) {
            if ("landscape".equalsIgnoreCase(str)) {
                l();
                return;
            }
            if ("portrait".equalsIgnoreCase(str)) {
                m();
                return;
            }
            if ("device".equalsIgnoreCase(str)) {
                if (com.ironsource.environment.b.q(this)) {
                    setRequestedOrientation(1);
                }
            } else if (getRequestedOrientation() == -1) {
                setRequestedOrientation(4);
            }
        }
    }

    private View a(ViewGroup viewGroup) {
        if (j()) {
            return viewGroup.findViewById(1);
        }
        return b.f.d.b.a.a().a(this.f15132d);
    }

    @Override // com.ironsource.sdk.controller.InterfaceC2398ha
    public void b() {
        a(false);
    }

    @Override // com.ironsource.sdk.controller.InterfaceC2398ha
    public void a() {
        a(true);
    }

    public void a(boolean z) {
        if (z) {
            k();
        } else {
            e();
        }
    }
}
