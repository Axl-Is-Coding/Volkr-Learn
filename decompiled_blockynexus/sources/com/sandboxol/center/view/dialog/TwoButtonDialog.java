package com.sandboxol.center.view.dialog;

import android.content.Context;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.sandboxol.center.R;
import com.sandboxol.common.dialog.FullScreenDialog;

/* JADX INFO: loaded from: classes3.dex */
public class TwoButtonDialog extends FullScreenDialog implements View.OnClickListener {
    private Button btnCancel;
    private Button btnSure;
    private OnTwoButtonDialogLeftClickListener leftListener;
    private OnTwoButtonDialogClickListener listener;
    private TextView tvDetails;
    private TextView tvTitle;

    public interface OnTwoButtonDialogClickListener {
        void onClick();
    }

    public interface OnTwoButtonDialogLeftClickListener {
        void onLeftClick();
    }

    public TwoButtonDialog(Context context) {
        super(context);
        initView();
    }

    public void initView() {
        setContentView(R.layout.base_dialog_two_button);
        this.tvTitle = (TextView) findViewById(R.id.tvTitle);
        this.tvDetails = (TextView) findViewById(R.id.tvDetails);
        this.btnSure = (Button) findViewById(R.id.btnSure);
        this.btnCancel = (Button) findViewById(R.id.btnCancel);
        this.btnCancel.setOnClickListener(this);
        this.btnSure.setOnClickListener(this);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        dismiss();
        OnTwoButtonDialogLeftClickListener onTwoButtonDialogLeftClickListener = this.leftListener;
        if (onTwoButtonDialogLeftClickListener != null) {
            onTwoButtonDialogLeftClickListener.onLeftClick();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btnCancel) {
            dismiss();
            OnTwoButtonDialogLeftClickListener onTwoButtonDialogLeftClickListener = this.leftListener;
            if (onTwoButtonDialogLeftClickListener != null) {
                onTwoButtonDialogLeftClickListener.onLeftClick();
                return;
            }
            return;
        }
        if (id == R.id.btnSure) {
            dismiss();
            OnTwoButtonDialogClickListener onTwoButtonDialogClickListener = this.listener;
            if (onTwoButtonDialogClickListener != null) {
                onTwoButtonDialogClickListener.onClick();
            }
        }
    }

    public TwoButtonDialog setDetailText(int i) {
        this.tvDetails.setText(i);
        return this;
    }

    public TwoButtonDialog setLeftButtonText(int i) {
        this.btnCancel.setText(i);
        return this;
    }

    public TwoButtonDialog setLeftListener(OnTwoButtonDialogLeftClickListener onTwoButtonDialogLeftClickListener) {
        this.leftListener = onTwoButtonDialogLeftClickListener;
        return this;
    }

    public TwoButtonDialog setListener(OnTwoButtonDialogClickListener onTwoButtonDialogClickListener) {
        this.listener = onTwoButtonDialogClickListener;
        return this;
    }

    public TwoButtonDialog setRightButtonText(int i) {
        this.btnSure.setText(i);
        return this;
    }

    public TwoButtonDialog setTitleText(int i) {
        this.tvTitle.setText(i);
        return this;
    }

    public TwoButtonDialog setDetailText(String str) {
        this.tvDetails.setText(Html.fromHtml(str));
        return this;
    }

    public TwoButtonDialog setTitleText(String str) {
        this.tvTitle.setText(str);
        return this;
    }
}
