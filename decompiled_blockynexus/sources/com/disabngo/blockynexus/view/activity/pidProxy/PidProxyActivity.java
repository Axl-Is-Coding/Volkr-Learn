package com.disabngo.blockynexus.view.activity.pidProxy;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.router.manager.ChannelManager;
import com.sandboxol.center.router.moduleInfo.game.GameBroadcastType;
import com.sandboxol.center.view.dialog.LoadingDialog;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.messager.MessagerClient;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes2.dex */
public class PidProxyActivity extends Activity {
    private void b() {
        Messenger.getDefault().register(this, "pidActivity.finish", new Action0() { // from class: com.disabngo.blockynexus.view.activity.pidProxy.a
            @Override // rx.functions.Action0
            public final void call() {
                this.f11061a.a();
            }
        });
        int intExtra = getIntent().getIntExtra("shareClass", -1);
        Uri uri = (Uri) getIntent().getParcelableExtra("shareUri");
        if (intExtra == 0) {
            new LoadingDialog(this).show();
            ChannelManager.onFacebookShare(this, null, "", uri);
            ReportDataAdapter.onEvent(this, EventConstant.SHARE_FACEBOOK_CLICK);
        } else if (intExtra == 1) {
            new LoadingDialog(this).show();
            ChannelManager.onGooglePlusShare(this, null, "", uri);
        } else {
            if (intExtra != 2) {
                return;
            }
            ChannelManager.onTwitterShare(this, null, "", uri);
            ReportDataAdapter.onEvent(this, EventConstant.SHARE_TWITTER_CLICK);
        }
    }

    public /* synthetic */ void a() {
        finish();
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        ChannelManager.onActivityResult(i, i2, intent);
        finish();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(67108864);
        b();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Messenger.getDefault().unregister(this);
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        MessagerClient.getIns().sendMsg0(GameBroadcastType.BROADCAST_DISMISS_SCREENSHOTSHAREDIALOG);
    }
}
