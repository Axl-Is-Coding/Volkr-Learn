package com.disabngo.blockynexus.view.dialog;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.config.UrlConstant;
import com.sandboxol.center.router.manager.ChannelManager;
import com.sandboxol.center.view.dialog.LoadingDialog;
import com.sandboxol.common.dialog.FullScreenDialog;

/* JADX INFO: loaded from: classes2.dex */
public class ShareDialog extends FullScreenDialog implements View.OnClickListener {
    private Context context;

    public ShareDialog(Context context) {
        super(context);
        this.context = context;
    }

    @Override // com.sandboxol.common.dialog.FullScreenDialog
    protected void init(Context context) {
        super.init(context);
        setContentView(R.layout.dialog_share);
        findViewById(R.id.ivGoogle).setOnClickListener(this);
        findViewById(R.id.ivTwitter).setOnClickListener(this);
        findViewById(R.id.ivFacebook).setOnClickListener(this);
        findViewById(R.id.tvCancel).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivFacebook /* 2131296873 */:
                new LoadingDialog(this.context).show();
                ChannelManager.onFacebookShare((Activity) this.context, UrlConstant.PLAY_STORE_URL, "test", Uri.parse("http://static.sandboxol.cn/sandbox/config/android/image/version_icon_clan.png"));
                dismiss();
                break;
            case R.id.ivGoogle /* 2131296878 */:
                new LoadingDialog(this.context).show();
                ChannelManager.onGooglePlusShare((Activity) this.context, UrlConstant.SHARE_URL, "test", null);
                dismiss();
                break;
            case R.id.ivTwitter /* 2131296921 */:
                ChannelManager.onTwitterShare(this.context, UrlConstant.SHARE_URL, "test", null);
                dismiss();
                break;
            case R.id.tvCancel /* 2131298052 */:
                dismiss();
                break;
        }
    }
}
