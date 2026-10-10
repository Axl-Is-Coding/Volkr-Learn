package com.bytedance.sdk.openadsdk.core;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: GlobalInfo.java */
/* JADX INFO: loaded from: classes.dex */
public class h {
    private static final h q = new h();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f6225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f6226b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f6227c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f6228d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f6229e;
    private String[] n;
    private com.bytedance.sdk.openadsdk.b.c r;
    private com.bytedance.sdk.openadsdk.core.video.c.c s;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private AtomicBoolean f6230f = new AtomicBoolean(false);
    private int g = 0;
    private boolean h = true;
    private boolean i = false;
    private final Set<Integer> j = Collections.synchronizedSet(new HashSet());
    private boolean k = false;
    private Bitmap l = null;
    private com.bytedance.sdk.openadsdk.utils.a m = new com.bytedance.sdk.openadsdk.utils.a();
    private int o = 0;
    private int p = 0;

    private h() {
        com.bytedance.sdk.openadsdk.h.g.a.a(o.a());
        this.j.add(4);
        Context contextA = o.a();
        if (contextA instanceof Application) {
            ((Application) contextA).registerActivityLifecycleCallbacks(this.m);
        } else {
            if (contextA == null || contextA.getApplicationContext() == null) {
                return;
            }
            ((Application) contextA.getApplicationContext()).registerActivityLifecycleCallbacks(this.m);
        }
    }

    public static h b() {
        return q;
    }

    public boolean a() {
        return this.m.a();
    }

    public String c() {
        return com.bytedance.sdk.openadsdk.multipro.b.b() ? com.bytedance.sdk.openadsdk.multipro.d.a.b("sp_global_info", "app_id", (String) null) : this.f6225a;
    }

    public String d() {
        return com.bytedance.sdk.openadsdk.multipro.b.b() ? com.bytedance.sdk.openadsdk.multipro.d.a.b("sp_global_info", "name", (String) null) : this.f6226b;
    }

    public int e() {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "sdk_coppa", 0);
        }
        this.o = com.bytedance.sdk.openadsdk.utils.v.a((String) null, o.a()).b("sdk_coppa", 0);
        return this.o;
    }

    public int f() {
        return com.bytedance.sdk.openadsdk.multipro.b.b() ? com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "tt_gdrp", -1) : com.bytedance.sdk.openadsdk.utils.v.a((String) null, o.a()).b("tt_gdrp", -1);
    }

    public int g() {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "global_coppa", -99);
        }
        this.p = com.bytedance.sdk.openadsdk.utils.v.a((String) null, o.a()).b("global_coppa", -99);
        if (this.p == -99) {
            this.p = e();
        }
        return this.p;
    }

    public boolean h() {
        return com.bytedance.sdk.openadsdk.multipro.b.b() ? com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "is_paid", false) : this.f6227c;
    }

    public String i() {
        return com.bytedance.sdk.openadsdk.multipro.b.b() ? com.bytedance.sdk.openadsdk.multipro.d.a.b("sp_global_info", "keywords", (String) null) : this.f6228d;
    }

    public String j() {
        return com.bytedance.sdk.openadsdk.multipro.b.b() ? com.bytedance.sdk.openadsdk.multipro.d.a.b("sp_global_info", "extra_data", (String) null) : this.f6229e;
    }

    public int k() {
        return com.bytedance.sdk.openadsdk.multipro.b.b() ? com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "title_bar_theme", 0) : this.g;
    }

    public boolean l() {
        return com.bytedance.sdk.openadsdk.multipro.b.b() ? com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "allow_lp_when_screen_lock", false) : this.i;
    }

    public void m() {
        e(this.f6225a);
        f(this.f6226b);
    }

    public com.bytedance.sdk.openadsdk.b.c n() {
        if (this.r == null) {
            this.r = new com.bytedance.sdk.openadsdk.b.c(10, 8);
        }
        return this.r;
    }

    public com.bytedance.sdk.openadsdk.core.video.c.c o() {
        if (this.s == null) {
            this.s = new com.bytedance.sdk.openadsdk.core.video.c.c(10, 8);
        }
        return this.s;
    }

    public boolean p() {
        return com.bytedance.sdk.openadsdk.multipro.b.b() ? com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "is_use_texture", false) : this.k;
    }

    public Bitmap q() {
        return com.bytedance.sdk.openadsdk.multipro.b.b() ? com.bytedance.sdk.openadsdk.utils.d.a(com.bytedance.sdk.openadsdk.multipro.d.a.b("sp_global_info", "pause_icon", (String) null)) : this.l;
    }

    public void a(String str) {
        e(str);
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "app_id", str);
        }
        this.f6225a = str;
    }

    public void b(String str) {
        f(str);
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "name", str);
        }
        this.f6226b = str;
    }

    private static void f(String str) {
        com.bytedance.sdk.openadsdk.utils.r.a(str, "name不能为空");
    }

    private static void h(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.utils.r.a(str.length() <= 1000, "data超长, 最长为1000");
    }

    public void c(int i) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "global_coppa", Integer.valueOf(i));
        } else {
            com.bytedance.sdk.openadsdk.utils.v.a((String) null, o.a()).a("global_coppa", i);
        }
        this.p = i;
    }

    public void d(String str) {
        h(str);
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "extra_data", str);
        }
        this.f6229e = str;
    }

    private static void e(String str) {
        com.bytedance.sdk.openadsdk.utils.r.a(str, "appid不能为空");
    }

    public void a(int i) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "sdk_coppa", Integer.valueOf(i));
        } else {
            com.bytedance.sdk.openadsdk.utils.v.a((String) null, o.a()).a("sdk_coppa", i);
        }
        this.o = i;
    }

    public void b(int i) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "tt_gdrp", Integer.valueOf(i));
        } else {
            com.bytedance.sdk.openadsdk.utils.v.a((String) null, o.a()).a("tt_gdrp", i);
        }
    }

    private static void g(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.utils.r.a(str.length() <= 1000, "keyword超长, 最长为1000");
    }

    public void c(String str) {
        g(str);
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "keywords", str);
        }
        this.f6228d = str;
    }

    public void d(int i) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "title_bar_theme", Integer.valueOf(i));
        }
        this.g = i;
    }

    public void b(boolean z) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "allow_show_notify", Boolean.valueOf(z));
        }
        this.h = z;
    }

    public void a(boolean z) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "is_paid", Boolean.valueOf(z));
        }
        this.f6227c = z;
    }

    public void d(boolean z) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "is_use_texture", Boolean.valueOf(z));
        }
        this.k = z;
    }

    public void c(boolean z) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "allow_lp_when_screen_lock", Boolean.valueOf(z));
        }
        this.i = z;
    }

    public void a(Bitmap bitmap) throws Throwable {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            String strA = com.bytedance.sdk.openadsdk.utils.d.a(bitmap);
            if (!TextUtils.isEmpty(strA)) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "pause_icon", strA);
            }
        }
        this.l = bitmap;
    }

    public void a(String[] strArr) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b() && strArr != null && strArr.length > 0) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    int i2 = i + 1;
                    if (i > 0) {
                        sb.append(",");
                    }
                    sb.append(str);
                    i = i2;
                }
            }
            String string = sb.toString();
            if (!TextUtils.isEmpty(string)) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "need_clear_task_reset", string);
            }
        }
        this.n = strArr;
    }
}
