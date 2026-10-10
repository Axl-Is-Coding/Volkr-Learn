package com.sandboxol.imchat;

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
import com.sandboxol.imchat.databinding.DialogAppLoadingBindingImpl;
import com.sandboxol.imchat.databinding.DialogGameCountDownBindingImpl;
import com.sandboxol.imchat.databinding.DialogPartyGuideBindingImpl;
import com.sandboxol.imchat.databinding.DialogTeamBackBindingImpl;
import com.sandboxol.imchat.databinding.FragmentPartyDressBindingImpl;
import com.sandboxol.imchat.databinding.FragmentTeamBindingImpl;
import com.sandboxol.imchat.databinding.ItemChatInviteTeamBindingImpl;
import com.sandboxol.imchat.databinding.ItemTeamAddBindingImpl;
import com.sandboxol.imchat.databinding.ItemTeamMemberBindingImpl;
import com.sandboxol.imchat.databinding.ItemTeamPositionBindingImpl;
import com.sandboxol.imchat.databinding.LayoutTeamBindingImpl;
import io.rong.imlib.common.RongLibConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class DataBinderMapperImpl extends b {
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(11);
    private static final int LAYOUT_DIALOGAPPLOADING = 1;
    private static final int LAYOUT_DIALOGGAMECOUNTDOWN = 2;
    private static final int LAYOUT_DIALOGPARTYGUIDE = 3;
    private static final int LAYOUT_DIALOGTEAMBACK = 4;
    private static final int LAYOUT_FRAGMENTPARTYDRESS = 5;
    private static final int LAYOUT_FRAGMENTTEAM = 6;
    private static final int LAYOUT_ITEMCHATINVITETEAM = 7;
    private static final int LAYOUT_ITEMTEAMADD = 8;
    private static final int LAYOUT_ITEMTEAMMEMBER = 9;
    private static final int LAYOUT_ITEMTEAMPOSITION = 10;
    private static final int LAYOUT_LAYOUTTEAM = 11;

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
            sKeys.put(133, "PartyGuideDialog");
            sKeys.put(134, "TeamAddItemViewModel");
            sKeys.put(135, "TeamViewModel");
            sKeys.put(136, "teamViewModel");
            sKeys.put(137, "partyGuideDialog");
            sKeys.put(138, "teamAddItemViewModel");
        }

        private InnerBrLookup() {
        }
    }

    private static class InnerLayoutIdLookup {
        static final HashMap<String, Integer> sKeys = new HashMap<>(11);

        static {
            sKeys.put("layout/dialog_app_loading_0", Integer.valueOf(R.layout.dialog_app_loading));
            sKeys.put("layout/dialog_game_count_down_0", Integer.valueOf(R.layout.dialog_game_count_down));
            sKeys.put("layout/dialog_party_guide_0", Integer.valueOf(R.layout.dialog_party_guide));
            sKeys.put("layout/dialog_team_back_0", Integer.valueOf(R.layout.dialog_team_back));
            sKeys.put("layout/fragment_party_dress_0", Integer.valueOf(R.layout.fragment_party_dress));
            sKeys.put("layout/fragment_team_0", Integer.valueOf(R.layout.fragment_team));
            sKeys.put("layout/item_chat_invite_team_0", Integer.valueOf(R.layout.item_chat_invite_team));
            sKeys.put("layout/item_team_add_0", Integer.valueOf(R.layout.item_team_add));
            sKeys.put("layout/item_team_member_0", Integer.valueOf(R.layout.item_team_member));
            sKeys.put("layout/item_team_position_0", Integer.valueOf(R.layout.item_team_position));
            sKeys.put("layout/layout_team_0", Integer.valueOf(R.layout.layout_team));
        }

        private InnerLayoutIdLookup() {
        }
    }

    static {
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.dialog_app_loading, 1);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.dialog_game_count_down, 2);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.dialog_party_guide, 3);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.dialog_team_back, 4);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.fragment_party_dress, 5);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.fragment_team, 6);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_chat_invite_team, 7);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_team_add, 8);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_team_member, 9);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.item_team_position, 10);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.layout_team, 11);
    }

    @Override // androidx.databinding.b
    public List<b> collectDependencies() {
        ArrayList arrayList = new ArrayList(7);
        arrayList.add(new a());
        arrayList.add(new com.sandboxol.center.DataBinderMapperImpl());
        arrayList.add(new com.sandboxol.common.DataBinderMapperImpl());
        arrayList.add(new com.sandboxol.greendao.b());
        arrayList.add(new com.sandboxol.messager.a());
        arrayList.add(new io.rong.imlib.DataBinderMapperImpl());
        arrayList.add(new me.iwf.photopicker.a());
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
                if ("layout/dialog_app_loading_0".equals(tag)) {
                    return new DialogAppLoadingBindingImpl(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_app_loading is invalid. Received: " + tag);
            case 2:
                if ("layout/dialog_game_count_down_0".equals(tag)) {
                    return new DialogGameCountDownBindingImpl(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_game_count_down is invalid. Received: " + tag);
            case 3:
                if ("layout/dialog_party_guide_0".equals(tag)) {
                    return new DialogPartyGuideBindingImpl(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_party_guide is invalid. Received: " + tag);
            case 4:
                if ("layout/dialog_team_back_0".equals(tag)) {
                    return new DialogTeamBackBindingImpl(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_team_back is invalid. Received: " + tag);
            case 5:
                if ("layout/fragment_party_dress_0".equals(tag)) {
                    return new FragmentPartyDressBindingImpl(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_party_dress is invalid. Received: " + tag);
            case 6:
                if ("layout/fragment_team_0".equals(tag)) {
                    return new FragmentTeamBindingImpl(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_team is invalid. Received: " + tag);
            case 7:
                if ("layout/item_chat_invite_team_0".equals(tag)) {
                    return new ItemChatInviteTeamBindingImpl(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_chat_invite_team is invalid. Received: " + tag);
            case 8:
                if ("layout/item_team_add_0".equals(tag)) {
                    return new ItemTeamAddBindingImpl(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_team_add is invalid. Received: " + tag);
            case 9:
                if ("layout/item_team_member_0".equals(tag)) {
                    return new ItemTeamMemberBindingImpl(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_team_member is invalid. Received: " + tag);
            case 10:
                if ("layout/item_team_position_0".equals(tag)) {
                    return new ItemTeamPositionBindingImpl(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_team_position is invalid. Received: " + tag);
            case 11:
                if ("layout/layout_team_0".equals(tag)) {
                    return new LayoutTeamBindingImpl(dVar, view);
                }
                throw new IllegalArgumentException("The tag for layout_team is invalid. Received: " + tag);
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
