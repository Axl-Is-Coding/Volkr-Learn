package com.disabngo.blockynexus.e.b.D;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.dialog.EditTextDialog;

/* JADX INFO: compiled from: GroupInfoModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class D {
    public void a(Context context, long j) {
        new EditTextDialog(context).c(context.getString(R.string.send_apply_for_friend)).b(context.getString(R.string.new_group_apply_message)).a(new C(this, context, j)).show();
    }
}
