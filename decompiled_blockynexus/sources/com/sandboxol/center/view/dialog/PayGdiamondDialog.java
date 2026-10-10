package com.sandboxol.center.view.dialog;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.sandboxol.center.R;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.greendao.c.va;

/* JADX INFO: loaded from: classes3.dex */
public class PayGdiamondDialog extends FullScreenDialog implements View.OnClickListener {
    private OnTwoButtonDialogClickListener LeftListener;
    private CheckBox cbWifi;
    private OnTwoButtonDialogClickListener listener;

    public interface OnTwoButtonDialogClickListener {
        void onClick();
    }

    public PayGdiamondDialog(Context context, int i) {
        super(context);
        initView(i);
    }

    public void initView(int i) {
        setContentView(R.layout.base_dialog_pay_gdiamond);
        Button button = (Button) findViewById(R.id.btnSure);
        Button button2 = (Button) findViewById(R.id.btnCancel);
        this.cbWifi = (CheckBox) findViewById(R.id.cbWifi);
        ((TextView) findViewById(R.id.tvDetails1)).setText(this.context.getString(R.string.base_gcube_need_pay, Integer.valueOf(i)));
        button2.setOnClickListener(this);
        button.setOnClickListener(this);
        this.cbWifi.setChecked(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btnCancel) {
            OnTwoButtonDialogClickListener onTwoButtonDialogClickListener = this.LeftListener;
            if (onTwoButtonDialogClickListener != null) {
                onTwoButtonDialogClickListener.onClick();
            }
            if (isShowing()) {
                dismiss();
                return;
            }
            return;
        }
        if (id == R.id.btnSure) {
            OnTwoButtonDialogClickListener onTwoButtonDialogClickListener2 = this.listener;
            if (onTwoButtonDialogClickListener2 != null) {
                onTwoButtonDialogClickListener2.onClick();
            }
            if (this.cbWifi.isChecked()) {
                va.newInstance().b(AccountCenter.newInstance().userId.get().longValue(), true);
            }
            if (isShowing()) {
                dismiss();
            }
        }
    }

    public PayGdiamondDialog setLeftListener(OnTwoButtonDialogClickListener onTwoButtonDialogClickListener) {
        this.LeftListener = onTwoButtonDialogClickListener;
        return this;
    }

    public PayGdiamondDialog setListener(OnTwoButtonDialogClickListener onTwoButtonDialogClickListener) {
        this.listener = onTwoButtonDialogClickListener;
        return this;
    }
}
