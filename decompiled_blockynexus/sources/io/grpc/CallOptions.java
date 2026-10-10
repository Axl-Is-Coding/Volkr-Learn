package io.grpc;

import com.google.common.base.j;
import com.google.common.base.m;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public final class CallOptions {
    public static final CallOptions DEFAULT = new CallOptions();
    private Attributes affinity;
    private String authority;
    private String compressorName;
    private CallCredentials credentials;
    private Object[][] customOptions;
    private Deadline deadline;
    private Executor executor;
    private boolean waitForReady;

    public static final class Key<T> {
        private final T defaultValue;
        private final String name;

        private Key(String str, T t) {
            this.name = str;
            this.defaultValue = t;
        }

        public static <T> Key<T> of(String str, T t) {
            m.a(str);
            return new Key<>(str, t);
        }

        public T getDefault() {
            return this.defaultValue;
        }

        public String toString() {
            return this.name;
        }
    }

    private CallOptions() {
        this.affinity = Attributes.EMPTY;
        this.customOptions = (Object[][]) Array.newInstance((Class<?>) Object.class, 0, 2);
    }

    public Attributes getAffinity() {
        return this.affinity;
    }

    public String getAuthority() {
        return this.authority;
    }

    public String getCompressor() {
        return this.compressorName;
    }

    public CallCredentials getCredentials() {
        return this.credentials;
    }

    public Deadline getDeadline() {
        return this.deadline;
    }

    @Deprecated
    public Long getDeadlineNanoTime() {
        if (getDeadline() == null) {
            return null;
        }
        return Long.valueOf(System.nanoTime() + getDeadline().timeRemaining(TimeUnit.NANOSECONDS));
    }

    public Executor getExecutor() {
        return this.executor;
    }

    public <T> T getOption(Key<T> key) {
        m.a(key);
        int i = 0;
        while (true) {
            Object[][] objArr = this.customOptions;
            if (i >= objArr.length) {
                return (T) ((Key) key).defaultValue;
            }
            if (key.equals(objArr[i][0])) {
                return (T) this.customOptions[i][1];
            }
            i++;
        }
    }

    public boolean isWaitForReady() {
        return this.waitForReady;
    }

    public String toString() {
        j.a aVarA = j.a(this);
        aVarA.a("deadline", this.deadline);
        aVarA.a("authority", this.authority);
        aVarA.a("callCredentials", this.credentials);
        aVarA.a("affinity", this.affinity);
        Executor executor = this.executor;
        aVarA.a("executor", executor != null ? executor.getClass() : null);
        aVarA.a("compressorName", this.compressorName);
        aVarA.a("customOptions", Arrays.deepToString(this.customOptions));
        aVarA.a("waitForReady", isWaitForReady());
        return aVarA.toString();
    }

    public CallOptions withAffinity(Attributes attributes) {
        CallOptions callOptions = new CallOptions(this);
        m.a(attributes);
        callOptions.affinity = attributes;
        return callOptions;
    }

    public CallOptions withAuthority(String str) {
        CallOptions callOptions = new CallOptions(this);
        callOptions.authority = str;
        return callOptions;
    }

    public CallOptions withCallCredentials(CallCredentials callCredentials) {
        CallOptions callOptions = new CallOptions(this);
        callOptions.credentials = callCredentials;
        return callOptions;
    }

    public CallOptions withCompression(String str) {
        CallOptions callOptions = new CallOptions(this);
        callOptions.compressorName = str;
        return callOptions;
    }

    public CallOptions withDeadline(Deadline deadline) {
        CallOptions callOptions = new CallOptions(this);
        callOptions.deadline = deadline;
        return callOptions;
    }

    public CallOptions withDeadlineAfter(long j, TimeUnit timeUnit) {
        return withDeadline(Deadline.after(j, timeUnit));
    }

    @Deprecated
    public CallOptions withDeadlineNanoTime(Long l) {
        return withDeadline(l != null ? Deadline.after(l.longValue() - System.nanoTime(), TimeUnit.NANOSECONDS) : null);
    }

    public CallOptions withExecutor(Executor executor) {
        CallOptions callOptions = new CallOptions(this);
        callOptions.executor = executor;
        return callOptions;
    }

    public <T> CallOptions withOption(Key<T> key, T t) {
        m.a(key);
        m.a(t);
        CallOptions callOptions = new CallOptions(this);
        int i = 0;
        while (true) {
            Object[][] objArr = this.customOptions;
            if (i >= objArr.length) {
                i = -1;
                break;
            }
            if (key.equals(objArr[i][0])) {
                break;
            }
            i++;
        }
        callOptions.customOptions = (Object[][]) Array.newInstance((Class<?>) Object.class, this.customOptions.length + (i == -1 ? 1 : 0), 2);
        Object[][] objArr2 = this.customOptions;
        System.arraycopy(objArr2, 0, callOptions.customOptions, 0, objArr2.length);
        if (i == -1) {
            callOptions.customOptions[this.customOptions.length] = new Object[]{key, t};
        } else {
            callOptions.customOptions[i][1] = t;
        }
        return callOptions;
    }

    public CallOptions withWaitForReady() {
        CallOptions callOptions = new CallOptions(this);
        callOptions.waitForReady = true;
        return callOptions;
    }

    public CallOptions withoutWaitForReady() {
        CallOptions callOptions = new CallOptions(this);
        callOptions.waitForReady = false;
        return callOptions;
    }

    private CallOptions(CallOptions callOptions) {
        this.affinity = Attributes.EMPTY;
        this.customOptions = (Object[][]) Array.newInstance((Class<?>) Object.class, 0, 2);
        this.deadline = callOptions.deadline;
        this.authority = callOptions.authority;
        this.credentials = callOptions.credentials;
        this.affinity = callOptions.affinity;
        this.executor = callOptions.executor;
        this.compressorName = callOptions.compressorName;
        this.customOptions = callOptions.customOptions;
        this.waitForReady = callOptions.waitForReady;
    }
}
