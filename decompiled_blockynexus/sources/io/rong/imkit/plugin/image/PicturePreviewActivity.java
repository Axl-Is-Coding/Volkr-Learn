package io.rong.imkit.plugin.image;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.a;
import cn.qqtheme.framework.widget.WheelView;
import com.bumptech.glide.c;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.j;
import io.rong.common.FileInfo;
import io.rong.common.FileUtils;
import io.rong.common.RLog;
import io.rong.imkit.R;
import io.rong.imkit.RongBaseNoActionbarActivity;
import io.rong.imkit.plugin.image.PictureSelectorActivity;
import io.rong.imkit.utilities.KitStorageUtils;
import io.rong.imlib.RongIMClient;
import io.rong.subscaleview.ImageSource;
import io.rong.subscaleview.SubsamplingScaleImageView;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public class PicturePreviewActivity extends RongBaseNoActionbarActivity {
    public static final int RESULT_SEND = 1;
    private static final String TAG = "PicturePreviewActivity";
    private ImageButton mBtnBack;
    private Button mBtnSend;
    private int mCurrentIndex;
    private TextView mIndexTotal;
    private ArrayList<PictureSelectorActivity.MediaItem> mItemAllSelectedList;
    private ArrayList<PictureSelectorActivity.MediaItem> mItemList;
    private ArrayList<PictureSelectorActivity.MediaItem> mItemSelectedList;
    private CheckButton mSelectBox;
    private View mToolbarBottom;
    private View mToolbarTop;
    private CheckButton mUseOrigin;
    private HackyViewPager mViewPager;
    private View mWholeView;

    private static class CheckButton {
        private boolean checked = false;
        private ImageView image;
        private int nor_resId;
        private View rootView;
        private int sel_resId;
        private TextView text;

        public CheckButton(View view, int i, int i2) {
            this.rootView = view;
            this.image = (ImageView) view.findViewById(R.id.image);
            this.text = (TextView) view.findViewById(R.id.text);
            this.nor_resId = i;
            this.sel_resId = i2;
            this.image.setImageResource(this.nor_resId);
        }

        public boolean getChecked() {
            return this.checked;
        }

        public void setChecked(boolean z) {
            this.checked = z;
            this.image.setImageResource(this.checked ? this.sel_resId : this.nor_resId);
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            this.rootView.setOnClickListener(onClickListener);
        }

        public void setSelectButtonVisibility(int i) {
            this.image.setVisibility(i);
        }

        public void setText(int i) {
            this.text.setText(i);
        }

        public void setText(CharSequence charSequence) {
            this.text.setText(charSequence);
        }
    }

    private class PreviewAdapter extends a {
        private PreviewAdapter() {
        }

        @Override // androidx.viewpager.widget.a
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.a
        public int getCount() {
            return PicturePreviewActivity.this.mItemList.size();
        }

        @Override // androidx.viewpager.widget.a
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            String string;
            final PictureSelectorActivity.MediaItem mediaItem = (PictureSelectorActivity.MediaItem) PicturePreviewActivity.this.mItemList.get(i);
            View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rc_picsel_preview, viewGroup, false);
            SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) viewInflate.findViewById(R.id.rc_photoView);
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.rc_gifview);
            ImageButton imageButton = (ImageButton) viewInflate.findViewById(R.id.rc_play_video);
            viewGroup.addView(viewInflate, -1, -1);
            if (mediaItem.mediaType == 3) {
                string = KitStorageUtils.getImageSavePath(PicturePreviewActivity.this) + File.separator + mediaItem.name;
                if (!new File(string).exists()) {
                    Bitmap frameAtIndex = null;
                    if (KitStorageUtils.isBuildAndTargetForQ(PicturePreviewActivity.this.getApplicationContext())) {
                        try {
                            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = PicturePreviewActivity.this.getApplicationContext().getContentResolver().openFileDescriptor(Uri.parse(mediaItem.uri_sdk29), "r");
                            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                            mediaMetadataRetriever.setDataSource(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
                            frameAtIndex = mediaMetadataRetriever.getFrameAtIndex(0);
                        } catch (IOException unused) {
                            RLog.e(PicturePreviewActivity.TAG, "instantiateItem Q is error");
                        }
                    } else {
                        frameAtIndex = ThumbnailUtils.createVideoThumbnail(mediaItem.uri, 1);
                    }
                    string = frameAtIndex != null ? FileUtils.convertBitmap2File(frameAtIndex, KitStorageUtils.getImageSavePath(PicturePreviewActivity.this), mediaItem.name).toString() : "";
                }
                imageButton.setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.plugin.image.PicturePreviewActivity.PreviewAdapter.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Intent intent = new Intent("android.intent.action.VIEW");
                        if (Build.VERSION.SDK_INT >= 24) {
                            intent.setFlags(335544320);
                            Uri uriForFile = FileProvider.getUriForFile(view.getContext(), view.getContext().getPackageName() + view.getContext().getResources().getString(R.string.rc_authorities_fileprovider), new File(mediaItem.uri));
                            if (KitStorageUtils.isBuildAndTargetForQ(PicturePreviewActivity.this.getApplicationContext())) {
                                intent.setDataAndType(Uri.parse(mediaItem.uri_sdk29), mediaItem.mimeType);
                            } else {
                                intent.setDataAndType(uriForFile, mediaItem.mimeType);
                            }
                            intent.addFlags(1);
                        } else {
                            intent.setDataAndType(Uri.parse("file://" + mediaItem.uri), mediaItem.mimeType);
                        }
                        PicturePreviewActivity.this.startActivity(intent);
                    }
                });
                imageButton.setVisibility(0);
                subsamplingScaleImageView.setImage(ImageSource.uri(string));
                imageView.setVisibility(8);
                subsamplingScaleImageView.setOrientation(PicturePreviewActivity.this.readPictureDegree(string, viewGroup.getContext()));
            } else {
                imageButton.setVisibility(8);
                String str = KitStorageUtils.isBuildAndTargetForQ(PicturePreviewActivity.this.getApplicationContext()) ? ((PictureSelectorActivity.MediaItem) PicturePreviewActivity.this.mItemList.get(i)).uri_sdk29 : ((PictureSelectorActivity.MediaItem) PicturePreviewActivity.this.mItemList.get(i)).uri;
                if (((PictureSelectorActivity.MediaItem) PicturePreviewActivity.this.mItemList.get(i)).uri.endsWith(".gif")) {
                    imageView.setVisibility(0);
                    c.a((FragmentActivity) PicturePreviewActivity.this).asGif().mo46load(str).into(imageView);
                } else {
                    imageView.setVisibility(8);
                    subsamplingScaleImageView.setImage(ImageSource.uri(str));
                    subsamplingScaleImageView.setOrientation(PicturePreviewActivity.this.readPictureDegree(str, viewGroup.getContext()));
                }
                string = str;
            }
            AlbumBitmapCacheHelper.getInstance().removePathFromShowlist(string);
            AlbumBitmapCacheHelper.getInstance().addPathToShowlist(string);
            return viewInflate;
        }

        @Override // androidx.viewpager.widget.a
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
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

    private String getSelectedSize(int i) {
        float f2;
        ArrayList<PictureSelectorActivity.MediaItem> arrayList = this.mItemList;
        if (arrayList == null || arrayList.size() <= 0) {
            f2 = WheelView.DividerConfig.FILL;
        } else {
            long length = 0;
            if (KitStorageUtils.isBuildAndTargetForQ(this)) {
                FileInfo fileInfoByUri = FileUtils.getFileInfoByUri(this, Uri.parse(this.mItemList.get(i).uri_sdk29));
                if (fileInfoByUri != null) {
                    length = fileInfoByUri.getSize();
                }
            } else {
                length = new File(this.mItemList.get(i).uri).length();
            }
            f2 = length / 1024.0f;
        }
        return f2 < 1024.0f ? String.format("%.0fK", Float.valueOf(f2)) : String.format("%.1fM", Float.valueOf(f2 / 1024.0f));
    }

    @TargetApi(11)
    public static int getSmartBarHeight(Context context) {
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            return context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("mz_action_button_min_height").get(cls.newInstance()).toString()));
        } catch (Exception e2) {
            RLog.e(TAG, "getSmartBarHeight", e2);
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getTotalSelectedNum() {
        int i = 0;
        for (int i2 = 0; i2 < this.mItemList.size(); i2++) {
            if (this.mItemList.get(i2).selected) {
                i++;
            }
        }
        ArrayList<PictureSelectorActivity.MediaItem> arrayList = this.mItemSelectedList;
        return arrayList != null ? i + arrayList.size() : i;
    }

    private String getTotalSelectedSize() {
        float length = WheelView.DividerConfig.FILL;
        for (int i = 0; i < this.mItemList.size(); i++) {
            if (this.mItemList.get(i).selected) {
                length += new File(this.mItemList.get(i).uri).length() / 1024.0f;
            }
        }
        if (this.mItemSelectedList != null) {
            for (int i2 = 0; i2 < this.mItemSelectedList.size(); i2++) {
                if (this.mItemSelectedList.get(i2).selected) {
                    length += new File(this.mItemSelectedList.get(i2).uri).length() / 1024.0f;
                }
            }
        }
        return length < 1024.0f ? String.format("%.0fK", Float.valueOf(length)) : String.format("%.1fM", Float.valueOf(length / 1024.0f));
    }

    private void initView() {
        this.mToolbarTop = findViewById(R.id.toolbar_top);
        this.mIndexTotal = (TextView) findViewById(R.id.index_total);
        this.mBtnBack = (ImageButton) findViewById(R.id.back);
        this.mBtnSend = (Button) findViewById(R.id.send);
        this.mWholeView = findViewById(R.id.whole_layout);
        this.mViewPager = (HackyViewPager) findViewById(R.id.viewpager);
        this.mToolbarBottom = findViewById(R.id.toolbar_bottom);
        this.mUseOrigin = new CheckButton(findViewById(R.id.origin_check), R.drawable.rc_origin_check_nor, R.drawable.rc_origin_check_sel);
        this.mSelectBox = new CheckButton(findViewById(R.id.select_check), R.drawable.rc_select_check_nor, R.drawable.rc_select_check_sel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateToolbar() {
        int totalSelectedNum = getTotalSelectedNum();
        if (this.mItemList.size() == 1 && totalSelectedNum == 0) {
            this.mBtnSend.setText(R.string.rc_picsel_toolbar_send);
            this.mUseOrigin.setText(R.string.rc_picprev_origin);
            this.mBtnSend.setEnabled(false);
            this.mBtnSend.setTextColor(getResources().getColor(R.color.rc_picsel_toolbar_send_text_disable));
            return;
        }
        if (totalSelectedNum == 0) {
            this.mBtnSend.setText(R.string.rc_picsel_toolbar_send);
            this.mUseOrigin.setText(R.string.rc_picprev_origin);
            this.mUseOrigin.setChecked(false);
            this.mBtnSend.setEnabled(false);
            this.mBtnSend.setTextColor(getResources().getColor(R.color.rc_picsel_toolbar_send_text_disable));
        } else if (totalSelectedNum <= 9) {
            this.mBtnSend.setEnabled(true);
            this.mBtnSend.setTextColor(getResources().getColor(R.color.rc_picsel_toolbar_send_text_normal));
            this.mBtnSend.setText(String.format(getResources().getString(R.string.rc_picsel_toolbar_send_num), Integer.valueOf(totalSelectedNum)));
        }
        this.mUseOrigin.setText(String.format(getResources().getString(R.string.rc_picprev_origin_size), getSelectedSize(this.mCurrentIndex)));
        if (this.mItemList.get(this.mCurrentIndex).mediaType == 3) {
            this.mUseOrigin.rootView.setVisibility(8);
        } else {
            this.mUseOrigin.rootView.setVisibility(0);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.rc_picprev_activity);
        initView();
        this.mUseOrigin.setChecked(getIntent().getBooleanExtra("sendOrigin", false));
        this.mCurrentIndex = getIntent().getIntExtra(FirebaseAnalytics.Param.INDEX, 0);
        if (this.mItemList == null) {
            this.mItemList = PictureSelectorActivity.PicItemHolder.itemList;
            this.mItemSelectedList = PictureSelectorActivity.PicItemHolder.itemSelectedList;
            this.mItemAllSelectedList = PictureSelectorActivity.PicItemHolder.itemAllSelectedMediaItemList;
        }
        if (this.mItemList == null) {
            RLog.e(TAG, "Itemlist is null");
            return;
        }
        this.mIndexTotal.setText(String.format("%d/%d", Integer.valueOf(this.mCurrentIndex + 1), Integer.valueOf(this.mItemList.size())));
        if (Build.VERSION.SDK_INT >= 11) {
            this.mWholeView.setSystemUiVisibility(1024);
            int smartBarHeight = getSmartBarHeight(this);
            if (smartBarHeight > 0) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mToolbarBottom.getLayoutParams();
                layoutParams.setMargins(0, 0, 0, smartBarHeight);
                this.mToolbarBottom.setLayoutParams(layoutParams);
            }
        }
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        int dimensionPixelSize = identifier > 0 ? getResources().getDimensionPixelSize(identifier) : 0;
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.mToolbarTop.getLayoutParams());
        layoutParams2.setMargins(0, dimensionPixelSize, 0, 0);
        this.mToolbarTop.setLayoutParams(layoutParams2);
        this.mBtnBack.setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.plugin.image.PicturePreviewActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("sendOrigin", PicturePreviewActivity.this.mUseOrigin.getChecked());
                PicturePreviewActivity.this.setResult(-1, intent);
                PicturePreviewActivity.this.finish();
            }
        });
        this.mBtnSend.setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.plugin.image.PicturePreviewActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                String str2;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                if (PicturePreviewActivity.this.mItemSelectedList != null) {
                    for (PictureSelectorActivity.MediaItem mediaItem : PicturePreviewActivity.this.mItemSelectedList) {
                        if (mediaItem.selected) {
                            if (KitStorageUtils.isBuildAndTargetForQ(PicturePreviewActivity.this.getApplicationContext())) {
                                String fileNameWithPath = FileUtils.getFileNameWithPath(mediaItem.uri);
                                int i = mediaItem.mediaType;
                                if (i == 1) {
                                    str2 = KitStorageUtils.getImageSavePath(PicturePreviewActivity.this.getApplicationContext()) + File.separator + fileNameWithPath;
                                } else if (i == 3) {
                                    str2 = KitStorageUtils.getVideoSavePath(PicturePreviewActivity.this.getApplicationContext()) + File.separator + fileNameWithPath;
                                } else {
                                    str2 = KitStorageUtils.getFileSavePath(PicturePreviewActivity.this.getApplicationContext()) + File.separator + fileNameWithPath;
                                }
                                if (FileUtils.copyFile(view.getContext(), Uri.parse(mediaItem.uri_sdk29), str2)) {
                                    linkedHashMap.put("file://" + str2, Integer.valueOf(mediaItem.mediaType));
                                }
                            } else {
                                linkedHashMap.put("file://" + mediaItem.uri, Integer.valueOf(mediaItem.mediaType));
                            }
                        }
                    }
                }
                for (PictureSelectorActivity.MediaItem mediaItem2 : PicturePreviewActivity.this.mItemList) {
                    if (mediaItem2.selected) {
                        if (KitStorageUtils.isBuildAndTargetForQ(PicturePreviewActivity.this.getApplicationContext())) {
                            String fileNameWithPath2 = FileUtils.getFileNameWithPath(mediaItem2.uri);
                            int i2 = mediaItem2.mediaType;
                            if (i2 == 1) {
                                str = KitStorageUtils.getImageSavePath(PicturePreviewActivity.this.getApplicationContext()) + File.separator + fileNameWithPath2;
                            } else if (i2 == 3) {
                                str = KitStorageUtils.getVideoSavePath(PicturePreviewActivity.this.getApplicationContext()) + File.separator + fileNameWithPath2;
                            } else {
                                str = KitStorageUtils.getFileSavePath(PicturePreviewActivity.this.getApplicationContext()) + File.separator + fileNameWithPath2;
                            }
                            if (FileUtils.copyFile(PicturePreviewActivity.this.getApplicationContext(), Uri.parse(mediaItem2.uri_sdk29), str)) {
                                linkedHashMap.put("file://" + str, Integer.valueOf(mediaItem2.mediaType));
                            }
                        } else {
                            linkedHashMap.put("file://" + mediaItem2.uri, Integer.valueOf(mediaItem2.mediaType));
                        }
                    }
                }
                String strA = new j().a(linkedHashMap);
                Intent intent = new Intent();
                intent.putExtra("sendOrigin", PicturePreviewActivity.this.mUseOrigin.getChecked());
                intent.putExtra("android.intent.extra.RETURN_RESULT", strA);
                PicturePreviewActivity.this.setResult(1, intent);
                PicturePreviewActivity.this.finish();
            }
        });
        this.mUseOrigin.setText(R.string.rc_picprev_origin);
        this.mUseOrigin.setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.plugin.image.PicturePreviewActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PictureSelectorActivity.MediaItem mediaItem = (PictureSelectorActivity.MediaItem) PicturePreviewActivity.this.mItemList.get(PicturePreviewActivity.this.mCurrentIndex);
                if (mediaItem.uri.endsWith(".gif")) {
                    int gIFLimitSize = RongIMClient.getInstance().getGIFLimitSize() * 1024;
                    File file = new File(mediaItem.uri);
                    if (file.exists() && file.length() > gIFLimitSize) {
                        new AlertDialog.Builder(PicturePreviewActivity.this).setMessage(PicturePreviewActivity.this.getResources().getString(R.string.rc_picsel_selected_max_gif_size_span_with_param)).setPositiveButton(R.string.rc_confirm, (DialogInterface.OnClickListener) null).setCancelable(false).create().show();
                        return;
                    }
                }
                PicturePreviewActivity.this.mUseOrigin.setChecked(!PicturePreviewActivity.this.mUseOrigin.getChecked());
                if (PicturePreviewActivity.this.mUseOrigin.getChecked() && PicturePreviewActivity.this.getTotalSelectedNum() == 0) {
                    PicturePreviewActivity.this.mSelectBox.setChecked(!PicturePreviewActivity.this.mSelectBox.getChecked());
                    ((PictureSelectorActivity.MediaItem) PicturePreviewActivity.this.mItemList.get(PicturePreviewActivity.this.mCurrentIndex)).selected = PicturePreviewActivity.this.mSelectBox.getChecked();
                    PicturePreviewActivity.this.updateToolbar();
                }
            }
        });
        this.mSelectBox.setText(R.string.rc_picprev_select);
        this.mSelectBox.setChecked(this.mItemList.get(this.mCurrentIndex).selected);
        this.mSelectBox.setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.plugin.image.PicturePreviewActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PictureSelectorActivity.MediaItem mediaItem = (PictureSelectorActivity.MediaItem) PicturePreviewActivity.this.mItemList.get(PicturePreviewActivity.this.mCurrentIndex);
                if (mediaItem.mediaType == 3) {
                    int videoLimitTime = RongIMClient.getInstance().getVideoLimitTime();
                    if (videoLimitTime < 1) {
                        videoLimitTime = 300;
                    }
                    if (TimeUnit.MILLISECONDS.toSeconds(mediaItem.duration) > videoLimitTime) {
                        new AlertDialog.Builder(PicturePreviewActivity.this).setMessage(PicturePreviewActivity.this.getResources().getString(R.string.rc_picsel_selected_max_time_span_with_param, Integer.valueOf(videoLimitTime / 60))).setPositiveButton(R.string.rc_confirm, (DialogInterface.OnClickListener) null).setCancelable(false).create().show();
                        return;
                    }
                }
                if (mediaItem.uri.endsWith(".gif")) {
                    int gIFLimitSize = RongIMClient.getInstance().getGIFLimitSize() * 1024;
                    File file = new File(mediaItem.uri);
                    if (file.exists() && file.length() > gIFLimitSize) {
                        new AlertDialog.Builder(PicturePreviewActivity.this).setMessage(PicturePreviewActivity.this.getResources().getString(R.string.rc_picsel_selected_max_gif_size_span_with_param)).setPositiveButton(R.string.rc_confirm, (DialogInterface.OnClickListener) null).setCancelable(false).create().show();
                        return;
                    }
                }
                if (!PicturePreviewActivity.this.mSelectBox.getChecked() && PicturePreviewActivity.this.getTotalSelectedNum() == 9) {
                    Toast.makeText(PicturePreviewActivity.this, R.string.rc_picsel_selected_max_pic_count, 0).show();
                    return;
                }
                PicturePreviewActivity.this.mSelectBox.setChecked(!PicturePreviewActivity.this.mSelectBox.getChecked());
                ((PictureSelectorActivity.MediaItem) PicturePreviewActivity.this.mItemList.get(PicturePreviewActivity.this.mCurrentIndex)).selected = PicturePreviewActivity.this.mSelectBox.getChecked();
                if (PicturePreviewActivity.this.mItemAllSelectedList == null) {
                    RLog.e(PicturePreviewActivity.TAG, "mItemAllSelectedList is null");
                } else if (PicturePreviewActivity.this.mSelectBox.getChecked()) {
                    PicturePreviewActivity.this.mItemAllSelectedList.add(PicturePreviewActivity.this.mItemList.get(PicturePreviewActivity.this.mCurrentIndex));
                } else {
                    PicturePreviewActivity.this.mItemAllSelectedList.remove(PicturePreviewActivity.this.mItemList.get(PicturePreviewActivity.this.mCurrentIndex));
                }
                PicturePreviewActivity.this.updateToolbar();
            }
        });
        this.mViewPager.setAdapter(new PreviewAdapter());
        this.mViewPager.setCurrentItem(this.mCurrentIndex);
        this.mViewPager.setOffscreenPageLimit(1);
        this.mViewPager.addOnPageChangeListener(new ViewPager.e() { // from class: io.rong.imkit.plugin.image.PicturePreviewActivity.5
            @Override // androidx.viewpager.widget.ViewPager.e
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.e
            public void onPageScrolled(int i, float f2, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.e
            public void onPageSelected(int i) {
                PicturePreviewActivity.this.mCurrentIndex = i;
                PicturePreviewActivity.this.mIndexTotal.setText(String.format("%d/%d", Integer.valueOf(i + 1), Integer.valueOf(PicturePreviewActivity.this.mItemList.size())));
                PicturePreviewActivity.this.mSelectBox.setChecked(((PictureSelectorActivity.MediaItem) PicturePreviewActivity.this.mItemList.get(i)).selected);
                PictureSelectorActivity.MediaItem mediaItem = (PictureSelectorActivity.MediaItem) PicturePreviewActivity.this.mItemList.get(i);
                PicturePreviewActivity.this.updateToolbar();
                if (mediaItem.mediaType == 3) {
                    PicturePreviewActivity.this.mUseOrigin.rootView.setVisibility(8);
                } else {
                    PicturePreviewActivity.this.mUseOrigin.rootView.setVisibility(0);
                }
            }
        });
        updateToolbar();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            Intent intent = new Intent();
            intent.putExtra("sendOrigin", this.mUseOrigin.getChecked());
            setResult(-1, intent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    public int readPictureDegree(String str, Context context) {
        return FileUtils.readPictureDegree(context, str);
    }
}
