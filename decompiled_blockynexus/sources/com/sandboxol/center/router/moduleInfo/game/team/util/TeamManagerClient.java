package com.sandboxol.center.router.moduleInfo.game.team.util;

import android.os.Handler;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.router.moduleInfo.game.team.listener.ITeamManagerListener;
import com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamRequest;
import com.sandboxol.center.router.moduleInfo.game.team.teammgr.TeamResponse;
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
public class TeamManagerClient extends Handler {
    private static TeamManagerClient mMe;
    private TeammgrGrpc.TeammgrStub asyncStub;
    private final ManagedChannel channel;
    private ITeamManagerListener mITeamManagerListener;
    private StreamObserver<TeamRequest> mTeamRequestStreamObserver;

    private TeamManagerClient(String str, int i, long j, String str2) {
        this(ManagedChannelBuilder.forAddress(str, i).idleTimeout(2L, TimeUnit.SECONDS).usePlaintext(true), String.valueOf(j), str2);
    }

    public static void destroyTeamManagerClient() {
        mMe = null;
    }

    private Metadata.AsciiMarshaller<String> getAsciiMarshaller() {
        return new Metadata.AsciiMarshaller<String>() { // from class: com.sandboxol.center.router.moduleInfo.game.team.util.TeamManagerClient.1
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

    public static TeamManagerClient getMe() {
        return mMe;
    }

    public static TeamManagerClient newInstance(String str, int i, long j, String str2) {
        if (mMe == null) {
            mMe = new TeamManagerClient(str, i, j, str2);
        }
        return mMe;
    }

    public /* synthetic */ void a(TeamRequest teamRequest, final Subscriber subscriber) {
        if (this.mTeamRequestStreamObserver == null) {
            this.mTeamRequestStreamObserver = this.asyncStub.team(new StreamObserver<TeamResponse>() { // from class: com.sandboxol.center.router.moduleInfo.game.team.util.TeamManagerClient.3
                @Override // io.grpc.stub.StreamObserver
                public void onCompleted() {
                    subscriber.onCompleted();
                }

                @Override // io.grpc.stub.StreamObserver
                public void onError(Throwable th) {
                    subscriber.onError(th);
                }

                @Override // io.grpc.stub.StreamObserver
                public void onNext(TeamResponse teamResponse) {
                    subscriber.onNext(teamResponse);
                }
            });
        }
        try {
            this.mTeamRequestStreamObserver.onNext(teamRequest);
        } catch (Exception e2) {
            e2.printStackTrace();
            this.mTeamRequestStreamObserver.onError(e2);
        }
    }

    public void setCreateTeamListener(ITeamManagerListener iTeamManagerListener) {
        this.mITeamManagerListener = iTeamManagerListener;
    }

    public void shutdownTeam() {
        StreamObserver<TeamRequest> streamObserver = this.mTeamRequestStreamObserver;
        if (streamObserver != null) {
            streamObserver.onCompleted();
        }
        this.channel.shutdownNow();
        this.mITeamManagerListener = null;
        mMe = null;
    }

    public void team(final TeamRequest teamRequest) {
        Observable.create(new Observable.OnSubscribe() { // from class: com.sandboxol.center.router.moduleInfo.game.team.util.c
            @Override // rx.functions.Action1
            public final void call(Object obj) {
                this.f16338a.a(teamRequest, (Subscriber) obj);
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((Subscriber) new Subscriber<TeamResponse>() { // from class: com.sandboxol.center.router.moduleInfo.game.team.util.TeamManagerClient.2
            @Override // rx.Observer
            public void onCompleted() {
                if (TeamManagerClient.this.mITeamManagerListener != null) {
                    TeamManagerClient.this.mITeamManagerListener.onTeamCompleted();
                }
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                if (TeamManagerClient.this.mITeamManagerListener != null) {
                    TeamManagerClient.this.mITeamManagerListener.onTeamError(Status.fromThrowable(th));
                }
            }

            @Override // rx.Observer
            public void onNext(TeamResponse teamResponse) {
                if (TeamManagerClient.this.mITeamManagerListener != null) {
                    TeamManagerClient.this.mITeamManagerListener.onTeamNext(teamResponse);
                }
            }
        });
    }

    private TeamManagerClient(ManagedChannelBuilder<?> managedChannelBuilder, String str, String str2) {
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
