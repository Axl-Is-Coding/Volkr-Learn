package com.disabngo.blockynexus.e.b.L;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.view.dialog.TwoButtonDialog;
import com.sandboxol.common.base.viewmodel.ViewModel;

/* JADX INFO: compiled from: InboxViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class k extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f9345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f9346b;

    public k(Context context) {
        this.f9345a = context;
        this.f9346b = new f(context, R.string.no_inbox_mail);
    }

    void f() {
        new TwoButtonDialog(this.f9345a).setDetailText(R.string.email_want_to_delete_email).setRightButtonText(R.string.delete).setListener(new TwoButtonDialog.OnTwoButtonDialogClickListener() { // from class: com.disabngo.blockynexus.e.b.L.b
            @Override // com.sandboxol.center.view.dialog.TwoButtonDialog.OnTwoButtonDialogClickListener
            public final void onClick() {
                this.f9334a.h();
            }
        }).show();
    }

    public /* synthetic */ void h() {
        new j().a(this.f9345a);
    }
}
