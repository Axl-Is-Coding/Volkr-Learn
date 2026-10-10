package io.rong.imkit.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.a;
import io.rong.common.FileUtils;
import io.rong.common.LibStorageUtils;
import io.rong.common.RLog;
import io.rong.common.dlog.DLog;
import io.rong.eventbus.EventBus;
import io.rong.imageloader.core.DisplayImageOptions;
import io.rong.imageloader.core.ImageLoader;
import io.rong.imageloader.core.assist.FailReason;
import io.rong.imageloader.core.assist.ImageScaleType;
import io.rong.imageloader.core.listener.ImageLoadingListener;
import io.rong.imageloader.core.listener.ImageLoadingProgressListener;
import io.rong.imkit.R;
import io.rong.imkit.RongBaseNoActionbarActivity;
import io.rong.imkit.destruct.DestructManager;
import io.rong.imkit.model.Event;
import io.rong.imkit.plugin.image.HackyViewPager;
import io.rong.imkit.utilities.KitStorageUtils;
import io.rong.imkit.utilities.OptionsPopupDialog;
import io.rong.imkit.utilities.PermissionCheckUtil;
import io.rong.imkit.utils.ImageDownloadManager;
import io.rong.imlib.RongCommonDefine;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Message;
import io.rong.message.ImageMessage;
import io.rong.message.ReferenceMessage;
import io.rong.subscaleview.ImageSource;
import io.rong.subscaleview.SubsamplingScaleImageView;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class PicturePagerActivity extends RongBaseNoActionbarActivity implements View.OnLongClickListener {
    private static final int IMAGE_MESSAGE_COUNT = 10;
    private static final String TAG = "PicturePagerActivity";
    protected Conversation.ConversationType mConversationType;
    protected ImageMessage mCurrentImageMessage;
    protected int mCurrentMessageId;
    protected ImageAdapter mImageAdapter;
    protected Message mMessage;
    protected HackyViewPager mViewPager;
    protected String mTargetId = null;
    private int mCurrentIndex = 0;
    protected boolean isFirstTime = false;
    protected ViewPager.e mPageChangeListener = new ViewPager.e() { // from class: io.rong.imkit.activity.PicturePagerActivity.1
        @Override // androidx.viewpager.widget.ViewPager.e
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.e
        public void onPageScrolled(int i, float f2, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.e
        public void onPageSelected(int i) {
            RLog.i(PicturePagerActivity.TAG, "onPageSelected. position:" + i);
            PicturePagerActivity.this.mCurrentIndex = i;
            View viewFindViewById = PicturePagerActivity.this.mViewPager.findViewById(i);
            if (viewFindViewById != null) {
                PicturePagerActivity.this.mImageAdapter.updatePhotoView(i, viewFindViewById);
            }
            if (i == PicturePagerActivity.this.mImageAdapter.getCount() - 1) {
                PicturePagerActivity picturePagerActivity = PicturePagerActivity.this;
                picturePagerActivity.getConversationImageUris(picturePagerActivity.mImageAdapter.getItem(i).getMessageId().getMessageId(), RongCommonDefine.GetMessageDirection.BEHIND);
            } else if (i == 0) {
                PicturePagerActivity picturePagerActivity2 = PicturePagerActivity.this;
                picturePagerActivity2.getConversationImageUris(picturePagerActivity2.mImageAdapter.getItem(i).getMessageId().getMessageId(), RongCommonDefine.GetMessageDirection.FRONT);
            }
        }
    };

    private static class DestructListener implements RongIMClient.DestructCountDownTimerListener {
        private WeakReference<ImageAdapter.ViewHolder> mHolder;
        private String mMessageId;

        public DestructListener(ImageAdapter.ViewHolder viewHolder, String str) {
            this.mHolder = new WeakReference<>(viewHolder);
            this.mMessageId = str;
        }

        @Override // io.rong.imlib.RongIMClient.DestructCountDownTimerListener
        public void onStop(String str) {
            ImageAdapter.ViewHolder viewHolder;
            if (!this.mMessageId.equals(str) || (viewHolder = this.mHolder.get()) == null) {
                return;
            }
            viewHolder.mCountDownView.setVisibility(8);
        }

        @Override // io.rong.imlib.RongIMClient.DestructCountDownTimerListener
        public void onTick(long j, String str) {
            ImageAdapter.ViewHolder viewHolder;
            if (!this.mMessageId.equals(str) || (viewHolder = this.mHolder.get()) == null) {
                return;
            }
            viewHolder.mCountDownView.setVisibility(0);
            viewHolder.mCountDownView.setText(String.valueOf(Math.max(j, 1L)));
        }
    }

    protected class ImageAdapter extends a {
        private ArrayList<ImageInfo> mImageList = new ArrayList<>();

        public class ViewHolder {
            TextView mCountDownView;
            SubsamplingScaleImageView photoView;
            ProgressBar progressBar;
            TextView progressText;

            public ViewHolder() {
            }
        }

        protected ImageAdapter() {
        }

        private boolean isDuplicate(int i) {
            Iterator<ImageInfo> it = this.mImageList.iterator();
            while (it.hasNext()) {
                if (it.next().getMessageId().getMessageId() == i) {
                    return true;
                }
            }
            return false;
        }

        private View newView(Context context, ImageInfo imageInfo) {
            View viewInflate = LayoutInflater.from(context).inflate(R.layout.rc_fr_image, (ViewGroup) null);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.progressBar = (ProgressBar) viewInflate.findViewById(R.id.rc_progress);
            viewHolder.progressText = (TextView) viewInflate.findViewById(R.id.rc_txt);
            viewHolder.photoView = (SubsamplingScaleImageView) viewInflate.findViewById(R.id.rc_photoView);
            viewHolder.mCountDownView = (TextView) viewInflate.findViewById(R.id.rc_count_down);
            viewHolder.photoView.setOnLongClickListener(PicturePagerActivity.this);
            viewHolder.photoView.setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.activity.PicturePagerActivity.ImageAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Window window = PicturePagerActivity.this.getWindow();
                    if (window != null) {
                        window.setFlags(DLog.CRS, DLog.CRS);
                    }
                    PicturePagerActivity.this.finish();
                }
            });
            viewInflate.setTag(viewHolder);
            return viewInflate;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeRecallItem(int i) {
            for (int size = this.mImageList.size() - 1; size >= 0; size--) {
                if (this.mImageList.get(size).message.getMessageId() == i) {
                    this.mImageList.remove(size);
                    return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updatePhotoView(final int i, View view) {
            String string;
            final ViewHolder viewHolder = (ViewHolder) view.getTag();
            Uri largeImageUri = this.mImageList.get(i).getLargeImageUri();
            final Uri thumbUri = this.mImageList.get(i).getThumbUri();
            if (largeImageUri == null || thumbUri == null) {
                RLog.e(PicturePagerActivity.TAG, "large uri and thumbnail uri of the image should not be null.");
                return;
            }
            if (PicturePagerActivity.this.mCurrentImageMessage.isDestruct() && PicturePagerActivity.this.mMessage.getMessageDirection().equals(Message.MessageDirection.RECEIVE)) {
                DestructManager.getInstance().addListener(PicturePagerActivity.this.mMessage.getUId(), new DestructListener(viewHolder, PicturePagerActivity.this.mMessage.getUId()), PicturePagerActivity.TAG);
            }
            File file = ImageLoader.getInstance().getDiskCache().get(largeImageUri.toString());
            if (file == null || !file.exists()) {
                ImageLoader.getInstance().loadImage(largeImageUri.toString(), null, new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisk(true).imageScaleType(ImageScaleType.NONE).bitmapConfig(Bitmap.Config.RGB_565).considerExifParams(true).build(), new ImageLoadingListener() { // from class: io.rong.imkit.activity.PicturePagerActivity.ImageAdapter.2
                    @Override // io.rong.imageloader.core.listener.ImageLoadingListener
                    public void onLoadingCancelled(String str, View view2) {
                        viewHolder.progressText.setVisibility(8);
                        viewHolder.progressText.setVisibility(8);
                    }

                    @Override // io.rong.imageloader.core.listener.ImageLoadingListener
                    public void onLoadingComplete(String str, View view2, Bitmap bitmap) {
                        ViewHolder viewHolder2;
                        if (PicturePagerActivity.this.mCurrentImageMessage.isDestruct() && PicturePagerActivity.this.mMessage.getMessageDirection().equals(Message.MessageDirection.RECEIVE)) {
                            DestructManager.getInstance().startDestruct(PicturePagerActivity.this.mMessage);
                            EventBus.getDefault().post(new Event.changeDestructionReadTimeEvent(PicturePagerActivity.this.mMessage));
                        }
                        viewHolder.progressText.setVisibility(8);
                        viewHolder.progressBar.setVisibility(8);
                        File file2 = ImageLoader.getInstance().getDiskCache().get(str);
                        Uri uriFromFile = file2 != null ? Uri.fromFile(file2) : null;
                        if (uriFromFile == null) {
                            onLoadingFailed(str, view2, new FailReason(FailReason.FailType.IO_ERROR, new IllegalStateException("load complete but not in cache.")));
                            return;
                        }
                        viewHolder.photoView.suitMaxScaleWithSize(bitmap.getWidth(), bitmap.getHeight());
                        viewHolder.photoView.setImage(ImageSource.uri(uriFromFile));
                        View viewFindViewById = PicturePagerActivity.this.mViewPager.findViewById(i);
                        if (viewFindViewById == null || (viewHolder2 = (ViewHolder) viewFindViewById.getTag()) == viewHolder) {
                            return;
                        }
                        viewHolder2.progressText.setVisibility(8);
                        viewHolder2.progressBar.setVisibility(8);
                        PicturePagerActivity.this.mImageAdapter.updatePhotoView(i, viewFindViewById);
                    }

                    @Override // io.rong.imageloader.core.listener.ImageLoadingListener
                    public void onLoadingFailed(String str, View view2, FailReason failReason) {
                        if (str.startsWith("file://")) {
                            viewHolder.progressText.setVisibility(8);
                            viewHolder.progressBar.setVisibility(8);
                        } else if (PermissionCheckUtil.requestPermissions(PicturePagerActivity.this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"})) {
                            ImageDownloadManager.getInstance().downloadImage(str, new ImageDownloadManager.DownloadStatusListener() { // from class: io.rong.imkit.activity.PicturePagerActivity.ImageAdapter.2.1
                                @Override // io.rong.imkit.utils.ImageDownloadManager.DownloadStatusListener
                                public void downloadFailed(ImageDownloadManager.DownloadStatusError downloadStatusError) {
                                    viewHolder.progressText.setVisibility(8);
                                    viewHolder.progressBar.setVisibility(8);
                                }

                                @Override // io.rong.imkit.utils.ImageDownloadManager.DownloadStatusListener
                                public void downloadSuccess(String str2, Bitmap bitmap) {
                                    viewHolder.photoView.setImage(ImageSource.uri(str2));
                                    viewHolder.progressText.setVisibility(8);
                                    viewHolder.progressBar.setVisibility(8);
                                }
                            });
                        } else {
                            viewHolder.progressText.setVisibility(8);
                            viewHolder.progressBar.setVisibility(8);
                        }
                    }

                    @Override // io.rong.imageloader.core.listener.ImageLoadingListener
                    public void onLoadingStarted(String str, View view2) {
                        String strSubstring = LibStorageUtils.FILE.equals(thumbUri.getScheme()) ? thumbUri.toString().substring(5) : null;
                        viewHolder.photoView.setBitmapAndFileUri(strSubstring != null ? BitmapFactory.decodeFile(strSubstring) : null, null);
                        viewHolder.progressText.setVisibility(0);
                        viewHolder.progressBar.setVisibility(0);
                        viewHolder.progressText.setText("0%");
                    }
                }, new ImageLoadingProgressListener() { // from class: io.rong.imkit.activity.PicturePagerActivity.ImageAdapter.3
                    @Override // io.rong.imageloader.core.listener.ImageLoadingProgressListener
                    public void onProgressUpdate(String str, View view2, int i2, int i3) {
                        viewHolder.progressText.setText(((i2 * 100) / i3) + "%");
                        if (i2 == i3) {
                            viewHolder.progressText.setVisibility(8);
                            viewHolder.progressBar.setVisibility(8);
                        } else {
                            viewHolder.progressText.setVisibility(0);
                            viewHolder.progressBar.setVisibility(0);
                        }
                    }
                });
                return;
            }
            Uri uriFromFile = Uri.fromFile(file);
            if (uriFromFile.equals(viewHolder.photoView.getUri())) {
                return;
            }
            if (uriFromFile.getScheme().equals(LibStorageUtils.FILE)) {
                string = uriFromFile.toString().substring(5);
            } else if (uriFromFile.getScheme().equals("content")) {
                Cursor cursorQuery = PicturePagerActivity.this.getApplicationContext().getContentResolver().query(uriFromFile, new String[]{"_data"}, null, null, null);
                cursorQuery.moveToFirst();
                string = cursorQuery.getString(0);
                cursorQuery.close();
            } else {
                string = "";
            }
            viewHolder.photoView.setOrientation(FileUtils.readPictureDegree(PicturePagerActivity.this, string));
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(string, options);
            viewHolder.photoView.suitMaxScaleWithSize(options.outWidth, options.outHeight);
            viewHolder.photoView.setImage(ImageSource.uri(uriFromFile));
        }

        public void addData(ArrayList<ImageInfo> arrayList, boolean z) {
            if (arrayList == null || arrayList.size() == 0) {
                return;
            }
            if (this.mImageList.size() == 0) {
                this.mImageList.addAll(arrayList);
                return;
            }
            if (!z || PicturePagerActivity.this.isFirstTime || isDuplicate(arrayList.get(0).getMessageId().getMessageId())) {
                if (PicturePagerActivity.this.isFirstTime || isDuplicate(arrayList.get(0).getMessageId().getMessageId())) {
                    return;
                }
                ArrayList<ImageInfo> arrayList2 = this.mImageList;
                arrayList2.addAll(arrayList2.size(), arrayList);
                return;
            }
            ArrayList arrayList3 = new ArrayList();
            arrayList3.addAll(this.mImageList);
            this.mImageList.clear();
            this.mImageList.addAll(arrayList);
            ArrayList<ImageInfo> arrayList4 = this.mImageList;
            arrayList4.addAll(arrayList4.size(), arrayList3);
        }

        @Override // androidx.viewpager.widget.a
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            RLog.i(PicturePagerActivity.TAG, "destroyItem.position:" + i);
            viewGroup.removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.a
        public int getCount() {
            return this.mImageList.size();
        }

        public ImageInfo getImageInfo(int i) {
            return this.mImageList.get(i);
        }

        public ImageInfo getItem(int i) {
            return this.mImageList.get(i);
        }

        @Override // androidx.viewpager.widget.a
        public int getItemPosition(Object obj) {
            return -2;
        }

        @Override // androidx.viewpager.widget.a
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            RLog.i(PicturePagerActivity.TAG, "instantiateItem.position:" + i);
            View viewNewView = newView(viewGroup.getContext(), this.mImageList.get(i));
            updatePhotoView(i, viewNewView);
            viewNewView.setId(i);
            viewGroup.addView(viewNewView);
            return viewNewView;
        }

        @Override // androidx.viewpager.widget.a
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    protected class ImageInfo {
        private Uri largeImageUri;
        private Message message;
        private Uri thumbUri;

        ImageInfo(Message message, Uri uri, Uri uri2) {
            this.message = message;
            this.thumbUri = uri;
            this.largeImageUri = uri2;
        }

        public Uri getLargeImageUri() {
            return this.largeImageUri;
        }

        public Message getMessageId() {
            return this.message;
        }

        public Uri getThumbUri() {
            return this.thumbUri;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getConversationImageUris(int i, final RongCommonDefine.GetMessageDirection getMessageDirection) {
        if (this.mConversationType == null || TextUtils.isEmpty(this.mTargetId)) {
            return;
        }
        RongIMClient.getInstance().getHistoryMessages(this.mConversationType, this.mTargetId, "RC:ImgMsg", i, 10, getMessageDirection, new RongIMClient.ResultCallback<List<Message>>() { // from class: io.rong.imkit.activity.PicturePagerActivity.3
            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onError(RongIMClient.ErrorCode errorCode) {
            }

            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onSuccess(List<Message> list) {
                ArrayList<ImageInfo> arrayList = new ArrayList<>();
                if (list != null) {
                    if (getMessageDirection.equals(RongCommonDefine.GetMessageDirection.FRONT)) {
                        Collections.reverse(list);
                    }
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        Message message = list.get(i2);
                        if ((message.getContent() instanceof ImageMessage) && !message.getContent().isDestruct()) {
                            ImageMessage imageMessage = (ImageMessage) message.getContent();
                            Uri remoteUri = imageMessage.getLocalUri() == null ? imageMessage.getRemoteUri() : imageMessage.getLocalUri();
                            if (imageMessage.getThumUri() != null && remoteUri != null) {
                                arrayList.add(PicturePagerActivity.this.new ImageInfo(message, imageMessage.getThumUri(), remoteUri));
                            }
                        }
                    }
                }
                if (getMessageDirection.equals(RongCommonDefine.GetMessageDirection.FRONT)) {
                    PicturePagerActivity picturePagerActivity = PicturePagerActivity.this;
                    if (picturePagerActivity.isFirstTime) {
                        arrayList.add(picturePagerActivity.new ImageInfo(picturePagerActivity.mMessage, picturePagerActivity.mCurrentImageMessage.getThumUri(), PicturePagerActivity.this.mCurrentImageMessage.getLocalUri() == null ? PicturePagerActivity.this.mCurrentImageMessage.getRemoteUri() : PicturePagerActivity.this.mCurrentImageMessage.getLocalUri()));
                        PicturePagerActivity.this.mImageAdapter.addData(arrayList, getMessageDirection.equals(RongCommonDefine.GetMessageDirection.FRONT));
                        PicturePagerActivity picturePagerActivity2 = PicturePagerActivity.this;
                        picturePagerActivity2.mViewPager.setAdapter(picturePagerActivity2.mImageAdapter);
                        PicturePagerActivity picturePagerActivity3 = PicturePagerActivity.this;
                        picturePagerActivity3.isFirstTime = false;
                        picturePagerActivity3.mViewPager.setCurrentItem(arrayList.size() - 1);
                        PicturePagerActivity.this.mCurrentIndex = arrayList.size() - 1;
                        return;
                    }
                }
                if (arrayList.size() > 0) {
                    PicturePagerActivity.this.mImageAdapter.addData(arrayList, getMessageDirection.equals(RongCommonDefine.GetMessageDirection.FRONT));
                    PicturePagerActivity.this.mImageAdapter.notifyDataSetChanged();
                    if (getMessageDirection.equals(RongCommonDefine.GetMessageDirection.FRONT)) {
                        PicturePagerActivity.this.mViewPager.setCurrentItem(arrayList.size());
                        PicturePagerActivity.this.mCurrentIndex = arrayList.size();
                    }
                }
            }
        });
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.rc_fr_photo);
        Message message = (Message) getIntent().getParcelableExtra("message");
        this.mMessage = message;
        if (message.getContent() instanceof ReferenceMessage) {
            this.mCurrentImageMessage = (ImageMessage) ((ReferenceMessage) message.getContent()).getReferenceContent();
        } else {
            this.mCurrentImageMessage = (ImageMessage) message.getContent();
        }
        this.mConversationType = message.getConversationType();
        this.mCurrentMessageId = message.getMessageId();
        this.mTargetId = message.getTargetId();
        this.mViewPager = (HackyViewPager) findViewById(R.id.viewpager);
        this.mViewPager.setOnPageChangeListener(this.mPageChangeListener);
        this.mImageAdapter = new ImageAdapter();
        this.isFirstTime = true;
        if (this.mMessage.getContent().isDestruct() || (this.mMessage.getContent() instanceof ReferenceMessage)) {
            ArrayList<ImageInfo> arrayList = new ArrayList<>();
            arrayList.add(new ImageInfo(this.mMessage, this.mCurrentImageMessage.getThumUri(), this.mCurrentImageMessage.getLocalUri() == null ? this.mCurrentImageMessage.getRemoteUri() : this.mCurrentImageMessage.getLocalUri()));
            this.mImageAdapter.addData(arrayList, true);
            this.mViewPager.setAdapter(this.mImageAdapter);
        } else {
            getConversationImageUris(this.mCurrentMessageId, RongCommonDefine.GetMessageDirection.FRONT);
            getConversationImageUris(this.mCurrentMessageId, RongCommonDefine.GetMessageDirection.BEHIND);
        }
        if (EventBus.getDefault().isRegistered(this)) {
            return;
        }
        EventBus.getDefault().register(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        ImageLoader.getInstance().clearMemoryCache();
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public void onEventMainThread(Event.RemoteMessageRecallEvent remoteMessageRecallEvent) {
        if (this.mCurrentMessageId == remoteMessageRecallEvent.getMessageId()) {
            new AlertDialog.Builder(this, 5).setMessage(getString(R.string.rc_recall_success)).setPositiveButton(getString(R.string.rc_dialog_ok), new DialogInterface.OnClickListener() { // from class: io.rong.imkit.activity.PicturePagerActivity.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    PicturePagerActivity.this.finish();
                }
            }).setCancelable(false).show();
            return;
        }
        if ("RC:ImgMsg".equals(remoteMessageRecallEvent.getRecallNotificationMessage().getOriginalObjectName())) {
            this.mImageAdapter.removeRecallItem(remoteMessageRecallEvent.getMessageId());
            this.mImageAdapter.notifyDataSetChanged();
            if (this.mImageAdapter.getCount() == 0) {
                finish();
            }
        }
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (this.mCurrentImageMessage.isDestruct()) {
            return false;
        }
        ImageInfo imageInfo = this.mImageAdapter.getImageInfo(this.mCurrentIndex);
        if (imageInfo != null) {
            Uri thumbUri = imageInfo.getThumbUri();
            Uri largeImageUri = imageInfo.getLargeImageUri();
            if (onPictureLongClick(view, thumbUri, largeImageUri)) {
                return true;
            }
            if (largeImageUri != null) {
                final File file = (largeImageUri.getScheme().startsWith("http") || largeImageUri.getScheme().startsWith("https")) ? ImageLoader.getInstance().getDiskCache().get(largeImageUri.toString()) : new File(largeImageUri.getPath());
                if (file != null && file.exists()) {
                    OptionsPopupDialog.newInstance(this, new String[]{getString(R.string.rc_save_picture)}).setOptionsPopupDialogListener(new OptionsPopupDialog.OnOptionsItemClickedListener() { // from class: io.rong.imkit.activity.PicturePagerActivity.4
                        @Override // io.rong.imkit.utilities.OptionsPopupDialog.OnOptionsItemClickedListener
                        public void onOptionsItemClicked(int i) {
                            if (i == 0 && PermissionCheckUtil.requestPermissions(PicturePagerActivity.this, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"})) {
                                File file2 = file;
                                if (file2 == null || !file2.exists()) {
                                    PicturePagerActivity picturePagerActivity = PicturePagerActivity.this;
                                    Toast.makeText(picturePagerActivity, picturePagerActivity.getString(R.string.rc_src_file_not_found), 0).show();
                                } else {
                                    KitStorageUtils.saveMediaToPublicDir(PicturePagerActivity.this, file, "image");
                                    PicturePagerActivity picturePagerActivity2 = PicturePagerActivity.this;
                                    Toast.makeText(picturePagerActivity2, picturePagerActivity2.getString(R.string.rc_save_picture_at), 0).show();
                                }
                            }
                        }
                    }).show();
                }
            }
            return false;
        }
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    public boolean onPictureLongClick(View view, Uri uri, Uri uri2) {
        return false;
    }

    public void onEventMainThread(Event.MessageDeleteEvent messageDeleteEvent) {
        RLog.d(TAG, "MessageDeleteEvent");
        if (messageDeleteEvent.getMessageIds() != null) {
            Iterator<Integer> it = messageDeleteEvent.getMessageIds().iterator();
            while (it.hasNext()) {
                this.mImageAdapter.removeRecallItem(it.next().intValue());
            }
            this.mImageAdapter.notifyDataSetChanged();
            if (this.mImageAdapter.getCount() == 0) {
                finish();
            }
        }
    }
}
