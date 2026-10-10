package com.sandboxol.gameblocky.web;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.router.moduleInfo.game.EngineEnv;
import com.sandboxol.center.router.module_application.BaseModuleApp;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.base.web.RetryWithDelay;
import com.sandboxol.common.retrofit.RetrofitFactory;
import com.sandboxol.common.utils.CommonHelper;
import com.sandboxol.greendao.entity.Dispatch;
import com.sandboxol.greendao.entity.MiniGameToken;
import java.util.ArrayList;
import java.util.HashMap;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.exceptions.Exceptions;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/* JADX INFO: compiled from: BlockyGameApi.java */
/* JADX INFO: loaded from: classes3.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final IBlockyGameApi f17765a = (IBlockyGameApi) RetrofitFactory.httpsCreate(BaseApplication.getApp().getMetaDataBaseUrl(), IBlockyGameApi.class);

    public static void a(Context context, long j, String str, String str2, OnResponseListener<MiniGameToken> onResponseListener) {
        long engineVersion = EngineEnv.getInstance(EngineEnv.getCurUseEngineTypeInGame()).getEngineVersion();
        f17765a.miniGameToken(str, j, (int) engineVersion, CommonHelper.getCountry()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<MiniGameToken>>) new i(new h(new MiniGameToken[1], str2, str, engineVersion, onResponseListener)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <D> void b(HttpResponse<D> httpResponse) {
        Log.e("web.MiniGameDispatch", "doOnNext. code: " + httpResponse.getCode() + "  msg:" + httpResponse.getMessage());
        if (httpResponse.getCode() != 2) {
            return;
        }
        try {
            Log.e("web.MiniGameDispatch", "server is busy. " + httpResponse.getMessage());
            throw new Exception("get dispatch failed");
        } catch (Throwable th) {
            Exceptions.propagate(th);
            throw null;
        }
    }

    public static void a(Context context, String str, String str2, long j, int i, String str3, String str4, String str5, String str6, OnResponseListener<Dispatch> onResponseListener) {
        long engineVersion = EngineEnv.getInstance(EngineEnv.getCurUseEngineTypeInGame()).getEngineVersion();
        long jLongValue = AccountCenter.newInstance().userId.get().longValue();
        String str7 = AccountCenter.newInstance().nickName.get();
        ArrayList arrayList = new ArrayList();
        arrayList.add(str4);
        HashMap map = new HashMap();
        map.put("clz", 0);
        map.put("name", str7);
        map.put("pioneer", true);
        map.put("targetId", Long.valueOf(j));
        map.put("ever", Long.valueOf(engineVersion));
        map.put("excludeIps", arrayList);
        map.put("rid", Integer.valueOf(i));
        map.put("picUrl", AccountCenter.newInstance().picUrl.get());
        map.put("packageName", BaseModuleApp.getBaseModuleApp().getMetaDataPackageName());
        map.put("appVer", BaseApplication.getApp().getMetaDataAppVersion() + "");
        map.put("country", TextUtils.isEmpty(str6) ? CommonHelper.getCountry() : str6);
        map.put("lang", CommonHelper.getUserLanguage());
        if (str3 != null && !str3.isEmpty()) {
            map.put("mapId", str3);
        }
        if (str5 != null && !str5.isEmpty()) {
            map.put("targetGameId", str5);
        }
        Log.e("web.GameBody1", new com.google.gson.j().a(map));
        ((IBlockyGameApi) RetrofitFactory.create(str, IBlockyGameApi.class)).newMiniGameDispatcher(map, jLongValue, str2).subscribeOn(Schedulers.newThread()).doOnNext(new Action1() { // from class: com.sandboxol.gameblocky.web.f
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                p.b((HttpResponse) obj);
            }
        }).retryWhen(new RetryWithDelay(1, 5000)).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<Dispatch>>) new j(onResponseListener));
    }

    public static void a(Context context, long j, String str, String str2, String str3, String str4, String str5, OnResponseListener<Dispatch> onResponseListener) {
        a(context, j, str, str2, str3, str4, EngineEnv.getInstance(EngineEnv.getCurUseEngineTypeInGame()).getEngineVersion(), str5, onResponseListener);
    }

    private static void a(Context context, long j, String str, String str2, String str3, String str4, long j2, String str5, OnResponseListener<Dispatch> onResponseListener) {
        long jLongValue = AccountCenter.newInstance().userId.get().longValue();
        String str6 = AccountCenter.newInstance().nickName.get();
        MiniGameToken[] miniGameTokenArr = new MiniGameToken[1];
        ArrayList arrayList = new ArrayList();
        arrayList.add(str3);
        HashMap map = new HashMap();
        map.put("clz", 0);
        map.put("name", str6);
        map.put("pioneer", true);
        map.put("targetId", Long.valueOf(j));
        map.put("ever", Long.valueOf(j2));
        map.put("excludeIps", arrayList);
        map.put("picUrl", AccountCenter.newInstance().picUrl.get());
        map.put("packageName", BaseModuleApp.getBaseModuleApp().getMetaDataPackageName());
        map.put("appVer", BaseApplication.getApp().getMetaDataAppVersion() + "");
        map.put("country", CommonHelper.getCountry());
        map.put("lang", CommonHelper.getUserLanguage());
        if (str2 != null && !str2.isEmpty()) {
            map.put("mapId", str2);
        }
        if (str5 != null && !str5.isEmpty()) {
            map.put("targetGameId", str5);
        }
        Log.e("web.GameBody2", new com.google.gson.j().a(map));
        f17765a.miniGameToken(str, j, (int) j2, CommonHelper.getCountry()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<MiniGameToken>>) new m(new l(miniGameTokenArr, map, str4, jLongValue, onResponseListener)));
    }

    public static void a(String str, long j, OnResponseListener<Dispatch> onResponseListener) {
        long engineVersion = EngineEnv.getInstance(EngineEnv.getCurUseEngineTypeInGame()).getEngineVersion();
        long jLongValue = AccountCenter.newInstance().userId.get().longValue();
        String str2 = AccountCenter.newInstance().nickName.get();
        HashMap map = new HashMap();
        map.put("clz", 0);
        map.put("pioneer", true);
        map.put("userId", Long.valueOf(jLongValue));
        map.put("name", str2);
        map.put("picUrl", AccountCenter.newInstance().picUrl.get());
        map.put("packageName", BaseModuleApp.getBaseModuleApp().getMetaDataPackageName());
        map.put("appVer", BaseApplication.getApp().getMetaDataAppVersion() + "");
        map.put("country", CommonHelper.getCountry());
        map.put("lang", CommonHelper.getUserLanguage());
        map.put("ever", Long.valueOf(engineVersion));
        map.put("targetId", Long.valueOf(j));
        f17765a.followGameAuth(str, j, (int) engineVersion, CommonHelper.getCountry()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<MiniGameToken>>) new o(new n(map, new MiniGameToken[1], jLongValue, onResponseListener)));
    }
}
