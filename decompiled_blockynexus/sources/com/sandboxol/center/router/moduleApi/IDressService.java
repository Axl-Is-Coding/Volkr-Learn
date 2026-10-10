package com.sandboxol.center.router.moduleApi;

import android.content.Context;
import android.view.ViewGroup;
import androidx.databinding.ObservableMap;
import com.sandboxol.center.router.moduleInfo.decorate.SingleDressInfo;
import com.sandboxol.common.base.web.OnResponseListener;
import java.util.List;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes3.dex */
public interface IDressService extends IBaseService {
    void changeBackground(String str);

    void changeSex(int i);

    void checkRes(int i, String str, String str2);

    void clothTypes(String str);

    void getFriendUsingList(Context context, long j, OnResponseListener<List<SingleDressInfo>> onResponseListener);

    void getUsingDressList(Context context, OnResponseListener<List<SingleDressInfo>> onResponseListener);

    void getUsingList(Context context);

    void handleOnesies(List<SingleDressInfo> list, ObservableMap<Long, String> observableMap, ObservableMap<Long, String> observableMap2, boolean z);

    void onCreate(Context context);

    void onDestroy();

    void onPauseByGroupView();

    void onPauseByGroupView(ViewGroup viewGroup);

    void onResumeByViewGroup(ViewGroup viewGroup, Action0 action0);

    void reloadActor();

    void setShowUsingDress(boolean z);

    void showShopErrorTip(Context context, int i);

    void startShopActivity(Context context);

    void useClothes(ObservableMap<Long, String> observableMap);
}
