package io.rong.imkit.widget;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaScannerConnection;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;
import io.rong.common.FileUtils;
import io.rong.imkit.R;
import io.rong.imkit.utilities.KitStorageUtils;
import java.io.File;

/* JADX INFO: loaded from: classes5.dex */
public class PicturePopupWindow extends PopupWindow {
    public PicturePopupWindow(final Context context, final File file) {
        super(context);
        View viewInflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.rc_pic_popup_window, (ViewGroup) null);
        viewInflate.setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.widget.PicturePopupWindow.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PicturePopupWindow.this.dismiss();
            }
        });
        ((Button) viewInflate.findViewById(R.id.rc_content)).setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.widget.PicturePopupWindow.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String imageSavePath = KitStorageUtils.getImageSavePath(view.getContext());
                File file2 = file;
                if (file2 == null || !file2.exists()) {
                    Context context2 = context;
                    Toast.makeText(context2, context2.getString(R.string.rc_src_file_not_found), 0).show();
                } else {
                    String str = System.currentTimeMillis() + ".jpg";
                    FileUtils.copyFile(file, imageSavePath + File.separator, str);
                    MediaScannerConnection.scanFile(context.getApplicationContext(), new String[]{imageSavePath + File.separator + str}, null, null);
                    Context context3 = context;
                    Toast.makeText(context3, String.format(context3.getString(R.string.rc_save_picture_at), imageSavePath + File.separator + str), 0).show();
                }
                PicturePopupWindow.this.dismiss();
            }
        });
        ((Button) viewInflate.findViewById(R.id.rc_btn_cancel)).setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.widget.PicturePopupWindow.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PicturePopupWindow.this.dismiss();
            }
        });
        setContentView(viewInflate);
        setWidth(-1);
        setHeight(-2);
        setFocusable(true);
        setBackgroundDrawable(new ColorDrawable(-1342177280));
    }
}
