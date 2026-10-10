package com.ironsource.sdk.controller;

import android.app.Activity;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import b.f.d.a.g;
import com.ironsource.sdk.ISNAdView.ISNAdView;
import com.ironsource.sdk.data.SSAEnums$ControllerState;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: ControllerManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class A implements InterfaceC2399i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Handler f15108a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private I f15110c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private CountDownTimer f15112e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f15109b = A.class.getSimpleName();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private SSAEnums$ControllerState f15111d = SSAEnums$ControllerState.None;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private CommandExecutor f15113f = new CommandExecutor("NativeCommandExecutor");
    private CommandExecutor g = new CommandExecutor("ControllerCommandsExecutor");

    public A(Activity activity, com.ironsource.sdk.service.g gVar, E e2) {
        a(activity, gVar, e2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        I i = this.f15110c;
        if (i != null) {
            i.destroy();
        }
    }

    private boolean h() {
        return SSAEnums$ControllerState.Ready.equals(this.f15111d);
    }

    public void d() {
        if (h()) {
            this.f15110c.enterBackground();
        }
    }

    public void e() {
        if (h()) {
            this.f15110c.enterForeground();
        }
    }

    public I f() {
        return this.f15110c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Activity activity, com.ironsource.sdk.service.g gVar, E e2) throws Exception {
        b.f.d.a.e.a(b.f.d.a.g.f2635b);
        this.f15110c = new WebController(activity, e2, this);
        WebController webController = (WebController) this.f15110c;
        webController.addTokenJSInterface(new C2396ga(activity.getApplicationContext(), gVar));
        webController.addOmidJSInterface(new Y(activity.getApplicationContext()));
        webController.addPermissionsJSInterface(new C2388ca(activity.getApplicationContext()));
        webController.addBannerJSInterface(new C2387c());
        webController.addDeviceDataJSInterface(new G(activity.getApplicationContext()));
        webController.addAdViewsJSInterface(new C2385b(activity));
        this.f15112e = new CountDownTimerC2418s(this, 200000L, 1000L).start();
        webController.downloadController();
        this.f15113f.b();
        this.f15113f.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        g.a aVar = b.f.d.a.g.f2636c;
        b.f.d.a.a aVar2 = new b.f.d.a.a();
        aVar2.a("callfailreason", str);
        b.f.d.a.e.a(aVar, aVar2.a());
        this.f15110c = new W(this);
        ((W) this.f15110c).a(str);
        this.f15113f.b();
        this.f15113f.a();
    }

    private void a(Activity activity, com.ironsource.sdk.service.g gVar, E e2) {
        f15108a.post(new RunnableC2415q(this, activity, gVar, e2));
    }

    public void a(Runnable runnable) {
        this.f15113f.a(runnable);
    }

    @Override // com.ironsource.sdk.controller.InterfaceC2399i
    public void a() {
        b.f.d.a.e.a(b.f.d.a.g.f2637d);
        this.f15111d = SSAEnums$ControllerState.Ready;
        CountDownTimer countDownTimer = this.f15112e;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.g.b();
        this.g.a();
        this.f15110c.restoreSavedState();
    }

    @Override // com.ironsource.sdk.controller.InterfaceC2399i
    public void a(String str) {
        g.a aVar = b.f.d.a.g.l;
        b.f.d.a.a aVar2 = new b.f.d.a.a();
        aVar2.a("callfailreason", str);
        b.f.d.a.e.a(aVar, aVar2.a());
        CountDownTimer countDownTimer = this.f15112e;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        g();
        f15108a.post(new RunnableC2420t(this, str));
    }

    @Override // com.ironsource.sdk.controller.InterfaceC2399i
    public void b() {
        this.f15111d = SSAEnums$ControllerState.Loaded;
    }

    public void b(com.ironsource.sdk.data.d dVar, Map<String, String> map, b.f.d.g.a.c cVar) {
        this.g.a(new RunnableC2407m(this, dVar, map, cVar));
    }

    public boolean b(String str) {
        if (h()) {
            return this.f15110c.isInterstitialAdAvailable(str);
        }
        return false;
    }

    public void a(String str, String str2, Map<String, String> map, b.f.d.g.e eVar) {
        this.g.a(new RunnableC2422u(this, str, str2, map, eVar));
    }

    public void b(Activity activity) {
        if (h()) {
            this.f15110c.unregisterConnectionReceiver(activity);
        }
    }

    public void a(Map<String, String> map) {
        this.g.a(new RunnableC2424v(this, map));
    }

    public void a(String str, String str2, b.f.d.g.e eVar) {
        this.g.a(new RunnableC2426w(this, str, str2, eVar));
    }

    public void a(String str, String str2, com.ironsource.sdk.data.d dVar, b.f.d.g.a.d dVar2) {
        this.g.a(new RunnableC2428x(this, str, str2, dVar, dVar2));
    }

    public void a(JSONObject jSONObject, b.f.d.g.a.d dVar) {
        this.g.a(new RunnableC2430y(this, jSONObject, dVar));
    }

    public void a(String str, String str2, com.ironsource.sdk.data.d dVar, b.f.d.g.a.c cVar) {
        this.g.a(new RunnableC2431z(this, str, str2, dVar, cVar));
    }

    public void a(String str, b.f.d.g.a.c cVar) {
        this.g.a(new RunnableC2401j(this, str, cVar));
    }

    public void a(com.ironsource.sdk.data.d dVar, Map<String, String> map, b.f.d.g.a.c cVar) {
        this.g.a(new RunnableC2403k(this, dVar, map, cVar));
    }

    public void a(JSONObject jSONObject, b.f.d.g.a.c cVar) {
        this.g.a(new RunnableC2405l(this, jSONObject, cVar));
    }

    public void a(String str, String str2, com.ironsource.sdk.data.d dVar, b.f.d.g.a.b bVar) {
        this.g.a(new RunnableC2409n(this, str, str2, dVar, bVar));
    }

    public void a(JSONObject jSONObject, b.f.d.g.a.b bVar) {
        this.g.a(new RunnableC2411o(this, jSONObject, bVar));
    }

    public void a(JSONObject jSONObject) {
        this.g.a(new RunnableC2413p(this, jSONObject));
    }

    public void a(Activity activity) {
        if (h()) {
            this.f15110c.registerConnectionReceiver(activity);
        }
    }

    public void a(ISNAdView iSNAdView) {
        I i = this.f15110c;
        if (i != null) {
            i.setCommunicationWithAdView(iSNAdView);
        }
    }
}
