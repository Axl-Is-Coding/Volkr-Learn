package com.disabngo.blockynexus.view.fragment.tribehas;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.TribeNoticeGet;
import com.disabngo.blockynexus.view.dialog.OneButtonNoticeDialog;
import com.disabngo.blockynexus.web.error.TribeOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: TribeHasModel.java */
/* JADX INFO: loaded from: classes2.dex */
class O extends OnResponseListener<TribeNoticeGet> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Q f11982a;

    O(Q q) {
        this.f11982a = q;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(TribeNoticeGet tribeNoticeGet) {
        if (tribeNoticeGet != null) {
            String string = SharedUtils.getString(this.f11982a.f11984a, "tribe.notice.content");
            if (tribeNoticeGet.getContent() == null || tribeNoticeGet.getContent().equals(string)) {
                return;
            }
            SharedUtils.putString(this.f11982a.f11984a, "tribe.notice.content", tribeNoticeGet.getContent());
            new OneButtonNoticeDialog(this.f11982a.f11984a).a(this.f11982a.f11984a.getString(R.string.tribe_notice_title)).setButtonText(this.f11982a.f11984a.getString(R.string.close)).setDetailText(tribeNoticeGet.getContent()).show();
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        TribeOnError.showErrorTip(this.f11982a.f11984a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f11982a.f11984a, i);
    }
}
