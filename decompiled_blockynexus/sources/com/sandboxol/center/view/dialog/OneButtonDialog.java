package com.sandboxol.center.view.dialog;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.sandboxol.center.R;
import com.sandboxol.common.dialog.FullScreenDialog;

/* JADX INFO: loaded from: classes3.dex */
public class OneButtonDialog extends FullScreenDialog implements View.OnClickListener {
    private Button btnSure;
    private boolean isAllow;
    private OneButtonDialogListener listener;
    private TextView tvDetails;

    public interface OneButtonDialogListener {
        void onClick();
    }

    public OneButtonDialog(Context context) {
        super(context);
        this.isAllow = true;
        initView();
    }

    public void initView() {
        setContentView(R.layout.base_dialog_one_button);
        this.tvDetails = (TextView) findViewById(R.id.tvDetails);
        this.btnSure = (Button) findViewById(R.id.btnSure);
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

    public OneButtonDialog setAllowBackPress(boolean z) {
        this.isAllow = z;
        return this;
    }

    public OneButtonDialog setButtonText(String str) {
        this.btnSure.setText(str);
        return this;
    }

    public OneButtonDialog setDetailText(String str) {
        this.tvDetails.setText(str);
        return this;
    }

    public OneButtonDialog setListener(OneButtonDialogListener oneButtonDialogListener) {
        this.listener = oneButtonDialogListener;
        return this;
    }

    public OneButtonDialog setButtonText(int i) {
        this.btnSure.setText(i);
        return this;
    }

    public OneButtonDialog setDetailText(int i) {
        this.tvDetails.setText(i);
        return this;
    }
}
