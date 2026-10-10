package com.sandboxol.googlepay;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.places.model.PlaceFields;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.sandboxol.ads.iron.d;
import com.sandboxol.adsoversea.DataBinderMapperImpl;
import com.sandboxol.googlepay.a.f;
import com.sandboxol.googlepay.a.h;
import com.sandboxol.googlepay.a.j;
import com.sandboxol.googlepay.a.l;
import com.sandboxol.googlepay.a.n;
import com.sandboxol.googlepay.a.p;
import com.sandboxol.googlepay.a.r;
import com.sandboxol.googlepay.a.t;
import com.sandboxol.googlepay.a.v;
import com.sandboxol.googlepay.a.x;
import io.rong.imlib.common.RongLibConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: DataBinderMapperImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class b extends androidx.databinding.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SparseIntArray f18249a = new SparseIntArray(12);

    /* JADX INFO: compiled from: DataBinderMapperImpl.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final SparseArray<String> f18250a = new SparseArray<>(145);

        static {
            f18250a.put(0, "_all");
            f18250a.put(1, "videoId");
            f18250a.put(2, "gameTitle");
            f18250a.put(3, "dislikeNumber");
            f18250a.put(4, "featuredPlay");
            f18250a.put(5, "title");
            f18250a.put(6, "evaluateStatus");
            f18250a.put(7, "videoUrl");
            f18250a.put(8, "bannerPic");
            f18250a.put(9, "youtubeUrl");
            f18250a.put(10, "alias");
            f18250a.put(11, "videoTime");
            f18250a.put(12, "tag");
            f18250a.put(13, "gameDetail");
            f18250a.put(14, "gameId");
            f18250a.put(15, "images");
            f18250a.put(16, "nickName");
            f18250a.put(17, "authorInfo");
            f18250a.put(18, "authorId");
            f18250a.put(19, "isPublish");
            f18250a.put(20, "tagName");
            f18250a.put(21, "gameCoverPic");
            f18250a.put(22, "playAmount");
            f18250a.put(23, "videoPic");
            f18250a.put(24, "authorName");
            f18250a.put(25, "authorPicUrl");
            f18250a.put(26, "likeNumber");
            f18250a.put(27, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
            f18250a.put(28, "tribeLevel");
            f18250a.put(29, "appVersion");
            f18250a.put(30, "resourceId");
            f18250a.put(31, "remainingDays");
            f18250a.put(32, "PasswordSettingDialog");
            f18250a.put(33, "seconds");
            f18250a.put(34, "gameName");
            f18250a.put(35, "activityFlag");
            f18250a.put(36, "captainName");
            f18250a.put(37, "price");
            f18250a.put(38, "currentCount");
            f18250a.put(39, "passwordSettingDialog");
            f18250a.put(40, "AdsTurntableDialog");
            f18250a.put(41, "id");
            f18250a.put(42, "vip");
            f18250a.put(43, "tasks");
            f18250a.put(44, "campaignGetIntegralRewardDialog");
            f18250a.put(45, "tribeGolds");
            f18250a.put(46, "expire");
            f18250a.put(47, "TeamInviteDialog");
            f18250a.put(48, "typeId");
            f18250a.put(49, "tribeClanId");
            f18250a.put(50, "teamCount");
            f18250a.put(51, "hasLocalRes");
            f18250a.put(52, "vipGcubeGiftOneButtonDialog");
            f18250a.put(53, "isCreate");
            f18250a.put(54, "currency");
            f18250a.put(55, "isActivity");
            f18250a.put(56, "buySuccess");
            f18250a.put(57, "campaignOneButtonDialog");
            f18250a.put(58, "tribeRole");
            f18250a.put(59, "memberCount");
            f18250a.put(60, "sex");
            f18250a.put(61, "psid");
            f18250a.put(62, "userId");
            f18250a.put(63, "url");
            f18250a.put(64, RongLibConst.KEY_TOKEN);
            f18250a.put(65, "gamePic");
            f18250a.put(66, "CampaignGetIntegralRewardDialog");
            f18250a.put(67, "isUgc");
            f18250a.put(68, "tribeName");
            f18250a.put(69, "blankType");
            f18250a.put(70, "country");
            f18250a.put(71, "isRecommend");
            f18250a.put(72, "isNewEngine");
            f18250a.put(73, "hasPurchase");
            f18250a.put(74, "experience");
            f18250a.put(75, "tribeHead");
            f18250a.put(76, "CampaignOneButtonDialog");
            f18250a.put(77, "picUrl");
            f18250a.put(78, "maxMember");
            f18250a.put(79, "suitPrice");
            f18250a.put(80, "details");
            f18250a.put(81, "organizeTeamUrl");
            f18250a.put(82, "iconUrl");
            f18250a.put(83, "verification");
            f18250a.put(84, "scrapMakeSureDialog");
            f18250a.put(85, "teamInviteDialog");
            f18250a.put(86, "captainId");
            f18250a.put(87, "limitedTimes");
            f18250a.put(88, "minutes");
            f18250a.put(89, "CheckAppVersionDialogViewModel");
            f18250a.put(90, "count");
            f18250a.put(91, "messageId");
            f18250a.put(92, "roomName");
            f18250a.put(93, "signInStatus");
            f18250a.put(94, "checkAppVersionDialogViewModel");
            f18250a.put(95, "AdsGameRewardDialog");
            f18250a.put(96, "scrapNum");
            f18250a.put(97, "name");
            f18250a.put(98, "viewModel");
            f18250a.put(99, "teamType");
            f18250a.put(100, "adsGameRewardDialog");
            f18250a.put(101, "gameType");
            f18250a.put(102, "itemType");
            f18250a.put(103, "releaseTime");
            f18250a.put(104, "show");
            f18250a.put(105, "taskMap");
            f18250a.put(106, "dispUrl");
            f18250a.put(107, "ScrapMakeSureDialog");
            f18250a.put(108, "ViewModel");
            f18250a.put(109, "pmId");
            f18250a.put(110, "maxCount");
            f18250a.put(111, "decorationInfoList");
            f18250a.put(112, "ScrapBagPageViewModel");
            f18250a.put(113, "scrapBagPageViewModel");
            f18250a.put(114, "suitId");
            f18250a.put(115, "chatRoomId");
            f18250a.put(116, "packageName");
            f18250a.put(117, PlaceFields.HOURS);
            f18250a.put(118, FirebaseAnalytics.Param.QUANTITY);
            f18250a.put(119, "adsTurntableDialog");
            f18250a.put(120, "enterType");
            f18250a.put(121, "isNew");
            f18250a.put(122, "occupyPosition");
            f18250a.put(123, "VipGcubeGiftOneButtonDialog");
            f18250a.put(124, "regionId");
            f18250a.put(125, "teamId");
            f18250a.put(126, "payChannel");
            f18250a.put(127, "orderField");
            f18250a.put(128, "showEmptyView");
            f18250a.put(129, "item");
            f18250a.put(130, "refreshing");
            f18250a.put(131, "emptyText");
            f18250a.put(132, "loadingMore");
            f18250a.put(133, "StarCodeHelpPopupWindow");
            f18250a.put(134, "RechargeViewModel");
            f18250a.put(135, "rechargeHistoryViewModel");
            f18250a.put(136, "RechargeHistoryViewModel");
            f18250a.put(137, "RechargeDetailViewModel");
            f18250a.put(138, "starCodeHelpPopupWindow");
            f18250a.put(139, "PayViewModel");
            f18250a.put(140, "rechargeViewModel");
            f18250a.put(141, "isVip");
            f18250a.put(142, "rechargeDetailViewModel");
            f18250a.put(143, "payViewModel");
        }
    }

    /* JADX INFO: renamed from: com.sandboxol.googlepay.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DataBinderMapperImpl.java */
    private static class C0151b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final HashMap<String, Integer> f18251a = new HashMap<>(12);

        static {
            f18251a.put("layout/fragment_pay_0", Integer.valueOf(R.layout.fragment_pay));
            f18251a.put("layout/fragment_recharge_0", Integer.valueOf(R.layout.fragment_recharge));
            f18251a.put("layout/fragment_recharge_detail_0", Integer.valueOf(R.layout.fragment_recharge_detail));
            f18251a.put("layout/fragment_recharge_history_0", Integer.valueOf(R.layout.fragment_recharge_history));
            f18251a.put("layout/googlepay_item_recharge_list_2_view_0", Integer.valueOf(R.layout.googlepay_item_recharge_list_2_view));
            f18251a.put("layout/googlepay_item_recharge_view_0", Integer.valueOf(R.layout.googlepay_item_recharge_view));
            f18251a.put("layout/item_recharge_2_view_0", Integer.valueOf(R.layout.item_recharge_2_view));
            f18251a.put("layout/item_recharge_history_0", Integer.valueOf(R.layout.item_recharge_history));
            f18251a.put("layout/item_recharge_view_0", Integer.valueOf(R.layout.item_recharge_view));
            f18251a.put("layout/popwindow_star_code_help_0", Integer.valueOf(R.layout.popwindow_star_code_help));
            f18251a.put("layout/recharge_data_list_view_0", Integer.valueOf(R.layout.recharge_data_list_view));
            f18251a.put("layout/recharge_history_data_list_view_0", Integer.valueOf(R.layout.recharge_history_data_list_view));
        }
    }

    static {
        f18249a.put(R.layout.fragment_pay, 1);
        f18249a.put(R.layout.fragment_recharge, 2);
        f18249a.put(R.layout.fragment_recharge_detail, 3);
        f18249a.put(R.layout.fragment_recharge_history, 4);
        f18249a.put(R.layout.googlepay_item_recharge_list_2_view, 5);
        f18249a.put(R.layout.googlepay_item_recharge_view, 6);
        f18249a.put(R.layout.item_recharge_2_view, 7);
        f18249a.put(R.layout.item_recharge_history, 8);
        f18249a.put(R.layout.item_recharge_view, 9);
        f18249a.put(R.layout.popwindow_star_code_help, 10);
        f18249a.put(R.layout.recharge_data_list_view, 11);
        f18249a.put(R.layout.recharge_history_data_list_view, 12);
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
        return a.f18250a.get(i);
    }

    @Override // androidx.databinding.b
    public ViewDataBinding getDataBinder(androidx.databinding.d dVar, View view, int i) {
        int i2 = f18249a.get(i);
        if (i2 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        }
        switch (i2) {
            case 1:
                if ("layout/fragment_pay_0".equals(tag)) {
                    return new com.sandboxol.googlepay.a.b(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_pay is invalid. Received: " + tag);
            case 2:
                if ("layout/fragment_recharge_0".equals(tag)) {
                    return new com.sandboxol.googlepay.a.d(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_recharge is invalid. Received: " + tag);
            case 3:
                if ("layout/fragment_recharge_detail_0".equals(tag)) {
                    return new f(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_recharge_detail is invalid. Received: " + tag);
            case 4:
                if ("layout/fragment_recharge_history_0".equals(tag)) {
                    return new h(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_recharge_history is invalid. Received: " + tag);
            case 5:
                if ("layout/googlepay_item_recharge_list_2_view_0".equals(tag)) {
                    return new j(dVar, view);
                }
                throw new IllegalArgumentException("The tag for googlepay_item_recharge_list_2_view is invalid. Received: " + tag);
            case 6:
                if ("layout/googlepay_item_recharge_view_0".equals(tag)) {
                    return new l(dVar, view);
                }
                throw new IllegalArgumentException("The tag for googlepay_item_recharge_view is invalid. Received: " + tag);
            case 7:
                if ("layout/item_recharge_2_view_0".equals(tag)) {
                    return new n(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_recharge_2_view is invalid. Received: " + tag);
            case 8:
                if ("layout/item_recharge_history_0".equals(tag)) {
                    return new p(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_recharge_history is invalid. Received: " + tag);
            case 9:
                if ("layout/item_recharge_view_0".equals(tag)) {
                    return new r(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_recharge_view is invalid. Received: " + tag);
            case 10:
                if ("layout/popwindow_star_code_help_0".equals(tag)) {
                    return new t(dVar, view);
                }
                throw new IllegalArgumentException("The tag for popwindow_star_code_help is invalid. Received: " + tag);
            case 11:
                if ("layout/recharge_data_list_view_0".equals(tag)) {
                    return new v(dVar, view);
                }
                throw new IllegalArgumentException("The tag for recharge_data_list_view is invalid. Received: " + tag);
            case 12:
                if ("layout/recharge_history_data_list_view_0".equals(tag)) {
                    return new x(dVar, view);
                }
                throw new IllegalArgumentException("The tag for recharge_history_data_list_view is invalid. Received: " + tag);
            default:
                return null;
        }
    }

    @Override // androidx.databinding.b
    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = C0151b.f18251a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.databinding.b
    public ViewDataBinding getDataBinder(androidx.databinding.d dVar, View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || f18249a.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
