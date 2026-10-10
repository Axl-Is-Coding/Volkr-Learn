package com.disabngo.blockynexus.view.activity.friendmatch;

import android.content.Context;
import com.disabngo.blockynexus.d.E;
import com.disabngo.blockynexus.databinding.AbstractC0607i;
import com.disabngo.blockynexus.entity.UserMapInfo;
import com.disabngo.blockynexus.web.FriendApi;
import com.disabngo.blockynexus.web.GeoApi;
import com.disabngo.blockynexus.web.error.GeoOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.OnDataListener;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.greendao.entity.Friend;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes2.dex */
public class FriendMatchModel {

    /* JADX INFO: renamed from: com.disabngo.blockynexus.view.activity.friendmatch.FriendMatchModel$1, reason: invalid class name */
    class AnonymousClass1 extends OnResponseListener<List<UserMapInfo>> {
        final /* synthetic */ Context val$context;
        final /* synthetic */ OnDataListener val$listener;
        final /* synthetic */ UserMapInfo val$myUserMapInfo;

        AnonymousClass1(UserMapInfo userMapInfo, OnDataListener onDataListener, Context context) {
            this.val$myUserMapInfo = userMapInfo;
            this.val$listener = onDataListener;
            this.val$context = context;
        }

        public /* synthetic */ void a(Random random, UserMapInfo userMapInfo, Random random2, UserMapInfo userMapInfo2) {
            if (userMapInfo2.getLatitude() == 0.0d || userMapInfo2.getLongitude() == 0.0d) {
                userMapInfo2.setLatitude(FriendMatchModel.this.random(random, userMapInfo.getLatitude(), (random2.nextDouble() * 0.5d) + userMapInfo.getLatitude()));
                userMapInfo2.setLongitude(FriendMatchModel.this.random(random, userMapInfo.getLongitude(), (random2.nextDouble() * 0.5d) + userMapInfo.getLongitude()));
            }
            double dA = E.a(userMapInfo.getLatitude(), userMapInfo.getLongitude(), userMapInfo2.getLatitude(), userMapInfo2.getLongitude());
            if (dA != 0.0d) {
                userMapInfo2.setDistance(dA);
                return;
            }
            userMapInfo2.setLatitude(FriendMatchModel.this.random(random, userMapInfo.getLatitude(), userMapInfo.getLatitude() + (random2.nextDouble() * 5.0d)));
            userMapInfo2.setLongitude(FriendMatchModel.this.random(random, userMapInfo.getLongitude(), (random2.nextDouble() * 5.0d) + userMapInfo.getLongitude()));
            userMapInfo2.setDistance(E.a(userMapInfo.getLatitude(), userMapInfo.getLongitude(), userMapInfo2.getLatitude(), userMapInfo2.getLongitude()));
        }

        @Override // com.sandboxol.common.base.web.OnResponseListener
        public void onError(int i, String str) {
            GeoOnError.showErrorTip(this.val$context, i);
            this.val$listener.onSuccess(null);
        }

        @Override // com.sandboxol.common.base.web.OnResponseListener
        public void onServerError(int i) {
            ServerOnError.showOnServerError(this.val$context, i);
            this.val$listener.onSuccess(null);
        }

