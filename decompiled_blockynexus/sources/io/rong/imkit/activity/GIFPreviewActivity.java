package io.rong.imkit.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.c;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.e;
import com.bumptech.glide.request.target.Target;
import io.rong.common.dlog.DLog;
import io.rong.eventbus.EventBus;
import io.rong.imkit.R;
import io.rong.imkit.RongBaseNoActionbarActivity;
import io.rong.imkit.RongContext;
import io.rong.imkit.destruct.DestructManager;
import io.rong.imkit.model.Event;
import io.rong.imkit.utilities.KitStorageUtils;
import io.rong.imkit.utilities.OptionsPopupDialog;
import io.rong.imkit.utilities.PermissionCheckUtil;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Message;
import io.rong.message.GIFMessage;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public class GIFPreviewActivity extends RongBaseNoActionbarActivity {
    private static final String TAG = "GIFPreviewActivity";
    Message currentMessage;
    TextView mCountDownView;

    private static class DestructListener implements RongIMClient.DestructCountDownTimerListener {
        private WeakReference<TextView> mCountDownView;
        private String mMessageId;

        public DestructListener(TextView textView, String str) {
            this.mCountDownView = new WeakReference<>(textView);
            this.mMessageId = str;
        }

        @Override // io.rong.imlib.RongIMClient.DestructCountDownTimerListener
        public void onStop(String str) {
            TextView textView;
            if (!this.mMessageId.equals(str) || (textView = this.mCountDownView.get()) == null) {
                return;
            }
            textView.setVisibility(8);
        }

        @Override // io.rong.imlib.RongIMClient.DestructCountDownTimerListener
        public void onTick(long j, String str) {
            TextView textView;
            if (!this.mMessageId.equals(str) || (textView = this.mCountDownView.get()) == null) {
                return;
            }
            textView.setVisibility(0);
            textView.setText(String.valueOf(Math.max(j, 1L)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveGif(GIFMessage gIFMessage) {
        final File file = new File(gIFMessage.getLocalUri().getPath());
        if (file.exists()) {
            OptionsPopupDialog.newInstance(this, new String[]{getString(R.string.rc_save_picture)}).setOptionsPopupDialogListener(new OptionsPopupDialog.OnOptionsItemClickedListener() { // from class: io.rong.imkit.activity.GIFPreviewActivity.4
                @Override // io.rong.imkit.utilities.OptionsPopupDialog.OnOptionsItemClickedListener
                public void onOptionsItemClicked(int i) {
                    if (i == 0 && PermissionCheckUtil.requestPermissions(GIFPreviewActivity.this, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"})) {
                        File file2 = file;
                        if (file2 == null || !file2.exists()) {
                            GIFPreviewActivity gIFPreviewActivity = GIFPreviewActivity.this;
                            Toast.makeText(gIFPreviewActivity, gIFPreviewActivity.getString(R.string.rc_src_file_not_found), 0).show();
                            return;
                        }
                        String str = "rong_" + System.currentTimeMillis() + ".gif";
                        KitStorageUtils.saveMediaToPublicDir(GIFPreviewActivity.this, file, "image");
                        GIFPreviewActivity gIFPreviewActivity2 = GIFPreviewActivity.this;
                        Toast.makeText(gIFPreviewActivity2, gIFPreviewActivity2.getString(R.string.rc_save_picture_at), 0).show();
                    }
                }
            }).show();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.rc_gif_preview);
        this.mCountDownView = (TextView) findViewById(R.id.rc_count_down);
        ImageView imageView = (ImageView) findViewById(R.id.rc_gif_preview);
        this.currentMessage = (Message) getIntent().getParcelableExtra("message");
        RongContext.getInstance().getEventBus().register(this);
        Message message = this.currentMessage;
        if (message == null || message.getContent() == null || !(this.currentMessage.getContent() instanceof GIFMessage)) {
            finish();
            return;
        }
        imageView.setOnLongClickListener(new View.OnLongClickListener() { // from class: io.rong.imkit.activity.GIFPreviewActivity.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                GIFMessage gIFMessage = (GIFMessage) GIFPreviewActivity.this.currentMessage.getContent();
                if (gIFMessage.isDestruct()) {
                    return false;
                }
                GIFPreviewActivity.this.saveGif(gIFMessage);
                return false;
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.activity.GIFPreviewActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Window window = GIFPreviewActivity.this.getWindow();
                if (window != null) {
                    window.setFlags(DLog.CRS, DLog.CRS);
                }
                GIFPreviewActivity.this.finish();
            }
        });
        GIFMessage gIFMessage = (GIFMessage) this.currentMessage.getContent();
        if (gIFMessage.isDestruct() && this.currentMessage.getMessageDirection().equals(Message.MessageDirection.RECEIVE)) {
            DestructManager.getInstance().addListener(this.currentMessage.getUId(), new DestructListener(this.mCountDownView, this.currentMessage.getUId()), TAG);
        }
        if (gIFMessage.getLocalUri() != null) {
            c.a((FragmentActivity) this).asGif().addListener(new e<GifDrawable>() { // from class: io.rong.imkit.activity.GIFPreviewActivity.3
                @Override // com.bumptech.glide.request.e
                public boolean onLoadFailed(GlideException glideException, Object obj, Target<GifDrawable> target, boolean z) {
                    return false;
                }

                @Override // com.bumptech.glide.request.e
                public boolean onResourceReady(GifDrawable gifDrawable, Object obj, Target<GifDrawable> target, DataSource dataSource, boolean z) {
                    if (!GIFPreviewActivity.this.currentMessage.getContent().isDestruct() || GIFPreviewActivity.this.currentMessage.getMessageDirection() != Message.MessageDirection.RECEIVE || GIFPreviewActivity.this.currentMessage.getReadTime() > 0 || TextUtils.isEmpty(GIFPreviewActivity.this.currentMessage.getUId())) {
                        return false;
                    }
                    DestructManager.getInstance().startDestruct(GIFPreviewActivity.this.currentMessage);
                    EventBus.getDefault().post(new Event.changeDestructionReadTimeEvent(GIFPreviewActivity.this.currentMessage));
                    return false;
                }
            }).mo46load(gIFMessage.getLocalUri().getPath()).into(imageView);
        }
        if (EventBus.getDefault().isRegistered(this)) {
            return;
        }
        EventBus.getDefault().register(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public void onEventMainThread(Event.MessageDeleteEvent messageDeleteEvent) {
        if (messageDeleteEvent.getMessageIds() == null || this.currentMessage == null) {
            return;
        }
        Iterator<Integer> it = messageDeleteEvent.getMessageIds().iterator();
        while (it.hasNext()) {
            if (it.next().intValue() == this.currentMessage.getMessageId()) {
                finish();
                return;
            }
        }
    }

    public void onEventMainThread(Event.RemoteMessageRecallEvent remoteMessageRecallEvent) {
        Message message = this.currentMessage;
        if (message != null && message.getMessageId() == remoteMessageRecallEvent.getMessageId()) {
            new AlertDialog.Builder(this, 5).setMessage(getString(R.string.rc_recall_success)).setPositiveButton(getString(R.string.rc_dialog_ok), new DialogInterface.OnClickListener() { // from class: io.rong.imkit.activity.GIFPreviewActivity.5
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    GIFPreviewActivity.this.finish();
                }
            }).setCancelable(false).show();
        }
    }
}
