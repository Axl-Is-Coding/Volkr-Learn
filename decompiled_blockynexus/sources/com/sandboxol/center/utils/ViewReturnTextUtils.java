package com.sandboxol.center.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.sandboxol.center.R;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.config.VipSubscribeStatus;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.utils.CommonHelper;
import com.sandboxol.greendao.entity.GamePayInfo;
import com.sandboxol.greendao.entity.GameWarmUpResponse;

/* JADX INFO: loaded from: classes3.dex */
public class ViewReturnTextUtils {
    public static Drawable DiamondGoldTribeGold(int i) {
        if (i == 1) {
            return androidx.core.content.b.c(BaseApplication.getContext(), CommonHelper.getResourcesById(BaseApplication.getContext(), "ic_", "diamond_all", "mipmap"));
        }
        if (i == 2) {
            return androidx.core.content.b.c(BaseApplication.getContext(), CommonHelper.getResourcesById(BaseApplication.getContext(), "ic_", StringConstant.MONEY_TYPE_GOLD, "mipmap"));
        }
        if (i == 3) {
            return androidx.core.content.b.c(BaseApplication.getContext(), CommonHelper.getResourcesById(BaseApplication.getContext(), "ic_tribe_", StringConstant.CHRISTMAS_GOLDS, "mipmap"));
        }
        return null;
    }

