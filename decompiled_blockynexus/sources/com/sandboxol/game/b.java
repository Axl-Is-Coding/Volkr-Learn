package com.sandboxol.game;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.d;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.places.model.PlaceFields;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.sandboxol.center.DataBinderMapperImpl;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.game.a.B;
import com.sandboxol.game.a.C2663b;
import com.sandboxol.game.a.C2665d;
import com.sandboxol.game.a.C2667f;
import com.sandboxol.game.a.C2669h;
import com.sandboxol.game.a.C2671j;
import com.sandboxol.game.a.D;
import com.sandboxol.game.a.F;
import com.sandboxol.game.a.H;
import com.sandboxol.game.a.J;
import com.sandboxol.game.a.l;
import com.sandboxol.game.a.n;
import com.sandboxol.game.a.p;
import com.sandboxol.game.a.r;
import com.sandboxol.game.a.t;
import com.sandboxol.game.a.v;
import com.sandboxol.game.a.x;
import com.sandboxol.game.a.z;
import io.rong.imlib.common.RongLibConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: DataBinderMapperImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class b extends androidx.databinding.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SparseIntArray f17738a = new SparseIntArray(18);

    /* JADX INFO: compiled from: DataBinderMapperImpl.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final SparseArray<String> f17739a = new SparseArray<>(154);

        static {
            f17739a.put(0, "_all");
            f17739a.put(1, "videoId");
            f17739a.put(2, "gameTitle");
            f17739a.put(3, "dislikeNumber");
            f17739a.put(4, "featuredPlay");
            f17739a.put(5, "title");
            f17739a.put(6, "evaluateStatus");
            f17739a.put(7, "videoUrl");
            f17739a.put(8, "bannerPic");
            f17739a.put(9, "youtubeUrl");
            f17739a.put(10, "alias");
            f17739a.put(11, "videoTime");
            f17739a.put(12, "tag");
            f17739a.put(13, "gameDetail");
            f17739a.put(14, "gameId");
            f17739a.put(15, "images");
            f17739a.put(16, "nickName");
            f17739a.put(17, "authorInfo");
            f17739a.put(18, "authorId");
            f17739a.put(19, "isPublish");
            f17739a.put(20, "tagName");
            f17739a.put(21, "gameCoverPic");
            f17739a.put(22, "playAmount");
            f17739a.put(23, "videoPic");
            f17739a.put(24, "authorName");
            f17739a.put(25, "authorPicUrl");
            f17739a.put(26, "likeNumber");
            f17739a.put(27, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
            f17739a.put(28, "tribeLevel");
            f17739a.put(29, "appVersion");
            f17739a.put(30, "resourceId");
            f17739a.put(31, "remainingDays");
            f17739a.put(32, "PasswordSettingDialog");
            f17739a.put(33, "seconds");
            f17739a.put(34, "gameName");
            f17739a.put(35, "activityFlag");
            f17739a.put(36, "captainName");
            f17739a.put(37, "price");
            f17739a.put(38, "currentCount");
            f17739a.put(39, "passwordSettingDialog");
            f17739a.put(40, "AdsTurntableDialog");
            f17739a.put(41, "id");
            f17739a.put(42, "vip");
            f17739a.put(43, "tasks");
            f17739a.put(44, "campaignGetIntegralRewardDialog");
            f17739a.put(45, "tribeGolds");
            f17739a.put(46, "expire");
            f17739a.put(47, "TeamInviteDialog");
            f17739a.put(48, "typeId");
            f17739a.put(49, "tribeClanId");
            f17739a.put(50, "teamCount");
            f17739a.put(51, "hasLocalRes");
            f17739a.put(52, "vipGcubeGiftOneButtonDialog");
            f17739a.put(53, "isCreate");
            f17739a.put(54, "currency");
            f17739a.put(55, "isActivity");
            f17739a.put(56, "buySuccess");
            f17739a.put(57, "campaignOneButtonDialog");
            f17739a.put(58, "tribeRole");
            f17739a.put(59, "memberCount");
            f17739a.put(60, "sex");
            f17739a.put(61, "psid");
            f17739a.put(62, "userId");
            f17739a.put(63, "url");
            f17739a.put(64, RongLibConst.KEY_TOKEN);
            f17739a.put(65, "gamePic");
            f17739a.put(66, "CampaignGetIntegralRewardDialog");
            f17739a.put(67, "isUgc");
            f17739a.put(68, "tribeName");
            f17739a.put(69, "blankType");
            f17739a.put(70, "country");
            f17739a.put(71, "isRecommend");
            f17739a.put(72, "isNewEngine");
            f17739a.put(73, "hasPurchase");
            f17739a.put(74, "experience");
            f17739a.put(75, "tribeHead");
            f17739a.put(76, "CampaignOneButtonDialog");
            f17739a.put(77, "picUrl");
            f17739a.put(78, "maxMember");
            f17739a.put(79, "suitPrice");
            f17739a.put(80, "details");
            f17739a.put(81, "organizeTeamUrl");
            f17739a.put(82, "iconUrl");
            f17739a.put(83, "verification");
            f17739a.put(84, "scrapMakeSureDialog");
            f17739a.put(85, "teamInviteDialog");
            f17739a.put(86, "captainId");
            f17739a.put(87, "limitedTimes");
            f17739a.put(88, "minutes");
            f17739a.put(89, "CheckAppVersionDialogViewModel");
            f17739a.put(90, "count");
            f17739a.put(91, "messageId");
            f17739a.put(92, "roomName");
            f17739a.put(93, "signInStatus");
            f17739a.put(94, "checkAppVersionDialogViewModel");
            f17739a.put(95, "AdsGameRewardDialog");
            f17739a.put(96, "scrapNum");
            f17739a.put(97, "name");
            f17739a.put(98, "viewModel");
            f17739a.put(99, "teamType");
            f17739a.put(100, "adsGameRewardDialog");
            f17739a.put(101, "gameType");
            f17739a.put(102, "itemType");
            f17739a.put(103, "releaseTime");
            f17739a.put(104, "show");
            f17739a.put(105, "taskMap");
            f17739a.put(106, "dispUrl");
            f17739a.put(107, "ScrapMakeSureDialog");
            f17739a.put(108, "ViewModel");
            f17739a.put(109, "pmId");
            f17739a.put(110, "maxCount");
            f17739a.put(111, "decorationInfoList");
            f17739a.put(112, "ScrapBagPageViewModel");
            f17739a.put(113, "scrapBagPageViewModel");
            f17739a.put(114, "suitId");
            f17739a.put(115, "chatRoomId");
            f17739a.put(116, "packageName");
            f17739a.put(117, PlaceFields.HOURS);
            f17739a.put(118, FirebaseAnalytics.Param.QUANTITY);
            f17739a.put(119, "adsTurntableDialog");
            f17739a.put(120, "enterType");
            f17739a.put(121, "isNew");
            f17739a.put(122, "occupyPosition");
            f17739a.put(123, "VipGcubeGiftOneButtonDialog");
            f17739a.put(124, "regionId");
            f17739a.put(125, "teamId");
            f17739a.put(126, "payChannel");
            f17739a.put(127, "orderField");
            f17739a.put(128, "showEmptyView");
            f17739a.put(129, "item");
            f17739a.put(130, "refreshing");
            f17739a.put(131, "emptyText");
            f17739a.put(132, "loadingMore");
            f17739a.put(133, "StarCodeHelpPopupWindow");
            f17739a.put(134, "scrapBoxDialog");
            f17739a.put(135, "scrapReceivedAnimDialog");
            f17739a.put(136, "rechargeDialog");
            f17739a.put(137, "praiseNumber");
            f17739a.put(138, "RechargeTipDialog");
            f17739a.put(139, "scrapListDialog");
            f17739a.put(140, StringConstant.GAME_ORDER_TYPE_APPRECIATE);
            f17739a.put(141, "webVideoViewModel");
            f17739a.put(142, "shareDialog");
            f17739a.put(143, "RechargeDetailDialog");
            f17739a.put(144, "ScrapListDialog");
            f17739a.put(145, "ShareDialog");
            f17739a.put(146, "ScrapBoxDialog");
            f17739a.put(147, "starCodeHelpPopupWindow");
            f17739a.put(148, "rechargeTipDialog");
            f17739a.put(149, "WebVideoViewModel");
            f17739a.put(150, "rechargeDetailDialog");
            f17739a.put(151, "ScrapReceivedAnimDialog");
            f17739a.put(152, "RechargeDialog");
        }
    }

    /* JADX INFO: renamed from: com.sandboxol.game.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DataBinderMapperImpl.java */
    private static class C0148b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final HashMap<String, Integer> f17740a = new HashMap<>(18);

        static {
            f17740a.put("layout/activity_start_mc_0", Integer.valueOf(R.layout.activity_start_mc));
            f17740a.put("layout/activity_web_video_0", Integer.valueOf(R.layout.activity_web_video));
            f17740a.put("layout/dialog_campaign_get_integral_reward_0", Integer.valueOf(R.layout.dialog_campaign_get_integral_reward));
            f17740a.put("layout/dialog_recharge_detail_0", Integer.valueOf(R.layout.dialog_recharge_detail));
            f17740a.put("layout/dialog_recharge_shop_0", Integer.valueOf(R.layout.dialog_recharge_shop));
            f17740a.put("layout/dialog_recharge_star_code_view_0", Integer.valueOf(R.layout.dialog_recharge_star_code_view));
            f17740a.put("layout/dialog_recharge_tip_0", Integer.valueOf(R.layout.dialog_recharge_tip));
            f17740a.put("layout/dialog_scrap_anim_0", Integer.valueOf(R.layout.dialog_scrap_anim));
            f17740a.put("layout/dialog_scrap_anim_list_view_0", Integer.valueOf(R.layout.dialog_scrap_anim_list_view));
            f17740a.put("layout/dialog_scrap_box_0", Integer.valueOf(R.layout.dialog_scrap_box));
            f17740a.put("layout/dialog_scrap_box_weekend_0", Integer.valueOf(R.layout.dialog_scrap_box_weekend));
            f17740a.put("layout/dialog_scrap_list_0", Integer.valueOf(R.layout.dialog_scrap_list));
            f17740a.put("layout/dialog_screenshot_share_0", Integer.valueOf(R.layout.dialog_screenshot_share));
            f17740a.put("layout/dialog_screenshot_share_for_bed_war_0", Integer.valueOf(R.layout.dialog_screenshot_share_for_bed_war));
            f17740a.put("layout/game_popwindow_star_code_help_0", Integer.valueOf(R.layout.game_popwindow_star_code_help));
            f17740a.put("layout/item_recharge_shop_0", Integer.valueOf(R.layout.item_recharge_shop));
            f17740a.put("layout/item_scrap_anim_0", Integer.valueOf(R.layout.item_scrap_anim));
            f17740a.put("layout/item_scrap_list_0", Integer.valueOf(R.layout.item_scrap_list));
        }
    }

    static {
        f17738a.put(R.layout.activity_start_mc, 1);
        f17738a.put(R.layout.activity_web_video, 2);
        f17738a.put(R.layout.dialog_campaign_get_integral_reward, 3);
        f17738a.put(R.layout.dialog_recharge_detail, 4);
        f17738a.put(R.layout.dialog_recharge_shop, 5);
        f17738a.put(R.layout.dialog_recharge_star_code_view, 6);
        f17738a.put(R.layout.dialog_recharge_tip, 7);
        f17738a.put(R.layout.dialog_scrap_anim, 8);
        f17738a.put(R.layout.dialog_scrap_anim_list_view, 9);
        f17738a.put(R.layout.dialog_scrap_box, 10);
        f17738a.put(R.layout.dialog_scrap_box_weekend, 11);
        f17738a.put(R.layout.dialog_scrap_list, 12);
        f17738a.put(R.layout.dialog_screenshot_share, 13);
        f17738a.put(R.layout.dialog_screenshot_share_for_bed_war, 14);
        f17738a.put(R.layout.game_popwindow_star_code_help, 15);
        f17738a.put(R.layout.item_recharge_shop, 16);
        f17738a.put(R.layout.item_scrap_anim, 17);
        f17738a.put(R.layout.item_scrap_list, 18);
    }

    @Override // androidx.databinding.b
    public List<androidx.databinding.b> collectDependencies() {
        ArrayList arrayList = new ArrayList(5);
        arrayList.add(new androidx.databinding.library.baseAdapters.a());
        arrayList.add(new DataBinderMapperImpl());
        arrayList.add(new com.sandboxol.common.DataBinderMapperImpl());
        arrayList.add(new com.sandboxol.greendao.b());
        arrayList.add(new com.sandboxol.messager.a());
        return arrayList;
    }

    @Override // androidx.databinding.b
    public String convertBrIdToString(int i) {
        return a.f17739a.get(i);
    }

    @Override // androidx.databinding.b
    public ViewDataBinding getDataBinder(d dVar, View view, int i) {
        int i2 = f17738a.get(i);
        if (i2 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        }
        switch (i2) {
            case 1:
                if ("layout/activity_start_mc_0".equals(tag)) {
                    return new C2663b(dVar, view);
                }
                throw new IllegalArgumentException("The tag for activity_start_mc is invalid. Received: " + tag);
            case 2:
                if ("layout/activity_web_video_0".equals(tag)) {
                    return new C2665d(dVar, view);
                }
                throw new IllegalArgumentException("The tag for activity_web_video is invalid. Received: " + tag);
            case 3:
                if ("layout/dialog_campaign_get_integral_reward_0".equals(tag)) {
                    return new C2667f(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_campaign_get_integral_reward is invalid. Received: " + tag);
            case 4:
                if ("layout/dialog_recharge_detail_0".equals(tag)) {
                    return new C2669h(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_recharge_detail is invalid. Received: " + tag);
            case 5:
                if ("layout/dialog_recharge_shop_0".equals(tag)) {
                    return new C2671j(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_recharge_shop is invalid. Received: " + tag);
            case 6:
                if ("layout/dialog_recharge_star_code_view_0".equals(tag)) {
                    return new l(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_recharge_star_code_view is invalid. Received: " + tag);
            case 7:
                if ("layout/dialog_recharge_tip_0".equals(tag)) {
                    return new n(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_recharge_tip is invalid. Received: " + tag);
            case 8:
                if ("layout/dialog_scrap_anim_0".equals(tag)) {
                    return new p(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_scrap_anim is invalid. Received: " + tag);
            case 9:
                if ("layout/dialog_scrap_anim_list_view_0".equals(tag)) {
                    return new r(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_scrap_anim_list_view is invalid. Received: " + tag);
            case 10:
                if ("layout/dialog_scrap_box_0".equals(tag)) {
                    return new t(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_scrap_box is invalid. Received: " + tag);
            case 11:
                if ("layout/dialog_scrap_box_weekend_0".equals(tag)) {
                    return new v(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_scrap_box_weekend is invalid. Received: " + tag);
            case 12:
                if ("layout/dialog_scrap_list_0".equals(tag)) {
                    return new x(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_scrap_list is invalid. Received: " + tag);
            case 13:
                if ("layout/dialog_screenshot_share_0".equals(tag)) {
                    return new z(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_screenshot_share is invalid. Received: " + tag);
            case 14:
                if ("layout/dialog_screenshot_share_for_bed_war_0".equals(tag)) {
                    return new B(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_screenshot_share_for_bed_war is invalid. Received: " + tag);
            case 15:
                if ("layout/game_popwindow_star_code_help_0".equals(tag)) {
                    return new D(dVar, view);
                }
                throw new IllegalArgumentException("The tag for game_popwindow_star_code_help is invalid. Received: " + tag);
            case 16:
                if ("layout/item_recharge_shop_0".equals(tag)) {
                    return new F(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_recharge_shop is invalid. Received: " + tag);
            case 17:
                if ("layout/item_scrap_anim_0".equals(tag)) {
                    return new H(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_scrap_anim is invalid. Received: " + tag);
            case 18:
                if ("layout/item_scrap_list_0".equals(tag)) {
                    return new J(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_scrap_list is invalid. Received: " + tag);
            default:
                return null;
        }
    }

    @Override // androidx.databinding.b
    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = C0148b.f17740a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.databinding.b
    public ViewDataBinding getDataBinder(d dVar, View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || f17738a.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
