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

/* JADX INFO: compiled from: DressClothe.java */
/* JADX INFO: loaded from: classes3.dex */
public class b extends com.sandboxol.decorate.d.a<SingleDressInfo> {
    public b(v vVar, n nVar, l lVar) {
        super(vVar, nVar, lVar);
    }

    /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method */
    protected void b2(SingleDressInfo singleDressInfo) {
    }

    protected void c(long j) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.decorate.d.a
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public void c(SingleDressInfo singleDressInfo) {
        this.f17139a.b(singleDressInfo);
        b2(singleDressInfo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.decorate.d.a
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public void d(SingleDressInfo singleDressInfo) {
        Messenger.getDefault().send(singleDressInfo, MessageToken.TOKEN_DRESS_RADIO_GROUP_MODIFY_ITEM_URL);
    }

    protected void a(Context context, SingleDressInfo singleDressInfo) {
        ea.a(context, singleDressInfo.getId(), singleDressInfo.getTypeId());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.decorate.d.a
    public void b(Context context, SingleDressInfo singleDressInfo) {
        if (n.a(singleDressInfo)) {
            if (this.f17140b.f17193a.size() > 0) {
                Iterator<Long> it = this.f17140b.f17193a.iterator();
                while (it.hasNext()) {
                    long jLongValue = it.next().longValue();
                    this.f17139a.d(jLongValue);
                    c(jLongValue);
                    a(a(jLongValue));
                    d(new SingleDressInfo(jLongValue));
                }
                this.f17140b.f17193a.clear();
            }
            Iterator<Long> it2 = singleDressInfo.getOccupyPosition().iterator();
            while (it2.hasNext()) {
                long jLongValue2 = it2.next().longValue();
                long jB = this.f17139a.b(jLongValue2);
                if (jB != 0) {
                    SingleDressInfo singleDressInfo2 = new SingleDressInfo();
                    singleDressInfo2.setId(jB);
                    singleDressInfo2.setTypeId(jLongValue2);
                    a(context, singleDressInfo2);
                }
                this.f17139a.e(jLongValue2);
                c(jLongValue2);
                a(b(jLongValue2));
                d(new SingleDressInfo(jLongValue2, singleDressInfo.getIconUrl()));
            }
            this.f17140b.f17193a.addAll(singleDressInfo.getOccupyPosition());
            return;
        }
        if (a(singleDressInfo)) {
            SingleDressInfo singleDressInfo3 = new SingleDressInfo();
            singleDressInfo3.setId(this.f17139a.b(16L));
            singleDressInfo3.setResourceId(j.a(16L));
            singleDressInfo3.setTypeId(16L);
            a(context, singleDressInfo3);
            a(singleDressInfo3);
            this.f17139a.d(16L);
            c(16L);
            Iterator<Long> it3 = this.f17140b.f17193a.iterator();
            while (it3.hasNext()) {
                long jLongValue3 = it3.next().longValue();
                if (jLongValue3 != singleDressInfo.getTypeId()) {
                    this.f17139a.d(jLongValue3);
                    c(jLongValue3);
                    a(a(jLongValue3));
                    d(new SingleDressInfo(jLongValue3));
                }
            }
            this.f17140b.f();
            d(new SingleDressInfo(16L));
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
        ea.a(context, singleDressInfo.getId());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.decorate.d.a
    /* JADX INFO: renamed from: c, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void a(SingleDressInfo singleDressInfo) {
        g.a(singleDressInfo.getResourceId());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.decorate.d.a
    /* JADX INFO: renamed from: d, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void b(SingleDressInfo singleDressInfo) {
        this.f17141c.a(singleDressInfo);
    }
}
