package com.sandboxol.center.router.moduleInfo.pay;

import com.sandboxol.center.router.module_application.BaseModuleApp;

/* JADX INFO: loaded from: classes3.dex */
public interface BroadcastType {
    public static final String BROADCAST_REFRESH_DRESS_SHOP_LIST = BaseModuleApp.getBaseModuleApp().getApplicationId() + ".refresh.shop.list";
    public static final String BROADCAST_ENTER_FRIEND_CHAT = BaseModuleApp.getBaseModuleApp().getApplicationId() + ".enter.friend.chat";
    public static final String BROADCAST_CLOSE_LOADING_DIALOG = BaseModuleApp.getBaseModuleApp().getApplicationId() + ".close.loading.dialog";
    public static final String BROADCAST_REFRESH_FRIEND_LIST = BaseModuleApp.getBaseModuleApp().getApplicationId() + ".refresh.friend.list";
    public static final String BROADCAST_REFRESH_FRIEND_APPLY_LIST = BaseModuleApp.getBaseModuleApp().getApplicationId() + ".refresh.friend.apply.list";
    public static final String BROADCAST_REFRESH_TRIBE_SHOP_LIST = BaseModuleApp.getBaseModuleApp().getApplicationId() + ".refresh.tribe.shop.list";
    public static final String BROADCAST_FRIEND_MATCH_PERFECT_USER_INFO = BaseModuleApp.getBaseModuleApp().getApplicationId() + ".friend.match.perfect.user.info";
    public static final String BROADCAST_FRIEND_HIDE_DRESS_LOADING = BaseModuleApp.getBaseModuleApp().getApplicationId() + ".hide.dress.loading";
}
