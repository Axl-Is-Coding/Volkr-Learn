package com.sandboxol.center.web;

import android.content.Context;
import android.text.TextUtils;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.AdsTurntableInfo;
import com.sandboxol.center.entity.AllGameIdInfo;
import com.sandboxol.center.entity.AppEngineResourceUpdateResult;
import com.sandboxol.center.entity.AppEngineUpgradeResponse;
import com.sandboxol.center.entity.CampaignRank;
import com.sandboxol.center.entity.ChatRoomResponse;
import com.sandboxol.center.entity.GameDetailShop;
import com.sandboxol.center.entity.GameRankingInfo;
import com.sandboxol.center.entity.GameResInfo;
import com.sandboxol.center.entity.GameUpdateContentInfo;
import com.sandboxol.center.entity.GameWarmUpResponse;
import com.sandboxol.center.entity.PartyCreateGameConfig;
import com.sandboxol.center.entity.RankInfo;
import com.sandboxol.center.entity.ResCheckEntity;
import com.sandboxol.center.entity.SystemAnnouncementInfo;
import com.sandboxol.center.router.moduleInfo.game.EngineEnv;
import com.sandboxol.center.router.module_application.BaseModuleApp;
import com.sandboxol.center.utils.Helper;
import com.sandboxol.center.web.GameApi;
import com.sandboxol.center.web.http.AuthTokenHttpListSubscriber;
import com.sandboxol.center.web.http.AuthTokenHttpPageSubscriber;
import com.sandboxol.center.web.http.AuthTokenHttpSubscriber;
import com.sandboxol.center.web.http.AuthTokenHttpTypePageSubscriber;
import com.sandboxol.center.web.http.LoadingHttpListSubscriber;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.common.base.web.HttpSubscriber;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.base.web.RetryWithDelay;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.retrofit.RetrofitFactory;
import com.sandboxol.common.utils.CommonHelper;
import com.sandboxol.common.utils.HttpUtils;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.sandboxol.common.widget.rv.pagerv.TypePageData;
import com.sandboxol.greendao.entity.AuthorInfo;
import com.sandboxol.greendao.entity.Dispatch;
import com.sandboxol.greendao.entity.Game;
import com.sandboxol.greendao.entity.GamingInfo;
import com.sandboxol.greendao.entity.MiniGameToken;
import com.trello.rxlifecycle.ActivityEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes3.dex */
public class GameApi {
    private static final IGameApi api = (IGameApi) RetrofitFactory.httpsCreate(BaseApplication.getApp().getMetaDataBaseUrl(), IGameApi.class);

    /* JADX INFO: renamed from: com.sandboxol.center.web.GameApi$1, reason: invalid class name */
    static class AnonymousClass1 extends OnResponseListener<MiniGameToken> {
        final /* synthetic */ int val$ever;
        final /* synthetic */ OnResponseListener val$listener;
        final /* synthetic */ MiniGameToken[] val$miniGameToken;
        final /* synthetic */ String val$typeId;

        AnonymousClass1(MiniGameToken[] miniGameTokenArr, String str, int i, OnResponseListener onResponseListener) {
            this.val$miniGameToken = miniGameTokenArr;
            this.val$typeId = str;
            this.val$ever = i;
            this.val$listener = onResponseListener;
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
            this.val$listener.onError(i, str);
        }

        @Override // com.sandboxol.common.base.web.OnResponseListener
        public void onServerError(int i) {
            this.val$listener.onServerError(i);
        }

