package com.sandboxol.gameblocky.web;

import android.text.TextUtils;
import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.common.base.web.HttpSubscriber;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.retrofit.RetrofitFactory;
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
class n extends OnResponseListener<MiniGameToken> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Map f17761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ MiniGameToken[] f17762b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ long f17763c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ OnResponseListener f17764d;

    n(Map map, MiniGameToken[] miniGameTokenArr, long j, OnResponseListener onResponseListener) {
        this.f17761a = map;
        this.f17762b = miniGameTokenArr;
        this.f17763c = j;
        this.f17764d = onResponseListener;
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
        this.f17764d.onError(i, str);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        this.f17764d.onServerError(i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(MiniGameToken miniGameToken) {
        if (miniGameToken == null || TextUtils.isEmpty(miniGameToken.getDispUrl())) {
            this.f17764d.onServerError(429);
            return;
        }
        this.f17761a.put("rid", Integer.valueOf(miniGameToken.getRegion()));
        this.f17762b[0] = miniGameToken;
        if (!TextUtils.isEmpty(miniGameToken.getCountry())) {
            this.f17761a.put("country", miniGameToken.getCountry());
        }
        Observable<HttpResponse<Dispatch>> observableSubscribeOn = ((IBlockyGameApi) RetrofitFactory.create(miniGameToken.getDispUrl(), IBlockyGameApi.class)).followGame(this.f17761a, this.f17763c, miniGameToken.getToken()).subscribeOn(Schedulers.io());
        final MiniGameToken[] miniGameTokenArr = this.f17762b;
        observableSubscribeOn.doOnNext(new Action1() { // from class: com.sandboxol.gameblocky.web.e
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                n.a(miniGameTokenArr, (HttpResponse) obj);
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<Dispatch>>) new HttpSubscriber(this.f17764d));
    }
}
