package com.sandboxol.imchat.web;

import android.content.Context;
import com.sandboxol.center.entity.PartyAuthInfo;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.common.base.web.HttpSubscriber;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.retrofit.RetrofitFactory;
import com.trello.rxlifecycle.ActivityEvent;
import com.trello.rxlifecycle.a;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes4.dex */
public class ChatGameApi {
    private static final IChatGameApi api = (IChatGameApi) RetrofitFactory.httpsCreate(BaseApplication.getApp().getMetaDataBaseUrl(), IChatGameApi.class);

    /* JADX WARN: Multi-variable type inference failed */
    public static void getPartyAuth(Context context, long j, String str, boolean z, OnResponseListener<PartyAuthInfo> onResponseListener) {
        if (context instanceof a) {
            api.getPartyAuth(j, str, z).compose(((a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new HttpSubscriber(onResponseListener));
        } else {
            api.getPartyAuth(j, str, z).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<PartyAuthInfo>>) new HttpSubscriber(onResponseListener));
        }
    }
}
