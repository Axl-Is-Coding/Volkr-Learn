package com.sandboxol.decorate.d.a.a;

import android.content.Context;
import androidx.databinding.ObservableList;
import com.sandboxol.center.router.moduleInfo.decorate.SingleDressInfo;
import com.sandboxol.center.router.moduleInfo.decorate.SuitDressInfo;
import com.sandboxol.decorate.manager.l;
import com.sandboxol.decorate.manager.n;
import com.sandboxol.decorate.manager.v;
import com.sandboxol.decorate.view.fragment.dress.ea;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: DressSuitClothe.java */
/* JADX INFO: loaded from: classes3.dex */
public class c extends com.sandboxol.decorate.d.a<SuitDressInfo> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected b f17144d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f17145e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private SuitDressInfo f17146f;

    public c(v vVar, n nVar, l lVar) {
        super(vVar, nVar, lVar);
        this.f17145e = false;
        a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.decorate.d.a
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public void d(Context context, SuitDressInfo suitDressInfo) {
        if (this.f17145e) {
            this.f17145e = false;
            ArrayList arrayList = new ArrayList();
            for (SingleDressInfo singleDressInfo : suitDressInfo.getDecorationInfoList()) {
                arrayList.add(Long.valueOf(singleDressInfo.getId()));
                this.f17139a.a(singleDressInfo);
            }
            ea.a(context, arrayList);
        }
    }

    protected void a() {
        this.f17144d = new b(this.f17139a, this.f17140b, this.f17141c);
    }

    public /* synthetic */ void a(Context context) {
        a(context, this.f17146f);
    }

    /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method */
    protected void b2(final Context context, SuitDressInfo suitDressInfo) {
        ArrayList arrayList = new ArrayList();
        for (SingleDressInfo singleDressInfo : suitDressInfo.getDecorationInfoList()) {
            arrayList.add(Long.valueOf(singleDressInfo.getId()));
            this.f17139a.g(singleDressInfo.getTypeId());
        }
        ea.a(context, arrayList, new ea.a() { // from class: com.sandboxol.decorate.d.a.a.a
            @Override // com.sandboxol.decorate.view.fragment.dress.ea.a
            public final void a() {
                this.f17142a.a(context);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.decorate.d.a
    /* JADX INFO: renamed from: c, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void b(Context context, SuitDressInfo suitDressInfo) {
        Iterator<SingleDressInfo> it = suitDressInfo.getDecorationInfoList().iterator();
        while (it.hasNext()) {
            this.f17144d.b(context, it.next());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.decorate.d.a
    /* JADX INFO: renamed from: d, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void c(Context context, SuitDressInfo suitDressInfo) {
        ObservableList<Long> observableList = this.f17139a.f17215d;
        if (observableList != null && observableList.size() > 0) {
            List<Long> listD = this.f17140b.d();
            if (listD.size() > 0) {
                SuitDressInfo suitDressInfo2 = new SuitDressInfo();
                suitDressInfo2.setDecorationInfoList(new ArrayList());
                for (int i = 0; i < listD.size(); i++) {
                    long jB = this.f17139a.b(listD.get(i).longValue());
                    if (jB != 0) {
                        SingleDressInfo singleDressInfo = new SingleDressInfo();
                        singleDressInfo.setId(jB);
                        singleDressInfo.setTypeId(listD.get(i).longValue());
                        suitDressInfo2.getDecorationInfoList().add(singleDressInfo);
                    }
                    this.f17139a.d(listD.get(i).longValue());
                    this.f17144d.a(a(listD.get(i).longValue()));
                    this.f17144d.d(new SingleDressInfo(listD.get(i).longValue()));
                    this.f17144d.c(listD.get(i).longValue());
                }
                if (listD.contains(16L)) {
                    this.f17140b.f();
                }
                this.f17146f = suitDressInfo;
                b2(context, suitDressInfo2);
            }
        } else {
            this.f17145e = true;
        }
        ArrayList arrayList = new ArrayList();
        for (SingleDressInfo singleDressInfo2 : suitDressInfo.getDecorationInfoList()) {
            arrayList.add(Long.valueOf(singleDressInfo2.getTypeId()));
            if (n.a(singleDressInfo2)) {
                arrayList.addAll(singleDressInfo2.getOccupyPosition());
            }
        }
        this.f17140b.a(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.decorate.d.a
    public void a(SuitDressInfo suitDressInfo) {
        Iterator<SingleDressInfo> it = suitDressInfo.getDecorationInfoList().iterator();
        while (it.hasNext()) {
            this.f17144d.a(it.next());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.decorate.d.a
    public void c(SuitDressInfo suitDressInfo) {
        this.f17139a.f17215d.clear();
        this.f17139a.f17215d.add(Long.valueOf(suitDressInfo.getSuitId()));
        for (SingleDressInfo singleDressInfo : suitDressInfo.getDecorationInfoList()) {
            this.f17144d.c(singleDressInfo);
            this.f17144d.b2(singleDressInfo);
        }
    }

    protected void a(Context context, SuitDressInfo suitDressInfo) {
        this.f17145e = true;
        d(context, suitDressInfo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.decorate.d.a
    public void b(SuitDressInfo suitDressInfo) {
        Iterator<SingleDressInfo> it = suitDressInfo.getDecorationInfoList().iterator();
        while (it.hasNext()) {
            this.f17144d.b(it.next());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.decorate.d.a
    public void d(SuitDressInfo suitDressInfo) {
        Iterator<SingleDressInfo> it = suitDressInfo.getDecorationInfoList().iterator();
        while (it.hasNext()) {
            this.f17144d.d(it.next());
        }
    }
}
