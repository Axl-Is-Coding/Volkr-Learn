package com.sandboxol.videosubmit.web;

import android.content.Context;
import com.sandboxol.center.web.http.AuthTokenHttpSubscriber;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.common.base.web.HttpSubscriber;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.retrofit.RetrofitFactory;
import com.sandboxol.common.utils.CommonHelper;
import com.sandboxol.common.utils.HttpUtils;
import com.sandboxol.videosubmit.entity.BGTubeInfoResponse;
import com.sandboxol.videosubmit.entity.BGTubeMultiLanguageConfig;
import com.sandboxol.videosubmit.entity.BGTubeSignInfoResponse;
import com.sandboxol.videosubmit.entity.LinkInfo;
import com.sandboxol.videosubmit.entity.SignStatusResponse;
import com.trello.rxlifecycle.ActivityEvent;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes4.dex */
public class VideoSubmitApi {
    private static final IVideoSubmitApi api = (IVideoSubmitApi) RetrofitFactory.httpsCreate(BaseApplication.getApp().getMetaDataBaseUrl(), IVideoSubmitApi.class);

    /* JADX WARN: Multi-variable type inference failed */
    public static void getBGTubeConfigInfo(final Context context, final OnResponseListener<BGTubeInfoResponse> onResponseListener) {
        ReplyCommand retryCommand = HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.videosubmit.web.d
            @Override // rx.functions.Action0
            public final void call() {
                VideoSubmitApi.getBGTubeConfigInfo(context, onResponseListener);
            }
        });
        if (context instanceof com.trello.rxlifecycle.a) {
            api.getBGTubeConfigInfo().compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).retry(2L).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
        } else {
            api.getBGTubeConfigInfo().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).retry(2L).subscribe((Subscriber<? super HttpResponse<BGTubeInfoResponse>>) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getBGTubeMultiLanguageConfig(final Context context, final String str, final OnResponseListener<BGTubeMultiLanguageConfig> onResponseListener) {
        ReplyCommand retryCommand = HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.videosubmit.web.b
            @Override // rx.functions.Action0
            public final void call() {
                VideoSubmitApi.getBGTubeMultiLanguageConfig(context, str, onResponseListener);
            }
        });
        if (context instanceof com.trello.rxlifecycle.a) {
            api.getBGTubeMultiLanguageConfig(str, CommonHelper.getUserLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).retry(2L).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
        } else {
            api.getBGTubeMultiLanguageConfig(str, CommonHelper.getUserLanguage()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).retry(2L).subscribe((Subscriber<? super HttpResponse<BGTubeMultiLanguageConfig>>) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getBGTubeSignInfoResponse(final Context context, final String str, final OnResponseListener<BGTubeSignInfoResponse> onResponseListener) {
        ReplyCommand retryCommand = HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.videosubmit.web.a
            @Override // rx.functions.Action0
            public final void call() {
                VideoSubmitApi.getBGTubeSignInfoResponse(context, str, onResponseListener);
            }
        });
        if (context instanceof com.trello.rxlifecycle.a) {
            api.getBGTubeSignInfoResponse(str).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
        } else {
            api.getBGTubeSignInfoResponse(str).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<BGTubeSignInfoResponse>>) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getSignUpStatus(final Context context, final String str, final OnResponseListener<SignStatusResponse> onResponseListener) {
        ReplyCommand retryCommand = HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.videosubmit.web.c
            @Override // rx.functions.Action0
            public final void call() {
                VideoSubmitApi.getSignUpStatus(context, str, onResponseListener);
            }
        });
        if (context instanceof com.trello.rxlifecycle.a) {
            api.getSignUpStatus(str).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
        } else {
            api.getSignUpStatus(str).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<SignStatusResponse>>) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void postSignUp(Context context, String str, String str2, String str3, OnResponseListener onResponseListener) {
        if (context instanceof com.trello.rxlifecycle.a) {
            api.postSignUp(str, str2, str3).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new HttpSubscriber(onResponseListener));
        } else {
            api.postSignUp(str, str2, str3).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse>) new HttpSubscriber(onResponseListener));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void postVideoLink(Context context, LinkInfo linkInfo, String str, OnResponseListener onResponseListener) {
        if (context instanceof com.trello.rxlifecycle.a) {
            api.postVideoLink(linkInfo, str).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new HttpSubscriber(onResponseListener));
        } else {
            api.postVideoLink(linkInfo, str).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse>) new HttpSubscriber(onResponseListener));
        }
    }
}
