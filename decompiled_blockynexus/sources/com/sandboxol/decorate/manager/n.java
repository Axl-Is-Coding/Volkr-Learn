package com.sandboxol.decorate.manager;

import androidx.databinding.ObservableMap;
import com.sandboxol.center.router.moduleInfo.decorate.SingleDressInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import rx.Observable;
import rx.functions.Action1;

/* JADX INFO: compiled from: OccupyManager.java */
/* JADX INFO: loaded from: classes3.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<Long> f17193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<Long> f17194b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<Long> f17195c;

    /* JADX INFO: compiled from: OccupyManager.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final n f17196a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final n f17197b;

        static {
            f17196a = new n();
            f17197b = new n();
        }
    }

    public static boolean a(SingleDressInfo singleDressInfo) {
        return singleDressInfo.getTypeId() == 16 && singleDressInfo.getOccupyPosition() != null && singleDressInfo.getOccupyPosition().size() > 0;
    }

    public static n b() {
        return a.f17196a;
    }

    public static n c() {
        return a.f17197b;
    }

    public static void g() {
        c().f17193a.clear();
        c().f17194b.clear();
        c().f17193a.addAll(b().f17193a);
        c().f17194b.addAll(b().f17194b);
    }

    public List<Long> d() {
        return this.f17194b;
    }

    public List<Long> e() {
        return this.f17195c;
    }

    public void f() {
        this.f17193a.clear();
    }

    public void h() {
        this.f17194b.clear();
    }

    private n() {
        this.f17193a = new ArrayList();
        this.f17194b = new ArrayList();
        this.f17195c = new ArrayList();
    }

    public void a(List<SingleDressInfo> list, final ObservableMap<Long, String> observableMap, final ObservableMap<Long, String> observableMap2, final boolean z) {
        Observable.from(list).subscribe(new Action1() { // from class: com.sandboxol.decorate.manager.c
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f17168a.a(observableMap, z, observableMap2, (SingleDressInfo) obj);
            }
        });
    }

    public void b(List<Long> list) {
        this.f17195c.clear();
        this.f17195c.addAll(list);
    }

    public /* synthetic */ void a(ObservableMap observableMap, boolean z, ObservableMap observableMap2, SingleDressInfo singleDressInfo) {
        if (singleDressInfo.getTypeId() != 16 || singleDressInfo.getOccupyPosition() == null || singleDressInfo.getOccupyPosition().size() <= 0) {
            return;
        }
        for (Long l : singleDressInfo.getOccupyPosition()) {
            observableMap.put(l, com.sandboxol.decorate.f.j.b(l.longValue()));
            if (z) {
                observableMap2.put(l, "empty");
            }
        }
        if (z) {
            b(singleDressInfo.getOccupyPosition());
        }
    }

    public void a(long j) {
        this.f17193a.remove(Long.valueOf(j));
    }

    public void a(ObservableMap<Long, String> observableMap, SingleDressInfo singleDressInfo) {
        if (singleDressInfo.getTypeId() != 16 || observableMap == null || singleDressInfo.getOccupyPosition() == null) {
            return;
        }
        Iterator<Long> it = singleDressInfo.getOccupyPosition().iterator();
        while (it.hasNext()) {
            long jLongValue = it.next().longValue();
            observableMap.put(Long.valueOf(jLongValue), com.sandboxol.decorate.f.j.b(jLongValue));
            if (singleDressInfo.getSuitId() != 0) {
                this.f17194b.add(Long.valueOf(jLongValue));
            }
        }
        this.f17193a.addAll(singleDressInfo.getOccupyPosition());
    }

    public void a(List<Long> list) {
        this.f17194b.clear();
        this.f17194b.addAll(list);
    }

    public void a(SingleDressInfo singleDressInfo, v vVar) {
        if (singleDressInfo.getTypeId() == 16) {
            Iterator<Long> it = singleDressInfo.getOccupyPosition().iterator();
            while (it.hasNext()) {
                if (this.f17194b.contains(Long.valueOf(it.next().longValue()))) {
                    this.f17194b.clear();
                    vVar.f17215d.clear();
                }
            }
            return;
        }
        if (this.f17194b.contains(Long.valueOf(singleDressInfo.getTypeId()))) {
            this.f17194b.clear();
            vVar.f17215d.clear();
        }
    }

    public void a() {
        this.f17193a.clear();
        this.f17194b.clear();
    }
}
