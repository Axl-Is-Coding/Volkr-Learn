package com.disabngo.blockynexus.binding.adapter;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.activity.videodetail.t;
import com.disabngo.blockynexus.view.activity.webview.WebViewActivity;
import com.sandboxol.center.config.ActivityType;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.router.manager.GameDetailManager;
import com.sandboxol.center.router.manager.VipManager;
import com.sandboxol.center.utils.Helper;
import com.sandboxol.center.utils.TemplateUtils;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.CommonHelper;
import com.sandboxol.greendao.entity.BannerEntity;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BannerBindAdapters {

    public static class GlideImageLoader extends ImageLoader {
        @Override // com.youth.banner.loader.ImageLoaderInterface
        public void displayImage(Context context, Object obj, ImageView imageView) {
            if (Helper.isValidContextForGlide(imageView)) {
                com.bumptech.glide.c.c(context).mo54load(obj).into(imageView);
            }
        }
    }

    public static void a(Banner banner, ReplyCommand<Integer> replyCommand) {
        banner.setOnPageChangeListener(new g(replyCommand));
    }

    public static void b(Banner banner, List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        banner.setBannerTitles(list);
    }

    public static void c(Banner banner, List<?> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        banner.setImages(list).setImageLoader(new GlideImageLoader()).start();
    }

    private static List<Boolean> d(List<BannerEntity> list) {
        ArrayList arrayList = new ArrayList();
        for (BannerEntity bannerEntity : list) {
            arrayList.add(Boolean.valueOf((!TextUtils.isEmpty(bannerEntity.getUrl()) && bannerEntity.getUrl().contains("jumpToShop")) || bannerEntity.isInside()));
        }
        return arrayList;
    }

    public static void a(Banner banner, int i, int i2) {
        banner.setBannerStyle(i);
        if (i2 != 0) {
            banner.setIndicatorGravity(i2);
        }
    }

    private static List<String> b(List<BannerEntity> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<BannerEntity> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getUrl());
        }
        return arrayList;
    }

    private static List<Boolean> c(List<BannerEntity> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<BannerEntity> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Boolean.valueOf(it.next().isFullScreen()));
        }
        return arrayList;
    }

    public static void a(final Banner banner, final List<BannerEntity> list) {
        final List<String> listA = a(list);
        final List<Boolean> listD = d(list);
        final List<String> listB = b(list);
        final List<Boolean> listC = c(list);
        banner.setOnBannerListener(new com.youth.banner.a.b() { // from class: com.disabngo.blockynexus.binding.adapter.b
            @Override // com.youth.banner.a.b
            public final void a(int i) {
                BannerBindAdapters.a(listB, banner, list, listD, listC, listA, i);
            }
        });
    }

    static /* synthetic */ void a(List list, Banner banner, List list2, List list3, List list4, List list5, int i) {
        String str = (String) list.get(i);
        ReportDataAdapter.onEvent(banner.getContext(), EventConstant.HOME_BANNER, String.valueOf(((BannerEntity) list2.get(i)).getId()));
        if (BaseApplication.getApp().getMetaDataAppVersion() >= ((BannerEntity) list2.get(i)).getVersion()) {
            if (!((Boolean) list3.get(i)).booleanValue()) {
                if (str == null) {
                    return;
                }
                if (Helper.hasBrowserCount(banner.getContext())) {
                    try {
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setData(Uri.parse(str.replace(" ", "")));
                        banner.getContext().startActivity(intent);
                        return;
                    } catch (ActivityNotFoundException e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
                AppToastUtils.showShortNegativeTipToast(banner.getContext(), R.string.no_browser);
                return;
            }
            if (((Boolean) list4.get(i)).booleanValue()) {
                if (((BannerEntity) list2.get(i)).getVersion() == 0 || BaseApplication.getApp().getMetaDataAppVersion() < ((BannerEntity) list2.get(i)).getVersion()) {
                    return;
                }
                if (str.contains("youtube") && CommonHelper.isAppInstalled(banner.getContext(), "com.google.android.youtube")) {
                    Intent intent2 = new Intent("android.intent.action.VIEW");
                    intent2.setData(Uri.parse(str));
                    intent2.setClassName("com.google.android.youtube", "com.google.android.youtube.UrlActivity");
                    banner.getContext().startActivity(intent2);
                } else {
                    WebViewActivity.a(banner.getContext(), str, (String) list5.get(i), false);
                }
                ReportDataAdapter.onEvent(banner.getContext(), EventConstant.CLICK_WHEEL_BANNER);
                ReportDataAdapter.onEvent(banner.getContext(), EventConstant.CLICK_WHEEL_ALL);
                return;
            }
            if (str.contains("jumpToMineGame=")) {
                GameDetailManager.enterGameDetail(banner.getContext(), (String) list5.get(i), str.replace("jumpToMineGame=", ""));
                return;
            }
            if (str.contains("jumpToRecharge")) {
                TemplateUtils.startTemplate(banner.getContext(), com.sandboxol.googlepay.view.fragment.recharge.k.class, banner.getContext().getString(R.string.me_recharge), R.mipmap.ic_recharge_history);
                return;
            }
            if (str.contains("jumpToShop")) {
                com.disabngo.blockynexus.c.a.a(banner.getContext());
                return;
            }
            if (str.contains("jumpToVip")) {
                VipManager.enterVipFragment(banner.getContext());
                return;
            }
            if (str.contains("jumpToShare")) {
                TemplateUtils.startTemplate(banner.getContext(), com.disabngo.blockynexus.e.b.ja.c.class, banner.getContext().getString(R.string.me_share));
                return;
            }
            if (str.contains("jumpToPreheat")) {
                Bundle bundle = new Bundle();
                bundle.putString(StringConstant.PREHEAT_GAME_ID, str.replace("jumpToPreheat=", ""));
                TemplateUtils.startTemplate(banner.getContext(), com.disabngo.blockynexus.e.b.U.c.class, (String) list5.get(i), bundle);
                return;
            }
            if (str.contains("jumpToTribe")) {
                Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_SELECT_TRIBE);
                return;
            }
            if (str.contains("jumpToCampaign")) {
                if (((BannerEntity) list2.get(i)).getVersion() == 0 || BaseApplication.getApp().getMetaDataAppVersion() < ((BannerEntity) list2.get(i)).getVersion()) {
                    return;
                }
                if (str.contains(":campaign")) {
                    String[] strArrSplit = str.split(":");
                    String str2 = strArrSplit.length > 2 ? strArrSplit[2] : "";
                    Messenger.getDefault().send(str2, MessageToken.TOKEN_GO_CAMPAIGN);
                    if (str2 != null) {
                        if (str2.equals(ActivityType.SLOT_MACHINE) || str2.equals(ActivityType.LUCKY_2020)) {
                            ReportDataAdapter.onEvent(banner.getContext(), EventConstant.CLICK_WHEEL_BANNER);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (str.contains(":party")) {
                    Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_GO_PARTY);
                    return;
                } else if (str.contains(":recharge")) {
                    Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_JUMP_TO_ACTIVITY);
                    return;
                } else {
                    if (str.contains(":share")) {
                        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_GO_TO_SHARE);
                        return;
                    }
                    return;
                }
            }
            if (str.contains("jumpToAppointActivity")) {
                if (((BannerEntity) list2.get(i)).getVersion() == 0 || BaseApplication.getApp().getMetaDataAppVersion() < ((BannerEntity) list2.get(i)).getVersion()) {
                    return;
                }
                if (str.contains(":friendmatch")) {
                    Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_GO_FRIEND_MATCH);
                    return;
                } else {
                    if (str.contains(":videodetail")) {
                        t.b(banner.getContext(), ((BannerEntity) list2.get(i)).getVideoId());
                        return;
                    }
                    return;
                }
            }
            if (str.contains("notice")) {
                Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_GO_NOTICE);
                return;
            }
            if (str.contains("youtube") && CommonHelper.isAppInstalled(banner.getContext(), "com.google.android.youtube")) {
                try {
                    Intent intent3 = new Intent("android.intent.action.VIEW");
                    intent3.setData(Uri.parse(str));
                    intent3.setClassName("com.google.android.youtube", "com.google.android.youtube.UrlActivity");
                    banner.getContext().startActivity(intent3);
                    return;
                } catch (ActivityNotFoundException e3) {
                    e3.printStackTrace();
                    WebViewActivity.a(banner.getContext(), str, (String) list5.get(i));
                    return;
                }
            }
            WebViewActivity.a(banner.getContext(), str, (String) list5.get(i));
        }
    }

    private static List<String> a(List<BannerEntity> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<BannerEntity> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getTitle());
        }
        return arrayList;
    }
}
