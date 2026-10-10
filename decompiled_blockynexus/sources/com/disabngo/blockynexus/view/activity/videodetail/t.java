package com.disabngo.blockynexus.view.activity.videodetail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.widget.LinearLayout;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.d.D;
import com.disabngo.blockynexus.e.b.x.J;
import com.disabngo.blockynexus.entity.FriendActivityIntentInfo;
import com.disabngo.blockynexus.view.activity.webview.WebViewActivity;
import com.disabngo.blockynexus.web.VideoApi;
import com.just.agentweb.AgentWeb;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.view.dialog.LoadingDialog;
import com.sandboxol.common.interfaces.OnDataListener;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.CommonHelper;
import com.sandboxol.greendao.c.Aa;
import com.sandboxol.greendao.entity.Friend;
import com.sandboxol.greendao.entity.VideoDetailInfo;

/* JADX INFO: compiled from: VideoDetailModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class t {
    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Context context, long j) {
        VideoApi.getVideoDetailInfo(context, j, new s(context));
    }

    public void b(Context context, VideoDetailInfo videoDetailInfo) {
        if (videoDetailInfo.getEvaluateStatus() == 1) {
            AppToastUtils.showShortNegativeTipToast(context, R.string.activity_video_have_evaluation);
        } else {
            videoDetailInfo.setEvaluateStatus(videoDetailInfo.getEvaluateStatus() == 0 ? 2 : 0);
            VideoApi.postDisLike(context, videoDetailInfo.getVideoId(), new m(this, videoDetailInfo, context));
        }
    }

    public void c(Context context, VideoDetailInfo videoDetailInfo) {
        if (videoDetailInfo.getEvaluateStatus() == 2) {
            AppToastUtils.showShortNegativeTipToast(context, R.string.activity_video_have_evaluation);
        } else {
            videoDetailInfo.setEvaluateStatus(videoDetailInfo.getEvaluateStatus() == 0 ? 1 : 0);
            VideoApi.postPraise(context, videoDetailInfo.getVideoId(), new n(this, videoDetailInfo, context));
        }
    }

    public AgentWeb a(Activity activity, ViewGroup viewGroup, String str) {
        AgentWeb agentWebGo = AgentWeb.with(activity).setAgentWebParent(viewGroup, new LinearLayout.LayoutParams(-1, -1)).useDefaultIndicator().setWebChromeClient(new l(this, activity)).setWebViewClient(new k(this)).createAgentWeb().ready().go(a(str));
        WebSettings webSettings = agentWebGo.getAgentWebSettings().getWebSettings();
        if (Build.VERSION.SDK_INT >= 17) {
            webSettings.setMediaPlaybackRequiresUserGesture(false);
        }
        webSettings.setBuiltInZoomControls(false);
        webSettings.setSupportZoom(false);
        webSettings.setDisplayZoomControls(false);
        agentWebGo.getWebCreator().getWebView().setBackgroundColor(-16777216);
        return agentWebGo;
    }

    public void b(Context context, long j, OnDataListener<VideoDetailInfo> onDataListener) {
        LoadingDialog loadingDialog = new LoadingDialog(context);
        loadingDialog.show();
        VideoApi.getVideoDetailInfo(context, j, new q(this, loadingDialog, onDataListener, context));
    }

    public void c(Context context, long j) {
        if (j != 0) {
            J.a(context, (Friend) null, new FriendActivityIntentInfo(j, j == AccountCenter.newInstance().userId.get().longValue() ? 4 : 2));
        }
    }

    public static void b(Context context, long j) {
        if (j != 0) {
            Aa.newInstance().a(j, new r(context, j));
        } else {
            AppToastUtils.showShortNegativeTipToast(context, R.string.activity_video_not_exist);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, VideoDetailInfo videoDetailInfo, Boolean bool) {
        D.a(context, videoDetailInfo, bool.booleanValue());
    }

    public void a(Context context, String str) {
        if (CommonHelper.isAppInstalled(context, "com.google.android.youtube")) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            intent.setClassName("com.google.android.youtube", "com.google.android.youtube.UrlActivity");
            context.startActivity(intent);
            return;
        }
        WebViewActivity.a(context, str, "", false);
    }

    public void a(Context context, VideoDetailInfo videoDetailInfo) {
        long videoId = videoDetailInfo.getVideoId();
        if (videoId != 0) {
            VideoApi.postPlayAmount(context, videoId, new o(this, videoDetailInfo, context));
        }
    }

    public void a(Context context, long j, OnDataListener<VideoDetailInfo> onDataListener) {
        VideoApi.getVideoDetailInfo(context, j, new p(this, onDataListener, context));
    }

    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return str + "?autoplay=1&loop=1&playlist=" + str.substring(str.lastIndexOf("/") + 1) + "&muted=1";
    }
}
