package com.sandboxol.googlepay.billing;

import android.content.Context;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.BuyVipEntity;
import com.sandboxol.center.entity.DailyAdsTaskInfo;
import com.sandboxol.center.entity.FirstTopUp;
import com.sandboxol.center.entity.ProductEntity;
import com.sandboxol.center.entity.RechargeEntity;
import com.sandboxol.center.entity.StarCodeUser;
import com.sandboxol.center.entity.VipSubInfo;
import com.sandboxol.center.router.moduleInfo.ads.AdsChannelControllerWrap;
import com.sandboxol.center.router.moduleInfo.pay.BuyParam;
import com.sandboxol.center.router.moduleInfo.pay.PayRecordInfo;
import com.sandboxol.center.router.moduleInfo.pay.PaySignatureInfo;
import com.sandboxol.center.router.moduleInfo.pay.ThirdPayResponse;
import com.sandboxol.center.router.moduleInfo.pay.VipProductResponse;
import com.sandboxol.center.router.module_application.BaseModuleApp;
import com.sandboxol.center.utils.VipDataManager;
import com.sandboxol.center.web.IUserApi;
import com.sandboxol.center.web.IVipApi;
import com.sandboxol.center.web.http.AuthTokenHttpListSubscriber;
import com.sandboxol.center.web.http.AuthTokenHttpPageSubscriber;
import com.sandboxol.center.web.http.AuthTokenHttpSubscriber;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.retrofit.RetrofitFactory;
import com.sandboxol.common.utils.CommonHelper;
import com.sandboxol.common.utils.HttpUtils;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.trello.rxlifecycle.ActivityEvent;
import java.util.List;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Func2;
import rx.functions.Func4;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes3.dex */
public class PayApi {
    private static final IPayApi api = (IPayApi) RetrofitFactory.httpsCreate(BaseApplication.getApp().getMetaDataBaseUrl(), IPayApi.class);

