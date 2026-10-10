package com.disabngo.blockynexus.e.b.ka;

import com.disabngo.blockynexus.view.dialog.TribeContributionDialog;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.utils.DialogUtils;
import com.sandboxol.center.view.dialog.PayGdiamondDialog;
import com.sandboxol.common.interfaces.ReportDataAdapter;

/* JADX INFO: compiled from: TribeContributionViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class m implements TribeContributionDialog.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ p f9875a;

    m(p pVar) {
        this.f9875a = pVar;
    }

    @Override // com.disabngo.blockynexus.view.dialog.TribeContributionDialog.a
    public void a(final int i) {
        long j = i;
        if (j > AccountCenter.newInstance().diamonds.get().longValue()) {
            DialogUtils.newsInstant().showPayGdiamondDialog(this.f9875a.f9879a, (int) (j - AccountCenter.newInstance().diamonds.get().longValue()), new PayGdiamondDialog.OnTwoButtonDialogClickListener() { // from class: com.disabngo.blockynexus.e.b.ka.a
                @Override // com.sandboxol.center.view.dialog.PayGdiamondDialog.OnTwoButtonDialogClickListener
                public final void onClick() {
                    this.f9868a.b(i);
                }
            }, null);
        } else {
            this.f9875a.a(1, i);
        }
        ReportDataAdapter.onEvent(this.f9875a.f9879a, EventConstant.CLAN_CUBE_DONATE_CLICK);
    }

    public /* synthetic */ void b(int i) {
        this.f9875a.a(1, i);
    }

    @Override // com.disabngo.blockynexus.view.dialog.TribeContributionDialog.a
    public void onCancel() {
    }
}
