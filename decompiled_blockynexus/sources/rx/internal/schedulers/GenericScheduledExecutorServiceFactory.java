package rx.internal.schedulers;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import rx.functions.Func0;
import rx.internal.util.RxThreadFactory;
import rx.plugins.RxJavaHooks;

/* JADX INFO: loaded from: classes5.dex */
enum GenericScheduledExecutorServiceFactory {
    ;

    static final String THREAD_NAME_PREFIX = "RxScheduledExecutorPool-";
    static final RxThreadFactory THREAD_FACTORY = new RxThreadFactory(THREAD_NAME_PREFIX);

    public static ScheduledExecutorService create() {
        Func0<? extends ScheduledExecutorService> onGenericScheduledExecutorService = RxJavaHooks.getOnGenericScheduledExecutorService();
        return onGenericScheduledExecutorService == null ? createDefault() : onGenericScheduledExecutorService.call();
    }

    static ScheduledExecutorService createDefault() {
        return Executors.newScheduledThreadPool(1, threadFactory());
    }

    static ThreadFactory threadFactory() {
        return THREAD_FACTORY;
    }
}