    /* JADX WARN: Multi-variable type inference failed */
    public static void buySubs(final Context context, final BuyParam buyParam, final StarCodeUser starCodeUser, final OnResponseListener<BuyVipEntity> onResponseListener) {
        ReplyCommand retryCommand = HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.googlepay.billing.u
            @Override // rx.functions.Action0
            public final void call() {
                PayApi.buySubs(context, buyParam, starCodeUser, onResponseListener);
            }
        });
        if (context instanceof com.trello.rxlifecycle.a) {
            api.buySubs(buyParam, StringConstant.CHRISTMAS_REWARD_TYPE_FREE, starCodeUser != null ? starCodeUser.getUserId() : 0L, starCodeUser != null ? starCodeUser.getStarCode() : "").compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).retry(2L).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
        } else {
            api.buySubs(buyParam, StringConstant.CHRISTMAS_REWARD_TYPE_FREE, starCodeUser != null ? starCodeUser.getUserId() : 0L, starCodeUser != null ? starCodeUser.getStarCode() : "").subscribeOn(Schedulers.io()).retry(2L).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<BuyVipEntity>>) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void buyVip(final Context context, final BuyParam buyParam, final StarCodeUser starCodeUser, final OnResponseListener<BuyVipEntity> onResponseListener) {
        ReplyCommand retryCommand = HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.googlepay.billing.y
            @Override // rx.functions.Action0
            public final void call() {
                PayApi.buyVip(context, buyParam, starCodeUser, onResponseListener);
            }
        });
        if (context instanceof com.trello.rxlifecycle.a) {
            api.buyVip(buyParam, StringConstant.CHRISTMAS_REWARD_TYPE_FREE, starCodeUser != null ? starCodeUser.getUserId() : 0L, starCodeUser != null ? starCodeUser.getStarCode() : "").compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).retry(2L).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
        } else {
            api.buyVip(buyParam, StringConstant.CHRISTMAS_REWARD_TYPE_FREE, starCodeUser != null ? starCodeUser.getUserId() : 0L, starCodeUser != null ? starCodeUser.getStarCode() : "").subscribeOn(Schedulers.io()).retry(2L).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<BuyVipEntity>>) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void buyVipExtend(final Context context, final BuyParam buyParam, final StarCodeUser starCodeUser, final OnResponseListener<BuyVipEntity> onResponseListener) {
        ReplyCommand retryCommand = HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.googlepay.billing.A
            @Override // rx.functions.Action0
            public final void call() {
                PayApi.buyVipExtend(context, buyParam, starCodeUser, onResponseListener);
            }
        });
        if (context instanceof com.trello.rxlifecycle.a) {
            api.buyVipExtend(buyParam, StringConstant.CHRISTMAS_REWARD_TYPE_FREE, starCodeUser != null ? starCodeUser.getUserId() : 0L, starCodeUser != null ? starCodeUser.getStarCode() : "").compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).retry(2L).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
        } else {
            api.buyVipExtend(buyParam, StringConstant.CHRISTMAS_REWARD_TYPE_FREE, starCodeUser != null ? starCodeUser.getUserId() : 0L, starCodeUser != null ? starCodeUser.getStarCode() : "").subscribeOn(Schedulers.io()).retry(2L).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<BuyVipEntity>>) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void firstTopUp(final Context context, final OnResponseListener<FirstTopUp> onResponseListener) {
        if (AccountCenter.newInstance().login.get().booleanValue()) {
            ReplyCommand retryCommand = HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.googlepay.billing.C
                @Override // rx.functions.Action0
                public final void call() {
                    PayApi.firstTopUp(context, onResponseListener);
                }
            });
            if (context instanceof com.trello.rxlifecycle.a) {
                api.firstTopReward(CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
            } else {
                api.firstTopReward(CommonHelper.getLanguage()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<FirstTopUp>>) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getPaySignature(final Context context, final OnResponseListener<PaySignatureInfo> onResponseListener) {
        ReplyCommand retryCommand = HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.googlepay.billing.v
            @Override // rx.functions.Action0
            public final void call() {
                PayApi.getPaySignature(context, onResponseListener);
            }
        });
        if (context instanceof com.trello.rxlifecycle.a) {
            api.getPaySignature(CommonHelper.getLanguage(), CommonHelper.getCountry()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
        } else {
            api.getPaySignature(CommonHelper.getLanguage(), CommonHelper.getCountry()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<PaySignatureInfo>>) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void isShowThirdPart(final Context context, final OnResponseListener<Boolean> onResponseListener) {
        ReplyCommand retryCommand = HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.googlepay.billing.w
            @Override // rx.functions.Action0
            public final void call() {
                PayApi.isShowThirdPart(context, onResponseListener);
            }
        });
        if (context instanceof com.trello.rxlifecycle.a) {
            api.isShowThirdPart(CommonHelper.getLanguage(), CommonHelper.getCountry()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
        } else {
            api.isShowThirdPart(CommonHelper.getLanguage(), CommonHelper.getCountry()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<Boolean>>) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void productsList(final Context context, final OnResponseListener<List<ProductEntity>> onResponseListener) {
        ReplyCommand retryCommand = HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.googlepay.billing.t
            @Override // rx.functions.Action0
            public final void call() {
                PayApi.productsList(context, onResponseListener);
            }
        });
        if (context instanceof com.trello.rxlifecycle.a) {
            api.productsList("gcubes", "android").compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).retry(2L).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpListSubscriber(onResponseListener, retryCommand));
        } else {
            api.productsList("gcubes", "android").subscribeOn(Schedulers.io()).retry(2L).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<List<ProductEntity>>>) new AuthTokenHttpListSubscriber(onResponseListener, retryCommand));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void productsListAndAds(final Context context, final OnResponseListener<List<ProductEntity>> onResponseListener) {
        Observable.zip(api.productsList("gcubes", "android").subscribeOn(Schedulers.io()), ((IUserApi) RetrofitFactory.httpsCreate(BaseApplication.getApp().getMetaDataBaseUrl(), IUserApi.class)).getAdsRewardInfo(AccountCenter.newInstance().userId.get().longValue()).subscribeOn(Schedulers.io()), new Func2() { // from class: com.sandboxol.googlepay.billing.m
            @Override // rx.functions.Func2
            public final Object call(Object obj, Object obj2) {
                HttpResponse httpResponse = (HttpResponse) obj;
                PayApi.a(context, httpResponse, (HttpResponse) obj2);
                return httpResponse;
            }
        }).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpListSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.googlepay.billing.z
            @Override // rx.functions.Action0
            public final void call() {
                PayApi.productsListAndAds(context, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void productsListAndAdsAndVipList(final Context context, final OnResponseListener<List<ProductEntity>> onResponseListener) {
        Observable.zip(api.productsList("gcubes", "android").subscribeOn(Schedulers.io()), ((IUserApi) RetrofitFactory.httpsCreate(BaseApplication.getApp().getMetaDataBaseUrl(), IUserApi.class)).getAdsRewardInfo(AccountCenter.newInstance().userId.get().longValue()).subscribeOn(Schedulers.io()), api.vipSubsProductsList("android").subscribeOn(Schedulers.io()), ((IVipApi) RetrofitFactory.httpsCreate(BaseApplication.getApp().getMetaDataBaseUrl(), IVipApi.class)).getSubscribeInfo("android").subscribeOn(Schedulers.io()), new Func4() { // from class: com.sandboxol.googlepay.billing.s
            @Override // rx.functions.Func4
            public final Object call(Object obj, Object obj2, Object obj3, Object obj4) {
                HttpResponse httpResponse = (HttpResponse) obj;
                PayApi.a(context, httpResponse, (HttpResponse) obj2, (HttpResponse) obj3, (HttpResponse) obj4);
                return httpResponse;
            }
        }).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpListSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.googlepay.billing.q
            @Override // rx.functions.Action0
            public final void call() {
                PayApi.productsListAndAdsAndVipList(context, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void recharge(final Context context, final BuyParam buyParam, final StarCodeUser starCodeUser, final OnResponseListener<RechargeEntity> onResponseListener) {
        ReplyCommand retryCommand = HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.googlepay.billing.p
            @Override // rx.functions.Action0
            public final void call() {
                PayApi.recharge(context, buyParam, starCodeUser, onResponseListener);
            }
        });
        if (context instanceof com.trello.rxlifecycle.a) {
            api.recharge(buyParam, StringConstant.CHRISTMAS_REWARD_TYPE_FREE, CommonHelper.getLanguage(), starCodeUser.getUserId(), starCodeUser.getStarCode()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).retry(2L).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
        } else {
            api.recharge(buyParam, StringConstant.CHRISTMAS_REWARD_TYPE_FREE, CommonHelper.getLanguage(), starCodeUser.getUserId(), starCodeUser.getStarCode()).subscribeOn(Schedulers.io()).retry(2L).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<RechargeEntity>>) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void rechargeGift(final Context context, final BuyParam buyParam, final OnResponseListener<RechargeEntity> onResponseListener) {
        ReplyCommand retryCommand = HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.googlepay.billing.D
            @Override // rx.functions.Action0
            public final void call() {
                PayApi.rechargeGift(context, buyParam, onResponseListener);
            }
        });
        if (context instanceof com.trello.rxlifecycle.a) {
            api.recharge(buyParam, BaseModuleApp.getBaseModuleApp().getMetaDataPackageName(), CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
        } else {
            api.recharge(buyParam, BaseModuleApp.getBaseModuleApp().getMetaDataPackageName(), CommonHelper.getLanguage()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<RechargeEntity>>) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void rechargeHistory(final Context context, final int i, final int i2, final OnResponseListener<PageData<PayRecordInfo>> onResponseListener) {
        ReplyCommand retryCommand = HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.googlepay.billing.B
            @Override // rx.functions.Action0
            public final void call() {
                PayApi.rechargeHistory(context, i, i2, onResponseListener);
            }
        });
        if (context instanceof com.trello.rxlifecycle.a) {
            api.rechargeHistory(AccountCenter.newInstance().userId.get().longValue(), i, i2).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpPageSubscriber(onResponseListener, retryCommand));
        } else {
            api.rechargeHistory(AccountCenter.newInstance().userId.get().longValue(), i, i2).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<PageData<PayRecordInfo>>>) new AuthTokenHttpPageSubscriber(onResponseListener, retryCommand));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void showThirdPartPayList(final Context context, final String str, final OnResponseListener<ThirdPayResponse> onResponseListener) {
        ReplyCommand retryCommand = HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.googlepay.billing.o
            @Override // rx.functions.Action0
            public final void call() {
                PayApi.showThirdPartPayList(context, str, onResponseListener);
            }
        });
        if (context instanceof com.trello.rxlifecycle.a) {
            api.showThirdPartPayList(CommonHelper.getCountry(), str).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
        } else {
            api.showThirdPartPayList(CommonHelper.getCountry(), str).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<ThirdPayResponse>>) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void updateMoney(final Context context, final OnResponseListener<RechargeEntity> onResponseListener) {
        ReplyCommand retryCommand = HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.googlepay.billing.r
            @Override // rx.functions.Action0
            public final void call() {
                PayApi.updateMoney(context, onResponseListener);
            }
        });
        if (context instanceof com.trello.rxlifecycle.a) {
            api.updateMoney().compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
        } else {
            api.updateMoney().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<RechargeEntity>>) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void vipProductsList(final Context context, final OnResponseListener<VipProductResponse> onResponseListener) {
        ReplyCommand retryCommand = HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.googlepay.billing.x
            @Override // rx.functions.Action0
            public final void call() {
                PayApi.vipProductsList(context, onResponseListener);
            }
        });
        if (context instanceof com.trello.rxlifecycle.a) {
            api.vipProductsList().compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
        } else {
            api.vipProductsList().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<VipProductResponse>>) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void vipSubsProductsList(final Context context, final OnResponseListener<VipProductResponse> onResponseListener) {
        ReplyCommand retryCommand = HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.googlepay.billing.n
            @Override // rx.functions.Action0
            public final void call() {
                PayApi.vipSubsProductsList(context, onResponseListener);
            }
        });
        if (context instanceof com.trello.rxlifecycle.a) {
            api.vipSubsProductsList("android").compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
        } else {
            api.vipSubsProductsList("android").subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<VipProductResponse>>) new AuthTokenHttpSubscriber(onResponseListener, retryCommand));
        }
    }

    static /* synthetic */ HttpResponse a(Context context, HttpResponse httpResponse, HttpResponse httpResponse2) {
        List list = (List) httpResponse.getData();
        DailyAdsTaskInfo dailyAdsTaskInfo = (DailyAdsTaskInfo) httpResponse2.getData();
        if (dailyAdsTaskInfo != null && list != null && AdsChannelControllerWrap.newInstance().isShowIronAds(context, AdsChannelControllerWrap.newInstance().getAdsCount(), 5)) {
            list.add(0, new ProductEntity(dailyAdsTaskInfo.getQuantity(), true, dailyAdsTaskInfo.getCurrency()));
            httpResponse.setData(list);
        }
        return httpResponse;
    }

    static /* synthetic */ HttpResponse a(Context context, HttpResponse httpResponse, HttpResponse httpResponse2, HttpResponse httpResponse3, HttpResponse httpResponse4) {
        VipDataManager.getInstance().setVipProductResponse((VipProductResponse) httpResponse3.getData());
        VipDataManager.getInstance().setVipSubInfo((VipSubInfo) httpResponse4.getData());
        List list = (List) httpResponse.getData();
        DailyAdsTaskInfo dailyAdsTaskInfo = (DailyAdsTaskInfo) httpResponse2.getData();
        if (dailyAdsTaskInfo != null && list != null && AdsChannelControllerWrap.newInstance().isShowIronAds(context, AdsChannelControllerWrap.newInstance().getAdsCount(), 5)) {
            list.add(0, new ProductEntity(dailyAdsTaskInfo.getQuantity(), true, dailyAdsTaskInfo.getCurrency()));
            httpResponse.setData(list);
        }
        return httpResponse;
    }
}
