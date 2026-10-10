package com.disabngo.blockynexus.service;

import android.content.Context;
import androidx.databinding.ObservableArrayMap;
import androidx.databinding.ObservableMap;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.router.moduleInfo.decorate.SingleDressInfo;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.decorate.f.j;
import com.sandboxol.decorate.manager.n;
import com.sandboxol.decorate.web.u;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PartyDressService.java */
/* JADX INFO: loaded from: classes2.dex */
class f extends OnResponseListener<List<SingleDressInfo>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f10500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f10501b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Context f10502c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ PartyDressService f10503d;

    f(PartyDressService partyDressService, long j, String str, Context context) {
        this.f10503d = partyDressService;
        this.f10500a = j;
        this.f10501b = str;
        this.f10502c = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        u.a(this.f10502c, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f10502c, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(List<SingleDressInfo> list) {
        ObservableArrayMap observableArrayMap = new ObservableArrayMap();
        if (list != null && list.size() > 0) {
            for (SingleDressInfo singleDressInfo : list) {
                if (singleDressInfo.getStatus() == 1) {
                    if (n.a(singleDressInfo)) {
                        Iterator<Long> it = singleDressInfo.getOccupyPosition().iterator();
                        while (it.hasNext()) {
                            long jLongValue = it.next().longValue();
                            observableArrayMap.put(Long.valueOf(jLongValue), j.b(jLongValue));
                        }
                    }
                    observableArrayMap.put(Long.valueOf(singleDressInfo.getTypeId()), singleDressInfo.getResourceId());
                }
            }
        }
        if (this.f10500a == AccountCenter.newInstance().userId.get().longValue()) {
            this.f10503d.a((ObservableMap<Long, String>) observableArrayMap);
        } else {
            this.f10503d.a((ObservableMap<Long, String>) observableArrayMap, this.f10501b);
        }
    }
}
