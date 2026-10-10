package com.sandboxol.center.view.dialog;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.sandboxol.center.R;
import com.sandboxol.common.dialog.FullScreenDialog;

/* JADX INFO: loaded from: classes3.dex */
public class OneTextButtonDialog extends FullScreenDialog implements View.OnClickListener {
    private TextView btnSure;
    private boolean isAllow;
    private OneButtonDialogListener listener;
    private TextView tvDetails;

    public interface OneButtonDialogListener {
        void onClick();
    }

    public OneTextButtonDialog(Context context) {
        super(context);
        this.isAllow = true;
        initView();
    }

    public void initView() {
        setContentView(R.layout.base_dialog_one_textview_button);
        this.tvDetails = (TextView) findViewById(R.id.tvDetails);
        this.btnSure = (TextView) findViewById(R.id.btnSure);
        this.btnSure.setOnClickListener(this);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        if (this.isAllow) {
            super.onBackPressed();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.btnSure) {
            OneButtonDialogListener oneButtonDialogListener = this.listener;
            if (oneButtonDialogListener != null) {
                oneButtonDialogListener.onClick();
            }
            dismiss();
        }
    }

    public OneTextButtonDialog setAllowBackPress(boolean z) {
        this.isAllow = z;
        return this;
    }

    public OneTextButtonDialog setButtonText(String str) {
        this.btnSure.setText(str);
        return this;
    }

    public OneTextButtonDialog setDetailText(String str) {
        this.tvDetails.setText(str);
        return this;
    }

    public OneTextButtonDialog setListener(OneButtonDialogListener oneButtonDialogListener) {
        this.listener = oneButtonDialogListener;
        return this;
    }

    public OneTextButtonDialog setButtonText(int i) {
        this.btnSure.setText(i);
        return this;
    }

    public OneTextButtonDialog setDetailText(int i) {
        this.tvDetails.setText(i);
        return this;
    }
}
