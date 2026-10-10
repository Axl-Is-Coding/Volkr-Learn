package com.sandboxol.gamedetail.c.a.a;

import androidx.databinding.ObservableField;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.web.error.GameOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.greendao.entity.Game;

/* JADX INFO: compiled from: GameDetailModel.java */
/* JADX INFO: loaded from: classes3.dex */
class S extends OnResponseListener<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ObservableField f17936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ObservableField f17937b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ObservableField f17938c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Z f17939d;

    S(Z z, ObservableField observableField, ObservableField observableField2, ObservableField observableField3) {
        this.f17939d = z;
        this.f17936a = observableField;
        this.f17937b = observableField2;
        this.f17938c = observableField3;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        GameOnError.showErrorTip(this.f17939d.f17962a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f17939d.f17962a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Integer num) {
        ((Game) this.f17936a.get()).setAppreciate(true);
        ((Game) this.f17936a.get()).setPraiseNumber(((Game) this.f17936a.get()).getPraiseNumber() + 1);
        this.f17937b.set(true);
        this.f17938c.set(String.valueOf(((Game) this.f17936a.get()).getPraiseNumber()));
        ReportDataAdapter.onEvent(this.f17939d.f17962a, EventConstant.CLICK_GOOD);
    }
}
