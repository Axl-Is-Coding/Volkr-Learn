package com.sandboxol.center.router.moduleInfo.game.team.util;

import android.os.Handler;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.router.moduleInfo.game.team.listener.IQuickInListener;
import com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyListRequest;
import com.sandboxol.center.router.moduleInfo.game.team.teammgr.PartyListResponse;
import com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeammgrGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.stub.MetadataUtils;
import io.grpc.stub.StreamObserver;
import io.rong.imlib.common.RongLibConst;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: classes3.dex */
public class QuickInManagerClient extends Handler {
    private static QuickInManagerClient mMe;
    private TeammgrGrpc.TeammgrStub asyncStub;
    private final ManagedChannel channel;
    private IQuickInListener iQuickInListener;
    private StreamObserver<PartyListRequest> quickInRequestStreamObserver;

    private QuickInManagerClient(String str, int i, long j, String str2) {
        this(ManagedChannelBuilder.forAddress(str, i).idleTimeout(2L, TimeUnit.SECONDS).usePlaintext(true), String.valueOf(j), str2);
    }

    private Metadata.AsciiMarshaller<String> getAsciiMarshaller() {
        return new Metadata.AsciiMarshaller<String>() { // from class: com.sandboxol.center.router.moduleInfo.game.team.util.QuickInManagerClient.1
            @Override // io.grpc.Metadata.AsciiMarshaller
            public String parseAsciiString(String str) {
                return str;
            }

            @Override // io.grpc.Metadata.AsciiMarshaller
            public String toAsciiString(String str) {
                return str;
            }
        };
    }

    public static QuickInManagerClient getMe() {
        return mMe;
    }

    public static QuickInManagerClient newInstance(String str, int i, long j, String str2) {
        if (mMe == null) {
            mMe = new QuickInManagerClient(str, i, j, str2);
        }
        return mMe;
    }

    public /* synthetic */ void a(PartyListRequest partyListRequest, final Subscriber subscriber) {
        if (this.quickInRequestStreamObserver == null) {
            this.quickInRequestStreamObserver = this.asyncStub.partyList(new StreamObserver<PartyListResponse>() { // from class: com.sandboxol.center.router.moduleInfo.game.team.util.QuickInManagerClient.3
                @Override // io.grpc.stub.StreamObserver
                public void onCompleted() {
                    subscriber.onCompleted();
                }

                @Override // io.grpc.stub.StreamObserver
                public void onError(Throwable th) {
                    subscriber.onError(th);
                }

                @Override // io.grpc.stub.StreamObserver
                public void onNext(PartyListResponse partyListResponse) {
                    subscriber.onNext(partyListResponse);
                }
            });
        }
        try {
            this.quickInRequestStreamObserver.onNext(partyListRequest);
        } catch (Exception e2) {
            e2.printStackTrace();
            this.quickInRequestStreamObserver.onError(e2);
        }
    }

    public void connectQuickIn(final PartyListRequest partyListRequest) {
        Observable.create(new Observable.OnSubscribe() { // from class: com.sandboxol.center.router.moduleInfo.game.team.util.b
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f16336a.a(partyListRequest, (Subscriber) obj);
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new Subscriber<PartyListResponse>() { // from class: com.sandboxol.center.router.moduleInfo.game.team.util.QuickInManagerClient.2
            @Override // rx.Observer
            public void onCompleted() {
                if (QuickInManagerClient.this.iQuickInListener != null) {
                    QuickInManagerClient.this.iQuickInListener.onTeamCompleted();
                }
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                Status statusFromThrowable = Status.fromThrowable(th);
                statusFromThrowable.getCode();
                Status.Code code = Status.Code.UNAVAILABLE;
                if (QuickInManagerClient.this.iQuickInListener != null) {
                    QuickInManagerClient.this.iQuickInListener.onTeamError(statusFromThrowable);
                }
            }

            @Override // rx.Observer
            public void onNext(PartyListResponse partyListResponse) {
                if (QuickInManagerClient.this.iQuickInListener != null) {
                    QuickInManagerClient.this.iQuickInListener.onTeamNext(partyListResponse);
                }
            }
        });
    }

    public void setQuickInListener(IQuickInListener iQuickInListener) {
        this.iQuickInListener = iQuickInListener;
    }

    public void shutDownQuickIn() {
        StreamObserver<PartyListRequest> streamObserver = this.quickInRequestStreamObserver;
        if (streamObserver != null) {
            streamObserver.onCompleted();
        }
        this.channel.shutdown();
        this.iQuickInListener = null;
        mMe = null;
    }

    private QuickInManagerClient(ManagedChannelBuilder<?> managedChannelBuilder, String str, String str2) {
        this.channel = managedChannelBuilder.build();
        this.asyncStub = TeammgrGrpc.newStub(this.channel);
        Metadata metadata = new Metadata();
        Metadata.Key keyOf = Metadata.Key.of(StringConstant.UID, getAsciiMarshaller());
        Metadata.Key keyOf2 = Metadata.Key.of(RongLibConst.KEY_TOKEN, getAsciiMarshaller());
        metadata.put(keyOf, str);
        metadata.put(keyOf2, str2);
        this.asyncStub = (TeammgrGrpc.TeammgrStub) MetadataUtils.attachHeaders(this.asyncStub, metadata);
    }
}
