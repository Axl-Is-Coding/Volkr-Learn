package com.disabngo.blockynexus.d;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.greendao.entity.GameDiskCacheInfo;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: com.disabngo.blockynexus.d.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DiskManageUtils.java */
/* JADX INFO: loaded from: classes2.dex */
class C0510g implements io.reactivex.w<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ io.reactivex.w f7222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f7223b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ObservableField f7224c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ ObservableField f7225d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ List f7226e;

    C0510g(io.reactivex.w wVar, Context context, ObservableField observableField, ObservableField observableField2, List list) {
        this.f7222a = wVar;
        this.f7223b = context;
        this.f7224c = observableField;
        this.f7225d = observableField2;
        this.f7226e = list;
    }

    @Override // io.reactivex.w
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onNext(Long l) {
        io.reactivex.w wVar = this.f7222a;
        if (wVar != null) {
            wVar.onNext(l);
        }
    }

    @Override // io.reactivex.w
    public void onComplete() {
        this.f7225d.set(0L);
        for (GameDiskCacheInfo gameDiskCacheInfo : this.f7226e) {
            if (gameDiskCacheInfo != null) {
                ObservableField observableField = this.f7225d;
                observableField.set(Long.valueOf(((Long) observableField.get()).longValue() + gameDiskCacheInfo.getDiskSpaceSize()));
            }
        }
        if (this.f7226e.size() > 0) {
            Iterator it = this.f7226e.iterator();
            while (it.hasNext()) {
                GameDiskCacheInfo gameDiskCacheInfo2 = (GameDiskCacheInfo) it.next();
                if (gameDiskCacheInfo2 != null && gameDiskCacheInfo2.getDiskSpaceSize() == 0) {
                    it.remove();
                }
            }
        }
        io.reactivex.w wVar = this.f7222a;
        if (wVar != null) {
            wVar.onComplete();
        }
        this.f7224c.set(false);
    }

    @Override // io.reactivex.w
    public void onError(Throwable th) {
        ReportDataAdapter.onError(this.f7223b, th);
        io.reactivex.w wVar = this.f7222a;
        if (wVar != null) {
            wVar.onError(th);
        }
        this.f7224c.set(false);
    }

    @Override // io.reactivex.w
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        io.reactivex.w wVar = this.f7222a;
        if (wVar != null) {
            wVar.onSubscribe(bVar);
        }
    }
}
