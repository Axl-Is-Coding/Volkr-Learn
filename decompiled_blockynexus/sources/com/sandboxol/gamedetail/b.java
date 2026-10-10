package com.sandboxol.gamedetail;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.places.model.PlaceFields;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.sandboxol.ads.iron.d;
import com.sandboxol.adsoversea.DataBinderMapperImpl;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.gamedetail.a.B;
import com.sandboxol.gamedetail.a.C2673b;
import com.sandboxol.gamedetail.a.C2675d;
import com.sandboxol.gamedetail.a.C2677f;
import com.sandboxol.gamedetail.a.C2679h;
import com.sandboxol.gamedetail.a.C2681j;
import com.sandboxol.gamedetail.a.C2683l;
import com.sandboxol.gamedetail.a.C2685n;
import com.sandboxol.gamedetail.a.D;
import com.sandboxol.gamedetail.a.F;
import com.sandboxol.gamedetail.a.H;
import com.sandboxol.gamedetail.a.J;
import com.sandboxol.gamedetail.a.L;
import com.sandboxol.gamedetail.a.N;
import com.sandboxol.gamedetail.a.p;
import com.sandboxol.gamedetail.a.r;
import com.sandboxol.gamedetail.a.t;
import com.sandboxol.gamedetail.a.v;
import com.sandboxol.gamedetail.a.x;
import com.sandboxol.gamedetail.a.z;
import io.rong.imlib.common.RongLibConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: DataBinderMapperImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class b extends androidx.databinding.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SparseIntArray f17890a = new SparseIntArray(20);

    /* JADX INFO: compiled from: DataBinderMapperImpl.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final SparseArray<String> f17891a = new SparseArray<>(172);

        static {
            f17891a.put(0, "_all");
            f17891a.put(1, "videoId");
            f17891a.put(2, "gameTitle");
            f17891a.put(3, "dislikeNumber");
            f17891a.put(4, "featuredPlay");
            f17891a.put(5, "title");
            f17891a.put(6, "evaluateStatus");
            f17891a.put(7, "videoUrl");
            f17891a.put(8, "bannerPic");
            f17891a.put(9, "youtubeUrl");
            f17891a.put(10, "alias");
            f17891a.put(11, "videoTime");
            f17891a.put(12, "tag");
            f17891a.put(13, "gameDetail");
            f17891a.put(14, "gameId");
            f17891a.put(15, "images");
            f17891a.put(16, "nickName");
            f17891a.put(17, "authorInfo");
            f17891a.put(18, "authorId");
            f17891a.put(19, "isPublish");
            f17891a.put(20, "tagName");
            f17891a.put(21, "gameCoverPic");
            f17891a.put(22, "playAmount");
            f17891a.put(23, "videoPic");
            f17891a.put(24, "authorName");
            f17891a.put(25, "authorPicUrl");
            f17891a.put(26, "likeNumber");
            f17891a.put(27, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
            f17891a.put(28, "StarCodeHelpPopupWindow");
            f17891a.put(29, "scrapBoxDialog");
            f17891a.put(30, "scrapReceivedAnimDialog");
            f17891a.put(31, "rechargeDialog");
            f17891a.put(32, "praiseNumber");
            f17891a.put(33, "ViewModel");
            f17891a.put(34, "RechargeTipDialog");
            f17891a.put(35, "scrapListDialog");
            f17891a.put(36, StringConstant.GAME_ORDER_TYPE_APPRECIATE);
            f17891a.put(37, "webVideoViewModel");
            f17891a.put(38, "shareDialog");
            f17891a.put(39, "RechargeDetailDialog");
            f17891a.put(40, "ScrapListDialog");
            f17891a.put(41, "ShareDialog");
            f17891a.put(42, "campaignGetIntegralRewardDialog");
            f17891a.put(43, "ScrapBoxDialog");
            f17891a.put(44, "starCodeHelpPopupWindow");
            f17891a.put(45, "rechargeTipDialog");
            f17891a.put(46, "WebVideoViewModel");
            f17891a.put(47, "CampaignGetIntegralRewardDialog");
            f17891a.put(48, "viewModel");
            f17891a.put(49, "rechargeDetailDialog");
            f17891a.put(50, "ScrapReceivedAnimDialog");
            f17891a.put(51, "RechargeDialog");
            f17891a.put(52, "tribeLevel");
            f17891a.put(53, "appVersion");
            f17891a.put(54, "resourceId");
            f17891a.put(55, "remainingDays");
            f17891a.put(56, "PasswordSettingDialog");
            f17891a.put(57, "seconds");
            f17891a.put(58, "gameName");
            f17891a.put(59, "activityFlag");
            f17891a.put(60, "captainName");
            f17891a.put(61, "price");
            f17891a.put(62, "currentCount");
            f17891a.put(63, "passwordSettingDialog");
            f17891a.put(64, "AdsTurntableDialog");
            f17891a.put(65, "id");
            f17891a.put(66, "vip");
            f17891a.put(67, "tasks");
            f17891a.put(68, "tribeGolds");
            f17891a.put(69, "expire");
            f17891a.put(70, "TeamInviteDialog");
            f17891a.put(71, "typeId");
            f17891a.put(72, "tribeClanId");
            f17891a.put(73, "teamCount");
            f17891a.put(74, "hasLocalRes");
            f17891a.put(75, "vipGcubeGiftOneButtonDialog");
            f17891a.put(76, "isCreate");
            f17891a.put(77, "currency");
            f17891a.put(78, "isActivity");
            f17891a.put(79, "buySuccess");
            f17891a.put(80, "campaignOneButtonDialog");
            f17891a.put(81, "tribeRole");
            f17891a.put(82, "memberCount");
            f17891a.put(83, "sex");
            f17891a.put(84, "psid");
            f17891a.put(85, "userId");
            f17891a.put(86, "url");
            f17891a.put(87, RongLibConst.KEY_TOKEN);
            f17891a.put(88, "gamePic");
            f17891a.put(89, "isUgc");
            f17891a.put(90, "tribeName");
            f17891a.put(91, "blankType");
            f17891a.put(92, "country");
            f17891a.put(93, "isRecommend");
            f17891a.put(94, "isNewEngine");
            f17891a.put(95, "hasPurchase");
            f17891a.put(96, "experience");
            f17891a.put(97, "tribeHead");
            f17891a.put(98, "CampaignOneButtonDialog");
            f17891a.put(99, "picUrl");
            f17891a.put(100, "maxMember");
            f17891a.put(101, "suitPrice");
            f17891a.put(102, "details");
            f17891a.put(103, "organizeTeamUrl");
            f17891a.put(104, "iconUrl");
            f17891a.put(105, "verification");
            f17891a.put(106, "scrapMakeSureDialog");
            f17891a.put(107, "teamInviteDialog");
            f17891a.put(108, "captainId");
            f17891a.put(109, "limitedTimes");
            f17891a.put(110, "minutes");
            f17891a.put(111, "CheckAppVersionDialogViewModel");
            f17891a.put(112, "count");
            f17891a.put(113, "messageId");
            f17891a.put(114, "roomName");
            f17891a.put(115, "signInStatus");
            f17891a.put(116, "checkAppVersionDialogViewModel");
            f17891a.put(117, "AdsGameRewardDialog");
            f17891a.put(118, "scrapNum");
            f17891a.put(119, "name");
            f17891a.put(120, "teamType");
            f17891a.put(121, "adsGameRewardDialog");
            f17891a.put(122, "gameType");
            f17891a.put(123, "itemType");
            f17891a.put(124, "releaseTime");
            f17891a.put(125, "show");
            f17891a.put(126, "taskMap");
            f17891a.put(127, "dispUrl");
            f17891a.put(128, "ScrapMakeSureDialog");
            f17891a.put(129, "pmId");
            f17891a.put(130, "maxCount");
            f17891a.put(131, "decorationInfoList");
            f17891a.put(132, "ScrapBagPageViewModel");
            f17891a.put(133, "scrapBagPageViewModel");
            f17891a.put(134, "suitId");
            f17891a.put(135, "chatRoomId");
            f17891a.put(136, "packageName");
            f17891a.put(137, PlaceFields.HOURS);
            f17891a.put(138, FirebaseAnalytics.Param.QUANTITY);
            f17891a.put(139, "adsTurntableDialog");
            f17891a.put(140, "enterType");
            f17891a.put(141, "isNew");
            f17891a.put(142, "occupyPosition");
            f17891a.put(143, "VipGcubeGiftOneButtonDialog");
            f17891a.put(144, "regionId");
            f17891a.put(145, "teamId");
            f17891a.put(146, "payChannel");
            f17891a.put(147, "orderField");
            f17891a.put(148, "showEmptyView");
            f17891a.put(149, "item");
            f17891a.put(150, "refreshing");
            f17891a.put(151, "emptyText");
            f17891a.put(152, "loadingMore");
            f17891a.put(153, "gameDetailHallViewModel");
            f17891a.put(154, "gameDetailViewModel");
            f17891a.put(155, "GameDetailRankViewModel");
            f17891a.put(156, "authorListViewModel");
            f17891a.put(157, "GameDetailShopViewModel");
            f17891a.put(158, "gameDetailShopDialog");
            f17891a.put(159, "gameDetailShopViewModel");
            f17891a.put(160, "GameDetailIntroduceViewModel");
            f17891a.put(161, "gameDetailRankViewModel");
            f17891a.put(162, "gameDetailIntroduceViewModel");
            f17891a.put(163, "GameDetailShopDialog");
            f17891a.put(164, "GameDetailViewModel");
            f17891a.put(165, "enterGameGuideDialog");
            f17891a.put(166, "EnterGameGuideDialog");
            f17891a.put(167, "gameDetailRankPageViewModel");
            f17891a.put(168, "AuthorListViewModel");
            f17891a.put(169, "GameDetailHallViewModel");
            f17891a.put(170, "GameDetailRankPageViewModel");
        }
    }

    /* JADX INFO: renamed from: com.sandboxol.gamedetail.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DataBinderMapperImpl.java */
    private static class C0150b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final HashMap<String, Integer> f17892a = new HashMap<>(20);

        static {
            f17892a.put("layout/author_list_list_view_0", Integer.valueOf(R.layout.author_list_list_view));
            f17892a.put("layout/content_game_detail_rank_page_0", Integer.valueOf(R.layout.content_game_detail_rank_page));
            f17892a.put("layout/content_game_hall_0", Integer.valueOf(R.layout.content_game_hall));
            f17892a.put("layout/dialog_author_list_0", Integer.valueOf(R.layout.dialog_author_list));
            f17892a.put("layout/dialog_enter_game_guide_0", Integer.valueOf(R.layout.dialog_enter_game_guide));
            f17892a.put("layout/dialog_game_detail_shop_0", Integer.valueOf(R.layout.dialog_game_detail_shop));
            f17892a.put("layout/dialog_mario_guide_0", Integer.valueOf(R.layout.dialog_mario_guide));
            f17892a.put("layout/fragment_game_detail_0", Integer.valueOf(R.layout.fragment_game_detail));
            f17892a.put("layout/fragment_game_detail_introduce_0", Integer.valueOf(R.layout.fragment_game_detail_introduce));
            f17892a.put("layout/fragment_game_detail_rank_0", Integer.valueOf(R.layout.fragment_game_detail_rank));
            f17892a.put("layout/fragment_game_detail_shop_0", Integer.valueOf(R.layout.fragment_game_detail_shop));
            f17892a.put("layout/game_detail_list_view_0", Integer.valueOf(R.layout.game_detail_list_view));
            f17892a.put("layout/game_detail_rank_page_list_view_0", Integer.valueOf(R.layout.game_detail_rank_page_list_view));
            f17892a.put("layout/game_detail_shop_list_view_0", Integer.valueOf(R.layout.game_detail_shop_list_view));
            f17892a.put("layout/item_author_list_dialog_0", Integer.valueOf(R.layout.item_author_list_dialog));
            f17892a.put("layout/item_game_detail_first_rank_0", Integer.valueOf(R.layout.item_game_detail_first_rank));
            f17892a.put("layout/item_game_detail_introduce_0", Integer.valueOf(R.layout.item_game_detail_introduce));
            f17892a.put("layout/item_game_detail_introduce_top_0", Integer.valueOf(R.layout.item_game_detail_introduce_top));
            f17892a.put("layout/item_game_detail_rank_0", Integer.valueOf(R.layout.item_game_detail_rank));
            f17892a.put("layout/item_game_detail_shop_0", Integer.valueOf(R.layout.item_game_detail_shop));
        }
    }

    static {
        f17890a.put(R.layout.author_list_list_view, 1);
        f17890a.put(R.layout.content_game_detail_rank_page, 2);
        f17890a.put(R.layout.content_game_hall, 3);
        f17890a.put(R.layout.dialog_author_list, 4);
        f17890a.put(R.layout.dialog_enter_game_guide, 5);
        f17890a.put(R.layout.dialog_game_detail_shop, 6);
        f17890a.put(R.layout.dialog_mario_guide, 7);
        f17890a.put(R.layout.fragment_game_detail, 8);
        f17890a.put(R.layout.fragment_game_detail_introduce, 9);
        f17890a.put(R.layout.fragment_game_detail_rank, 10);
        f17890a.put(R.layout.fragment_game_detail_shop, 11);
        f17890a.put(R.layout.game_detail_list_view, 12);
        f17890a.put(R.layout.game_detail_rank_page_list_view, 13);
        f17890a.put(R.layout.game_detail_shop_list_view, 14);
        f17890a.put(R.layout.item_author_list_dialog, 15);
        f17890a.put(R.layout.item_game_detail_first_rank, 16);
        f17890a.put(R.layout.item_game_detail_introduce, 17);
        f17890a.put(R.layout.item_game_detail_introduce_top, 18);
        f17890a.put(R.layout.item_game_detail_rank, 19);
        f17890a.put(R.layout.item_game_detail_shop, 20);
    }

    @Override // androidx.databinding.b
    public List<androidx.databinding.b> collectDependencies() {
        ArrayList arrayList = new ArrayList(9);
        arrayList.add(new androidx.databinding.library.baseAdapters.a());
        arrayList.add(new d());
        arrayList.add(new com.sandboxol.ads.mob.d());
        arrayList.add(new DataBinderMapperImpl());
        arrayList.add(new com.sandboxol.center.DataBinderMapperImpl());
        arrayList.add(new com.sandboxol.common.DataBinderMapperImpl());
        arrayList.add(new com.sandboxol.game.b());
        arrayList.add(new com.sandboxol.greendao.b());
        arrayList.add(new com.sandboxol.messager.a());
        return arrayList;
    }

    @Override // androidx.databinding.b
    public String convertBrIdToString(int i) {
        return a.f17891a.get(i);
    }

    @Override // androidx.databinding.b
    public ViewDataBinding getDataBinder(androidx.databinding.d dVar, View view, int i) {
        int i2 = f17890a.get(i);
        if (i2 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        }
        switch (i2) {
            case 1:
                if ("layout/author_list_list_view_0".equals(tag)) {
                    return new C2673b(dVar, view);
                }
                throw new IllegalArgumentException("The tag for author_list_list_view is invalid. Received: " + tag);
            case 2:
                if ("layout/content_game_detail_rank_page_0".equals(tag)) {
                    return new C2675d(dVar, view);
                }
                throw new IllegalArgumentException("The tag for content_game_detail_rank_page is invalid. Received: " + tag);
            case 3:
                if ("layout/content_game_hall_0".equals(tag)) {
                    return new C2677f(dVar, view);
                }
                throw new IllegalArgumentException("The tag for content_game_hall is invalid. Received: " + tag);
            case 4:
                if ("layout/dialog_author_list_0".equals(tag)) {
                    return new C2679h(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_author_list is invalid. Received: " + tag);
            case 5:
                if ("layout/dialog_enter_game_guide_0".equals(tag)) {
                    return new C2681j(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_enter_game_guide is invalid. Received: " + tag);
            case 6:
                if ("layout/dialog_game_detail_shop_0".equals(tag)) {
                    return new C2683l(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_game_detail_shop is invalid. Received: " + tag);
            case 7:
                if ("layout/dialog_mario_guide_0".equals(tag)) {
                    return new C2685n(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_mario_guide is invalid. Received: " + tag);
            case 8:
                if ("layout/fragment_game_detail_0".equals(tag)) {
                    return new p(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_game_detail is invalid. Received: " + tag);
            case 9:
                if ("layout/fragment_game_detail_introduce_0".equals(tag)) {
                    return new r(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_game_detail_introduce is invalid. Received: " + tag);
            case 10:
                if ("layout/fragment_game_detail_rank_0".equals(tag)) {
                    return new t(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_game_detail_rank is invalid. Received: " + tag);
            case 11:
                if ("layout/fragment_game_detail_shop_0".equals(tag)) {
                    return new v(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_game_detail_shop is invalid. Received: " + tag);
            case 12:
                if ("layout/game_detail_list_view_0".equals(tag)) {
                    return new x(dVar, view);
                }
                throw new IllegalArgumentException("The tag for game_detail_list_view is invalid. Received: " + tag);
            case 13:
                if ("layout/game_detail_rank_page_list_view_0".equals(tag)) {
                    return new z(dVar, view);
                }
                throw new IllegalArgumentException("The tag for game_detail_rank_page_list_view is invalid. Received: " + tag);
            case 14:
                if ("layout/game_detail_shop_list_view_0".equals(tag)) {
                    return new B(dVar, view);
                }
                throw new IllegalArgumentException("The tag for game_detail_shop_list_view is invalid. Received: " + tag);
            case 15:
                if ("layout/item_author_list_dialog_0".equals(tag)) {
                    return new D(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_author_list_dialog is invalid. Received: " + tag);
            case 16:
                if ("layout/item_game_detail_first_rank_0".equals(tag)) {
                    return new F(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_game_detail_first_rank is invalid. Received: " + tag);
            case 17:
                if ("layout/item_game_detail_introduce_0".equals(tag)) {
                    return new H(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_game_detail_introduce is invalid. Received: " + tag);
            case 18:
                if ("layout/item_game_detail_introduce_top_0".equals(tag)) {
                    return new J(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_game_detail_introduce_top is invalid. Received: " + tag);
            case 19:
                if ("layout/item_game_detail_rank_0".equals(tag)) {
                    return new L(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_game_detail_rank is invalid. Received: " + tag);
            case 20:
                if ("layout/item_game_detail_shop_0".equals(tag)) {
                    return new N(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_game_detail_shop is invalid. Received: " + tag);
            default:
                return null;
        }
    }

    @Override // androidx.databinding.b
    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = C0150b.f17892a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.databinding.b
    public ViewDataBinding getDataBinder(androidx.databinding.d dVar, View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || f17890a.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
