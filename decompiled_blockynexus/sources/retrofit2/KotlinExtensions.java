package retrofit2;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.umeng.analytics.pro.au;
import java.lang.reflect.Method;
import kotlin.KotlinNullPointerException;
import kotlin.Result;
import kotlin.b.a;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.c;
import kotlin.coroutines.jvm.internal.e;
import kotlin.jvm.internal.i;
import kotlin.l;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

/* JADX INFO: compiled from: KotlinExtensions.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class KotlinExtensions {

    /* JADX INFO: renamed from: retrofit2.KotlinExtensions$yieldAndThrow$1, reason: invalid class name */
    /* JADX INFO: compiled from: KotlinExtensions.kt */
    @c(c = "retrofit2/KotlinExtensions", f = "KotlinExtensions.kt", l = {100, 102}, m = "yieldAndThrow")
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(a aVar) {
            super(aVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return KotlinExtensions.yieldAndThrow(null, this);
        }
    }

    public static final <T> Object await(final Call<T> call, a<? super T> aVar) {
        CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(b.a(aVar), 1);
        final CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
        cancellableContinuation.invokeOnCancellation(new kotlin.jvm.a.b<Throwable, l>() { // from class: retrofit2.KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$1
            {
                super(1);
            }

            @Override // kotlin.jvm.a.b
            public /* bridge */ /* synthetic */ l invoke(Throwable th) {
                invoke2(th);
                return l.f22855a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                call.cancel();
            }
        });
        call.enqueue(new Callback<T>() { // from class: retrofit2.KotlinExtensions$await$2$2
            @Override // retrofit2.Callback
            public void onFailure(Call<T> call2, Throwable th) {
                i.b(call2, "call");
                i.b(th, au.az);
                a aVar2 = cancellableContinuation;
                Result.a aVar3 = Result.Companion;
                Object objA = kotlin.i.a(th);
                Result.m112constructorimpl(objA);
                aVar2.resumeWith(objA);
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<T> call2, Response<T> response) {
                i.b(call2, "call");
                i.b(response, "response");
                if (!response.isSuccessful()) {
                    a aVar2 = cancellableContinuation;
                    HttpException httpException = new HttpException(response);
                    Result.a aVar3 = Result.Companion;
                    Object objA = kotlin.i.a(httpException);
                    Result.m112constructorimpl(objA);
                    aVar2.resumeWith(objA);
                    return;
                }
                T tBody = response.body();
                if (tBody != null) {
                    a aVar4 = cancellableContinuation;
                    Result.a aVar5 = Result.Companion;
                    Result.m112constructorimpl(tBody);
                    aVar4.resumeWith(tBody);
                    return;
                }
                Object objA2 = call2.request().a(Invocation.class);
                if (objA2 == null) {
                    i.a();
                    throw null;
                }
                i.a(objA2, "call.request().tag(Invocation::class.java)!!");
                Method method = ((Invocation) objA2).method();
                StringBuilder sb = new StringBuilder();
                sb.append("Response from ");
                i.a((Object) method, FirebaseAnalytics.Param.METHOD);
                Class<?> declaringClass = method.getDeclaringClass();
                i.a((Object) declaringClass, "method.declaringClass");
                sb.append(declaringClass.getName());
                sb.append('.');
                sb.append(method.getName());
                sb.append(" was null but response body type was declared as non-null");
                KotlinNullPointerException kotlinNullPointerException = new KotlinNullPointerException(sb.toString());
                a aVar6 = cancellableContinuation;
                Result.a aVar7 = Result.Companion;
                Object objA3 = kotlin.i.a(kotlinNullPointerException);
                Result.m112constructorimpl(objA3);
                aVar6.resumeWith(objA3);
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == kotlin.coroutines.intrinsics.c.a()) {
            e.b(aVar);
        }
        return result;
    }

    public static final <T> Object awaitNullable(final Call<T> call, a<? super T> aVar) {
        CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(b.a(aVar), 1);
        final CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
        cancellableContinuation.invokeOnCancellation(new kotlin.jvm.a.b<Throwable, l>() { // from class: retrofit2.KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$2
            {
                super(1);
            }

            @Override // kotlin.jvm.a.b
            public /* bridge */ /* synthetic */ l invoke(Throwable th) {
                invoke2(th);
                return l.f22855a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                call.cancel();
            }
        });
        call.enqueue(new Callback<T>() { // from class: retrofit2.KotlinExtensions$await$4$2
            @Override // retrofit2.Callback
            public void onFailure(Call<T> call2, Throwable th) {
                i.b(call2, "call");
                i.b(th, au.az);
                a aVar2 = cancellableContinuation;
                Result.a aVar3 = Result.Companion;
                Object objA = kotlin.i.a(th);
                Result.m112constructorimpl(objA);
                aVar2.resumeWith(objA);
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<T> call2, Response<T> response) {
                i.b(call2, "call");
                i.b(response, "response");
                if (response.isSuccessful()) {
                    a aVar2 = cancellableContinuation;
                    T tBody = response.body();
                    Result.a aVar3 = Result.Companion;
                    Result.m112constructorimpl(tBody);
                    aVar2.resumeWith(tBody);
                    return;
                }
                a aVar4 = cancellableContinuation;
                HttpException httpException = new HttpException(response);
                Result.a aVar5 = Result.Companion;
                Object objA = kotlin.i.a(httpException);
                Result.m112constructorimpl(objA);
                aVar4.resumeWith(objA);
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == kotlin.coroutines.intrinsics.c.a()) {
            e.b(aVar);
        }
        return result;
    }

    public static final <T> Object awaitResponse(final Call<T> call, a<? super Response<T>> aVar) {
        CancellableContinuation cancellableContinuationImpl = new CancellableContinuationImpl(b.a(aVar), 1);
        final CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
        cancellableContinuation.invokeOnCancellation(new kotlin.jvm.a.b<Throwable, l>() { // from class: retrofit2.KotlinExtensions$awaitResponse$$inlined$suspendCancellableCoroutine$lambda$1
            {
                super(1);
            }

            @Override // kotlin.jvm.a.b
            public /* bridge */ /* synthetic */ l invoke(Throwable th) {
                invoke2(th);
                return l.f22855a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                call.cancel();
            }
        });
        call.enqueue(new Callback<T>() { // from class: retrofit2.KotlinExtensions$awaitResponse$2$2
            @Override // retrofit2.Callback
            public void onFailure(Call<T> call2, Throwable th) {
                i.b(call2, "call");
                i.b(th, au.az);
                a aVar2 = cancellableContinuation;
                Result.a aVar3 = Result.Companion;
                Object objA = kotlin.i.a(th);
                Result.m112constructorimpl(objA);
                aVar2.resumeWith(objA);
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<T> call2, Response<T> response) {
                i.b(call2, "call");
                i.b(response, "response");
                a aVar2 = cancellableContinuation;
                Result.a aVar3 = Result.Companion;
                Result.m112constructorimpl(response);
                aVar2.resumeWith(response);
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == kotlin.coroutines.intrinsics.c.a()) {
            e.b(aVar);
        }
        return result;
    }

    private static final <T> T create(Retrofit retrofit) {
        i.a(4, "T");
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object yieldAndThrow(java.lang.Exception r4, kotlin.b.a<?> r5) throws java.lang.Exception {
        /*
            boolean r0 = r5 instanceof retrofit2.KotlinExtensions.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r5
            retrofit2.KotlinExtensions$yieldAndThrow$1 r0 = (retrofit2.KotlinExtensions.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            retrofit2.KotlinExtensions$yieldAndThrow$1 r0 = new retrofit2.KotlinExtensions$yieldAndThrow$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.a()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r4 = r0.L$0
            java.lang.Exception r4 = (java.lang.Exception) r4
            boolean r0 = r5 instanceof kotlin.Result.Failure
            if (r0 == 0) goto L49
            kotlin.Result$Failure r5 = (kotlin.Result.Failure) r5
            java.lang.Throwable r4 = r5.exception
            throw r4
        L32:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3a:
            boolean r2 = r5 instanceof kotlin.Result.Failure
            if (r2 != 0) goto L4a
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = kotlinx.coroutines.YieldKt.yield(r0)
            if (r5 != r1) goto L49
            return r1
        L49:
            throw r4
        L4a:
            kotlin.Result$Failure r5 = (kotlin.Result.Failure) r5
            java.lang.Throwable r4 = r5.exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: retrofit2.KotlinExtensions.yieldAndThrow(java.lang.Exception, kotlin.b.a):java.lang.Object");
    }
}
