package com.sandboxol.common.retrofit;

import android.content.Context;
import com.alibaba.android.arouter.utils.Consts;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.utils.CommonHelper;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.C;
import okhttp3.C2940e;
import okhttp3.C2942g;
import okhttp3.H;
import okhttp3.Interceptor;
import okhttp3.z;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/* JADX INFO: loaded from: classes3.dex */
public class RetrofitFactory {
    static /* synthetic */ H a(long j, Interceptor.Chain chain) throws IOException {
        H.a aVarT = chain.proceed(chain.request()).t();
        aVarT.b("Pragma");
        aVarT.b("Cache-Control");
        aVarT.b("Cache-Control", "max-age=" + j);
        return aVarT.a();
    }

    static /* synthetic */ H b(long j, Interceptor.Chain chain) throws IOException {
        C cRequest = chain.request();
        if (!CommonHelper.isNetworkConnected(BaseApplication.getContext())) {
            C.a aVarF = cRequest.f();
            aVarF.b("Cache-Control", "public, only-if-cached, max-stale=" + j);
            aVarF.a(C2942g.f23147b);
            cRequest = aVarF.a();
        }
        return chain.proceed(cRequest);
    }

    public static <T> T cacheCreate(String str, Class<T> cls, final long j) {
        try {
            File file = new File(CommonHelper.getDiskCacheDir(BaseApplication.getContext()), "BlockyModsCache");
            Retrofit.Builder builderAddConverterFactory = new Retrofit.Builder().addCallAdapterFactory(RxJavaCallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create());
            z.a aVar = new z.a();
            aVar.b(new Interceptor() { // from class: com.sandboxol.common.retrofit.b
                @Override // okhttp3.Interceptor
                public final H intercept(Interceptor.Chain chain) {
                    return RetrofitFactory.a(j, chain);
                }
            });
            aVar.a(new Interceptor() { // from class: com.sandboxol.common.retrofit.a
                @Override // okhttp3.Interceptor
                public final H intercept(Interceptor.Chain chain) {
                    return RetrofitFactory.b(j, chain);
                }
            });
            aVar.a(new C2940e(file, 31457280L));
            return (T) builderAddConverterFactory.client(aVar.a()).baseUrl(str).build().create(cls);
        } catch (Exception e2) {
            e2.printStackTrace();
            return (T) create(str, cls);
        }
    }

    public static <T> T create(String str, Class<T> cls) {
        Retrofit.Builder builder = new Retrofit.Builder();
        z.a aVar = new z.a();
        aVar.a(getBaseUrlInterceptor(str, str));
        return (T) builder.client(aVar.a()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create()).baseUrl(str).build().create(cls);
    }

    public static BaseUrlInterceptor getBaseUrlInterceptor(String str, String str2) {
        try {
            Context context = BaseApplication.getContext();
            String packageName = context != null ? context.getPackageName() : "unknown";
            return new BaseUrlInterceptor(str, str2, packageName.substring(packageName.lastIndexOf(Consts.DOT) + 1), BaseApplication.getApp().getMetaDataAppVersion());
        } catch (Exception e2) {
            e2.printStackTrace();
            return new BaseUrlInterceptor(str, str2);
        }
    }

    public static <T> T httpsCreate(String str, Class<T> cls) {
        Retrofit.Builder builderAddConverterFactory = new Retrofit.Builder().addCallAdapterFactory(RxJavaCallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create());
        z.a aVar = new z.a();
        aVar.a(getBaseUrlInterceptor(str, BaseApplication.getApp().getMetaDataBackupBaseUrl()));
        aVar.a(true);
        aVar.b(10L, TimeUnit.SECONDS);
        aVar.c(10L, TimeUnit.SECONDS);
        aVar.d(10L, TimeUnit.SECONDS);
        return (T) builderAddConverterFactory.client(aVar.a()).baseUrl(str).build().create(cls);
    }

    public static <T> T create(String str, Class<T> cls, long j) {
        Retrofit.Builder builderAddConverterFactory = new Retrofit.Builder().addCallAdapterFactory(RxJavaCallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create());
        z.a aVar = new z.a();
        aVar.b(j, TimeUnit.MILLISECONDS);
        aVar.c(j, TimeUnit.MILLISECONDS);
        aVar.d(j, TimeUnit.MILLISECONDS);
        return (T) builderAddConverterFactory.client(aVar.a()).baseUrl(str).build().create(cls);
    }
}
