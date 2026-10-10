package com.disabngo.blockynexus.view.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.AbstractC0518ab;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.CommonHelper;

/* JADX INFO: loaded from: classes2.dex */
public class SecretQuestionFinishDialog extends FullScreenDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AbstractC0518ab f11379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Listener f11380b;

    public interface Listener {
        void onClickSave();
    }

    public SecretQuestionFinishDialog(Context context, String str, String str2, String str3, String str4) {
        super(context);
        this.f11379a.f8157f.setText(str);
        this.f11379a.g.setText(str2);
        this.f11379a.f8155d.setText(str3);
        this.f11379a.f8156e.setText(str4);
    }

    public void a(Listener listener) {
        this.f11380b = listener;
    }

    @Override // com.sandboxol.common.dialog.FullScreenDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        this.f11380b.onClickSave();
        super.dismiss();
    }

    @Override // com.sandboxol.common.dialog.FullScreenDialog
    protected void init(final Context context) {
        super.init(context);
        this.f11379a = (AbstractC0518ab) androidx.databinding.e.a(LayoutInflater.from(context), R.layout.dialog_app_secret_question_finish, (ViewGroup) null, false);
        setContentView(this.f11379a.getRoot());
        this.f11379a.f8152a.setOnClickListener(new View.OnClickListener() { // from class: com.disabngo.blockynexus.view.dialog.Z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11443a.a(view);
            }
        });
        this.f11379a.f8153b.setOnClickListener(new View.OnClickListener() { // from class: com.disabngo.blockynexus.view.dialog.aa
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f11468a.a(context, view);
            }
        });
    }

    public /* synthetic */ void a(View view) {
        dismiss();
    }

    public /* synthetic */ void a(Context context, View view) {
        a(context, this.f11379a);
    }

    private void a(Context context, AbstractC0518ab abstractC0518ab) {
        CommonHelper.screenPic(context, StringConstant.SECRET_QUESTION + AccountCenter.newInstance().userId.get(), abstractC0518ab.f8154c);
        AppToastUtils.showShortPositiveTipToast(context, R.string.account_register_finish_save_success);
        this.f11380b.onClickSave();
        dismiss();
    }
}
