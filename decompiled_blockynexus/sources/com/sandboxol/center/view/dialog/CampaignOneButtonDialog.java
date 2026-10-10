package com.sandboxol.center.view.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ObservableField;
import com.sandboxol.center.R;
import com.sandboxol.center.databinding.BaseDialogCampaignOneBtnBinding;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.dialog.FullScreenDialog;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes3.dex */
public class CampaignOneButtonDialog extends FullScreenDialog {
    public ObservableField<String> betResult;
    private Context context;
    public ReplyCommand onConfirmClickCommand;

    public CampaignOneButtonDialog(Context context) {
        super(context);
        this.betResult = new ObservableField<>("");
        this.onConfirmClickCommand = new ReplyCommand(new Action0() { // from class: com.sandboxol.center.view.dialog.k
            @Override // rx.functions.Action0
            public final void call() {
                this.f16382a.onConfirm();
            }
        });
        this.context = context;
        initView();
    }

    public void initView() {
        BaseDialogCampaignOneBtnBinding baseDialogCampaignOneBtnBinding = (BaseDialogCampaignOneBtnBinding) androidx.databinding.e.a(LayoutInflater.from(this.context), R.layout.base_dialog_campaign_one_btn, (ViewGroup) null, false);
        baseDialogCampaignOneBtnBinding.setCampaignOneButtonDialog(this);
        setContentView(baseDialogCampaignOneBtnBinding.getRoot());
    }

    public void onConfirm() {
        if (isShowing()) {
            cancel();
        }
    }

    public CampaignOneButtonDialog setMsg(String str) {
        this.betResult.set(str);
        return this;
    }

    public CampaignOneButtonDialog setMsg(int i) {
        this.betResult.set(this.context.getString(i));
        return this;
    }
}
