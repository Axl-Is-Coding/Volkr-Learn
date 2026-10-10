package androidx.loader.content;

import android.os.Binder;
import android.os.Process;
import androidx.loader.content.ModernAsyncTask;

/* JADX INFO: Add missing generic type declarations: [Params, Result] */
/* JADX INFO: compiled from: ModernAsyncTask.java */
/* JADX INFO: loaded from: classes.dex */
class e<Params, Result> extends ModernAsyncTask.c<Params, Result> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ModernAsyncTask f1639b;

    e(ModernAsyncTask modernAsyncTask) {
        this.f1639b = modernAsyncTask;
    }

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
    @Override // java.util.concurrent.Callable
    public Result call() throws Exception {
        this.f1639b.j.set(true);
        Result result = null;
        try {
            try {
                Process.setThreadPriority(10);
                result = (Result) this.f1639b.a((Object[]) this.f1630a);
                Binder.flushPendingCommands();
                return result;
            } finally {
            }
        } finally {
            this.f1639b.d(result);
        }
    }
}