        @Override // com.sandboxol.common.base.web.OnResponseListener
        public void onSuccess(List<UserMapInfo> list) {
            if (list == null || list.isEmpty()) {
                return;
            }
            final Random random = new Random(99L);
            final Random random2 = new Random(10L);
            Observable observableSubscribeOn = Observable.from(list).subscribeOn(AndroidSchedulers.mainThread());
            final UserMapInfo userMapInfo = this.val$myUserMapInfo;
            observableSubscribeOn.subscribe(new Action1() { // from class: com.disabngo.blockynexus.view.activity.friendmatch.b
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    this.f10603a.a(random, userMapInfo, random2, (UserMapInfo) obj);
                }
            });
            Collections.sort(list, new Comparator() { // from class: com.disabngo.blockynexus.view.activity.friendmatch.a
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return Double.valueOf(((UserMapInfo) obj).getDistance()).compareTo(Double.valueOf(((UserMapInfo) obj2).getDistance()));
                }
            });
            this.val$listener.onSuccess(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public double random(Random random, double d2, double d3) {
        return (random.nextDouble() * (d3 - d2)) + d2;
    }

    public void getFriendInfo(final Context context, long j, final OnDataListener<Friend> onDataListener) {
        FriendApi.friendDetails(context, j, new OnResponseListener<Friend>() { // from class: com.disabngo.blockynexus.view.activity.friendmatch.FriendMatchModel.2
            @Override // com.sandboxol.common.base.web.OnResponseListener
            public void onError(int i, String str) {
                onDataListener.onSuccess(null);
            }

            @Override // com.sandboxol.common.base.web.OnResponseListener
            public void onServerError(int i) {
                onDataListener.onSuccess(null);
                ServerOnError.showOnServerError(context, i);
            }

            @Override // com.sandboxol.common.base.web.OnResponseListener
            public void onSuccess(Friend friend) {
                if (friend != null) {
                    onDataListener.onSuccess(friend);
                }
            }
        });
    }

    public void getUserMapInfoList(Context context, UserMapInfo userMapInfo, OnDataListener<List<UserMapInfo>> onDataListener) {
        GeoApi.getUserMapInfoList(context, new AnonymousClass1(userMapInfo, onDataListener, context));
    }

    public List<UserMapInfo> setViewXY(List<UserMapInfo> list, AbstractC0607i abstractC0607i) {
        int i;
        double d2;
        double d3;
        int i2;
        double d4;
        double d5;
        int i3;
        int measuredWidth = abstractC0607i.g.getMeasuredWidth();
        int measuredHeight = abstractC0607i.g.getMeasuredHeight();
        int i4 = measuredWidth / 2;
        int i5 = measuredHeight / 2;
        if (measuredWidth > measuredHeight) {
            measuredWidth = measuredHeight;
        }
        abstractC0607i.g.getClass();
        int i6 = measuredWidth / 19;
        int size = list.size();
        for (int i7 = 0; i7 < size; i7++) {
            UserMapInfo userMapInfo = list.get(i7);
            if (i7 < 2) {
                i = i6 * 2;
                d2 = (i7 * 180) + 40;
                double dRandom = Math.random();
                double d6 = 180;
                Double.isNaN(d6);
                d3 = dRandom * d6;
                Double.isNaN(d2);
            } else if (i7 < 5) {
                i = i6 * 3;
                d2 = (i7 - 2) * 120;
                double dRandom2 = Math.random();
                double d7 = 80;
                Double.isNaN(d7);
                d3 = dRandom2 * d7;
                Double.isNaN(d2);
            } else if (i7 < 9) {
                i = i6 * 4;
                d2 = ((i7 - 5) * 90) + 40;
                double dRandom3 = Math.random();
                double d8 = 90;
                Double.isNaN(d8);
                d3 = dRandom3 * d8;
                Double.isNaN(d2);
            } else if (i7 < 13) {
                i = i6 * 5;
                d2 = (i7 - 9) * 90;
                double dRandom4 = Math.random();
                double d9 = 50;
                Double.isNaN(d9);
                d3 = dRandom4 * d9;
                Double.isNaN(d2);
            } else {
                if (i7 < 18) {
                    i2 = i6 * 6;
                    d4 = ((i7 - 13) * 72) + 36;
                    double dRandom5 = Math.random();
                    double d10 = 72;
                    Double.isNaN(d10);
                    d5 = dRandom5 * d10;
                    Double.isNaN(d4);
                } else if (i7 < 23) {
                    i2 = i6 * 7;
                    d4 = (i7 - 18) * 72;
                    double dRandom6 = Math.random();
                    double d11 = 36;
                    Double.isNaN(d11);
                    d5 = dRandom6 * d11;
                    Double.isNaN(d4);
                } else {
                    i = i6 * 8;
                    d2 = (i7 - 23) * 51;
                    double dRandom7 = Math.random();
                    double d12 = 46;
                    Double.isNaN(d12);
                    d3 = dRandom7 * d12;
                    Double.isNaN(d2);
                }
                i3 = (int) (d4 + d5);
                i = i2;
                double d13 = i3;
                double dCos = Math.cos(Math.toRadians(d13));
                double d14 = i;
                Double.isNaN(d14);
                userMapInfo.setX(((int) (dCos * d14)) + i4);
                double dSin = Math.sin(Math.toRadians(d13));
                Double.isNaN(d14);
                userMapInfo.setY(((int) (dSin * d14)) + i5);
            }
            i3 = (int) (d2 + d3);
            double d132 = i3;
            double dCos2 = Math.cos(Math.toRadians(d132));
            double d142 = i;
            Double.isNaN(d142);
            userMapInfo.setX(((int) (dCos2 * d142)) + i4);
            double dSin2 = Math.sin(Math.toRadians(d132));
            Double.isNaN(d142);
            userMapInfo.setY(((int) (dSin2 * d142)) + i5);
        }
        return list;
    }
}
