package com.ironsource.mediationsdk;

import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.ServerProtocol;
import com.ironsource.environment.NetworkStateReceiver;
import com.ironsource.mediationsdk.AbstractSmash;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.sdk.ListenersWrapper;
import com.ironsource.mediationsdk.utils.CappingManager;
import com.sandboxol.center.config.IntConstant;
import com.sandboxol.center.web.http.HttpCode;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: RewardedVideoManager.java */
/* JADX INFO: loaded from: classes2.dex */
class Na extends AbstractC2309a implements NetworkStateReceiver.a, com.ironsource.mediationsdk.sdk.V, com.ironsource.mediationsdk.utils.d {
    private ListenersWrapper t;
    private NetworkStateReceiver w;
    private com.ironsource.mediationsdk.model.l x;
    private int z;
    private final String s = Na.class.getSimpleName();
    private Timer y = null;
    private boolean u = false;
    private boolean v = false;
    private boolean D = false;
    private boolean B = false;
    private long C = new Date().getTime();
    private List<AbstractSmash.MEDIATION_STATE> A = Arrays.asList(AbstractSmash.MEDIATION_STATE.INIT_FAILED, AbstractSmash.MEDIATION_STATE.CAPPED_PER_SESSION, AbstractSmash.MEDIATION_STATE.EXHAUSTED, AbstractSmash.MEDIATION_STATE.CAPPED_PER_DAY);

    Na() {
        this.g = new com.ironsource.mediationsdk.utils.f("rewarded_video", this);
    }

    private synchronized AbstractC2311b h(Pa pa) {
        this.n.b(IronSourceLogger.IronSourceTag.NATIVE, this.s + ":startAdapter(" + pa.r() + ")", 1);
        AbstractC2311b abstractC2311bA = C2313c.a().a(pa.f14598c, pa.f14598c.k());
        if (abstractC2311bA == null) {
            this.n.b(IronSourceLogger.IronSourceTag.API, pa.r() + " is configured in IronSource's platform, but the adapter is not integrated", 2);
            return null;
        }
        pa.a(abstractC2311bA);
        pa.a(AbstractSmash.MEDIATION_STATE.INITIATED);
        c((AbstractSmash) pa);
        a(1001, pa, (Object[][]) null);
        try {
            pa.c(this.m, this.l);
            return abstractC2311bA;
        } catch (Throwable th) {
            this.n.a(IronSourceLogger.IronSourceTag.API, this.s + "failed to init adapter: " + pa.w() + "v", th);
            pa.a(AbstractSmash.MEDIATION_STATE.INIT_FAILED);
            return null;
        }
    }

    private synchronized void i() {
        if (o()) {
            this.n.b(IronSourceLogger.IronSourceTag.INTERNAL, "Reset Iteration", 0);
            boolean z = false;
            for (AbstractSmash abstractSmash : this.i) {
                if (abstractSmash.v() == AbstractSmash.MEDIATION_STATE.EXHAUSTED) {
                    abstractSmash.j();
                }
                if (abstractSmash.v() == AbstractSmash.MEDIATION_STATE.AVAILABLE) {
                    z = true;
                }
            }
            this.n.b(IronSourceLogger.IronSourceTag.INTERNAL, "End of Reset Iteration", 0);
            if (c(z)) {
                this.t.a(this.p.booleanValue());
            }
        }
    }

    private String j() {
        com.ironsource.mediationsdk.model.l lVar = this.x;
        return lVar == null ? "" : lVar.c();
    }

