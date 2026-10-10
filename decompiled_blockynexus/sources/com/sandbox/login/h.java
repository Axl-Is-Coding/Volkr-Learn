package com.sandbox.login;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.places.model.PlaceFields;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.sandbox.login.c.A;
import com.sandbox.login.c.B;
import com.sandbox.login.c.C2434b;
import com.sandbox.login.c.C2436d;
import com.sandbox.login.c.C2438f;
import com.sandbox.login.c.C2440h;
import com.sandbox.login.c.C2442j;
import com.sandbox.login.c.C2443k;
import com.sandbox.login.c.D;
import com.sandbox.login.c.E;
import com.sandbox.login.c.G;
import com.sandbox.login.c.I;
import com.sandbox.login.c.J;
import com.sandbox.login.c.L;
import com.sandbox.login.c.m;
import com.sandbox.login.c.o;
import com.sandbox.login.c.q;
import com.sandbox.login.c.s;
import com.sandbox.login.c.u;
import com.sandbox.login.c.w;
import com.sandbox.login.c.y;
import com.sandboxol.center.DataBinderMapperImpl;
import io.rong.imlib.common.RongLibConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: DataBinderMapperImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class h extends androidx.databinding.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SparseIntArray f15909a = new SparseIntArray(17);

    /* JADX INFO: compiled from: DataBinderMapperImpl.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final SparseArray<String> f15910a = new SparseArray<>(138);

        static {
            f15910a.put(0, "_all");
            f15910a.put(1, "videoId");
            f15910a.put(2, "gameTitle");
            f15910a.put(3, "dislikeNumber");
            f15910a.put(4, "featuredPlay");
            f15910a.put(5, "title");
            f15910a.put(6, "evaluateStatus");
            f15910a.put(7, "videoUrl");
            f15910a.put(8, "bannerPic");
            f15910a.put(9, "youtubeUrl");
            f15910a.put(10, "alias");
            f15910a.put(11, "videoTime");
            f15910a.put(12, "tag");
            f15910a.put(13, "gameDetail");
            f15910a.put(14, "gameId");
            f15910a.put(15, "images");
            f15910a.put(16, "nickName");
            f15910a.put(17, "authorInfo");
            f15910a.put(18, "authorId");
            f15910a.put(19, "isPublish");
            f15910a.put(20, "tagName");
            f15910a.put(21, "gameCoverPic");
            f15910a.put(22, "playAmount");
            f15910a.put(23, "videoPic");
            f15910a.put(24, "authorName");
            f15910a.put(25, "authorPicUrl");
            f15910a.put(26, "likeNumber");
            f15910a.put(27, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
            f15910a.put(28, "tribeLevel");
            f15910a.put(29, "appVersion");
            f15910a.put(30, "resourceId");
            f15910a.put(31, "remainingDays");
            f15910a.put(32, "PasswordSettingDialog");
            f15910a.put(33, "seconds");
            f15910a.put(34, "gameName");
            f15910a.put(35, "activityFlag");
            f15910a.put(36, "captainName");
            f15910a.put(37, "price");
            f15910a.put(38, "currentCount");
            f15910a.put(39, "passwordSettingDialog");
            f15910a.put(40, "AdsTurntableDialog");
            f15910a.put(41, "id");
            f15910a.put(42, "vip");
            f15910a.put(43, "tasks");
            f15910a.put(44, "campaignGetIntegralRewardDialog");
            f15910a.put(45, "tribeGolds");
            f15910a.put(46, "expire");
            f15910a.put(47, "TeamInviteDialog");
            f15910a.put(48, "typeId");
            f15910a.put(49, "tribeClanId");
            f15910a.put(50, "teamCount");
            f15910a.put(51, "hasLocalRes");
            f15910a.put(52, "vipGcubeGiftOneButtonDialog");
            f15910a.put(53, "isCreate");
            f15910a.put(54, "currency");
            f15910a.put(55, "isActivity");
            f15910a.put(56, "buySuccess");
            f15910a.put(57, "campaignOneButtonDialog");
            f15910a.put(58, "tribeRole");
            f15910a.put(59, "memberCount");
            f15910a.put(60, "sex");
            f15910a.put(61, "psid");
            f15910a.put(62, "userId");
            f15910a.put(63, "url");
            f15910a.put(64, RongLibConst.KEY_TOKEN);
            f15910a.put(65, "gamePic");
            f15910a.put(66, "CampaignGetIntegralRewardDialog");
            f15910a.put(67, "isUgc");
            f15910a.put(68, "tribeName");
            f15910a.put(69, "blankType");
            f15910a.put(70, "country");
            f15910a.put(71, "isRecommend");
            f15910a.put(72, "isNewEngine");
            f15910a.put(73, "hasPurchase");
            f15910a.put(74, "experience");
            f15910a.put(75, "tribeHead");
            f15910a.put(76, "CampaignOneButtonDialog");
            f15910a.put(77, "picUrl");
            f15910a.put(78, "maxMember");
            f15910a.put(79, "suitPrice");
            f15910a.put(80, "details");
            f15910a.put(81, "organizeTeamUrl");
            f15910a.put(82, "iconUrl");
            f15910a.put(83, "verification");
            f15910a.put(84, "scrapMakeSureDialog");
            f15910a.put(85, "teamInviteDialog");
            f15910a.put(86, "captainId");
            f15910a.put(87, "limitedTimes");
            f15910a.put(88, "minutes");
            f15910a.put(89, "CheckAppVersionDialogViewModel");
            f15910a.put(90, "count");
            f15910a.put(91, "messageId");
            f15910a.put(92, "roomName");
            f15910a.put(93, "signInStatus");
            f15910a.put(94, "checkAppVersionDialogViewModel");
            f15910a.put(95, "AdsGameRewardDialog");
            f15910a.put(96, "scrapNum");
            f15910a.put(97, "name");
            f15910a.put(98, "viewModel");
            f15910a.put(99, "teamType");
            f15910a.put(100, "adsGameRewardDialog");
            f15910a.put(101, "gameType");
            f15910a.put(102, "itemType");
            f15910a.put(103, "releaseTime");
            f15910a.put(104, "show");
            f15910a.put(105, "taskMap");
            f15910a.put(106, "dispUrl");
            f15910a.put(107, "ScrapMakeSureDialog");
            f15910a.put(108, "ViewModel");
            f15910a.put(109, "pmId");
            f15910a.put(110, "maxCount");
            f15910a.put(111, "decorationInfoList");
            f15910a.put(112, "ScrapBagPageViewModel");
            f15910a.put(113, "scrapBagPageViewModel");
            f15910a.put(114, "suitId");
            f15910a.put(115, "chatRoomId");
            f15910a.put(116, "packageName");
            f15910a.put(117, PlaceFields.HOURS);
            f15910a.put(118, FirebaseAnalytics.Param.QUANTITY);
            f15910a.put(119, "adsTurntableDialog");
            f15910a.put(120, "enterType");
            f15910a.put(121, "isNew");
            f15910a.put(122, "occupyPosition");
            f15910a.put(123, "VipGcubeGiftOneButtonDialog");
            f15910a.put(124, "regionId");
            f15910a.put(125, "teamId");
            f15910a.put(126, "payChannel");
            f15910a.put(127, "orderField");
            f15910a.put(128, "showEmptyView");
            f15910a.put(129, "item");
            f15910a.put(130, "refreshing");
            f15910a.put(131, "emptyText");
            f15910a.put(132, "loadingMore");
            f15910a.put(133, "registerStep1ViewModel");
            f15910a.put(134, "registerDialog");
            f15910a.put(135, "RegisterDialog");
            f15910a.put(136, "RegisterStep1ViewModel");
        }
    }

    /* JADX INFO: compiled from: DataBinderMapperImpl.java */
    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final HashMap<String, Integer> f15911a = new HashMap<>(21);

        static {
            f15911a.put("layout/dialog_protocol_0", Integer.valueOf(R.layout.dialog_protocol));
            f15911a.put("layout/login_account_list_item_0", Integer.valueOf(R.layout.login_account_list_item));
            f15911a.put("layout/login_account_list_layout_0", Integer.valueOf(R.layout.login_account_list_layout));
            f15911a.put("layout/login_account_record_item_0", Integer.valueOf(R.layout.login_account_record_item));
            f15911a.put("layout-sw600dp/login_activity_login_0", Integer.valueOf(R.layout.login_activity_login));
            f15911a.put("layout/login_activity_login_0", Integer.valueOf(R.layout.login_activity_login));
            f15911a.put("layout/login_activity_role_make_0", Integer.valueOf(R.layout.login_activity_role_make));
            f15911a.put("layout/login_data_list_view_0", Integer.valueOf(R.layout.login_data_list_view));
            f15911a.put("layout/login_dialog_app_register_finish_0", Integer.valueOf(R.layout.login_dialog_app_register_finish));
            f15911a.put("layout/login_dialog_register_0", Integer.valueOf(R.layout.login_dialog_register));
            f15911a.put("layout/login_fragment_account_record_0", Integer.valueOf(R.layout.login_fragment_account_record));
            f15911a.put("layout/login_fragment_change_password_0", Integer.valueOf(R.layout.login_fragment_change_password));
            f15911a.put("layout/login_fragment_confirm_password_0", Integer.valueOf(R.layout.login_fragment_confirm_password));
            f15911a.put("layout-sw600dp/login_fragment_make_role_0", Integer.valueOf(R.layout.login_fragment_make_role));
            f15911a.put("layout/login_fragment_make_role_0", Integer.valueOf(R.layout.login_fragment_make_role));
            f15911a.put("layout/login_fragment_register_0", Integer.valueOf(R.layout.login_fragment_register));
            f15911a.put("layout-sw600dp/login_fragment_register_0", Integer.valueOf(R.layout.login_fragment_register));
            f15911a.put("layout/login_fragment_set_account_0", Integer.valueOf(R.layout.login_fragment_set_account));
            f15911a.put("layout-sw600dp/login_register_step_1_0", Integer.valueOf(R.layout.login_register_step_1));
            f15911a.put("layout/login_register_step_1_0", Integer.valueOf(R.layout.login_register_step_1));
            f15911a.put("layout/login_relogin_tip_dialog_0", Integer.valueOf(R.layout.login_relogin_tip_dialog));
        }
    }

    static {
        f15909a.put(R.layout.dialog_protocol, 1);
        f15909a.put(R.layout.login_account_list_item, 2);
        f15909a.put(R.layout.login_account_list_layout, 3);
        f15909a.put(R.layout.login_account_record_item, 4);
        f15909a.put(R.layout.login_activity_login, 5);
        f15909a.put(R.layout.login_activity_role_make, 6);
        f15909a.put(R.layout.login_data_list_view, 7);
        f15909a.put(R.layout.login_dialog_app_register_finish, 8);
        f15909a.put(R.layout.login_dialog_register, 9);
        f15909a.put(R.layout.login_fragment_account_record, 10);
        f15909a.put(R.layout.login_fragment_change_password, 11);
        f15909a.put(R.layout.login_fragment_confirm_password, 12);
        f15909a.put(R.layout.login_fragment_make_role, 13);
        f15909a.put(R.layout.login_fragment_register, 14);
        f15909a.put(R.layout.login_fragment_set_account, 15);
        f15909a.put(R.layout.login_register_step_1, 16);
        f15909a.put(R.layout.login_relogin_tip_dialog, 17);
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
        return a.f15910a.get(i);
    }

    @Override // androidx.databinding.b
    public ViewDataBinding getDataBinder(androidx.databinding.d dVar, View view, int i) {
        int i2 = f15909a.get(i);
        if (i2 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        }
        switch (i2) {
            case 1:
                if ("layout/dialog_protocol_0".equals(tag)) {
                    return new C2434b(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_protocol is invalid. Received: " + tag);
            case 2:
                if ("layout/login_account_list_item_0".equals(tag)) {
                    return new C2436d(dVar, view);
                }
                throw new IllegalArgumentException("The tag for login_account_list_item is invalid. Received: " + tag);
            case 3:
                if ("layout/login_account_list_layout_0".equals(tag)) {
                    return new C2438f(dVar, view);
                }
                throw new IllegalArgumentException("The tag for login_account_list_layout is invalid. Received: " + tag);
            case 4:
                if ("layout/login_account_record_item_0".equals(tag)) {
                    return new C2440h(dVar, view);
                }
                throw new IllegalArgumentException("The tag for login_account_record_item is invalid. Received: " + tag);
            case 5:
                if ("layout-sw600dp/login_activity_login_0".equals(tag)) {
                    return new C2443k(dVar, view);
                }
                if ("layout/login_activity_login_0".equals(tag)) {
                    return new C2442j(dVar, view);
                }
                throw new IllegalArgumentException("The tag for login_activity_login is invalid. Received: " + tag);
            case 6:
                if ("layout/login_activity_role_make_0".equals(tag)) {
                    return new m(dVar, view);
                }
                throw new IllegalArgumentException("The tag for login_activity_role_make is invalid. Received: " + tag);
            case 7:
                if ("layout/login_data_list_view_0".equals(tag)) {
                    return new o(dVar, view);
                }
                throw new IllegalArgumentException("The tag for login_data_list_view is invalid. Received: " + tag);
            case 8:
                if ("layout/login_dialog_app_register_finish_0".equals(tag)) {
                    return new q(dVar, view);
                }
                throw new IllegalArgumentException("The tag for login_dialog_app_register_finish is invalid. Received: " + tag);
            case 9:
                if ("layout/login_dialog_register_0".equals(tag)) {
                    return new s(dVar, view);
                }
                throw new IllegalArgumentException("The tag for login_dialog_register is invalid. Received: " + tag);
            case 10:
                if ("layout/login_fragment_account_record_0".equals(tag)) {
                    return new u(dVar, view);
                }
                throw new IllegalArgumentException("The tag for login_fragment_account_record is invalid. Received: " + tag);
            case 11:
                if ("layout/login_fragment_change_password_0".equals(tag)) {
                    return new w(dVar, view);
                }
                throw new IllegalArgumentException("The tag for login_fragment_change_password is invalid. Received: " + tag);
            case 12:
                if ("layout/login_fragment_confirm_password_0".equals(tag)) {
                    return new y(dVar, view);
                }
                throw new IllegalArgumentException("The tag for login_fragment_confirm_password is invalid. Received: " + tag);
            case 13:
                if ("layout-sw600dp/login_fragment_make_role_0".equals(tag)) {
                    return new B(dVar, view);
                }
                if ("layout/login_fragment_make_role_0".equals(tag)) {
                    return new A(dVar, view);
                }
                throw new IllegalArgumentException("The tag for login_fragment_make_role is invalid. Received: " + tag);
            case 14:
                if ("layout/login_fragment_register_0".equals(tag)) {
                    return new D(dVar, view);
                }
                if ("layout-sw600dp/login_fragment_register_0".equals(tag)) {
                    return new E(dVar, view);
                }
                throw new IllegalArgumentException("The tag for login_fragment_register is invalid. Received: " + tag);
            case 15:
                if ("layout/login_fragment_set_account_0".equals(tag)) {
                    return new G(dVar, view);
                }
                throw new IllegalArgumentException("The tag for login_fragment_set_account is invalid. Received: " + tag);
            case 16:
                if ("layout-sw600dp/login_register_step_1_0".equals(tag)) {
                    return new J(dVar, view);
                }
                if ("layout/login_register_step_1_0".equals(tag)) {
                    return new I(dVar, view);
                }
                throw new IllegalArgumentException("The tag for login_register_step_1 is invalid. Received: " + tag);
            case 17:
                if ("layout/login_relogin_tip_dialog_0".equals(tag)) {
                    return new L(dVar, view);
                }
                throw new IllegalArgumentException("The tag for login_relogin_tip_dialog is invalid. Received: " + tag);
            default:
                return null;
        }
    }

    @Override // androidx.databinding.b
    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = b.f15911a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.databinding.b
    public ViewDataBinding getDataBinder(androidx.databinding.d dVar, View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || f15909a.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
