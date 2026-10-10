package retrofit2;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import retrofit2.CallAdapter;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes5.dex */
class Platform {
    private static final Platform PLATFORM = findPlatform();

    static class Android extends Platform {

        static class MainThreadExecutor implements Executor {
            private final Handler handler = new Handler(Looper.getMainLooper());

            MainThreadExecutor() {
            }

            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                this.handler.post(runnable);
            }
        }

        Android() {
        }

        @Override // retrofit2.Platform
        List<? extends CallAdapter.Factory> defaultCallAdapterFactories(Executor executor) {
            if (executor == null) {
                throw new AssertionError();
            }
            DefaultCallAdapterFactory defaultCallAdapterFactory = new DefaultCallAdapterFactory(executor);
            return Build.VERSION.SDK_INT >= 24 ? Arrays.asList(CompletableFutureCallAdapterFactory.INSTANCE, defaultCallAdapterFactory) : Collections.singletonList(defaultCallAdapterFactory);
        }

        @Override // retrofit2.Platform
        int defaultCallAdapterFactoriesSize() {
            return Build.VERSION.SDK_INT >= 24 ? 2 : 1;
        }

        @Override // retrofit2.Platform
        public Executor defaultCallbackExecutor() {
            return new MainThreadExecutor();
        }

        @Override // retrofit2.Platform
        List<? extends Converter.Factory> defaultConverterFactories() {
            return Build.VERSION.SDK_INT >= 24 ? Collections.singletonList(OptionalConverterFactory.INSTANCE) : Collections.emptyList();
        }

        @Override // retrofit2.Platform
        int defaultConverterFactoriesSize() {
            return Build.VERSION.SDK_INT >= 24 ? 1 : 0;
        }

        @Override // retrofit2.Platform
        boolean isDefaultMethod(Method method) {
            if (Build.VERSION.SDK_INT < 24) {
                return false;
            }
            return method.isDefault();
        }
    }

    static class Java8 extends Platform {
        Java8() {
        }

        @Override // retrofit2.Platform
        List<? extends CallAdapter.Factory> defaultCallAdapterFactories(Executor executor) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(CompletableFutureCallAdapterFactory.INSTANCE);
            arrayList.add(new DefaultCallAdapterFactory(executor));
            return Collections.unmodifiableList(arrayList);
        }

        @Override // retrofit2.Platform
        int defaultCallAdapterFactoriesSize() {
            return 2;
        }

        @Override // retrofit2.Platform
        List<? extends Converter.Factory> defaultConverterFactories() {
            return Collections.singletonList(OptionalConverterFactory.INSTANCE);
        }

        @Override // retrofit2.Platform
        int defaultConverterFactoriesSize() {
            return 1;
        }

        @Override // retrofit2.Platform
        Object invokeDefaultMethod(Method method, Class<?> cls, Object obj, Object... objArr) throws Throwable {
            Constructor declaredConstructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, Integer.TYPE);
            declaredConstructor.setAccessible(true);
            return ((MethodHandles.Lookup) declaredConstructor.newInstance(cls, -1)).unreflectSpecial(method, cls).bindTo(obj).invokeWithArguments(objArr);
        }

        @Override // retrofit2.Platform
        boolean isDefaultMethod(Method method) {
            return method.isDefault();
        }
    }

    Platform() {
    }

    private static Platform findPlatform() {
        try {
            Class.forName("android.os.Build");
            if (Build.VERSION.SDK_INT != 0) {
                return new Android();
            }
        } catch (ClassNotFoundException unused) {
        }
        try {
            Class.forName("java.util.Optional");
            return new Java8();
        } catch (ClassNotFoundException unused2) {
            return new Platform();
        }
    }

    static Platform get() {
        return PLATFORM;
    }

    List<? extends CallAdapter.Factory> defaultCallAdapterFactories(Executor executor) {
        return Collections.singletonList(new DefaultCallAdapterFactory(executor));
    }

    int defaultCallAdapterFactoriesSize() {
        return 1;
    }

    Executor defaultCallbackExecutor() {
        return null;
    }

    List<? extends Converter.Factory> defaultConverterFactories() {
        return Collections.emptyList();
    }

    int defaultConverterFactoriesSize() {
        return 0;
    }

    Object invokeDefaultMethod(Method method, Class<?> cls, Object obj, Object... objArr) throws Throwable {
        throw new UnsupportedOperationException();
    }

    boolean isDefaultMethod(Method method) {
        return false;
    }
}
