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
class n extends OnResponseListener<TribeTask> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ OnResponseListener f10214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ObservableField f10215b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f10216c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ p f10217d;

    n(p pVar, OnResponseListener onResponseListener, ObservableField observableField, int i) {
        this.f10217d = pVar;
        this.f10214a = onResponseListener;
        this.f10215b = observableField;
        this.f10216c = i;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(TribeTask tribeTask) {
        this.f10214a.onSuccess(tribeTask.getTasks());
        this.f10217d.a(tribeTask, (ObservableField<Integer>) this.f10215b);
        this.f10217d.f10225d.set(false);
        if (this.f10216c != 1) {
            BillingManager.getInstance().updateUserMoney(((DefaultListModel) this.f10217d).context);
        } else {
            BillingManager.getInstance().updateUserMoney(((DefaultListModel) this.f10217d).context, true);
            ReportDataAdapter.onEvent(((DefaultListModel) this.f10217d).context, EventConstant.CLAN_TASK_GROUP_REFRESH_SUC);
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        this.f10217d.f10225d.set(false);
        TribeOnError.showErrorTip(((DefaultListModel) this.f10217d).context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        this.f10217d.f10225d.set(false);
        ServerOnError.showOnServerError(((DefaultListModel) this.f10217d).context, i);
    }
}
