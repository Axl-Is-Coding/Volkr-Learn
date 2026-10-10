package com.disabngo.blockynexus.d;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Process;
import android.util.Log;
import com.alibaba.android.arouter.launcher.ARouter;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.e.b.c.C0822b;
import com.disabngo.blockynexus.entity.UserMapInfo;
import com.disabngo.blockynexus.view.activity.discover.DiscoverActivity;
import com.disabngo.blockynexus.view.activity.friendmatch.FriendMatchActivity;
import com.disabngo.blockynexus.view.activity.join.EnterGameActivity;
import com.disabngo.blockynexus.view.activity.main.MainActivity;
import com.disabngo.blockynexus.view.activity.overviewrank.OverViewRankActivity;
import com.disabngo.blockynexus.view.activity.searchfriend.SearchFriendActivity;
import com.disabngo.blockynexus.view.activity.tribesearch.TribeSearchActivity;
import com.disabngo.blockynexus.view.activity.videodetail.VideoDetailActivity;
import com.disabngo.blockynexus.view.dialog.FiveStarsDialog;
import com.disabngo.blockynexus.view.dialog.UploadApkDialog;
import com.disabngo.blockynexus.view.dialog.UploadNewGameDialog;
import com.disabngo.blockynexus.view.dialog.UploadSoDialog;
import com.disabngo.blockynexus.view.dialog.partyfriend.PartyFriendInfoDialog;
import com.disabngo.blockynexus.view.fragment.tribehas.TribeHasFragment;
import com.disabngo.blockynexus.view.fragment.tribeno.TribeNoFragment;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.config.UrlConstant;
import com.sandboxol.center.entity.AppInfoCenter;
import com.sandboxol.center.entity.LatestVersion;
import com.sandboxol.center.router.manager.HalloweenManager;
import com.sandboxol.center.router.manager.SandboxReportManager;
import com.sandboxol.center.router.moduleInfo.game.EnterRealmsResult;
import com.sandboxol.center.router.moduleInfo.report.ReportEvent;
import com.sandboxol.center.router.moduleInfo.report.ReportEventType;
import com.sandboxol.center.router.path.RouterActivityPath;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.center.view.dialog.TopLoadingDialog;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.greendao.entity.Game;
import com.sandboxol.greendao.entity.VideoDetailInfo;

