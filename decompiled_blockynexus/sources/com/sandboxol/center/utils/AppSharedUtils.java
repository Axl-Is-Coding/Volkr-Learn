package com.sandboxol.center.utils;

import android.content.Context;
import com.google.gson.reflect.TypeToken;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.AllGameIdInfo;
import com.sandboxol.center.entity.BannerInfo;
import com.sandboxol.center.entity.ChestIntegralReward;
import com.sandboxol.center.entity.DecorationResourcesResponse;
import com.sandboxol.center.entity.FirstTopUp;
import com.sandboxol.center.entity.ProductEntity;
import com.sandboxol.center.entity.VisitorCenter;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.sandboxol.greendao.entity.ChristmasAllRewardInfo;
import com.sandboxol.greendao.entity.Game;
import java.util.ArrayList;
import java.util.List;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes3.dex */
public class AppSharedUtils {
    private static AppSharedUtils instance;
    private Context context;

    private AppSharedUtils(Context context) {
        this.context = context;
    }

    public static AppSharedUtils newInstance() {
        if (instance == null) {
            synchronized (AppSharedUtils.class) {
                if (instance == null) {
                    instance = new AppSharedUtils(BaseApplication.getContext());
                }
            }
        }
        return instance;
    }

    public /* synthetic */ void a(Action0 action0, String str) {
        if (str == null || "".equals(str)) {
            AccountCenter.newInstance();
        } else {
            try {
                ((AccountCenter) new com.google.gson.j().a(str, new TypeToken<AccountCenter>() { // from class: com.sandboxol.center.utils.AppSharedUtils.1
                }.getType())).clone(AccountCenter.newInstance());
            } catch (Exception e2) {
                e2.printStackTrace();
                AccountCenter.newInstance();
            }
        }
        if (action0 != null) {
            action0.call();
        }
    }