        @Override // com.sandboxol.common.base.web.OnResponseListener
        public void onSuccess(MiniGameToken miniGameToken) {
            if (miniGameToken == null || TextUtils.isEmpty(miniGameToken.getDispUrl())) {
                this.val$listener.onServerError(429);
                return;
            }
            this.val$miniGameToken[0] = miniGameToken;
            Observable<HttpResponse<MiniGameToken>> observableSubscribeOn = ((IGameApi) RetrofitFactory.create(miniGameToken.getDispUrl(), IGameApi.class)).miniGameMap("", this.val$typeId, this.val$ever).subscribeOn(Schedulers.io());
            final MiniGameToken[] miniGameTokenArr = this.val$miniGameToken;
            observableSubscribeOn.doOnNext(new Action1() { // from class: com.sandboxol.center.web.b
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    GameApi.AnonymousClass1.a(miniGameTokenArr, (HttpResponse) obj);
                }
            }).observeOn(AndroidSchedulers.mainThread()).doOnNext(new Action1() { // from class: com.sandboxol.center.web.c
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    HttpUtils.throwException(((HttpResponse) obj).getCode());
                }
            }).retryWhen(new RetryWithDelay(1, 5000)).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<MiniGameToken>>) new HttpSubscriber<MiniGameToken, HttpResponse<MiniGameToken>>(this.val$listener) { // from class: com.sandboxol.center.web.GameApi.1.1
                @Override // com.sandboxol.common.base.web.HttpSubscriber, com.sandboxol.common.base.web.BaseSubscriber
                public boolean isCheckNetwork() {
                    return true;
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.sandboxol.center.web.GameApi$3, reason: invalid class name */
    static class AnonymousClass3 extends OnResponseListener<MiniGameToken> {
        final /* synthetic */ Context val$context;
        final /* synthetic */ OnResponseListener val$listener;
        final /* synthetic */ Map val$map;
        final /* synthetic */ MiniGameToken[] val$miniGameToken;
        final /* synthetic */ long val$userId;

        AnonymousClass3(MiniGameToken[] miniGameTokenArr, Map map, long j, Context context, OnResponseListener onResponseListener) {
            this.val$miniGameToken = miniGameTokenArr;
            this.val$map = map;
            this.val$userId = j;
            this.val$context = context;
            this.val$listener = onResponseListener;
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
            this.val$listener.onError(i, str);
        }

        @Override // com.sandboxol.common.base.web.OnResponseListener
        public void onServerError(int i) {
            this.val$listener.onServerError(i);
        }

        @Override // com.sandboxol.common.base.web.OnResponseListener
        public void onSuccess(MiniGameToken miniGameToken) {
            if (miniGameToken == null || TextUtils.isEmpty(miniGameToken.getDispUrl())) {
                this.val$listener.onServerError(429);
                return;
            }
            this.val$miniGameToken[0] = miniGameToken;
            this.val$map.put("rid", Integer.valueOf(miniGameToken.getRegion()));
            if (!TextUtils.isEmpty(miniGameToken.getCountry())) {
                this.val$map.put("country", miniGameToken.getCountry());
            }
            Observable observableObserveOn = ((IGameApi) RetrofitFactory.create(miniGameToken.getDispUrl(), IGameApi.class)).newMiniGameDispatcher(this.val$map, this.val$userId, miniGameToken.getToken()).compose(((com.trello.rxlifecycle.a) this.val$context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            final MiniGameToken[] miniGameTokenArr = this.val$miniGameToken;
            observableObserveOn.doOnNext(new Action1() { // from class: com.sandboxol.center.web.e
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    GameApi.AnonymousClass3.a(miniGameTokenArr, (HttpResponse) obj);
                }
            }).doOnNext(new Action1() { // from class: com.sandboxol.center.web.d
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    HttpUtils.throwException(((HttpResponse) obj).getCode());
                }
            }).retryWhen(new RetryWithDelay(1, 5000)).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new HttpSubscriber<Dispatch, HttpResponse<Dispatch>>(this.val$listener) { // from class: com.sandboxol.center.web.GameApi.3.1
                @Override // com.sandboxol.common.base.web.HttpSubscriber, com.sandboxol.common.base.web.BaseSubscriber
                public boolean isCheckNetwork() {
                    return true;
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.sandboxol.center.web.GameApi$6, reason: invalid class name */
    static class AnonymousClass6 extends OnResponseListener<MiniGameToken> {
        final /* synthetic */ Context val$context;
        final /* synthetic */ int val$engineVersion;
        final /* synthetic */ String val$gameType;
        final /* synthetic */ OnResponseListener val$listener;
        final /* synthetic */ int val$resVersion;

        AnonymousClass6(String str, int i, int i2, Context context, OnResponseListener onResponseListener) {
            this.val$gameType = str;
            this.val$engineVersion = i;
            this.val$resVersion = i2;
            this.val$context = context;
            this.val$listener = onResponseListener;
        }

        @Override // com.sandboxol.common.base.web.OnResponseListener
        public void onError(int i, String str) {
            this.val$listener.onError(i, str);
        }

        @Override // com.sandboxol.common.base.web.OnResponseListener
        public void onServerError(int i) {
            this.val$listener.onServerError(i);
        }

        @Override // com.sandboxol.common.base.web.OnResponseListener
        public void onSuccess(MiniGameToken miniGameToken) {
            if (miniGameToken == null || TextUtils.isEmpty(miniGameToken.getDispUrl())) {
                this.val$listener.onServerError(429);
            } else {
                ((IGameApi) RetrofitFactory.create(miniGameToken.getDispUrl(), IGameApi.class)).getResInfo(this.val$gameType, this.val$engineVersion, this.val$resVersion).compose(((com.trello.rxlifecycle.a) this.val$context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).doOnNext(new Action1() { // from class: com.sandboxol.center.web.h
                    @Override // rx.functions.Action1
                    public final void call(Object obj) {
                        HttpUtils.throwException(((HttpResponse) obj).getCode());
                    }
                }).retryWhen(new RetryWithDelay(1, 5000)).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new HttpSubscriber<GameResInfo, HttpResponse<GameResInfo>>(this.val$listener) { // from class: com.sandboxol.center.web.GameApi.6.1
                    @Override // com.sandboxol.common.base.web.HttpSubscriber, com.sandboxol.common.base.web.BaseSubscriber
                    public boolean isCheckNetwork() {
                        return true;
                    }
                });
            }
        }
    }

    /* JADX INFO: renamed from: com.sandboxol.center.web.GameApi$9, reason: invalid class name */
    static class AnonymousClass9 extends OnResponseListener<MiniGameToken> {
        final /* synthetic */ OnResponseListener val$listener;
        final /* synthetic */ Map val$map;
        final /* synthetic */ MiniGameToken[] val$miniGameToken;
        final /* synthetic */ long val$userId;

        AnonymousClass9(Map map, MiniGameToken[] miniGameTokenArr, long j, OnResponseListener onResponseListener) {
            this.val$map = map;
            this.val$miniGameToken = miniGameTokenArr;
            this.val$userId = j;
            this.val$listener = onResponseListener;
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
            this.val$listener.onError(i, str);
        }

        @Override // com.sandboxol.common.base.web.OnResponseListener
        public void onServerError(int i) {
            this.val$listener.onServerError(i);
        }

        @Override // com.sandboxol.common.base.web.OnResponseListener
        public void onSuccess(MiniGameToken miniGameToken) {
            if (miniGameToken == null || TextUtils.isEmpty(miniGameToken.getDispUrl())) {
                this.val$listener.onServerError(429);
                return;
            }
            this.val$map.put("rid", Integer.valueOf(miniGameToken.getRegion()));
            this.val$miniGameToken[0] = miniGameToken;
            if (!TextUtils.isEmpty(miniGameToken.getCountry())) {
                this.val$map.put("country", miniGameToken.getCountry());
            }
            Observable<HttpResponse<Dispatch>> observableSubscribeOn = ((IGameApi) RetrofitFactory.create(miniGameToken.getDispUrl(), IGameApi.class)).followGame(this.val$map, this.val$userId, miniGameToken.getToken()).subscribeOn(Schedulers.io());
            final MiniGameToken[] miniGameTokenArr = this.val$miniGameToken;
            Observable<HttpResponse<Dispatch>> observableObserveOn = observableSubscribeOn.doOnNext(new Action1() { // from class: com.sandboxol.center.web.l
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    GameApi.AnonymousClass9.a(miniGameTokenArr, (HttpResponse) obj);
                }
            }).observeOn(AndroidSchedulers.mainThread());
            final OnResponseListener onResponseListener = this.val$listener;
            observableObserveOn.doOnNext(new Action1() { // from class: com.sandboxol.center.web.k
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    GameApi.AnonymousClass9.a(onResponseListener, (HttpResponse) obj);
                }
            }).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<Dispatch>>) new HttpSubscriber<Dispatch, HttpResponse<Dispatch>>(this.val$listener) { // from class: com.sandboxol.center.web.GameApi.9.1
                @Override // com.sandboxol.common.base.web.HttpSubscriber, com.sandboxol.common.base.web.BaseSubscriber
                public boolean isCheckNetwork() {
                    return true;
                }
            });
        }

        /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
            java.lang.UnsupportedOperationException
            	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1091)
            	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
            	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
            	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
            	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
            	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1116)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
            	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1116)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
            	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
            */
        static /* synthetic */ void a(com.sandboxol.common.base.web.OnResponseListener r2, com.sandboxol.common.base.web.HttpResponse r3) {
            /*
                int r0 = r3.getCode()
                r1 = 2
                if (r0 == r1) goto L11
                switch(r0) {
                    case 10: goto L11;
                    case 11: goto L11;
                    case 12: goto L11;
                    default: goto La;
                }
            La:
                switch(r0) {
                    case 14: goto L11;
                    case 15: goto L11;
                    case 16: goto L11;
                    default: goto Ld;
                }
            Ld:
                switch(r0) {
                    case 2009: goto L11;
                    case 2010: goto L11;
                    case 2011: goto L11;
                    default: goto L10;
                }
            L10:
                goto L1c
            L11:
                int r0 = r3.getCode()
                java.lang.String r3 = r3.getMessage()
                r2.onError(r0, r3)
            L1c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.center.web.GameApi.AnonymousClass9.a(com.sandboxol.common.base.web.OnResponseListener, com.sandboxol.common.base.web.HttpResponse):void");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void appreciation(final Context context, final String str, final OnResponseListener<Integer> onResponseListener) {
        api.appreciation(str).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.r
            @Override // rx.functions.Action0
            public final void call() {
                GameApi.appreciation(context, str, onResponseListener);
            }
        })));
    }

    static /* synthetic */ void b(MiniGameToken miniGameToken, HttpResponse httpResponse) {
        if (!httpResponse.isSuccess() || httpResponse.getData() == null) {
            return;
        }
        Dispatch dispatch = (Dispatch) httpResponse.getData();
        dispatch.dispUrl = miniGameToken.getDispUrl();
        dispatch.signature = miniGameToken.getSignature();
        dispatch.timestamp = miniGameToken.getTimestamp();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void category(final Context context, final int i, final int i2, final String str, final long j, final String str2, final int i3, final OnResponseListener<PageData<Game>> onResponseListener) {
        api.category(i, i2, str, j, str2, 1, CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpPageSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.s
            @Override // rx.functions.Action0
            public final void call() {
                GameApi.category(context, i, i2, str, j, str2, i3, onResponseListener);
            }
        })));
    }

    public static void countUploadVersion(final String str, final int i, final OnResponseListener onResponseListener) {
        api.countUploadVersion(str, i, CommonHelper.getCountry()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse>) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.M
            @Override // rx.functions.Action0
            public final void call() {
                GameApi.countUploadVersion(str, i, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void deleteChatRoom(final Context context, final String str, final OnResponseListener onResponseListener) {
        api.deleteChatRoom(str).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.O
            @Override // rx.functions.Action0
            public final void call() {
                GameApi.deleteChatRoom(context, str, onResponseListener);
            }
        })));
    }

    public static void engine2FollowGameAuth(String str, int i, long j, String str2, OnResponseListener<MiniGameToken> onResponseListener) {
        api.followGameAuth(str, j, i, str2, CommonHelper.getCountry()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<MiniGameToken>>) new HttpSubscriber(onResponseListener));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void followFriendInGameDispatch(Context context, long j, final MiniGameToken miniGameToken, int i, int i2, final OnResponseListener<Dispatch> onResponseListener) {
        long jLongValue = AccountCenter.newInstance().userId.get().longValue();
        String str = AccountCenter.newInstance().nickName.get();
        HashMap map = new HashMap();
        map.put("clz", 0);
        map.put("pioneer", true);
        map.put("userId", Long.valueOf(jLongValue));
        map.put("name", str);
        map.put("picUrl", AccountCenter.newInstance().picUrl.get());
        map.put("packageName", BaseModuleApp.getBaseModuleApp().getMetaDataPackageName());
        map.put("appVer", BaseApplication.getApp().getMetaDataAppVersion() + "");
        map.put("country", CommonHelper.getCountry());
        map.put("lang", CommonHelper.getUserLanguage());
        map.put("resVersion", Integer.valueOf(i));
        map.put("ever", Integer.valueOf(i2));
        map.put("targetId", Long.valueOf(j));
        map.put("rid", Integer.valueOf(miniGameToken.getRegion()));
        if (!TextUtils.isEmpty(miniGameToken.getCountry())) {
            map.put("country", miniGameToken.getCountry());
        }
        ((IGameApi) RetrofitFactory.create(miniGameToken.getDispUrl(), IGameApi.class)).followGame(map, jLongValue, miniGameToken.getToken()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).doOnNext(new Action1() { // from class: com.sandboxol.center.web.P
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                GameApi.a(miniGameToken, (HttpResponse) obj);
            }
        }).observeOn(AndroidSchedulers.mainThread()).doOnNext(new Action1() { // from class: com.sandboxol.center.web.x
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                GameApi.a(onResponseListener, (HttpResponse) obj);
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new HttpSubscriber<Dispatch, HttpResponse<Dispatch>>(onResponseListener) { // from class: com.sandboxol.center.web.GameApi.11
            @Override // com.sandboxol.common.base.web.HttpSubscriber, com.sandboxol.common.base.web.BaseSubscriber
            public boolean isCheckNetwork() {
                return true;
            }
        });
    }

    public static void followGame(int i, String str, long j, GamingInfo gamingInfo, OnResponseListener<Dispatch> onResponseListener) {
        long jLongValue = AccountCenter.newInstance().userId.get().longValue();
        String str2 = AccountCenter.newInstance().nickName.get();
        MiniGameToken[] miniGameTokenArr = new MiniGameToken[1];
        HashMap map = new HashMap();
        map.put("userId", Long.valueOf(jLongValue));
        map.put("name", str2);
        map.put("picUrl", AccountCenter.newInstance().picUrl.get());
        map.put("packageName", BaseModuleApp.getBaseModuleApp().getMetaDataPackageName());
        map.put("appVer", BaseApplication.getApp().getMetaDataAppVersion() + "");
        map.put("country", CommonHelper.getCountry());
        map.put("lang", CommonHelper.getUserLanguage());
        map.put("ever", Integer.valueOf(i));
        map.put("targetId", Long.valueOf(j));
        if (!TextUtils.isEmpty(gamingInfo.getRoomAddr())) {
            map.put("roomAddr", gamingInfo.getRoomAddr());
        }
        if (!TextUtils.isEmpty(gamingInfo.getGameInstanceId())) {
            map.put("gameId", gamingInfo.getGameInstanceId());
        }
        String regionId = TextUtils.isEmpty(gamingInfo.getRegionId()) ? "" : gamingInfo.getRegionId();
        map.put("isPrivate", Boolean.valueOf(gamingInfo.getIsPrivateParty() == 1));
        map.put("appVer", String.valueOf(gamingInfo.getAppVersion()));
        api.followGameAuth(str, j, i, regionId, CommonHelper.getCountry()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<MiniGameToken>>) new HttpSubscriber<MiniGameToken, HttpResponse<MiniGameToken>>(new AnonymousClass9(map, miniGameTokenArr, jLongValue, onResponseListener)) { // from class: com.sandboxol.center.web.GameApi.10
            @Override // com.sandboxol.common.base.web.HttpSubscriber, com.sandboxol.common.base.web.BaseSubscriber
            public boolean isCheckNetwork() {
                return true;
            }
        });
    }

    public static void gameDetail(Context context, String str, long j, OnResponseListener<Game> onResponseListener) {
        api.gameDetail(str, BaseApplication.getApp().getMetaDataAppVersion(), CommonHelper.getLanguage(), j).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<Game>>) new HttpSubscriber(onResponseListener));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void gamePreheat(final Context context, final String str, final OnResponseListener<GameWarmUpResponse> onResponseListener) {
        api.gamePreheat(str, CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.K
            @Override // rx.functions.Action0
            public final void call() {
                GameApi.gamePreheat(context, str, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getAdsGameDouble(final Context context, final OnResponseListener<Long> onResponseListener) {
        api.getAdsGameDouble(CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).retry(2L).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.y
            @Override // rx.functions.Action0
            public final void call() {
                GameApi.getAdsGameDouble(context, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getAdsTurnHaveReward(final Context context, final String str, final OnResponseListener<String> onResponseListener) {
        api.getAdsTurnHaveReward(str, CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.L
            @Override // rx.functions.Action0
            public final void call() {
                GameApi.getAdsTurnHaveReward(context, str, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getAdsTurntableInfo(final Context context, final String str, final OnResponseListener<List<AdsTurntableInfo>> onResponseListener) {
        api.getAdsTurntableInfo(str, CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new LoadingHttpListSubscriber(context, onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.I
            @Override // rx.functions.Action0
            public final void call() {
                GameApi.getAdsTurntableInfo(context, str, onResponseListener);
            }
        }), true));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getAdsTurntableReward(final Context context, final String str, final OnResponseListener<Long> onResponseListener) {
        api.getAdsTurntableReward(str, CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.p
            @Override // rx.functions.Action0
            public final void call() {
                GameApi.getAdsTurntableReward(context, str, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getAllGameIdInfo(final Context context, final OnResponseListener<List<AllGameIdInfo>> onResponseListener) {
        HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.G
            @Override // rx.functions.Action0
            public final void call() {
                GameApi.getAllGameIdInfo(context, onResponseListener);
            }
        });
        api.getAllGameIdInfo(CommonHelper.getLanguage(), BaseApplication.getApp().getMetaDataAppVersion()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new HttpSubscriber(onResponseListener));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getAuthorList(final Context context, final long j, final OnResponseListener<List<AuthorInfo>> onResponseListener) {
        api.getAuthorList(j, CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpListSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.a
            @Override // rx.functions.Action0
            public final void call() {
                GameApi.getAuthorList(context, j, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getChatRoomId(final Context context, final String str, final OnResponseListener<ChatRoomResponse> onResponseListener) {
        api.getChatRoom(str).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.w
            @Override // rx.functions.Action0
            public final void call() {
                GameApi.getChatRoomId(context, str, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getGameDetailShop(final Context context, final String str, final int i, final OnResponseListener<List<GameDetailShop>> onResponseListener) {
        api.getGameDetailShop(AccountCenter.newInstance().userId.get().longValue(), AccountCenter.newInstance().token.get(), CommonHelper.getLanguage(), str, i).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpListSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.B
            @Override // rx.functions.Action0
            public final void call() {
                GameApi.getGameDetailShop(context, str, i, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static void getGameListByCondition(final Context context, final String str, final long j, final int i, final int i2, final OnResponseListener<TypePageData<Game>> onResponseListener) {
        api.getGameListByCondition(CommonHelper.getLanguage(), Helper.isBelowKitKat() ? 1 : 0, str, j, i, i2, "android").compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpTypePageSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.v
            @Override // rx.functions.Action0
            public final void call() {
                GameApi.getGameListByCondition(context, str, j, i, i2, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static void getGameListGuessYouLike(final Context context, final OnResponseListener<List<Game>> onResponseListener) {
        api.getGameListGuessYouLike(CommonHelper.getLanguage(), Helper.isBelowKitKat() ? 1 : 0, "android").compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpListSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.H
            @Override // rx.functions.Action0
            public final void call() {
                GameApi.getGameListGuessYouLike(context, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static void getGameListMore(final Context context, final int i, final int i2, final OnResponseListener<PageData<Game>> onResponseListener) {
        api.getGameListMore(CommonHelper.getLanguage(), Helper.isBelowKitKat() ? 1 : 0, "android", i, i2).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpPageSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.m
            @Override // rx.functions.Action0
            public final void call() {
                GameApi.getGameListMore(context, i, i2, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getGameMyRank(final Context context, final String str, final String str2, final OnResponseListener<CampaignRank> onResponseListener) {
        api.getGameMyRank(CommonHelper.getLanguage(), str2, str).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.C
            @Override // rx.functions.Action0
            public final void call() {
                GameApi.getGameMyRank(context, str, str2, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getGameRank(Context context, String str, String str2, int i, int i2, OnResponseListener<RankInfo<CampaignRank>> onResponseListener) {
        api.getGameRank(CommonHelper.getLanguage(), str2, str, i, i2).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new HttpSubscriber(onResponseListener));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getGameResInfo(Context context, String str, int i, int i2, OnResponseListener<GameResInfo> onResponseListener) {
        api.miniGameToken(str, AccountCenter.newInstance().userId.get().longValue(), i, CommonHelper.getCountry()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new HttpSubscriber<MiniGameToken, HttpResponse<MiniGameToken>>(new AnonymousClass6(str, i, i2, context, onResponseListener)) { // from class: com.sandboxol.center.web.GameApi.7
            @Override // com.sandboxol.common.base.web.HttpSubscriber, com.sandboxol.common.base.web.BaseSubscriber
            public boolean isCheckNetwork() {
                return true;
            }
        });
    }

    public static void getGameResource(final Context context, final long j, final long j2, final String str, final String str2, final String str3, final OnResponseListener<List<AppEngineResourceUpdateResult>> onResponseListener) {
        long j3 = SharedUtils.getLong(context, SharedConstant.ENGINE_V1_COMMON_RES_VERSION);
        if ("v2".equals(str2)) {
            j3 = SharedUtils.getLong(context, SharedConstant.ENGINE_V2_COMMON_RES_VERSION);
        } else if ("v3".equals(str2)) {
            j3 = SharedUtils.getLong(context, SharedConstant.ENGINE_V3_COMMON_RES_VERSION);
        }
        ReplyCommand retryCommand = HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.z
            @Override // rx.functions.Action0
            public final void call() {
                GameApi.getGameResource(context, j, j2, str, str2, str3, onResponseListener);
            }
        });
        api.getGameResource(j, j3, j2, str, str2, CommonHelper.getLanguage()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<List<AppEngineResourceUpdateResult>>>) new AuthTokenHttpListSubscriber(onResponseListener, retryCommand));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getGameTypeList(final Context context, final OnResponseListener<List<GameRankingInfo>> onResponseListener) {
        api.getGameTypeList(CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.n
            @Override // rx.functions.Action0
            public final void call() {
                GameApi.getGameTypeList(context, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getGameUpdateContent(final Context context, final Game game, final OnResponseListener<GameUpdateContentInfo> onResponseListener) {
        api.getGameUpdateContent(game.getGameId(), CommonHelper.getLanguage(), (int) EngineEnv.getEngineVersion(game.getIsNewEngine(), game.getIsUgc()), game.getIsNewEngine()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.A
            @Override // rx.functions.Action0
            public final void call() {
                GameApi.getGameUpdateContent(context, game, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getGameUpdateContentList(final Context context, final OnResponseListener<Map<String, Integer>> onResponseListener) {
        api.getGameUpdateContentList(AccountCenter.newInstance().userId.get().longValue(), CommonHelper.getLanguage(), (int) EngineEnv.v1().getEngineVersion(), (int) EngineEnv.v2().getEngineVersion()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.f
            @Override // rx.functions.Action0
            public final void call() {
                GameApi.getGameUpdateContentList(context, onResponseListener);
            }
        })));
    }

    public static void getGameUpgradeInfo(final Context context, final String str, final long j, final OnResponseListener<AppEngineUpgradeResponse> onResponseListener) {
        api.getUpgradeInfo(EngineEnv.v1().getEngineVersion(), j, str, CommonHelper.getLanguage()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<AppEngineUpgradeResponse>>) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.i
            @Override // rx.functions.Action0
            public final void call() {
                GameApi.getGameUpgradeInfo(context, str, j, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getMiniGameDispatch(Context context, String str, int i, int i2, OnResponseListener<Dispatch> onResponseListener) {
        long jLongValue = AccountCenter.newInstance().userId.get().longValue();
        String str2 = AccountCenter.newInstance().nickName.get();
        HashMap map = new HashMap();
        map.put("clz", 0);
        map.put("name", str2);
        map.put("pioneer", true);
        map.put("targetId", Long.valueOf(jLongValue));
        map.put("resVersion", Integer.valueOf(i));
        map.put("ever", Integer.valueOf(i2));
        map.put("picUrl", AccountCenter.newInstance().picUrl.get());
        map.put("packageName", BaseModuleApp.getBaseModuleApp().getMetaDataPackageName());
        map.put("appVer", BaseApplication.getApp().getMetaDataAppVersion() + "");
        map.put("country", CommonHelper.getCountry());
        map.put("lang", CommonHelper.getUserLanguage());
        api.miniGameToken(str, jLongValue, i2, CommonHelper.getCountry()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new HttpSubscriber<MiniGameToken, HttpResponse<MiniGameToken>>(new AnonymousClass3(new MiniGameToken[1], map, jLongValue, context, onResponseListener)) { // from class: com.sandboxol.center.web.GameApi.4
            @Override // com.sandboxol.common.base.web.HttpSubscriber, com.sandboxol.common.base.web.BaseSubscriber
            public boolean isCheckNetwork() {
                return true;
            }
        });
    }

    public static void getMiniGameMap(int i, String str, OnResponseListener<MiniGameToken> onResponseListener) {
        api.miniGameToken(str, AccountCenter.newInstance().userId.get().longValue(), i, CommonHelper.getCountry()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<MiniGameToken>>) new HttpSubscriber<MiniGameToken, HttpResponse<MiniGameToken>>(new AnonymousClass1(new MiniGameToken[1], str, i, onResponseListener)) { // from class: com.sandboxol.center.web.GameApi.2
            @Override // com.sandboxol.common.base.web.HttpSubscriber, com.sandboxol.common.base.web.BaseSubscriber
            public boolean isCheckNetwork() {
                return true;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getMiniGameToken(final Context context, final String str, final int i, final OnResponseListener<MiniGameToken> onResponseListener) {
        api.miniGameToken(str, AccountCenter.newInstance().userId.get().longValue(), i, CommonHelper.getCountry()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.j
            @Override // rx.functions.Action0
            public final void call() {
                GameApi.getTeamMiniGameToken(context, str, i, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getPartyCreateGameConfig(final Context context, final String str, final OnResponseListener<PartyCreateGameConfig> onResponseListener) {
        api.getPartyCreateGameConfig(str, CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.o
            @Override // rx.functions.Action0
            public final void call() {
                GameApi.getPartyCreateGameConfig(context, str, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getStopServiceAnnouncementInfo(final Context context, final OnResponseListener<SystemAnnouncementInfo> onResponseListener) {
        api.getStopServiceAnnouncementInfo(CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.J
            @Override // rx.functions.Action0
            public final void call() {
                GameApi.getStopServiceAnnouncementInfo(context, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getTeamMiniGameToken(final Context context, final String str, final int i, final OnResponseListener<MiniGameToken> onResponseListener) {
        api.miniGameToken(str, AccountCenter.newInstance().userId.get().longValue(), i, CommonHelper.getCountry()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.F
            @Override // rx.functions.Action0
            public final void call() {
                GameApi.getTeamMiniGameToken(context, str, i, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void getUpgradeInfo(final Context context, final String str, final long j, final OnResponseListener<AppEngineUpgradeResponse> onResponseListener) {
        api.getUpgradeInfo(EngineEnv.v1().getEngineVersion(), j, str, CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.g
            @Override // rx.functions.Action0
            public final void call() {
                GameApi.getUpgradeInfo(context, str, j, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void miniGameDetail(final Context context, final String str, final OnResponseListener<Game> onResponseListener) {
        api.miniGameDetail(str, CommonHelper.getLanguage()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.N
            @Override // rx.functions.Action0
            public final void call() {
                GameApi.miniGameDetail(context, str, onResponseListener);
            }
        })));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void onGetGameDispatch(Context context, final MiniGameToken miniGameToken, int i, int i2, OnResponseListener<Dispatch> onResponseListener) {
        long jLongValue = AccountCenter.newInstance().userId.get().longValue();
        String str = AccountCenter.newInstance().nickName.get();
        HashMap map = new HashMap();
        map.put("clz", 0);
        map.put("name", str);
        map.put("pioneer", true);
        map.put("targetId", Long.valueOf(jLongValue));
        map.put("resVersion", Integer.valueOf(i));
        map.put("ever", Integer.valueOf(i2));
        map.put("picUrl", AccountCenter.newInstance().picUrl.get());
        map.put("packageName", BaseModuleApp.getBaseModuleApp().getMetaDataPackageName());
        map.put("appVer", BaseApplication.getApp().getMetaDataAppVersion() + "");
        map.put("country", CommonHelper.getCountry());
        map.put("lang", CommonHelper.getUserLanguage());
        map.put("rid", Integer.valueOf(miniGameToken.getRegion()));
        if (!TextUtils.isEmpty(miniGameToken.getCountry())) {
            map.put("country", miniGameToken.getCountry());
        }
        ((IGameApi) RetrofitFactory.create(miniGameToken.getDispUrl(), IGameApi.class)).newMiniGameDispatcher(map, jLongValue, miniGameToken.getToken()).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).doOnNext(new Action1() { // from class: com.sandboxol.center.web.E
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                GameApi.b(miniGameToken, (HttpResponse) obj);
            }
        }).doOnNext(new Action1() { // from class: com.sandboxol.center.web.q
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                HttpUtils.throwException(((HttpResponse) obj).getCode());
            }
        }).retryWhen(new RetryWithDelay(1, 5000)).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new HttpSubscriber<Dispatch, HttpResponse<Dispatch>>(onResponseListener) { // from class: com.sandboxol.center.web.GameApi.5
            @Override // com.sandboxol.common.base.web.HttpSubscriber, com.sandboxol.common.base.web.BaseSubscriber
            public boolean isCheckNetwork() {
                return true;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void onGetGameResInfo(Context context, MiniGameToken miniGameToken, String str, int i, int i2, OnResponseListener<GameResInfo> onResponseListener) {
        if (TextUtils.isEmpty(miniGameToken.getDispUrl())) {
            onResponseListener.onServerError(429);
        } else {
            ((IGameApi) RetrofitFactory.create(miniGameToken.getDispUrl(), IGameApi.class)).getResInfo(str, i, i2).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).doOnNext(new Action1() { // from class: com.sandboxol.center.web.u
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    HttpUtils.throwException(((HttpResponse) obj).getCode());
                }
            }).retryWhen(new RetryWithDelay(1, 5000)).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new HttpSubscriber<GameResInfo, HttpResponse<GameResInfo>>(onResponseListener) { // from class: com.sandboxol.center.web.GameApi.8
                @Override // com.sandboxol.common.base.web.HttpSubscriber, com.sandboxol.common.base.web.BaseSubscriber
                public boolean isCheckNetwork() {
                    return true;
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static void recentlyPlayList(final Context context, final OnResponseListener<List<Game>> onResponseListener) {
        api.recentlyPlayList(CommonHelper.getLanguage(), Helper.isBelowKitKat() ? 1 : 0).compose(((com.trello.rxlifecycle.a) context).bindUntilEvent(ActivityEvent.DESTROY)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new AuthTokenHttpListSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.D
            @Override // rx.functions.Action0
            public final void call() {
                GameApi.recentlyPlayList(context, onResponseListener);
            }
        })));
    }

    public static void resCheck(final int i, final OnResponseListener<ResCheckEntity> onResponseListener) {
        api.resCheck(i, "armeabi-v7a").subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<ResCheckEntity>>) new AuthTokenHttpSubscriber(onResponseListener, HttpUtils.getRetryCommand(onResponseListener, new Action0() { // from class: com.sandboxol.center.web.t
            @Override // rx.functions.Action0
            public final void call() {
                GameApi.resCheck(i, onResponseListener);
            }
        })));
    }

    static /* synthetic */ void a(MiniGameToken miniGameToken, HttpResponse httpResponse) {
        if (!httpResponse.isSuccess() || httpResponse.getData() == null) {
            return;
        }
        Dispatch dispatch = (Dispatch) httpResponse.getData();
        dispatch.dispUrl = miniGameToken.getDispUrl();
        dispatch.signature = miniGameToken.getSignature();
        dispatch.timestamp = miniGameToken.getTimestamp();
    }

    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1091)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1116)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1116)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    static /* synthetic */ void a(com.sandboxol.common.base.web.OnResponseListener r2, com.sandboxol.common.base.web.HttpResponse r3) {
        /*
            int r0 = r3.getCode()
            r1 = 2
            if (r0 == r1) goto L11
            switch(r0) {
                case 10: goto L11;
                case 11: goto L11;
                case 12: goto L11;
                default: goto La;
            }
        La:
            switch(r0) {
                case 14: goto L11;
                case 15: goto L11;
                case 16: goto L11;
                default: goto Ld;
            }
        Ld:
            switch(r0) {
                case 2009: goto L11;
                case 2010: goto L11;
                case 2011: goto L11;
                default: goto L10;
            }
        L10:
            goto L1c
        L11:
            int r0 = r3.getCode()
            java.lang.String r3 = r3.getMessage()
            r2.onError(r0, r3)
        L1c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.center.web.GameApi.a(com.sandboxol.common.base.web.OnResponseListener, com.sandboxol.common.base.web.HttpResponse):void");
    }
}
