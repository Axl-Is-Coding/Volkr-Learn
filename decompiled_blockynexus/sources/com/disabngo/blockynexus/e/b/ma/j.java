package com.disabngo.blockynexus.e.b.ma;

import android.widget.EditText;
import com.disabngo.blockynexus.entity.RequestJoinTribe;
import com.disabngo.blockynexus.view.dialog.EditTextDialog;
import com.disabngo.blockynexus.web.TribeApi;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.common.interfaces.ReportDataAdapter;

/* JADX INFO: compiled from: TribeDetailViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class j implements EditTextDialog.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ m f9946a;

    j(m mVar) {
        this.f9946a = mVar;
    }

    @Override // com.disabngo.blockynexus.view.dialog.EditTextDialog.a
    public void a(EditText editText) {
    }

    @Override // com.disabngo.blockynexus.view.dialog.EditTextDialog.a
    public void a(String str) {
        ReportDataAdapter.onEvent(this.f9946a.f9949a, EventConstant.CLAN_DETAIL_PAGE_CLICK_ENTER, this.f9946a.f9950b);
        TribeApi.requestJoinTribe(this.f9946a.f9949a, new RequestJoinTribe((int) this.f9946a.f9952d, str), new i(this));
    }
}
