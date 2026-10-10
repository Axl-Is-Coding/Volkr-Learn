package com.sandboxol.vip;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.d;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.places.model.PlaceFields;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.sandboxol.center.DataBinderMapperImpl;
import com.sandboxol.vip.b.B;
import com.sandboxol.vip.b.C2745b;
import com.sandboxol.vip.b.f;
import com.sandboxol.vip.b.h;
import com.sandboxol.vip.b.j;
import com.sandboxol.vip.b.l;
import com.sandboxol.vip.b.n;
import com.sandboxol.vip.b.p;
import com.sandboxol.vip.b.r;
import com.sandboxol.vip.b.t;
import com.sandboxol.vip.b.v;
import com.sandboxol.vip.b.x;
import com.sandboxol.vip.b.z;
import io.rong.imlib.common.RongLibConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: DataBinderMapperImpl.java */
/* JADX INFO: loaded from: classes4.dex */
public class b extends androidx.databinding.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SparseIntArray f18959a = new SparseIntArray(14);

    /* JADX INFO: compiled from: DataBinderMapperImpl.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final SparseArray<String> f18960a = new SparseArray<>(155);

        static {
            f18960a.put(0, "_all");
            f18960a.put(1, "videoId");
            f18960a.put(2, "gameTitle");
            f18960a.put(3, "dislikeNumber");
            f18960a.put(4, "featuredPlay");
            f18960a.put(5, "title");
            f18960a.put(6, "evaluateStatus");
            f18960a.put(7, "videoUrl");
            f18960a.put(8, "bannerPic");
            f18960a.put(9, "youtubeUrl");
            f18960a.put(10, "alias");
            f18960a.put(11, "videoTime");
            f18960a.put(12, "tag");
            f18960a.put(13, "gameDetail");
            f18960a.put(14, "gameId");
            f18960a.put(15, "images");
            f18960a.put(16, "nickName");
            f18960a.put(17, "authorInfo");
            f18960a.put(18, "authorId");
            f18960a.put(19, "isPublish");
            f18960a.put(20, "tagName");
            f18960a.put(21, "gameCoverPic");
            f18960a.put(22, "playAmount");
            f18960a.put(23, "videoPic");
            f18960a.put(24, "authorName");
            f18960a.put(25, "authorPicUrl");
            f18960a.put(26, "likeNumber");
            f18960a.put(27, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
            f18960a.put(28, "StarCodeHelpPopupWindow");
            f18960a.put(29, "RechargeViewModel");
            f18960a.put(30, "rechargeHistoryViewModel");
            f18960a.put(31, "RechargeHistoryViewModel");
            f18960a.put(32, "RechargeDetailViewModel");
            f18960a.put(33, "ViewModel");
            f18960a.put(34, "starCodeHelpPopupWindow");
            f18960a.put(35, "PayViewModel");
            f18960a.put(36, "isVip");
            f18960a.put(37, "rechargeViewModel");
            f18960a.put(38, "rechargeDetailViewModel");
            f18960a.put(39, "viewModel");
            f18960a.put(40, "payViewModel");
            f18960a.put(41, "tribeLevel");
            f18960a.put(42, "appVersion");
            f18960a.put(43, "resourceId");
            f18960a.put(44, "remainingDays");
            f18960a.put(45, "PasswordSettingDialog");
            f18960a.put(46, "seconds");
            f18960a.put(47, "gameName");
            f18960a.put(48, "activityFlag");
            f18960a.put(49, "captainName");
            f18960a.put(50, "price");
            f18960a.put(51, "currentCount");
            f18960a.put(52, "passwordSettingDialog");
            f18960a.put(53, "AdsTurntableDialog");
            f18960a.put(54, "id");
            f18960a.put(55, "vip");
            f18960a.put(56, "tasks");
            f18960a.put(57, "campaignGetIntegralRewardDialog");
            f18960a.put(58, "tribeGolds");
            f18960a.put(59, "expire");
            f18960a.put(60, "TeamInviteDialog");
            f18960a.put(61, "typeId");
            f18960a.put(62, "tribeClanId");
            f18960a.put(63, "teamCount");
            f18960a.put(64, "hasLocalRes");
            f18960a.put(65, "vipGcubeGiftOneButtonDialog");
            f18960a.put(66, "isCreate");
            f18960a.put(67, "currency");
            f18960a.put(68, "isActivity");
            f18960a.put(69, "buySuccess");
            f18960a.put(70, "campaignOneButtonDialog");
            f18960a.put(71, "tribeRole");
            f18960a.put(72, "memberCount");
            f18960a.put(73, "sex");
            f18960a.put(74, "psid");
            f18960a.put(75, "userId");
            f18960a.put(76, "url");
            f18960a.put(77, RongLibConst.KEY_TOKEN);
            f18960a.put(78, "gamePic");
            f18960a.put(79, "CampaignGetIntegralRewardDialog");
            f18960a.put(80, "isUgc");
            f18960a.put(81, "tribeName");
            f18960a.put(82, "blankType");
            f18960a.put(83, "country");
            f18960a.put(84, "isRecommend");
            f18960a.put(85, "isNewEngine");
            f18960a.put(86, "hasPurchase");
            f18960a.put(87, "experience");
            f18960a.put(88, "tribeHead");
            f18960a.put(89, "CampaignOneButtonDialog");
            f18960a.put(90, "picUrl");
            f18960a.put(91, "maxMember");
            f18960a.put(92, "suitPrice");
            f18960a.put(93, "details");
            f18960a.put(94, "organizeTeamUrl");
            f18960a.put(95, "iconUrl");
            f18960a.put(96, "verification");
            f18960a.put(97, "scrapMakeSureDialog");
            f18960a.put(98, "teamInviteDialog");
            f18960a.put(99, "captainId");
            f18960a.put(100, "limitedTimes");
            f18960a.put(101, "minutes");
            f18960a.put(102, "CheckAppVersionDialogViewModel");
            f18960a.put(103, "count");
            f18960a.put(104, "messageId");
            f18960a.put(105, "roomName");
            f18960a.put(106, "signInStatus");
            f18960a.put(107, "checkAppVersionDialogViewModel");
            f18960a.put(108, "AdsGameRewardDialog");
            f18960a.put(109, "scrapNum");
            f18960a.put(110, "name");
            f18960a.put(111, "teamType");
            f18960a.put(112, "adsGameRewardDialog");
            f18960a.put(113, "gameType");
            f18960a.put(114, "itemType");
            f18960a.put(115, "releaseTime");
            f18960a.put(116, "show");
            f18960a.put(117, "taskMap");
            f18960a.put(118, "dispUrl");
            f18960a.put(119, "ScrapMakeSureDialog");
            f18960a.put(120, "pmId");
            f18960a.put(121, "maxCount");
            f18960a.put(122, "decorationInfoList");
            f18960a.put(123, "ScrapBagPageViewModel");
            f18960a.put(124, "scrapBagPageViewModel");
            f18960a.put(125, "suitId");
            f18960a.put(126, "chatRoomId");
            f18960a.put(127, "packageName");
            f18960a.put(128, PlaceFields.HOURS);
            f18960a.put(129, FirebaseAnalytics.Param.QUANTITY);
            f18960a.put(130, "adsTurntableDialog");
            f18960a.put(131, "enterType");
            f18960a.put(132, "isNew");
            f18960a.put(133, "occupyPosition");
            f18960a.put(134, "VipGcubeGiftOneButtonDialog");
            f18960a.put(135, "regionId");
            f18960a.put(136, "teamId");
            f18960a.put(137, "payChannel");
            f18960a.put(138, "orderField");
            f18960a.put(139, "showEmptyView");
            f18960a.put(140, "item");
            f18960a.put(141, "refreshing");
            f18960a.put(142, "emptyText");
            f18960a.put(143, "loadingMore");
            f18960a.put(144, "PrivilegeDetailViewModel");
            f18960a.put(145, "privilegeCenterViewModel");
            f18960a.put(146, "privilegeDetailPageViewModel");
            f18960a.put(147, "PrivilegeCenterViewModel");
            f18960a.put(148, "PrivilegeDetailPageViewModel");
            f18960a.put(149, "PrivilegeCenterPageViewModel");
            f18960a.put(150, "privilegeCenterPageViewModel");
            f18960a.put(151, "MorePrivilegeItemViewModel");
            f18960a.put(152, "privilegeDetailViewModel");
            f18960a.put(153, "morePrivilegeItemViewModel");
        }
    }

    /* JADX INFO: renamed from: com.sandboxol.vip.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DataBinderMapperImpl.java */
    private static class C0166b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final HashMap<String, Integer> f18961a = new HashMap<>(14);

        static {
            f18961a.put("layout/vip_content_page_detail_type_0", Integer.valueOf(R.layout.vip_content_page_detail_type));
            f18961a.put("layout/vip_content_page_vip_type_0", Integer.valueOf(R.layout.vip_content_page_vip_type));
            f18961a.put("layout/vip_dialog_subscribe_bottom_0", Integer.valueOf(R.layout.vip_dialog_subscribe_bottom));
            f18961a.put("layout/vip_dialog_subscribe_help_0", Integer.valueOf(R.layout.vip_dialog_subscribe_help));
            f18961a.put("layout/vip_dialog_subscribe_rules_0", Integer.valueOf(R.layout.vip_dialog_subscribe_rules));
            f18961a.put("layout/vip_dialog_subscribe_valid_period_help_0", Integer.valueOf(R.layout.vip_dialog_subscribe_valid_period_help));
            f18961a.put("layout/vip_fragment_privilege_center_0", Integer.valueOf(R.layout.vip_fragment_privilege_center));
            f18961a.put("layout/vip_fragment_privilege_detail_0", Integer.valueOf(R.layout.vip_fragment_privilege_detail));
            f18961a.put("layout/vip_list_item_more_privilege_0", Integer.valueOf(R.layout.vip_list_item_more_privilege));
            f18961a.put("layout/vip_list_item_subscribe_bottom_0", Integer.valueOf(R.layout.vip_list_item_subscribe_bottom));
            f18961a.put("layout/vip_list_layout_more_privilege_0", Integer.valueOf(R.layout.vip_list_layout_more_privilege));
            f18961a.put("layout/vip_list_layout_subscribe_bottom_0", Integer.valueOf(R.layout.vip_list_layout_subscribe_bottom));
            f18961a.put("layout/vip_subscribe_vip_list_view_0", Integer.valueOf(R.layout.vip_subscribe_vip_list_view));
            f18961a.put("layout/vip_tab_item_0", Integer.valueOf(R.layout.vip_tab_item));
        }
    }

    static {
        f18959a.put(R.layout.vip_content_page_detail_type, 1);
        f18959a.put(R.layout.vip_content_page_vip_type, 2);
        f18959a.put(R.layout.vip_dialog_subscribe_bottom, 3);
        f18959a.put(R.layout.vip_dialog_subscribe_help, 4);
        f18959a.put(R.layout.vip_dialog_subscribe_rules, 5);
        f18959a.put(R.layout.vip_dialog_subscribe_valid_period_help, 6);
        f18959a.put(R.layout.vip_fragment_privilege_center, 7);
        f18959a.put(R.layout.vip_fragment_privilege_detail, 8);
        f18959a.put(R.layout.vip_list_item_more_privilege, 9);
        f18959a.put(R.layout.vip_list_item_subscribe_bottom, 10);
        f18959a.put(R.layout.vip_list_layout_more_privilege, 11);
        f18959a.put(R.layout.vip_list_layout_subscribe_bottom, 12);
        f18959a.put(R.layout.vip_subscribe_vip_list_view, 13);
        f18959a.put(R.layout.vip_tab_item, 14);
    }

    @Override // androidx.databinding.b
    public List<androidx.databinding.b> collectDependencies() {
        ArrayList arrayList = new ArrayList(6);
        arrayList.add(new androidx.databinding.library.baseAdapters.a());
        arrayList.add(new DataBinderMapperImpl());
        arrayList.add(new com.sandboxol.common.DataBinderMapperImpl());
        arrayList.add(new com.sandboxol.googlepay.b());
        arrayList.add(new com.sandboxol.greendao.b());
        arrayList.add(new com.sandboxol.messager.a());
        return arrayList;
    }

    @Override // androidx.databinding.b
    public String convertBrIdToString(int i) {
        return a.f18960a.get(i);
    }

    @Override // androidx.databinding.b
    public ViewDataBinding getDataBinder(d dVar, View view, int i) {
        int i2 = f18959a.get(i);
        if (i2 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        }
        switch (i2) {
            case 1:
                if ("layout/vip_content_page_detail_type_0".equals(tag)) {
                    return new C2745b(dVar, view);
                }
                throw new IllegalArgumentException("The tag for vip_content_page_detail_type is invalid. Received: " + tag);
            case 2:
                if ("layout/vip_content_page_vip_type_0".equals(tag)) {
                    return new com.sandboxol.vip.b.d(dVar, view);
                }
                throw new IllegalArgumentException("The tag for vip_content_page_vip_type is invalid. Received: " + tag);
            case 3:
                if ("layout/vip_dialog_subscribe_bottom_0".equals(tag)) {
                    return new f(dVar, view);
                }
                throw new IllegalArgumentException("The tag for vip_dialog_subscribe_bottom is invalid. Received: " + tag);
            case 4:
                if ("layout/vip_dialog_subscribe_help_0".equals(tag)) {
                    return new h(dVar, view);
                }
                throw new IllegalArgumentException("The tag for vip_dialog_subscribe_help is invalid. Received: " + tag);
            case 5:
                if ("layout/vip_dialog_subscribe_rules_0".equals(tag)) {
                    return new j(dVar, view);
                }
                throw new IllegalArgumentException("The tag for vip_dialog_subscribe_rules is invalid. Received: " + tag);
            case 6:
                if ("layout/vip_dialog_subscribe_valid_period_help_0".equals(tag)) {
                    return new l(dVar, view);
                }
                throw new IllegalArgumentException("The tag for vip_dialog_subscribe_valid_period_help is invalid. Received: " + tag);
            case 7:
                if ("layout/vip_fragment_privilege_center_0".equals(tag)) {
                    return new n(dVar, view);
                }
                throw new IllegalArgumentException("The tag for vip_fragment_privilege_center is invalid. Received: " + tag);
            case 8:
                if ("layout/vip_fragment_privilege_detail_0".equals(tag)) {
                    return new p(dVar, view);
                }
                throw new IllegalArgumentException("The tag for vip_fragment_privilege_detail is invalid. Received: " + tag);
            case 9:
                if ("layout/vip_list_item_more_privilege_0".equals(tag)) {
                    return new r(dVar, view);
                }
                throw new IllegalArgumentException("The tag for vip_list_item_more_privilege is invalid. Received: " + tag);
            case 10:
                if ("layout/vip_list_item_subscribe_bottom_0".equals(tag)) {
                    return new t(dVar, view);
                }
                throw new IllegalArgumentException("The tag for vip_list_item_subscribe_bottom is invalid. Received: " + tag);
            case 11:
                if ("layout/vip_list_layout_more_privilege_0".equals(tag)) {
                    return new v(dVar, view);
                }
                throw new IllegalArgumentException("The tag for vip_list_layout_more_privilege is invalid. Received: " + tag);
            case 12:
                if ("layout/vip_list_layout_subscribe_bottom_0".equals(tag)) {
                    return new x(dVar, view);
                }
                throw new IllegalArgumentException("The tag for vip_list_layout_subscribe_bottom is invalid. Received: " + tag);
            case 13:
                if ("layout/vip_subscribe_vip_list_view_0".equals(tag)) {
                    return new z(dVar, view);
                }
                throw new IllegalArgumentException("The tag for vip_subscribe_vip_list_view is invalid. Received: " + tag);
            case 14:
                if ("layout/vip_tab_item_0".equals(tag)) {
                    return new B(dVar, view);
                }
                throw new IllegalArgumentException("The tag for vip_tab_item is invalid. Received: " + tag);
            default:
                return null;
        }
    }

    @Override // androidx.databinding.b
    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = C0166b.f18961a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.databinding.b
    public ViewDataBinding getDataBinder(d dVar, View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || f18959a.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
