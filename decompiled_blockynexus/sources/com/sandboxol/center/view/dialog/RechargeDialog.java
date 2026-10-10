package com.sandboxol.center.view.dialog;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.sandboxol.center.R;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.databinding.BaseDialogAppRechargeBinding;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.view.activity.FollowUpActivity;
import com.sandboxol.greendao.c.va;

/* JADX INFO: loaded from: classes3.dex */
public class RechargeDialog extends FollowUpActivity implements View.OnClickListener {
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.btnSure) {
            finish();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        boolean booleanExtra = getIntent().getBooleanExtra(StringConstant.RECHARGE_RESULT, false);
        String stringExtra = getIntent().getStringExtra(StringConstant.RECHARGE_MESSAGE);
        boolean booleanExtra2 = getIntent().getBooleanExtra(StringConstant.RECHARGE_FROM_GAME, false);
        BaseDialogAppRechargeBinding baseDialogAppRechargeBinding = (BaseDialogAppRechargeBinding) androidx.databinding.e.a(this, R.layout.base_dialog_app_recharge);
        baseDialogAppRechargeBinding.btnSure.setOnClickListener(this);
        baseDialogAppRechargeBinding.tvTitle.setText(getResources().getString(booleanExtra ? R.string.base_tip : R.string.base_recharge_failed));
        baseDialogAppRechargeBinding.tvDetails.setText(stringExtra == null ? "" : stringExtra);
        if (AccountCenter.newInstance().hasPassword.get().booleanValue() || AccountCenter.newInstance().userId.get().longValue() == 0 || TextUtils.isEmpty(getString(R.string.base_recharge_success)) || !getString(R.string.base_recharge_success).equals(stringExtra)) {
            return;
        }
        if (!booleanExtra2) {
            setHasFollowUp(true);
        } else if (booleanExtra) {
            va.newInstance().a(AccountCenter.newInstance().userId.get().longValue(), true);
        }
    }
}
