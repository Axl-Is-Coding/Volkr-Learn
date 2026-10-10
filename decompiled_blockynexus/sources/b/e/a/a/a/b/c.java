package b.e.a.a.a.b;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static c f2554a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f2555b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private BroadcastReceiver f2556c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f2557d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f2558e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private a f2559f;

    public interface a {
        void a(boolean z);
    }

    private c() {
    }

    public static c a() {
        return f2554a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (this.f2558e != z) {
            this.f2558e = z;
            if (this.f2557d) {
                g();
                a aVar = this.f2559f;
                if (aVar != null) {
                    aVar.a(d());
                }
            }
        }
    }

    private void e() {
        this.f2556c = new b(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        this.f2555b.registerReceiver(this.f2556c, intentFilter);
    }

    private void f() {
        BroadcastReceiver broadcastReceiver;
        Context context = this.f2555b;
        if (context == null || (broadcastReceiver = this.f2556c) == null) {
            return;
        }
        context.unregisterReceiver(broadcastReceiver);
        this.f2556c = null;
    }

    private void g() {
        boolean z = !this.f2558e;
        Iterator<com.iab.omid.library.ironsrc.adsession.g> it = b.e.a.a.a.b.a.a().b().iterator();
        while (it.hasNext()) {
            it.next().j().a(z);
        }
    }

    public void a(Context context) {
        this.f2555b = context.getApplicationContext();
    }

    public void a(a aVar) {
        this.f2559f = aVar;
    }

    public void b() {
        e();
        this.f2557d = true;
        g();
    }

    public void c() {
        f();
        this.f2557d = false;
        this.f2558e = false;
        this.f2559f = null;
    }

    public boolean d() {
        return !this.f2558e;
    }
}
