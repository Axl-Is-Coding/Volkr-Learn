package com.sandboxol.center.web;

import android.content.Context;
import com.sandboxol.center.entity.ScrapHistoryInfo;
import com.sandboxol.center.entity.ScrapInfoInBackpack;
import com.sandboxol.center.entity.ScrapRequestTargetInfo;
import com.sandboxol.center.entity.ScrapRewardComposeInfo;
import com.sandboxol.center.entity.ScrapRewardDetails;
import com.sandboxol.center.entity.ScrapRewardInfo;
import com.sandboxol.center.entity.ScrapTreasureBoxConfig;
import com.sandboxol.center.entity.ScrapVipInfo;
import com.sandboxol.center.web.http.AuthTokenHttpListSubscriber;
import com.sandboxol.center.web.http.AuthTokenHttpPageSubscriber;
import com.sandboxol.center.web.http.AuthTokenHttpSubscriber;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.retrofit.RetrofitFactory;
import com.sandboxol.common.utils.CommonHelper;
import com.sandboxol.common.utils.HttpUtils;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.trello.rxlifecycle.ActivityEvent;
import java.util.List;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes3.dex */
public class ScrapApi {
    private static final IScrapApi api = (IScrapApi) RetrofitFactory.httpsCreate(BaseApplication.getApp().getMetaDataBaseUrl(), IScrapApi.class);

    public static void askScrap(final Context context, final long j, final String str, final OnResponseListener<Object> onResponseListener) {
        api.askScrap("v2", CommonHelper.getLanguage(), j, str).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<Object>>) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.Z
            @Override // rx.functions.Action0
            public final void call() {
                ScrapApi.askScrap(context, j, str, onResponseListener);
            }
        })));
    }

    public static void combineScrap(final Context context, final String str, final int i, final OnResponseListener<ScrapRewardComposeInfo> onResponseListener) {
        api.postCombineCardReward("v2", CommonHelper.getLanguage(), str, i).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<ScrapRewardComposeInfo>>) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.ea
            @Override // rx.functions.Action0
            public final void call() {
                ScrapApi.combineScrap(context, str, i, onResponseListener);
            }
        })));
    }

    public static void getBackpackInfo(final Context context, final int i, final int i2, final int i3, final OnResponseListener<PageData<ScrapInfoInBackpack>> onResponseListener) {
        api.getBackpackInfo("v2", CommonHelper.getLanguage(), i, i2, i3).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<PageData<ScrapInfoInBackpack>>>) new AuthTokenHttpPageSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.Q
            @Override // rx.functions.Action0
            public final void call() {
                ScrapApi.getBackpackInfo(context, i, i2, i3, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getCombineHistory(final Context context, final int i, final int i2, final OnResponseListener<PageData<ScrapHistoryInfo>> onResponseListener) {
        api.getScrapCombineHistory(CommonHelper.getLanguage(), i, i2).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpPageSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.S
            @Override // rx.functions.Action0
            public final void call() {
                ScrapApi.getCombineHistory(context, i, i2, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getRequestTargetInfo(final Context context, final String str, final int i, final int i2, final OnResponseListener<PageData<ScrapRequestTargetInfo>> onResponseListener) {
        api.getRequestTargetList(CommonHelper.getLanguage(), str, i, i2).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpPageSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.ba
            @Override // rx.functions.Action0
            public final void call() {
                ScrapApi.getRequestTargetInfo(context, str, i, i2, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getRewardValue(final Context context, final OnResponseListener<Integer> onResponseListener) {
        api.getRewardValue().compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.fa
            @Override // rx.functions.Action0
            public final void call() {
                ScrapApi.getRewardValue(context, onResponseListener);
            }
        })));
    }

    public static void getScrapBagValue(final Context context, final OnResponseListener<Integer> onResponseListener) {
        api.getScrapBagValue().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<Integer>>) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.W
            @Override // rx.functions.Action0
            public final void call() {
                ScrapApi.getScrapBagValue(context, onResponseListener);
            }
        })));
    }

    public static void getScrapNum(final Context context, final String str, final OnResponseListener<Integer> onResponseListener) {
        api.getScrapNum(CommonHelper.getLanguage(), str).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<Integer>>) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.V
            @Override // rx.functions.Action0
            public final void call() {
                ScrapApi.getScrapNum(context, str, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getScrapRedPointNum(final Context context, final OnResponseListener<Integer> onResponseListener) {
        api.getCombineNum("v2").compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.aa
            @Override // rx.functions.Action0
            public final void call() {
                ScrapApi.getScrapRedPointNum(context, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getScrapRewardDetails(final Context context, final String str, final OnResponseListener<ScrapRewardDetails> onResponseListener) {
        api.getScrapRewardDetails("v2", CommonHelper.getLanguage(), str).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.T
            @Override // rx.functions.Action0
            public final void call() {
                ScrapApi.getScrapRewardDetails(context, str, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getScrapRewardList(final Context context, final int i, final int i2, final int i3, final OnResponseListener<PageData<ScrapRewardInfo>> onResponseListener) {
        api.getScrapRewardList("v2", CommonHelper.getLanguage(), i, i2, i3).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.da
            @Override // rx.functions.Action0
            public final void call() {
                ScrapApi.getScrapRewardList(context, i, i2, i3, onResponseListener);
            }
        })));
    }

    public static void getScrapRule(final OnResponseListener<List<String>> onResponseListener) {
        api.getScrapRule(CommonHelper.getLanguage()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<List<String>>>) new AuthTokenHttpListSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.ga
            @Override // rx.functions.Action0
            public final void call() {
                ScrapApi.getScrapRule(onResponseListener);
            }
        })));
    }

    public static void getScrapTreasureBoxList(final Context context, final OnResponseListener<ScrapTreasureBoxConfig> onResponseListener) {
        api.getScrapTreasureBoxList("v2", CommonHelper.getLanguage()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<ScrapTreasureBoxConfig>>) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.Y
            @Override // rx.functions.Action0
            public final void call() {
                ScrapApi.getScrapTreasureBoxList(context, onResponseListener);
            }
        })));
    }

    public static void getScrapVipConvertInfo(final String str, final int i, final OnResponseListener<ScrapVipInfo> onResponseListener) {
        api.getScrapVipConvert(CommonHelper.getLanguage(), str, i).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<ScrapVipInfo>>) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.U
            @Override // rx.functions.Action0
            public final void call() {
                ScrapApi.getScrapVipConvertInfo(str, i, onResponseListener);
            }
        })));
    }

    public static void receiveScrap(final Context context, final long j, final String str, final String str2, final OnResponseListener<Object> onResponseListener) {
        api.receiveScrap("v2", CommonHelper.getLanguage(), j, str, str2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<Object>>) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.ca
            @Override // rx.functions.Action0
            public final void call() {
                ScrapApi.receiveScrap(context, j, str, str2, onResponseListener);
            }
        })));
    }

    public static void sendScrap(final Context context, final long j, final String str, final int i, final OnResponseListener<String> onResponseListener) {
        api.sendScrap("v2", CommonHelper.getLanguage(), j, str, i).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<String>>) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.X
            @Override // rx.functions.Action0
            public final void call() {
                ScrapApi.sendScrap(context, j, str, i, onResponseListener);
            }
        })));
    }
}
