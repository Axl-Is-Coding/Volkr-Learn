package com.sandboxol.center.view.dialog;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import com.sandboxol.center.R;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.common.utils.SharedUtils;

/* JADX INFO: loaded from: classes3.dex */
public class NotWifiDialog extends FullScreenDialog implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private OnCancelClickListener cancelListener;
    private CheckBox cbWifi;
    private OnTwoButtonDialogClickListener listener;

    public interface OnCancelClickListener {
        void onCancel();
    }

    public interface OnTwoButtonDialogClickListener {
        void onClick();
    }

    public NotWifiDialog(Context context) {
        super(context);
        initView();
    }

    public void initView() {
        setContentView(R.layout.base_dialog_not_wifi);
        Button button = (Button) findViewById(R.id.btnSure);
        Button button2 = (Button) findViewById(R.id.btnCancel);
        this.cbWifi = (CheckBox) findViewById(R.id.cbWifi);
        button2.setOnClickListener(this);
        button.setOnClickListener(this);
        this.cbWifi.setOnCheckedChangeListener(this);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        com.apkfuns.logutils.c.a("NotWifiDialog").d(String.valueOf(z));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btnCancel) {
            dismiss();
            OnCancelClickListener onCancelClickListener = this.cancelListener;
            if (onCancelClickListener != null) {
                onCancelClickListener.onCancel();
                return;
            }
            return;
        }
        if (id == R.id.btnSure) {
            dismiss();
            if (this.cbWifi.isChecked()) {
                SharedUtils.putBoolean(this.context, SharedConstant.IS_SHOW_NO_WIFI, true);
            }
            OnTwoButtonDialogClickListener onTwoButtonDialogClickListener = this.listener;
            if (onTwoButtonDialogClickListener != null) {
                onTwoButtonDialogClickListener.onClick();
            }
        }
    }

    public NotWifiDialog setCancelListener(OnCancelClickListener onCancelClickListener) {
        this.cancelListener = onCancelClickListener;
        return this;
    }

    public NotWifiDialog setListener(OnTwoButtonDialogClickListener onTwoButtonDialogClickListener) {
        this.listener = onTwoButtonDialogClickListener;
        this.cbWifi.setChecked(true);
        return this;
    }
}
