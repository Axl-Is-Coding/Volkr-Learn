package com.sandboxol.gameblocky.web;

import android.text.TextUtils;
import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.base.web.RetryWithDelay;
import com.sandboxol.common.retrofit.RetrofitFactory;
import com.sandboxol.common.utils.HttpUtils;
import com.sandboxol.greendao.entity.MiniGameToken;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/* JADX INFO: compiled from: BlockyGameApi.java */
/* JADX INFO: loaded from: classes3.dex */
class h extends OnResponseListener<MiniGameToken> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ MiniGameToken[] f17750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f17751b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f17752c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ long f17753d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ OnResponseListener f17754e;

    h(MiniGameToken[] miniGameTokenArr, String str, String str2, long j, OnResponseListener onResponseListener) {
        this.f17750a = miniGameTokenArr;
        this.f17751b = str;
        this.f17752c = str2;
        this.f17753d = j;
        this.f17754e = onResponseListener;
    }

    static /* synthetic */ void a(MiniGameToken[] miniGameTokenArr, HttpResponse httpResponse) {
        if (!httpResponse.isSuccess() || httpResponse.getData() == null) {
            return;
        }
        miniGameTokenArr[0].setMapName(((MiniGameToken) httpResponse.getData()).getMapName());
        miniGameTokenArr[0].setDownloadUrl(((MiniGameToken) httpResponse.getData()).getDownloadUrl());
        httpResponse.setData(miniGameTokenArr[0]);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        this.f17754e.onError(i, str);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        this.f17754e.onServerError(i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(MiniGameToken miniGameToken) {
        if (miniGameToken == null || TextUtils.isEmpty(miniGameToken.getDispUrl())) {
            this.f17754e.onServerError(429);
            return;
        }
        this.f17750a[0] = miniGameToken;
        Observable<HttpResponse<MiniGameToken>> observableSubscribeOn = ((IBlockyGameApi) RetrofitFactory.create(miniGameToken.getDispUrl(), IBlockyGameApi.class)).miniGameMap(this.f17751b, this.f17752c, this.f17753d).subscribeOn(Schedulers.io());
        final MiniGameToken[] miniGameTokenArr = this.f17750a;
        observableSubscribeOn.doOnNext(new Action1() { // from class: com.sandboxol.gameblocky.web.b
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                h.a(miniGameTokenArr, (HttpResponse) obj);
            }
        }).observeOn(AndroidSchedulers.mainThread()).doOnNext(new Action1() { // from class: com.sandboxol.gameblocky.web.a
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                HttpUtils.throwException(((HttpResponse) obj).getCode());
            }
        }).retryWhen(new RetryWithDelay(1, 5000)).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<MiniGameToken>>) new g(this, this.f17754e));
    }
}
