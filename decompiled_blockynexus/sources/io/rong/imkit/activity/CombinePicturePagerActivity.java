package io.rong.imkit.activity;

import android.os.Bundle;
import io.rong.eventbus.EventBus;
import io.rong.imkit.R;
import io.rong.imkit.activity.PicturePagerActivity;
import io.rong.imkit.plugin.image.HackyViewPager;
import io.rong.imlib.model.Message;
import io.rong.message.ImageMessage;
import io.rong.message.ReferenceMessage;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public class CombinePicturePagerActivity extends PicturePagerActivity {
    @Override // io.rong.imkit.activity.PicturePagerActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
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
        this.mImageAdapter = new PicturePagerActivity.ImageAdapter();
        this.isFirstTime = true;
        ArrayList<PicturePagerActivity.ImageInfo> arrayList = new ArrayList<>();
        arrayList.add(new PicturePagerActivity.ImageInfo(this.mMessage, this.mCurrentImageMessage.getThumUri(), this.mCurrentImageMessage.getLocalUri() == null ? this.mCurrentImageMessage.getRemoteUri() : this.mCurrentImageMessage.getLocalUri()));
        this.mImageAdapter.addData(arrayList, true);
        this.mViewPager.setAdapter(this.mImageAdapter);
        if (EventBus.getDefault().isRegistered(this)) {
            return;
        }
        EventBus.getDefault().register(this);
    }
}