    public void getAccountInfo(final Action0 action0) {
        MultiProcessSharedUtils.getString(this.context, "account.info", new Action1() { // from class: com.sandboxol.center.utils.a
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f16340a.a(action0, (String) obj);
            }
        });
    }

    public List<AllGameIdInfo> getAllGameIdInfo() {
        try {
            String string = SharedUtils.getString(this.context, SharedConstant.ALL_GAME_ID_INFO);
            return string != null ? (List) new com.google.gson.j().a(string, new TypeToken<List<AllGameIdInfo>>() { // from class: com.sandboxol.center.utils.AppSharedUtils.9
            }.getType()) : new ArrayList();
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    public List<String> getAllQuickInText() {
        try {
            String string = SharedUtils.getString(this.context, SharedConstant.ALL_QUICK_IN_TEXT);
            return string != null ? (List) new com.google.gson.j().a(string, new TypeToken<List<String>>() { // from class: com.sandboxol.center.utils.AppSharedUtils.10
            }.getType()) : new ArrayList();
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    public List<ChestIntegralReward> getChestStatusList() {
        String string = SharedUtils.getString(this.context, SharedConstant.CHEST_STATUS_INFO, null);
        if (string == null) {
            return new ArrayList();
        }
        try {
            return (List) new com.google.gson.j().a(string, new TypeToken<List<ChestIntegralReward>>() { // from class: com.sandboxol.center.utils.AppSharedUtils.5
            }.getType());
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    public DecorationResourcesResponse getDecorationResourcesResponse() {
        String string = SharedUtils.getString(this.context, SharedConstant.RESOURCES_RESPONSE, null);
        if (string != null) {
            try {
                return (DecorationResourcesResponse) new com.google.gson.j().a(string, new TypeToken<DecorationResourcesResponse>() { // from class: com.sandboxol.center.utils.AppSharedUtils.7
                }.getType());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public FirstTopUp getFirstTopUpInfo() {
        String string = SharedUtils.getString(this.context, "first.top.up.info", null);
        if (string != null) {
            try {
                return (FirstTopUp) new com.google.gson.j().a(string, new TypeToken<FirstTopUp>() { // from class: com.sandboxol.center.utils.AppSharedUtils.4
                }.getType());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public String getFriendString(String str) {
        return SharedUtils.getString(this.context, "friend", AccountCenter.newInstance().userId.get() + str, "");
    }

    public List<BannerInfo> getMoreGameDialogInfo() {
        try {
            String string = SharedUtils.getString(this.context, SharedConstant.MORE_GAME_INFO);
            return string != null ? (List) new com.google.gson.j().a(string, new TypeToken<List<BannerInfo>>() { // from class: com.sandboxol.center.utils.AppSharedUtils.6
            }.getType()) : new ArrayList();
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    public List<ProductEntity> getProductInfo() {
        String string = SharedUtils.getString(this.context, "backup.product.info", null);
        if (string == null) {
            return new ArrayList();
        }
        try {
            return (List) new com.google.gson.j().a(string, new TypeToken<List<ProductEntity>>() { // from class: com.sandboxol.center.utils.AppSharedUtils.3
            }.getType());
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    public List<ChristmasAllRewardInfo> getRewardList() {
        try {
            String string = SharedUtils.getString(this.context, SharedConstant.CHRISTMAS_ALL_REWARD_LIST);
            return string != null ? (List) new com.google.gson.j().a(string, new TypeToken<List<ChristmasAllRewardInfo>>() { // from class: com.sandboxol.center.utils.AppSharedUtils.8
            }.getType()) : new ArrayList();
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    public void getVisitorInfo() {
        String string = SharedUtils.getString(this.context, "visitor.info", null);
        if (string == null) {
            VisitorCenter.setInstance(null);
            return;
        }
        try {
            VisitorCenter.setInstance((VisitorCenter) new com.google.gson.j().a(string, new TypeToken<VisitorCenter>() { // from class: com.sandboxol.center.utils.AppSharedUtils.2
            }.getType()));
        } catch (Exception e2) {
            VisitorCenter.setInstance(null);
            e2.printStackTrace();
        }
    }

    public boolean isEqualsRecommendGame(PageData<Game> pageData, String str) {
        String string = SharedUtils.getString(this.context, SharedConstant.RECOMMEND_GAME_LIST + str, null);
        List<Game> data = pageData.getData();
        if (string == null || data.size() == 0) {
            return false;
        }
        return new com.google.gson.j().a(data).equals(string);
    }

    public void putAccountInfo(String str) {
        MultiProcessSharedUtils.putString(this.context, "account.info", str);
    }

    public void putAllGameIdInfo(List<AllGameIdInfo> list) {
        SharedUtils.putString(this.context, SharedConstant.ALL_GAME_ID_INFO, new com.google.gson.j().a(list));
    }

    public void putAllQuickInText(List<String> list) {
        SharedUtils.putString(this.context, SharedConstant.ALL_QUICK_IN_TEXT, new com.google.gson.j().a(list));
    }

    public void putChestStatusList(List<ChestIntegralReward> list) {
        SharedUtils.putString(this.context, SharedConstant.CHEST_STATUS_INFO, new com.google.gson.j().a(list));
    }

    public void putDecorationResourcesResponse(DecorationResourcesResponse decorationResourcesResponse) {
        SharedUtils.putString(this.context, SharedConstant.RESOURCES_RESPONSE, new com.google.gson.j().a(decorationResourcesResponse));
    }

    public void putFirstTopUpInfo(FirstTopUp firstTopUp) {
        SharedUtils.putString(this.context, "first.top.up.info", new com.google.gson.j().a(firstTopUp));
    }

    public void putFriendString(String str, String str2) {
        SharedUtils.putString(this.context, "friend", AccountCenter.newInstance().userId.get() + str, str2);
    }

    public void putMoreGameDialogInfo(String str) {
        SharedUtils.putString(this.context, SharedConstant.MORE_GAME_INFO, str);
    }

    public void putProductInfo(List<ProductEntity> list) {
        SharedUtils.putString(this.context, "backup.product.info", new com.google.gson.j().a(list));
    }

    public void putRecommendGame(PageData<Game> pageData, String str) {
        List<Game> data = pageData.getData();
        SharedUtils.putString(this.context, SharedConstant.RECOMMEND_GAME_LIST + str, new com.google.gson.j().a(data));
    }

    public void putRewardList(List<ChristmasAllRewardInfo> list) {
        SharedUtils.putString(this.context, SharedConstant.CHRISTMAS_ALL_REWARD_LIST, new com.google.gson.j().a(list));
    }

    public void putVisitorInfo(String str) {
        SharedUtils.putString(this.context, "visitor.info", str);
    }
}
