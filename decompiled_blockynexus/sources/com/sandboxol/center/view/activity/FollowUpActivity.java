package com.sandboxol.center.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import com.sandboxol.center.utils.IntentUtils;

/* JADX INFO: loaded from: classes3.dex */
public class FollowUpActivity extends AppCompatActivity {
    private boolean isHasFollowUp;

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        followUp();
    }

    public void followUp() {
        if (this.isHasFollowUp) {
            IntentUtils.startPasswordSettingDialog(this, true);
        }
    }

    public void setHasFollowUp(boolean z) {
        this.isHasFollowUp = z;
    }
}
