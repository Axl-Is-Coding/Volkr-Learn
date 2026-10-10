package com.disabngo.blockynexus.c;

import android.content.Context;
import android.content.Intent;
import com.disabngo.blockynexus.entity.FriendActivityIntentInfo;
import com.disabngo.blockynexus.view.activity.friends.FriendInfoActivity;
import com.disabngo.blockynexus.view.activity.tribeshop.TribeShopActivity;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.entity.TribeCenter;
import com.sandboxol.center.router.manager.DressManager;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.greendao.entity.Friend;

/* JADX INFO: compiled from: DressActivityManger.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public static void a(Context context, FriendActivityIntentInfo friendActivityIntentInfo, Friend friend) {
        Intent intent = new Intent();
        intent.setClass(context, FriendInfoActivity.class);
        intent.putExtra("friend.info", friendActivityIntentInfo);
        intent.putExtra("friend.data", friend);
        context.startActivity(intent);
    }

    public static void b(Context context) {
        Intent intent = new Intent();
        intent.setClass(context, TribeShopActivity.class);
        intent.putExtra("tribe.golds.count", TribeCenter.newInstance().tribeGolds.get());
        intent.putExtra("tribe.level", TribeCenter.newInstance().tribeLevel.get());
        context.startActivity(intent);
    }

    public static void a(Context context, FriendActivityIntentInfo friendActivityIntentInfo, Friend friend, int i) {
        Intent intent = new Intent();
        intent.setClass(context, FriendInfoActivity.class);
        intent.putExtra("friend.info", friendActivityIntentInfo);
        intent.putExtra("friend.data", friend);
        intent.putExtra(StringConstant.FROM_PAGE, i);
        context.startActivity(intent);
    }

    public static void a(Context context) {
        DressManager.startShopActivity(context);
        ReportDataAdapter.onEvent(context, EventConstant.DRESS_SHOP_TOTAL);
    }
}
