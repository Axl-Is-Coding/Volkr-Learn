package com.disabngo.blockynexus.view.dialog;

import android.content.Context;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.common.interfaces.ReportDataAdapter;

/* JADX INFO: loaded from: classes2.dex */
public class FriendMatchPermissionApplyDialog extends FullScreenDialog implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TextView f11300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TextView f11301b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Button f11302c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Button f11303d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private OnTwoButtonDialogClickListener f11304e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private a f11305f;

    public interface OnTwoButtonDialogClickListener {
        void onClick();
    }

    public interface a {
        void onLeftClick();
    }

    public FriendMatchPermissionApplyDialog(Context context) {
        super(context);
        initView();
    }

    public FriendMatchPermissionApplyDialog a(OnTwoButtonDialogClickListener onTwoButtonDialogClickListener) {
        this.f11304e = onTwoButtonDialogClickListener;
        return this;
    }

    public void initView() {
        setContentView(R.layout.dialog_friend_match_permission_apply);
        this.f11300a = (TextView) findViewById(R.id.tvTitle);
        this.f11301b = (TextView) findViewById(R.id.tvDetails);
        this.f11302c = (Button) findViewById(R.id.btnSure);
        this.f11303d = (Button) findViewById(R.id.btnCancel);
        this.f11303d.setOnClickListener(this);
        this.f11302c.setOnClickListener(this);
        ReportDataAdapter.onEvent(this.context, EventConstant.FRIEND_MATCH_PERMISSION_APPLY_DIALOG_SHOW);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btnCancel) {
            dismiss();
            a aVar = this.f11305f;
            if (aVar != null) {
                aVar.onLeftClick();
                return;
            }
            return;
        }
        if (id != R.id.btnSure) {
            return;
        }
        dismiss();
        OnTwoButtonDialogClickListener onTwoButtonDialogClickListener = this.f11304e;
        if (onTwoButtonDialogClickListener != null) {
            onTwoButtonDialogClickListener.onClick();
        }
    }

    public FriendMatchPermissionApplyDialog setDetailText(String str) {
        this.f11301b.setText(Html.fromHtml(str));
        return this;
    }

    public FriendMatchPermissionApplyDialog setTitleText(int i) {
        this.f11300a.setText(i);
        return this;
    }
}
