package com.sandboxol.decorate.d.a.b;

import android.content.Context;
import com.sandboxol.center.router.moduleInfo.decorate.SingleDressInfo;
import com.sandboxol.decorate.entity.ShopRecommendDecorationInfo;
import com.sandboxol.decorate.manager.l;
import com.sandboxol.decorate.manager.n;
import com.sandboxol.decorate.manager.v;

/* JADX INFO: compiled from: ShopClothe.java */
/* JADX INFO: loaded from: classes3.dex */
public class a extends com.sandboxol.decorate.d.a.a.b {
    public a(v vVar, n nVar, l lVar) {
        super(vVar, nVar, lVar);
    }

    @Override // com.sandboxol.decorate.d.a.a.b
    protected void a(Context context, SingleDressInfo singleDressInfo) {
    }

    @Override // com.sandboxol.decorate.d.a.a.b
    protected void b(SingleDressInfo singleDressInfo) {
        if (singleDressInfo.getTypeId() != 6) {
            this.f17139a.f17217f.put(Long.valueOf(singleDressInfo.getTypeId()), new ShopRecommendDecorationInfo(singleDressInfo));
        }
    }

    @Override // com.sandboxol.decorate.d.a.a.b
    protected void c(long j) {
        this.f17139a.f17217f.remove(Long.valueOf(j));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.decorate.d.a.a.b, com.sandboxol.decorate.d.a
    public void d(Context context, SingleDressInfo singleDressInfo) {
    }
}
