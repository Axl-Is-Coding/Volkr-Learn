package com.disabngo.blockynexus.web;

import android.content.Context;
import com.disabngo.blockynexus.entity.MailInfo;
import com.sandboxol.center.web.http.AuthTokenHttpListSubscriber;
import com.sandboxol.center.web.http.AuthTokenHttpSubscriber;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.retrofit.RetrofitFactory;
import com.sandboxol.common.utils.HttpUtils;
import com.trello.rxlifecycle.ActivityEvent;
import java.util.List;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes3.dex */
public class MailBoxApi {
    private static final IMailBoxApi api = (IMailBoxApi) RetrofitFactory.httpsCreate("https://d32gv25kv9q34j.cloudfront.net", IMailBoxApi.class);

    /* JADX WARN: Multi-variable type inference failed */
    public static void getAttachment(final Context context, final long j, final OnResponseListener<String> onResponseListener) {
        api.getAttachment(j).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.ga
            @Override // rx.functions.Action0
            public final void call() {
                MailBoxApi.getAttachment(context, j, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void hasNewEmail(final Context context, final OnResponseListener<Boolean> onResponseListener) {
        api.hasNewEmail().compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.fa
            @Override // rx.functions.Action0
            public final void call() {
                MailBoxApi.hasNewEmail(context, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void mailList(final Context context, final OnResponseListener<List<MailInfo>> onResponseListener) {
        api.mailList().compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpListSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.ia
            @Override // rx.functions.Action0
            public final void call() {
                MailBoxApi.mailList(context, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void mailOperation(final Context context, final int i, final Long[] lArr, final OnResponseListener onResponseListener) {
        api.mailOperation(i, lArr).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.disabngo.blockynexus.web.ha
            @Override // rx.functions.Action0
            public final void call() {
                MailBoxApi.mailOperation(context, i, lArr, onResponseListener);
            }
        })));
    }
}
