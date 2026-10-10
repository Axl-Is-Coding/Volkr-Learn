package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import androidx.annotation.Nullable;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.4l, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C13514l<T> implements InvocationHandler {
    public static byte[] A02;
    public static String[] A03;
    public ClassLoader A00;
    public T A01;

    static {
        A04();
        A03();
    }

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A03[2].length() != 16) {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[6] = "7LVLxstLm7VGVuwpoPddR";
            strArr[5] = "O4Ajby3FQpCfAUdim7NmB";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 40);
            i4++;
        }
    }

    public static void A03() {
        A02 = new byte[]{-20, -5, -12};
    }

    public static void A04() {
        A03 = new String[]{"HJBbstbFgkhP2Es2YC6tj0WPrL", "4IOUVAMDExjQBHSpAfoXSYCtPyIaCI88", "z5PEOWpVsYBM96D6", "SPmK69spxohqfCa0SsQ", "2TZuMIK", "01EkjjI8QhZqdiHuXsMGI", "efeA7FnPjHODjVcAjRmk7", "pSZyNCg"};
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4l != com.facebook.ads.internal.apiimp.AdApiProxy$ProxyInvocationHandler<T> */
    public C13514l(T impl, ClassLoader classLoader) {
        this.A01 = impl;
        this.A00 = classLoader;
    }

    @Nullable
    public static Object A00(final ClassLoader classLoader, Method method) {
        Class<?> returnType = method.getReturnType();
        if (returnType.equals(Void.TYPE)) {
            return null;
        }
        if (returnType.isPrimitive()) {
            return Array.get(Array.newInstance(method.getReturnType(), 1), 0);
        }
        if (returnType.equals(String.class)) {
            return A02(0, 0, 23);
        }
        if (!returnType.isInterface()) {
            return null;
        }
        return Proxy.newProxyInstance(classLoader, new Class[]{returnType}, new InvocationHandler() { // from class: com.facebook.ads.redexgen.X.4k
            @Override // java.lang.reflect.InvocationHandler
            @Nullable
            public final Object invoke(Object obj, Method method2, Object[] objArr) {
                return C13514l.A00(classLoader, method2);
            }
        });
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4l != com.facebook.ads.internal.apiimp.AdApiProxy$ProxyInvocationHandler<T> */
    public final T A05() {
        return this.A01;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.4l != com.facebook.ads.internal.apiimp.AdApiProxy$ProxyInvocationHandler<T> */
    @Override // java.lang.reflect.InvocationHandler
    @SuppressLint({"CatchGeneralException"})
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        try {
            return method.invoke(this.A01, objArr);
        } catch (Throwable th) {
            if (th instanceof InvocationTargetException) {
                Throwable targetException = th.getTargetException();
                if (targetException instanceof C12801p) {
                    throw new IllegalStateException(targetException.getMessage());
                }
            }
            Object objA00 = A00(this.A00, method);
            C2027Wc c2027WcA00 = AnonymousClass86.A00();
            if (c2027WcA00 != null) {
                c2027WcA00.A04().A8H(A02(0, 3, 99), C8Y.A0D, new C8Z(th));
                return objA00;
            }
            return objA00;
        }
    }
}
