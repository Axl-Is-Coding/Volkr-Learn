package com.sandboxol.imchat.web;

import android.content.Context;
import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.common.base.web.HttpSubscriber;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.retrofit.RetrofitFactory;
import com.sandboxol.common.utils.CommonHelper;
import com.trello.rxlifecycle.ActivityEvent;
import com.trello.rxlifecycle.a;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes4.dex */
public class PartyApi {
    /* JADX WARN: Multi-variable type inference failed */
    public static void isPartyExist(Context context, String str, long j, String str2, String str3, OnResponseListener<String> onResponseListener) {
        if (context instanceof a) {
            ((IPartyApi) RetrofitFactory.httpsCreate(str, IPartyApi.class)).isPartyExist(CommonHelper.getLanguage(), str3).compose(((a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new HttpSubscriber(onResponseListener));
        } else {
            ((IPartyApi) RetrofitFactory.httpsCreate(str, IPartyApi.class)).isPartyExist(CommonHelper.getLanguage(), str3).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<String>>) new HttpSubscriber(onResponseListener));
        }
    }
}