    public static Drawable TribeLevel(int i) {
        return androidx.core.content.b.c(BaseApplication.getContext(), CommonHelper.getResourcesById(BaseApplication.getContext(), "ic_tribe_level_", String.valueOf(i), "mipmap"));
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.drawable.Drawable adsRewardType(java.lang.String r3) {
        /*
            int r0 = r3.hashCode()
            r1 = 3178592(0x308060, float:4.454156E-39)
            r2 = 1
            if (r0 == r1) goto L1a
            r1 = 1655054676(0x62a62154, float:1.5322805E21)
            if (r0 == r1) goto L10
            goto L24
        L10:
            java.lang.String r0 = "diamond"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L24
            r3 = 1
            goto L25
        L1a:
            java.lang.String r0 = "gold"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L24
            r3 = 0
            goto L25
        L24:
            r3 = -1
        L25:
            if (r3 == 0) goto L3f
            if (r3 == r2) goto L34
            android.content.Context r3 = com.sandboxol.common.base.app.BaseApplication.getContext()
            int r0 = com.sandboxol.center.R.mipmap.ic_gold
            android.graphics.drawable.Drawable r3 = androidx.core.content.b.c(r3, r0)
            return r3
        L34:
            android.content.Context r3 = com.sandboxol.common.base.app.BaseApplication.getContext()
            int r0 = com.sandboxol.center.R.mipmap.ic_diamond
            android.graphics.drawable.Drawable r3 = androidx.core.content.b.c(r3, r0)
            return r3
        L3f:
            android.content.Context r3 = com.sandboxol.common.base.app.BaseApplication.getContext()
            int r0 = com.sandboxol.center.R.mipmap.ic_gold
            android.graphics.drawable.Drawable r3 = androidx.core.content.b.c(r3, r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.center.utils.ViewReturnTextUtils.adsRewardType(java.lang.String):android.graphics.drawable.Drawable");
    }

    public static Drawable authorTeamIcon(GameWarmUpResponse gameWarmUpResponse) {
        return (gameWarmUpResponse == null || gameWarmUpResponse.getAuthorInfo() == null || gameWarmUpResponse.getAuthorInfo().getIsTeam() != 2) ? androidx.core.content.b.c(BaseApplication.getContext(), CommonHelper.getResourcesById(BaseApplication.getContext(), "ic_", "add_friend_btn", "mipmap")) : androidx.core.content.b.c(BaseApplication.getContext(), CommonHelper.getResourcesById(BaseApplication.getContext(), "ic_", "author_list_btn", "mipmap"));
    }

    public static Drawable buyGame(GamePayInfo gamePayInfo) {
        if (gamePayInfo == null) {
            return null;
        }
        if (gamePayInfo.getCurrency() == 1) {
            return androidx.core.content.b.c(BaseApplication.getContext(), CommonHelper.getResourcesById(BaseApplication.getContext(), "ic_", "diamond_all", "mipmap"));
        }
        if (gamePayInfo.getCurrency() == 2) {
            return androidx.core.content.b.c(BaseApplication.getContext(), CommonHelper.getResourcesById(BaseApplication.getContext(), "ic_", StringConstant.MONEY_TYPE_GOLD, "mipmap"));
        }
        return null;
    }

    public static String dailySignInButtonText(boolean z) {
        return BaseApplication.getContext().getString(CommonHelper.getResourcesById(BaseApplication.getContext(), "base_sign_in_", z ? "get" : "has_get", "string"));
    }

    public static String friendListStatus(int i, String str) {
        return i == 30 ? BaseApplication.getContext().getString(R.string.base_friend_status_offline) : i == 10 ? BaseApplication.getContext().getString(R.string.base_friend_status_online) : (i == 8 || i == 9) ? TextUtils.isEmpty(str) ? BaseApplication.getContext().getString(R.string.base_friend_status_gaming) : str : BaseApplication.getContext().getString(R.string.base_friend_status_offline);
    }

    public static int friendListStatusTextColor(int i) {
        return i == 30 ? androidx.core.content.b.a(BaseApplication.getContext(), R.color.base_friend_status_offline) : i == 10 ? androidx.core.content.b.a(BaseApplication.getContext(), R.color.base_friend_status_online) : i == 8 ? androidx.core.content.b.a(BaseApplication.getContext(), R.color.base_friend_status_gaming) : i == 9 ? androidx.core.content.b.a(BaseApplication.getContext(), R.color.base_friend_status_party) : androidx.core.content.b.a(BaseApplication.getContext(), R.color.base_friend_status_offline);
    }

    public static Drawable gameShopBuyGood(int i) {
        if (i == 1) {
            return androidx.core.content.b.c(BaseApplication.getContext(), CommonHelper.getResourcesById(BaseApplication.getContext(), "ic_", "gold_diamond", "mipmap"));
        }
        if (i == 2) {
            return androidx.core.content.b.c(BaseApplication.getContext(), CommonHelper.getResourcesById(BaseApplication.getContext(), "ic_", StringConstant.MONEY_TYPE_GOLD, "mipmap"));
        }
        if (i == 3) {
            return androidx.core.content.b.c(BaseApplication.getContext(), CommonHelper.getResourcesById(BaseApplication.getContext(), "ic_tribe_", StringConstant.CHRISTMAS_GOLDS, "mipmap"));
        }
        return null;
    }

    public static String getCountryAndLanguage(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = "—";
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "—";
        }
        return BaseApplication.getContext().getString(R.string.base_friend_new_come_from, str, str2);
    }

    public static Drawable getDonationHistoryDrawable(int i) {
        switch (i) {
            case 0:
                return androidx.core.content.b.c(BaseApplication.getContext(), CommonHelper.getResourcesById(BaseApplication.getContext(), "ic_", "tribe_task_level_total", "mipmap"));
            case 1:
                return androidx.core.content.b.c(BaseApplication.getContext(), CommonHelper.getResourcesById(BaseApplication.getContext(), "ic_", StringConstant.MONEY_TYPE_DIAMOND, "mipmap"));
            case 2:
                return androidx.core.content.b.c(BaseApplication.getContext(), CommonHelper.getResourcesById(BaseApplication.getContext(), "ic_", StringConstant.MONEY_TYPE_GOLD, "mipmap"));
            case 3:
                return androidx.core.content.b.c(BaseApplication.getContext(), CommonHelper.getResourcesById(BaseApplication.getContext(), "ic_", "tribe_task_level_a", "mipmap"));
            case 4:
                return androidx.core.content.b.c(BaseApplication.getContext(), CommonHelper.getResourcesById(BaseApplication.getContext(), "ic_", "tribe_task_level_b", "mipmap"));
            case 5:
                return androidx.core.content.b.c(BaseApplication.getContext(), CommonHelper.getResourcesById(BaseApplication.getContext(), "ic_", "tribe_task_level_c", "mipmap"));
            case 6:
                return androidx.core.content.b.c(BaseApplication.getContext(), CommonHelper.getResourcesById(BaseApplication.getContext(), "ic_", "tribe_task_level_c", "mipmap"));
            case 7:
                return androidx.core.content.b.c(BaseApplication.getContext(), CommonHelper.getResourcesById(BaseApplication.getContext(), "ic_", "tribe_task_level_s", "mipmap"));
            default:
                return androidx.core.content.b.c(BaseApplication.getContext(), CommonHelper.getResourcesById(BaseApplication.getContext(), "ic_", StringConstant.MONEY_TYPE_GOLD, "mipmap"));
        }
    }

    public static String getDonationHistoryText(int i, int i2) {
        switch (i) {
            case 0:
                return BaseApplication.getContext().getString(R.string.base_tribe_task_all);
            case 1:
            case 2:
                return String.valueOf(i2);
            case 3:
                return BaseApplication.getContext().getString(R.string.base_tribe_task_a);
            case 4:
                return BaseApplication.getContext().getString(R.string.base_tribe_task_b);
            case 5:
                return BaseApplication.getContext().getString(R.string.base_tribe_task_c);
            case 6:
                return BaseApplication.getContext().getString(R.string.base_tribe_task_d);
            case 7:
                return BaseApplication.getContext().getString(R.string.base_tribe_task_s);
            default:
                return "";
        }
    }

    public static String getFriendAge(int i) {
        return i == 0 ? BaseApplication.getContext().getString(R.string.base_friend_new_age, "—") : BaseApplication.getContext().getString(R.string.base_friend_new_age, String.valueOf(i));
    }

    public static Drawable getGameDetailRankBg(int i) {
        if (i == 1) {
            return BaseApplication.getContext().getResources().getDrawable(R.mipmap.ic_game_detail_rank_one);
        }
        if (i == 2) {
            return BaseApplication.getContext().getResources().getDrawable(R.mipmap.ic_game_detail_rank_two);
        }
        if (i != 3) {
            return null;
        }
        return BaseApplication.getContext().getResources().getDrawable(R.mipmap.ic_game_detail_rank_three);
    }

    public static Drawable getNewDonationHistoryDrawable(int i) {
        return i == 1 ? androidx.core.content.b.c(BaseApplication.getContext(), CommonHelper.getResourcesById(BaseApplication.getContext(), "ic_", "diamond_all", "mipmap")) : getDonationHistoryDrawable(i);
    }

    private static String getOfflineDesc(long j) {
        long systemCurrentTime = FriendStatusTimeRecorder.getInstance().getSystemCurrentTime() - j;
        if (systemCurrentTime <= 0) {
            systemCurrentTime = 1;
        }
        long j2 = 86400000;
        long j3 = systemCurrentTime / j2;
        long j4 = systemCurrentTime - (j2 * j3);
        long j5 = 3600000;
        long j6 = j4 / j5;
        long j7 = (j4 - (j5 * j6)) / ((long) 60000);
        return j3 >= 30 ? BaseApplication.getContext().getString(R.string.base_friend_logout_time_month) : j3 > 0 ? BaseApplication.getContext().getString(R.string.base_friend_logout_time_day, String.valueOf(j3)) : j6 > 0 ? BaseApplication.getContext().getString(R.string.base_friend_logout_time_hour, String.valueOf(j6)) : BaseApplication.getContext().getString(R.string.base_friend_logout_time_min, String.valueOf(j7 != 0 ? j7 : 1L));
    }

    public static Drawable getRankingSelected(boolean z) {
        return z ? BaseApplication.getContext().getResources().getDrawable(R.mipmap.icon_up) : BaseApplication.getContext().getResources().getDrawable(R.mipmap.icon_down);
    }

    public static String getRechargeCurrencyText(boolean z, int i) {
        return z ? i == 1 ? BaseApplication.getContext().getString(R.string.Bcube) : BaseApplication.getContext().getString(R.string.gold) : BaseApplication.getContext().getString(R.string.gDiamond);
    }

    public static String getString(int i) {
        return BaseApplication.getContext().getString(i);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.drawable.Drawable getTaskLevelDrawable(java.lang.String r7) {
        /*
            Method dump skipped, instruction units count: 208
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.center.utils.ViewReturnTextUtils.getTaskLevelDrawable(java.lang.String):android.graphics.drawable.Drawable");
    }

    public static Drawable getTaskStatusBg(int i) {
        return (i == 0 || i == 1) ? BaseApplication.getContext().getResources().getDrawable(R.drawable.btn_green_selector) : (i == 2 || i == 3) ? BaseApplication.getContext().getResources().getDrawable(R.drawable.btn_red_select) : BaseApplication.getContext().getResources().getDrawable(R.drawable.btn_green_selector);
    }

    public static boolean getTaskStatusBtnEnable(int i) {
        if (i == 0) {
            return true;
        }
        if (i != 1) {
            return i == 2 || i != 3;
        }
        return false;
    }

    public static String getTaskStatusText(int i) {
        return BaseApplication.getContext().getString(i != 0 ? i != 1 ? i != 2 ? i != 3 ? R.string.base_tribe_task_status_0 : R.string.base_tribe_task_status_3 : R.string.base_tribe_task_status_2 : R.string.base_tribe_task_status_1 : R.string.base_tribe_task_status_0);
    }

    public static String getUserID(long j) {
        return "ID:" + j;
    }

    public static Drawable getVideoDetailDrawableDisLike(int i) {
        return androidx.core.content.b.c(BaseApplication.getContext(), i == 2 ? R.mipmap.app_fragment_video_detail_dislike_enable : R.mipmap.app_fragment_video_detail_dislike_nor);
    }

    public static Drawable getVideoDetailDrawableLike(int i) {
        return androidx.core.content.b.c(BaseApplication.getContext(), i == 1 ? R.mipmap.app_fragment_video_detail_like_enable : R.mipmap.app_fragment_video_detail_like_nor);
    }

    public static Drawable getViewAdsCountBg(boolean z) {
        return androidx.core.content.b.c(BaseApplication.getContext(), z ? R.drawable.ic_friend_red_point : R.drawable.bg_ads_can_view);
    }

    public static Drawable inboxDetailDiamondGold(int i) {
        String str = StringConstant.MONEY_TYPE_GOLD;
        if (i == 1) {
            str = StringConstant.MONEY_TYPE_DIAMOND;
        }
        return androidx.core.content.b.c(BaseApplication.getContext(), CommonHelper.getResourcesById(BaseApplication.getContext(), "item_sign_in_", str, "mipmap"));
    }

    public static Drawable inboxMailIcon(int i) {
        return androidx.core.content.b.c(BaseApplication.getContext(), CommonHelper.getResourcesById(BaseApplication.getContext(), "ic_inbox_mail_", String.valueOf(i), "mipmap"));
    }

    public static String isVipAndNoVipText() {
        Context context;
        int i;
        if (AccountCenter.newInstance().vip.get().intValue() == 0) {
            context = BaseApplication.getContext();
            i = R.string.base_pay_no_vip;
        } else {
            context = BaseApplication.getContext();
            i = R.string.base_pay_is_vip;
        }
        return context.getString(i);
    }

    public static String partyRoomName(int i, int i2) {
        return i + "/" + i2;
    }

    public static Drawable rechargeDiscountIcon(int i) {
        switch (i) {
            case 9:
                return androidx.core.content.b.c(BaseApplication.getContext(), CommonHelper.getResourcesById(BaseApplication.getContext(), "ic_discount_", VipSubscribeStatus.SUBSCRIPTION_PAUSED, "mipmap"));
            case 10:
                return androidx.core.content.b.c(BaseApplication.getContext(), CommonHelper.getResourcesById(BaseApplication.getContext(), "ic_discount_", "20", "mipmap"));
            case 11:
                return androidx.core.content.b.c(BaseApplication.getContext(), CommonHelper.getResourcesById(BaseApplication.getContext(), "ic_discount_", "30", "mipmap"));
            case 12:
                return androidx.core.content.b.c(BaseApplication.getContext(), CommonHelper.getResourcesById(BaseApplication.getContext(), "ic_discount_", "40", "mipmap"));
            default:
                return null;
        }
    }

    public static Drawable returnVipIcon(int i) {
        try {
            return i != 1 ? i != 2 ? i != 3 ? i != 4 ? androidx.core.content.b.c(BaseApplication.getContext(), R.drawable.ic_vip_none) : androidx.core.content.b.c(BaseApplication.getContext(), R.drawable.ic_vip_mvp_plus) : androidx.core.content.b.c(BaseApplication.getContext(), R.drawable.ic_vip_mvp) : androidx.core.content.b.c(BaseApplication.getContext(), R.drawable.ic_vip_vip_up) : androidx.core.content.b.c(BaseApplication.getContext(), R.drawable.ic_vip_vip);
        } catch (Resources.NotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static Drawable rightDrawable(String str) {
        return androidx.core.content.b.c(BaseApplication.getContext(), CommonHelper.getResourcesById(BaseApplication.getContext(), "ic_", str, "mipmap"));
    }

    public static Drawable tribeIsLock(int i) {
        return i == 0 ? androidx.core.content.b.c(BaseApplication.getContext(), R.mipmap.ic_tribe_not_auto_enter) : androidx.core.content.b.c(BaseApplication.getContext(), R.mipmap.ic_tribe_auto_enter);
    }

    public static int tribeMemberListTextColor(int i) {
        return i == 20 ? androidx.core.content.b.a(BaseApplication.getContext(), R.color.base_tribe_chief_bg) : androidx.core.content.b.a(BaseApplication.getContext(), R.color.base_tribe_elder_bg);
    }

    public static String tribeMessageTypeText(int i, String str) {
        switch (i) {
            case 0:
            case 5:
                return str;
            case 1:
                return BaseApplication.getContext().getString(R.string.base_tribe_become_elder);
            case 2:
                return BaseApplication.getContext().getString(R.string.base_tribe_become_chief);
            case 3:
                return BaseApplication.getContext().getString(R.string.base_tribe_removed);
            case 4:
                return BaseApplication.getContext().getString(R.string.base_tribe_removed_myself);
            case 6:
                BaseApplication.getContext().getString(R.string.base_tribe_select_member);
                break;
            case 7:
                break;
            default:
                return "";
        }
        return BaseApplication.getContext().getString(R.string.base_tribe_dissolve);
    }

    public static Drawable userInformationTribeTextBg(int i) {
        return i == 20 ? androidx.core.content.b.c(BaseApplication.getContext(), R.drawable.bg_user_info_chief) : androidx.core.content.b.c(BaseApplication.getContext(), R.drawable.bg_user_info_elder);
    }

    public static Drawable vipFragmentIcon(String str) {
        return androidx.core.content.b.c(BaseApplication.getContext(), CommonHelper.getResourcesById(BaseApplication.getContext(), "", str, "mipmap"));
    }

    public static String vipPayButtonText(int i, int i2) {
        return i < i2 ? i == 0 ? BaseApplication.getContext().getString(R.string.base_vip_pay_open_vip) : BaseApplication.getContext().getString(R.string.base_vip_pay_upgrade_vip) : BaseApplication.getContext().getString(R.string.base_vip_pay_renew_vip);
    }

    public static String vipPayMonthText(int i) {
        return BaseApplication.getContext().getString(R.string.base_vip_pay_month, Integer.valueOf(i));
    }

    public static Drawable vipPrivilegeItemPic(String str) {
        return androidx.core.content.b.c(BaseApplication.getContext(), CommonHelper.getResourcesById(BaseApplication.getContext(), "ic_vip_", str, "drawable"));
    }

    public static String vipPrivilegeItemText(String str) {
        return BaseApplication.getContext().getString(CommonHelper.getResourcesById(BaseApplication.getContext(), "vip_", str, "string"));
    }

    public static String vipTopText() {
        if (AccountCenter.newInstance().vip.get().intValue() == 0) {
            return BaseApplication.getContext().getString(R.string.base_vip_title_text, AccountCenter.newInstance().nickName.get());
        }
        String str = "VIP";
        if (AccountCenter.newInstance().vip.get().intValue() != 1) {
            if (AccountCenter.newInstance().vip.get().intValue() == 2) {
                str = "VIP+";
            } else if (AccountCenter.newInstance().vip.get().intValue() == 3) {
                str = "MVP";
            }
        }
        return BaseApplication.getContext().getString(R.string.base_vip_title_has_vip_text, AccountCenter.newInstance().nickName.get(), str, AccountCenter.newInstance().expireDate.get());
    }

    public static String friendListStatus(int i, String str, long j) {
        if (i == 30) {
            return getOfflineDesc(j);
        }
        if (i == 10) {
            return BaseApplication.getContext().getString(R.string.base_friend_status_online);
        }
        if (i == 8 || i == 9) {
            return TextUtils.isEmpty(str) ? BaseApplication.getContext().getString(R.string.base_friend_status_gaming) : str;
        }
        return BaseApplication.getContext().getString(R.string.base_friend_status_offline);
    }

    public static String friendListStatus(int i) {
        if (i == 30) {
            return BaseApplication.getContext().getString(R.string.base_friend_status_offline);
        }
        if (i == 10) {
            return BaseApplication.getContext().getString(R.string.base_friend_status_online);
        }
        return BaseApplication.getContext().getString(R.string.base_friend_status_offline);
    }
}
