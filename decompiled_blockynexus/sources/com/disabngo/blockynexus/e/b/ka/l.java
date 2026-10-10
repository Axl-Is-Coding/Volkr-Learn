package com.disabngo.blockynexus.e.b.ka;

import com.disabngo.blockynexus.view.dialog.TribeContributionDialog;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.common.interfaces.ReportDataAdapter;

/* JADX INFO: compiled from: TribeContributionViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class l implements TribeContributionDialog.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ p f9874a;

    l(p pVar) {
        this.f9874a = pVar;
    }

    @Override // com.disabngo.blockynexus.view.dialog.TribeContributionDialog.a
    public void a(int i) {
        this.f9874a.a(2, i);
        ReportDataAdapter.onEvent(this.f9874a.f9879a, EventConstant.CLAN_GOLD_DONATE_CLICK);
    }

    @Override // com.disabngo.blockynexus.view.dialog.TribeContributionDialog.a
    public void onCancel() {
    }
}
