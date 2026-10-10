package com.disabngo.blockynexus.e.b.la;

import android.text.TextUtils;
import android.widget.EditText;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.dialog.EditTextDialog;
import com.sandboxol.common.utils.AppToastUtils;

/* JADX INFO: compiled from: TribeCreateViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class m implements EditTextDialog.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ n f9921a;

    m(n nVar) {
        this.f9921a = nVar;
    }

    @Override // com.disabngo.blockynexus.view.dialog.EditTextDialog.a
    public void a(EditText editText) {
    }

    @Override // com.disabngo.blockynexus.view.dialog.EditTextDialog.a
    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            AppToastUtils.showShortNegativeTipToast(this.f9921a.f9922a, R.string.tribe_label_empty);
            return;
        }
        this.f9921a.h.add(str);
        n nVar = this.f9921a;
        nVar.j.setData(nVar.h);
    }
}
