package com.disabngo.blockynexus.view.dialog.shareactivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.View;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.router.manager.ChannelManager;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.AppToastUtils;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import fi.iki.elonen.NanoHTTPD;

/* JADX INFO: loaded from: classes2.dex */
public class ShareActivityDialog extends FullScreenDialog implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f11684a;
    private Context context;

    public ShareActivityDialog(Context context, String str) {
        super(context);
        this.context = context;
        this.f11684a = str;
    }

    @Override // com.sandboxol.common.dialog.FullScreenDialog
    protected void init(Context context) {
        super.init(context);
        setContentView(R.layout.dialog_activity_share);
        findViewById(R.id.ivWhatsapp).setOnClickListener(this);
        findViewById(R.id.ivTwitter).setOnClickListener(this);
        findViewById(R.id.ivSystem).setOnClickListener(this);
        findViewById(R.id.tvCancel).setOnClickListener(this);
        findViewById(R.id.ivDiscord).setOnClickListener(this);
        findViewById(R.id.ivLine).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.context instanceof Activity) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SEND");
            intent.setType(NanoHTTPD.MIME_PLAINTEXT);
            PackageManager packageManager = this.context.getPackageManager();
            switch (view.getId()) {
                case R.id.ivDiscord /* 2131296869 */:
                    ReportDataAdapter.onEvent(this.context, EventConstant.CLICK_SHARE_CHANNEL_TIME, "discord");
                    intent.putExtra("android.intent.extra.TEXT", this.context.getString(R.string.activity_share_invitation_content) + UMCustomLogInfoBuilder.LINE_SEP + this.f11684a);
                    intent.setPackage("com.discord");
                    if (packageManager.resolveActivity(intent, 65536) == null) {
                        Context context = this.context;
                        AppToastUtils.showLongNegativeTipToast(context, context.getString(R.string.activity_share_discord_tips));
                    } else {
                        ((Activity) this.context).startActivityForResult(intent, 1);
                        dismiss();
                    }
                    break;
                case R.id.ivFacebook /* 2131296873 */:
                    ReportDataAdapter.onEvent(this.context, EventConstant.CLICK_SHARE_CHANNEL_TIME, StringConstant.THIRD_PART_LOGIN_FB);
                    Context context2 = this.context;
                    ChannelManager.onFacebookShare((Activity) context2, this.f11684a, context2.getString(R.string.activity_share_invitation_content), Uri.parse("http://static.sandboxol.com/sandbox/activity/banner/sharesharepage.png"));
                    dismiss();
                    break;
                case R.id.ivLine /* 2131296885 */:
                    ReportDataAdapter.onEvent(this.context, EventConstant.CLICK_SHARE_CHANNEL_TIME, StringConstant.THIRD_PART_LOGIN_LINE);
                    Uri uri = Uri.parse("line://msg/text/" + this.context.getString(R.string.activity_share_invitation_content) + " " + this.f11684a);
                    if (packageManager.resolveActivity(new Intent("android.intent.action.VIEW", uri), 65536) != null) {
                        ((Activity) this.context).startActivityForResult(new Intent("android.intent.action.VIEW", uri), 2);
                    } else {
                        Context context3 = this.context;
                        AppToastUtils.showLongNegativeTipToast(context3, context3.getString(R.string.activity_share_line_tips));
                    }
                    dismiss();
                    break;
                case R.id.ivSystem /* 2131296916 */:
                    ReportDataAdapter.onEvent(this.context, EventConstant.CLICK_SHARE_CHANNEL_TIME, "system");
                    intent.putExtra("android.intent.extra.TEXT", this.context.getString(R.string.activity_share_invitation_content) + UMCustomLogInfoBuilder.LINE_SEP + this.f11684a);
                    if (packageManager.resolveActivity(intent, 65536) == null) {
                        Context context4 = this.context;
                        AppToastUtils.showLongNegativeTipToast(context4, context4.getString(R.string.activity_share_no_app_can_share_tips));
                    } else {
                        ((Activity) this.context).startActivityForResult(intent, 3);
                        dismiss();
                    }
                    break;
                case R.id.ivTwitter /* 2131296921 */:
                    ReportDataAdapter.onEvent(this.context, EventConstant.CLICK_SHARE_CHANNEL_TIME, StringConstant.THIRD_PART_LOGIN_TW);
                    Context context5 = this.context;
                    ChannelManager.onTwitterShare(context5, this.f11684a, context5.getString(R.string.activity_share_invitation_content), null);
                    dismiss();
                    break;
                case R.id.ivWhatsapp /* 2131296922 */:
                    ReportDataAdapter.onEvent(this.context, EventConstant.CLICK_SHARE_CHANNEL_TIME, "whatsapp");
                    intent.putExtra("android.intent.extra.TEXT", this.context.getString(R.string.activity_share_invitation_content) + UMCustomLogInfoBuilder.LINE_SEP + this.f11684a);
                    intent.setPackage("com.whatsapp");
                    if (packageManager.resolveActivity(intent, 65536) == null) {
                        Context context6 = this.context;
                        AppToastUtils.showLongNegativeTipToast(context6, context6.getString(R.string.activity_share_whatsapp_tips));
                    } else {
                        ((Activity) this.context).startActivityForResult(intent, 0);
                        dismiss();
                    }
                    break;
                case R.id.tvCancel /* 2131298052 */:
                    dismiss();
                    break;
            }
        }
    }
}
