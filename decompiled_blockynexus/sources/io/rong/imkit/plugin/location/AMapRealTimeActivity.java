package io.rong.imkit.plugin.location;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import io.rong.common.RLog;
import io.rong.imageloader.core.DisplayImageOptions;
import io.rong.imageloader.core.ImageLoader;
import io.rong.imageloader.core.assist.LoadedFrom;
import io.rong.imageloader.core.display.CircleBitmapDisplayer;
import io.rong.imageloader.core.imageaware.ImageViewAware;
import io.rong.imageloader.core.listener.ImageLoadingListener;
import io.rong.imageloader.core.listener.ImageLoadingProgressListener;
import io.rong.imkit.R;
import io.rong.imkit.RongBaseNoActionbarActivity;
import io.rong.imkit.plugin.location.IUserInfoProvider;
import io.rong.imkit.utilities.PromptPopupDialog;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.location.RealTimeLocationConstant;
import io.rong.imlib.model.UserInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class AMapRealTimeActivity extends RongBaseNoActionbarActivity implements ILocationChangedListener, IUserInfoProvider.UserInfoCallback {
    private static final String TAG = "AMapRealTimeActivity";
    private AMap mAMap;
    private MapView mAMapView;
    private Handler mHandler;
    private boolean mHasAnimate;
    private ArrayList<String> mParticipants;
    private ViewGroup mTitleBar;
    private Map<String, UserTarget> mUserTargetMap;
    private TextView mUserText;

    private class UserTarget {
        private Marker targetMarker;
        private ImageView targetView;

        private UserTarget() {
        }

        public Marker getTargetMarker() {
            return this.targetMarker;
        }

        public ImageView getTargetView() {
            return this.targetView;
        }

        public void setTargetMarker(Marker marker) {
            this.targetMarker = marker;
        }

        public void setTargetView(ImageView imageView) {
            this.targetView = imageView;
        }
    }

    private DisplayImageOptions createDisplayImageOptions(int i) {
        DisplayImageOptions.Builder builder = new DisplayImageOptions.Builder();
        if (i != 0) {
            Drawable drawable = getResources().getDrawable(i);
            builder.showImageOnLoading(drawable);
            builder.showImageForEmptyUri(drawable);
            builder.showImageOnFail(drawable);
        }
        builder.displayer(new CircleBitmapDisplayer());
        return builder.resetViewBeforeLoading(false).cacheInMemory(true).cacheOnDisk(true).bitmapConfig(Bitmap.Config.RGB_565).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public UserTarget createUserTargetById(String str) {
        if (this.mUserTargetMap.get(str) != null) {
            return this.mUserTargetMap.get(str);
        }
        UserTarget userTarget = new UserTarget();
        userTarget.setTargetView(new ImageView(this));
        userTarget.getTargetView().setTag(str);
        userTarget.getTargetView().setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.plugin.location.AMapRealTimeActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserTarget userTarget2 = (UserTarget) AMapRealTimeActivity.this.mUserTargetMap.get((String) view.getTag());
                LatLng position = userTarget2 != null ? userTarget2.getTargetMarker().getPosition() : null;
                if (position != null) {
                    AMapRealTimeActivity.this.mAMap.animateCamera(CameraUpdateFactory.changeLatLng(position), (AMap.CancelableCallback) null);
                }
            }
        });
        float f2 = Resources.getSystem().getDisplayMetrics().density;
        int i = (int) ((40.0f * f2) + 0.5f);
        int i2 = (int) ((f2 * 2.0f) + 0.5f);
        userTarget.getTargetView().setLayoutParams(new ViewGroup.LayoutParams(i, i));
        userTarget.getTargetView().setPadding(i2, i2, i2, i2);
        setAvatar(userTarget.getTargetView(), null);
        this.mTitleBar.addView(userTarget.getTargetView());
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.rc_icon_rt_location_marker, (ViewGroup) null);
        ImageView imageView = (ImageView) viewInflate.findViewById(android.R.id.icon1);
        setAvatar((ImageView) viewInflate.findViewById(android.R.id.icon), null);
        if (str.equals(RongIMClient.getInstance().getCurrentUserId())) {
            imageView.setImageResource(R.drawable.rc_rt_loc_myself);
        } else {
            imageView.setImageResource(R.drawable.rc_rt_loc_other);
        }
        userTarget.setTargetMarker(this.mAMap.addMarker(new MarkerOptions().anchor(0.5f, 0.5f).icon(BitmapDescriptorFactory.fromView(viewInflate))));
        return userTarget;
    }

    private Bitmap drawableToBitmap(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    private void initMap() {
        this.mAMap = this.mAMapView.getMap();
        this.mAMap.getUiSettings().setMyLocationButtonEnabled(false);
        this.mAMap.setMapType(1);
        for (String str : this.mParticipants) {
            this.mUserTargetMap.put(str, createUserTargetById(str));
            LocationManager.getInstance().getUserInfo(str, this);
            updateParticipantTitleText();
        }
        this.mAMap.animateCamera(CameraUpdateFactory.zoomTo(17.0f), (AMap.CancelableCallback) null);
    }

    private void removeParticipantMarker(UserTarget userTarget) {
        userTarget.getTargetMarker().remove();
    }

    private void removeParticipantTitleIcon(final UserTarget userTarget) {
        this.mHandler.post(new Runnable() { // from class: io.rong.imkit.plugin.location.AMapRealTimeActivity.5
            @Override // java.lang.Runnable
            public void run() {
                AMapRealTimeActivity.this.mTitleBar.removeView(userTarget.getTargetView());
            }
        });
    }

    private void setAvatar(ImageView imageView, String str) {
        DisplayImageOptions displayImageOptionsCreateDisplayImageOptions = createDisplayImageOptions(str == null ? R.drawable.rc_ext_realtime_default_avatar : 0);
        ImageViewAware imageViewAware = new ImageViewAware(imageView);
        if (str == null) {
            try {
                displayImageOptionsCreateDisplayImageOptions.getDisplayer().display(drawableToBitmap(displayImageOptionsCreateDisplayImageOptions.getImageForEmptyUri(null)), imageViewAware, LoadedFrom.DISC_CACHE);
                return;
            } catch (Exception e2) {
                RLog.e(TAG, "setAvatar", e2);
                return;
            }
        }
        File file = ImageLoader.getInstance().getDiskCache().get(str);
        if (file == null || !file.exists()) {
            if (TextUtils.isEmpty(str)) {
                RLog.e(TAG, "SetAvatar, url is empty");
                return;
            } else {
                ImageLoader.getInstance().displayImage(str, imageViewAware, displayImageOptionsCreateDisplayImageOptions, (ImageLoadingListener) null, (ImageLoadingProgressListener) null);
                return;
            }
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 1;
            displayImageOptionsCreateDisplayImageOptions.getDisplayer().display(BitmapFactory.decodeFile(file.getAbsolutePath(), options), imageViewAware, LoadedFrom.DISC_CACHE);
        } catch (Exception e3) {
            RLog.e(TAG, "setAvatar", e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateParticipantMarker(final double d2, final double d3, final String str) {
        this.mHandler.post(new Runnable() { // from class: io.rong.imkit.plugin.location.AMapRealTimeActivity.7
            @Override // java.lang.Runnable
            public void run() {
                UserTarget userTargetCreateUserTargetById = (UserTarget) AMapRealTimeActivity.this.mUserTargetMap.get(str);
                if (userTargetCreateUserTargetById == null) {
                    userTargetCreateUserTargetById = AMapRealTimeActivity.this.createUserTargetById(str);
                    AMapRealTimeActivity.this.mUserTargetMap.put(str, userTargetCreateUserTargetById);
                    LocationManager.getInstance().getUserInfo(str, AMapRealTimeActivity.this);
                    if (!AMapRealTimeActivity.this.mParticipants.contains(str)) {
                        AMapRealTimeActivity.this.mParticipants.add(str);
                    }
                }
                userTargetCreateUserTargetById.getTargetMarker().setPosition(new LatLng(d2, d3));
                AMapRealTimeActivity.this.updateParticipantTitleText();
                if (!str.equals(RongIMClient.getInstance().getCurrentUserId()) || AMapRealTimeActivity.this.mHasAnimate) {
                    return;
                }
                double d4 = d2;
                if (d4 != 0.0d) {
                    double d5 = d3;
                    if (d5 != 0.0d) {
                        AMapRealTimeActivity.this.mAMap.animateCamera(CameraUpdateFactory.changeLatLng(new LatLng(d4, d5)), (AMap.CancelableCallback) null);
                        AMapRealTimeActivity.this.mHasAnimate = true;
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateParticipantTitleText() {
        this.mHandler.post(new Runnable() { // from class: io.rong.imkit.plugin.location.AMapRealTimeActivity.6
            @Override // java.lang.Runnable
            public void run() {
                if (AMapRealTimeActivity.this.mUserTargetMap.size() == 0) {
                    RLog.e(AMapRealTimeActivity.TAG, "mUserTargetMap size is 0 ");
                } else {
                    AMapRealTimeActivity.this.mUserText.setText(String.format(AMapRealTimeActivity.this.getResources().getString(R.string.rc_others_are_sharing_location2), Integer.valueOf(AMapRealTimeActivity.this.mUserTargetMap.size())));
                }
            }
        });
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.rc_location_real_time_activity);
        this.mHandler = new Handler();
        this.mUserTargetMap = new HashMap();
        this.mAMapView = findViewById(R.id.rc_ext_amap);
        this.mAMapView.onCreate(bundle);
        findViewById(R.id.rc_toolbar_close).setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.plugin.location.AMapRealTimeActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PromptPopupDialog promptPopupDialogNewInstance = PromptPopupDialog.newInstance(view.getContext(), "", AMapRealTimeActivity.this.getString(R.string.rc_ext_exit_location_sharing), AMapRealTimeActivity.this.getString(R.string.rc_ext_exit_location_sharing_confirm));
                promptPopupDialogNewInstance.setPromptButtonClickedListener(new PromptPopupDialog.OnPromptButtonClickedListener() { // from class: io.rong.imkit.plugin.location.AMapRealTimeActivity.1.1
                    @Override // io.rong.imkit.utilities.PromptPopupDialog.OnPromptButtonClickedListener
                    public void onPositiveButtonClicked() {
                        LocationManager.getInstance().quitLocationSharing();
                        AMapRealTimeActivity.this.finish();
                    }
                });
                promptPopupDialogNewInstance.show();
            }
        });
        findViewById(R.id.rc_toolbar_hide).setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.plugin.location.AMapRealTimeActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AMapRealTimeActivity.this.finish();
            }
        });
        this.mTitleBar = (ViewGroup) findViewById(R.id.rc_user_icons);
        this.mUserText = (TextView) findViewById(R.id.rc_user_text);
        this.mParticipants = getIntent().getStringArrayListExtra("participants");
        if (this.mParticipants == null) {
            this.mParticipants = new ArrayList<>();
            this.mParticipants.add(RongIMClient.getInstance().getCurrentUserId());
        }
        initMap();
        LocationManager.getInstance().setLocationChangedListener(this);
        LocationManager.getInstance().setMyLocationChangedListener(new IMyLocationChangedListener() { // from class: io.rong.imkit.plugin.location.AMapRealTimeActivity.3
            @Override // io.rong.imkit.plugin.location.IMyLocationChangedListener
            public void onMyLocationChanged(AMapLocationInfo aMapLocationInfo) {
                AMapRealTimeActivity.this.updateParticipantMarker(aMapLocationInfo.getLat(), aMapLocationInfo.getLng(), RongIMClient.getInstance().getCurrentUserId());
            }
        });
        LocationManager.getInstance().updateMyLocationInLoop(5);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        RLog.d(TAG, "onDestroy()");
        this.mAMapView.onDestroy();
        LocationManager.getInstance().setLocationChangedListener(null);
        LocationManager.getInstance().setMyLocationChangedListener(null);
        super.onDestroy();
    }

    @Override // io.rong.imkit.plugin.location.ILocationChangedListener
    public void onError(RealTimeLocationConstant.RealTimeLocationErrorCode realTimeLocationErrorCode) {
        Toast.makeText(this, R.string.rc_network_exception, 0).show();
        LocationManager.getInstance().quitLocationSharing();
        finish();
    }

    @Override // io.rong.imkit.plugin.location.IUserInfoProvider.UserInfoCallback
    public void onGotUserInfo(UserInfo userInfo) {
        String userId = userInfo.getUserId();
        UserTarget userTarget = this.mUserTargetMap.get(userId);
        if (userTarget != null) {
            setAvatar(userTarget.getTargetView(), userInfo.getPortraitUri() != null ? userInfo.getPortraitUri().toString() : null);
            View viewInflate = LayoutInflater.from(this).inflate(R.layout.rc_icon_rt_location_marker, (ViewGroup) null);
            ImageView imageView = (ImageView) viewInflate.findViewById(android.R.id.icon);
            ImageView imageView2 = (ImageView) viewInflate.findViewById(android.R.id.icon1);
            setAvatar(imageView, userInfo.getPortraitUri() != null ? userInfo.getPortraitUri().toString() : null);
            if (userId.equals(RongIMClient.getInstance().getCurrentUserId())) {
                imageView2.setImageResource(R.drawable.rc_rt_loc_myself);
            } else {
                imageView2.setImageResource(R.drawable.rc_rt_loc_other);
            }
            userTarget.getTargetMarker().setIcon(BitmapDescriptorFactory.fromView(viewInflate));
        }
    }

    @Override // io.rong.imkit.plugin.location.ILocationChangedListener
    public void onLocationChanged(double d2, double d3, String str) {
        updateParticipantMarker(d2, d3, str);
    }

    @Override // io.rong.imkit.plugin.location.ILocationChangedListener
    public void onParticipantJoinSharing(String str) {
        if (this.mUserTargetMap.get(str) != null) {
            return;
        }
        if (!this.mParticipants.contains(str)) {
            this.mParticipants.add(str);
        }
        this.mUserTargetMap.put(str, createUserTargetById(str));
        LocationManager.getInstance().getUserInfo(str, this);
        updateParticipantTitleText();
    }

    @Override // io.rong.imkit.plugin.location.ILocationChangedListener
    public void onParticipantQuitSharing(String str) {
        UserTarget userTarget = this.mUserTargetMap.get(str);
        this.mParticipants.remove(str);
        if (userTarget != null) {
            this.mUserTargetMap.remove(str);
            removeParticipantTitleIcon(userTarget);
            updateParticipantTitleText();
            removeParticipantMarker(userTarget);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mAMapView.onPause();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mAMapView.onResume();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.mAMapView.onSaveInstanceState(bundle);
    }

    @Override // io.rong.imkit.plugin.location.ILocationChangedListener
    public void onSharingTerminated() {
    }
}
