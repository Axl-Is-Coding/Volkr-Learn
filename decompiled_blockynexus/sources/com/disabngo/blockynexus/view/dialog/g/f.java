package com.disabngo.blockynexus.view.dialog.g;

import com.disabngo.blockynexus.R;
import com.sandboxol.center.entity.ScrapRequestTargetInfo;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.utils.AppToastUtils;
import rx.functions.Action0;

/* JADX INFO: compiled from: ScrapRequestItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class f implements Action0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ g f11575a;

    f(g gVar) {
        this.f11575a = gVar;
    }

    @Override // rx.functions.Action0
    public void call() {
        if (((ScrapRequestTargetInfo) ((ListItemViewModel) this.f11575a).item).getHelpStatus() == 1) {
            AppToastUtils.showShortNegativeTipToast(((ListItemViewModel) this.f11575a).context, ((ListItemViewModel) this.f11575a).context.getString(R.string.app_scrap_status_tips_1));
            return;
        }
        if (this.f11575a.f11577b.get().longValue() == ((ScrapRequestTargetInfo) ((ListItemViewModel) this.f11575a).item).getFriendId()) {
            this.f11575a.f11577b.set(0L);
            return;
        }
        g gVar = this.f11575a;
        gVar.f11577b.set(Long.valueOf(((ScrapRequestTargetInfo) ((ListItemViewModel) gVar).item).getFriendId()));
        g gVar2 = this.f11575a;
        gVar2.f11576a.set(((ScrapRequestTargetInfo) ((ListItemViewModel) gVar2).item).getFriendName());
    }
}
