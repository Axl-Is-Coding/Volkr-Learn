package com.sandboxol.oversea;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.places.model.PlaceFields;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.sandboxol.ads.iron.d;
import com.sandboxol.adsoversea.DataBinderMapperImpl;
import io.rong.imlib.common.RongLibConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: DataBinderMapperImpl.java */
/* JADX INFO: loaded from: classes4.dex */
public class a extends androidx.databinding.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SparseIntArray f18814a = new SparseIntArray(0);

    /* JADX INFO: renamed from: com.sandboxol.oversea.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DataBinderMapperImpl.java */
    private static class C0159a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final SparseArray<String> f18815a = new SparseArray<>(134);

        static {
            f18815a.put(0, "_all");
            f18815a.put(1, "videoId");
            f18815a.put(2, "gameTitle");
            f18815a.put(3, "dislikeNumber");
            f18815a.put(4, "featuredPlay");
            f18815a.put(5, "title");
            f18815a.put(6, "evaluateStatus");
            f18815a.put(7, "videoUrl");
            f18815a.put(8, "bannerPic");
            f18815a.put(9, "youtubeUrl");
            f18815a.put(10, "alias");
            f18815a.put(11, "videoTime");
            f18815a.put(12, "tag");
            f18815a.put(13, "gameDetail");
            f18815a.put(14, "gameId");
            f18815a.put(15, "images");
            f18815a.put(16, "nickName");
            f18815a.put(17, "authorInfo");
            f18815a.put(18, "authorId");
            f18815a.put(19, "isPublish");
            f18815a.put(20, "tagName");
            f18815a.put(21, "gameCoverPic");
            f18815a.put(22, "playAmount");
            f18815a.put(23, "videoPic");
            f18815a.put(24, "authorName");
            f18815a.put(25, "authorPicUrl");
            f18815a.put(26, "likeNumber");
            f18815a.put(27, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
            f18815a.put(28, "tribeLevel");
            f18815a.put(29, "appVersion");
            f18815a.put(30, "resourceId");
            f18815a.put(31, "remainingDays");
            f18815a.put(32, "PasswordSettingDialog");
            f18815a.put(33, "seconds");
            f18815a.put(34, "gameName");
            f18815a.put(35, "activityFlag");
            f18815a.put(36, "captainName");
            f18815a.put(37, "price");
            f18815a.put(38, "currentCount");
            f18815a.put(39, "passwordSettingDialog");
            f18815a.put(40, "AdsTurntableDialog");
            f18815a.put(41, "id");
            f18815a.put(42, "vip");
            f18815a.put(43, "tasks");
            f18815a.put(44, "campaignGetIntegralRewardDialog");
            f18815a.put(45, "tribeGolds");
            f18815a.put(46, "expire");
            f18815a.put(47, "TeamInviteDialog");
            f18815a.put(48, "typeId");
            f18815a.put(49, "tribeClanId");
            f18815a.put(50, "teamCount");
            f18815a.put(51, "hasLocalRes");
            f18815a.put(52, "vipGcubeGiftOneButtonDialog");
            f18815a.put(53, "isCreate");
            f18815a.put(54, "currency");
            f18815a.put(55, "isActivity");
            f18815a.put(56, "buySuccess");
            f18815a.put(57, "campaignOneButtonDialog");
            f18815a.put(58, "tribeRole");
            f18815a.put(59, "memberCount");
            f18815a.put(60, "sex");
            f18815a.put(61, "psid");
            f18815a.put(62, "userId");
            f18815a.put(63, "url");
            f18815a.put(64, RongLibConst.KEY_TOKEN);
            f18815a.put(65, "gamePic");
            f18815a.put(66, "CampaignGetIntegralRewardDialog");
            f18815a.put(67, "isUgc");
            f18815a.put(68, "tribeName");
            f18815a.put(69, "blankType");
            f18815a.put(70, "country");
            f18815a.put(71, "isRecommend");
            f18815a.put(72, "isNewEngine");
            f18815a.put(73, "hasPurchase");
            f18815a.put(74, "experience");
            f18815a.put(75, "tribeHead");
            f18815a.put(76, "CampaignOneButtonDialog");
            f18815a.put(77, "picUrl");
            f18815a.put(78, "maxMember");
            f18815a.put(79, "suitPrice");
            f18815a.put(80, "details");
            f18815a.put(81, "organizeTeamUrl");
            f18815a.put(82, "iconUrl");
            f18815a.put(83, "verification");
            f18815a.put(84, "scrapMakeSureDialog");
            f18815a.put(85, "teamInviteDialog");
            f18815a.put(86, "captainId");
            f18815a.put(87, "limitedTimes");
            f18815a.put(88, "minutes");
            f18815a.put(89, "CheckAppVersionDialogViewModel");
            f18815a.put(90, "count");
            f18815a.put(91, "messageId");
            f18815a.put(92, "roomName");
            f18815a.put(93, "signInStatus");
            f18815a.put(94, "checkAppVersionDialogViewModel");
            f18815a.put(95, "AdsGameRewardDialog");
            f18815a.put(96, "scrapNum");
            f18815a.put(97, "name");
            f18815a.put(98, "viewModel");
            f18815a.put(99, "teamType");
            f18815a.put(100, "adsGameRewardDialog");
            f18815a.put(101, "gameType");
            f18815a.put(102, "itemType");
            f18815a.put(103, "releaseTime");
            f18815a.put(104, "show");
            f18815a.put(105, "taskMap");
            f18815a.put(106, "dispUrl");
            f18815a.put(107, "ScrapMakeSureDialog");
            f18815a.put(108, "ViewModel");
            f18815a.put(109, "pmId");
            f18815a.put(110, "maxCount");
            f18815a.put(111, "decorationInfoList");
            f18815a.put(112, "ScrapBagPageViewModel");
            f18815a.put(113, "scrapBagPageViewModel");
            f18815a.put(114, "suitId");
            f18815a.put(115, "chatRoomId");
            f18815a.put(116, "packageName");
            f18815a.put(117, PlaceFields.HOURS);
            f18815a.put(118, FirebaseAnalytics.Param.QUANTITY);
            f18815a.put(119, "adsTurntableDialog");
            f18815a.put(120, "enterType");
            f18815a.put(121, "isNew");
            f18815a.put(122, "occupyPosition");
            f18815a.put(123, "VipGcubeGiftOneButtonDialog");
            f18815a.put(124, "regionId");
            f18815a.put(125, "teamId");
            f18815a.put(126, "payChannel");
            f18815a.put(127, "orderField");
            f18815a.put(128, "showEmptyView");
            f18815a.put(129, "item");
            f18815a.put(130, "refreshing");
            f18815a.put(131, "emptyText");
            f18815a.put(132, "loadingMore");
        }
    }

    /* JADX INFO: compiled from: DataBinderMapperImpl.java */
    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final HashMap<String, Integer> f18816a = new HashMap<>(0);
    }

    @Override // androidx.databinding.b
    public List<androidx.databinding.b> collectDependencies() {
        ArrayList arrayList = new ArrayList(8);
        arrayList.add(new androidx.databinding.library.baseAdapters.a());
        arrayList.add(new d());
        arrayList.add(new com.sandboxol.ads.mob.d());
        arrayList.add(new DataBinderMapperImpl());
        arrayList.add(new com.sandboxol.center.DataBinderMapperImpl());
        arrayList.add(new com.sandboxol.common.DataBinderMapperImpl());
        arrayList.add(new com.sandboxol.greendao.b());
        arrayList.add(new com.sandboxol.messager.a());
        return arrayList;
    }

    @Override // androidx.databinding.b
    public String convertBrIdToString(int i) {
        return C0159a.f18815a.get(i);
    }

    @Override // androidx.databinding.b
    public ViewDataBinding getDataBinder(androidx.databinding.d dVar, View view, int i) {
        if (f18814a.get(i) <= 0 || view.getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    @Override // androidx.databinding.b
    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = b.f18816a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.databinding.b
    public ViewDataBinding getDataBinder(androidx.databinding.d dVar, View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || f18814a.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
