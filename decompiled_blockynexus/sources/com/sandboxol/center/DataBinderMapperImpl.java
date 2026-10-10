package com.sandboxol.center;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.b;
import androidx.databinding.d;
import androidx.databinding.library.baseAdapters.a;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.places.model.PlaceFields;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.sandboxol.center.databinding.BaseContentScrapBagPageBindingImpl;
import com.sandboxol.center.databinding.BaseDialogActivityGuideBindingImpl;
import com.sandboxol.center.databinding.BaseDialogAdsGameRewardBindingImpl;
import com.sandboxol.center.databinding.BaseDialogAdsTurntableBindingImpl;
import com.sandboxol.center.databinding.BaseDialogAppCheckAppVersionBindingImpl;
import com.sandboxol.center.databinding.BaseDialogAppFiveStarsBindingImpl;
import com.sandboxol.center.databinding.BaseDialogAppLoadingBindingImpl;
import com.sandboxol.center.databinding.BaseDialogAppRechargeBindingImpl;
import com.sandboxol.center.databinding.BaseDialogCampaignGetIntegralRewardBindingImpl;
import com.sandboxol.center.databinding.BaseDialogCampaignOneBtnBindingImpl;
import com.sandboxol.center.databinding.BaseDialogCloseAppBindingImpl;
import com.sandboxol.center.databinding.BaseDialogNotWifiBindingImpl;
import com.sandboxol.center.databinding.BaseDialogOneButtonBindingImpl;
import com.sandboxol.center.databinding.BaseDialogPasswordSettingBindingImpl;
import com.sandboxol.center.databinding.BaseDialogPayGdiamondBindingImpl;
import com.sandboxol.center.databinding.BaseDialogScrapBagBindingImpl;
import com.sandboxol.center.databinding.BaseDialogScrapMakeSureBindingImpl;
import com.sandboxol.center.databinding.BaseDialogScrapRewardDescBindingLandImpl;
import com.sandboxol.center.databinding.BaseDialogScrapRewardDescBindingPortImpl;
import com.sandboxol.center.databinding.BaseDialogTeamInviteBindingImpl;
import com.sandboxol.center.databinding.BaseDialogTwoButtonBindingImpl;
import com.sandboxol.center.databinding.BaseDialogTwoTextviewButtonBindingImpl;
import com.sandboxol.center.databinding.BaseDialogVipGcubeGiftOneButtonBindingImpl;
import com.sandboxol.center.databinding.BaseItemAdsTurntableBindingImpl;
import com.sandboxol.center.databinding.BaseItemScrapBagBindingImpl;
import com.sandboxol.center.databinding.BaseItemTeamInviteBindingImpl;
import com.sandboxol.center.databinding.BaseLayoutCircleProgressBindingImpl;
import com.sandboxol.center.databinding.BaseLayoutCircleProgressOtherBindingImpl;
import com.sandboxol.center.databinding.BaseLayoutFloatCircleBindingImpl;
import com.sandboxol.center.databinding.BaseLayoutIvScrapLevelBindingImpl;
import com.sandboxol.center.databinding.BaseTeamInviteDataListViewBindingImpl;
import io.rong.imlib.common.RongLibConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DataBinderMapperImpl extends b {
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(30);
    private static final int LAYOUT_BASECONTENTSCRAPBAGPAGE = 1;
    private static final int LAYOUT_BASEDIALOGACTIVITYGUIDE = 2;
    private static final int LAYOUT_BASEDIALOGADSGAMEREWARD = 3;
    private static final int LAYOUT_BASEDIALOGADSTURNTABLE = 4;
    private static final int LAYOUT_BASEDIALOGAPPCHECKAPPVERSION = 5;
    private static final int LAYOUT_BASEDIALOGAPPFIVESTARS = 6;
    private static final int LAYOUT_BASEDIALOGAPPLOADING = 7;
    private static final int LAYOUT_BASEDIALOGAPPRECHARGE = 8;
    private static final int LAYOUT_BASEDIALOGCAMPAIGNGETINTEGRALREWARD = 9;
    private static final int LAYOUT_BASEDIALOGCAMPAIGNONEBTN = 10;
    private static final int LAYOUT_BASEDIALOGCLOSEAPP = 11;
    private static final int LAYOUT_BASEDIALOGNOTWIFI = 12;
    private static final int LAYOUT_BASEDIALOGONEBUTTON = 13;
    private static final int LAYOUT_BASEDIALOGPASSWORDSETTING = 14;
    private static final int LAYOUT_BASEDIALOGPAYGDIAMOND = 15;
    private static final int LAYOUT_BASEDIALOGSCRAPBAG = 16;
    private static final int LAYOUT_BASEDIALOGSCRAPMAKESURE = 17;
    private static final int LAYOUT_BASEDIALOGSCRAPREWARDDESC = 18;
    private static final int LAYOUT_BASEDIALOGTEAMINVITE = 19;
    private static final int LAYOUT_BASEDIALOGTWOBUTTON = 20;
    private static final int LAYOUT_BASEDIALOGTWOTEXTVIEWBUTTON = 21;
    private static final int LAYOUT_BASEDIALOGVIPGCUBEGIFTONEBUTTON = 22;
    private static final int LAYOUT_BASEITEMADSTURNTABLE = 23;
    private static final int LAYOUT_BASEITEMSCRAPBAG = 24;
    private static final int LAYOUT_BASEITEMTEAMINVITE = 25;
    private static final int LAYOUT_BASELAYOUTCIRCLEPROGRESS = 26;
    private static final int LAYOUT_BASELAYOUTCIRCLEPROGRESSOTHER = 27;
    private static final int LAYOUT_BASELAYOUTFLOATCIRCLE = 28;
    private static final int LAYOUT_BASELAYOUTIVSCRAPLEVEL = 29;
    private static final int LAYOUT_BASETEAMINVITEDATALISTVIEW = 30;

    private static class InnerBrLookup {
        static final SparseArray<String> sKeys = new SparseArray<>(134);

        static {
            sKeys.put(0, "_all");
            sKeys.put(1, "videoId");
            sKeys.put(2, "gameTitle");
            sKeys.put(3, "dislikeNumber");
            sKeys.put(4, "featuredPlay");
            sKeys.put(5, "title");
            sKeys.put(6, "evaluateStatus");
            sKeys.put(7, "videoUrl");
            sKeys.put(8, "bannerPic");
            sKeys.put(9, "youtubeUrl");
            sKeys.put(10, "alias");
            sKeys.put(11, "videoTime");
            sKeys.put(12, "tag");
            sKeys.put(13, "gameDetail");
            sKeys.put(14, "gameId");
            sKeys.put(15, "images");
            sKeys.put(16, "nickName");
            sKeys.put(17, "authorInfo");
            sKeys.put(18, "authorId");
            sKeys.put(19, "isPublish");
            sKeys.put(20, "tagName");
            sKeys.put(21, "gameCoverPic");
            sKeys.put(22, "playAmount");
            sKeys.put(23, "videoPic");
            sKeys.put(24, "authorName");
            sKeys.put(25, "authorPicUrl");
            sKeys.put(26, "likeNumber");
            sKeys.put(27, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
            sKeys.put(28, "showEmptyView");
            sKeys.put(29, "item");
            sKeys.put(30, "refreshing");
            sKeys.put(31, "emptyText");
            sKeys.put(32, "viewModel");
            sKeys.put(33, "ViewModel");
            sKeys.put(34, "loadingMore");
            sKeys.put(35, "tribeLevel");
            sKeys.put(36, "appVersion");
            sKeys.put(37, "resourceId");
            sKeys.put(38, "remainingDays");
            sKeys.put(39, "PasswordSettingDialog");
            sKeys.put(40, "seconds");
            sKeys.put(41, "gameName");
            sKeys.put(42, "activityFlag");
            sKeys.put(43, "captainName");
            sKeys.put(44, "price");
            sKeys.put(45, "currentCount");
            sKeys.put(46, "passwordSettingDialog");
            sKeys.put(47, "AdsTurntableDialog");
            sKeys.put(48, "id");
            sKeys.put(49, "vip");
            sKeys.put(50, "tasks");
            sKeys.put(51, "campaignGetIntegralRewardDialog");
            sKeys.put(52, "tribeGolds");
            sKeys.put(53, "expire");
            sKeys.put(54, "TeamInviteDialog");
            sKeys.put(55, "typeId");
            sKeys.put(56, "tribeClanId");
            sKeys.put(57, "teamCount");
            sKeys.put(58, "hasLocalRes");
            sKeys.put(59, "vipGcubeGiftOneButtonDialog");
            sKeys.put(60, "isCreate");
            sKeys.put(61, "currency");
            sKeys.put(62, "isActivity");
            sKeys.put(63, "buySuccess");
            sKeys.put(64, "campaignOneButtonDialog");
            sKeys.put(65, "tribeRole");
            sKeys.put(66, "memberCount");
            sKeys.put(67, "sex");
            sKeys.put(68, "psid");
            sKeys.put(69, "userId");
            sKeys.put(70, "url");
            sKeys.put(71, RongLibConst.KEY_TOKEN);
            sKeys.put(72, "gamePic");
            sKeys.put(73, "CampaignGetIntegralRewardDialog");
            sKeys.put(74, "isUgc");
            sKeys.put(75, "tribeName");
            sKeys.put(76, "blankType");
            sKeys.put(77, "country");
            sKeys.put(78, "isRecommend");
            sKeys.put(79, "isNewEngine");
            sKeys.put(80, "hasPurchase");
            sKeys.put(81, "experience");
            sKeys.put(82, "tribeHead");
            sKeys.put(83, "CampaignOneButtonDialog");
            sKeys.put(84, "picUrl");
            sKeys.put(85, "maxMember");
            sKeys.put(86, "suitPrice");
            sKeys.put(87, "details");
            sKeys.put(88, "organizeTeamUrl");
            sKeys.put(89, "iconUrl");
            sKeys.put(90, "verification");
            sKeys.put(91, "scrapMakeSureDialog");
            sKeys.put(92, "teamInviteDialog");
            sKeys.put(93, "captainId");
            sKeys.put(94, "limitedTimes");
            sKeys.put(95, "minutes");
            sKeys.put(96, "CheckAppVersionDialogViewModel");
            sKeys.put(97, "count");
            sKeys.put(98, "messageId");
            sKeys.put(99, "roomName");
            sKeys.put(100, "signInStatus");
            sKeys.put(101, "checkAppVersionDialogViewModel");
            sKeys.put(102, "AdsGameRewardDialog");
            sKeys.put(103, "scrapNum");
            sKeys.put(104, "name");
            sKeys.put(105, "teamType");
            sKeys.put(106, "adsGameRewardDialog");
            sKeys.put(107, "gameType");
            sKeys.put(108, "itemType");
            sKeys.put(109, "releaseTime");
            sKeys.put(110, "show");
            sKeys.put(111, "taskMap");
            sKeys.put(112, "dispUrl");
            sKeys.put(113, "ScrapMakeSureDialog");
            sKeys.put(114, "pmId");
            sKeys.put(115, "maxCount");
            sKeys.put(116, "decorationInfoList");
            sKeys.put(117, "ScrapBagPageViewModel");
            sKeys.put(118, "scrapBagPageViewModel");
            sKeys.put(119, "suitId");
            sKeys.put(120, "chatRoomId");
            sKeys.put(121, "packageName");
            sKeys.put(122, PlaceFields.HOURS);
            sKeys.put(123, FirebaseAnalytics.Param.QUANTITY);
            sKeys.put(124, "adsTurntableDialog");
            sKeys.put(125, "enterType");
            sKeys.put(126, "isNew");
            sKeys.put(127, "occupyPosition");
            sKeys.put(128, "VipGcubeGiftOneButtonDialog");
            sKeys.put(129, "regionId");
            sKeys.put(130, "teamId");
            sKeys.put(131, "payChannel");
            sKeys.put(132, "orderField");
        }

        private InnerBrLookup() {
        }
    }

    private static class InnerLayoutIdLookup {
        static final HashMap<String, Integer> sKeys = new HashMap<>(31);

        static {
            sKeys.put("layout/base_content_scrap_bag_page_0", Integer.valueOf(R.layout.base_content_scrap_bag_page));
            sKeys.put("layout/base_dialog_activity_guide_0", Integer.valueOf(R.layout.base_dialog_activity_guide));
            sKeys.put("layout/base_dialog_ads_game_reward_0", Integer.valueOf(R.layout.base_dialog_ads_game_reward));
            sKeys.put("layout/base_dialog_ads_turntable_0", Integer.valueOf(R.layout.base_dialog_ads_turntable));
            sKeys.put("layout/base_dialog_app_check_app_version_0", Integer.valueOf(R.layout.base_dialog_app_check_app_version));
            sKeys.put("layout/base_dialog_app_five_stars_0", Integer.valueOf(R.layout.base_dialog_app_five_stars));
            sKeys.put("layout/base_dialog_app_loading_0", Integer.valueOf(R.layout.base_dialog_app_loading));
            sKeys.put("layout/base_dialog_app_recharge_0", Integer.valueOf(R.layout.base_dialog_app_recharge));
            sKeys.put("layout/base_dialog_campaign_get_integral_reward_0", Integer.valueOf(R.layout.base_dialog_campaign_get_integral_reward));
            sKeys.put("layout/base_dialog_campaign_one_btn_0", Integer.valueOf(R.layout.base_dialog_campaign_one_btn));
            sKeys.put("layout/base_dialog_close_app_0", Integer.valueOf(R.layout.base_dialog_close_app));
            sKeys.put("layout/base_dialog_not_wifi_0", Integer.valueOf(R.layout.base_dialog_not_wifi));
            sKeys.put("layout/base_dialog_one_button_0", Integer.valueOf(R.layout.base_dialog_one_button));
            sKeys.put("layout/base_dialog_password_setting_0", Integer.valueOf(R.layout.base_dialog_password_setting));
            sKeys.put("layout/base_dialog_pay_gdiamond_0", Integer.valueOf(R.layout.base_dialog_pay_gdiamond));
            sKeys.put("layout/base_dialog_scrap_bag_0", Integer.valueOf(R.layout.base_dialog_scrap_bag));
            sKeys.put("layout/base_dialog_scrap_make_sure_0", Integer.valueOf(R.layout.base_dialog_scrap_make_sure));
            sKeys.put("layout-port/base_dialog_scrap_reward_desc_0", Integer.valueOf(R.layout.base_dialog_scrap_reward_desc));
            sKeys.put("layout-land/base_dialog_scrap_reward_desc_0", Integer.valueOf(R.layout.base_dialog_scrap_reward_desc));
            sKeys.put("layout/base_dialog_team_invite_0", Integer.valueOf(R.layout.base_dialog_team_invite));
            sKeys.put("layout/base_dialog_two_button_0", Integer.valueOf(R.layout.base_dialog_two_button));
            sKeys.put("layout/base_dialog_two_textview_button_0", Integer.valueOf(R.layout.base_dialog_two_textview_button));
            sKeys.put("layout/base_dialog_vip_gcube_gift_one_button_0", Integer.valueOf(R.layout.base_dialog_vip_gcube_gift_one_button));
            sKeys.put("layout/base_item_ads_turntable_0", Integer.valueOf(R.layout.base_item_ads_turntable));
            sKeys.put("layout/base_item_scrap_bag_0", Integer.valueOf(R.layout.base_item_scrap_bag));
            sKeys.put("layout/base_item_team_invite_0", Integer.valueOf(R.layout.base_item_team_invite));
            sKeys.put("layout/base_layout_circle_progress_0", Integer.valueOf(R.layout.base_layout_circle_progress));
            sKeys.put("layout/base_layout_circle_progress_other_0", Integer.valueOf(R.layout.base_layout_circle_progress_other));
            sKeys.put("layout/base_layout_float_circle_0", Integer.valueOf(R.layout.base_layout_float_circle));
            sKeys.put("layout/base_layout_iv_scrap_level_0", Integer.valueOf(R.layout.base_layout_iv_scrap_level));
            sKeys.put("layout/base_team_invite_data_list_view_0", Integer.valueOf(R.layout.base_team_invite_data_list_view));
        }

        private InnerLayoutIdLookup() {
        }
    }

    static {
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.base_content_scrap_bag_page, 1);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.base_dialog_activity_guide, 2);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.base_dialog_ads_game_reward, 3);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.base_dialog_ads_turntable, 4);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.base_dialog_app_check_app_version, 5);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.base_dialog_app_five_stars, 6);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.base_dialog_app_loading, 7);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.base_dialog_app_recharge, 8);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.base_dialog_campaign_get_integral_reward, 9);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.base_dialog_campaign_one_btn, 10);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.base_dialog_close_app, 11);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.base_dialog_not_wifi, 12);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.base_dialog_one_button, 13);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.base_dialog_password_setting, 14);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.base_dialog_pay_gdiamond, 15);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.base_dialog_scrap_bag, 16);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.base_dialog_scrap_make_sure, 17);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.base_dialog_scrap_reward_desc, 18);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.base_dialog_team_invite, 19);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.base_dialog_two_button, 20);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.base_dialog_two_textview_button, 21);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.base_dialog_vip_gcube_gift_one_button, 22);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.base_item_ads_turntable, 23);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.base_item_scrap_bag, 24);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.base_item_team_invite, 25);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.base_layout_circle_progress, 26);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.base_layout_circle_progress_other, 27);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.base_layout_float_circle, 28);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.base_layout_iv_scrap_level, 29);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.base_team_invite_data_list_view, 30);
    }

    @Override // androidx.databinding.b
    public List<b> collectDependencies() {
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(new a());
        arrayList.add(new com.sandboxol.common.DataBinderMapperImpl());
        arrayList.add(new com.sandboxol.greendao.b());
        arrayList.add(new com.sandboxol.messager.a());
        return arrayList;
    }

    @Override // androidx.databinding.b
    public String convertBrIdToString(int i) {
        return InnerBrLookup.sKeys.get(i);
    }

    @Override // androidx.databinding.b
    public ViewDataBinding getDataBinder(d dVar, View view, int i) {
        int i2 = INTERNAL_LAYOUT_ID_LOOKUP.get(i);
        if (i2 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        }
        switch (i2) {
            case 1:
                if ("layout/base_content_scrap_bag_page_0".equals(tag)) {
                    return new BaseContentScrapBagPageBindingImpl(dVar, view);
                }
                throw new IllegalArgumentException("The tag for base_content_scrap_bag_page is invalid. Received: " + tag);
            case 2:
                if ("layout/base_dialog_activity_guide_0".equals(tag)) {
                    return new BaseDialogActivityGuideBindingImpl(dVar, view);
                }
                throw new IllegalArgumentException("The tag for base_dialog_activity_guide is invalid. Received: " + tag);
            case 3:
                if ("layout/base_dialog_ads_game_reward_0".equals(tag)) {
                    return new BaseDialogAdsGameRewardBindingImpl(dVar, view);
                }
                throw new IllegalArgumentException("The tag for base_dialog_ads_game_reward is invalid. Received: " + tag);
            case 4:
                if ("layout/base_dialog_ads_turntable_0".equals(tag)) {
                    return new BaseDialogAdsTurntableBindingImpl(dVar, view);
                }
                throw new IllegalArgumentException("The tag for base_dialog_ads_turntable is invalid. Received: " + tag);
            case 5:
                if ("layout/base_dialog_app_check_app_version_0".equals(tag)) {
                    return new BaseDialogAppCheckAppVersionBindingImpl(dVar, view);
                }
                throw new IllegalArgumentException("The tag for base_dialog_app_check_app_version is invalid. Received: " + tag);
            case 6:
                if ("layout/base_dialog_app_five_stars_0".equals(tag)) {
                    return new BaseDialogAppFiveStarsBindingImpl(dVar, view);
                }
                throw new IllegalArgumentException("The tag for base_dialog_app_five_stars is invalid. Received: " + tag);
            case 7:
                if ("layout/base_dialog_app_loading_0".equals(tag)) {
                    return new BaseDialogAppLoadingBindingImpl(dVar, view);
                }
                throw new IllegalArgumentException("The tag for base_dialog_app_loading is invalid. Received: " + tag);
            case 8:
                if ("layout/base_dialog_app_recharge_0".equals(tag)) {
                    return new BaseDialogAppRechargeBindingImpl(dVar, view);
                }
                throw new IllegalArgumentException("The tag for base_dialog_app_recharge is invalid. Received: " + tag);
            case 9:
                if ("layout/base_dialog_campaign_get_integral_reward_0".equals(tag)) {
                    return new BaseDialogCampaignGetIntegralRewardBindingImpl(dVar, view);
                }
                throw new IllegalArgumentException("The tag for base_dialog_campaign_get_integral_reward is invalid. Received: " + tag);
            case 10:
                if ("layout/base_dialog_campaign_one_btn_0".equals(tag)) {
                    return new BaseDialogCampaignOneBtnBindingImpl(dVar, view);
                }
                throw new IllegalArgumentException("The tag for base_dialog_campaign_one_btn is invalid. Received: " + tag);
            case 11:
                if ("layout/base_dialog_close_app_0".equals(tag)) {
                    return new BaseDialogCloseAppBindingImpl(dVar, view);
                }
                throw new IllegalArgumentException("The tag for base_dialog_close_app is invalid. Received: " + tag);
            case 12:
                if ("layout/base_dialog_not_wifi_0".equals(tag)) {
                    return new BaseDialogNotWifiBindingImpl(dVar, view);
                }
                throw new IllegalArgumentException("The tag for base_dialog_not_wifi is invalid. Received: " + tag);
            case 13:
                if ("layout/base_dialog_one_button_0".equals(tag)) {
                    return new BaseDialogOneButtonBindingImpl(dVar, view);
                }
                throw new IllegalArgumentException("The tag for base_dialog_one_button is invalid. Received: " + tag);
            case 14:
                if ("layout/base_dialog_password_setting_0".equals(tag)) {
                    return new BaseDialogPasswordSettingBindingImpl(dVar, view);
                }
                throw new IllegalArgumentException("The tag for base_dialog_password_setting is invalid. Received: " + tag);
            case 15:
                if ("layout/base_dialog_pay_gdiamond_0".equals(tag)) {
                    return new BaseDialogPayGdiamondBindingImpl(dVar, view);
                }
                throw new IllegalArgumentException("The tag for base_dialog_pay_gdiamond is invalid. Received: " + tag);
            case 16:
                if ("layout/base_dialog_scrap_bag_0".equals(tag)) {
                    return new BaseDialogScrapBagBindingImpl(dVar, view);
                }
                throw new IllegalArgumentException("The tag for base_dialog_scrap_bag is invalid. Received: " + tag);
            case 17:
                if ("layout/base_dialog_scrap_make_sure_0".equals(tag)) {
                    return new BaseDialogScrapMakeSureBindingImpl(dVar, view);
                }
                throw new IllegalArgumentException("The tag for base_dialog_scrap_make_sure is invalid. Received: " + tag);
            case 18:
                if ("layout-port/base_dialog_scrap_reward_desc_0".equals(tag)) {
                    return new BaseDialogScrapRewardDescBindingPortImpl(dVar, view);
                }
                if ("layout-land/base_dialog_scrap_reward_desc_0".equals(tag)) {
                    return new BaseDialogScrapRewardDescBindingLandImpl(dVar, view);
                }
                throw new IllegalArgumentException("The tag for base_dialog_scrap_reward_desc is invalid. Received: " + tag);
            case 19:
                if ("layout/base_dialog_team_invite_0".equals(tag)) {
                    return new BaseDialogTeamInviteBindingImpl(dVar, view);
                }
                throw new IllegalArgumentException("The tag for base_dialog_team_invite is invalid. Received: " + tag);
            case 20:
                if ("layout/base_dialog_two_button_0".equals(tag)) {
                    return new BaseDialogTwoButtonBindingImpl(dVar, view);
                }
                throw new IllegalArgumentException("The tag for base_dialog_two_button is invalid. Received: " + tag);
            case 21:
                if ("layout/base_dialog_two_textview_button_0".equals(tag)) {
                    return new BaseDialogTwoTextviewButtonBindingImpl(dVar, view);
                }
                throw new IllegalArgumentException("The tag for base_dialog_two_textview_button is invalid. Received: " + tag);
            case 22:
                if ("layout/base_dialog_vip_gcube_gift_one_button_0".equals(tag)) {
                    return new BaseDialogVipGcubeGiftOneButtonBindingImpl(dVar, view);
                }
                throw new IllegalArgumentException("The tag for base_dialog_vip_gcube_gift_one_button is invalid. Received: " + tag);
            case 23:
                if ("layout/base_item_ads_turntable_0".equals(tag)) {
                    return new BaseItemAdsTurntableBindingImpl(dVar, view);
                }
                throw new IllegalArgumentException("The tag for base_item_ads_turntable is invalid. Received: " + tag);
            case 24:
                if ("layout/base_item_scrap_bag_0".equals(tag)) {
                    return new BaseItemScrapBagBindingImpl(dVar, view);
                }
                throw new IllegalArgumentException("The tag for base_item_scrap_bag is invalid. Received: " + tag);
            case 25:
                if ("layout/base_item_team_invite_0".equals(tag)) {
                    return new BaseItemTeamInviteBindingImpl(dVar, view);
                }
                throw new IllegalArgumentException("The tag for base_item_team_invite is invalid. Received: " + tag);
            case 26:
                if ("layout/base_layout_circle_progress_0".equals(tag)) {
                    return new BaseLayoutCircleProgressBindingImpl(dVar, view);
                }
                throw new IllegalArgumentException("The tag for base_layout_circle_progress is invalid. Received: " + tag);
            case 27:
                if ("layout/base_layout_circle_progress_other_0".equals(tag)) {
                    return new BaseLayoutCircleProgressOtherBindingImpl(dVar, view);
                }
                throw new IllegalArgumentException("The tag for base_layout_circle_progress_other is invalid. Received: " + tag);
            case 28:
                if ("layout/base_layout_float_circle_0".equals(tag)) {
                    return new BaseLayoutFloatCircleBindingImpl(dVar, view);
                }
                throw new IllegalArgumentException("The tag for base_layout_float_circle is invalid. Received: " + tag);
            case 29:
                if ("layout/base_layout_iv_scrap_level_0".equals(tag)) {
                    return new BaseLayoutIvScrapLevelBindingImpl(dVar, view);
                }
                throw new IllegalArgumentException("The tag for base_layout_iv_scrap_level is invalid. Received: " + tag);
            case 30:
                if ("layout/base_team_invite_data_list_view_0".equals(tag)) {
                    return new BaseTeamInviteDataListViewBindingImpl(dVar, view);
                }
                throw new IllegalArgumentException("The tag for base_team_invite_data_list_view is invalid. Received: " + tag);
            default:
                return null;
        }
    }

    @Override // androidx.databinding.b
    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = InnerLayoutIdLookup.sKeys.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.databinding.b
    public ViewDataBinding getDataBinder(d dVar, View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || INTERNAL_LAYOUT_ID_LOOKUP.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
