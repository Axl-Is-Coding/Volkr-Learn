package com.sandboxol.imchat.ui.dialog;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.e;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.imchat.R;
import com.sandboxol.imchat.databinding.DialogPartyGuideBinding;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes4.dex */
public class PartyGuideDialog extends FullScreenDialog {
    private AnimationDrawable loadingAnim;
    public ReplyCommand onClickClose;
    public int weight;

    public PartyGuideDialog(Context context, int i) {
        super(context);
        this.onClickClose = new ReplyCommand(new Action0() { // from class: com.sandboxol.imchat.ui.dialog.PartyGuideDialog.1
            @Override // rx.functions.Action0
            public void call() {
                PartyGuideDialog.this.dismiss();
            }
        });
        this.weight = i - 2;
        initView();
    }

    @Override // com.sandboxol.common.dialog.FullScreenDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            if (this.loadingAnim.isRunning()) {
                this.loadingAnim.stop();
            }
            super.dismiss();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void initView() {
        DialogPartyGuideBinding dialogPartyGuideBinding = (DialogPartyGuideBinding) e.a(LayoutInflater.from(this.context), R.layout.dialog_party_guide, (ViewGroup) null, false);
        dialogPartyGuideBinding.setPartyGuideDialog(this);
        setContentView(dialogPartyGuideBinding.getRoot());
        dialogPartyGuideBinding.view.setLayoutParams(new LinearLayout.LayoutParams(0, 1, this.weight));
        this.loadingAnim = (AnimationDrawable) ((ImageView) findViewById(R.id.ivLoading)).getBackground();
        if (this.loadingAnim.isRunning()) {
            return;
        }
        this.loadingAnim.start();
    }
}
