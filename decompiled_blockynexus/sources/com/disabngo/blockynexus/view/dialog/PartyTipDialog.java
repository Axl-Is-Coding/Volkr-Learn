package com.disabngo.blockynexus.view.dialog;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.AbstractC0555dc;
import com.disabngo.blockynexus.view.activity.main.bc;
import com.sandboxol.blockmango.config.GameConstant;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.greendao.entity.InviteMessage;

/* JADX INFO: loaded from: classes2.dex */
public class PartyTipDialog extends Activity implements View.OnClickListener {
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != R.id.btnCancel) {
            if (id == R.id.btnConfirm) {
                InviteMessage inviteMessage = (InviteMessage) getIntent().getSerializableExtra(GameConstant.INVITE_TEAM_MESSAGE_NEXT);
                if (inviteMessage != null) {
                    ReportDataAdapter.onEvent(this, EventConstant.CLICK_ACCEPT_TIME, inviteMessage.getGameType());
                    new bc().a(this, inviteMessage, 8);
                    return;
                }
                return;
            }
            if (id != R.id.ivCancel) {
                return;
            }
        }
        if (isFinishing()) {
            return;
        }
        finish();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        AbstractC0555dc abstractC0555dc = (AbstractC0555dc) androidx.databinding.e.a(this, R.layout.dialog_party_tip);
        abstractC0555dc.f8255c.setOnClickListener(this);
        abstractC0555dc.f8253a.setOnClickListener(this);
        abstractC0555dc.f8254b.setOnClickListener(this);
    }
}
