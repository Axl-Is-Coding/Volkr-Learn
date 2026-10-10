package com.sandboxol.videosubmit;

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
import com.sandboxol.videosubmit.databinding.ActivityVideoSubmitBindingImpl;
import com.sandboxol.videosubmit.databinding.VideosubmitDialogGuideBindingImpl;
import com.sandboxol.videosubmit.databinding.VideosubmitDialogLinkBindingImpl;
import com.sandboxol.videosubmit.databinding.VideosubmitDialogRegisterSucceedBindingImpl;
import com.sandboxol.videosubmit.databinding.VideosubmitDialogSignUpBindingImpl;
import com.sandboxol.videosubmit.databinding.VideosubmitDialogSignUpInfoBindingImpl;
import com.sandboxol.videosubmit.databinding.VideosubmitDialogSubmitSucceedBindingImpl;
import com.sandboxol.videosubmit.databinding.VideosubmitEventRulesBindingImpl;
import com.sandboxol.videosubmit.databinding.VideosubmitGamesBindingImpl;
import com.sandboxol.videosubmit.databinding.VideosubmitItemEventRuleBindingImpl;
import com.sandboxol.videosubmit.databinding.VideosubmitItemGameBindingImpl;
import com.sandboxol.videosubmit.databinding.VideosubmitItemLinkBindingImpl;
import com.sandboxol.videosubmit.databinding.VideosubmitItemThemeBindingImpl;
import com.sandboxol.videosubmit.databinding.VideosubmitItemTipBindingImpl;
import com.sandboxol.videosubmit.databinding.VideosubmitItemWinnerBindingImpl;
import com.sandboxol.videosubmit.databinding.VideosubmitListLinkBindingImpl;
import com.sandboxol.videosubmit.databinding.VideosubmitRwardsBindingImpl;
import com.sandboxol.videosubmit.databinding.VideosubmitTipsBindingImpl;
import com.sandboxol.videosubmit.databinding.VideosubmitVideoThemesBindingImpl;
import com.sandboxol.videosubmit.databinding.VideosubmitWinnersBindingImpl;
import io.rong.imlib.common.RongLibConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class DataBinderMapperImpl extends b {
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(20);
    private static final int LAYOUT_ACTIVITYVIDEOSUBMIT = 1;
    private static final int LAYOUT_VIDEOSUBMITDIALOGGUIDE = 2;
    private static final int LAYOUT_VIDEOSUBMITDIALOGLINK = 3;
    private static final int LAYOUT_VIDEOSUBMITDIALOGREGISTERSUCCEED = 4;
    private static final int LAYOUT_VIDEOSUBMITDIALOGSIGNUP = 5;
    private static final int LAYOUT_VIDEOSUBMITDIALOGSIGNUPINFO = 6;
    private static final int LAYOUT_VIDEOSUBMITDIALOGSUBMITSUCCEED = 7;
    private static final int LAYOUT_VIDEOSUBMITEVENTRULES = 8;
    private static final int LAYOUT_VIDEOSUBMITGAMES = 9;
    private static final int LAYOUT_VIDEOSUBMITITEMEVENTRULE = 10;
    private static final int LAYOUT_VIDEOSUBMITITEMGAME = 11;
    private static final int LAYOUT_VIDEOSUBMITITEMLINK = 12;
    private static final int LAYOUT_VIDEOSUBMITITEMTHEME = 13;
    private static final int LAYOUT_VIDEOSUBMITITEMTIP = 14;
    private static final int LAYOUT_VIDEOSUBMITITEMWINNER = 15;
    private static final int LAYOUT_VIDEOSUBMITLISTLINK = 16;
    private static final int LAYOUT_VIDEOSUBMITRWARDS = 17;
    private static final int LAYOUT_VIDEOSUBMITTIPS = 18;
    private static final int LAYOUT_VIDEOSUBMITVIDEOTHEMES = 19;
    private static final int LAYOUT_VIDEOSUBMITWINNERS = 20;

    private static class InnerBrLookup {
        static final SparseArray<String> sKeys = new SparseArray<>(140);

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
            sKeys.put(28, "tribeLevel");
            sKeys.put(29, "appVersion");
            sKeys.put(30, "resourceId");
            sKeys.put(31, "remainingDays");
            sKeys.put(32, "PasswordSettingDialog");
            sKeys.put(33, "seconds");
            sKeys.put(34, "gameName");
            sKeys.put(35, "activityFlag");
            sKeys.put(36, "captainName");
            sKeys.put(37, "price");
            sKeys.put(38, "currentCount");
            sKeys.put(39, "passwordSettingDialog");
            sKeys.put(40, "AdsTurntableDialog");
            sKeys.put(41, "id");
            sKeys.put(42, "vip");
            sKeys.put(43, "tasks");
            sKeys.put(44, "campaignGetIntegralRewardDialog");
            sKeys.put(45, "tribeGolds");
            sKeys.put(46, "expire");
            sKeys.put(47, "TeamInviteDialog");
            sKeys.put(48, "typeId");
            sKeys.put(49, "tribeClanId");
            sKeys.put(50, "teamCount");
            sKeys.put(51, "hasLocalRes");
            sKeys.put(52, "vipGcubeGiftOneButtonDialog");
            sKeys.put(53, "isCreate");
            sKeys.put(54, "currency");
            sKeys.put(55, "isActivity");
            sKeys.put(56, "buySuccess");
            sKeys.put(57, "campaignOneButtonDialog");
            sKeys.put(58, "tribeRole");
            sKeys.put(59, "memberCount");
            sKeys.put(60, "sex");
            sKeys.put(61, "psid");
            sKeys.put(62, "userId");
            sKeys.put(63, "url");
            sKeys.put(64, RongLibConst.KEY_TOKEN);
            sKeys.put(65, "gamePic");
            sKeys.put(66, "CampaignGetIntegralRewardDialog");
            sKeys.put(67, "isUgc");
            sKeys.put(68, "tribeName");
            sKeys.put(69, "blankType");
            sKeys.put(70, "country");
            sKeys.put(71, "isRecommend");
            sKeys.put(72, "isNewEngine");
            sKeys.put(73, "hasPurchase");
            sKeys.put(74, "experience");
            sKeys.put(75, "tribeHead");
            sKeys.put(76, "CampaignOneButtonDialog");
            sKeys.put(77, "picUrl");
            sKeys.put(78, "maxMember");
            sKeys.put(79, "suitPrice");
            sKeys.put(80, "details");
            sKeys.put(81, "organizeTeamUrl");
            sKeys.put(82, "iconUrl");
            sKeys.put(83, "verification");
            sKeys.put(84, "scrapMakeSureDialog");
            sKeys.put(85, "teamInviteDialog");
            sKeys.put(86, "captainId");
            sKeys.put(87, "limitedTimes");
            sKeys.put(88, "minutes");
            sKeys.put(89, "CheckAppVersionDialogViewModel");
            sKeys.put(90, "count");
            sKeys.put(91, "messageId");
            sKeys.put(92, "roomName");
            sKeys.put(93, "signInStatus");
            sKeys.put(94, "checkAppVersionDialogViewModel");
            sKeys.put(95, "AdsGameRewardDialog");
            sKeys.put(96, "scrapNum");
            sKeys.put(97, "name");
            sKeys.put(98, "viewModel");
            sKeys.put(99, "teamType");
            sKeys.put(100, "adsGameRewardDialog");
            sKeys.put(101, "gameType");
            sKeys.put(102, "itemType");
            sKeys.put(103, "releaseTime");
            sKeys.put(104, "show");
            sKeys.put(105, "taskMap");
            sKeys.put(106, "dispUrl");
            sKeys.put(107, "ScrapMakeSureDialog");
            sKeys.put(108, "ViewModel");
            sKeys.put(109, "pmId");
            sKeys.put(110, "maxCount");
            sKeys.put(111, "decorationInfoList");
            sKeys.put(112, "ScrapBagPageViewModel");
            sKeys.put(113, "scrapBagPageViewModel");
            sKeys.put(114, "suitId");
            sKeys.put(115, "chatRoomId");
            sKeys.put(116, "packageName");
            sKeys.put(117, PlaceFields.HOURS);
            sKeys.put(118, FirebaseAnalytics.Param.QUANTITY);
            sKeys.put(119, "adsTurntableDialog");
            sKeys.put(120, "enterType");
            sKeys.put(121, "isNew");
            sKeys.put(122, "occupyPosition");
            sKeys.put(123, "VipGcubeGiftOneButtonDialog");
            sKeys.put(124, "regionId");
            sKeys.put(125, "teamId");
            sKeys.put(126, "payChannel");
            sKeys.put(127, "orderField");
            sKeys.put(128, "showEmptyView");
            sKeys.put(129, "item");
            sKeys.put(130, "refreshing");
            sKeys.put(131, "emptyText");
            sKeys.put(132, "loadingMore");
            sKeys.put(133, "VideoSubmitViewModel");
            sKeys.put(134, "winner");
            sKeys.put(135, "rule");
            sKeys.put(136, "videoSubmitViewModel");
            sKeys.put(137, "tip");
            sKeys.put(138, "drawableStart");
        }

        private InnerBrLookup() {
        }
    }

    private static class InnerLayoutIdLookup {
        static final HashMap<String, Integer> sKeys = new HashMap<>(20);

        static {
            sKeys.put("layout/activity_video_submit_0", Integer.valueOf(R.layout.activity_video_submit));
            sKeys.put("layout/videosubmit_dialog_guide_0", Integer.valueOf(R.layout.videosubmit_dialog_guide));
            sKeys.put("layout/videosubmit_dialog_link_0", Integer.valueOf(R.layout.videosubmit_dialog_link));
            sKeys.put("layout/videosubmit_dialog_register_succeed_0", Integer.valueOf(R.layout.videosubmit_dialog_register_succeed));
            sKeys.put("layout/videosubmit_dialog_sign_up_0", Integer.valueOf(R.layout.videosubmit_dialog_sign_up));
            sKeys.put("layout/videosubmit_dialog_sign_up_info_0", Integer.valueOf(R.layout.videosubmit_dialog_sign_up_info));
            sKeys.put("layout/videosubmit_dialog_submit_succeed_0", Integer.valueOf(R.layout.videosubmit_dialog_submit_succeed));
            sKeys.put("layout/videosubmit_event_rules_0", Integer.valueOf(R.layout.videosubmit_event_rules));
            sKeys.put("layout/videosubmit_games_0", Integer.valueOf(R.layout.videosubmit_games));
            sKeys.put("layout/videosubmit_item_event_rule_0", Integer.valueOf(R.layout.videosubmit_item_event_rule));
            sKeys.put("layout/videosubmit_item_game_0", Integer.valueOf(R.layout.videosubmit_item_game));
            sKeys.put("layout/videosubmit_item_link_0", Integer.valueOf(R.layout.videosubmit_item_link));
            sKeys.put("layout/videosubmit_item_theme_0", Integer.valueOf(R.layout.videosubmit_item_theme));
            sKeys.put("layout/videosubmit_item_tip_0", Integer.valueOf(R.layout.videosubmit_item_tip));
            sKeys.put("layout/videosubmit_item_winner_0", Integer.valueOf(R.layout.videosubmit_item_winner));
            sKeys.put("layout/videosubmit_list_link_0", Integer.valueOf(R.layout.videosubmit_list_link));
            sKeys.put("layout/videosubmit_rwards_0", Integer.valueOf(R.layout.videosubmit_rwards));
            sKeys.put("layout/videosubmit_tips_0", Integer.valueOf(R.layout.videosubmit_tips));
            sKeys.put("layout/videosubmit_video_themes_0", Integer.valueOf(R.layout.videosubmit_video_themes));
            sKeys.put("layout/videosubmit_winners_0", Integer.valueOf(R.layout.videosubmit_winners));
        }

        private InnerLayoutIdLookup() {
        }
    }

    static {
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.activity_video_submit, 1);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.videosubmit_dialog_guide, 2);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.videosubmit_dialog_link, 3);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.videosubmit_dialog_register_succeed, 4);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.videosubmit_dialog_sign_up, 5);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.videosubmit_dialog_sign_up_info, 6);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.videosubmit_dialog_submit_succeed, 7);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.videosubmit_event_rules, 8);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.videosubmit_games, 9);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.videosubmit_item_event_rule, 10);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.videosubmit_item_game, 11);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.videosubmit_item_link, 12);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.videosubmit_item_theme, 13);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.videosubmit_item_tip, 14);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.videosubmit_item_winner, 15);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.videosubmit_list_link, 16);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.videosubmit_rwards, 17);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.videosubmit_tips, 18);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.videosubmit_video_themes, 19);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.videosubmit_winners, 20);
    }

    @Override // androidx.databinding.b
    public List<b> collectDependencies() {
        ArrayList arrayList = new ArrayList(5);
        arrayList.add(new a());
        arrayList.add(new com.sandboxol.center.DataBinderMapperImpl());
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
                if ("layout/activity_video_submit_0".equals(tag)) {
                    return new ActivityVideoSubmitBindingImpl(dVar, view);
                }
                throw new IllegalArgumentException("The tag for activity_video_submit is invalid. Received: " + tag);
            case 2:
                if ("layout/videosubmit_dialog_guide_0".equals(tag)) {
                    return new VideosubmitDialogGuideBindingImpl(dVar, view);
                }
                throw new IllegalArgumentException("The tag for videosubmit_dialog_guide is invalid. Received: " + tag);
            case 3:
                if ("layout/videosubmit_dialog_link_0".equals(tag)) {
                    return new VideosubmitDialogLinkBindingImpl(dVar, view);
                }
                throw new IllegalArgumentException("The tag for videosubmit_dialog_link is invalid. Received: " + tag);
            case 4:
                if ("layout/videosubmit_dialog_register_succeed_0".equals(tag)) {
                    return new VideosubmitDialogRegisterSucceedBindingImpl(dVar, view);
                }
                throw new IllegalArgumentException("The tag for videosubmit_dialog_register_succeed is invalid. Received: " + tag);
            case 5:
                if ("layout/videosubmit_dialog_sign_up_0".equals(tag)) {
                    return new VideosubmitDialogSignUpBindingImpl(dVar, view);
                }
                throw new IllegalArgumentException("The tag for videosubmit_dialog_sign_up is invalid. Received: " + tag);
            case 6:
                if ("layout/videosubmit_dialog_sign_up_info_0".equals(tag)) {
                    return new VideosubmitDialogSignUpInfoBindingImpl(dVar, view);
                }
                throw new IllegalArgumentException("The tag for videosubmit_dialog_sign_up_info is invalid. Received: " + tag);
            case 7:
                if ("layout/videosubmit_dialog_submit_succeed_0".equals(tag)) {
                    return new VideosubmitDialogSubmitSucceedBindingImpl(dVar, view);
                }
                throw new IllegalArgumentException("The tag for videosubmit_dialog_submit_succeed is invalid. Received: " + tag);
            case 8:
                if ("layout/videosubmit_event_rules_0".equals(tag)) {
                    return new VideosubmitEventRulesBindingImpl(dVar, view);
                }
                throw new IllegalArgumentException("The tag for videosubmit_event_rules is invalid. Received: " + tag);
            case 9:
                if ("layout/videosubmit_games_0".equals(tag)) {
                    return new VideosubmitGamesBindingImpl(dVar, view);
                }
                throw new IllegalArgumentException("The tag for videosubmit_games is invalid. Received: " + tag);
            case 10:
                if ("layout/videosubmit_item_event_rule_0".equals(tag)) {
                    return new VideosubmitItemEventRuleBindingImpl(dVar, view);
                }
                throw new IllegalArgumentException("The tag for videosubmit_item_event_rule is invalid. Received: " + tag);
            case 11:
                if ("layout/videosubmit_item_game_0".equals(tag)) {
                    return new VideosubmitItemGameBindingImpl(dVar, view);
                }
                throw new IllegalArgumentException("The tag for videosubmit_item_game is invalid. Received: " + tag);
            case 12:
                if ("layout/videosubmit_item_link_0".equals(tag)) {
                    return new VideosubmitItemLinkBindingImpl(dVar, view);
                }
                throw new IllegalArgumentException("The tag for videosubmit_item_link is invalid. Received: " + tag);
            case 13:
                if ("layout/videosubmit_item_theme_0".equals(tag)) {
                    return new VideosubmitItemThemeBindingImpl(dVar, view);
                }
                throw new IllegalArgumentException("The tag for videosubmit_item_theme is invalid. Received: " + tag);
            case 14:
                if ("layout/videosubmit_item_tip_0".equals(tag)) {
                    return new VideosubmitItemTipBindingImpl(dVar, view);
                }
                throw new IllegalArgumentException("The tag for videosubmit_item_tip is invalid. Received: " + tag);
            case 15:
                if ("layout/videosubmit_item_winner_0".equals(tag)) {
                    return new VideosubmitItemWinnerBindingImpl(dVar, view);
                }
                throw new IllegalArgumentException("The tag for videosubmit_item_winner is invalid. Received: " + tag);
            case 16:
                if ("layout/videosubmit_list_link_0".equals(tag)) {
                    return new VideosubmitListLinkBindingImpl(dVar, view);
                }
                throw new IllegalArgumentException("The tag for videosubmit_list_link is invalid. Received: " + tag);
            case 17:
                if ("layout/videosubmit_rwards_0".equals(tag)) {
                    return new VideosubmitRwardsBindingImpl(dVar, view);
                }
                throw new IllegalArgumentException("The tag for videosubmit_rwards is invalid. Received: " + tag);
            case 18:
                if ("layout/videosubmit_tips_0".equals(tag)) {
                    return new VideosubmitTipsBindingImpl(dVar, view);
                }
                throw new IllegalArgumentException("The tag for videosubmit_tips is invalid. Received: " + tag);
            case 19:
                if ("layout/videosubmit_video_themes_0".equals(tag)) {
                    return new VideosubmitVideoThemesBindingImpl(dVar, view);
                }
                throw new IllegalArgumentException("The tag for videosubmit_video_themes is invalid. Received: " + tag);
            case 20:
                if ("layout/videosubmit_winners_0".equals(tag)) {
                    return new VideosubmitWinnersBindingImpl(dVar, view);
                }
                throw new IllegalArgumentException("The tag for videosubmit_winners is invalid. Received: " + tag);
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
