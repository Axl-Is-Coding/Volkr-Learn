package com.sandboxol.halloween;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.places.model.PlaceFields;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.sandboxol.center.DataBinderMapperImpl;
import com.sandboxol.halloween.b.f;
import com.sandboxol.halloween.b.h;
import com.sandboxol.halloween.b.j;
import com.sandboxol.halloween.b.l;
import com.sandboxol.halloween.b.n;
import com.sandboxol.halloween.b.p;
import com.sandboxol.halloween.b.r;
import com.sandboxol.halloween.b.t;
import io.rong.imlib.common.RongLibConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: DataBinderMapperImpl.java */
/* JADX INFO: loaded from: classes4.dex */
public class b extends androidx.databinding.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SparseIntArray f18580a = new SparseIntArray(10);

    /* JADX INFO: compiled from: DataBinderMapperImpl.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final SparseArray<String> f18581a = new SparseArray<>(134);

        static {
            f18581a.put(0, "_all");
            f18581a.put(1, "videoId");
            f18581a.put(2, "gameTitle");
            f18581a.put(3, "dislikeNumber");
            f18581a.put(4, "featuredPlay");
            f18581a.put(5, "title");
            f18581a.put(6, "evaluateStatus");
            f18581a.put(7, "videoUrl");
            f18581a.put(8, "bannerPic");
            f18581a.put(9, "youtubeUrl");
            f18581a.put(10, "alias");
            f18581a.put(11, "videoTime");
            f18581a.put(12, "tag");
            f18581a.put(13, "gameDetail");
            f18581a.put(14, "gameId");
            f18581a.put(15, "images");
            f18581a.put(16, "nickName");
            f18581a.put(17, "authorInfo");
            f18581a.put(18, "authorId");
            f18581a.put(19, "isPublish");
            f18581a.put(20, "tagName");
            f18581a.put(21, "gameCoverPic");
            f18581a.put(22, "playAmount");
            f18581a.put(23, "videoPic");
            f18581a.put(24, "authorName");
            f18581a.put(25, "authorPicUrl");
            f18581a.put(26, "likeNumber");
            f18581a.put(27, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
            f18581a.put(28, "tribeLevel");
            f18581a.put(29, "appVersion");
            f18581a.put(30, "resourceId");
            f18581a.put(31, "remainingDays");
            f18581a.put(32, "PasswordSettingDialog");
            f18581a.put(33, "seconds");
            f18581a.put(34, "gameName");
            f18581a.put(35, "activityFlag");
            f18581a.put(36, "captainName");
            f18581a.put(37, "price");
            f18581a.put(38, "currentCount");
            f18581a.put(39, "passwordSettingDialog");
            f18581a.put(40, "AdsTurntableDialog");
            f18581a.put(41, "id");
            f18581a.put(42, "vip");
            f18581a.put(43, "tasks");
            f18581a.put(44, "campaignGetIntegralRewardDialog");
            f18581a.put(45, "tribeGolds");
            f18581a.put(46, "expire");
            f18581a.put(47, "TeamInviteDialog");
            f18581a.put(48, "typeId");
            f18581a.put(49, "tribeClanId");
            f18581a.put(50, "teamCount");
            f18581a.put(51, "hasLocalRes");
            f18581a.put(52, "vipGcubeGiftOneButtonDialog");
            f18581a.put(53, "isCreate");
            f18581a.put(54, "currency");
            f18581a.put(55, "isActivity");
            f18581a.put(56, "buySuccess");
            f18581a.put(57, "campaignOneButtonDialog");
            f18581a.put(58, "tribeRole");
            f18581a.put(59, "memberCount");
            f18581a.put(60, "sex");
            f18581a.put(61, "psid");
            f18581a.put(62, "userId");
            f18581a.put(63, "url");
            f18581a.put(64, RongLibConst.KEY_TOKEN);
            f18581a.put(65, "gamePic");
            f18581a.put(66, "CampaignGetIntegralRewardDialog");
            f18581a.put(67, "isUgc");
            f18581a.put(68, "tribeName");
            f18581a.put(69, "blankType");
            f18581a.put(70, "country");
            f18581a.put(71, "isRecommend");
            f18581a.put(72, "isNewEngine");
            f18581a.put(73, "hasPurchase");
            f18581a.put(74, "experience");
            f18581a.put(75, "tribeHead");
            f18581a.put(76, "CampaignOneButtonDialog");
            f18581a.put(77, "picUrl");
            f18581a.put(78, "maxMember");
            f18581a.put(79, "suitPrice");
            f18581a.put(80, "details");
            f18581a.put(81, "organizeTeamUrl");
            f18581a.put(82, "iconUrl");
            f18581a.put(83, "verification");
            f18581a.put(84, "scrapMakeSureDialog");
            f18581a.put(85, "teamInviteDialog");
            f18581a.put(86, "captainId");
            f18581a.put(87, "limitedTimes");
            f18581a.put(88, "minutes");
            f18581a.put(89, "CheckAppVersionDialogViewModel");
            f18581a.put(90, "count");
            f18581a.put(91, "messageId");
            f18581a.put(92, "roomName");
            f18581a.put(93, "signInStatus");
            f18581a.put(94, "checkAppVersionDialogViewModel");
            f18581a.put(95, "AdsGameRewardDialog");
            f18581a.put(96, "scrapNum");
            f18581a.put(97, "name");
            f18581a.put(98, "viewModel");
            f18581a.put(99, "teamType");
            f18581a.put(100, "adsGameRewardDialog");
            f18581a.put(101, "gameType");
            f18581a.put(102, "itemType");
            f18581a.put(103, "releaseTime");
            f18581a.put(104, "show");
            f18581a.put(105, "taskMap");
            f18581a.put(106, "dispUrl");
            f18581a.put(107, "ScrapMakeSureDialog");
            f18581a.put(108, "ViewModel");
            f18581a.put(109, "pmId");
            f18581a.put(110, "maxCount");
            f18581a.put(111, "decorationInfoList");
            f18581a.put(112, "ScrapBagPageViewModel");
            f18581a.put(113, "scrapBagPageViewModel");
            f18581a.put(114, "suitId");
            f18581a.put(115, "chatRoomId");
            f18581a.put(116, "packageName");
            f18581a.put(117, PlaceFields.HOURS);
            f18581a.put(118, FirebaseAnalytics.Param.QUANTITY);
            f18581a.put(119, "adsTurntableDialog");
            f18581a.put(120, "enterType");
            f18581a.put(121, "isNew");
            f18581a.put(122, "occupyPosition");
            f18581a.put(123, "VipGcubeGiftOneButtonDialog");
            f18581a.put(124, "regionId");
            f18581a.put(125, "teamId");
            f18581a.put(126, "payChannel");
            f18581a.put(127, "orderField");
            f18581a.put(128, "showEmptyView");
            f18581a.put(129, "item");
            f18581a.put(130, "refreshing");
            f18581a.put(131, "emptyText");
            f18581a.put(132, "loadingMore");
        }
    }

    /* JADX INFO: renamed from: com.sandboxol.halloween.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DataBinderMapperImpl.java */
    private static class C0154b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final HashMap<String, Integer> f18582a = new HashMap<>(10);

        static {
            f18582a.put("layout/halloween_dialog_currency_0", Integer.valueOf(R.layout.halloween_dialog_currency));
            f18582a.put("layout/halloween_dialog_reward_0", Integer.valueOf(R.layout.halloween_dialog_reward));
            f18582a.put("layout/halloween_dialog_ruler_0", Integer.valueOf(R.layout.halloween_dialog_ruler));
            f18582a.put("layout/halloween_dialog_tips_0", Integer.valueOf(R.layout.halloween_dialog_tips));
            f18582a.put("layout/halloween_fragment_exchange_0", Integer.valueOf(R.layout.halloween_fragment_exchange));
            f18582a.put("layout/halloween_fragment_home_0", Integer.valueOf(R.layout.halloween_fragment_home));
            f18582a.put("layout/halloween_fragment_tasks_0", Integer.valueOf(R.layout.halloween_fragment_tasks));
            f18582a.put("layout/halloween_item_reward_0", Integer.valueOf(R.layout.halloween_item_reward));
            f18582a.put("layout/halloween_item_task_0", Integer.valueOf(R.layout.halloween_item_task));
            f18582a.put("layout/halloween_reward_list_layout_0", Integer.valueOf(R.layout.halloween_reward_list_layout));
        }
    }

    static {
        f18580a.put(R.layout.halloween_dialog_currency, 1);
        f18580a.put(R.layout.halloween_dialog_reward, 2);
        f18580a.put(R.layout.halloween_dialog_ruler, 3);
        f18580a.put(R.layout.halloween_dialog_tips, 4);
        f18580a.put(R.layout.halloween_fragment_exchange, 5);
        f18580a.put(R.layout.halloween_fragment_home, 6);
        f18580a.put(R.layout.halloween_fragment_tasks, 7);
        f18580a.put(R.layout.halloween_item_reward, 8);
        f18580a.put(R.layout.halloween_item_task, 9);
        f18580a.put(R.layout.halloween_reward_list_layout, 10);
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
        return a.f18581a.get(i);
    }

    @Override // androidx.databinding.b
    public ViewDataBinding getDataBinder(androidx.databinding.d dVar, View view, int i) {
        int i2 = f18580a.get(i);
        if (i2 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        }
        switch (i2) {
            case 1:
                if ("layout/halloween_dialog_currency_0".equals(tag)) {
                    return new com.sandboxol.halloween.b.b(dVar, view);
                }
                throw new IllegalArgumentException("The tag for halloween_dialog_currency is invalid. Received: " + tag);
            case 2:
                if ("layout/halloween_dialog_reward_0".equals(tag)) {
                    return new com.sandboxol.halloween.b.d(dVar, view);
                }
                throw new IllegalArgumentException("The tag for halloween_dialog_reward is invalid. Received: " + tag);
            case 3:
                if ("layout/halloween_dialog_ruler_0".equals(tag)) {
                    return new f(dVar, view);
                }
                throw new IllegalArgumentException("The tag for halloween_dialog_ruler is invalid. Received: " + tag);
            case 4:
                if ("layout/halloween_dialog_tips_0".equals(tag)) {
                    return new h(dVar, view);
                }
                throw new IllegalArgumentException("The tag for halloween_dialog_tips is invalid. Received: " + tag);
            case 5:
                if ("layout/halloween_fragment_exchange_0".equals(tag)) {
                    return new j(dVar, view);
                }
                throw new IllegalArgumentException("The tag for halloween_fragment_exchange is invalid. Received: " + tag);
            case 6:
                if ("layout/halloween_fragment_home_0".equals(tag)) {
                    return new l(dVar, view);
                }
                throw new IllegalArgumentException("The tag for halloween_fragment_home is invalid. Received: " + tag);
            case 7:
                if ("layout/halloween_fragment_tasks_0".equals(tag)) {
                    return new n(dVar, view);
                }
                throw new IllegalArgumentException("The tag for halloween_fragment_tasks is invalid. Received: " + tag);
            case 8:
                if ("layout/halloween_item_reward_0".equals(tag)) {
                    return new p(dVar, view);
                }
                throw new IllegalArgumentException("The tag for halloween_item_reward is invalid. Received: " + tag);
            case 9:
                if ("layout/halloween_item_task_0".equals(tag)) {
                    return new r(dVar, view);
                }
                throw new IllegalArgumentException("The tag for halloween_item_task is invalid. Received: " + tag);
            case 10:
                if ("layout/halloween_reward_list_layout_0".equals(tag)) {
                    return new t(dVar, view);
                }
                throw new IllegalArgumentException("The tag for halloween_reward_list_layout is invalid. Received: " + tag);
            default:
                return null;
        }
    }

    @Override // androidx.databinding.b
    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = C0154b.f18582a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.databinding.b
    public ViewDataBinding getDataBinder(androidx.databinding.d dVar, View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || f18580a.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
