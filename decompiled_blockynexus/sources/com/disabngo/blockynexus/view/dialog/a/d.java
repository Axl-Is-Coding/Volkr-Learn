package com.disabngo.blockynexus.view.dialog.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.Pa;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.entity.UserSignInResponse;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.common.interfaces.ReportDataAdapter;

/* JADX INFO: compiled from: ActivitySignUpDialog.java */
/* JADX INFO: loaded from: classes2.dex */
public class d extends FullScreenDialog {
    public d(Context context, UserSignInResponse userSignInResponse) {
        super(context);
        a(context, userSignInResponse);
        ReportDataAdapter.onEvent(context, EventConstant.EDAY_SIGNIN_TIME);
    }

    private void a(Context context, UserSignInResponse userSignInResponse) {
        Pa pa = (Pa) androidx.databinding.e.a(LayoutInflater.from(context), R.layout.dialog_activity_sign_up, (ViewGroup) null, false);
        pa.a(new k(context, this, userSignInResponse));
        setContentView(pa.getRoot());
    }
}
