package com.disabngo.blockynexus.e.b.r;

import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.d.C0513j;
import com.sandboxol.greendao.entity.GameDiskCacheInfo;
import java.util.List;

/* JADX INFO: compiled from: DiskSpaceViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class s implements com.sandboxol.greendao.a.c<List<GameDiskCacheInfo>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ObservableField f10118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ v f10119b;

    s(v vVar, ObservableField observableField) {
        this.f10119b = vVar;
        this.f10118a = observableField;
    }

    @Override // com.sandboxol.greendao.a.c
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(List<GameDiskCacheInfo> list) {
        if (list != null && list.size() > 0) {
            C0513j.a(this.f10119b.f10122a, list, this.f10119b.p, (ObservableField<Long>) this.f10118a, new r(this));
            return;
        }
        v vVar = this.f10119b;
        vVar.j = 0L;
        vVar.p.set(false);
    }

    @Override // com.sandboxol.greendao.a.c
    public void onError(int i, String str) {
        this.f10119b.p.set(false);
    }
}
