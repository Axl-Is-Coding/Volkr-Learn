package com.sandboxol.decorate.d.a.a;

import android.content.Context;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.router.moduleInfo.decorate.SingleDressInfo;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.decorate.f.j;
import com.sandboxol.decorate.manager.g;
import com.sandboxol.decorate.manager.l;
import com.sandboxol.decorate.manager.n;
import com.sandboxol.decorate.manager.v;
import com.sandboxol.decorate.view.fragment.dress.ea;
import java.util.Iterator;

/* JADX INFO: compiled from: DressUnclothe.java */
/* JADX INFO: loaded from: classes3.dex */
public class e extends com.sandboxol.decorate.d.a<SingleDressInfo> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b f17148d;

    public e(v vVar, n nVar, l lVar) {
        super(vVar, nVar, lVar);
        this.f17148d = new b(vVar, nVar, lVar);
    }

    protected void c(long j) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.decorate.d.a
    /* JADX INFO: renamed from: c, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void b(SingleDressInfo singleDressInfo) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.decorate.d.a
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public void d(SingleDressInfo singleDressInfo) {
        Messenger.getDefault().send(new SingleDressInfo(singleDressInfo.getTypeId()), MessageToken.TOKEN_DRESS_RADIO_GROUP_MODIFY_ITEM_URL);
    }

    protected void a(Context context, SingleDressInfo singleDressInfo) {
        ea.a(context, singleDressInfo.getId(), singleDressInfo.getTypeId());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.decorate.d.a
    public void b(Context context, SingleDressInfo singleDressInfo) {
        if (n.a(singleDressInfo)) {
            Iterator<Long> it = singleDressInfo.getOccupyPosition().iterator();
            while (it.hasNext()) {
                long jLongValue = it.next().longValue();
                this.f17139a.d(jLongValue);
                c(jLongValue);
                this.f17148d.a(a(jLongValue));
                d(new SingleDressInfo(jLongValue));
            }
            this.f17140b.a(singleDressInfo.getId());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.decorate.d.a
    public void c(Context context, SingleDressInfo singleDressInfo) {
        this.f17140b.a(singleDressInfo, this.f17139a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.decorate.d.a
    public void d(Context context, SingleDressInfo singleDressInfo) {
        a(context, singleDressInfo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.decorate.d.a
    /* JADX INFO: renamed from: d, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void c(SingleDressInfo singleDressInfo) {
        this.f17139a.d(singleDressInfo.getTypeId());
        c(singleDressInfo.getTypeId());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.decorate.d.a
    /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void a(SingleDressInfo singleDressInfo) {
        g.a(j.a(singleDressInfo.getTypeId()));
    }
}
