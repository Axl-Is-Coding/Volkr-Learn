package com.sandboxol.gameblocky.web;

import android.text.TextUtils;
import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.base.web.RetryWithDelay;
import com.sandboxol.common.retrofit.RetrofitFactory;
import com.sandboxol.common.utils.HttpUtils;
import com.sandboxol.greendao.entity.Dispatch;
import com.sandboxol.greendao.entity.MiniGameToken;
import java.util.Map;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/* JADX INFO: compiled from: BlockyGameApi.java */
/* JADX INFO: loaded from: classes3.dex */
class l extends OnResponseListener<MiniGameToken> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ MiniGameToken[] f17756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Map f17757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f17758c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ long f17759d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ OnResponseListener f17760e;

    l(MiniGameToken[] miniGameTokenArr, Map map, String str, long j, OnResponseListener onResponseListener) {
        this.f17756a = miniGameTokenArr;
        this.f17757b = map;
        this.f17758c = str;
        this.f17759d = j;
        this.f17760e = onResponseListener;
    }

    static /* synthetic */ void a(MiniGameToken[] miniGameTokenArr, HttpResponse httpResponse) {
        if (!httpResponse.isSuccess() || httpResponse.getData() == null) {
            return;
        }
        Dispatch dispatch = (Dispatch) httpResponse.getData();
        dispatch.dispUrl = miniGameTokenArr[0].getDispUrl();
        dispatch.signature = miniGameTokenArr[0].getSignature();
        dispatch.timestamp = miniGameTokenArr[0].getTimestamp();
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        this.f17760e.onError(i, str);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        this.f17760e.onServerError(i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(MiniGameToken miniGameToken) {
        if (miniGameToken == null || TextUtils.isEmpty(miniGameToken.getDispUrl())) {
            this.f17760e.onServerError(429);
            return;
        }
        this.f17756a[0] = miniGameToken;
        this.f17757b.put("rid", Integer.valueOf(miniGameToken.getRegion()));
        this.f17757b.put("attributesJson", this.f17758c);
        if (!TextUtils.isEmpty(miniGameToken.getCountry())) {
            this.f17757b.put("country", miniGameToken.getCountry());
        }
        Observable<HttpResponse<Dispatch>> observableObserveOn = ((IBlockyGameApi) RetrofitFactory.create(miniGameToken.getDispUrl(), IBlockyGameApi.class)).newMiniGameDispatcher(this.f17757b, this.f17759d, miniGameToken.getToken()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final MiniGameToken[] miniGameTokenArr = this.f17756a;
        observableObserveOn.doOnNext(new Action1() { // from class: com.sandboxol.gameblocky.web.c
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                l.a(miniGameTokenArr, (HttpResponse) obj);
            }
        }).doOnNext(new Action1() { // from class: com.sandboxol.gameblocky.web.d
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                HttpUtils.throwException(((HttpResponse) obj).getCode());
            }
        }).retryWhen(new RetryWithDelay(1, 5000)).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<Dispatch>>) new k(this, this.f17760e));
    }
}
