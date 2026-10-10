package io.rong.imkit.plugin.location;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.maps2d.CoordinateConverter;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.netlocation.AMapNetworkLocationClient;
import io.rong.common.RLog;
import io.rong.imkit.plugin.location.IUserInfoProvider;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.location.RealTimeLocationConstant;
import io.rong.imlib.location.RealTimeLocationType;
import io.rong.imlib.model.Conversation;

/* JADX INFO: loaded from: classes5.dex */
public class LocationManager2D {
    private static final String TAG = "LocationManager2D";
    private Context mContext;
    private Conversation.ConversationType mConversationType;
    private LatLng mLatLng;
    private ILocationChangedListener mLocationChangedListener;
    private AMapNetworkLocationClient mLocationClient;
    private AMapLocationParser mLocationParser;
    private LoopThread mLoopThread;
    private AMapLocationInfo mMyLastLatLng;
    private IMyLocationChangedListener mMyLocationChangedListener;
    private IRealTimeLocationStateListener mParticipantChangedListener;
    private String mTargetId;
    private IUserInfoProvider mUserInfoProvider;

    /* JADX INFO: renamed from: io.rong.imkit.plugin.location.LocationManager2D$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$io$rong$imlib$location$RealTimeLocationConstant$RealTimeLocationStatus = new int[RealTimeLocationConstant.RealTimeLocationStatus.values().length];

        static {
            try {
                $SwitchMap$io$rong$imlib$location$RealTimeLocationConstant$RealTimeLocationStatus[RealTimeLocationConstant.RealTimeLocationStatus.RC_REAL_TIME_LOCATION_STATUS_IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$rong$imlib$location$RealTimeLocationConstant$RealTimeLocationStatus[RealTimeLocationConstant.RealTimeLocationStatus.RC_REAL_TIME_LOCATION_STATUS_INCOMING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private class LoopThread extends Thread {
        private boolean mLooping;
        private int mMilSec;

        public LoopThread(int i) {
            this.mMilSec = i * 1000;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            this.mLooping = true;
            while (this.mLooping) {
                if (LocationManager2D.this.mLocationClient == null) {
                    LocationManager2D locationManager2D = LocationManager2D.this;
                    locationManager2D.mLocationClient = new AMapNetworkLocationClient(locationManager2D.mContext);
                    LocationManager2D.this.mLocationClient.setApiKey("8bc77f14ab831d62baaf2ed17fb798a4");
                }
                String networkLocation = LocationManager2D.this.mLocationClient.getNetworkLocation();
                RLog.d(LocationManager2D.TAG, "LoopThread location: " + networkLocation);
                if (!TextUtils.isEmpty(networkLocation)) {
                    AMapLocationInfo aMapLocationInfo = LocationManager2D.this.mLocationParser.parserApsJsonResp(networkLocation);
                    RongIMClient.getInstance().updateRealTimeLocationStatus(LocationManager2D.this.mConversationType, LocationManager2D.this.mTargetId, aMapLocationInfo.getLat(), aMapLocationInfo.getLng(), aMapLocationInfo.getCoord() == 1 ? RealTimeLocationType.GCJ02 : RealTimeLocationType.WGS84);
                    LocationManager2D.this.mMyLastLatLng = aMapLocationInfo;
                }
                try {
                    Thread.sleep(this.mMilSec);
                } catch (InterruptedException e2) {
                    RLog.e(LocationManager2D.TAG, "LoopThread run", e2);
                    Thread.currentThread().interrupt();
                }
            }
        }

        public void stopLooping() {
            this.mLooping = false;
        }
    }

    private class MyLocationThread extends Thread {
        private MyLocationThread() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            if (LocationManager2D.this.mLocationClient == null) {
                LocationManager2D locationManager2D = LocationManager2D.this;
                locationManager2D.mLocationClient = new AMapNetworkLocationClient(locationManager2D.mContext);
                LocationManager2D.this.mLocationClient.setApiKey("8bc77f14ab831d62baaf2ed17fb798a4");
            }
            String networkLocation = LocationManager2D.this.mLocationClient.getNetworkLocation();
            RLog.d(LocationManager2D.TAG, "MyLocationThread location: " + networkLocation);
            AMapLocationInfo aMapLocationInfo = LocationManager2D.this.mLocationParser.parserApsJsonResp(networkLocation);
            LocationManager2D.this.sendOnMyLocationChanged(aMapLocationInfo);
            LocationManager2D.this.mMyLastLatLng = aMapLocationInfo;
        }
    }

    private static class SingletonHolder {
        private static final LocationManager2D INSTANCE = new LocationManager2D();

        private SingletonHolder() {
        }
    }

    public static LocationManager2D getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendOnLocationChanged(double d2, double d3, String str) {
        ILocationChangedListener iLocationChangedListener;
        if (this.mContext == null || (iLocationChangedListener = this.mLocationChangedListener) == null) {
            return;
        }
        iLocationChangedListener.onLocationChanged(d2, d3, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendOnMyLocationChanged(AMapLocationInfo aMapLocationInfo) {
        IMyLocationChangedListener iMyLocationChangedListener;
        if (this.mContext == null || (iMyLocationChangedListener = this.mMyLocationChangedListener) == null || aMapLocationInfo == null) {
            return;
        }
        iMyLocationChangedListener.onMyLocationChanged(aMapLocationInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendOnParticipantChanged() {
        if (this.mContext == null || this.mParticipantChangedListener == null) {
            return;
        }
        this.mParticipantChangedListener.onParticipantChanged(RongIMClient.getInstance().getRealTimeLocationParticipants(this.mConversationType, this.mTargetId));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendOnParticipantJoinSharing(String str) {
        ILocationChangedListener iLocationChangedListener;
        if (this.mContext == null || (iLocationChangedListener = this.mLocationChangedListener) == null) {
            return;
        }
        iLocationChangedListener.onParticipantJoinSharing(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendOnParticipantQuitSharing(String str) {
        ILocationChangedListener iLocationChangedListener;
        if (this.mContext == null || (iLocationChangedListener = this.mLocationChangedListener) == null) {
            return;
        }
        iLocationChangedListener.onParticipantQuitSharing(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendOnRealTimeLocationError(RealTimeLocationConstant.RealTimeLocationErrorCode realTimeLocationErrorCode) {
        ILocationChangedListener iLocationChangedListener;
        if (this.mContext != null && (iLocationChangedListener = this.mLocationChangedListener) != null) {
            iLocationChangedListener.onError(realTimeLocationErrorCode);
        }
        IRealTimeLocationStateListener iRealTimeLocationStateListener = this.mParticipantChangedListener;
        if (iRealTimeLocationStateListener != null) {
            iRealTimeLocationStateListener.onErrorException();
        }
    }

    public void bindConversation(Context context, Conversation.ConversationType conversationType, String str) {
        this.mContext = context.getApplicationContext();
        this.mConversationType = conversationType;
        this.mTargetId = str;
        this.mLocationParser = new AMapLocationParser();
        RongIMClient.getInstance().addRealTimeLocationListener(this.mConversationType, this.mTargetId, new RongIMClient.RealTimeLocationListener() { // from class: io.rong.imkit.plugin.location.LocationManager2D.1
            @Override // io.rong.imlib.RongIMClient.RealTimeLocationListener
            public void onError(RealTimeLocationConstant.RealTimeLocationErrorCode realTimeLocationErrorCode) {
                RLog.d(LocationManager2D.TAG, "RealTimeLocationErrorCode errorCode = " + realTimeLocationErrorCode);
                LocationManager2D.this.stopMyLocationInLoop();
                LocationManager2D.this.sendOnRealTimeLocationError(realTimeLocationErrorCode);
            }

            @Override // io.rong.imlib.RongIMClient.RealTimeLocationListener
            public void onParticipantsJoin(String str2) {
                RLog.d(LocationManager2D.TAG, "onParticipantsJoin userId = " + str2);
                LocationManager2D.this.sendOnParticipantChanged();
                LocationManager2D.this.sendOnParticipantJoinSharing(str2);
            }

            @Override // io.rong.imlib.RongIMClient.RealTimeLocationListener
            public void onParticipantsQuit(String str2) {
                RLog.d(LocationManager2D.TAG, "onParticipantsQuit userId = " + str2);
                LocationManager2D.this.sendOnParticipantChanged();
                LocationManager2D.this.sendOnParticipantQuitSharing(str2);
            }

            @Override // io.rong.imlib.RongIMClient.RealTimeLocationListener
            public void onReceiveLocation(double d2, double d3, String str2) {
                RLog.d(LocationManager2D.TAG, "onReceiveLocation userId = " + str2 + "; latitude = " + d2 + "; longitude = " + d3);
                if (str2.equals(RongIMClient.getInstance().getCurrentUserId())) {
                    LocationManager2D.this.mLatLng = new LatLng(d2, d3);
                }
                LocationManager2D.this.sendOnLocationChanged(d2, d3, str2);
            }

            @Override // io.rong.imlib.RongIMClient.RealTimeLocationListener
            public void onReceiveLocationWithType(double d2, double d3, RealTimeLocationType realTimeLocationType, String str2) {
                RLog.d(LocationManager2D.TAG, "onReceiveLocationWithType userId = " + str2 + "; latitude = " + d2 + "; longitude = " + d3 + ",type = " + realTimeLocationType);
                if (realTimeLocationType != RealTimeLocationType.WGS84 || (d2 == 0.0d && d3 == 0.0d)) {
                    if (str2.equals(RongIMClient.getInstance().getCurrentUserId())) {
                        LocationManager2D.this.mLatLng = new LatLng(d2, d3);
                    }
                    LocationManager2D.this.sendOnLocationChanged(d2, d3, str2);
                    return;
                }
                LatLng latLng = new LatLng(d2, d3);
                CoordinateConverter coordinateConverter = new CoordinateConverter();
                coordinateConverter.from(CoordinateConverter.CoordType.GPS);
                coordinateConverter.coord(latLng);
                LatLng latLngConvert = coordinateConverter.convert();
                if (str2.equals(RongIMClient.getInstance().getCurrentUserId())) {
                    LocationManager2D.this.mLatLng = new LatLng(latLngConvert.latitude, latLngConvert.longitude);
                }
                LocationManager2D.this.sendOnLocationChanged(latLngConvert.latitude, latLngConvert.longitude, str2);
            }

            @Override // io.rong.imlib.RongIMClient.RealTimeLocationListener
            public void onStatusChange(RealTimeLocationConstant.RealTimeLocationStatus realTimeLocationStatus) {
                RLog.d(LocationManager2D.TAG, "onStatusChange status = " + realTimeLocationStatus.getMessage());
                LocationManager2D.this.sendOnParticipantChanged();
            }
        });
    }

    public void getUserInfo(String str, IUserInfoProvider.UserInfoCallback userInfoCallback) {
        IUserInfoProvider iUserInfoProvider = this.mUserInfoProvider;
        if (iUserInfoProvider != null) {
            iUserInfoProvider.getUserInfo(str, userInfoCallback);
        }
    }

    public boolean isSharing() {
        RealTimeLocationConstant.RealTimeLocationStatus realTimeLocationCurrentState = RongIMClient.getInstance().getRealTimeLocationCurrentState(this.mConversationType, this.mTargetId);
        return realTimeLocationCurrentState == RealTimeLocationConstant.RealTimeLocationStatus.RC_REAL_TIME_LOCATION_STATUS_CONNECTED || realTimeLocationCurrentState == RealTimeLocationConstant.RealTimeLocationStatus.RC_REAL_TIME_LOCATION_STATUS_OUTGOING;
    }

    public int joinLocationSharing() {
        if (RongIMClient.getInstance().getCurrentConnectionStatus() != RongIMClient.ConnectionStatusListener.ConnectionStatus.CONNECTED) {
            return 1;
        }
        int i = AnonymousClass2.$SwitchMap$io$rong$imlib$location$RealTimeLocationConstant$RealTimeLocationStatus[RongIMClient.getInstance().getRealTimeLocationCurrentState(this.mConversationType, this.mTargetId).ordinal()];
        if (i != 1) {
            return (i == 2 && RongIMClient.getInstance().joinRealTimeLocation(this.mConversationType, this.mTargetId).getValue() == RealTimeLocationConstant.RealTimeLocationErrorCode.RC_REAL_TIME_LOCATION_EXCEED_MAX_PARTICIPANT.getValue()) ? 2 : 0;
        }
        RongIMClient.getInstance().startRealTimeLocation(this.mConversationType, this.mTargetId);
        return 0;
    }

    public void quitLocationSharing() {
        RLog.d(TAG, "quitLocationSharing");
        RealTimeLocationConstant.RealTimeLocationStatus realTimeLocationCurrentState = RongIMClient.getInstance().getRealTimeLocationCurrentState(this.mConversationType, this.mTargetId);
        if (realTimeLocationCurrentState == RealTimeLocationConstant.RealTimeLocationStatus.RC_REAL_TIME_LOCATION_STATUS_CONNECTED || realTimeLocationCurrentState == RealTimeLocationConstant.RealTimeLocationStatus.RC_REAL_TIME_LOCATION_STATUS_OUTGOING) {
            RongIMClient.getInstance().quitRealTimeLocation(this.mConversationType, this.mTargetId);
            stopMyLocationInLoop();
            this.mLatLng = null;
        }
    }

    public void setLocationChangedListener(ILocationChangedListener iLocationChangedListener) {
        LatLng latLng;
        this.mLocationChangedListener = iLocationChangedListener;
        ILocationChangedListener iLocationChangedListener2 = this.mLocationChangedListener;
        if (iLocationChangedListener2 == null || (latLng = this.mLatLng) == null) {
            return;
        }
        iLocationChangedListener2.onLocationChanged(latLng.latitude, this.mLatLng.longitude, RongIMClient.getInstance().getCurrentUserId());
    }

    public void setMyLocationChangedListener(IMyLocationChangedListener iMyLocationChangedListener) {
        this.mMyLocationChangedListener = iMyLocationChangedListener;
        if (this.mMyLocationChangedListener != null) {
            updateMyLocation();
            AMapLocationInfo aMapLocationInfo = this.mMyLastLatLng;
            if (aMapLocationInfo != null) {
                iMyLocationChangedListener.onMyLocationChanged(aMapLocationInfo);
            }
        }
    }

    public void setParticipantChangedListener(IRealTimeLocationStateListener iRealTimeLocationStateListener) {
        this.mParticipantChangedListener = iRealTimeLocationStateListener;
        IRealTimeLocationStateListener iRealTimeLocationStateListener2 = this.mParticipantChangedListener;
        if (iRealTimeLocationStateListener2 != null) {
            iRealTimeLocationStateListener2.onParticipantChanged(RongIMClient.getInstance().getRealTimeLocationParticipants(this.mConversationType, this.mTargetId));
        }
    }

    public void setUserInfoProvider(IUserInfoProvider iUserInfoProvider) {
        this.mUserInfoProvider = iUserInfoProvider;
    }

    public void stopMyLocationInLoop() {
        LoopThread loopThread = this.mLoopThread;
        if (loopThread != null) {
            loopThread.stopLooping();
            this.mLoopThread = null;
        }
    }

    public void unBindConversation() {
        RongIMClient.getInstance().removeRealTimeLocationObserver(this.mConversationType, this.mTargetId);
    }

    public void updateMyLocation() {
        new MyLocationThread().start();
    }

    public void updateMyLocationInLoop(int i) {
        LoopThread loopThread = this.mLoopThread;
        if (loopThread != null) {
            loopThread.stopLooping();
        }
        this.mLoopThread = new LoopThread(i);
        this.mLoopThread.start();
    }

    private LocationManager2D() {
    }
}
