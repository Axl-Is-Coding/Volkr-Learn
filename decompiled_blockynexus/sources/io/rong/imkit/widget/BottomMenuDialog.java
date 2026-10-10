package io.rong.imkit.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import io.rong.imkit.R;

/* JADX INFO: loaded from: classes5.dex */
public class BottomMenuDialog extends Dialog implements View.OnClickListener {
    private View.OnClickListener cancelListener;
    private String cancelText;
    private View.OnClickListener confirmListener;
    private String confirmText;
    private View.OnClickListener middleListener;
    private String middleText;

    BottomMenuDialog(Context context) {
        super(context, R.style.dialogFullscreen);
    }

    public View.OnClickListener getCancelListener() {
        return this.cancelListener;
    }

    public View.OnClickListener getConfirmListener() {
        return this.confirmListener;
    }

    public View.OnClickListener getMiddleListener() {
        return this.middleListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        View.OnClickListener onClickListener = id == R.id.bt_by_step ? this.confirmListener : id == R.id.bt_combine ? this.middleListener : id == R.id.bt_cancel ? this.cancelListener : null;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.rc_dialog_bottom);
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.flags = 2;
            attributes.dimAmount = 0.5f;
            window.setAttributes(attributes);
            window.setBackgroundDrawableResource(android.R.color.transparent);
        }
        Button button = (Button) findViewById(R.id.bt_by_step);
        Button button2 = (Button) findViewById(R.id.bt_combine);
        Button button3 = (Button) findViewById(R.id.bt_cancel);
        if (!TextUtils.isEmpty(this.confirmText)) {
            button.setText(this.confirmText);
        }
        if (!TextUtils.isEmpty(this.middleText)) {
            button2.setText(this.middleText);
        }
        if (!TextUtils.isEmpty(this.cancelText)) {
            button3.setText(this.cancelText);
        }
        button3.setOnClickListener(this);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    void setCancelListener(View.OnClickListener onClickListener) {
        this.cancelListener = onClickListener;
    }

    void setConfirmListener(View.OnClickListener onClickListener) {
        this.confirmListener = onClickListener;
    }

    void setMiddleListener(View.OnClickListener onClickListener) {
        this.middleListener = onClickListener;
    }

    public BottomMenuDialog(Context context, int i) {
        super(context, i);
    }

    public BottomMenuDialog(Context context, String str, String str2) {
        super(context, R.style.dialogFullscreen);
        this.confirmText = str;
        this.middleText = str2;
    }

    public BottomMenuDialog(Context context, String str, String str2, String str3) {
        super(context, R.style.dialogFullscreen);
        this.confirmText = str;
        this.middleText = str2;
        this.cancelText = str3;
    }
}
