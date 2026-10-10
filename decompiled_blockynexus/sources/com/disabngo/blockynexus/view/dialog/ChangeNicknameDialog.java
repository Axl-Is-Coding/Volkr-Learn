package com.disabngo.blockynexus.view.dialog;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.entity.ModifyNameFreeResponse;
import com.sandboxol.common.dialog.FullScreenDialog;

/* JADX INFO: loaded from: classes2.dex */
public class ChangeNicknameDialog extends FullScreenDialog implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private OnTwoButtonDialogClickListener f11272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ModifyNameFreeResponse f11273b;

    public interface OnTwoButtonDialogClickListener {
        void onClick();
    }

    public ChangeNicknameDialog(Context context, ModifyNameFreeResponse modifyNameFreeResponse) {
        super(context);
        this.f11273b = modifyNameFreeResponse;
        initView();
    }

    public ChangeNicknameDialog a(OnTwoButtonDialogClickListener onTwoButtonDialogClickListener) {
        this.f11272a = onTwoButtonDialogClickListener;
        return this;
    }

    public void initView() {
        setContentView(R.layout.dialog_change_nickname);
        TextView textView = (TextView) findViewById(R.id.tvDiamond);
        Button button = (Button) findViewById(R.id.btnSure);
        Button button2 = (Button) findViewById(R.id.btnCancel);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.llDiamond);
        button2.setOnClickListener(this);
        button.setOnClickListener(this);
        linearLayout.setVisibility(this.f11273b.isFree() ? 8 : 0);
        textView.setText(String.valueOf(this.f11273b.getQuantity()));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btnCancel) {
            dismiss();
            return;
        }
        if (id != R.id.btnSure) {
            return;
        }
        dismiss();
        OnTwoButtonDialogClickListener onTwoButtonDialogClickListener = this.f11272a;
        if (onTwoButtonDialogClickListener != null) {
            onTwoButtonDialogClickListener.onClick();
        }
    }
}
