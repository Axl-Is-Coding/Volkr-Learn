package com.sandboxol.googlepay.b;

import android.content.Context;
import com.sandboxol.googlepay.R;

/* JADX INFO: compiled from: ViewModelUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static String a(Context context, int i) {
        if (i == 40) {
            return context.getString(R.string.googleplay_recharge_history_top_up_activity);
        }
        if (i == 44) {
            return context.getString(R.string.googleplay_recharge_history_jackpot);
        }
        if (i == 46) {
            return context.getString(R.string.googleplay_recharge_history_dragonball_recharge_tips);
        }
        if (i == 60) {
            return context.getString(R.string.googleplay_recharge_history_buy_suit);
        }
        switch (i) {
            case 1:
                return context.getString(R.string.googleplay_recharge_history_google_pay);
            case 2:
                return context.getString(R.string.googleplay_recharge_history_google_refund);
            case 3:
                return context.getString(R.string.googleplay_recharge_history_buy_dress);
            case 4:
                return context.getString(R.string.googleplay_recharge_history_refund_back_money);
            case 5:
                return context.getString(R.string.googleplay_recharge_history_refund_game_buy_success);
            case 6:
                return context.getString(R.string.googleplay_recharge_history_refund_game_buy_failed);
            case 7:
                return context.getString(R.string.googleplay_recharge_history_google_pay);
            case 8:
                return context.getString(R.string.googleplay_recharge_history_google_refund);
            default:
                switch (i) {
                    case 10:
                        return context.getString(R.string.googleplay_recharge_history_refund_game_reward);
                    case 11:
                        return context.getString(R.string.googleplay_buy_upgrade_vip);
                    case 12:
                        return context.getString(R.string.googleplay_daily_tasks);
                    case 13:
                        return context.getString(R.string.googleplay_email_get_vip_diamonds);
                    case 14:
                        return context.getString(R.string.googleplay_email_watch_ads);
                    case 15:
                        return context.getString(R.string.googleplay_recharge_history_create_tribe);
                    case 16:
                        return context.getString(R.string.googleplay_recharge_history_create_tribe_failed);
                    case 17:
                        return context.getString(R.string.googleplay_recharge_history_tribe_donate);
                    case 18:
                        return context.getString(R.string.googleplay_recharge_history_refresh_task);
                    case 19:
                        return context.getString(R.string.googleplay_recharge_history_activity_gift);
                    case 20:
                        return context.getString(R.string.googleplay_recharge_history_box_gift);
                    case 21:
                        break;
                    case 22:
                        return context.getString(R.string.googleplay_recharge_history_christmas);
                    case 23:
                        return context.getString(R.string.googleplay_recharge_history_game_pay);
                    case 24:
                        return context.getString(R.string.googleplay_recharge_history_dress_ads);
                    case 25:
                        return context.getString(R.string.googleplay_recharge_history_change_name);
                    case 26:
                        return context.getString(R.string.googleplay_recharge_history_invite_gift);
                    case 27:
                        return context.getString(R.string.googleplay_recharge_history_sign_in);
                    case 28:
                        return context.getString(R.string.googleplay_recharge_history_game_settle_accounts);
                    case 29:
                        return context.getString(R.string.googleplay_recharge_history_lucky_block);
                    case 30:
                        return context.getString(R.string.googleplay_group_create_pay);
                    case 31:
                        return context.getString(R.string.googleplay_recharge_history_user_share);
                    default:
                        switch (i) {
                            case 33:
                                return context.getString(R.string.googleplay_recharge_history_finish_user_info);
                            case 34:
                                return context.getString(R.string.googleplay_recharge_history_activity_system);
                            case 35:
                                return context.getString(R.string.googleplay_recharge_history_game_gift);
                            case 36:
                                return context.getString(R.string.googleplay_recharge_history_vip_gift);
                            case 37:
                                return context.getString(R.string.googleplay_recharge_history_create_game_party);
                            default:
                                switch (i) {
                                    case 49:
                                        break;
                                    case 50:
                                        return context.getString(R.string.googleplay_recharge_history_vip_sub_refund);
                                    case 51:
                                        return context.getString(R.string.googleplay_recharge_history_thanksgiving);
                                    case 52:
                                        return context.getString(R.string.googleplay_recharge_history_vip_refund);
                                    default:
                                        return "";
                                }
                                break;
                        }
                        break;
                }
                return context.getString(R.string.googleplay_recharge_history_halloween);
        }
    }
}
