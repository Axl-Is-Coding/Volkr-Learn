package com.disabngo.blockynexus.e.b.ua;

import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.entity.TribeTask;
import com.disabngo.blockynexus.web.error.TribeOnError;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.router.manager.BillingManager;
import com.sandboxol.common.base.model.DefaultListModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: TribeTaskPageListModel.java */
/* JADX INFO: loaded from: classes2.dex */
class o extends OnResponseListener<TribeTask> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ OnResponseListener f10218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ObservableField f10219b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f10220c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ p f10221d;

    o(p pVar, OnResponseListener onResponseListener, ObservableField observableField, int i) {
        this.f10221d = pVar;
        this.f10218a = onResponseListener;
        this.f10219b = observableField;
        this.f10220c = i;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(TribeTask tribeTask) {
        this.f10218a.onSuccess(this.f10221d.a(tribeTask));
        this.f10221d.a(tribeTask, (ObservableField<Integer>) this.f10219b);
        this.f10221d.f10225d.set(false);
        if (this.f10220c != 1) {
            BillingManager.getInstance().updateUserMoney(((DefaultListModel) this.f10221d).context);
        } else {
            BillingManager.getInstance().updateUserMoney(((DefaultListModel) this.f10221d).context, true);
            ReportDataAdapter.onEvent(((DefaultListModel) this.f10221d).context, EventConstant.CLAN_TASK_PERSONAL_REFRESH_SUC);
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        this.f10218a.onError(i, str);
        this.f10221d.f10225d.set(false);
        TribeOnError.showErrorTip(((DefaultListModel) this.f10221d).context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        this.f10218a.onServerError(i);
        this.f10221d.f10225d.set(false);
        ServerOnError.showOnServerError(((DefaultListModel) this.f10221d).context, i);
    }
}
