package androidx.appcompat.app;

import android.content.res.Resources;
import java.lang.Thread;

/* JADX INFO: compiled from: AppCompatDelegateImpl.java */
/* JADX INFO: loaded from: classes.dex */
class m implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Thread.UncaughtExceptionHandler f314a;

    m(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f314a = uncaughtExceptionHandler;
    }

    private boolean a(Throwable th) {
        String message;
        if (!(th instanceof Resources.NotFoundException) || (message = th.getMessage()) == null) {
            return false;
        }
        return message.contains("drawable") || message.contains("Drawable");
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (!a(th)) {
            this.f314a.uncaughtException(thread, th);
            return;
        }
        Resources.NotFoundException notFoundException = new Resources.NotFoundException(th.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
        notFoundException.initCause(th.getCause());
        notFoundException.setStackTrace(th.getStackTrace());
        this.f314a.uncaughtException(thread, notFoundException);
    }
}
