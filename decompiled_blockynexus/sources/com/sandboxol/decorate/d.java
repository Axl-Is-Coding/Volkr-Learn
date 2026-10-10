package com.sandboxol.decorate;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.places.model.PlaceFields;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.sandboxol.center.DataBinderMapperImpl;
import com.sandboxol.decorate.c.B;
import com.sandboxol.decorate.c.C2577b;
import com.sandboxol.decorate.c.C2579d;
import com.sandboxol.decorate.c.C2581f;
import com.sandboxol.decorate.c.C2583h;
import com.sandboxol.decorate.c.C2585j;
import com.sandboxol.decorate.c.C2587l;
import com.sandboxol.decorate.c.C2589n;
import com.sandboxol.decorate.c.C2591p;
import com.sandboxol.decorate.c.C2594t;
import com.sandboxol.decorate.c.C2596v;
import com.sandboxol.decorate.c.C2598x;
import com.sandboxol.decorate.c.C2600z;
import com.sandboxol.decorate.c.D;
import com.sandboxol.decorate.c.F;
import com.sandboxol.decorate.c.H;
import com.sandboxol.decorate.c.J;
import com.sandboxol.decorate.c.L;
import com.sandboxol.decorate.c.N;
import com.sandboxol.decorate.c.P;
import com.sandboxol.decorate.c.S;
import com.sandboxol.decorate.c.U;
import com.sandboxol.decorate.c.W;
import com.sandboxol.decorate.c.Y;
import com.sandboxol.decorate.c.aa;
import com.sandboxol.decorate.c.r;
import io.rong.imlib.common.RongLibConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: DataBinderMapperImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class d extends androidx.databinding.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SparseIntArray f17136a = new SparseIntArray(26);

    /* JADX INFO: compiled from: DataBinderMapperImpl.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final SparseArray<String> f17137a = new SparseArray<>(176);

        static {
            f17137a.put(0, "_all");
            f17137a.put(1, "videoId");
            f17137a.put(2, "gameTitle");
            f17137a.put(3, "dislikeNumber");
            f17137a.put(4, "featuredPlay");
            f17137a.put(5, "title");
            f17137a.put(6, "evaluateStatus");
            f17137a.put(7, "videoUrl");
            f17137a.put(8, "bannerPic");
            f17137a.put(9, "youtubeUrl");
            f17137a.put(10, "alias");
            f17137a.put(11, "videoTime");
            f17137a.put(12, "tag");
            f17137a.put(13, "gameDetail");
            f17137a.put(14, "gameId");
            f17137a.put(15, "images");
            f17137a.put(16, "nickName");
            f17137a.put(17, "authorInfo");
            f17137a.put(18, "authorId");
            f17137a.put(19, "isPublish");
            f17137a.put(20, "tagName");
            f17137a.put(21, "gameCoverPic");
            f17137a.put(22, "playAmount");
            f17137a.put(23, "videoPic");
            f17137a.put(24, "authorName");
            f17137a.put(25, "authorPicUrl");
            f17137a.put(26, "likeNumber");
            f17137a.put(27, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
            f17137a.put(28, "tribeLevel");
            f17137a.put(29, "appVersion");
            f17137a.put(30, "resourceId");
            f17137a.put(31, "remainingDays");
            f17137a.put(32, "PasswordSettingDialog");
            f17137a.put(33, "seconds");
            f17137a.put(34, "gameName");
            f17137a.put(35, "activityFlag");
            f17137a.put(36, "captainName");
            f17137a.put(37, "price");
            f17137a.put(38, "currentCount");
            f17137a.put(39, "passwordSettingDialog");
            f17137a.put(40, "AdsTurntableDialog");
            f17137a.put(41, "id");
            f17137a.put(42, "vip");
            f17137a.put(43, "tasks");
            f17137a.put(44, "campaignGetIntegralRewardDialog");
            f17137a.put(45, "tribeGolds");
            f17137a.put(46, "expire");
            f17137a.put(47, "TeamInviteDialog");
            f17137a.put(48, "typeId");
            f17137a.put(49, "tribeClanId");
            f17137a.put(50, "teamCount");
            f17137a.put(51, "hasLocalRes");
            f17137a.put(52, "vipGcubeGiftOneButtonDialog");
            f17137a.put(53, "isCreate");
            f17137a.put(54, "currency");
            f17137a.put(55, "isActivity");
            f17137a.put(56, "buySuccess");
            f17137a.put(57, "campaignOneButtonDialog");
            f17137a.put(58, "tribeRole");
            f17137a.put(59, "memberCount");
            f17137a.put(60, "sex");
            f17137a.put(61, "psid");
            f17137a.put(62, "userId");
            f17137a.put(63, "url");
            f17137a.put(64, RongLibConst.KEY_TOKEN);
            f17137a.put(65, "gamePic");
            f17137a.put(66, "CampaignGetIntegralRewardDialog");
            f17137a.put(67, "isUgc");
            f17137a.put(68, "tribeName");
            f17137a.put(69, "blankType");
            f17137a.put(70, "country");
            f17137a.put(71, "isRecommend");
            f17137a.put(72, "isNewEngine");
            f17137a.put(73, "hasPurchase");
            f17137a.put(74, "experience");
            f17137a.put(75, "tribeHead");
            f17137a.put(76, "CampaignOneButtonDialog");
            f17137a.put(77, "picUrl");
            f17137a.put(78, "maxMember");
            f17137a.put(79, "suitPrice");
            f17137a.put(80, "details");
            f17137a.put(81, "organizeTeamUrl");
            f17137a.put(82, "iconUrl");
            f17137a.put(83, "verification");
            f17137a.put(84, "scrapMakeSureDialog");
            f17137a.put(85, "teamInviteDialog");
            f17137a.put(86, "captainId");
            f17137a.put(87, "limitedTimes");
            f17137a.put(88, "minutes");
            f17137a.put(89, "CheckAppVersionDialogViewModel");
            f17137a.put(90, "count");
            f17137a.put(91, "messageId");
            f17137a.put(92, "roomName");
            f17137a.put(93, "signInStatus");
            f17137a.put(94, "checkAppVersionDialogViewModel");
            f17137a.put(95, "AdsGameRewardDialog");
            f17137a.put(96, "scrapNum");
            f17137a.put(97, "name");
            f17137a.put(98, "viewModel");
            f17137a.put(99, "teamType");
            f17137a.put(100, "adsGameRewardDialog");
            f17137a.put(101, "gameType");
            f17137a.put(102, "itemType");
            f17137a.put(103, "releaseTime");
            f17137a.put(104, "show");
            f17137a.put(105, "taskMap");
            f17137a.put(106, "dispUrl");
            f17137a.put(107, "ScrapMakeSureDialog");
            f17137a.put(108, "ViewModel");
            f17137a.put(109, "pmId");
            f17137a.put(110, "maxCount");
            f17137a.put(111, "decorationInfoList");
            f17137a.put(112, "ScrapBagPageViewModel");
            f17137a.put(113, "scrapBagPageViewModel");
            f17137a.put(114, "suitId");
            f17137a.put(115, "chatRoomId");
            f17137a.put(116, "packageName");
            f17137a.put(117, PlaceFields.HOURS);
            f17137a.put(118, FirebaseAnalytics.Param.QUANTITY);
            f17137a.put(119, "adsTurntableDialog");
            f17137a.put(120, "enterType");
            f17137a.put(121, "isNew");
            f17137a.put(122, "occupyPosition");
            f17137a.put(123, "VipGcubeGiftOneButtonDialog");
            f17137a.put(124, "regionId");
            f17137a.put(125, "teamId");
            f17137a.put(126, "payChannel");
            f17137a.put(127, "orderField");
            f17137a.put(128, "showEmptyView");
            f17137a.put(129, "item");
            f17137a.put(130, "refreshing");
            f17137a.put(131, "emptyText");
            f17137a.put(132, "loadingMore");
            f17137a.put(133, "DressSuitItemBlankViewModel");
            f17137a.put(134, "dressBuyItemViewModel");
            f17137a.put(135, "dressSuitPageViewModel");
            f17137a.put(136, "DressBuySuitPieceItemViewModel");
            f17137a.put(137, "DressBuyItemViewModel");
            f17137a.put(138, "DressBuySuitItemViewModel");
            f17137a.put(139, "dressShopSuitPageViewModel");
            f17137a.put(140, "DressPageViewModel");
            f17137a.put(141, "dressBuySuitPieceItemViewModel");
            f17137a.put(142, "dressSuitItemBlankViewModel");
            f17137a.put(143, "dressShopGuideDialogViewModel");
            f17137a.put(144, "dressExtraItemViewModel");
            f17137a.put(145, "DressExpiredDialog");
            f17137a.put(146, "DressExpiredItemViewModel");
            f17137a.put(147, "DressShopSuitPageViewModel");
            f17137a.put(148, "dressShopGuideDialogPageModel");
            f17137a.put(149, "DressSuitItemViewModel");
            f17137a.put(150, "DressExtraItemViewModel");
            f17137a.put(151, "dressBuyDialog");
            f17137a.put(152, "dressShopPageViewModel");
            f17137a.put(153, "dressShopRecommendPageViewModel");
            f17137a.put(154, "dressSuitItemViewModel");
            f17137a.put(155, "DressSuitExtraItemViewModel");
            f17137a.put(156, "dressItemBlankViewModel");
            f17137a.put(157, "DressBuyDialog");
            f17137a.put(158, "DressShopRecommendPageViewModel");
            f17137a.put(159, "DressSuitPageViewModel");
            f17137a.put(160, "dressBuySuitItemViewModel");
            f17137a.put(161, "DressShopGuideDialogViewModel");
            f17137a.put(162, "dressSuitExtraItemViewModel");
            f17137a.put(163, "DressViewModel");
            f17137a.put(164, "dressPageViewModel");
            f17137a.put(165, "DressShopSuitItemViewModel");
            f17137a.put(166, "dressExpiredDialog");
            f17137a.put(167, "DressShopGuideDialogPageModel");
            f17137a.put(168, "dressShopRecommendPageItemViewModel");
            f17137a.put(169, "dressViewModel");
            f17137a.put(170, "DressShopPageViewModel");
            f17137a.put(171, "dressShopSuitItemViewModel");
            f17137a.put(172, "dressExpiredItemViewModel");
            f17137a.put(173, "DressShopRecommendPageItemViewModel");
            f17137a.put(174, "DressItemBlankViewModel");
        }
    }

    /* JADX INFO: compiled from: DataBinderMapperImpl.java */
    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final HashMap<String, Integer> f17138a = new HashMap<>(26);

        static {
            f17138a.put("layout/content_dress_page_0", Integer.valueOf(R.layout.content_dress_page));
            f17138a.put("layout/content_dress_shop_guide_dialog_page_0", Integer.valueOf(R.layout.content_dress_shop_guide_dialog_page));
            f17138a.put("layout/content_dress_shop_page_0", Integer.valueOf(R.layout.content_dress_shop_page));
            f17138a.put("layout/content_dress_shop_recommend_page_0", Integer.valueOf(R.layout.content_dress_shop_recommend_page));
            f17138a.put("layout/content_dress_shop_suit_page_0", Integer.valueOf(R.layout.content_dress_shop_suit_page));
            f17138a.put("layout/content_dress_suit_page_0", Integer.valueOf(R.layout.content_dress_suit_page));
            f17138a.put("layout/decorate_list_view_dress_buy_0", Integer.valueOf(R.layout.decorate_list_view_dress_buy));
            f17138a.put("layout/dialog_dress_buy_0", Integer.valueOf(R.layout.dialog_dress_buy));
            f17138a.put("layout/dialog_dress_expired_0", Integer.valueOf(R.layout.dialog_dress_expired));
            f17138a.put("layout/dialog_dress_shop_guide_0", Integer.valueOf(R.layout.dialog_dress_shop_guide));
            f17138a.put("layout/dialog_leave_dress_shop_0", Integer.valueOf(R.layout.dialog_leave_dress_shop));
            f17138a.put("layout/fragment_dress_0", Integer.valueOf(R.layout.fragment_dress));
            f17138a.put("layout/item_dress_0", Integer.valueOf(R.layout.item_dress));
            f17138a.put("layout/item_dress_blank_0", Integer.valueOf(R.layout.item_dress_blank));
            f17138a.put("layout/item_dress_buy_0", Integer.valueOf(R.layout.item_dress_buy));
            f17138a.put("layout/item_dress_buy_suit_0", Integer.valueOf(R.layout.item_dress_buy_suit));
            f17138a.put("layout/item_dress_buy_suit_piece_0", Integer.valueOf(R.layout.item_dress_buy_suit_piece));
            f17138a.put("layout/item_dress_expired_0", Integer.valueOf(R.layout.item_dress_expired));
            f17138a.put("layout/item_dress_shop_clear_history_0", Integer.valueOf(R.layout.item_dress_shop_clear_history));
            f17138a.put("layout/item_dress_shop_special_0", Integer.valueOf(R.layout.item_dress_shop_special));
            f17138a.put("layout/item_dress_special_0", Integer.valueOf(R.layout.item_dress_special));
            f17138a.put("layout/item_dress_suit_blank_0", Integer.valueOf(R.layout.item_dress_suit_blank));
            f17138a.put("layout/item_new_dress_shop_0", Integer.valueOf(R.layout.item_new_dress_shop));
            f17138a.put("layout/item_new_dress_shop_recommend_0", Integer.valueOf(R.layout.item_new_dress_shop_recommend));
            f17138a.put("layout/item_new_dress_shop_suit_0", Integer.valueOf(R.layout.item_new_dress_shop_suit));
            f17138a.put("layout/item_new_dress_suit_0", Integer.valueOf(R.layout.item_new_dress_suit));
        }
    }

    static {
        f17136a.put(R.layout.content_dress_page, 1);
        f17136a.put(R.layout.content_dress_shop_guide_dialog_page, 2);
        f17136a.put(R.layout.content_dress_shop_page, 3);
        f17136a.put(R.layout.content_dress_shop_recommend_page, 4);
        f17136a.put(R.layout.content_dress_shop_suit_page, 5);
        f17136a.put(R.layout.content_dress_suit_page, 6);
        f17136a.put(R.layout.decorate_list_view_dress_buy, 7);
        f17136a.put(R.layout.dialog_dress_buy, 8);
        f17136a.put(R.layout.dialog_dress_expired, 9);
        f17136a.put(R.layout.dialog_dress_shop_guide, 10);
        f17136a.put(R.layout.dialog_leave_dress_shop, 11);
        f17136a.put(R.layout.fragment_dress, 12);
        f17136a.put(R.layout.item_dress, 13);
        f17136a.put(R.layout.item_dress_blank, 14);
        f17136a.put(R.layout.item_dress_buy, 15);
        f17136a.put(R.layout.item_dress_buy_suit, 16);
        f17136a.put(R.layout.item_dress_buy_suit_piece, 17);
        f17136a.put(R.layout.item_dress_expired, 18);
        f17136a.put(R.layout.item_dress_shop_clear_history, 19);
        f17136a.put(R.layout.item_dress_shop_special, 20);
        f17136a.put(R.layout.item_dress_special, 21);
        f17136a.put(R.layout.item_dress_suit_blank, 22);
        f17136a.put(R.layout.item_new_dress_shop, 23);
        f17136a.put(R.layout.item_new_dress_shop_recommend, 24);
        f17136a.put(R.layout.item_new_dress_shop_suit, 25);
        f17136a.put(R.layout.item_new_dress_suit, 26);
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
        return a.f17137a.get(i);
    }

    @Override // androidx.databinding.b
    public ViewDataBinding getDataBinder(androidx.databinding.d dVar, View view, int i) {
        int i2 = f17136a.get(i);
        if (i2 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        }
        switch (i2) {
            case 1:
                if ("layout/content_dress_page_0".equals(tag)) {
                    return new C2577b(dVar, view);
                }
                throw new IllegalArgumentException("The tag for content_dress_page is invalid. Received: " + tag);
            case 2:
                if ("layout/content_dress_shop_guide_dialog_page_0".equals(tag)) {
                    return new C2579d(dVar, view);
                }
                throw new IllegalArgumentException("The tag for content_dress_shop_guide_dialog_page is invalid. Received: " + tag);
            case 3:
                if ("layout/content_dress_shop_page_0".equals(tag)) {
                    return new C2581f(dVar, view);
                }
                throw new IllegalArgumentException("The tag for content_dress_shop_page is invalid. Received: " + tag);
            case 4:
                if ("layout/content_dress_shop_recommend_page_0".equals(tag)) {
                    return new C2583h(dVar, view);
                }
                throw new IllegalArgumentException("The tag for content_dress_shop_recommend_page is invalid. Received: " + tag);
            case 5:
                if ("layout/content_dress_shop_suit_page_0".equals(tag)) {
                    return new C2585j(dVar, view);
                }
                throw new IllegalArgumentException("The tag for content_dress_shop_suit_page is invalid. Received: " + tag);
            case 6:
                if ("layout/content_dress_suit_page_0".equals(tag)) {
                    return new C2587l(dVar, view);
                }
                throw new IllegalArgumentException("The tag for content_dress_suit_page is invalid. Received: " + tag);
            case 7:
                if ("layout/decorate_list_view_dress_buy_0".equals(tag)) {
                    return new C2589n(dVar, view);
                }
                throw new IllegalArgumentException("The tag for decorate_list_view_dress_buy is invalid. Received: " + tag);
            case 8:
                if ("layout/dialog_dress_buy_0".equals(tag)) {
                    return new C2591p(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_dress_buy is invalid. Received: " + tag);
            case 9:
                if ("layout/dialog_dress_expired_0".equals(tag)) {
                    return new r(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_dress_expired is invalid. Received: " + tag);
            case 10:
                if ("layout/dialog_dress_shop_guide_0".equals(tag)) {
                    return new C2594t(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_dress_shop_guide is invalid. Received: " + tag);
            case 11:
                if ("layout/dialog_leave_dress_shop_0".equals(tag)) {
                    return new C2596v(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_leave_dress_shop is invalid. Received: " + tag);
            case 12:
                if ("layout/fragment_dress_0".equals(tag)) {
                    return new C2598x(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_dress is invalid. Received: " + tag);
            case 13:
                if ("layout/item_dress_0".equals(tag)) {
                    return new C2600z(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_dress is invalid. Received: " + tag);
            case 14:
                if ("layout/item_dress_blank_0".equals(tag)) {
                    return new B(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_dress_blank is invalid. Received: " + tag);
            case 15:
                if ("layout/item_dress_buy_0".equals(tag)) {
                    return new D(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_dress_buy is invalid. Received: " + tag);
            case 16:
                if ("layout/item_dress_buy_suit_0".equals(tag)) {
                    return new F(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_dress_buy_suit is invalid. Received: " + tag);
            case 17:
                if ("layout/item_dress_buy_suit_piece_0".equals(tag)) {
                    return new H(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_dress_buy_suit_piece is invalid. Received: " + tag);
            case 18:
                if ("layout/item_dress_expired_0".equals(tag)) {
                    return new J(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_dress_expired is invalid. Received: " + tag);
            case 19:
                if ("layout/item_dress_shop_clear_history_0".equals(tag)) {
                    return new L(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_dress_shop_clear_history is invalid. Received: " + tag);
            case 20:
                if ("layout/item_dress_shop_special_0".equals(tag)) {
                    return new N(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_dress_shop_special is invalid. Received: " + tag);
            case 21:
                if ("layout/item_dress_special_0".equals(tag)) {
                    return new P(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_dress_special is invalid. Received: " + tag);
            case 22:
                if ("layout/item_dress_suit_blank_0".equals(tag)) {
                    return new S(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_dress_suit_blank is invalid. Received: " + tag);
            case 23:
                if ("layout/item_new_dress_shop_0".equals(tag)) {
                    return new U(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_new_dress_shop is invalid. Received: " + tag);
            case 24:
                if ("layout/item_new_dress_shop_recommend_0".equals(tag)) {
                    return new W(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_new_dress_shop_recommend is invalid. Received: " + tag);
            case 25:
                if ("layout/item_new_dress_shop_suit_0".equals(tag)) {
                    return new Y(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_new_dress_shop_suit is invalid. Received: " + tag);
            case 26:
                if ("layout/item_new_dress_suit_0".equals(tag)) {
                    return new aa(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_new_dress_suit is invalid. Received: " + tag);
            default:
                return null;
        }
    }

    @Override // androidx.databinding.b
    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = b.f17138a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.databinding.b
    public ViewDataBinding getDataBinder(androidx.databinding.d dVar, View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || f17136a.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