    private synchronized boolean k() {
        boolean z;
        z = false;
        Iterator<AbstractSmash> it = this.i.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            if (it.next().v() == AbstractSmash.MEDIATION_STATE.AVAILABLE) {
                z = true;
                break;
            }
        }
        return z;
    }

    private synchronized boolean l() {
        int i;
        i = 0;
        for (AbstractSmash abstractSmash : this.i) {
            if (abstractSmash.v() == AbstractSmash.MEDIATION_STATE.INIT_FAILED || abstractSmash.v() == AbstractSmash.MEDIATION_STATE.CAPPED_PER_DAY || abstractSmash.v() == AbstractSmash.MEDIATION_STATE.CAPPED_PER_SESSION || abstractSmash.v() == AbstractSmash.MEDIATION_STATE.NOT_AVAILABLE || abstractSmash.v() == AbstractSmash.MEDIATION_STATE.EXHAUSTED) {
                i++;
            }
        }
        return this.i.size() == i;
    }

    private synchronized boolean m() {
        for (AbstractSmash abstractSmash : this.i) {
            if (abstractSmash.v() == AbstractSmash.MEDIATION_STATE.NOT_AVAILABLE || abstractSmash.v() == AbstractSmash.MEDIATION_STATE.AVAILABLE || abstractSmash.v() == AbstractSmash.MEDIATION_STATE.INITIATED || abstractSmash.v() == AbstractSmash.MEDIATION_STATE.INIT_PENDING || abstractSmash.v() == AbstractSmash.MEDIATION_STATE.LOAD_PENDING) {
                return true;
            }
        }
        return false;
    }

    private synchronized boolean n() {
        if (e() == null) {
            return false;
        }
        return ((Pa) e()).I();
    }

    private synchronized boolean o() {
        for (AbstractSmash abstractSmash : this.i) {
            if (abstractSmash.v() == AbstractSmash.MEDIATION_STATE.NOT_INITIATED || abstractSmash.v() == AbstractSmash.MEDIATION_STATE.INITIATED || abstractSmash.v() == AbstractSmash.MEDIATION_STATE.AVAILABLE) {
                return false;
            }
        }
        return true;
    }

    private AbstractC2311b p() {
        AbstractC2311b abstractC2311bH = null;
        int i = 0;
        for (int i2 = 0; i2 < this.i.size() && abstractC2311bH == null; i2++) {
            if (this.i.get(i2).v() == AbstractSmash.MEDIATION_STATE.AVAILABLE || this.i.get(i2).v() == AbstractSmash.MEDIATION_STATE.INITIATED) {
                i++;
                if (i >= this.h) {
                    break;
                }
            } else if (this.i.get(i2).v() == AbstractSmash.MEDIATION_STATE.NOT_INITIATED && (abstractC2311bH = h((Pa) this.i.get(i2))) == null) {
                this.i.get(i2).a(AbstractSmash.MEDIATION_STATE.INIT_FAILED);
            }
        }
        return abstractC2311bH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void q() {
        if (com.ironsource.mediationsdk.utils.j.d(com.ironsource.mediationsdk.utils.c.c().b()) && this.p != null) {
            if (!this.p.booleanValue()) {
                c(102);
                c(1000);
                this.B = true;
                for (AbstractSmash abstractSmash : this.i) {
                    if (abstractSmash.v() == AbstractSmash.MEDIATION_STATE.NOT_AVAILABLE) {
                        try {
                            this.n.b(IronSourceLogger.IronSourceTag.INTERNAL, "Fetch from timer: " + abstractSmash.r() + ":reload smash", 1);
                            a(1001, abstractSmash, (Object[][]) null);
                            ((Pa) abstractSmash).G();
                        } catch (Throwable th) {
                            this.n.b(IronSourceLogger.IronSourceTag.NATIVE, abstractSmash.r() + " Failed to call fetchVideo(), " + th.getLocalizedMessage(), 1);
                        }
                    }
                }
            }
        }
    }

    private synchronized void r() {
        if (e() != null && !this.q) {
            this.q = true;
            if (h((Pa) e()) == null) {
                this.t.a(this.p.booleanValue());
            }
        } else if (!n() || c(true)) {
            this.t.a(this.p.booleanValue());
        }
    }

    private void s() {
        for (int i = 0; i < this.i.size(); i++) {
            String strI = this.i.get(i).f14598c.i();
            if (strI.equalsIgnoreCase("IronSource") || strI.equalsIgnoreCase("SupersonicAds")) {
                C2313c.a().a(this.i.get(i).f14598c, this.i.get(i).f14598c.k());
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        if (this.z <= 0) {
            this.n.b(IronSourceLogger.IronSourceTag.INTERNAL, "load interval is not set, ignoring", 1);
            return;
        }
        Timer timer = this.y;
        if (timer != null) {
            timer.cancel();
        }
        this.y = new Timer();
        this.y.schedule(new Ma(this), this.z * 1000);
    }

    private void u() {
        if (g()) {
            c(1000);
            a(IntConstant.PERMISSION_STORAGE_DOWNLOAD, new Object[][]{new Object[]{"duration", 0}});
            this.B = false;
        } else if (m()) {
            c(1000);
            this.B = true;
            this.C = new Date().getTime();
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.V
    public void c(Pa pa) {
        this.n.b(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, pa.r() + ":onRewardedVideoAdStarted()", 1);
        a(1204, pa, new Object[][]{new Object[]{"placement", j()}, new Object[]{"sessionDepth", Integer.valueOf(pa.A)}});
        this.t.g();
    }

    @Override // com.ironsource.mediationsdk.sdk.V
    public void d(Pa pa) {
        this.n.b(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, pa.r() + ":onRewardedVideoAdOpened()", 1);
        a(1005, pa, new Object[][]{new Object[]{"placement", j()}, new Object[]{"sessionDepth", Integer.valueOf(pa.A)}});
        this.t.onRewardedVideoAdOpened();
    }

    @Override // com.ironsource.mediationsdk.sdk.V
    public void e(Pa pa) {
        this.n.b(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, pa.r() + ":onRewardedVideoAdEnded()", 1);
        a(1205, pa, new Object[][]{new Object[]{"placement", j()}, new Object[]{"sessionDepth", Integer.valueOf(pa.A)}});
        this.t.b();
    }

    @Override // com.ironsource.mediationsdk.sdk.V
    public void f(Pa pa) {
        this.n.b(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, pa.r() + ":onRewardedVideoAdVisible()", 1);
        if (this.x != null) {
            a(1206, pa, new Object[][]{new Object[]{"placement", j()}, new Object[]{"sessionDepth", Integer.valueOf(pa.A)}});
        } else {
            this.n.b(IronSourceLogger.IronSourceTag.INTERNAL, "mCurrentPlacement is null", 3);
        }
    }

    public synchronized boolean g() {
        this.n.b(IronSourceLogger.IronSourceTag.API, this.s + ":isRewardedVideoAvailable()", 1);
        if (this.o && !com.ironsource.mediationsdk.utils.j.d(com.ironsource.mediationsdk.utils.c.c().b())) {
            return false;
        }
        for (AbstractSmash abstractSmash : this.i) {
            if (abstractSmash.C() && ((Pa) abstractSmash).I()) {
                return true;
            }
        }
        return false;
    }

    public void a(ListenersWrapper listenersWrapper) {
        this.t = listenersWrapper;
    }

    public synchronized void b(String str) {
        this.n.b(IronSourceLogger.IronSourceTag.API, this.s + ":showRewardedVideo(placementName: " + str + ")", 1);
        this.t.b(str);
        a(1100, new Object[][]{new Object[]{"placement", str}});
        if (this.D) {
            this.n.b(IronSourceLogger.IronSourceTag.API, "showRewardedVideo error: can't show ad while an ad is already showing", 3);
            this.t.c(new com.ironsource.mediationsdk.logger.b(1022, "showRewardedVideo error: can't show ad while an ad is already showing"));
            return;
        }
        if (this.o && !com.ironsource.mediationsdk.utils.j.d(com.ironsource.mediationsdk.utils.c.c().b())) {
            this.n.b(IronSourceLogger.IronSourceTag.API, "showRewardedVideo error: can't show ad when there's no internet connection", 3);
            this.t.c(com.ironsource.mediationsdk.utils.g.f("Rewarded Video"));
            return;
        }
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < this.i.size(); i3++) {
            AbstractSmash abstractSmash = this.i.get(i3);
            this.n.b(IronSourceLogger.IronSourceTag.INTERNAL, "showRewardedVideo, iterating on: " + abstractSmash.r() + ", Status: " + abstractSmash.v(), 0);
            if (abstractSmash.v() == AbstractSmash.MEDIATION_STATE.AVAILABLE) {
                if (((Pa) abstractSmash).I()) {
                    a(abstractSmash, i3);
                    if (this.r && !abstractSmash.equals(f())) {
                        d();
                    }
                    if (abstractSmash.A()) {
                        abstractSmash.a(AbstractSmash.MEDIATION_STATE.CAPPED_PER_SESSION);
                        a(1401, abstractSmash, (Object[][]) null);
                        h();
                    } else if (this.g.c(abstractSmash)) {
                        abstractSmash.a(AbstractSmash.MEDIATION_STATE.CAPPED_PER_DAY);
                        a(150, abstractSmash, new Object[][]{new Object[]{AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE}});
                        h();
                    } else if (abstractSmash.B()) {
                        p();
                        i();
                    }
                    return;
                }
                a(false, (Pa) abstractSmash);
                Exception exc = new Exception("FailedToShowVideoException");
                this.n.a(IronSourceLogger.IronSourceTag.INTERNAL, abstractSmash.r() + " Failed to show video", exc);
            } else if (abstractSmash.v() == AbstractSmash.MEDIATION_STATE.CAPPED_PER_SESSION || abstractSmash.v() == AbstractSmash.MEDIATION_STATE.CAPPED_PER_DAY) {
                i++;
            } else if (abstractSmash.v() == AbstractSmash.MEDIATION_STATE.NOT_AVAILABLE) {
                i2++;
            }
        }
        if (n()) {
            a(e(), this.i.size());
        } else if (i + i2 == this.i.size()) {
            this.t.c(com.ironsource.mediationsdk.utils.g.d("Rewarded Video"));
        }
    }

    public synchronized void a(String str, String str2) {
        this.n.b(IronSourceLogger.IronSourceTag.API, this.s + ":initRewardedVideo(appKey: " + str + ", userId: " + str2 + ")", 1);
        long time = new Date().getTime();
        c(81312);
        this.m = str;
        this.l = str2;
        int i = 0;
        for (AbstractSmash abstractSmash : this.i) {
            if (this.g.d(abstractSmash)) {
                a(150, abstractSmash, new Object[][]{new Object[]{AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, "false"}});
            }
            if (this.g.c(abstractSmash)) {
                abstractSmash.a(AbstractSmash.MEDIATION_STATE.CAPPED_PER_DAY);
                i++;
            }
        }
        if (i == this.i.size()) {
            this.t.a(false);
            return;
        }
        c(1000);
        this.t.b((String) null);
        this.B = true;
        this.C = new Date().getTime();
        a(81313, new Object[][]{new Object[]{"duration", Long.valueOf(new Date().getTime() - time)}});
        s();
        for (int i2 = 0; i2 < this.h && i2 < this.i.size() && p() != null; i2++) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized boolean c(boolean r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.lang.Boolean r0 = r3.p     // Catch: java.lang.Throwable -> L57
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L26
            r3.t()     // Catch: java.lang.Throwable -> L57
            if (r4 == 0) goto L13
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r2)     // Catch: java.lang.Throwable -> L57
            r3.p = r4     // Catch: java.lang.Throwable -> L57
            goto L55
        L13:
            boolean r4 = r3.n()     // Catch: java.lang.Throwable -> L57
            if (r4 != 0) goto L54
            boolean r4 = r3.l()     // Catch: java.lang.Throwable -> L57
            if (r4 == 0) goto L54
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r1)     // Catch: java.lang.Throwable -> L57
            r3.p = r4     // Catch: java.lang.Throwable -> L57
            goto L55
        L26:
            if (r4 == 0) goto L37
            java.lang.Boolean r0 = r3.p     // Catch: java.lang.Throwable -> L57
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> L57
            if (r0 != 0) goto L37
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r2)     // Catch: java.lang.Throwable -> L57
            r3.p = r4     // Catch: java.lang.Throwable -> L57
            goto L55
        L37:
            if (r4 != 0) goto L54
            java.lang.Boolean r4 = r3.p     // Catch: java.lang.Throwable -> L57
            boolean r4 = r4.booleanValue()     // Catch: java.lang.Throwable -> L57
            if (r4 == 0) goto L54
            boolean r4 = r3.k()     // Catch: java.lang.Throwable -> L57
            if (r4 != 0) goto L54
            boolean r4 = r3.n()     // Catch: java.lang.Throwable -> L57
            if (r4 != 0) goto L54
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r1)     // Catch: java.lang.Throwable -> L57
            r3.p = r4     // Catch: java.lang.Throwable -> L57
            goto L55
        L54:
            r2 = 0
        L55:
            monitor-exit(r3)
            return r2
        L57:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.Na.c(boolean):boolean");
    }

    private boolean d(boolean z) {
        Boolean bool = this.p;
        if (bool == null) {
            return false;
        }
        if (z && !bool.booleanValue() && k()) {
            this.p = true;
            return true;
        }
        if (z || !this.p.booleanValue()) {
            return false;
        }
        this.p = false;
        return true;
    }

    @Override // com.ironsource.mediationsdk.sdk.V
    public void g(Pa pa) {
        this.n.b(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, pa.r() + ":onRewardedVideoAdClosed()", 1);
        this.D = false;
        StringBuilder sb = new StringBuilder();
        try {
            for (AbstractSmash abstractSmash : this.i) {
                if (((Pa) abstractSmash).I()) {
                    sb.append(abstractSmash.r() + ";");
                }
            }
        } catch (Throwable unused) {
            this.n.b(IronSourceLogger.IronSourceTag.INTERNAL, "Failed to check RV availability", 0);
        }
        Object[][] objArr = new Object[3][];
        objArr[0] = new Object[]{"placement", j()};
        Object[] objArr2 = new Object[2];
        objArr2[0] = "ext1";
        StringBuilder sb2 = new StringBuilder();
        sb2.append("otherRVAvailable = ");
        sb2.append(sb.length() > 0 ? "true|" + ((Object) sb) : "false");
        objArr2[1] = sb2.toString();
        objArr[1] = objArr2;
        objArr[2] = new Object[]{"sessionDepth", Integer.valueOf(pa.A)};
        a(1203, pa, objArr);
        com.ironsource.mediationsdk.utils.m.a().b(1);
        if (!pa.A() && !this.g.c(pa)) {
            a(1001, pa, (Object[][]) null);
        }
        u();
        this.t.onRewardedVideoAdClosed();
        for (AbstractSmash abstractSmash2 : this.i) {
            this.n.b(IronSourceLogger.IronSourceTag.INTERNAL, "Fetch on ad closed, iterating on: " + abstractSmash2.r() + ", Status: " + abstractSmash2.v(), 0);
            if (abstractSmash2.v() == AbstractSmash.MEDIATION_STATE.NOT_AVAILABLE) {
                try {
                    if (!abstractSmash2.r().equals(pa.r())) {
                        this.n.b(IronSourceLogger.IronSourceTag.INTERNAL, abstractSmash2.r() + ":reload smash", 1);
                        ((Pa) abstractSmash2).G();
                        a(1001, abstractSmash2, (Object[][]) null);
                    }
                } catch (Throwable th) {
                    this.n.b(IronSourceLogger.IronSourceTag.NATIVE, abstractSmash2.r() + " Failed to call fetchVideo(), " + th.getLocalizedMessage(), 1);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0020, code lost:
    
        r1.a(com.ironsource.mediationsdk.AbstractSmash.MEDIATION_STATE.CAPPED_PER_SESSION);
        p();
     */
    @Override // com.ironsource.mediationsdk.AbstractC2309a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected synchronized void d() {
        /*
            r3 = this;
            monitor-enter(r3)
            super.d()     // Catch: java.lang.Throwable -> L2a
            java.util.concurrent.CopyOnWriteArrayList<com.ironsource.mediationsdk.AbstractSmash> r0 = r3.i     // Catch: java.lang.Throwable -> L2a
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L2a
        La:
            boolean r1 = r0.hasNext()     // Catch: java.lang.Throwable -> L2a
            if (r1 == 0) goto L28
            java.lang.Object r1 = r0.next()     // Catch: java.lang.Throwable -> L2a
            com.ironsource.mediationsdk.AbstractSmash r1 = (com.ironsource.mediationsdk.AbstractSmash) r1     // Catch: java.lang.Throwable -> L2a
            com.ironsource.mediationsdk.AbstractSmash r2 = r3.f()     // Catch: java.lang.Throwable -> L2a
            boolean r2 = r1.equals(r2)     // Catch: java.lang.Throwable -> L2a
            if (r2 == 0) goto La
            com.ironsource.mediationsdk.AbstractSmash$MEDIATION_STATE r0 = com.ironsource.mediationsdk.AbstractSmash.MEDIATION_STATE.CAPPED_PER_SESSION     // Catch: java.lang.Throwable -> L2a
            r1.a(r0)     // Catch: java.lang.Throwable -> L2a
            r3.p()     // Catch: java.lang.Throwable -> L2a
        L28:
            monitor-exit(r3)
            return
        L2a:
            r0 = move-exception
            monitor-exit(r3)
            goto L2e
        L2d:
            throw r0
        L2e:
            goto L2d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.Na.d():void");
    }

    private void c(int i) {
        a(i, (Object[][]) null);
    }

    private synchronized void h() {
        if (p() != null) {
            return;
        }
        if (a(AbstractSmash.MEDIATION_STATE.NOT_AVAILABLE, AbstractSmash.MEDIATION_STATE.CAPPED_PER_SESSION, AbstractSmash.MEDIATION_STATE.CAPPED_PER_DAY) < this.i.size()) {
            i();
        } else {
            if (c(false)) {
                r();
            }
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.V
    public void a(com.ironsource.mediationsdk.logger.b bVar, Pa pa) {
        this.n.b(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, pa.r() + ":onRewardedVideoAdShowFailed(" + bVar + ")", 1);
        this.D = false;
        a(1202, pa, new Object[][]{new Object[]{"placement", j()}, new Object[]{"errorCode", Integer.valueOf(bVar.a())}, new Object[]{"reason", bVar.b()}, new Object[]{"sessionDepth", Integer.valueOf(pa != null ? pa.A : com.ironsource.mediationsdk.utils.m.a().a(1))}});
        u();
        this.t.c(bVar);
    }

    @Override // com.ironsource.mediationsdk.sdk.V
    public synchronized void a(boolean z, Pa pa) {
        this.n.b(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, pa.r() + ": onRewardedVideoAvailabilityChanged(available:" + z + ")", 1);
        if (this.u) {
            return;
        }
        if (z && this.B) {
            this.B = false;
            a(IntConstant.PERMISSION_STORAGE_DOWNLOAD, new Object[][]{new Object[]{"duration", Long.valueOf(new Date().getTime() - this.C)}});
        }
        try {
        } catch (Throwable th) {
            this.n.a(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, "onRewardedVideoAvailabilityChanged(available:" + z + ", provider:" + pa.w() + ")", th);
        }
        if (pa.equals(e())) {
            if (c(z)) {
                this.t.a(this.p.booleanValue());
            }
            return;
        }
        if (pa.equals(f())) {
            this.n.b(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, pa.r() + " is a premium adapter, canShowPremium: " + c(), 1);
            if (!c()) {
                pa.a(AbstractSmash.MEDIATION_STATE.CAPPED_PER_SESSION);
                if (c(false)) {
                    this.t.a(this.p.booleanValue());
                }
                return;
            }
        }
        if (pa.C() && !this.g.c(pa)) {
            if (z) {
                if (c(true)) {
                    this.t.a(this.p.booleanValue());
                }
            } else {
                if (c(false)) {
                    r();
                }
                p();
                i();
            }
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.V
    public void b(Pa pa) {
        this.n.b(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, pa.r() + ":onRewardedVideoAdRewarded()", 1);
        if (this.x == null) {
            this.x = U.e().c().a().e().b();
        }
        JSONObject jSONObjectA = com.ironsource.mediationsdk.utils.j.a(pa);
        try {
            jSONObjectA.put("sessionDepth", pa.A);
            if (this.x != null) {
                jSONObjectA.put("placement", j());
                jSONObjectA.put("rewardName", this.x.e());
                jSONObjectA.put("rewardAmount", this.x.d());
            } else {
                this.n.b(IronSourceLogger.IronSourceTag.INTERNAL, "mCurrentPlacement is null", 3);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        b.f.b.b bVar = new b.f.b.b(1010, jSONObjectA);
        if (!TextUtils.isEmpty(this.m)) {
            bVar.a("transId", com.ironsource.mediationsdk.utils.j.b("" + Long.toString(bVar.d()) + this.m + pa.w()));
            if (!TextUtils.isEmpty(U.e().d())) {
                bVar.a("dynamicUserId", U.e().d());
            }
            Map<String, String> mapJ = U.e().j();
            if (mapJ != null) {
                for (String str : mapJ.keySet()) {
                    bVar.a("custom_" + str, mapJ.get(str));
                }
            }
        }
        com.ironsource.mediationsdk.b.k.g().c(bVar);
        com.ironsource.mediationsdk.model.l lVar = this.x;
        if (lVar != null) {
            this.t.a(lVar);
        } else {
            this.n.b(IronSourceLogger.IronSourceTag.INTERNAL, "mCurrentPlacement is null", 3);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.V
    public void a(Pa pa) {
        this.n.b(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, pa.r() + ":onRewardedVideoAdClicked()", 1);
        if (this.x == null) {
            this.x = U.e().c().a().e().b();
        }
        if (this.x == null) {
            this.n.b(IronSourceLogger.IronSourceTag.INTERNAL, "mCurrentPlacement is null", 3);
        } else {
            a(HttpCode.PASSWORD_NOT_SET, pa, new Object[][]{new Object[]{"placement", j()}, new Object[]{"sessionDepth", Integer.valueOf(pa.A)}});
            this.t.b(this.x);
        }
    }

    @Override // com.ironsource.environment.NetworkStateReceiver.a
    public void a(boolean z) {
        if (this.o) {
            this.n.b(IronSourceLogger.IronSourceTag.INTERNAL, "Network Availability Changed To: " + z, 0);
            if (d(z)) {
                this.u = !z;
                this.t.a(z);
            }
        }
    }

    void b(boolean z) {
        this.v = z;
    }

    void b(int i) {
        this.z = i;
    }

    void a(Context context, boolean z) {
        this.n.b(IronSourceLogger.IronSourceTag.INTERNAL, this.s + " Should Track Network State: " + z, 0);
        this.o = z;
        if (this.o) {
            if (this.w == null) {
                this.w = new NetworkStateReceiver(context, this);
            }
            context.getApplicationContext().registerReceiver(this.w, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        } else if (this.w != null) {
            context.getApplicationContext().unregisterReceiver(this.w);
        }
    }

    @Override // com.ironsource.mediationsdk.utils.d
    public void b() {
        boolean z = false;
        for (AbstractSmash abstractSmash : this.i) {
            if (abstractSmash.v() == AbstractSmash.MEDIATION_STATE.CAPPED_PER_DAY) {
                a(150, abstractSmash, new Object[][]{new Object[]{AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, "false"}});
                abstractSmash.a(AbstractSmash.MEDIATION_STATE.NOT_AVAILABLE);
                if (((Pa) abstractSmash).I() && abstractSmash.C()) {
                    abstractSmash.a(AbstractSmash.MEDIATION_STATE.AVAILABLE);
                    z = true;
                }
            }
        }
        if (z && c(true)) {
            this.t.a(true);
        }
    }

    private void a(int i, int i2) {
        for (int i3 = 0; i3 < i && i3 < this.i.size(); i3++) {
            if (!this.A.contains(this.i.get(i3).v())) {
                a(((Pa) this.i.get(i3)).H(), false, i2);
            }
        }
    }

    private synchronized void a(String str, boolean z, int i) {
        String str2 = "";
        try {
            str2 = ("" + str) + "&sdkVersion=" + com.ironsource.mediationsdk.utils.j.c();
            com.ironsource.mediationsdk.f.c.b(str2, z, i);
        } catch (Throwable th) {
            this.n.a(IronSourceLogger.IronSourceTag.NETWORK, "reportImpression:(providerURL:" + str2 + ", hit:" + z + ")", th);
        }
    }

    void a(com.ironsource.mediationsdk.model.l lVar) {
        this.x = lVar;
        this.t.b(lVar.c());
    }

    private synchronized void a(AbstractSmash abstractSmash, int i) {
        CappingManager.b(com.ironsource.mediationsdk.utils.c.c().b(), this.x);
        if (CappingManager.f(com.ironsource.mediationsdk.utils.c.c().b(), j())) {
            a(1400, new Object[][]{new Object[]{"placement", j()}});
        }
        this.g.b(abstractSmash);
        if (this.x != null) {
            if (this.v) {
                a(((Pa) abstractSmash).H(), true, this.x.b());
                a(i, this.x.b());
            }
            a(abstractSmash, i, j());
        } else {
            this.n.b(IronSourceLogger.IronSourceTag.INTERNAL, "mCurrentPlacement is null", 3);
        }
        a(1201, abstractSmash, this.x != null ? new Object[][]{new Object[]{"placement", j()}} : null);
        this.D = true;
        ((Pa) abstractSmash).A = com.ironsource.mediationsdk.utils.m.a().a(1);
        ((Pa) abstractSmash).J();
    }

    private void a(AbstractSmash abstractSmash, int i, String str) {
        a(1209, abstractSmash, new Object[][]{new Object[]{"placement", str}, new Object[]{AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE}});
        for (int i2 = 0; i2 < this.i.size() && i2 < i; i2++) {
            AbstractSmash abstractSmash2 = this.i.get(i2);
            if (abstractSmash2.v() == AbstractSmash.MEDIATION_STATE.NOT_AVAILABLE) {
                a(1209, abstractSmash2, new Object[][]{new Object[]{"placement", str}, new Object[]{AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, "false"}});
            }
        }
    }

    private void a(int i, Object[][] objArr) {
        JSONObject jSONObjectB = com.ironsource.mediationsdk.utils.j.b(false);
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    jSONObjectB.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e2) {
                this.n.b(IronSourceLogger.IronSourceTag.INTERNAL, "RewardedVideoManager logMediationEvent " + Log.getStackTraceString(e2), 3);
            }
        }
        com.ironsource.mediationsdk.b.k.g().c(new b.f.b.b(i, jSONObjectB));
    }

    private void a(int i, AbstractSmash abstractSmash, Object[][] objArr) {
        JSONObject jSONObjectA = com.ironsource.mediationsdk.utils.j.a(abstractSmash);
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    jSONObjectA.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e2) {
                this.n.b(IronSourceLogger.IronSourceTag.INTERNAL, "RewardedVideoManager logProviderEvent " + Log.getStackTraceString(e2), 3);
            }
        }
        com.ironsource.mediationsdk.b.k.g().c(new b.f.b.b(i, jSONObjectA));
    }

    private int a(AbstractSmash.MEDIATION_STATE... mediation_stateArr) {
        int i = 0;
        for (AbstractSmash abstractSmash : this.i) {
            int i2 = i;
            for (AbstractSmash.MEDIATION_STATE mediation_state : mediation_stateArr) {
                if (abstractSmash.v() == mediation_state) {
                    i2++;
                }
            }
            i = i2;
        }
        return i;
    }
}
