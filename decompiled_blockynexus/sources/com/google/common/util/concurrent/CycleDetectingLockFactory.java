package com.google.common.util.concurrent;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.MapMaker;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public class CycleDetectingLockFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ConcurrentMap<Class<? extends Enum>, Map<? extends Enum, a>> f14032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Logger f14033b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ThreadLocal<ArrayList<a>> f14034c;

    private static class ExampleStackTrace extends IllegalStateException {
        static final StackTraceElement[] EMPTY_STACK_TRACE = new StackTraceElement[0];
        static final Set<String> EXCLUDED_CLASS_NAMES = ImmutableSet.of(CycleDetectingLockFactory.class.getName(), ExampleStackTrace.class.getName(), a.class.getName());

        ExampleStackTrace(a aVar, a aVar2) {
            super(aVar.a() + " -> " + aVar2.a());
            StackTraceElement[] stackTrace = getStackTrace();
            int length = stackTrace.length;
            for (int i = 0; i < length; i++) {
                if (b.class.getName().equals(stackTrace[i].getClassName())) {
                    setStackTrace(EMPTY_STACK_TRACE);
                    return;
                } else {
                    if (!EXCLUDED_CLASS_NAMES.contains(stackTrace[i].getClassName())) {
                        setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i, length));
                        return;
                    }
                }
            }
        }
    }

    public static final class PotentialDeadlockException extends ExampleStackTrace {
        private final ExampleStackTrace conflictingStackTrace;

        /* synthetic */ PotentialDeadlockException(a aVar, a aVar2, ExampleStackTrace exampleStackTrace, i iVar) {
            this(aVar, aVar2, exampleStackTrace);
        }

        public ExampleStackTrace getConflictingStackTrace() {
            return this.conflictingStackTrace;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            StringBuilder sb = new StringBuilder(super.getMessage());
            for (Throwable cause = this.conflictingStackTrace; cause != null; cause = cause.getCause()) {
                sb.append(", ");
                sb.append(cause.getMessage());
            }
            return sb.toString();
        }

        private PotentialDeadlockException(a aVar, a aVar2, ExampleStackTrace exampleStackTrace) {
            super(aVar, aVar2);
            this.conflictingStackTrace = exampleStackTrace;
            initCause(exampleStackTrace);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f14035a;

        String a() {
            return this.f14035a;
        }
    }

    public static final class b<E extends Enum<E>> extends CycleDetectingLockFactory {
    }

    static {
        MapMaker mapMaker = new MapMaker();
        mapMaker.k();
        f14032a = mapMaker.j();
        f14033b = Logger.getLogger(CycleDetectingLockFactory.class.getName());
        f14034c = new i();
    }
}
