package com.disabngo.blockynexus.e.b.D;

import android.content.Context;
import android.widget.EditText;
import com.disabngo.blockynexus.view.dialog.EditTextDialog;
import com.disabngo.blockynexus.web.GroupChatApi;

/* JADX INFO: compiled from: GroupInfoModel.java */
/* JADX INFO: loaded from: classes2.dex */
class C implements EditTextDialog.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f9158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ long f9159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ D f9160c;

    C(D d2, Context context, long j) {
        this.f9160c = d2;
        this.f9158a = context;
        this.f9159b = j;
    }

    @Override // com.disabngo.blockynexus.view.dialog.EditTextDialog.a
    public void a(EditText editText) {
    }

    @Override // com.disabngo.blockynexus.view.dialog.EditTextDialog.a
    public void a(String str) {
        GroupChatApi.postJoinGroupApply(this.f9158a, this.f9159b, str, new B(this));
    }
}
