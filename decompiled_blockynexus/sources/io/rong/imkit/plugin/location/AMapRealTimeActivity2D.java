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
import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.CameraUpdateFactory;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.model.BitmapDescriptorFactory;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.Marker;
import com.amap.api.maps2d.model.MarkerOptions;
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
public class AMapRealTimeActivity2D extends RongBaseNoActionbarActivity implements ILocationChangedListener, IUserInfoProvider.UserInfoCallback {
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
        public Marker targetMarker;
        public ImageView targetView;

        private UserTarget() {
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

    private UserTarget createUserTargetById(String str) {
        if (this.mUserTargetMap.get(str) != null) {
            return this.mUserTargetMap.get(str);
        }
        UserTarget userTarget = new UserTarget();
        userTarget.targetView = new ImageView(this);
        userTarget.targetView.setTag(str);
        userTarget.targetView.setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.plugin.location.AMapRealTimeActivity2D.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UserTarget userTarget2 = (UserTarget) AMapRealTimeActivity2D.this.mUserTargetMap.get((String) view.getTag());
                LatLng position = userTarget2 != null ? userTarget2.targetMarker.getPosition() : null;
                if (position != null) {
                    AMapRealTimeActivity2D.this.mAMap.animateCamera(CameraUpdateFactory.changeLatLng(position), (AMap.CancelableCallback) null);
                }
            }
        });
        float f2 = Resources.getSystem().getDisplayMetrics().density;
        int i = (int) ((40.0f * f2) + 0.5f);
        int i2 = (int) ((f2 * 2.0f) + 0.5f);
        userTarget.targetView.setLayoutParams(new ViewGroup.LayoutParams(i, i));
        userTarget.targetView.setPadding(i2, i2, i2, i2);
        setAvatar(userTarget.targetView, null);
        this.mTitleBar.addView(userTarget.targetView);
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.rc_icon_rt_location_marker, (ViewGroup) null);
        ImageView imageView = (ImageView) viewInflate.findViewById(android.R.id.icon1);
        setAvatar((ImageView) viewInflate.findViewById(android.R.id.icon), null);
        if (str.equals(RongIMClient.getInstance().getCurrentUserId())) {
            imageView.setImageResource(R.drawable.rc_rt_loc_myself);
        } else {
            imageView.setImageResource(R.drawable.rc_rt_loc_other);
        }
        userTarget.targetMarker = this.mAMap.addMarker(new MarkerOptions().anchor(0.5f, 0.5f).icon(BitmapDescriptorFactory.fromView(viewInflate)));
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
            LocationManager2D.getInstance().getUserInfo(str, this);
            updateParticipantTitleText();
        }
        this.mAMap.animateCamera(CameraUpdateFactory.zoomTo(17.0f), (AMap.CancelableCallback) null);
    }

    private void removeParticipantMarker(UserTarget userTarget) {
        userTarget.targetMarker.remove();
    }

    private void removeParticipantTitleIcon(final UserTarget userTarget) {
        this.mHandler.post(new Runnable() { // from class: io.rong.imkit.plugin.location.AMapRealTimeActivity2D.5
            @Override // java.lang.Runnable
            public void run() {
                AMapRealTimeActivity2D.this.mTitleBar.removeView(userTarget.targetView);
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
                e2.printStackTrace();
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
    public void updateParticipantMarker(double d2, double d3, String str) {
        UserTarget userTargetCreateUserTargetById = this.mUserTargetMap.get(str);
        if (userTargetCreateUserTargetById == null) {
            userTargetCreateUserTargetById = createUserTargetById(str);
            this.mUserTargetMap.put(str, userTargetCreateUserTargetById);
            LocationManager2D.getInstance().getUserInfo(str, this);
            if (!this.mParticipants.contains(str)) {
                this.mParticipants.add(str);
            }
        }
        userTargetCreateUserTargetById.targetMarker.setPosition(new LatLng(d2, d3));
        updateParticipantTitleText();
        if (!str.equals(RongIMClient.getInstance().getCurrentUserId()) || this.mHasAnimate || d2 == 0.0d || d3 == 0.0d) {
            return;
        }
        this.mAMap.animateCamera(CameraUpdateFactory.changeLatLng(new LatLng(d2, d3)), (AMap.CancelableCallback) null);
        this.mHasAnimate = true;
    }

    private void updateParticipantTitleText() {
        this.mHandler.post(new Runnable() { // from class: io.rong.imkit.plugin.location.AMapRealTimeActivity2D.6
            @Override // java.lang.Runnable
            public void run() {
                if (AMapRealTimeActivity2D.this.mUserTargetMap.size() == 0) {
                    RLog.e(AMapRealTimeActivity2D.TAG, "mUserTargetMap size is 0 ");
                } else {
                    AMapRealTimeActivity2D.this.mUserText.setText(String.format(AMapRealTimeActivity2D.this.getResources().getString(R.string.rc_others_are_sharing_location2), Integer.valueOf(AMapRealTimeActivity2D.this.mUserTargetMap.size())));
                }
            }
        });
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.rc_location_real_time_activity_2d);
        this.mHandler = new Handler();
        this.mUserTargetMap = new HashMap();
        this.mAMapView = findViewById(R.id.rc_ext_amap);
        this.mAMapView.onCreate(bundle);
        findViewById(R.id.rc_toolbar_close).setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.plugin.location.AMapRealTimeActivity2D.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PromptPopupDialog promptPopupDialogNewInstance = PromptPopupDialog.newInstance(view.getContext(), "", AMapRealTimeActivity2D.this.getString(R.string.rc_ext_exit_location_sharing), AMapRealTimeActivity2D.this.getString(R.string.rc_ext_exit_location_sharing_confirm));
                promptPopupDialogNewInstance.setPromptButtonClickedListener(new PromptPopupDialog.OnPromptButtonClickedListener() { // from class: io.rong.imkit.plugin.location.AMapRealTimeActivity2D.1.1
                    @Override // io.rong.imkit.utilities.PromptPopupDialog.OnPromptButtonClickedListener
                    public void onPositiveButtonClicked() {
                        LocationManager2D.getInstance().quitLocationSharing();
                        AMapRealTimeActivity2D.this.finish();
                    }
                });
                promptPopupDialogNewInstance.show();
            }
        });
        findViewById(R.id.rc_toolbar_hide).setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.plugin.location.AMapRealTimeActivity2D.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AMapRealTimeActivity2D.this.finish();
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
        LocationManager2D.getInstance().setLocationChangedListener(this);
        LocationManager2D.getInstance().setMyLocationChangedListener(new IMyLocationChangedListener() { // from class: io.rong.imkit.plugin.location.AMapRealTimeActivity2D.3
            @Override // io.rong.imkit.plugin.location.IMyLocationChangedListener
            public void onMyLocationChanged(AMapLocationInfo aMapLocationInfo) {
                AMapRealTimeActivity2D.this.updateParticipantMarker(aMapLocationInfo.getLat(), aMapLocationInfo.getLng(), RongIMClient.getInstance().getCurrentUserId());
            }
        });
        LocationManager2D.getInstance().updateMyLocationInLoop(5);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        RLog.d(TAG, "onDestroy()");
        this.mAMapView.onDestroy();
        LocationManager2D.getInstance().setLocationChangedListener(null);
        super.onDestroy();
    }

    @Override // io.rong.imkit.plugin.location.ILocationChangedListener
    public void onError(RealTimeLocationConstant.RealTimeLocationErrorCode realTimeLocationErrorCode) {
        Toast.makeText(this, R.string.rc_network_exception, 0).show();
        LocationManager2D.getInstance().quitLocationSharing();
        finish();
    }

    @Override // io.rong.imkit.plugin.location.IUserInfoProvider.UserInfoCallback
    public void onGotUserInfo(UserInfo userInfo) {
        String userId = userInfo.getUserId();
        UserTarget userTarget = this.mUserTargetMap.get(userId);
        if (userTarget != null) {
            setAvatar(userTarget.targetView, userInfo.getPortraitUri() != null ? userInfo.getPortraitUri().toString() : null);
            View viewInflate = LayoutInflater.from(this).inflate(R.layout.rc_icon_rt_location_marker, (ViewGroup) null);
            ImageView imageView = (ImageView) viewInflate.findViewById(android.R.id.icon);
            ImageView imageView2 = (ImageView) viewInflate.findViewById(android.R.id.icon1);
            setAvatar(imageView, userInfo.getPortraitUri() != null ? userInfo.getPortraitUri().toString() : null);
            if (userId.equals(RongIMClient.getInstance().getCurrentUserId())) {
                imageView2.setImageResource(R.drawable.rc_rt_loc_myself);
            } else {
                imageView2.setImageResource(R.drawable.rc_rt_loc_other);
            }
            userTarget.targetMarker.setIcon(BitmapDescriptorFactory.fromView(viewInflate));
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
        LocationManager2D.getInstance().getUserInfo(str, this);
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

    @Override // io.rong.imkit.plugin.location.ILocationChangedListener
    public void onSharingTerminated() {
    }
}
