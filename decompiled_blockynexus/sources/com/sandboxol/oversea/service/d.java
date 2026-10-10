package com.sandboxol.oversea.service;

import android.content.Context;
import android.util.Log;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.router.moduleInfo.login.interfaces.ILoginListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.oversea.R;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.k;
import com.twitter.sdk.android.core.y;

/* JADX INFO: compiled from: ChannelService.java */
/* JADX INFO: loaded from: classes4.dex */
class d extends com.twitter.sdk.android.core.c<y> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ILoginListener f18844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f18845b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ChannelService f18846c;

    d(ChannelService channelService, ILoginListener iLoginListener, Context context) {
        this.f18846c = channelService;
        this.f18844a = iLoginListener;
        this.f18845b = context;
    }

    @Override // com.twitter.sdk.android.core.c
    public void a(k<y> kVar) {
        try {
            y yVar = kVar.f20217a;
            Log.d("TwitterKit", String.format("Login Success: userId: %s authToken: %s", Long.valueOf(yVar.c()), yVar.a().f20267b));
            this.f18844a.loginSuccessful(yVar.c() + "", yVar.d(), yVar.a().f20267b, StringConstant.THIRD_PART_LOGIN_TW);
            ReportDataAdapter.onEvent(this.f18845b, EventConstant.THIRD_TWITTER_SUC);
        } catch (Exception unused) {
            Log.e("TwitterKit", "success exception");
            ReportDataAdapter.onEvent(this.f18845b, EventConstant.THIRD_TWITTER_FAILED);
        }
    }

    @Override // com.twitter.sdk.android.core.c
    public void a(TwitterException twitterException) {
        Log.d("TwitterKit", String.format("Login with Twitter failure: %s", twitterException.getMessage()));
        AppToastUtils.showShortNegativeTipToast(this.f18845b, R.string.twitter_login_failed);
        ReportDataAdapter.onEvent(this.f18845b, EventConstant.THIRD_TWITTER_FAILED);
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_THIRD_LOGIN_CANCEL);
    }
}
