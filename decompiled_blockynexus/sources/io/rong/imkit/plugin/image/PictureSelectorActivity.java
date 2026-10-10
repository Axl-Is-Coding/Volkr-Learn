package io.rong.imkit.plugin.image;

import a.a.b;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.CursorLoader;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaMetadataRetriever;
import android.media.MediaScannerConnection;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import com.alibaba.sdk.android.feedback.windvane.WXBaseHybridActivity;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.j;
import com.umeng.analytics.pro.ay;
import io.rong.common.FileUtils;
import io.rong.common.RLog;
import io.rong.imkit.R;
import io.rong.imkit.RongBaseNoActionbarActivity;
import io.rong.imkit.plugin.image.AlbumBitmapCacheHelper;
import io.rong.imkit.utilities.KitStorageUtils;
import io.rong.imkit.utilities.PermissionCheckUtil;
import io.rong.imlib.IMLibExtensionModuleManager;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.HardwareResource;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public class PictureSelectorActivity extends RongBaseNoActionbarActivity {
    public static final int REQUEST_CAMERA = 1;
    public static final int REQUEST_CODE_ASK_PERMISSIONS = 100;
    public static final int REQUEST_PREVIEW = 0;
    public static final int SIGHT_DEFAULT_DURATION_LIMIT = 300;
    private static final String TAG = "PictureSelectorActivity";
    private Handler bgHandler;
    private ImageButton mBtnBack;
    private Button mBtnSend;
    private ListView mCatalogListView;
    private View mCatalogView;
    private GridView mGridView;
    private PicTypeBtn mPicType;
    private PreviewBtn mPreviewBtn;
    private Uri mTakePictureUri;
    private int perHeight;
    private int perWidth;
    private ExecutorService pool;
    private HandlerThread thread;
    private Handler uiHandler;
    private List<MediaItem> mAllItemList = new ArrayList();
    private Map<String, List<MediaItem>> mItemMap = new b();
    private ArrayList<Uri> mAllSelectedItemList = new ArrayList<>();
    private List<String> mCatalogList = new ArrayList();
    private String mCurrentCatalog = "";
    private boolean mSendOrigin = false;

    private class CatalogAdapter extends BaseAdapter {
        private LayoutInflater mInflater;

        private class ViewHolder {
            ImageView image;
            TextView name;
            TextView number;
            ImageView selected;

            private ViewHolder() {
            }
        }

        public CatalogAdapter() {
            this.mInflater = PictureSelectorActivity.this.getLayoutInflater();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return PictureSelectorActivity.this.mItemMap.size() + 1;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(final int i, View view, ViewGroup viewGroup) {
            final ViewHolder viewHolder;
            String str;
            int size;
            String string;
            boolean zIsEmpty;
            String str2;
            if (view == null) {
                view = this.mInflater.inflate(R.layout.rc_picsel_catalog_listview, viewGroup, false);
                viewHolder = new ViewHolder();
                viewHolder.image = (ImageView) view.findViewById(R.id.image);
                viewHolder.name = (TextView) view.findViewById(R.id.name);
                viewHolder.number = (TextView) view.findViewById(R.id.number);
                viewHolder.selected = (ImageView) view.findViewById(R.id.selected);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            if (viewHolder.image.getTag() != null) {
                AlbumBitmapCacheHelper.getInstance().removePathFromShowlist((String) viewHolder.image.getTag());
            }
            if (i == 0) {
                if (PictureSelectorActivity.this.mItemMap.size() == 0) {
                    viewHolder.image.setImageResource(R.drawable.rc_picsel_empty_pic);
                } else {
                    List list = (List) PictureSelectorActivity.this.mItemMap.get(PictureSelectorActivity.this.mCatalogList.get(0));
                    if (list == null || list.size() <= 0) {
                        str2 = "";
                    } else {
                        final MediaItem mediaItem = (MediaItem) list.get(0);
                        if (mediaItem.mediaType == 1) {
                            str2 = KitStorageUtils.isBuildAndTargetForQ(PictureSelectorActivity.this) ? mediaItem.uri_sdk29 : mediaItem.uri;
                        } else {
                            String str3 = KitStorageUtils.getImageSavePath(PictureSelectorActivity.this) + File.separator + mediaItem.name;
                            if (!new File(str3).exists()) {
                                new Thread(new Runnable() { // from class: io.rong.imkit.plugin.image.PictureSelectorActivity.CatalogAdapter.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Bitmap frameAtTime;
                                        if (KitStorageUtils.isBuildAndTargetForQ(PictureSelectorActivity.this)) {
                                            try {
                                                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                                                mediaMetadataRetriever.setDataSource(PictureSelectorActivity.this.getApplicationContext(), Uri.parse(mediaItem.uri_sdk29));
                                                frameAtTime = mediaMetadataRetriever.getFrameAtTime();
                                            } catch (Exception e2) {
                                                RLog.e(PictureSelectorActivity.TAG, "video get thumbnail error", e2);
                                                frameAtTime = null;
                                            }
                                        } else {
                                            frameAtTime = ThumbnailUtils.createVideoThumbnail(mediaItem.uri, 1);
                                        }
                                        if (frameAtTime != null) {
                                            final File fileConvertBitmap2File = FileUtils.convertBitmap2File(frameAtTime, KitStorageUtils.getImageSavePath(PictureSelectorActivity.this), mediaItem.name);
                                            PictureSelectorActivity.this.runOnUiThread(new Runnable() { // from class: io.rong.imkit.plugin.image.PictureSelectorActivity.CatalogAdapter.1.1
                                                @Override // java.lang.Runnable
                                                public void run() {
                                                    PictureSelectorActivity pictureSelectorActivity = PictureSelectorActivity.this;
                                                    String absolutePath = fileConvertBitmap2File.getAbsolutePath();
                                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                                    pictureSelectorActivity.setImageViewBackground(absolutePath, viewHolder.image, i);
                                                }
                                            });
                                        }
                                    }
                                }).start();
                            }
                            str2 = str3;
                        }
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        AlbumBitmapCacheHelper.getInstance().addPathToShowlist(str2);
                        viewHolder.image.setTag(str2);
                        PictureSelectorActivity.this.setImageViewBackground(str2, viewHolder.image, i);
                    }
                }
                string = PictureSelectorActivity.this.getResources().getString(R.string.rc_picsel_catalog_allpic);
                viewHolder.number.setVisibility(8);
                zIsEmpty = PictureSelectorActivity.this.mCurrentCatalog.isEmpty();
                size = 0;
            } else {
                int i2 = i - 1;
                final MediaItem mediaItem2 = (MediaItem) ((List) PictureSelectorActivity.this.mItemMap.get(PictureSelectorActivity.this.mCatalogList.get(i2))).get(0);
                if (mediaItem2.mediaType == 1) {
                    str = KitStorageUtils.isBuildAndTargetForQ(PictureSelectorActivity.this) ? mediaItem2.uri_sdk29 : mediaItem2.uri;
                } else {
                    String str4 = KitStorageUtils.getImageSavePath(PictureSelectorActivity.this) + File.separator + mediaItem2.name;
                    if (!new File(str4).exists()) {
                        new Thread(new Runnable() { // from class: io.rong.imkit.plugin.image.PictureSelectorActivity.CatalogAdapter.2
                            @Override // java.lang.Runnable
                            public void run() {
                                Bitmap frameAtTime;
                                if (KitStorageUtils.isBuildAndTargetForQ(PictureSelectorActivity.this)) {
                                    try {
                                        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                                        mediaMetadataRetriever.setDataSource(PictureSelectorActivity.this.getApplicationContext(), Uri.parse(mediaItem2.uri_sdk29));
                                        frameAtTime = mediaMetadataRetriever.getFrameAtTime();
                                    } catch (Exception e2) {
                                        RLog.e(PictureSelectorActivity.TAG, "video get thumbnail error", e2);
                                        frameAtTime = null;
                                    }
                                } else {
                                    frameAtTime = ThumbnailUtils.createVideoThumbnail(mediaItem2.uri, 1);
                                }
                                if (frameAtTime != null) {
                                    final File fileConvertBitmap2File = FileUtils.convertBitmap2File(frameAtTime, KitStorageUtils.getImageSavePath(PictureSelectorActivity.this), mediaItem2.name);
                                    PictureSelectorActivity.this.runOnUiThread(new Runnable() { // from class: io.rong.imkit.plugin.image.PictureSelectorActivity.CatalogAdapter.2.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            PictureSelectorActivity pictureSelectorActivity = PictureSelectorActivity.this;
                                            String absolutePath = fileConvertBitmap2File.getAbsolutePath();
                                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                            pictureSelectorActivity.setImageViewBackground(absolutePath, viewHolder.image, i);
                                        }
                                    });
                                }
                            }
                        }).start();
                    }
                    str = str4;
                }
                String str5 = (String) PictureSelectorActivity.this.mCatalogList.get(i2);
                size = ((List) PictureSelectorActivity.this.mItemMap.get(PictureSelectorActivity.this.mCatalogList.get(i2))).size();
                viewHolder.number.setVisibility(0);
                boolean zEquals = str5.equals(PictureSelectorActivity.this.mCurrentCatalog);
                AlbumBitmapCacheHelper.getInstance().addPathToShowlist(str);
                viewHolder.image.setTag(str);
                PictureSelectorActivity.this.setImageViewBackground(str, viewHolder.image, i);
                string = str5;
                zIsEmpty = zEquals;
            }
            viewHolder.name.setText(string);
            viewHolder.number.setText(String.format(PictureSelectorActivity.this.getResources().getString(R.string.rc_picsel_catalog_number), Integer.valueOf(size)));
            viewHolder.selected.setVisibility(zIsEmpty ? 0 : 4);
            return view;
        }
    }

    private class GridViewAdapter extends BaseAdapter {
        private LayoutInflater mInflater;

        private class ViewHolder {
            SelectBox checkBox;
            ImageView image;
            View mask;
            View videoContainer;
            TextView videoDuration;

            private ViewHolder() {
            }
        }

        public GridViewAdapter() {
            this.mInflater = PictureSelectorActivity.this.getLayoutInflater();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int size = 1;
            if (!PictureSelectorActivity.this.mCurrentCatalog.isEmpty()) {
                List list = (List) PictureSelectorActivity.this.mItemMap.get(PictureSelectorActivity.this.mCurrentCatalog);
                if (list != null) {
                    return 1 + list.size();
                }
                return 1;
            }
            Iterator it = PictureSelectorActivity.this.mItemMap.keySet().iterator();
            while (it.hasNext()) {
                List list2 = (List) PictureSelectorActivity.this.mItemMap.get((String) it.next());
                if (list2 != null) {
                    size += list2.size();
                }
            }
            return size;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        @TargetApi(23)
        public View getView(final int i, View view, ViewGroup viewGroup) {
            final MediaItem itemAt;
            final ViewHolder viewHolder;
            String str;
            if (i == 0) {
                View viewInflate = this.mInflater.inflate(R.layout.rc_picsel_grid_camera, viewGroup, false);
                ((ImageButton) viewInflate.findViewById(R.id.camera_mask)).setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.plugin.image.PictureSelectorActivity.GridViewAdapter.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        String[] strArr = {"android.permission.CAMERA"};
                        if (PermissionCheckUtil.checkPermissions(PictureSelectorActivity.this, strArr)) {
                            PictureSelectorActivity.this.requestCamera();
                        } else {
                            PermissionCheckUtil.requestPermissions(PictureSelectorActivity.this, strArr, 100);
                        }
                    }
                });
                return viewInflate;
            }
            if (PictureSelectorActivity.this.mCurrentCatalog.isEmpty()) {
                itemAt = (MediaItem) PictureSelectorActivity.this.mAllItemList.get(i - 1);
            } else {
                PictureSelectorActivity pictureSelectorActivity = PictureSelectorActivity.this;
                itemAt = pictureSelectorActivity.getItemAt(pictureSelectorActivity.mCurrentCatalog, i - 1);
            }
            if (view == null || view.getTag() == null) {
                view = this.mInflater.inflate(R.layout.rc_picsel_grid_item, viewGroup, false);
                viewHolder = new ViewHolder();
                viewHolder.image = (ImageView) view.findViewById(R.id.image);
                viewHolder.mask = view.findViewById(R.id.mask);
                viewHolder.checkBox = (SelectBox) view.findViewById(R.id.checkbox);
                viewHolder.videoContainer = view.findViewById(R.id.video_container);
                viewHolder.videoDuration = (TextView) view.findViewById(R.id.video_duration);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            if (viewHolder.image.getTag() != null) {
                AlbumBitmapCacheHelper.getInstance().removePathFromShowlist((String) viewHolder.image.getTag());
            }
            if (itemAt == null) {
                return view;
            }
            int i2 = itemAt.mediaType;
            if (i2 == 1) {
                str = KitStorageUtils.isBuildAndTargetForQ(PictureSelectorActivity.this) ? itemAt.uri_sdk29 : itemAt.uri;
            } else if (i2 != 3) {
                str = "";
            } else {
                str = KitStorageUtils.getImageSavePath(PictureSelectorActivity.this) + File.separator + itemAt.name;
                if (!new File(str).exists()) {
                    PictureSelectorActivity.this.pool.execute(new Runnable() { // from class: io.rong.imkit.plugin.image.PictureSelectorActivity.GridViewAdapter.2
                        @Override // java.lang.Runnable
                        public void run() {
                            Bitmap frameAtTime;
                            if (KitStorageUtils.isBuildAndTargetForQ(PictureSelectorActivity.this)) {
                                try {
                                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                                    mediaMetadataRetriever.setDataSource(PictureSelectorActivity.this.getApplicationContext(), Uri.parse(itemAt.uri_sdk29));
                                    frameAtTime = mediaMetadataRetriever.getFrameAtTime();
                                } catch (Exception e2) {
                                    RLog.e(PictureSelectorActivity.TAG, "video get thumbnail error", e2);
                                    frameAtTime = null;
                                }
                            } else {
                                frameAtTime = ThumbnailUtils.createVideoThumbnail(itemAt.uri, 1);
                            }
                            if (frameAtTime != null) {
                                final File fileConvertBitmap2File = FileUtils.convertBitmap2File(frameAtTime, KitStorageUtils.getImageSavePath(PictureSelectorActivity.this), itemAt.name);
                                PictureSelectorActivity.this.runOnUiThread(new Runnable() { // from class: io.rong.imkit.plugin.image.PictureSelectorActivity.GridViewAdapter.2.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        PictureSelectorActivity pictureSelectorActivity2 = PictureSelectorActivity.this;
                                        String absolutePath = fileConvertBitmap2File.getAbsolutePath();
                                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                        pictureSelectorActivity2.setImageViewBackground(absolutePath, viewHolder.image, i);
                                    }
                                });
                            }
                        }
                    });
                }
            }
            AlbumBitmapCacheHelper.getInstance().addPathToShowlist(str);
            viewHolder.image.setTag(str);
            PictureSelectorActivity.this.setImageViewBackground(str, viewHolder.image, i);
            if (itemAt.mediaType == 3) {
                viewHolder.videoContainer.setVisibility(0);
                long minutes = TimeUnit.MILLISECONDS.toMinutes(itemAt.duration);
                long seconds = TimeUnit.MILLISECONDS.toSeconds(itemAt.duration) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(itemAt.duration));
                viewHolder.videoDuration.setText(String.format(Locale.CHINA, seconds < 10 ? "%d:0%d" : "%d:%d", Long.valueOf(minutes), Long.valueOf(seconds)));
            } else {
                viewHolder.videoContainer.setVisibility(8);
            }
            viewHolder.checkBox.setChecked(itemAt.selected);
            viewHolder.checkBox.setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.plugin.image.PictureSelectorActivity.GridViewAdapter.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (itemAt.mediaType == 3) {
                        if (TextUtils.isEmpty(viewHolder.videoDuration.getText())) {
                            return;
                        }
                        int videoLimitTime = RongIMClient.getInstance().getVideoLimitTime();
                        if (videoLimitTime < 1) {
                            videoLimitTime = 300;
                        }
                        String[] strArrSplit = viewHolder.videoDuration.getText().toString().split(":");
                        if ((Integer.parseInt(strArrSplit[0]) * 60) + Integer.parseInt(strArrSplit[1]) > videoLimitTime) {
                            new AlertDialog.Builder(PictureSelectorActivity.this).setMessage(PictureSelectorActivity.this.getResources().getString(R.string.rc_picsel_selected_max_time_span_with_param, Integer.valueOf(videoLimitTime / 60))).setPositiveButton(R.string.rc_confirm, (DialogInterface.OnClickListener) null).setCancelable(false).create().show();
                            return;
                        }
                    }
                    if (itemAt.uri.endsWith(".gif")) {
                        int gIFLimitSize = RongIMClient.getInstance().getGIFLimitSize() * 1024;
                        File file = new File(itemAt.uri);
                        if (file.exists() && file.length() > gIFLimitSize) {
                            new AlertDialog.Builder(PictureSelectorActivity.this).setMessage(PictureSelectorActivity.this.getResources().getString(R.string.rc_picsel_selected_max_gif_size_span_with_param)).setPositiveButton(R.string.rc_confirm, (DialogInterface.OnClickListener) null).setCancelable(false).create().show();
                            return;
                        }
                    }
                    if (!viewHolder.checkBox.getChecked() && PictureSelectorActivity.this.getTotalSelectedNum() == 9) {
                        Toast.makeText(PictureSelectorActivity.this, R.string.rc_picsel_selected_max_pic_count, 0).show();
                        return;
                    }
                    viewHolder.checkBox.setChecked(!r8.getChecked());
                    itemAt.selected = viewHolder.checkBox.getChecked();
                    if (itemAt.selected) {
                        PictureSelectorActivity.this.mAllSelectedItemList.add(Uri.parse("file://" + itemAt.uri));
                        ArrayList<MediaItem> arrayList = PicItemHolder.itemAllSelectedMediaItemList;
                        if (arrayList != null) {
                            arrayList.add(itemAt);
                        }
                        viewHolder.mask.setBackgroundColor(PictureSelectorActivity.this.getResources().getColor(R.color.rc_picsel_grid_mask_pressed));
                    } else {
                        try {
                            PictureSelectorActivity.this.mAllSelectedItemList.remove(Uri.parse("file://" + itemAt.uri));
                        } catch (Exception e2) {
                            RLog.e(PictureSelectorActivity.TAG, "GridViewAdapter getView", e2);
                        }
                        ArrayList<MediaItem> arrayList2 = PicItemHolder.itemAllSelectedMediaItemList;
                        if (arrayList2 != null) {
                            arrayList2.remove(itemAt);
                        }
                        viewHolder.mask.setBackgroundDrawable(PictureSelectorActivity.this.getResources().getDrawable(R.drawable.rc_sp_grid_mask));
                    }
                    PictureSelectorActivity.this.updateToolbar();
                }
            });
            if (itemAt.selected) {
                viewHolder.mask.setBackgroundColor(PictureSelectorActivity.this.getResources().getColor(R.color.rc_picsel_grid_mask_pressed));
            } else {
                viewHolder.mask.setBackgroundDrawable(PictureSelectorActivity.this.getResources().getDrawable(R.drawable.rc_sp_grid_mask));
            }
            return view;
        }
    }

    interface IExecutedCallback {
        void executed();
    }

    public static class MediaItem implements Parcelable {
        public static final Parcelable.Creator<MediaItem> CREATOR = new Parcelable.Creator<MediaItem>() { // from class: io.rong.imkit.plugin.image.PictureSelectorActivity.MediaItem.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public MediaItem createFromParcel(Parcel parcel) {
                return new MediaItem(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public MediaItem[] newArray(int i) {
                return new MediaItem[i];
            }
        };
        int duration;
        int mediaType;
        String mimeType;
        String name;
        boolean selected;
        String uri;
        String uri_sdk29;

        public MediaItem() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.name);
            parcel.writeInt(this.mediaType);
            parcel.writeString(this.mimeType);
            parcel.writeString(this.uri);
            parcel.writeByte(this.selected ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.duration);
            parcel.writeString(this.uri_sdk29);
        }

        protected MediaItem(Parcel parcel) {
            this.name = parcel.readString();
            this.mediaType = parcel.readInt();
            this.mimeType = parcel.readString();
            this.uri = parcel.readString();
            this.selected = parcel.readByte() != 0;
            this.duration = parcel.readInt();
            this.uri_sdk29 = parcel.readString();
        }
    }

    static class PicItemHolder {
        static ArrayList<MediaItem> itemAllSelectedMediaItemList;
        static ArrayList<MediaItem> itemList;
        static ArrayList<MediaItem> itemSelectedList;

        PicItemHolder() {
        }
    }

    public static class PicTypeBtn extends LinearLayout {
        TextView mText;

        public PicTypeBtn(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public void init(Activity activity) {
            this.mText = (TextView) activity.findViewById(R.id.type_text);
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (isEnabled()) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.mText.setVisibility(4);
                } else if (action == 1) {
                    this.mText.setVisibility(0);
                }
            }
            return super.onTouchEvent(motionEvent);
        }

        public void setText(String str) {
            this.mText.setText(str);
        }

        public void setTextColor(int i) {
            this.mText.setTextColor(i);
        }
    }

    public static class PreviewBtn extends LinearLayout {
        private TextView mText;

        public PreviewBtn(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public void init(Activity activity) {
            this.mText = (TextView) activity.findViewById(R.id.preview_text);
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (isEnabled()) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.mText.setVisibility(4);
                } else if (action == 1) {
                    this.mText.setVisibility(0);
                }
            }
            return super.onTouchEvent(motionEvent);
        }

        @Override // android.view.View
        public void setEnabled(boolean z) {
            super.setEnabled(z);
            this.mText.setTextColor(getResources().getColor(z ? R.color.rc_picsel_toolbar_send_text_normal : R.color.rc_picsel_toolbar_send_text_disable));
        }

        public void setText(int i) {
            this.mText.setText(i);
        }

        public void setText(String str) {
            this.mText.setText(str);
        }
    }

    public static class SelectBox extends ImageView {
        private boolean mIsChecked;

        public SelectBox(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            setImageResource(R.drawable.rc_select_check_nor);
        }

        public boolean getChecked() {
            return this.mIsChecked;
        }

        public void setChecked(boolean z) {
            this.mIsChecked = z;
            setImageResource(this.mIsChecked ? R.drawable.rc_select_check_sel : R.drawable.rc_select_check_nor);
        }
    }

    private MediaItem findByUri(String str) {
        Iterator<String> it = this.mItemMap.keySet().iterator();
        while (it.hasNext()) {
            for (MediaItem mediaItem : this.mItemMap.get(it.next())) {
                if (mediaItem.uri.equals(str)) {
                    return mediaItem;
                }
            }
        }
        return null;
    }

    private String formatSize(long j) {
        if (j > 1048576) {
            return (Math.round((j / 1048576.0f) * 100.0f) / 100.0f) + "M";
        }
        if (j <= 1024) {
            return j + "B";
        }
        return (Math.round((j / 1024.0f) * 100.0f) / 100.0f) + "KB";
    }

    private MediaItem getItemAt(int i) {
        Iterator<String> it = this.mItemMap.keySet().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            for (MediaItem mediaItem : this.mItemMap.get(it.next())) {
                if (i2 == i) {
                    return mediaItem;
                }
                i2++;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getTotalSelectedNum() {
        Iterator<String> it = this.mItemMap.keySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            List<MediaItem> list = this.mItemMap.get(it.next());
            if (list != null) {
                Iterator it2 = new ArrayList(list).iterator();
                while (it2.hasNext()) {
                    if (((MediaItem) it2.next()).selected) {
                        i++;
                    }
                }
            }
        }
        return i;
    }

    private void initView() {
        updatePictureItems(new IExecutedCallback() { // from class: io.rong.imkit.plugin.image.PictureSelectorActivity.2
            @Override // io.rong.imkit.plugin.image.PictureSelectorActivity.IExecutedCallback
            public void executed() {
                if (PictureSelectorActivity.this.uiHandler != null) {
                    PictureSelectorActivity.this.uiHandler.post(new Runnable() { // from class: io.rong.imkit.plugin.image.PictureSelectorActivity.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PictureSelectorActivity.this.initWidget();
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initWidget() {
        this.mGridView.setAdapter((ListAdapter) new GridViewAdapter());
        this.mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: io.rong.imkit.plugin.image.PictureSelectorActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i == 0) {
                    return;
                }
                ArrayList<MediaItem> arrayList = new ArrayList<>();
                if (PictureSelectorActivity.this.mCurrentCatalog.isEmpty()) {
                    arrayList.addAll(PictureSelectorActivity.this.mAllItemList);
                    PicItemHolder.itemList = arrayList;
                    PicItemHolder.itemSelectedList = null;
                } else {
                    Map map = PictureSelectorActivity.this.mItemMap;
                    if (map == null) {
                        return;
                    }
                    List list = (List) map.get(PictureSelectorActivity.this.mCurrentCatalog);
                    if (list != null) {
                        arrayList.addAll(list);
                        PicItemHolder.itemList = arrayList;
                    }
                    ArrayList<MediaItem> arrayList2 = new ArrayList<>();
                    for (String str : map.keySet()) {
                        List<MediaItem> list2 = (List) map.get(str);
                        if (!str.equals(PictureSelectorActivity.this.mCurrentCatalog) && list2 != null) {
                            for (MediaItem mediaItem : list2) {
                                if (mediaItem.selected) {
                                    arrayList2.add(mediaItem);
                                }
                            }
                        }
                    }
                    PicItemHolder.itemSelectedList = arrayList2;
                }
                Intent intent = new Intent(PictureSelectorActivity.this, (Class<?>) PicturePreviewActivity.class);
                intent.putExtra(FirebaseAnalytics.Param.INDEX, i - 1);
                intent.putExtra("sendOrigin", PictureSelectorActivity.this.mSendOrigin);
                PictureSelectorActivity.this.startActivityForResult(intent, 0);
            }
        });
        this.mBtnSend.setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.plugin.image.PictureSelectorActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                Iterator it = PictureSelectorActivity.this.mItemMap.entrySet().iterator();
                while (it.hasNext()) {
                    for (MediaItem mediaItem : (List) ((Map.Entry) it.next()).getValue()) {
                        if (mediaItem.selected) {
                            if (KitStorageUtils.isBuildAndTargetForQ(PictureSelectorActivity.this)) {
                                String fileNameWithPath = FileUtils.getFileNameWithPath(mediaItem.uri);
                                int i = mediaItem.mediaType;
                                if (i == 1) {
                                    str = KitStorageUtils.getImageSavePath(PictureSelectorActivity.this) + File.separator + fileNameWithPath;
                                } else if (i == 3) {
                                    str = KitStorageUtils.getVideoSavePath(PictureSelectorActivity.this) + File.separator + fileNameWithPath;
                                } else {
                                    str = KitStorageUtils.getFileSavePath(PictureSelectorActivity.this) + File.separator + fileNameWithPath;
                                }
                                if (FileUtils.copyFile(PictureSelectorActivity.this.getApplicationContext(), Uri.parse(mediaItem.uri_sdk29), str)) {
                                    linkedHashMap.put("file://" + str, Integer.valueOf(mediaItem.mediaType));
                                }
                            } else {
                                linkedHashMap.put("file://" + mediaItem.uri, Integer.valueOf(mediaItem.mediaType));
                            }
                        }
                    }
                }
                String strA = new j().a(linkedHashMap);
                Intent intent = new Intent();
                intent.putExtra("sendOrigin", PictureSelectorActivity.this.mSendOrigin);
                intent.putExtra("android.intent.extra.RETURN_RESULT", strA);
                PictureSelectorActivity.this.setResult(-1, intent);
                PictureSelectorActivity.this.finish();
            }
        });
        this.mPicType.setEnabled(true);
        this.mPicType.setTextColor(getResources().getColor(R.color.rc_picsel_toolbar_send_text_normal));
        this.mPicType.setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.plugin.image.PictureSelectorActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PictureSelectorActivity.this.mCatalogView.setVisibility(0);
            }
        });
        this.mPreviewBtn.setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.plugin.image.PictureSelectorActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PicItemHolder.itemList = new ArrayList<>();
                Iterator it = PictureSelectorActivity.this.mItemMap.keySet().iterator();
                while (it.hasNext()) {
                    for (MediaItem mediaItem : (List) PictureSelectorActivity.this.mItemMap.get((String) it.next())) {
                        if (mediaItem.selected) {
                            PicItemHolder.itemList.add(mediaItem);
                        }
                    }
                }
                if (PictureSelectorActivity.this.mAllSelectedItemList != null && PicItemHolder.itemList != null) {
                    int i = 0;
                    while (i < PictureSelectorActivity.this.mAllSelectedItemList.size()) {
                        Uri uri = (Uri) PictureSelectorActivity.this.mAllSelectedItemList.get(i);
                        int i2 = i + 1;
                        for (int i3 = i2; i3 < PicItemHolder.itemList.size(); i3++) {
                            MediaItem mediaItem2 = PicItemHolder.itemList.get(i3);
                            if (mediaItem2 != null && uri.toString().contains(mediaItem2.uri)) {
                                PicItemHolder.itemList.remove(i3);
                                PicItemHolder.itemList.add(i, mediaItem2);
                            }
                        }
                        i = i2;
                    }
                }
                PicItemHolder.itemSelectedList = null;
                Intent intent = new Intent(PictureSelectorActivity.this, (Class<?>) PicturePreviewActivity.class);
                intent.putExtra("sendOrigin", PictureSelectorActivity.this.mSendOrigin);
                PictureSelectorActivity.this.startActivityForResult(intent, 0);
            }
        });
        this.mCatalogView.setOnTouchListener(new View.OnTouchListener() { // from class: io.rong.imkit.plugin.image.PictureSelectorActivity.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1 && PictureSelectorActivity.this.mCatalogView.getVisibility() == 0) {
                    PictureSelectorActivity.this.mCatalogView.setVisibility(8);
                }
                return true;
            }
        });
        this.mCatalogListView.setAdapter((ListAdapter) new CatalogAdapter());
        this.mCatalogListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: io.rong.imkit.plugin.image.PictureSelectorActivity.8
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                String str = i == 0 ? "" : (String) PictureSelectorActivity.this.mCatalogList.get(i - 1);
                if (str.equals(PictureSelectorActivity.this.mCurrentCatalog)) {
                    PictureSelectorActivity.this.mCatalogView.setVisibility(8);
                    return;
                }
                PictureSelectorActivity.this.mCurrentCatalog = str;
                PictureSelectorActivity.this.mPicType.setText(((TextView) view.findViewById(R.id.name)).getText().toString());
                PictureSelectorActivity.this.mCatalogView.setVisibility(8);
                ((CatalogAdapter) PictureSelectorActivity.this.mCatalogListView.getAdapter()).notifyDataSetChanged();
                ((GridViewAdapter) PictureSelectorActivity.this.mGridView.getAdapter()).notifyDataSetChanged();
            }
        });
        this.perWidth = ((WindowManager) getSystemService("window")).getDefaultDisplay().getWidth() / 3;
        this.perHeight = ((WindowManager) getSystemService("window")).getDefaultDisplay().getHeight() / 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImageViewBackground(String str, ImageView imageView, int i) {
        Bitmap bitmap = AlbumBitmapCacheHelper.getInstance().getBitmap(str, this.perWidth, this.perHeight, new AlbumBitmapCacheHelper.ILoadImageCallback() { // from class: io.rong.imkit.plugin.image.PictureSelectorActivity.11
            @Override // io.rong.imkit.plugin.image.AlbumBitmapCacheHelper.ILoadImageCallback
            public void onLoadImageCallBack(Bitmap bitmap2, String str2, Object... objArr) {
                if (bitmap2 == null) {
                    return;
                }
                BitmapDrawable bitmapDrawable = new BitmapDrawable(PictureSelectorActivity.this.getResources(), bitmap2);
                View viewFindViewWithTag = PictureSelectorActivity.this.mGridView.findViewWithTag(str2);
                if (viewFindViewWithTag != null) {
                    viewFindViewWithTag.setBackgroundDrawable(bitmapDrawable);
                }
            }
        }, Integer.valueOf(i));
        if (bitmap != null) {
            imageView.setBackgroundDrawable(new BitmapDrawable(getResources(), bitmap));
        } else {
            imageView.setBackgroundResource(R.drawable.rc_grid_image_default);
        }
    }

    private void shutdownAndAwaitTermination(ExecutorService executorService) {
        executorService.shutdown();
        try {
            if (executorService.awaitTermination(60L, TimeUnit.SECONDS)) {
                return;
            }
            executorService.shutdownNow();
            if (executorService.awaitTermination(60L, TimeUnit.SECONDS)) {
                return;
            }
            System.err.println("Pool did not terminate");
        } catch (InterruptedException unused) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePictureItems(final IExecutedCallback iExecutedCallback) {
        this.bgHandler.post(new Runnable() { // from class: io.rong.imkit.plugin.image.PictureSelectorActivity.10
            @Override // java.lang.Runnable
            public void run() {
                Class<?> cls;
                String[] strArr = {ay.f20688d, "_data", "date_added", MessengerShareContentUtility.MEDIA_TYPE, "mime_type", "title", "duration"};
                try {
                    cls = Class.forName("io.rong.sight.SightExtensionModule");
                } catch (ClassNotFoundException e2) {
                    RLog.e(PictureSelectorActivity.TAG, "updatePictureItems", e2);
                    cls = null;
                }
                String str = (cls != null && PictureSelectorActivity.this.getResources().getBoolean(R.bool.rc_media_selector_contain_video)) ? "media_type=1 OR media_type=3" : "media_type=1";
                Uri contentUri = MediaStore.Files.getContentUri(WXBaseHybridActivity.EXTERNAL);
                Cursor cursorLoadInBackground = new CursorLoader(PictureSelectorActivity.this, contentUri, strArr, str, null, "date_added DESC").loadInBackground();
                PictureSelectorActivity.this.mItemMap.clear();
                PictureSelectorActivity.this.mAllItemList.clear();
                PictureSelectorActivity.this.mCatalogList.clear();
                PictureSelectorActivity.this.mAllSelectedItemList.clear();
                PicItemHolder.itemAllSelectedMediaItemList = new ArrayList<>();
                if (cursorLoadInBackground != null) {
                    if (cursorLoadInBackground.moveToFirst()) {
                        do {
                            MediaItem mediaItem = new MediaItem();
                            mediaItem.name = cursorLoadInBackground.getString(5);
                            mediaItem.mediaType = cursorLoadInBackground.getInt(3);
                            mediaItem.mimeType = cursorLoadInBackground.getString(4);
                            mediaItem.uri = cursorLoadInBackground.getString(1);
                            mediaItem.duration = cursorLoadInBackground.getInt(6);
                            mediaItem.uri_sdk29 = ContentUris.withAppendedId(contentUri, cursorLoadInBackground.getLong(0)).toString();
                            if (mediaItem.uri != null && ((mediaItem.mediaType != 3 || mediaItem.duration != 0) && (mediaItem.mediaType != 3 || "video/mp4".equals(mediaItem.mimeType)))) {
                                File file = new File(mediaItem.uri);
                                if (file.exists() && file.length() != 0) {
                                    PictureSelectorActivity.this.mAllItemList.add(mediaItem);
                                    int iLastIndexOf = mediaItem.uri.lastIndexOf("/");
                                    if (iLastIndexOf != -1) {
                                        String strSubstring = iLastIndexOf != 0 ? mediaItem.uri.substring(mediaItem.uri.lastIndexOf("/", iLastIndexOf - 1) + 1, iLastIndexOf) : "/";
                                        if (PictureSelectorActivity.this.mItemMap.containsKey(strSubstring)) {
                                            ((List) PictureSelectorActivity.this.mItemMap.get(strSubstring)).add(mediaItem);
                                        } else {
                                            ArrayList arrayList = new ArrayList();
                                            arrayList.add(mediaItem);
                                            PictureSelectorActivity.this.mItemMap.put(strSubstring, arrayList);
                                            PictureSelectorActivity.this.mCatalogList.add(strSubstring);
                                        }
                                    }
                                }
                            }
                        } while (cursorLoadInBackground.moveToNext());
                    }
                    cursorLoadInBackground.close();
                    IExecutedCallback iExecutedCallback2 = iExecutedCallback;
                    if (iExecutedCallback2 != null) {
                        iExecutedCallback2.executed();
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateToolbar() {
        int totalSelectedNum = getTotalSelectedNum();
        if (totalSelectedNum == 0) {
            this.mBtnSend.setEnabled(false);
            this.mBtnSend.setTextColor(getResources().getColor(R.color.rc_picsel_toolbar_send_text_disable));
            this.mBtnSend.setText(R.string.rc_picsel_toolbar_send);
            this.mPreviewBtn.setEnabled(false);
            this.mPreviewBtn.setText(R.string.rc_picsel_toolbar_preview);
            return;
        }
        if (totalSelectedNum <= 9) {
            this.mBtnSend.setEnabled(true);
            this.mBtnSend.setTextColor(getResources().getColor(R.color.rc_picsel_toolbar_send_text_normal));
            this.mBtnSend.setText(String.format(getResources().getString(R.string.rc_picsel_toolbar_send_num), Integer.valueOf(totalSelectedNum)));
            this.mPreviewBtn.setEnabled(true);
            this.mPreviewBtn.setText(String.format(getResources().getString(R.string.rc_picsel_toolbar_preview_num), Integer.valueOf(totalSelectedNum)));
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    @TargetApi(23)
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100) {
            if (Build.VERSION.SDK_INT < 23 || checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) {
                Toast.makeText(getApplicationContext(), getString(R.string.rc_permission_grant_needed), 0).show();
                finish();
            } else {
                initView();
            }
        }
        if (i2 == 0) {
            return;
        }
        if (i2 == 1) {
            setResult(-1, intent);
            finish();
            return;
        }
        if (i == 0) {
            this.mSendOrigin = intent.getBooleanExtra("sendOrigin", false);
            GridViewAdapter gridViewAdapter = (GridViewAdapter) this.mGridView.getAdapter();
            if (gridViewAdapter != null) {
                gridViewAdapter.notifyDataSetChanged();
            }
            CatalogAdapter catalogAdapter = (CatalogAdapter) this.mCatalogListView.getAdapter();
            if (catalogAdapter != null) {
                catalogAdapter.notifyDataSetChanged();
            }
            updateToolbar();
            return;
        }
        if (i == 1 && this.mTakePictureUri != null) {
            PicItemHolder.itemList = new ArrayList<>();
            MediaItem mediaItem = new MediaItem();
            mediaItem.uri = this.mTakePictureUri.getPath();
            mediaItem.mediaType = 1;
            PicItemHolder.itemList.add(mediaItem);
            PicItemHolder.itemSelectedList = null;
            mediaItem.uri_sdk29 = this.mTakePictureUri.toString();
            startActivityForResult(new Intent(this, (Class<?>) PicturePreviewActivity.class), 0);
            MediaScannerConnection.scanFile(getApplicationContext(), new String[]{this.mTakePictureUri.getPath()}, null, new MediaScannerConnection.OnScanCompletedListener() { // from class: io.rong.imkit.plugin.image.PictureSelectorActivity.9
                @Override // android.media.MediaScannerConnection.OnScanCompletedListener
                public void onScanCompleted(String str, Uri uri) {
                    PictureSelectorActivity.this.updatePictureItems(null);
                }
            });
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @TargetApi(23)
    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        setContentView(R.layout.rc_picsel_activity);
        this.thread = new HandlerThread(TAG);
        this.thread.start();
        this.bgHandler = new Handler(this.thread.getLooper());
        this.uiHandler = new Handler(getMainLooper());
        this.mGridView = (GridView) findViewById(R.id.gridlist);
        this.mBtnBack = (ImageButton) findViewById(R.id.back);
        this.mBtnBack.setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.plugin.image.PictureSelectorActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PictureSelectorActivity.this.finish();
            }
        });
        this.mBtnSend = (Button) findViewById(R.id.send);
        this.mPicType = (PicTypeBtn) findViewById(R.id.pic_type);
        this.mPicType.init(this);
        this.mPicType.setEnabled(false);
        this.mPreviewBtn = (PreviewBtn) findViewById(R.id.preview);
        this.mPreviewBtn.init(this);
        this.mPreviewBtn.setEnabled(false);
        this.mCatalogView = findViewById(R.id.catalog_window);
        this.mCatalogListView = (ListView) findViewById(R.id.catalog_listview);
        String[] strArr = {"android.permission.READ_EXTERNAL_STORAGE"};
        if (!PermissionCheckUtil.checkPermissions(this, strArr)) {
            PermissionCheckUtil.requestPermissions(this, strArr, 100);
        } else {
            this.pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
            initView();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        PicItemHolder.itemList = null;
        PicItemHolder.itemSelectedList = null;
        PicItemHolder.itemAllSelectedMediaItemList = null;
        this.thread.quit();
        this.bgHandler.removeCallbacks(this.thread);
        this.bgHandler = null;
        this.uiHandler = null;
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        View view;
        if (i != 4 || (view = this.mCatalogView) == null || view.getVisibility() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        this.mCatalogView.setVisibility(8);
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i != 100) {
            super.onRequestPermissionsResult(i, strArr, iArr);
            return;
        }
        if (iArr[0] != 0) {
            if (strArr[0].equals("android.permission.CAMERA")) {
                Toast.makeText(getApplicationContext(), getString(R.string.rc_permission_grant_needed), 0).show();
                return;
            } else {
                Toast.makeText(getApplicationContext(), getString(R.string.rc_permission_grant_needed), 0).show();
                finish();
                return;
            }
        }
        if (strArr[0].equals("android.permission.READ_EXTERNAL_STORAGE")) {
            initView();
        } else if (strArr[0].equals("android.permission.CAMERA")) {
            requestCamera();
        }
    }

    protected void requestCamera() {
        if (IMLibExtensionModuleManager.getInstance().onRequestHardwareResource(HardwareResource.ResourceType.VIDEO)) {
            Toast.makeText(this, getString(R.string.rc_voip_call_video_start_fail), 1).show();
            return;
        }
        if (IMLibExtensionModuleManager.getInstance().onRequestHardwareResource(HardwareResource.ResourceType.AUDIO)) {
            Toast.makeText(this, getString(R.string.rc_voip_call_audio_start_fail), 1).show();
            return;
        }
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        List<ResolveInfo> listQueryIntentActivities = getPackageManager().queryIntentActivities(intent, 65536);
        if (listQueryIntentActivities.size() <= 0) {
            Toast.makeText(this, getResources().getString(R.string.rc_voip_cpu_error), 0).show();
            return;
        }
        if (KitStorageUtils.isBuildAndTargetForQ(this)) {
            String strValueOf = String.valueOf(System.currentTimeMillis());
            ContentValues contentValues = new ContentValues();
            contentValues.put("description", "This is an image");
            contentValues.put("_display_name", strValueOf);
            contentValues.put("mime_type", "image/jpeg");
            contentValues.put("title", strValueOf);
            contentValues.put("relative_path", "Pictures");
            Uri uriInsert = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
            this.mTakePictureUri = uriInsert;
            intent.putExtra("output", uriInsert);
        } else {
            String str = System.currentTimeMillis() + ".jpg";
            File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            if (!externalStoragePublicDirectory.exists()) {
                externalStoragePublicDirectory.mkdirs();
            }
            File file = new File(externalStoragePublicDirectory, str);
            this.mTakePictureUri = Uri.fromFile(file);
            try {
                Uri uriForFile = FileProvider.getUriForFile(this, getPackageName() + getString(R.string.rc_authorities_fileprovider), file);
                Iterator<ResolveInfo> it = listQueryIntentActivities.iterator();
                while (it.hasNext()) {
                    String str2 = it.next().activityInfo.packageName;
                    grantUriPermission(str2, uriForFile, 2);
                    grantUriPermission(str2, uriForFile, 1);
                }
                intent.putExtra("output", uriForFile);
            } catch (Exception e2) {
                RLog.e(TAG, "requestCamera", e2);
                throw new RuntimeException("Please check IMKit Manifest FileProvider config. Please refer to http://support.rongcloud.cn/kb/NzA1");
            }
        }
        startActivityForResult(intent, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaItem getItemAt(String str, int i) {
        if (!this.mItemMap.containsKey(str)) {
            return null;
        }
        int i2 = 0;
        for (MediaItem mediaItem : this.mItemMap.get(str)) {
            if (i2 == i) {
                return mediaItem;
            }
            i2++;
        }
        return null;
    }
}
