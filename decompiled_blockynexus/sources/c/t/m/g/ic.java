package c.t.m.g;

import c.t.m.g.qc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class ic {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f3245a = "AccessIpMgr";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f3246b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Map<String, a> f3247c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static qc.a f3248d;

    static {
        new ConcurrentHashMap();
        f3247c = new ConcurrentHashMap();
        f3248d = new qc.a();
    }

    public static oc a(String str) {
        a aVar = f3247c.get(str);
        if (aVar != null) {
            oc ocVar = new oc(aVar.f3250b, aVar.g);
            ocVar.f3335c = aVar.a();
            return ocVar;
        }
        gc gcVar = new gc(str);
        gcVar.f3217e = (byte) 3;
        oc ocVar2 = new oc(str, "");
        ArrayList arrayList = new ArrayList();
        arrayList.add(gcVar);
        ocVar2.f3335c = arrayList;
        return ocVar2;
    }

    public static void a() {
        fc.j().post(new mc());
    }

    public static void a(String str, gc gcVar, int i) {
        a aVar = f3247c.get(str);
        if (aVar == null || i == 0) {
            return;
        }
        aVar.b(gcVar);
    }

    public static void b() {
        C0434ia.d().f();
    }

    public static void c() {
        List<oc> listA = C0434ia.d().f().a();
        if (listA != null) {
            f3247c.clear();
            for (oc ocVar : listA) {
                a aVar = new a(f3246b);
                aVar.f3250b = ocVar.f3333a;
                aVar.g = ocVar.f3334b;
                Iterator<gc> it = ocVar.f3335c.iterator();
                while (it.hasNext()) {
                    aVar.a(it.next());
                }
                gc gcVar = new gc(ocVar.f3333a);
                gcVar.f3217e = (byte) 3;
                aVar.a(gcVar);
                f3247c.put(ocVar.f3333a, aVar);
            }
        }
    }

    static /* synthetic */ void d() {
        f3246b = qc.b();
        C0434ia.d().f();
        c();
    }

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f3249a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f3250b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private List<gc> f3251c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private List<gc> f3252d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private List<gc> f3253e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private List<gc> f3254f;
        String g;

        public a(String str) {
            this.f3249a = str;
        }

        public final List<gc> a() {
            ArrayList arrayList = new ArrayList();
            List<gc> list = this.f3251c;
            if (list != null && list.size() > 0) {
                arrayList.addAll(list);
            }
            List<gc> list2 = this.f3252d;
            if (list2 != null && list2.size() > 0) {
                arrayList.addAll(list2);
            }
            List<gc> list3 = this.f3253e;
            if (list3 != null && list3.size() > 0) {
                arrayList.addAll(list3);
            }
            List<gc> list4 = this.f3254f;
            if (list4 != null && list4.size() > 0) {
                arrayList.addAll(list4);
            }
            return arrayList;
        }

        public final synchronized void b(gc gcVar) {
            if (gcVar == null) {
                return;
            }
            if (gcVar.f3217e == 1) {
                if (this.f3251c != null && !this.f3251c.isEmpty() && gcVar.a(this.f3251c.get(0))) {
                    this.f3251c.remove(0);
                }
            } else if (gcVar.f3217e == 2 && this.f3252d != null && !this.f3252d.isEmpty() && gcVar.a(this.f3252d.get(0))) {
                this.f3252d.remove(0);
            }
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Appid：" + ((Object) null) + " domain：" + this.f3250b + "\r\n");
            sb.append("apn：" + this.f3249a + " ckIP：" + ((String) null) + "\r\n");
            Iterator<gc> it = a().iterator();
            while (it.hasNext()) {
                sb.append("accessIP：" + it.next().toString() + "\r\n");
            }
            return sb.toString();
        }

        public final void a(gc gcVar) {
            if (gcVar == null) {
                return;
            }
            byte b2 = gcVar.f3217e;
            if (b2 == 1) {
                if (this.f3251c == null) {
                    this.f3251c = new ArrayList();
                }
                this.f3251c.add(gcVar);
                return;
            }
            if (b2 == 2) {
                if (this.f3252d == null) {
                    this.f3252d = new ArrayList();
                }
                this.f3252d.add(gcVar);
            } else if (b2 == 3) {
                if (this.f3253e == null) {
                    this.f3253e = new ArrayList();
                }
                this.f3253e.add(gcVar);
            } else if (b2 == 4) {
                if (this.f3254f == null) {
                    this.f3254f = new ArrayList();
                }
                this.f3254f.add(gcVar);
            } else {
                if (this.f3251c == null) {
                    this.f3251c = new ArrayList();
                }
                this.f3251c.add(gcVar);
            }
        }
    }
}
