package io.grpc.stub;

import com.google.common.base.m;
import io.grpc.CallCredentials;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientInterceptor;
import io.grpc.ClientInterceptors;
import io.grpc.Deadline;
import io.grpc.stub.AbstractStub;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractStub<S extends AbstractStub<S>> {
    private final CallOptions callOptions;
    private final Channel channel;

    protected AbstractStub(Channel channel) {
        this(channel, CallOptions.DEFAULT);
    }

    protected abstract S build(Channel channel, CallOptions callOptions);

    public final CallOptions getCallOptions() {
        return this.callOptions;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final S withCallCredentials(CallCredentials callCredentials) {
        return (S) build(this.channel, this.callOptions.withCallCredentials(callCredentials));
    }

    public final S withChannel(Channel channel) {
        return (S) build(channel, this.callOptions);
    }

    public final S withCompression(String str) {
        return (S) build(this.channel, this.callOptions.withCompression(str));
    }

    public final S withDeadline(Deadline deadline) {
        return (S) build(this.channel, this.callOptions.withDeadline(deadline));
    }

    public final S withDeadlineAfter(long j, TimeUnit timeUnit) {
        return (S) build(this.channel, this.callOptions.withDeadlineAfter(j, timeUnit));
    }

    @Deprecated
    public final S withDeadlineNanoTime(Long l) {
        return (S) build(this.channel, this.callOptions.withDeadlineNanoTime(l));
    }

    public final S withInterceptors(ClientInterceptor... clientInterceptorArr) {
        return (S) build(ClientInterceptors.intercept(this.channel, clientInterceptorArr), this.callOptions);
    }

    public final <T> S withOption(CallOptions.Key<T> key, T t) {
        return (S) build(this.channel, this.callOptions.withOption(key, t));
    }

    protected AbstractStub(Channel channel, CallOptions callOptions) {
        m.a(channel);
        this.channel = channel;
        m.a(callOptions);
        this.callOptions = callOptions;
    }
}
