package com.sandboxol.gameblocky.web;

import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.base.web.HttpResponse;
import com.sandboxol.common.base.web.HttpSubscriber;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.retrofit.RetrofitFactory;
import io.rong.common.LibStorageUtils;
import java.io.File;
import okhttp3.G;
import okhttp3.w;
import okhttp3.x;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/* JADX INFO: compiled from: BlockyUserApi.java */
/* JADX INFO: loaded from: classes3.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final IBlockyUserApi f17766a = (IBlockyUserApi) RetrofitFactory.httpsCreate(BaseApplication.getApp().getMetaDataBaseUrl(), IBlockyUserApi.class);

    public static void a(File file, String str, String str2, OnResponseListener<String> onResponseListener) {
        f17766a.uploadFile(str2, str, x.b.a(LibStorageUtils.FILE, str2, G.create(w.b("multipart/form-data"), file))).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber<? super HttpResponse<String>>) new HttpSubscriber(onResponseListener));
    }
}
