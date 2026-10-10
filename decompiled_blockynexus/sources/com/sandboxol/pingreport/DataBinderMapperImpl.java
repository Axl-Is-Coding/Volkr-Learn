package com.sandboxol.pingreport;

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
import io.rong.imlib.common.RongLibConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class DataBinderMapperImpl extends b {
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(0);

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
        }

        private InnerBrLookup() {
        }
    }

    private static class InnerLayoutIdLookup {
        static final HashMap<String, Integer> sKeys = new HashMap<>(0);

        private InnerLayoutIdLookup() {
        }
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
        if (INTERNAL_LAYOUT_ID_LOOKUP.get(i) <= 0 || view.getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
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
