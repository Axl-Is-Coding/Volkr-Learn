package com.sandboxol.center.view.dialog;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.sandboxol.center.R;
import com.sandboxol.center.router.moduleInfo.pay.BroadcastType;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.messager.MessagerClient;

/* JADX INFO: loaded from: classes3.dex */
public class TopLoadingDialog extends AppCompatActivity implements View.OnClickListener {
    private AnimationDrawable loadingAnim;

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.btnSure) {
            finish();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.base_dialog_app_loading);
        this.loadingAnim = (AnimationDrawable) ((ImageView) findViewById(R.id.ivLoading)).getBackground();
        if (!this.loadingAnim.isRunning()) {
            this.loadingAnim.start();
        }
        MessagerClient.getIns().registerMsg0(TopLoadingDialog.class, BroadcastType.BROADCAST_CLOSE_LOADING_DIALOG, new com.sandboxol.messager.a.a() { // from class: com.sandboxol.center.view.dialog.TopLoadingDialog.1
            @Override // com.sandboxol.messager.a.a
            public void onCall() {
                if (TopLoadingDialog.this.isFinishing()) {
                    return;
                }
                TopLoadingDialog.this.finish();
            }
        });
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        try {
            super.onDestroy();
            Messenger.getDefault().unregister(this);
            MessagerClient.getIns().unRegisterMsg(getClass());
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        if (isFinishing()) {
            overridePendingTransition(R.anim.base_start_loading, R.anim.base_start_loading_back);
        }
    }
}
