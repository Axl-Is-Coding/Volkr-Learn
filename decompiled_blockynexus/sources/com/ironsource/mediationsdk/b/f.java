package com.ironsource.mediationsdk.b;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.ironsource.mediationsdk.V;
import com.ironsource.mediationsdk.model.s;
import com.ironsource.mediationsdk.sdk.C2353h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: BaseEventsManager.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class f implements b.f.b.d {
    int D;
    String E;
    String F;
    Set<Integer> G;
    private a H;
    private V I;
    private s J;
    private com.ironsource.mediationsdk.logger.c K;
    private boolean k;
    private b.f.b.a m;
    private com.ironsource.mediationsdk.b.a n;
    private ArrayList<b.f.b.b> o;
    private int q;
    private String r;
    private Context s;
    private int[] w;
    private int[] x;
    private int[] y;
    private int[] z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f14780a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f14781b = 100;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f14782c = 5000;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f14783d = 90000;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final int f14784e = 1024;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f14785f = 5;
    final String g = "supersonic_sdk.db";
    final String h = com.umeng.analytics.pro.b.L;
    final String i = "placement";
    private final String j = "abt";
    private boolean l = false;
    private boolean p = true;
    private int t = 100;
    private int u = 5000;
    private int v = 1;
    private Map<String, String> A = new HashMap();
    private Map<String, String> B = new HashMap();
    private String C = "";
    private final Object L = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: BaseEventsManager.java */
    class a extends HandlerThread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Handler f14786a;

        a(String str) {
            super(str);
        }

        void a(Runnable runnable) {
            this.f14786a.post(runnable);
        }

        void a() {
            this.f14786a = new Handler(getLooper());
        }
    }

    static /* synthetic */ int e(f fVar) {
        int i = fVar.q;
        fVar.q = i + 1;
        return i;
    }

    protected abstract int a(b.f.b.b bVar);

    protected abstract String a(int i);

    protected abstract boolean b(b.f.b.b bVar);

    protected abstract void d();

    protected abstract void d(b.f.b.b bVar);

    protected abstract boolean e(b.f.b.b bVar);

    protected abstract boolean f(b.f.b.b bVar);

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized int g(b.f.b.b bVar) {
        return bVar.c() + 90000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void h() {
        ArrayList<b.f.b.b> arrayListA;
        this.l = false;
        synchronized (this.L) {
            arrayListA = a(this.o, this.m.c(this.F), this.u);
            this.o.clear();
            this.m.a(this.F);
        }
        this.q = 0;
        if (arrayListA.size() > 0) {
            JSONObject jSONObjectB = C2353h.a().b();
            try {
                a(jSONObjectB);
                String strA = a();
                if (!TextUtils.isEmpty(strA)) {
                    jSONObjectB.put("abt", strA);
                }
                Map<String, String> mapB = b();
                if (!mapB.isEmpty()) {
                    for (Map.Entry<String, String> entry : mapB.entrySet()) {
                        if (!jSONObjectB.has(entry.getKey())) {
                            jSONObjectB.put(entry.getKey(), entry.getValue());
                        }
                    }
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            new b.f.b.c(new d(this)).execute(this.n.a(arrayListA, jSONObjectB), this.n.b(), arrayListA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i() {
        return (this.q >= this.t || this.l) && this.k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j(b.f.b.b bVar) {
        return (bVar.c() == 14 || bVar.c() == 114 || bVar.c() == 514 || bVar.c() == 140 || bVar.c() == 40 || bVar.c() == 41 || bVar.c() == 50 || bVar.c() == 51 || bVar.c() == 52) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k(b.f.b.b bVar) {
        if (bVar == null) {
            return false;
        }
        if (a(this.w)) {
            return true ^ a(bVar.c(), this.w);
        }
        if (a(this.x)) {
            return a(bVar.c(), this.x);
        }
        return true;
    }

    public void f() {
        h();
    }

    private void b(String str) {
        com.ironsource.mediationsdk.b.a aVar = this.n;
        if (aVar == null || !aVar.c().equals(str)) {
            this.n = g.a(str, this.D);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        synchronized (this.L) {
            this.m.a(this.o, this.F);
            this.o.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i(b.f.b.b bVar) {
        return (bVar.c() == 40 || bVar.c() == 41 || bVar.c() == 50 || bVar.c() == 51 || bVar.c() == 52) ? false : true;
    }

    public synchronized void c(b.f.b.b bVar) {
        this.H.a(new b(this, bVar));
    }

    public void d(int i) {
        if (i > 0) {
            this.t = i;
        }
    }

    void e() {
        this.o = new ArrayList<>();
        this.q = 0;
        this.n = g.a(this.E, this.D);
        this.H = new a(this.F + "EventThread");
        this.H.start();
        this.H.a();
        this.K = com.ironsource.mediationsdk.logger.c.c();
        this.r = com.ironsource.mediationsdk.utils.j.e();
        this.G = new HashSet();
        d();
    }

    public void d(int[] iArr, Context context) {
        this.y = iArr;
        com.ironsource.mediationsdk.utils.j.d(context, this.F, iArr);
    }

    public void b(int i) {
        if (i > 0) {
            this.v = i;
        }
    }

    public void c(int i) {
        if (i > 0) {
            this.u = i;
        }
    }

    public void b(int[] iArr, Context context) {
        this.x = iArr;
        com.ironsource.mediationsdk.utils.j.b(context, this.F, iArr);
    }

    public void c(int[] iArr, Context context) {
        this.w = iArr;
        com.ironsource.mediationsdk.utils.j.c(context, this.F, iArr);
    }

    public void b(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.E = str;
        com.ironsource.mediationsdk.utils.j.d(context, this.F, str);
        b(str);
    }

    public Map<String, String> c() {
        return this.B;
    }

    public synchronized void a(Context context, V v) {
        this.E = com.ironsource.mediationsdk.utils.j.a(context, this.F, this.E);
        b(this.E);
        this.n.a(com.ironsource.mediationsdk.utils.j.b(context, this.F, (String) null));
        this.m = b.f.b.a.a(context, "supersonic_sdk.db", 5);
        g();
        this.w = com.ironsource.mediationsdk.utils.j.c(context, this.F);
        this.x = com.ironsource.mediationsdk.utils.j.b(context, this.F);
        this.y = com.ironsource.mediationsdk.utils.j.d(context, this.F);
        this.z = com.ironsource.mediationsdk.utils.j.a(context, this.F);
        this.I = v;
        this.s = context;
    }

    public void b(boolean z) {
        this.p = z;
    }

    public Map<String, String> b() {
        return this.A;
    }

    public void b(Map<String, String> map) {
        this.B.putAll(map);
    }

    public synchronized void a(s sVar) {
        this.J = sVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean a(String str, b.f.b.b bVar) {
        boolean zContains;
        if (!str.equalsIgnoreCase("none")) {
            return false;
        }
        if (a(this.z)) {
            zContains = a(bVar.c(), this.z);
        } else {
            zContains = this.G.contains(Integer.valueOf(bVar.c()));
        }
        return zContains;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h(b.f.b.b bVar) {
        JSONObject jSONObjectB = bVar.b();
        if (jSONObjectB == null) {
            return false;
        }
        return jSONObjectB.has("sessionDepth");
    }

    private ArrayList<b.f.b.b> a(ArrayList<b.f.b.b> arrayList, ArrayList<b.f.b.b> arrayList2, int i) {
        ArrayList arrayList3 = new ArrayList();
        arrayList3.addAll(arrayList);
        arrayList3.addAll(arrayList2);
        Collections.sort(arrayList3, new e(this));
        if (arrayList3.size() <= i) {
            return new ArrayList<>(arrayList3);
        }
        ArrayList<b.f.b.b> arrayList4 = new ArrayList<>(arrayList3.subList(0, i));
        this.m.a(arrayList3.subList(i, arrayList3.size()), this.F);
        return arrayList4;
    }

    public void a(int[] iArr, Context context) {
        this.z = iArr;
        com.ironsource.mediationsdk.utils.j.a(context, this.F, iArr);
    }

    public void a(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.ironsource.mediationsdk.b.a aVar = this.n;
        if (aVar != null) {
            aVar.a(str);
        }
        com.ironsource.mediationsdk.utils.j.e(context, this.F, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(ArrayList<b.f.b.b> arrayList) {
        return arrayList != null && arrayList.size() >= this.v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int[] iArr) {
        return iArr != null && iArr.length > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, int[] iArr) {
        if (!a(iArr)) {
            return false;
        }
        for (int i2 : iArr) {
            if (i == i2) {
                return true;
            }
        }
        return false;
    }

    public void a(boolean z) {
        this.k = z;
    }

    private void a(JSONObject jSONObject) {
        try {
            if (this.I == null) {
                if (this.J != null) {
                    String strB = this.J.b();
                    if (!TextUtils.isEmpty(strB)) {
                        jSONObject.put("segmentId", strB);
                    }
                    JSONObject jSONObjectA = this.J.a();
                    Iterator<String> itKeys = jSONObjectA.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        jSONObject.put(next, jSONObjectA.get(next));
                    }
                    return;
                }
                return;
            }
            this.I.a();
            throw null;
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void a(String str) {
        this.C = str;
    }

    public String a() {
        return this.C;
    }

    public void a(Map<String, String> map) {
        this.A.putAll(map);
    }

    public void a(Map<String, Object> map, int i, String str) {
        map.put("auctionTrials", Integer.valueOf(i));
        if (TextUtils.isEmpty(str)) {
            return;
        }
        map.put("auctionFallback", str);
    }

    private void a(b.f.b.b bVar, String str, int i) {
        JSONObject jSONObjectB = bVar.b();
        if (jSONObjectB == null || !jSONObjectB.has(str)) {
            return;
        }
        try {
            String string = jSONObjectB.getString(str);
            bVar.a(str, string.substring(0, Math.min(string.length(), i)));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b.f.b.b bVar, String str) {
        a(bVar, str, 1024);
    }
}
