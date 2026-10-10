package com.sandboxol.decorate.manager;

import com.sandboxol.center.router.moduleInfo.decorate.SingleDressInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: compiled from: HistoryManager.java */
/* JADX INFO: loaded from: classes3.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LinkedList<SingleDressInfo> f17190a;

    /* JADX INFO: compiled from: HistoryManager.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final l f17191a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final l f17192b;

        static {
            f17191a = new l();
            f17192b = new l();
        }
    }

    public static l c() {
        return a.f17191a;
    }

    public static l d() {
        return a.f17192b;
    }

    public void a(SingleDressInfo singleDressInfo) {
        SingleDressInfo singleDressInfo2 = new SingleDressInfo(singleDressInfo);
        singleDressInfo2.setItemType(0);
        singleDressInfo2.setBlankType(0);
        Iterator<SingleDressInfo> it = this.f17190a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            SingleDressInfo next = it.next();
            if (next.getId() == singleDressInfo.getId()) {
                this.f17190a.remove(next);
                break;
            }
        }
        this.f17190a.addFirst(singleDressInfo2);
    }

    public LinkedList<SingleDressInfo> b() {
        return this.f17190a;
    }

    private l() {
        this.f17190a = new LinkedList<>();
    }

    public void a(v vVar) {
        ArrayList arrayList = new ArrayList();
        for (SingleDressInfo singleDressInfo : this.f17190a) {
            if (!vVar.f17213b.containsValue(singleDressInfo.getResourceId())) {
                arrayList.add(singleDressInfo);
            }
        }
        this.f17190a.removeAll(arrayList);
    }

    public void a() {
        this.f17190a.clear();
    }
}
