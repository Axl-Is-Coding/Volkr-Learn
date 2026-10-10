package io.rong.imlib.location;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Message;
import androidx.core.app.h;
import androidx.core.content.b;
import io.rong.common.RLog;
import io.rong.imlib.IRongCallback;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.location.RealTimeLocationConstant;
import io.rong.imlib.location.message.RealTimeLocationJoinMessage;
import io.rong.imlib.location.message.RealTimeLocationQuitMessage;
import io.rong.imlib.location.message.RealTimeLocationStartMessage;
import io.rong.imlib.location.message.RealTimeLocationStatusMessage;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Message;
import io.rong.imlib.navigation.LocationConfig;
import io.rong.imlib.navigation.NavigationCacheHelper;
import io.rong.imlib.stateMachine.State;
import io.rong.imlib.stateMachine.StateMachine;
import io.rong.message.InformationNotificationMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class RealTimeLocation extends StateMachine {
    public static final int RC_REAL_TIME_LOCATION_EVENT_DISABLE_GPS = 14;
    public static final int RC_REAL_TIME_LOCATION_EVENT_JOIN = 1;
    public static final int RC_REAL_TIME_LOCATION_EVENT_JOIN_FAILURE = 9;
    public static final int RC_REAL_TIME_LOCATION_EVENT_NETWORK_UNAVAILABLE = 13;
    public static final int RC_REAL_TIME_LOCATION_EVENT_PARTICIPANT_JOIN = 4;
    public static final int RC_REAL_TIME_LOCATION_EVENT_PARTICIPANT_NO_RESPONSE = 12;
    public static final int RC_REAL_TIME_LOCATION_EVENT_PARTICIPANT_QUIT = 5;
    public static final int RC_REAL_TIME_LOCATION_EVENT_PARTICIPANT_START = 3;
    public static final int RC_REAL_TIME_LOCATION_EVENT_QUIT = 2;
    public static final int RC_REAL_TIME_LOCATION_EVENT_RECEIVE_LOCATION_MESSAGE = 6;
    public static final int RC_REAL_TIME_LOCATION_EVENT_REFRESH_TIME_EXPIRE = 10;
    public static final int RC_REAL_TIME_LOCATION_EVENT_SEND_LOCATION_MESSAGE = 7;
    public static final int RC_REAL_TIME_LOCATION_EVENT_START = 0;
    public static final int RC_REAL_TIME_LOCATION_EVENT_START_FAILURE = 8;
    public static final int RC_REAL_TIME_LOCATION_EVENT_TERMINAL = 11;
    private static final String TAG = "RealTimeLocation";
    private RongIMClient mClient;
    private State mConnectedState;
    private Context mContext;
    private Conversation.ConversationType mConversationType;
    private RealTimeLocationConstant.RealTimeLocationStatus mCurrentState;
    private int mFilterDistance;
    private boolean mGpsEnable;
    private State mIncomingState;
    private double mLatitude;
    private LocationListener mLocationListener;
    private LocationManager mLocationManager;
    private double mLongitude;
    private RealTimeLocationObserver mObservers;
    private OnRealTimeLocationQuitListener mOnRealTimeLocationQuitListener;
    private State mOutgoingState;
    private ArrayList<String> mParticipants;
    private RealTimeLocationType mRealTimeLocationType;
    private RongIMClient.OnReceiveMessageListener mReceiveMessageListener;
    private int mRefreshInterval;
    private Runnable mRefreshRunnable;
    private String mSelfId;
    private String mTargetId;
    private State mTerminalState;
    private HashMap<String, ParticipantWatcher> mWatcher;

    private class ConnectedState extends State {
        private ConnectedState() {
        }

        @Override // io.rong.imlib.stateMachine.State, io.rong.imlib.stateMachine.IState
        public void enter() {
            RealTimeLocation.this.mCurrentState = RealTimeLocationConstant.RealTimeLocationStatus.RC_REAL_TIME_LOCATION_STATUS_CONNECTED;
            RealTimeLocation realTimeLocation = RealTimeLocation.this;
            realTimeLocation.onStatusChanged(realTimeLocation.mCurrentState);
            RealTimeLocation.this.startTimer();
            RLog.d(RealTimeLocation.TAG, "connected enter : current = " + RealTimeLocation.this.mCurrentState);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // io.rong.imlib.stateMachine.State, io.rong.imlib.stateMachine.IState
        public boolean processMessage(Message message) {
            RLog.i(RealTimeLocation.TAG, getName() + ", msg = " + message.what);
            switch (message.what) {
                case 2:
                    RealTimeLocation.this.sendQuitMessage();
                    RealTimeLocation.this.mParticipants.remove(RealTimeLocation.this.mSelfId);
                    if (RealTimeLocation.this.mParticipants.size() == 0) {
                        RealTimeLocation realTimeLocation = RealTimeLocation.this;
                        realTimeLocation.transitionTo(realTimeLocation.mTerminalState);
                    } else {
                        RealTimeLocation realTimeLocation2 = RealTimeLocation.this;
                        realTimeLocation2.transitionTo(realTimeLocation2.mIncomingState);
                    }
                    return true;
                case 3:
                case 11:
                default:
                    return true;
                case 4:
                    String str = (String) message.obj;
                    ParticipantWatcher participantWatcher = RealTimeLocation.this.new ParticipantWatcher(str);
                    participantWatcher.start();
                    RealTimeLocation.this.mWatcher.put(str, participantWatcher);
                    if (!RealTimeLocation.this.mParticipants.contains(str)) {
                        RealTimeLocation.this.mParticipants.add(str);
                    }
                    RealTimeLocation.this.onParticipantsJoin(str);
                    RealTimeLocation.this.getHandler().sendEmptyMessage(7);
                    return true;
                case 5:
                case 12:
                    String str2 = (String) message.obj;
                    RealTimeLocation.this.mParticipants.remove(str2);
                    ParticipantWatcher participantWatcher2 = (ParticipantWatcher) RealTimeLocation.this.mWatcher.get(str2);
                    if (participantWatcher2 != null) {
                        participantWatcher2.stop();
                    }
                    RealTimeLocation.this.mWatcher.remove(str2);
                    RealTimeLocation.this.onParticipantQuit(str2);
                    if (RealTimeLocation.this.mParticipants.size() == 1) {
                        RealTimeLocation realTimeLocation3 = RealTimeLocation.this;
                        realTimeLocation3.transitionTo(realTimeLocation3.mOutgoingState);
                    }
                    return true;
                case 6:
                    io.rong.imlib.model.Message message2 = (io.rong.imlib.model.Message) message.obj;
                    String senderUserId = message2.getSenderUserId();
                    ParticipantWatcher participantWatcher3 = (ParticipantWatcher) RealTimeLocation.this.mWatcher.get(senderUserId);
                    if (participantWatcher3 == null) {
                        ParticipantWatcher participantWatcher4 = RealTimeLocation.this.new ParticipantWatcher(senderUserId);
                        participantWatcher4.start();
                        RealTimeLocation.this.mWatcher.put(senderUserId, participantWatcher4);
                        if (!RealTimeLocation.this.mParticipants.contains(senderUserId)) {
                            RealTimeLocation.this.mParticipants.add(senderUserId);
                        }
                        RealTimeLocation.this.onParticipantsJoin(senderUserId);
                    } else {
                        participantWatcher3.update();
                    }
                    RealTimeLocationStatusMessage realTimeLocationStatusMessage = (RealTimeLocationStatusMessage) message2.getContent();
                    RealTimeLocation.this.onReceiveLocation(realTimeLocationStatusMessage.getLatitude(), realTimeLocationStatusMessage.getLongitude(), realTimeLocationStatusMessage.getRealTimeLocationType(), senderUserId);
                    return true;
                case 7:
                case 10:
                    RealTimeLocation.this.sendLocationMessage();
                    RealTimeLocation.this.updateSelfLocation();
                    return true;
                case 8:
                    RealTimeLocation.this.onError(RealTimeLocationConstant.RealTimeLocationErrorCode.RC_REAL_TIME_LOCATION_START_FAILURE);
                    RealTimeLocation realTimeLocation4 = RealTimeLocation.this;
                    realTimeLocation4.transitionTo(realTimeLocation4.mTerminalState);
                    return true;
                case 9:
                    RealTimeLocation.this.onError(RealTimeLocationConstant.RealTimeLocationErrorCode.RC_REAL_TIME_LOCATION_JOIN_FAILURE);
                    RealTimeLocation realTimeLocation5 = RealTimeLocation.this;
                    realTimeLocation5.transitionTo(realTimeLocation5.mTerminalState);
                    return true;
                case 13:
                    RealTimeLocation.this.onError(RealTimeLocationConstant.RealTimeLocationErrorCode.RC_REAL_TIME_LOCATION_NETWORK_UNAVAILABLE);
                    RealTimeLocation realTimeLocation6 = RealTimeLocation.this;
                    realTimeLocation6.transitionTo(realTimeLocation6.mTerminalState);
                    return true;
                case 14:
                    RealTimeLocation.this.onError(RealTimeLocationConstant.RealTimeLocationErrorCode.RC_REAL_TIME_LOCATION_GPS_DISABLED);
                    RealTimeLocation realTimeLocation7 = RealTimeLocation.this;
                    realTimeLocation7.transitionTo(realTimeLocation7.mTerminalState);
                    return true;
            }
        }
    }

    private class IdleState extends State {
        private IdleState() {
        }

        @Override // io.rong.imlib.stateMachine.State, io.rong.imlib.stateMachine.IState
        public void enter() {
            RealTimeLocation.this.mCurrentState = RealTimeLocationConstant.RealTimeLocationStatus.RC_REAL_TIME_LOCATION_STATUS_IDLE;
            if (RealTimeLocation.this.mSelfId != null) {
                RealTimeLocation realTimeLocation = RealTimeLocation.this;
                realTimeLocation.onStatusChanged(realTimeLocation.mCurrentState);
            }
            RLog.d(RealTimeLocation.TAG, "idle enter : current = " + RealTimeLocation.this.mCurrentState);
        }

        @Override // io.rong.imlib.stateMachine.State, io.rong.imlib.stateMachine.IState
        public boolean processMessage(Message message) {
            RLog.i(RealTimeLocation.TAG, getName() + ", msg = " + message.what);
            int i = message.what;
            if (i == 0) {
                RealTimeLocation.this.sendStartMessage();
                RealTimeLocation realTimeLocation = RealTimeLocation.this;
                realTimeLocation.mSelfId = realTimeLocation.mClient.getCurrentUserId();
                RealTimeLocation.this.mParticipants.add(RealTimeLocation.this.mSelfId);
                RealTimeLocation.this.updateSelfLocation();
                RealTimeLocation realTimeLocation2 = RealTimeLocation.this;
                realTimeLocation2.transitionTo(realTimeLocation2.mOutgoingState);
                return true;
            }
            if (i == 3) {
                String str = (String) message.obj;
                ParticipantWatcher participantWatcher = RealTimeLocation.this.new ParticipantWatcher(str);
                participantWatcher.start();
                RealTimeLocation.this.mWatcher.put(str, participantWatcher);
                RealTimeLocation.this.mParticipants.add(str);
                RealTimeLocation realTimeLocation3 = RealTimeLocation.this;
                realTimeLocation3.transitionTo(realTimeLocation3.mIncomingState);
                return true;
            }
            if (i != 6) {
                return true;
            }
            String senderUserId = ((io.rong.imlib.model.Message) message.obj).getSenderUserId();
            ParticipantWatcher participantWatcher2 = RealTimeLocation.this.new ParticipantWatcher(senderUserId);
            participantWatcher2.start();
            RealTimeLocation.this.mWatcher.put(senderUserId, participantWatcher2);
            RealTimeLocation.this.mParticipants.add(senderUserId);
            RealTimeLocation realTimeLocation4 = RealTimeLocation.this;
            realTimeLocation4.transitionTo(realTimeLocation4.mIncomingState);
            return true;
        }
    }

    private class IncomingState extends State {
        private IncomingState() {
        }

        @Override // io.rong.imlib.stateMachine.State, io.rong.imlib.stateMachine.IState
        public void enter() {
            RealTimeLocation.this.stopTimer();
            RealTimeLocation.this.mCurrentState = RealTimeLocationConstant.RealTimeLocationStatus.RC_REAL_TIME_LOCATION_STATUS_INCOMING;
            RealTimeLocation realTimeLocation = RealTimeLocation.this;
            realTimeLocation.onStatusChanged(realTimeLocation.mCurrentState);
            RLog.d(RealTimeLocation.TAG, "incoming enter : current = " + RealTimeLocation.this.mCurrentState);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:19:0x00ac  */
        @Override // io.rong.imlib.stateMachine.State, io.rong.imlib.stateMachine.IState
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean processMessage(android.os.Message r10) {
            /*
                Method dump skipped, instruction units count: 330
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.rong.imlib.location.RealTimeLocation.IncomingState.processMessage(android.os.Message):boolean");
        }
    }

    interface OnRealTimeLocationQuitListener {
        void onRealTimeLocationQuit(Conversation.ConversationType conversationType, String str);
    }

    private class OutgoingState extends State {
        private OutgoingState() {
        }

        @Override // io.rong.imlib.stateMachine.State, io.rong.imlib.stateMachine.IState
        public void enter() {
            RealTimeLocation.this.mCurrentState = RealTimeLocationConstant.RealTimeLocationStatus.RC_REAL_TIME_LOCATION_STATUS_OUTGOING;
            RealTimeLocation realTimeLocation = RealTimeLocation.this;
            realTimeLocation.onStatusChanged(realTimeLocation.mCurrentState);
            RealTimeLocation.this.startTimer();
            RLog.d(RealTimeLocation.TAG, "outgoing enter : current = " + RealTimeLocation.this.mCurrentState);
        }

        @Override // io.rong.imlib.stateMachine.State, io.rong.imlib.stateMachine.IState
        public boolean processMessage(Message message) {
            RLog.i(RealTimeLocation.TAG, getName() + ", msg = " + message.what);
            int i = message.what;
            if (i == 2) {
                RealTimeLocation.this.sendQuitMessage();
                RealTimeLocation realTimeLocation = RealTimeLocation.this;
                realTimeLocation.transitionTo(realTimeLocation.mTerminalState);
                return true;
            }
            if (i == 4) {
                String str = (String) message.obj;
                ParticipantWatcher participantWatcher = RealTimeLocation.this.new ParticipantWatcher(str);
                participantWatcher.start();
                RealTimeLocation.this.mWatcher.put(str, participantWatcher);
                RealTimeLocation.this.mParticipants.add(str);
                RealTimeLocation.this.onParticipantsJoin(str);
                RealTimeLocation realTimeLocation2 = RealTimeLocation.this;
                realTimeLocation2.transitionTo(realTimeLocation2.mConnectedState);
                return true;
            }
            if (i != 10) {
                if (i == 6) {
                    String senderUserId = ((io.rong.imlib.model.Message) message.obj).getSenderUserId();
                    if (RealTimeLocation.this.mWatcher.containsKey(senderUserId)) {
                        return true;
                    }
                    ParticipantWatcher participantWatcher2 = RealTimeLocation.this.new ParticipantWatcher(senderUserId);
                    participantWatcher2.start();
                    RealTimeLocation.this.mWatcher.put(senderUserId, participantWatcher2);
                    RealTimeLocation.this.mParticipants.add(senderUserId);
                    RealTimeLocation.this.onParticipantsJoin(senderUserId);
                    RealTimeLocation realTimeLocation3 = RealTimeLocation.this;
                    realTimeLocation3.transitionTo(realTimeLocation3.mConnectedState);
                    return true;
                }
                if (i != 7) {
                    if (i == 8) {
                        RealTimeLocation.this.onError(RealTimeLocationConstant.RealTimeLocationErrorCode.RC_REAL_TIME_LOCATION_START_FAILURE);
                        RealTimeLocation realTimeLocation4 = RealTimeLocation.this;
                        realTimeLocation4.transitionTo(realTimeLocation4.mTerminalState);
                        return true;
                    }
                    if (i == 13) {
                        RealTimeLocation.this.onError(RealTimeLocationConstant.RealTimeLocationErrorCode.RC_REAL_TIME_LOCATION_NETWORK_UNAVAILABLE);
                        RealTimeLocation realTimeLocation5 = RealTimeLocation.this;
                        realTimeLocation5.transitionTo(realTimeLocation5.mTerminalState);
                        return true;
                    }
                    if (i != 14) {
                        return true;
                    }
                    RealTimeLocation.this.onError(RealTimeLocationConstant.RealTimeLocationErrorCode.RC_REAL_TIME_LOCATION_GPS_DISABLED);
                    RealTimeLocation realTimeLocation6 = RealTimeLocation.this;
                    realTimeLocation6.transitionTo(realTimeLocation6.mTerminalState);
                    return true;
                }
            }
            RealTimeLocation.this.sendLocationMessage();
            RealTimeLocation.this.updateSelfLocation();
            return true;
        }
    }

    private class ParticipantWatcher {
        String id;
        Runnable runnable;

        ParticipantWatcher(final String str) {
            this.id = str;
            this.runnable = new Runnable() { // from class: io.rong.imlib.location.RealTimeLocation.ParticipantWatcher.1
                @Override // java.lang.Runnable
                public void run() {
                    Message messageObtain = Message.obtain();
                    messageObtain.what = 12;
                    messageObtain.obj = str;
                    RealTimeLocation.this.getHandler().sendMessage(messageObtain);
                }
            };
        }

        public void start() {
            RealTimeLocation.this.getHandler().postDelayed(this.runnable, RealTimeLocation.this.mRefreshInterval * 3);
        }

        public void stop() {
            RealTimeLocation.this.getHandler().removeCallbacks(this.runnable);
        }

        public void update() {
            RealTimeLocation.this.getHandler().removeCallbacks(this.runnable);
            RealTimeLocation.this.getHandler().postDelayed(this.runnable, RealTimeLocation.this.mRefreshInterval * 3);
        }
    }

    private class TerminalState extends State {
        private TerminalState() {
        }

        @Override // io.rong.imlib.stateMachine.State, io.rong.imlib.stateMachine.IState
        public void enter() {
            RLog.d(RealTimeLocation.TAG, "terminal enter : current = " + RealTimeLocation.this.mCurrentState);
            RealTimeLocation.this.mParticipants.clear();
            RealTimeLocation.this.stopTimer();
            if (RealTimeLocation.this.mWatcher.size() > 0) {
                Iterator it = RealTimeLocation.this.mWatcher.values().iterator();
                while (it.hasNext()) {
                    ((ParticipantWatcher) it.next()).stop();
                }
                RealTimeLocation.this.mWatcher.clear();
            }
            RealTimeLocation.this.getHandler().sendEmptyMessage(11);
        }

        @Override // io.rong.imlib.stateMachine.State, io.rong.imlib.stateMachine.IState
        public boolean processMessage(Message message) {
            RLog.i(RealTimeLocation.TAG, getName() + ", msg = " + message.what);
            if (message.what != 11 || RealTimeLocation.this.mOnRealTimeLocationQuitListener == null) {
                return true;
            }
            RealTimeLocation.this.mOnRealTimeLocationQuitListener.onRealTimeLocationQuit(RealTimeLocation.this.mConversationType, RealTimeLocation.this.mTargetId);
            return true;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public RealTimeLocation(Context context, Conversation.ConversationType conversationType, String str, RongIMClient.OnReceiveMessageListener onReceiveMessageListener) {
        String str2;
        if (conversationType == null) {
            str2 = "";
        } else {
            str2 = conversationType.getName() + str;
        }
        super(str2);
        this.mRefreshInterval = 10000;
        this.mFilterDistance = 5;
        this.mLatitude = 0.0d;
        this.mLongitude = 0.0d;
        this.mRealTimeLocationType = RealTimeLocationType.UNKNOWN;
        this.mOutgoingState = new OutgoingState();
        this.mIncomingState = new IncomingState();
        this.mConnectedState = new ConnectedState();
        this.mTerminalState = new TerminalState();
        RLog.d(TAG, "RealTimeLocation");
        this.mContext = context;
        this.mConversationType = conversationType;
        this.mTargetId = str;
        this.mClient = RongIMClient.getInstance();
        this.mCurrentState = RealTimeLocationConstant.RealTimeLocationStatus.RC_REAL_TIME_LOCATION_STATUS_IDLE;
        this.mParticipants = new ArrayList<>();
        this.mWatcher = new HashMap<>();
        this.mReceiveMessageListener = onReceiveMessageListener;
        LocationConfig locationConfig = NavigationCacheHelper.getLocationConfig(context);
        if (locationConfig != null) {
            this.mFilterDistance = locationConfig.getDistanceFilter();
            this.mRefreshInterval = locationConfig.getRefreshInterval() * 1000;
        }
        this.mRefreshRunnable = new Runnable() { // from class: io.rong.imlib.location.RealTimeLocation.3
            @Override // java.lang.Runnable
            public void run() {
                RealTimeLocation.this.getHandler().sendEmptyMessage(10);
                RealTimeLocation.this.getHandler().postDelayed(RealTimeLocation.this.mRefreshRunnable, RealTimeLocation.this.mRefreshInterval);
            }
        };
        this.mGpsEnable = isGpsEnable(context);
        IdleState idleState = new IdleState();
        addState(idleState);
        addState(this.mIncomingState, idleState);
        addState(this.mOutgoingState, idleState);
        addState(this.mConnectedState, idleState);
        addState(this.mTerminalState, idleState);
        setInitialState(idleState);
        start();
    }

    private Criteria getCriteria() {
        Criteria criteria = new Criteria();
        criteria.setAccuracy(1);
        criteria.setSpeedRequired(false);
        criteria.setCostAllowed(false);
        criteria.setBearingRequired(false);
        criteria.setAltitudeRequired(false);
        criteria.setPowerRequirement(1);
        return criteria;
    }

    private void gpsInit(Context context) {
        String str;
        RLog.d(TAG, "gpsInit");
        this.mLocationManager = (LocationManager) context.getSystemService("location");
        LocationManager locationManager = this.mLocationManager;
        if (locationManager == null || !locationManager.isProviderEnabled("gps")) {
            RLog.e(TAG, "GSP is disabled");
            return;
        }
        this.mGpsEnable = true;
        this.mLocationListener = new LocationListener() { // from class: io.rong.imlib.location.RealTimeLocation.4
            @Override // android.location.LocationListener
            public void onLocationChanged(Location location) {
                RLog.d(RealTimeLocation.TAG, "onLocationChanged");
                if (location != null) {
                    RealTimeLocation.this.mLatitude = location.getLatitude();
                    RealTimeLocation.this.mLongitude = location.getLongitude();
                }
            }

            @Override // android.location.LocationListener
            public void onProviderDisabled(String str2) {
                RealTimeLocation.this.mGpsEnable = false;
                RealTimeLocation.this.getHandler().sendEmptyMessage(14);
            }

            @Override // android.location.LocationListener
            public void onProviderEnabled(String str2) {
                RealTimeLocation.this.mGpsEnable = true;
                if (b.a(RealTimeLocation.this.mContext, "android.permission.ACCESS_FINE_LOCATION") != 0 && b.a(RealTimeLocation.this.mContext, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
                    RLog.e(RealTimeLocation.TAG, "permission is not granted");
                    return;
                }
                Location lastKnownLocation = RealTimeLocation.this.mLocationManager.getLastKnownLocation(str2);
                if (lastKnownLocation != null) {
                    RealTimeLocation.this.mLatitude = lastKnownLocation.getLatitude();
                    RealTimeLocation.this.mLongitude = lastKnownLocation.getLongitude();
                }
            }

            @Override // android.location.LocationListener
            public void onStatusChanged(String str2, int i, Bundle bundle) {
                RLog.d(RealTimeLocation.TAG, "onStatusChanged");
                if (i == 0) {
                    RLog.i(RealTimeLocation.TAG, "当前GPS状态为服务区外状态");
                } else if (i == 1) {
                    RLog.i(RealTimeLocation.TAG, "当前GPS状态为暂停服务状态");
                } else {
                    if (i != 2) {
                        return;
                    }
                    RLog.i(RealTimeLocation.TAG, "当前GPS状态为可见状态");
                }
            }
        };
        String bestProvider = this.mLocationManager.getBestProvider(getCriteria(), true);
        Location lastKnownLocation = bestProvider != null ? this.mLocationManager.getLastKnownLocation(bestProvider) : null;
        if (lastKnownLocation != null) {
            this.mLatitude = lastKnownLocation.getLatitude();
            this.mLongitude = lastKnownLocation.getLongitude();
        }
        String str2 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("gpsInit: location = ");
        if (lastKnownLocation != null) {
            str = "[ " + this.mLatitude + " " + this.mLongitude + " ]";
        } else {
            str = "null";
        }
        sb.append(str);
        RLog.e(str2, sb.toString());
    }

    private boolean isGpsEnable(Context context) {
        return h.a("android.permission.ACCESS_FINE_LOCATION") == null || context.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(RealTimeLocationConstant.RealTimeLocationErrorCode realTimeLocationErrorCode) {
        RealTimeLocationObserver realTimeLocationObserver = this.mObservers;
        if (realTimeLocationObserver != null) {
            realTimeLocationObserver.onError(realTimeLocationErrorCode);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onParticipantQuit(String str) {
        RealTimeLocationObserver realTimeLocationObserver = this.mObservers;
        if (realTimeLocationObserver != null) {
            realTimeLocationObserver.onParticipantsQuit(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onParticipantsJoin(String str) {
        RealTimeLocationObserver realTimeLocationObserver = this.mObservers;
        if (realTimeLocationObserver != null) {
            realTimeLocationObserver.onParticipantsJoin(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onReceiveLocation(double d2, double d3, RealTimeLocationType realTimeLocationType, String str) {
        RealTimeLocationObserver realTimeLocationObserver = this.mObservers;
        if (realTimeLocationObserver != null) {
            realTimeLocationObserver.onReceiveLocationWithType(d2, d3, realTimeLocationType, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStatusChanged(RealTimeLocationConstant.RealTimeLocationStatus realTimeLocationStatus) {
        RealTimeLocationObserver realTimeLocationObserver = this.mObservers;
        if (realTimeLocationObserver != null) {
            realTimeLocationObserver.onStatusChange(realTimeLocationStatus);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendJoinMessage() {
        this.mClient.sendMessage(this.mConversationType, this.mTargetId, RealTimeLocationJoinMessage.obtain("join real time location."), null, null, new IRongCallback.ISendMessageCallback() { // from class: io.rong.imlib.location.RealTimeLocation.6
            @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
            public void onAttached(io.rong.imlib.model.Message message) {
            }

            @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
            public void onError(io.rong.imlib.model.Message message, RongIMClient.ErrorCode errorCode) {
                if (RealTimeLocation.this.getHandler() != null) {
                    RealTimeLocation.this.getHandler().sendEmptyMessage(9);
                }
            }

            @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
            public void onSuccess(io.rong.imlib.model.Message message) {
                if (RealTimeLocation.this.getHandler() != null) {
                    RealTimeLocation.this.getHandler().sendEmptyMessage(7);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendLocationMessage() {
        this.mClient.sendMessage(this.mConversationType, this.mTargetId, RealTimeLocationStatusMessage.obtain(this.mLatitude, this.mLongitude, this.mRealTimeLocationType), null, null, new IRongCallback.ISendMessageCallback() { // from class: io.rong.imlib.location.RealTimeLocation.8
            @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
            public void onAttached(io.rong.imlib.model.Message message) {
            }

            @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
            public void onError(io.rong.imlib.model.Message message, RongIMClient.ErrorCode errorCode) {
                RLog.e(RealTimeLocation.TAG, "sendLocationMessage error = " + errorCode);
                if (RealTimeLocation.this.getHandler() == null || RealTimeLocation.this.getHandler().hasMessages(13)) {
                    return;
                }
                RealTimeLocation.this.getHandler().sendEmptyMessageDelayed(13, RealTimeLocation.this.mRefreshInterval * 3);
            }

            @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
            public void onSuccess(io.rong.imlib.model.Message message) {
                if (RealTimeLocation.this.getHandler() == null || !RealTimeLocation.this.getHandler().hasMessages(13)) {
                    return;
                }
                RealTimeLocation.this.getHandler().removeMessages(13);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendQuitMessage() {
        this.mClient.sendMessage(this.mConversationType, this.mTargetId, RealTimeLocationQuitMessage.obtain("quit real time location."), null, null, new IRongCallback.ISendMessageCallback() { // from class: io.rong.imlib.location.RealTimeLocation.7
            @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
            public void onAttached(io.rong.imlib.model.Message message) {
            }

            @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
            public void onError(io.rong.imlib.model.Message message, RongIMClient.ErrorCode errorCode) {
            }

            @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
            public void onSuccess(io.rong.imlib.model.Message message) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendStartMessage() {
        this.mClient.sendMessage(this.mConversationType, this.mTargetId, RealTimeLocationStartMessage.obtain("start real time location."), "收到一条位置共享消息", null, new IRongCallback.ISendMessageCallback() { // from class: io.rong.imlib.location.RealTimeLocation.5
            @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
            public void onAttached(io.rong.imlib.model.Message message) {
                if (RealTimeLocation.this.mReceiveMessageListener != null) {
                    message.setSentStatus(Message.SentStatus.SENT);
                    RealTimeLocation.this.mReceiveMessageListener.onReceived(message, 0);
                }
            }

            @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
            public void onError(io.rong.imlib.model.Message message, RongIMClient.ErrorCode errorCode) {
                if (RealTimeLocation.this.getHandler() != null) {
                    RealTimeLocation.this.getHandler().sendEmptyMessage(8);
                }
            }

            @Override // io.rong.imlib.IRongCallback.ISendMessageCallback
            public void onSuccess(io.rong.imlib.model.Message message) {
                if (RealTimeLocation.this.getHandler() != null) {
                    RealTimeLocation.this.getHandler().sendEmptyMessage(7);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startTimer() {
        getHandler().removeCallbacks(this.mRefreshRunnable);
        getHandler().postDelayed(this.mRefreshRunnable, this.mRefreshInterval);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopTimer() {
        getHandler().removeCallbacks(this.mRefreshRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSelfLocation() {
        onReceiveLocation(this.mLatitude, this.mLongitude, this.mRealTimeLocationType, this.mSelfId);
    }

    public void addListener(final RealTimeLocationObserver realTimeLocationObserver) {
        getHandler().post(new Runnable() { // from class: io.rong.imlib.location.RealTimeLocation.1
            @Override // java.lang.Runnable
            public void run() {
                RealTimeLocation.this.mObservers = realTimeLocationObserver;
            }
        });
    }

    public void deleteListener() {
        getHandler().post(new Runnable() { // from class: io.rong.imlib.location.RealTimeLocation.2
            @Override // java.lang.Runnable
            public void run() {
                RealTimeLocation.this.mObservers = null;
            }
        });
    }

    void destroy() {
        RLog.d(TAG, "destroy");
        quitNow();
        RongIMClient.getInstance().insertIncomingMessage(this.mConversationType, this.mTargetId, RongIMClient.getInstance().getCurrentUserId(), null, InformationNotificationMessage.obtain(this.mContext.getResources().getString(this.mContext.getResources().getIdentifier("rc_location_sharing_ended", "string", this.mContext.getPackageName()))), System.currentTimeMillis() - RongIMClient.getInstance().getDeltaTime(), new RongIMClient.ResultCallback<io.rong.imlib.model.Message>() { // from class: io.rong.imlib.location.RealTimeLocation.9
            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onError(RongIMClient.ErrorCode errorCode) {
            }

            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onSuccess(io.rong.imlib.model.Message message) {
                if (RealTimeLocation.this.mReceiveMessageListener != null) {
                    RealTimeLocation.this.mReceiveMessageListener.onReceived(message, 0);
                }
            }
        });
    }

    public List<String> getParticipants() {
        return this.mParticipants;
    }

    public RealTimeLocationConstant.RealTimeLocationStatus getRealTimeLocationCurrentState() {
        return this.mCurrentState;
    }

    public boolean gpsIsAvailable() {
        return this.mGpsEnable;
    }

    void setOnRealTimeLocationQuitListener(OnRealTimeLocationQuitListener onRealTimeLocationQuitListener) {
        this.mOnRealTimeLocationQuitListener = onRealTimeLocationQuitListener;
    }

    public void updateLocation(double d2, double d3) {
        this.mLatitude = d2;
        this.mLongitude = d3;
    }

    public void updateLocationWithType(double d2, double d3, RealTimeLocationType realTimeLocationType) {
        this.mLatitude = d2;
        this.mLongitude = d3;
        this.mRealTimeLocationType = realTimeLocationType;
    }
}
