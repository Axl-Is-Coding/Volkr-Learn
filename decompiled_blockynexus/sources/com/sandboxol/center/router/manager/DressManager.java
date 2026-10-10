package com.sandboxol.center.router.manager;

import android.content.Context;
import android.view.ViewGroup;
import androidx.databinding.ObservableMap;
import com.sandboxol.center.router.RouteServiceManager;
import com.sandboxol.center.router.moduleApi.IDressService;
import com.sandboxol.center.router.moduleInfo.decorate.SingleDressInfo;
import com.sandboxol.center.router.path.RouterServicePath;
import com.sandboxol.common.base.web.OnResponseListener;
import java.util.List;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes.dex */
public class DressManager {
    private static IDressService iDressService = (IDressService) RouteServiceManager.provide(RouterServicePath.EventDress.DRESS_SERVICE);

    public static void changeBackground(String str) {
        IDressService iDressService2 = iDressService;
        if (iDressService2 != null) {
            iDressService2.changeBackground(str);
        }
    }

    public static void changeSex(int i) {
        IDressService iDressService2 = iDressService;
        if (iDressService2 != null) {
            iDressService2.changeSex(i);
        }
    }

    public static void checkRes(int i, String str, String str2) {
        IDressService iDressService2 = iDressService;
        if (iDressService2 != null) {
            iDressService2.checkRes(i, str, str2);
        }
    }

    public static void clothTypes(String str) {
        IDressService iDressService2 = iDressService;
        if (iDressService2 != null) {
            iDressService2.clothTypes(str);
        }
    }

    public static void getFriendUsingList(Context context, long j, OnResponseListener<List<SingleDressInfo>> onResponseListener) {
        IDressService iDressService2 = iDressService;
        if (iDressService2 != null) {
            iDressService2.getFriendUsingList(context, j, onResponseListener);
        }
    }

    public static void getUsingDressList(Context context, OnResponseListener<List<SingleDressInfo>> onResponseListener) {
        IDressService iDressService2 = iDressService;
        if (iDressService2 != null) {
            iDressService2.getUsingDressList(context, onResponseListener);
        }
    }

    public static void getUsingList(Context context) {
        IDressService iDressService2 = iDressService;
        if (iDressService2 != null) {
            iDressService2.getUsingList(context);
        }
    }

    public static void handleOnesies(List<SingleDressInfo> list, ObservableMap<Long, String> observableMap, ObservableMap<Long, String> observableMap2, boolean z) {
        IDressService iDressService2 = iDressService;
        if (iDressService2 != null) {
            iDressService2.handleOnesies(list, observableMap, observableMap2, z);
        }
    }

    public static void onCreate(Context context) {
        IDressService iDressService2 = iDressService;
        if (iDressService2 != null) {
            iDressService2.onCreate(context);
        }
    }

    public static void onDestroy() {
        IDressService iDressService2 = iDressService;
        if (iDressService2 != null) {
            iDressService2.onDestroy();
        }
    }

    public static void onPauseByGroupView(ViewGroup viewGroup) {
        IDressService iDressService2 = iDressService;
        if (iDressService2 != null) {
            iDressService2.onPauseByGroupView(viewGroup);
        }
    }

    public static void onResumeByViewGroup(ViewGroup viewGroup, Action0 action0) {
        IDressService iDressService2 = iDressService;
        if (iDressService2 != null) {
            iDressService2.onResumeByViewGroup(viewGroup, action0);
        }
    }

    public static void reloadActor() {
        IDressService iDressService2 = iDressService;
        if (iDressService2 != null) {
            iDressService2.reloadActor();
        }
    }

    public static void setShowUsingDress(boolean z) {
        IDressService iDressService2 = iDressService;
        if (iDressService2 != null) {
            iDressService2.setShowUsingDress(z);
        }
    }

    public static void showShopErrorTip(Context context, int i) {
        IDressService iDressService2 = iDressService;
        if (iDressService2 != null) {
            iDressService2.showShopErrorTip(context, i);
        }
    }

    public static void startShopActivity(Context context) {
        IDressService iDressService2 = iDressService;
        if (iDressService2 != null) {
            iDressService2.startShopActivity(context);
        }
    }

    public static void useClothes(ObservableMap<Long, String> observableMap) {
        IDressService iDressService2 = iDressService;
        if (iDressService2 != null) {
            iDressService2.useClothes(observableMap);
        }
    }

    public static void onPauseByGroupView() {
        IDressService iDressService2 = iDressService;
        if (iDressService2 != null) {
            iDressService2.onPauseByGroupView();
        }
    }
}