/* JADX INFO: compiled from: IntentUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class D {
    public static void a(Context context, String str, String str2) {
        Intent intent = new Intent(context, (Class<?>) UploadSoDialog.class);
        intent.setFlags(268435456);
        intent.putExtra(StringConstant.UPLOAD_SO_URL, str);
        intent.putExtra(StringConstant.UPLOAD_SO_SIGNATURE, str2);
        context.startActivity(intent);
    }

    public static void b(Context context, LatestVersion latestVersion, boolean z) {
        Intent intent = new Intent(context, (Class<?>) UploadApkDialog.class);
        intent.setFlags(268435456);
        intent.putExtra(StringConstant.UPLOAD_SO_URL, latestVersion.getApkUrl());
        intent.putExtra(StringConstant.IS_FORCE_UPDATE, z);
        intent.putExtra(StringConstant.UPLOAD_DETAILS, latestVersion.getContent(z));
        intent.putExtra(StringConstant.UPLOAD_PIC_URL, latestVersion.getPicUrl());
        context.startActivity(intent);
    }

    public static void c(Activity activity) {
        Intent intent = new Intent(activity, (Class<?>) TopLoadingDialog.class);
        intent.setFlags(268435456);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.base_start_loading, R.anim.base_start_loading_back);
    }

    public static void d(Context context) {
        Intent intent = new Intent(context, (Class<?>) MainActivity.class);
        intent.setFlags(67108864);
        context.startActivity(intent);
    }

    public static void e(Context context) {
        c(context, true);
    }

    public static void f(Context context) {
        context.startActivity(new Intent(context, (Class<?>) TribeHasFragment.class));
    }

    public static void g(Context context) {
        context.startActivity(new Intent(context, (Class<?>) TribeNoFragment.class));
    }

    public static void h(Context context) {
        context.startActivity(new Intent(context, (Class<?>) TribeSearchActivity.class));
    }

    private static void i(Context context) {
        try {
            context.startActivity(new Intent(BaseApplication.getApp().getPackageName() + ".christmas"));
        } catch (ActivityNotFoundException unused) {
            AppToastUtils.showShortNegativeTipToast(context, "empty");
        }
    }

    private static void j(Context context) {
    }

    private static void k(Context context) {
        try {
            ARouter.getInstance().build(RouterActivityPath.Jackpot.MAIN_ACTIVITY).navigation();
        } catch (ActivityNotFoundException unused) {
            AppToastUtils.showShortNegativeTipToast(context, "empty");
        }
    }

    private static void l(Context context) {
        try {
            ARouter.getInstance().build(RouterActivityPath.VideoSubmit.MAIN_ACTIVITY).navigation();
        } catch (Exception unused) {
            AppToastUtils.showShortNegativeTipToast(context, "empty");
        }
    }

    private static void m(Context context) {
        try {
            context.startActivity(new Intent(BaseApplication.getApp().getPackageName() + ".wheel"));
        } catch (ActivityNotFoundException unused) {
            AppToastUtils.showShortNegativeTipToast(context, "empty");
        }
    }

    public static void c(Context context) {
        Intent intent = new Intent(context, (Class<?>) FiveStarsDialog.class);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    public static void a(Context context, LatestVersion latestVersion, boolean z) {
        Intent intent = new Intent(context, (Class<?>) UploadApkDialog.class);
        intent.setFlags(268435456);
        intent.putExtra(StringConstant.UPLOAD_SO_URL, latestVersion.getUrl());
        intent.putExtra(StringConstant.IS_FORCE_UPDATE, z);
        intent.putExtra(StringConstant.UPLOAD_DETAILS, latestVersion.getContent(z));
        intent.putExtra(StringConstant.UPLOAD_PIC_URL, latestVersion.getPicUrl());
        context.startActivity(intent);
    }

    public static void b(Context context, boolean z) {
        Intent intent = new Intent(context, (Class<?>) SearchFriendActivity.class);
        intent.setFlags(67108864);
        intent.putExtra(StringConstant.IS_SHOW_FRIEND_DETAIL, z);
        context.startActivity(intent);
        ReportDataAdapter.onEvent(context, EventConstant.CHAT_ADD_FRIEND_CLICK);
        SandboxReportManager.onEvent(ReportEvent.NEW_CHAT_ADD_FRIEND, ReportEventType.NEW_USER_BEHAVIOR, "app");
    }

    public static void c(Context context, boolean z) {
        if (AppInfoCenter.newInstance().getAppConfig().isUseNewSearch()) {
            a(context, z);
        } else {
            b(context, z);
        }
    }

    public static void a(Context context, String str, int i, String str2) {
        Intent intent = new Intent(context, (Class<?>) UploadNewGameDialog.class);
        intent.setFlags(268435456);
        intent.putExtra(StringConstant.GAME_UPDATE_RESULTS, str);
        intent.putExtra(StringConstant.UPLOAD_SO_HASH_CODE, i);
        intent.putExtra(StringConstant.GAME_INFO, str2);
        context.startActivity(intent);
    }

    public static void b(Context context) {
        TemplateUtils.startTemplate(context, C0822b.class, context.getString(R.string.content_main_item1));
    }

    public static void b(Activity activity) {
        activity.startActivity(new Intent(activity, (Class<?>) OverViewRankActivity.class));
        if (activity instanceof MainActivity) {
            return;
        }
        activity.finish();
    }

    public static void a(Context context, boolean z) {
        Intent intent = new Intent(context, (Class<?>) com.disabngo.blockynexus.view.activity.newsearch.SearchFriendActivity.class);
        intent.setFlags(67108864);
        intent.putExtra(StringConstant.IS_SHOW_FRIEND_DETAIL, z);
        context.startActivity(intent);
        ReportDataAdapter.onEvent(context, EventConstant.CHAT_ADD_FRIEND_CLICK);
        SandboxReportManager.onEvent(ReportEvent.NEW_CHAT_ADD_FRIEND, ReportEventType.NEW_USER_BEHAVIOR, "app");
    }

    public static void a(Context context, Game game, EnterRealmsResult enterRealmsResult) {
        Intent intent = new Intent(context, (Class<?>) EnterGameActivity.class);
        intent.putExtra(StringConstant.ENTER_GAME_INFO, game);
        intent.putExtra(StringConstant.ENTER_GAME_REAlMS_SESULT, enterRealmsResult);
        context.startActivity(intent);
    }

    public static void a(Context context, Game game, long j, String str) {
        Intent intent = new Intent(context, (Class<?>) EnterGameActivity.class);
        intent.putExtra(StringConstant.ENTER_GAME_INFO, game);
        intent.putExtra(StringConstant.ENTER_GAME_TARGET_ID, j);
        intent.putExtra(StringConstant.ENTER_GAME_REGION_ID, str);
        context.startActivity(intent);
    }

    public static void a(Context context, Game game, boolean z) {
        Intent intent = new Intent(context, (Class<?>) EnterGameActivity.class);
        intent.putExtra(StringConstant.ENTER_GAME_INFO, game);
        intent.putExtra(StringConstant.ENTER_GAME_FROM_LATELY_GAME, z);
        context.startActivity(intent);
    }

    public static void a(Context context, UserMapInfo userMapInfo) {
        Intent intent = new Intent(context, (Class<?>) FriendMatchActivity.class);
        intent.setFlags(67108864);
        intent.putExtra(StringConstant.FRIEND_MATCH_MY_LOCATION_INFO, userMapInfo);
        context.startActivity(intent);
    }

    public static void a(Context context, String str) {
        if (str != null) {
            switch (str) {
                case "wheel":
                    m(context);
                    ReportDataAdapter.onEvent(context, EventConstant.CLICK_WHEEL_HOME);
                    ReportDataAdapter.onEvent(context, EventConstant.CLICK_WHEEL_ALL);
                    break;
                case "slot_machine":
                case "Lucky 2020":
                    k(context);
                    ReportDataAdapter.onEvent(context, EventConstant.CLICK_WHEEL_HOME);
                    ReportDataAdapter.onEvent(context, EventConstant.CLICK_WHEEL_ALL);
                    break;
                case "Christmas":
                    i(context);
                    break;
                case "Gift bags":
                case "dragon_ball":
                    j(context);
                    ReportDataAdapter.onEvent(context, EventConstant.RECHARGE_CLICK);
                    break;
                case "bgtube":
                    l(context);
                    ReportDataAdapter.onEvent(context, "Click_BGtube_banner");
                    break;
                case "halloween":
                case "thanks_giving":
                    HalloweenManager.enterActivity(context);
                    break;
                case "Jigsaw":
                    TemplateUtils.startTemplate(context, com.disabngo.blockynexus.e.b.da.h.class, context.getString(R.string.app_scrap_main_title));
                    break;
            }
        }
    }

    public static void a(Context context) {
        Log.e("LocalAPI", Log.getStackTraceString(new Throwable()));
        context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(UrlConstant.PLAY_STORE_URL)));
        Process.killProcess(Process.myPid());
    }

    public static void a(Context context, VideoDetailInfo videoDetailInfo, boolean z) {
        Intent intent = new Intent(context, (Class<?>) VideoDetailActivity.class);
        intent.putExtra(StringConstant.YOUTUBE_VIDEO_DETAIL_INFO, videoDetailInfo);
        intent.putExtra(StringConstant.YOUTUBE_VIDEO_DETAIL_IS_NEED_REFRESH, z);
        context.startActivity(intent);
    }

    public static void a(Activity activity) {
        activity.startActivity(new Intent(activity, (Class<?>) DiscoverActivity.class));
        if (activity instanceof MainActivity) {
            return;
        }
        activity.finish();
    }

    public static void a(Activity activity, long j) {
        Intent intent = new Intent(activity, (Class<?>) PartyFriendInfoDialog.class);
        intent.putExtra("friend.id", j);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.base_start_loading, R.anim.base_start_loading_back);
    }
}
