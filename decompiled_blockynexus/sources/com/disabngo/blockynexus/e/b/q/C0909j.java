package com.disabngo.blockynexus.e.b.q;

import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import com.disabngo.blockynexus.d.C0513j;
import com.sandboxol.common.base.model.DefaultListModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.greendao.entity.GameDiskCacheInfo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.disabngo.blockynexus.e.b.q.j, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DiskGameManageListModel.java */
/* JADX INFO: loaded from: classes2.dex */
class C0909j implements com.sandboxol.greendao.a.c<List<GameDiskCacheInfo>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ OnResponseListener f10079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ k f10080b;

    C0909j(k kVar, OnResponseListener onResponseListener) {
        this.f10080b = kVar;
        this.f10079a = onResponseListener;
    }

    @Override // com.sandboxol.greendao.a.c
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(List<GameDiskCacheInfo> list) {
        if (list == null || list.size() <= 0) {
            this.f10080b.f10083c.set(false);
            this.f10080b.f10084d.set(false);
            this.f10079a.onSuccess(list);
            return;
        }
        k kVar = this.f10080b;
        ObservableList<GameDiskCacheInfo> observableList = kVar.f10082b;
        if (observableList != null) {
            observableList.clear();
            this.f10080b.f10082b.addAll(list);
            C0513j.a(((DefaultListModel) this.f10080b).context, list, (ObservableField<Boolean>) this.f10080b.f10083c, (ObservableField<Long>) new ObservableField(0L), new C0908i(this, list));
        } else {
            kVar.f10083c.set(false);
            this.f10080b.f10084d.set(false);
            this.f10079a.onSuccess(list);
        }
    }

    @Override // com.sandboxol.greendao.a.c
    public void onError(int i, String str) {
        this.f10079a.onSuccess(new ArrayList());
        this.f10080b.f10084d.set(false);
    }
}
