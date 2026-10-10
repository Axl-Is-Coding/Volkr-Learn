package b.a.a.a.a.a;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.c.k;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.o;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: GPDownLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeakReference<Context> f2451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.d.b f2452b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private h f2453c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f2454d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f2455e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AtomicBoolean f2456f = new AtomicBoolean(false);
    private boolean g = false;

    public a(Context context, h hVar, String str) {
        this.f2451a = new WeakReference<>(context);
        this.f2453c = hVar;
        o.c("GPDownLoader", this.f2453c.Z().toString());
        this.f2452b = hVar.K();
        this.f2454d = str;
        o.c("GPDownLoader", "====tag===" + str);
        if (com.bytedance.sdk.openadsdk.core.o.a() == null) {
            com.bytedance.sdk.openadsdk.core.o.a(context);
        }
    }

    private Context e() {
        WeakReference<Context> weakReference = this.f2451a;
        return (weakReference == null || weakReference.get() == null) ? com.bytedance.sdk.openadsdk.core.o.a() : this.f2451a.get();
    }

    @Override // b.a.a.a.a.a.b
    public void a(boolean z) {
        this.g = z;
    }

    public boolean b() {
        if (this.f2453c.L() == null) {
            return false;
        }
        String strA = this.f2453c.L().a();
        if (!TextUtils.isEmpty(strA)) {
            Uri uri = Uri.parse(strA);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            if (ab.a(e(), intent)) {
                if (!(e() instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                e().startActivity(intent);
                d.f(com.bytedance.sdk.openadsdk.core.o.a(), this.f2453c, this.f2454d, "open_url_app", null);
                k.a().a(this.f2453c, this.f2454d);
                return true;
            }
        }
        if (this.f2455e && !this.f2456f.get()) {
            return false;
        }
        this.f2455e = true;
        d.f(e(), this.f2453c, this.f2454d, "open_fallback_url", null);
        return false;
    }

    @Override // b.a.a.a.a.a.b
    public boolean c() {
        this.f2456f.set(true);
        return this.f2452b != null && a(e(), this.f2452b.c());
    }

    @Override // b.a.a.a.a.a.b
    public boolean d() {
        Intent intentA;
        com.bytedance.sdk.openadsdk.core.d.b bVar = this.f2452b;
        if (bVar == null) {
            return false;
        }
        String strC = bVar.c();
        if (TextUtils.isEmpty(strC) || !ab.b(e(), strC) || (intentA = ab.a(e(), strC)) == null) {
            return false;
        }
        intentA.putExtra("START_ONLY_FOR_ANDROID", true);
        e().startActivity(intentA);
        d.f(e(), this.f2453c, this.f2454d, "click_open", null);
        return true;
    }

    public boolean a(Context context, String str) {
        Intent launchIntentForPackage;
        if (context == null || str == null || TextUtils.isEmpty(str)) {
            return false;
        }
        o.c("GPDownLoader", "gotoGooglePlay :market://details?id=" + str);
        Intent intent = new Intent("android.intent.action.VIEW");
        Uri uri = Uri.parse("market://details?id=" + str);
        intent.setData(uri);
        for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 65536)) {
            if (resolveInfo.activityInfo.packageName.equals("com.android.vending") && (launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("com.android.vending")) != null) {
                launchIntentForPackage.setComponent(new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name));
                launchIntentForPackage.setData(uri);
                if (!(context instanceof Activity)) {
                    launchIntentForPackage.setFlags(268435456);
                }
                context.startActivity(launchIntentForPackage);
                return true;
            }
        }
        Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + str));
        if (!(context instanceof Activity)) {
            intent2.setFlags(268435456);
        }
        context.startActivity(intent2);
        return true;
    }

    @Override // b.a.a.a.a.a.b
    public void a() {
        if (e() == null || this.f2452b == null || d()) {
            return;
        }
        if (b()) {
            this.f2456f.set(true);
        } else {
            c();
        }
    }
}
