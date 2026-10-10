package com.sandboxol.imchat.ui.dialog;

import android.content.Context;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.imchat.R;

/* JADX INFO: loaded from: classes4.dex */
public class TeamDialog extends FullScreenDialog implements View.OnClickListener {
    private Button btnCancel;
    private Button btnSure;
    private OnTeamBackDialogClickListener listener;
    private TextView tvDetails;
    private TextView tvTitle;

    public interface OnTeamBackDialogClickListener {
        void onClick();
    }

    public TeamDialog(Context context) {
        super(context);
        initView();
    }

    public void initView() {
        setContentView(R.layout.dialog_team_back);
        this.tvTitle = (TextView) findViewById(R.id.tvTitle);
        this.tvDetails = (TextView) findViewById(R.id.tvDetails);
        this.btnSure = (Button) findViewById(R.id.btnSure);
        this.btnCancel = (Button) findViewById(R.id.btnCancel);
        this.btnCancel.setOnClickListener(this);
        this.btnSure.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btnCancel) {
            dismiss();
            return;
        }
        if (id == R.id.btnSure) {
            dismiss();
            OnTeamBackDialogClickListener onTeamBackDialogClickListener = this.listener;
            if (onTeamBackDialogClickListener != null) {
                onTeamBackDialogClickListener.onClick();
            }
        }
    }

    public TeamDialog setDetailText(String str) {
        this.tvDetails.setText(Html.fromHtml(str));
        return this;
    }

    public TeamDialog setListener(OnTeamBackDialogClickListener onTeamBackDialogClickListener) {
        this.listener = onTeamBackDialogClickListener;
        return this;
    }
}
