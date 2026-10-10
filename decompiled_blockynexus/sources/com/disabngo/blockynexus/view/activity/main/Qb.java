package com.disabngo.blockynexus.view.activity.main;

import android.content.Context;
import com.disabngo.blockynexus.databinding.AbstractC0672o;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;
import rx.Observer;

/* JADX INFO: compiled from: MainModel.java */
/* JADX INFO: loaded from: classes2.dex */
class Qb implements Observer<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ AbstractC0672o f10823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f10824b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ DataRecyclerView f10825c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ bc f10826d;

    Qb(bc bcVar, AbstractC0672o abstractC0672o, Context context, DataRecyclerView dataRecyclerView) {
        this.f10826d = bcVar;
        this.f10823a = abstractC0672o;
        this.f10824b = context;
        this.f10825c = dataRecyclerView;
    }

    @Override // rx.Observer
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onNext(Boolean bool) {
        bc bcVar = this.f10826d;
        bcVar.a(this.f10823a, this.f10824b, this.f10825c, bcVar.f10882c, new io.reactivex.b.a() { // from class: com.disabngo.blockynexus.view.activity.main.A
            @Override // io.reactivex.b.a
            public final void run() throws Exception {
                Qb.a();
            }
        });
    }

    @Override // rx.Observer
    public void onCompleted() {
    }

    @Override // rx.Observer
    public void onError(Throwable th) {
        com.sandboxol.greendao.c.oa.newInstance().b();
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_REFRESH_SCRAP_RED_POINT_NUM);
    }

    static /* synthetic */ void a() throws Exception {
        com.sandboxol.greendao.c.oa.newInstance().b();
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_REFRESH_SCRAP_RED_POINT_NUM);
    }
}
