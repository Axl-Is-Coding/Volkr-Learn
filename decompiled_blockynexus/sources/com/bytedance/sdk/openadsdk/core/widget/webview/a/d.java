package com.bytedance.sdk.openadsdk.core.widget.webview.a;

import android.text.TextUtils;
import com.bytedance.sdk.adnet.b.i;
import com.bytedance.sdk.adnet.b.j;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.ab;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* JADX INFO: compiled from: TmplDiffManager.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile d f6648a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AtomicLong f6649b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ScheduledFuture<?> f6650c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AtomicBoolean f6651d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private AtomicBoolean f6652e = new AtomicBoolean(false);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private CopyOnWriteArrayList<j> f6653f = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<i> g = new CopyOnWriteArrayList<>();

    /* JADX INFO: compiled from: TmplDiffManager.java */
    private class a implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f6661b;

        public a(int i) {
            this.f6661b = 0;
            this.f6661b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f6661b == 1) {
                d.this.g();
                com.bytedance.sdk.openadsdk.i.a.a().a(d.this.new a(1), d.this.f6649b.get());
            }
        }
    }

    private d() {
        f();
    }

    private void f() {
        this.f6649b = new AtomicLong(o.h().j() * 1000);
        this.f6651d = new AtomicBoolean(false);
        this.f6650c = com.bytedance.sdk.openadsdk.i.a.a().a((Runnable) new a(1), 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        JSONObject jSONObjectA;
        List<l> listB = c.a().b();
        if (listB.isEmpty()) {
            return;
        }
        for (l lVar : listB) {
            if (this.f6652e.get()) {
                return;
            }
            if (!TextUtils.isEmpty(lVar.d()) && (jSONObjectA = a(lVar.d(), true)) != null) {
                String strOptString = jSONObjectA.optString("md5");
                String strOptString2 = jSONObjectA.optString("version");
                String strOptString3 = jSONObjectA.optString("data");
                if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString2) && !TextUtils.isEmpty(strOptString3) && !strOptString.equals(lVar.c())) {
                    lVar.c(strOptString).e(strOptString3);
                    if (f.b(strOptString2)) {
                        lVar.f(strOptString2);
                        b.a().a(true);
                    }
                    c.a().a(lVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        int iB;
        com.bytedance.sdk.openadsdk.utils.o.b("TmplDiffManager", "start doCheckAndDeleteTask");
        if (o.h() != null && (iB = o.h().b() * 3) > 0) {
            List<l> listB = c.a().b();
            if (listB.isEmpty() || iB >= listB.size()) {
                com.bytedance.sdk.openadsdk.utils.o.b("TmplDiffManager", "end doCheckAndDeleteTask maxTplCnt,local size" + iB + "," + listB.size());
                return;
            }
            int size = (int) (listB.size() - (iB * 0.75f));
            com.bytedance.sdk.openadsdk.utils.o.b("TmplDiffManager", "doCheckAndDeleteTask maxTplCnt,local size,deleteCnt:" + iB + "," + listB.size() + "," + size);
            HashSet hashSet = new HashSet();
            for (int i = 0; i < size; i++) {
                hashSet.add(listB.get(i).b());
            }
            a(hashSet);
            com.bytedance.sdk.openadsdk.utils.o.b("TmplDiffManager", "end doCheckAndDeleteTask");
            this.f6651d.set(false);
        }
    }

    private void i() {
        CopyOnWriteArrayList<j> copyOnWriteArrayList = this.f6653f;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.clear();
        }
        CopyOnWriteArrayList<i> copyOnWriteArrayList2 = this.g;
        if (copyOnWriteArrayList2 != null) {
            copyOnWriteArrayList2.clear();
        }
    }

    public void d() {
        if (this.f6651d.getAndSet(true)) {
            return;
        }
        com.bytedance.sdk.openadsdk.i.a.a().a(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.widget.webview.a.d.1
            @Override // java.lang.Runnable
            public void run() {
                d.this.h();
            }
        }, 60000L);
    }

    public void e() {
        this.f6652e.set(true);
        CopyOnWriteArrayList<i> copyOnWriteArrayList = this.g;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            for (i iVar : this.g) {
                if (iVar != null) {
                    try {
                        if (!iVar.isDone() || !iVar.isCancelled()) {
                            iVar.cancel(true);
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        }
        CopyOnWriteArrayList<j> copyOnWriteArrayList2 = this.f6653f;
        if (copyOnWriteArrayList2 != null && copyOnWriteArrayList2.size() > 0) {
            for (j jVar : this.f6653f) {
                if (jVar != null) {
                    jVar.cancel();
                }
            }
        }
        i();
    }

    public void b() {
        f();
    }

    public void c() {
        long j = o.h().j() * 1000;
        if (this.f6649b.get() != j) {
            ScheduledFuture<?> scheduledFuture = this.f6650c;
            if (scheduledFuture != null && scheduledFuture.isCancelled()) {
                this.f6650c.cancel(true);
            }
            this.f6649b.set(j);
            this.f6650c = com.bytedance.sdk.openadsdk.i.a.a().a((Runnable) new a(1), 0L);
        }
    }

    public static d a() {
        if (f6648a == null) {
            synchronized (d.class) {
                if (f6648a == null) {
                    f6648a = new d();
                }
            }
        }
        return f6648a;
    }

    public l a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return c.a().a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public JSONObject a(String str, boolean z) {
        if (this.f6652e.get()) {
            return null;
        }
        i iVarA = i.a();
        j jVar = new j(0, str, iVarA);
        jVar.setResponseOnMain(false).setShouldCache(false).build(com.bytedance.sdk.openadsdk.g.d.a(o.a()).d());
        if (z) {
            this.f6653f.add(jVar);
            this.g.add(iVarA);
        }
        try {
            m mVar = iVarA.get();
            if (mVar != null && mVar.a() && mVar.f5538a != 0) {
                return new JSONObject((String) mVar.f5538a);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return null;
    }

    public void a(h hVar) {
        if (hVar == null || hVar.u() == null) {
            return;
        }
        String strB = hVar.u().b();
        String strD = hVar.u().d();
        String strC = hVar.u().c();
        int iD = ab.d(hVar.M());
        a(com.bytedance.sdk.openadsdk.core.g.j.a().a(strB).b(strC).c(strD), iD + "");
    }

    public synchronized void a(com.bytedance.sdk.openadsdk.core.g.j jVar, String str) {
        if (jVar == null) {
            return;
        }
        final String str2 = jVar.f6222a;
        final String str3 = jVar.f6224c;
        final String str4 = jVar.f6223b;
        if (TextUtils.isEmpty(str)) {
            str = com.bytedance.sdk.openadsdk.core.h.b().c();
        }
        final String str5 = str;
        if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str2)) {
            com.bytedance.sdk.openadsdk.i.a.a().b(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.widget.webview.a.d.2
                @Override // java.lang.Runnable
                public void run() {
                    l lVarA = d.this.a(str2);
                    if (lVarA != null && str4.equals(lVarA.c())) {
                        if (com.bytedance.sdk.openadsdk.core.widget.webview.a.a.g()) {
                            return;
                        }
                        b.a().a(true);
                        return;
                    }
                    JSONObject jSONObjectA = d.this.a(str3, false);
                    if (jSONObjectA != null) {
                        String strOptString = jSONObjectA.optString("md5");
                        String strOptString2 = jSONObjectA.optString("version");
                        String strOptString3 = jSONObjectA.optString("data");
                        if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2) || TextUtils.isEmpty(strOptString3)) {
                            return;
                        }
                        l lVarF = new l().a(str5).b(str2).c(strOptString).d(str3).e(strOptString3).f(strOptString2);
                        c.a().a(lVarF);
                        if (f.b(strOptString2)) {
                            lVarF.f(strOptString2);
                            b.a().a(true);
                        }
                    }
                }
            }, 10);
        }
    }

    public void a(Set<String> set) {
        try {
            c.a().a(set);
        } catch (Throwable unused) {
        }
    }

    public void a(boolean z) {
        this.f6652e.set(z);
    }
}
