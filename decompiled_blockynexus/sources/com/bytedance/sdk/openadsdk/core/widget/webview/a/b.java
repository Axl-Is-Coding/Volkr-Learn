package com.bytedance.sdk.openadsdk.core.widget.webview.a;

import com.bytedance.sdk.adnet.b.i;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.h;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: TemplateManager.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static File f6637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile b f6638b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AtomicBoolean f6639c = new AtomicBoolean(true);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AtomicBoolean f6640d = new AtomicBoolean(false);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f6641e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private CopyOnWriteArrayList<com.bytedance.sdk.adnet.b.c> f6642f = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<i> g = new CopyOnWriteArrayList<>();
    private AtomicBoolean h = new AtomicBoolean(false);
    private AtomicInteger i = new AtomicInteger(0);
    private AtomicLong j = new AtomicLong();

    private b() {
        h();
    }

    public static File f() {
        if (f6637a == null) {
            try {
                File file = new File(new File(o.a().getCacheDir(), "tt_tmpl_pkg"), MessengerShareContentUtility.ATTACHMENT_TEMPLATE_TYPE);
                file.mkdirs();
                f6637a = file;
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.utils.o.c("TemplateManager", "getTemplateDir error", th);
            }
        }
        return f6637a;
    }

    private void h() {
        com.bytedance.sdk.openadsdk.utils.o.b("TemplateManager", "init......1");
        com.bytedance.sdk.openadsdk.i.a.a().b(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.widget.webview.a.b.1
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                f.a();
                b.this.f6639c.set(false);
                com.bytedance.sdk.openadsdk.utils.o.b("TemplateManager", "init......2");
                b.this.i();
                b.this.e();
                com.bytedance.sdk.openadsdk.utils.o.b("TemplateManager", "init......3");
            }
        }, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() throws Throwable {
        com.bytedance.sdk.openadsdk.utils.o.b("TemplateManager", "check template usable1");
        k kVarB = f.b();
        if (kVarB == null || !kVarB.e()) {
            com.bytedance.sdk.openadsdk.utils.o.b("TemplateManager", "check template usable2");
            return;
        }
        boolean z = true;
        for (k.a aVar : kVarB.d()) {
            String strA = aVar.a();
            File file = new File(f(), h.a(strA));
            String strA2 = h.a(file);
            if (!file.exists() || !file.isFile() || aVar.b() == null || !aVar.b().equals(strA2)) {
                z = false;
                com.bytedance.sdk.openadsdk.utils.o.b("TemplateManager", "check template usable3: " + strA + "," + file.getAbsolutePath());
                break;
            }
        }
        if (!z) {
            f.d();
        }
        com.bytedance.sdk.openadsdk.utils.o.b("TemplateManager", "check template usable4: " + z);
        this.f6641e = z;
    }

    private void j() {
        com.bytedance.sdk.openadsdk.utils.o.e("TemplateManager", "任务执行完，，，clearCurrentExecuteTaskList");
        CopyOnWriteArrayList<com.bytedance.sdk.adnet.b.c> copyOnWriteArrayList = this.f6642f;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.clear();
        }
        CopyOnWriteArrayList<i> copyOnWriteArrayList2 = this.g;
        if (copyOnWriteArrayList2 != null) {
            copyOnWriteArrayList2.clear();
        }
    }

    private void k() {
        if (this.i.getAndSet(0) <= 0 || System.currentTimeMillis() - this.j.get() <= 600000) {
            return;
        }
        e();
    }

    public boolean c() {
        return this.f6641e;
    }

    public k d() {
        return f.b();
    }

    public void e() {
        a(false);
    }

    public void g() {
        this.h.set(true);
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
        CopyOnWriteArrayList<com.bytedance.sdk.adnet.b.c> copyOnWriteArrayList2 = this.f6642f;
        if (copyOnWriteArrayList2 != null && copyOnWriteArrayList2.size() > 0) {
            for (com.bytedance.sdk.adnet.b.c cVar : this.f6642f) {
                if (cVar != null) {
                    cVar.cancel();
                }
            }
        }
        j();
        this.f6641e = false;
        this.f6640d.set(false);
    }

    public static b a() {
        if (f6638b == null) {
            synchronized (b.class) {
                if (f6638b == null) {
                    f6638b = new b();
                }
            }
        }
        return f6638b;
    }

    public void b() {
        h();
    }

    public void b(boolean z) {
        this.h.set(z);
    }

    public void a(boolean z) {
        m mVar;
        if (this.f6639c.get()) {
            com.bytedance.sdk.openadsdk.utils.o.b("TemplateManager", "loadTemplate error1");
            return;
        }
        try {
            if (this.f6640d.get()) {
                if (z) {
                    this.i.getAndIncrement();
                }
                com.bytedance.sdk.openadsdk.utils.o.b("TemplateManager", "loadTemplate error2: " + z);
                return;
            }
            com.bytedance.sdk.openadsdk.utils.o.b("TemplateManager", "init......5");
            this.f6640d.set(true);
            k kVarA = o.f().a();
            k kVarB = f.b();
            if (kVarA != null && kVarA.e()) {
                com.bytedance.sdk.openadsdk.utils.o.b("TemplateManager", "init......7");
                if (!f.b(kVarA.b())) {
                    this.f6640d.set(false);
                    this.j.set(System.currentTimeMillis());
                    com.bytedance.sdk.openadsdk.utils.o.b("TemplateManager", "loadTemplate error4");
                    return;
                }
                com.bytedance.sdk.openadsdk.utils.o.b("TemplateManager", "init......8");
                ArrayList<k.a> arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                if (kVarB != null && !kVarB.d().isEmpty()) {
                    if (kVarA.d().isEmpty()) {
                        arrayList.addAll(kVarB.d());
                        com.bytedance.sdk.openadsdk.utils.o.b("TemplateManager", "loadTemplate update2");
                    } else {
                        for (k.a aVar : kVarA.d()) {
                            if (!kVarB.d().contains(aVar)) {
                                arrayList2.add(aVar);
                            } else {
                                k.a aVarA = f.a(aVar.a());
                                if (aVarA != null && aVar.b() != null && !aVar.b().equals(aVarA.b())) {
                                    arrayList2.add(aVar);
                                }
                            }
                        }
                        for (k.a aVar2 : kVarB.d()) {
                            if (!kVarA.d().contains(aVar2)) {
                                arrayList.add(aVar2);
                            }
                        }
                        com.bytedance.sdk.openadsdk.utils.o.b("TemplateManager", "loadTemplate update3");
                    }
                } else {
                    arrayList2.addAll(kVarA.d());
                    com.bytedance.sdk.openadsdk.utils.o.b("TemplateManager", "loadTemplate update1");
                }
                com.bytedance.sdk.openadsdk.utils.o.b("TemplateManager", "init......9");
                for (k.a aVar3 : arrayList2) {
                    if (this.h.get()) {
                        com.bytedance.sdk.openadsdk.utils.o.e("TemplateManager", "isCancel，，，任务结束是。。。。。0");
                        return;
                    }
                    String strA = aVar3.a();
                    File file = new File(f(), h.a(strA));
                    File file2 = new File(file + ".tmp");
                    if (file.exists()) {
                        try {
                            file.delete();
                        } catch (Throwable unused) {
                        }
                    }
                    if (file2.exists()) {
                        try {
                            file2.delete();
                        } catch (Throwable unused2) {
                        }
                    }
                    i iVarA = i.a();
                    com.bytedance.sdk.adnet.b.c cVar = new com.bytedance.sdk.adnet.b.c(file.getAbsolutePath(), strA, iVarA);
                    cVar.build(com.bytedance.sdk.openadsdk.g.d.a(o.a()).c());
                    this.f6642f.add(cVar);
                    this.g.add(iVarA);
                    try {
                        mVar = iVarA.get();
                    } catch (Throwable unused3) {
                        mVar = null;
                    }
                    if (mVar == null || !mVar.a()) {
                        this.f6640d.set(false);
                        a(arrayList2);
                        com.bytedance.sdk.openadsdk.utils.o.b("TemplateManager", "loadTemplate error5");
                        j();
                        return;
                    }
                }
                j();
                for (k.a aVar4 : arrayList) {
                    if (this.h.get()) {
                        com.bytedance.sdk.openadsdk.utils.o.e("TemplateManager", "isCancel，，，任务结束是。。。。。1");
                        return;
                    }
                    File file3 = new File(f(), h.a(aVar4.a()));
                    File file4 = new File(file3 + ".tmp");
                    if (file3.exists()) {
                        try {
                            file3.delete();
                        } catch (Throwable unused4) {
                        }
                    }
                    if (file4.exists()) {
                        try {
                            file4.delete();
                        } catch (Throwable unused5) {
                        }
                    }
                }
                if (this.h.get()) {
                    com.bytedance.sdk.openadsdk.utils.o.e("TemplateManager", "isCancel，，，任务结束是。。。。。2");
                    return;
                }
                f.a(kVarA);
                f.c();
                com.bytedance.sdk.openadsdk.utils.o.b("TemplateManager", "loadTemplate update success: " + kVarA.b());
                i();
                this.f6640d.set(false);
                this.j.set(System.currentTimeMillis());
                k();
                return;
            }
            this.f6640d.set(false);
            a(109);
            com.bytedance.sdk.openadsdk.utils.o.b("TemplateManager", "loadTemplate error3");
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.utils.o.a("TemplateManager", "loadTemplate error: ", th);
        }
    }

    private void a(int i) {
        com.bytedance.sdk.openadsdk.f.a.a().c(com.bytedance.sdk.openadsdk.f.a.c.b().b(i).f(g.a(i)));
    }

    private void a(List<k.a> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<k.a> it = list.iterator();
        while (it.hasNext()) {
            File file = new File(f(), h.a(it.next().a()));
            File file2 = new File(file + ".tmp");
            if (file.exists()) {
                try {
                    file.delete();
                } catch (Throwable unused) {
                }
            }
            if (file2.exists()) {
                try {
                    file2.delete();
                } catch (Throwable unused2) {
                }
            }
        }
    }
}
