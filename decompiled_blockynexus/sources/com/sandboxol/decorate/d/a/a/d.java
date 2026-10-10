package com.sandboxol.decorate.d.a.a;

import android.content.Context;
import com.sandboxol.center.router.moduleInfo.decorate.SingleDressInfo;
import com.sandboxol.center.router.moduleInfo.decorate.SuitDressInfo;
import com.sandboxol.decorate.manager.l;
import com.sandboxol.decorate.manager.n;
import com.sandboxol.decorate.manager.v;
import com.sandboxol.decorate.view.fragment.dress.ea;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: DressSuitUnclothe.java */
/* JADX INFO: loaded from: classes3.dex */
public class d extends com.sandboxol.decorate.d.a<SuitDressInfo> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected e f17147d;

    public d(v vVar, n nVar, l lVar) {
        super(vVar, nVar, lVar);
        a();
    }

    protected void a() {
        this.f17147d = new e(this.f17139a, this.f17140b, this.f17141c);
    }

    protected void a(Context context, SuitDressInfo suitDressInfo) {
        ArrayList arrayList = new ArrayList();
        for (SingleDressInfo singleDressInfo : suitDressInfo.getDecorationInfoList()) {
            arrayList.add(Long.valueOf(singleDressInfo.getId()));
            this.f17139a.g(singleDressInfo.getTypeId());
        }
        ea.a(context, arrayList, (ea.a) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.decorate.d.a
    public void b(Context context, SuitDressInfo suitDressInfo) {
        for (SingleDressInfo singleDressInfo : suitDressInfo.getDecorationInfoList()) {
            if (n.a(singleDressInfo)) {
                this.f17147d.b(context, singleDressInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.decorate.d.a
    public void c(Context context, SuitDressInfo suitDressInfo) {
        this.f17140b.h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.decorate.d.a
    public void d(Context context, SuitDressInfo suitDressInfo) {
        a(context, suitDressInfo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.decorate.d.a
    public void c(SuitDressInfo suitDressInfo) {
        this.f17139a.f17215d.remove(Long.valueOf(suitDressInfo.getSuitId()));
        Iterator<SingleDressInfo> it = suitDressInfo.getDecorationInfoList().iterator();
        while (it.hasNext()) {
            this.f17147d.c(it.next());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.decorate.d.a
    public void d(SuitDressInfo suitDressInfo) {
        Iterator<SingleDressInfo> it = suitDressInfo.getDecorationInfoList().iterator();
        while (it.hasNext()) {
            this.f17147d.d(it.next());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.decorate.d.a
    public void b(SuitDressInfo suitDressInfo) {
        Iterator<SingleDressInfo> it = suitDressInfo.getDecorationInfoList().iterator();
        while (it.hasNext()) {
            this.f17147d.b(it.next());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.decorate.d.a
    public void a(SuitDressInfo suitDressInfo) {
        Iterator<SingleDressInfo> it = suitDressInfo.getDecorationInfoList().iterator();
        while (it.hasNext()) {
            this.f17147d.a(it.next());
        }
    }
}
