package com.sandboxol.decorate.d.a.c;

import android.content.Context;
import com.sandboxol.center.router.moduleInfo.decorate.SingleDressInfo;
import com.sandboxol.center.router.moduleInfo.decorate.SuitDressInfo;
import com.sandboxol.decorate.manager.l;
import com.sandboxol.decorate.manager.n;
import com.sandboxol.decorate.manager.v;
import java.util.Iterator;

/* JADX INFO: compiled from: TrySuitClothe.java */
/* JADX INFO: loaded from: classes3.dex */
public class b extends com.sandboxol.decorate.d.a.a.c {
    public b(v vVar, n nVar, l lVar) {
        super(vVar, nVar, lVar);
    }

    @Override // com.sandboxol.decorate.d.a.a.c
    protected void a(Context context, SuitDressInfo suitDressInfo) {
    }

    @Override // com.sandboxol.decorate.d.a.a.c
    protected void b(Context context, SuitDressInfo suitDressInfo) {
        Iterator<SingleDressInfo> it = suitDressInfo.getDecorationInfoList().iterator();
        while (it.hasNext()) {
            this.f17139a.f(it.next().getTypeId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.decorate.d.a.a.c, com.sandboxol.decorate.d.a
    /* JADX INFO: renamed from: e */
    public void d(Context context, SuitDressInfo suitDressInfo) {
        Iterator<SingleDressInfo> it = suitDressInfo.getDecorationInfoList().iterator();
        while (it.hasNext()) {
            this.f17139a.a(it.next().getTypeId());
        }
    }
}
