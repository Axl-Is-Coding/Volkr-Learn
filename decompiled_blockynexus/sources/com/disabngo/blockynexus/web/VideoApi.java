package com.disabngo.blockynexus.web;

import android.content.Context;
import com.sandboxol.center.web.http.AuthTokenHttpPageSubscriber;
import com.sandboxol.center.web.http.AuthTokenHttpSubscriber;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.retrofit.RetrofitFactory;
import com.sandboxol.common.utils.CommonHelper;
import com.sandboxol.common.utils.HttpUtils;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.sandboxol.greendao.entity.VideoDetailInfo;
import com.sandboxol.greendao.entity.VideoInfo;
import com.trello.rxlifecycle.ActivityEvent;
import java.util.List;
import java.util.Map;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes3.dex */
public class VideoApi {
    private static final IVideoApi api = (IVideoApi) RetrofitFactory.httpsCreate("https://d32gv25kv9q34j.cloudfront.net", IVideoApi.class);

    /* JADX WARN: Multi-variable type inference failed */
    public static void getMoreVideoByAuthor(final Context context, final int i, final int i2, final List<String> list, final long j, final long j2, final OnResponseListener<PageData<VideoInfo>> onResponseListener) {
        ReplyCommand retryCommand = HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.mb
            @Override // rx.functions.Action0
            public final void call() {
                VideoApi.getMoreVideoByAuthor(context, i, i2, list, j, j2, onResponseListener);
            }
        });
        if (list == null || list.isEmpty()) {
            api.getMoreVideoByAuthor(CommonHelper.getLanguage(), i, i2, j, j2).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpPageSubscriber(onResponseListener, retryCommand));
        } else {
            api.getMoreVideoByAuthor(CommonHelper.getLanguage(), i, i2, list, j, j2).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpPageSubscriber(onResponseListener, retryCommand));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getVideoByTag(final Context context, final int i, final int i2, final String str, final List<String> list, final OnResponseListener<PageData<VideoInfo>> onResponseListener) {
        ReplyCommand retryCommand = HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.hb
            @Override // rx.functions.Action0
            public final void call() {
                VideoApi.getVideoByTag(context, i, i2, str, list, onResponseListener);
            }
        });
        if (list == null || list.isEmpty()) {
            api.getVideoByTag(CommonHelper.getLanguage(), str, i, i2).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpPageSubscriber(onResponseListener, retryCommand));
        } else {
            api.getVideoByTag(CommonHelper.getLanguage(), "tag", i, i2, list).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpPageSubscriber(onResponseListener, retryCommand));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getVideoDetailInfo(final Context context, final long j, final OnResponseListener<VideoDetailInfo> onResponseListener) {
        api.getVideoDetailInfo(CommonHelper.getLanguage(), j).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.lb
            @Override // rx.functions.Action0
            public final void call() {
                VideoApi.getVideoDetailInfo(context, j, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getVideoTagList(final Context context, final OnResponseListener<Map<String, String>> onResponseListener) {
        api.getVideoTagList(CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.gb
            @Override // rx.functions.Action0
            public final void call() {
                VideoApi.getVideoTagList(context, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void postDisLike(final Context context, final long j, final OnResponseListener<Integer> onResponseListener) {
        api.postDisLike(CommonHelper.getLanguage(), j).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.kb
            @Override // rx.functions.Action0
            public final void call() {
                VideoApi.postDisLike(context, j, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void postPlayAmount(final Context context, final long j, final OnResponseListener<Integer> onResponseListener) {
        api.postPlayAmount(CommonHelper.getLanguage(), j).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.jb
            @Override // rx.functions.Action0
            public final void call() {
                VideoApi.postPlayAmount(context, j, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void postPraise(final Context context, final long j, final OnResponseListener<Integer> onResponseListener) {
        api.postPraise(CommonHelper.getLanguage(), j).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.ib
            @Override // rx.functions.Action0
            public final void call() {
                VideoApi.postPraise(context, j, onResponseListener);
            }
        })));
    }
}
