package com.disabngo.blockynexus.view.activity.main;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.entity.LatestVersion;
import com.sandboxol.center.view.dialog.TwoButtonDialog;
import com.sandboxol.common.base.web.OnResponseListener;

/* JADX INFO: compiled from: MainModel.java */
/* JADX INFO: loaded from: classes2.dex */
class Ub extends OnResponseListener<LatestVersion> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f10844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f10845b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ boolean f10846c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ bc f10847d;

    Ub(bc bcVar, Context context, boolean z, boolean z2) {
        this.f10847d = bcVar;
        this.f10844a = context;
        this.f10845b = z;
        this.f10846c = z2;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(LatestVersion latestVersion) {
        this.f10847d.a(this.f10844a, latestVersion, this.f10845b);
    }

    public /* synthetic */ void b(Context context, boolean z, boolean z2) {
        this.f10847d.a(context, z, z2);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        TwoButtonDialog detailText = new TwoButtonDialog(this.f10844a).setRightButtonText(R.string.retry).setDetailText(R.string.dialog_check_app_version_failed);
        final Context context = this.f10844a;
        final boolean z = this.f10846c;
        final boolean z2 = this.f10845b;
        detailText.setListener(new TwoButtonDialog.OnTwoButtonDialogClickListener() { // from class: com.disabngo.blockynexus.view.activity.main.y
            @Override // com.sandboxol.center.view.dialog.TwoButtonDialog.OnTwoButtonDialogClickListener
            public final void onClick() {
                this.f10987a.a(context, z, z2);
            }
        }).show();
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        TwoButtonDialog detailText = new TwoButtonDialog(this.f10844a).setRightButtonText(R.string.retry).setDetailText(R.string.dialog_check_app_version_failed);
        final Context context = this.f10844a;
        final boolean z = this.f10846c;
        final boolean z2 = this.f10845b;
        detailText.setListener(new TwoButtonDialog.OnTwoButtonDialogClickListener() { // from class: com.disabngo.blockynexus.view.activity.main.z
            @Override // com.sandboxol.center.view.dialog.TwoButtonDialog.OnTwoButtonDialogClickListener
            public final void onClick() {
                this.f10993a.b(context, z, z2);
            }
        }).show();
    }

    public /* synthetic */ void a(Context context, boolean z, boolean z2) {
        this.f10847d.a(context, z, z2);
    }
}
