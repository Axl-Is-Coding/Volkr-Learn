package com.disabngo.blockynexus.view.dialog;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.databinding.BaseDialogAppRechargeBinding;

/* JADX INFO: loaded from: classes2.dex */
public class OverallSituationDialog extends AppCompatActivity implements View.OnClickListener {
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.btnSure) {
            return;
        }
        finish();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra(StringConstant.OVERALL_DIALOG_TITLE);
        String stringExtra2 = getIntent().getStringExtra(StringConstant.OVERALL_DIALOG_CONTENT);
        BaseDialogAppRechargeBinding baseDialogAppRechargeBinding = (BaseDialogAppRechargeBinding) androidx.databinding.e.a(this, R.layout.base_dialog_app_recharge);
        baseDialogAppRechargeBinding.btnSure.setOnClickListener(this);
        baseDialogAppRechargeBinding.tvTitle.setText(stringExtra);
        baseDialogAppRechargeBinding.tvDetails.setText(stringExtra2);
    }
}
