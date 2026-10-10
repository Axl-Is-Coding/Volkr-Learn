package io.rong.imkit.tools;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.a;
import io.rong.common.RLog;
import io.rong.imageloader.core.DisplayImageOptions;
import io.rong.imageloader.core.ImageLoader;
import io.rong.imageloader.core.assist.FailReason;
import io.rong.imageloader.core.imageaware.ImageAware;
import io.rong.imageloader.core.imageaware.ImageViewAware;
import io.rong.imageloader.core.listener.ImageLoadingListener;
import io.rong.imageloader.core.listener.ImageLoadingProgressListener;
import io.rong.imkit.R;
import io.rong.imkit.fragment.BaseFragment;
import io.rong.imkit.plugin.image.AlbumBitmapCacheHelper;
import io.rong.imkit.plugin.image.HackyViewPager;
import io.rong.imkit.widget.PicturePopupWindow;
import io.rong.imlib.RongCommonDefine;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;
import io.rong.imlib.model.Message;
import io.rong.message.ImageMessage;
import io.rong.photoview.PhotoView;
import io.rong.photoview.PhotoViewAttacher;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class PhotoFragment extends BaseFragment {
    private static final int IMAGE_MESSAGE_COUNT = 10;
    private static final String TAG = "PhotoFragment";
    private Conversation.ConversationType mConversationType;
    private ImageMessage mCurrentImageMessage;
    private int mCurrentMessageId;
    private PhotoDownloadListener mDownloadListener;
    private ImageAware mDownloadingImageAware;
    private ImageAdapter mImageAdapter;
    private HackyViewPager mViewPager;
    private String mTargetId = null;
    private int mCurrentIndex = 0;
    private boolean isFirstTime = false;
    private ViewPager.e mPageChangeListener = new ViewPager.e() { // from class: io.rong.imkit.tools.PhotoFragment.1
        @Override // androidx.viewpager.widget.ViewPager.e
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.e
        public void onPageScrolled(int i, float f2, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.e
        public void onPageSelected(int i) {
            RLog.i(PhotoFragment.TAG, "onPageSelected. position:" + i);
            PhotoFragment.this.mCurrentIndex = i;
            View viewFindViewById = PhotoFragment.this.mViewPager.findViewById(i);
            if (viewFindViewById != null) {
                PhotoFragment.this.mImageAdapter.updatePhotoView(i, viewFindViewById, PhotoFragment.this.mDownloadListener);
            }
            if (i == PhotoFragment.this.mImageAdapter.getCount() - 1) {
                PhotoFragment photoFragment = PhotoFragment.this;
                photoFragment.getConversationImageUris(photoFragment.mImageAdapter.getItem(i).getMessageId(), RongCommonDefine.GetMessageDirection.BEHIND);
            } else if (i == 0) {
                PhotoFragment photoFragment2 = PhotoFragment.this;
                photoFragment2.getConversationImageUris(photoFragment2.mImageAdapter.getItem(i).getMessageId(), RongCommonDefine.GetMessageDirection.FRONT);
            }
        }
    };

    private class ImageAdapter extends a {
        private ArrayList<ImageInfo> mImageList;
        private PicturePopupWindow menuWindow;
        private View.OnClickListener onMenuWindowClick;

        class ViewHolder {
            PhotoView photoView;
            ProgressBar progressBar;
            TextView progressText;

            ViewHolder() {
            }
        }

        private ImageAdapter() {
            this.mImageList = new ArrayList<>();
            this.onMenuWindowClick = new View.OnClickListener() { // from class: io.rong.imkit.tools.PhotoFragment.ImageAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ImageAdapter.this.menuWindow.dismiss();
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addData(ArrayList<ImageInfo> arrayList, boolean z) {
            if (arrayList == null || arrayList.size() == 0) {
                return;
            }
            if (this.mImageList.size() == 0) {
                this.mImageList.addAll(arrayList);
                return;
            }
            if (z && !PhotoFragment.this.isFirstTime && isUnDuplicate(arrayList.get(0).getMessageId())) {
                ArrayList arrayList2 = new ArrayList(this.mImageList);
                this.mImageList.clear();
                this.mImageList.addAll(arrayList);
                ArrayList<ImageInfo> arrayList3 = this.mImageList;
                arrayList3.addAll(arrayList3.size(), arrayList2);
                return;
            }
            if (PhotoFragment.this.isFirstTime || !isUnDuplicate(arrayList.get(0).getMessageId())) {
                return;
            }
            ArrayList<ImageInfo> arrayList4 = this.mImageList;
            arrayList4.addAll(arrayList4.size(), arrayList);
        }

        private DisplayImageOptions createDisplayImageOptions(Uri uri) {
            DisplayImageOptions.Builder builder = new DisplayImageOptions.Builder();
            Drawable drawableCreateFromPath = Drawable.createFromPath(uri.getPath());
            return builder.resetViewBeforeLoading(false).cacheInMemory(false).cacheOnDisk(true).bitmapConfig(Bitmap.Config.RGB_565).showImageForEmptyUri(drawableCreateFromPath).showImageOnFail(drawableCreateFromPath).showImageOnLoading(drawableCreateFromPath).handler(new Handler()).build();
        }

        private boolean isUnDuplicate(int i) {
            Iterator<ImageInfo> it = this.mImageList.iterator();
            while (it.hasNext()) {
                if (it.next().getMessageId() == i) {
                    return false;
                }
            }
            return true;
        }

        private View newView(Context context, final ImageInfo imageInfo) {
            View viewInflate = LayoutInflater.from(context).inflate(R.layout.rc_fr_image, (ViewGroup) null);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.progressBar = (ProgressBar) viewInflate.findViewById(R.id.rc_progress);
            viewHolder.progressText = (TextView) viewInflate.findViewById(R.id.rc_txt);
            viewHolder.photoView = (PhotoView) viewInflate.findViewById(R.id.rc_photoView);
            viewHolder.photoView.setOnLongClickListener(new View.OnLongClickListener() { // from class: io.rong.imkit.tools.PhotoFragment.ImageAdapter.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    Uri largeImageUri = imageInfo.getLargeImageUri();
                    File file = largeImageUri != null ? (largeImageUri.getScheme() == null || !(largeImageUri.getScheme().startsWith("http") || largeImageUri.getScheme().startsWith("https"))) ? new File(largeImageUri.getPath()) : ImageLoader.getInstance().getDiskCache().get(largeImageUri.toString()) : null;
                    ImageAdapter imageAdapter = ImageAdapter.this;
                    imageAdapter.menuWindow = new PicturePopupWindow(PhotoFragment.this.getActivity(), file);
                    ImageAdapter.this.menuWindow.showAtLocation(view, 81, 0, 0);
                    ImageAdapter.this.menuWindow.setOutsideTouchable(false);
                    return false;
                }
            });
            viewHolder.photoView.setOnPhotoTapListener(new PhotoViewAttacher.OnPhotoTapListener() { // from class: io.rong.imkit.tools.PhotoFragment.ImageAdapter.3
                @Override // io.rong.photoview.PhotoViewAttacher.OnPhotoTapListener
                public void onOutsidePhotoTap() {
                }

                @Override // io.rong.photoview.PhotoViewAttacher.OnPhotoTapListener
                public void onPhotoTap(View view, float f2, float f3) {
                    if (PhotoFragment.this.getActivity() != null) {
                        PhotoFragment.this.getActivity().finish();
                    }
                }
            });
            viewInflate.setTag(viewHolder);
            return viewInflate;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updatePhotoView(int i, View view, final PhotoDownloadListener photoDownloadListener) {
            final ViewHolder viewHolder = (ViewHolder) view.getTag();
            Uri largeImageUri = this.mImageList.get(i).getLargeImageUri();
            Uri thumbUri = this.mImageList.get(i).getThumbUri();
            if (largeImageUri == null || largeImageUri.getScheme() == null || thumbUri == null) {
                RLog.e(PhotoFragment.TAG, "large uri and thumbnail uri of the image should not be null.");
                return;
            }
            File file = (largeImageUri.getScheme().startsWith("http") || largeImageUri.getScheme().startsWith("https")) ? ImageLoader.getInstance().getDiskCache().get(largeImageUri.toString()) : new File(largeImageUri.getPath());
            if (file == null || !file.exists()) {
                if (i != PhotoFragment.this.mCurrentIndex) {
                    viewHolder.photoView.setImageDrawable(Drawable.createFromPath(thumbUri.getPath()));
                    return;
                }
                ImageViewAware imageViewAware = new ImageViewAware(viewHolder.photoView);
                if (PhotoFragment.this.mDownloadingImageAware != null) {
                    ImageLoader.getInstance().cancelDisplayTask(PhotoFragment.this.mDownloadingImageAware);
                }
                ImageLoader.getInstance().displayImage(largeImageUri.toString(), imageViewAware, createDisplayImageOptions(thumbUri), new ImageLoadingListener() { // from class: io.rong.imkit.tools.PhotoFragment.ImageAdapter.5
                    @Override // io.rong.imageloader.core.listener.ImageLoadingListener
                    public void onLoadingCancelled(String str, View view2) {
                        viewHolder.progressText.setVisibility(8);
                        viewHolder.progressText.setVisibility(8);
                    }

                    @Override // io.rong.imageloader.core.listener.ImageLoadingListener
                    public void onLoadingComplete(String str, View view2, Bitmap bitmap) {
                        PhotoDownloadListener photoDownloadListener2 = photoDownloadListener;
                        if (photoDownloadListener2 != null) {
                            photoDownloadListener2.onDownloaded(Uri.parse(str));
                        }
                        viewHolder.progressText.setVisibility(8);
                        viewHolder.progressBar.setVisibility(8);
                    }

                    @Override // io.rong.imageloader.core.listener.ImageLoadingListener
                    public void onLoadingFailed(String str, View view2, FailReason failReason) {
                        PhotoDownloadListener photoDownloadListener2 = photoDownloadListener;
                        if (photoDownloadListener2 != null) {
                            photoDownloadListener2.onDownloadError();
                        }
                        viewHolder.progressText.setVisibility(8);
                        viewHolder.progressBar.setVisibility(8);
                    }

                    @Override // io.rong.imageloader.core.listener.ImageLoadingListener
                    public void onLoadingStarted(String str, View view2) {
                        viewHolder.progressText.setVisibility(0);
                        viewHolder.progressBar.setVisibility(0);
                        viewHolder.progressText.setText("0%");
                    }
                }, new ImageLoadingProgressListener() { // from class: io.rong.imkit.tools.PhotoFragment.ImageAdapter.6
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
                PhotoFragment.this.mDownloadingImageAware = imageViewAware;
                return;
            }
            if (PhotoFragment.this.mDownloadListener != null) {
                PhotoFragment.this.mDownloadListener.onDownloaded(largeImageUri);
            }
            AlbumBitmapCacheHelper.getInstance().addPathToShowlist(file.getAbsolutePath());
            Bitmap bitmap = AlbumBitmapCacheHelper.getInstance().getBitmap(file.getAbsolutePath(), 0, 0, new AlbumBitmapCacheHelper.ILoadImageCallback() { // from class: io.rong.imkit.tools.PhotoFragment.ImageAdapter.4
                @Override // io.rong.imkit.plugin.image.AlbumBitmapCacheHelper.ILoadImageCallback
                public void onLoadImageCallBack(Bitmap bitmap2, String str, Object... objArr) {
                    if (bitmap2 == null) {
                        return;
                    }
                    viewHolder.photoView.setImageBitmap(bitmap2);
                }
            }, Integer.valueOf(i));
            if (bitmap != null) {
                viewHolder.photoView.setImageBitmap(bitmap);
            } else {
                viewHolder.photoView.setImageDrawable(Drawable.createFromPath(thumbUri.getPath()));
            }
        }

        @Override // androidx.viewpager.widget.a
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            RLog.i(PhotoFragment.TAG, "destroyItem.position:" + i);
            ((ViewHolder) viewGroup.findViewById(i).getTag()).photoView.setImageURI(null);
            viewGroup.removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.a
        public int getCount() {
            return this.mImageList.size();
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
            RLog.i(PhotoFragment.TAG, "instantiateItem.position:" + i);
            View viewNewView = newView(viewGroup.getContext(), this.mImageList.get(i));
            updatePhotoView(i, viewNewView, PhotoFragment.this.mDownloadListener);
            viewNewView.setId(i);
            viewGroup.addView(viewNewView);
            return viewNewView;
        }

        @Override // androidx.viewpager.widget.a
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    private class ImageInfo {
        private Uri largeImageUri;
        private int messageId;
        private Uri thumbUri;

        ImageInfo(int i, Uri uri, Uri uri2) {
            this.messageId = i;
            this.thumbUri = uri;
            this.largeImageUri = uri2;
        }

        Uri getLargeImageUri() {
            return this.largeImageUri;
        }

        int getMessageId() {
            return this.messageId;
        }

        Uri getThumbUri() {
            return this.thumbUri;
        }
    }

    public interface PhotoDownloadListener {
        void onDownloadError();

        void onDownloaded(Uri uri);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getConversationImageUris(int i, final RongCommonDefine.GetMessageDirection getMessageDirection) {
        if (this.mConversationType == null || TextUtils.isEmpty(this.mTargetId)) {
            return;
        }
        RongIMClient.getInstance().getHistoryMessages(this.mConversationType, this.mTargetId, "RC:ImgMsg", i, 10, getMessageDirection, new RongIMClient.ResultCallback<List<Message>>() { // from class: io.rong.imkit.tools.PhotoFragment.2
            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onError(RongIMClient.ErrorCode errorCode) {
            }

            @Override // io.rong.imlib.RongIMClient.ResultCallback
            public void onSuccess(List<Message> list) {
                ArrayList arrayList = new ArrayList();
                if (list != null) {
                    if (getMessageDirection.equals(RongCommonDefine.GetMessageDirection.FRONT)) {
                        Collections.reverse(list);
                    }
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        Message message = list.get(i2);
                        if (message.getContent() instanceof ImageMessage) {
                            ImageMessage imageMessage = (ImageMessage) message.getContent();
                            Uri remoteUri = imageMessage.getLocalUri() == null ? imageMessage.getRemoteUri() : imageMessage.getLocalUri();
                            if (imageMessage.getThumUri() != null && remoteUri != null) {
                                arrayList.add(PhotoFragment.this.new ImageInfo(message.getMessageId(), imageMessage.getThumUri(), remoteUri));
                            }
                        }
                    }
                }
                if (getMessageDirection.equals(RongCommonDefine.GetMessageDirection.FRONT) && PhotoFragment.this.isFirstTime) {
                    PhotoFragment photoFragment = PhotoFragment.this;
                    arrayList.add(photoFragment.new ImageInfo(photoFragment.mCurrentMessageId, PhotoFragment.this.mCurrentImageMessage.getThumUri(), PhotoFragment.this.mCurrentImageMessage.getLocalUri() == null ? PhotoFragment.this.mCurrentImageMessage.getRemoteUri() : PhotoFragment.this.mCurrentImageMessage.getLocalUri()));
                    PhotoFragment.this.mImageAdapter.addData(arrayList, true);
                    PhotoFragment.this.mViewPager.setAdapter(PhotoFragment.this.mImageAdapter);
                    PhotoFragment.this.isFirstTime = false;
                    PhotoFragment.this.mViewPager.setCurrentItem(arrayList.size() - 1);
                    PhotoFragment.this.mCurrentIndex = arrayList.size() - 1;
                    return;
                }
                if (arrayList.size() > 0) {
                    PhotoFragment.this.mImageAdapter.addData(arrayList, getMessageDirection.equals(RongCommonDefine.GetMessageDirection.FRONT));
                    PhotoFragment.this.mImageAdapter.notifyDataSetChanged();
                    if (getMessageDirection.equals(RongCommonDefine.GetMessageDirection.FRONT)) {
                        PhotoFragment.this.mViewPager.setCurrentItem(arrayList.size());
                        PhotoFragment.this.mCurrentIndex = arrayList.size();
                    }
                }
            }
        });
    }

    public void initPhoto(Message message, PhotoDownloadListener photoDownloadListener) {
        if (message == null) {
            return;
        }
        this.mCurrentImageMessage = (ImageMessage) message.getContent();
        this.mConversationType = message.getConversationType();
        this.mCurrentMessageId = message.getMessageId();
        this.mTargetId = message.getTargetId();
        this.mDownloadListener = photoDownloadListener;
        if (this.mCurrentMessageId < 0) {
            RLog.e(TAG, "The value of messageId is wrong!");
            return;
        }
        this.mImageAdapter = new ImageAdapter();
        this.isFirstTime = true;
        this.mViewPager.setOnPageChangeListener(this.mPageChangeListener);
        getConversationImageUris(this.mCurrentMessageId, RongCommonDefine.GetMessageDirection.FRONT);
        getConversationImageUris(this.mCurrentMessageId, RongCommonDefine.GetMessageDirection.BEHIND);
    }

    @Override // io.rong.imkit.fragment.BaseFragment
    public boolean onBackPressed() {
        return false;
    }

    @Override // io.rong.imkit.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.rc_fr_photo, viewGroup, true);
        this.mViewPager = (HackyViewPager) viewInflate.findViewById(R.id.viewpager);
        return viewInflate;
    }

    @Override // io.rong.imkit.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // io.rong.imkit.fragment.BaseFragment
    public void onRestoreUI() {
    }

    @Override // io.rong.imkit.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override // io.rong.imkit.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }
}
