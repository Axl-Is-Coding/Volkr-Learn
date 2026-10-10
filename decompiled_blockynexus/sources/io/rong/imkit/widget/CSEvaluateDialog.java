package io.rong.imkit.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import io.rong.common.RLog;
import io.rong.imkit.R;
import io.rong.imlib.CustomServiceConfig;
import io.rong.imlib.RongIMClient;

/* JADX INFO: loaded from: classes5.dex */
public class CSEvaluateDialog extends AlertDialog {
    private static final String TAG = "CSEvaluateDialog";
    private EvaluateClickListener mClickListener;
    private boolean mResolved;
    private CustomServiceConfig.CSEvaSolveStatus mSolveStatus;
    private int mStars;
    private String mTargetId;

    public interface EvaluateClickListener {
        void onEvaluateCanceled();

        void onEvaluateSubmit();
    }

    public CSEvaluateDialog(Context context, String str) {
        super(context);
        setCanceledOnTouchOutside(false);
        this.mTargetId = str;
    }

    public void destroy() {
        dismiss();
    }

    public void setClickListener(EvaluateClickListener evaluateClickListener) {
        this.mClickListener = evaluateClickListener;
    }

    @Override // android.app.Dialog
    public void setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        super.setOnCancelListener(onCancelListener);
    }

    public void showRobot(boolean z) {
        show();
        setContentView(R.layout.rc_cs_alert_robot_evaluation);
        final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.rc_cs_yes_no);
        if (z) {
            linearLayout.getChildAt(0).setSelected(true);
            linearLayout.getChildAt(1).setSelected(false);
        } else {
            linearLayout.getChildAt(0).setSelected(false);
            linearLayout.getChildAt(1).setSelected(true);
        }
        for (int i = 0; i < linearLayout.getChildCount(); i++) {
            linearLayout.getChildAt(i).setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.widget.CSEvaluateDialog.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    view.setSelected(true);
                    if (linearLayout.indexOfChild(view) == 0) {
                        linearLayout.getChildAt(1).setSelected(false);
                        CSEvaluateDialog.this.mResolved = true;
                    } else {
                        CSEvaluateDialog.this.mResolved = false;
                        linearLayout.getChildAt(0).setSelected(false);
                    }
                }
            });
        }
        findViewById(R.id.rc_btn_cancel).setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.widget.CSEvaluateDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CSEvaluateDialog.this.mClickListener != null) {
                    CSEvaluateDialog.this.mClickListener.onEvaluateCanceled();
                }
            }
        });
        findViewById(R.id.rc_btn_ok).setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.widget.CSEvaluateDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RongIMClient.getInstance().evaluateCustomService(CSEvaluateDialog.this.mTargetId, CSEvaluateDialog.this.mResolved, "");
                if (CSEvaluateDialog.this.mClickListener != null) {
                    CSEvaluateDialog.this.mClickListener.onEvaluateSubmit();
                }
            }
        });
    }

    public void showStar(final String str) {
        show();
        setContentView(R.layout.rc_cs_alert_human_evaluation);
        final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.rc_cs_stars);
        for (int i = 0; i < linearLayout.getChildCount(); i++) {
            linearLayout.getChildAt(i).setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.widget.CSEvaluateDialog.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int iIndexOfChild = linearLayout.indexOfChild(view);
                    int childCount = linearLayout.getChildCount();
                    int i2 = iIndexOfChild + 1;
                    CSEvaluateDialog.this.mStars = i2;
                    if (view.isSelected()) {
                        while (i2 < childCount) {
                            linearLayout.getChildAt(i2).setSelected(false);
                            i2++;
                        }
                    } else {
                        while (iIndexOfChild >= 0) {
                            linearLayout.getChildAt(iIndexOfChild).setSelected(true);
                            iIndexOfChild--;
                        }
                    }
                }
            });
        }
        findViewById(R.id.rc_btn_cancel).setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.widget.CSEvaluateDialog.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CSEvaluateDialog.this.mClickListener != null) {
                    CSEvaluateDialog.this.mClickListener.onEvaluateCanceled();
                }
            }
        });
        findViewById(R.id.rc_btn_ok).setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.widget.CSEvaluateDialog.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RongIMClient.getInstance().evaluateCustomService(CSEvaluateDialog.this.mTargetId, CSEvaluateDialog.this.mStars, null, str);
                if (CSEvaluateDialog.this.mClickListener != null) {
                    CSEvaluateDialog.this.mClickListener.onEvaluateSubmit();
                }
            }
        });
    }

    public void showStarMessage(boolean z) {
        setView((LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.rc_cs_evaluate, (ViewGroup) null));
        show();
        if (getWindow() != null) {
            getWindow().setContentView(R.layout.rc_cs_evaluate);
        } else {
            RLog.e(TAG, "getWindow is null.");
        }
        RatingBar ratingBar = (RatingBar) findViewById(R.id.rc_rating_bar);
        final TextView textView = (TextView) findViewById(R.id.rc_evaluate_level);
        TextView textView2 = (TextView) findViewById(R.id.rc_cs_resolved_or_not);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.rc_resolve_progress);
        final ImageView imageView = (ImageView) findViewById(R.id.rc_cs_resolved);
        final ImageView imageView2 = (ImageView) findViewById(R.id.rc_cs_resolving);
        final ImageView imageView3 = (ImageView) findViewById(R.id.rc_cs_unresolved);
        final EditText editText = (EditText) findViewById(R.id.rc_cs_evaluate_content);
        ImageView imageView4 = (ImageView) findViewById(R.id.rc_close_button);
        TextView textView3 = (TextView) findViewById(R.id.rc_submit_button);
        this.mStars = 5;
        if (z) {
            textView2.setVisibility(0);
            linearLayout.setVisibility(0);
            this.mSolveStatus = CustomServiceConfig.CSEvaSolveStatus.RESOLVED;
        } else {
            textView2.setVisibility(8);
            linearLayout.setVisibility(8);
        }
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() { // from class: io.rong.imkit.widget.CSEvaluateDialog.7
            @Override // android.widget.RatingBar.OnRatingBarChangeListener
            public void onRatingChanged(RatingBar ratingBar2, float f2, boolean z2) {
                if (ratingBar2.getId() == R.id.rc_rating_bar) {
                    if (f2 >= 5.0f) {
                        CSEvaluateDialog.this.mStars = 5;
                        textView.setText(R.string.rc_cs_very_satisfactory);
                        return;
                    }
                    if (f2 >= 4.0f && f2 < 5.0f) {
                        CSEvaluateDialog.this.mStars = 4;
                        textView.setText(R.string.rc_cs_satisfactory);
                        return;
                    }
                    if (f2 >= 3.0f && f2 < 4.0f) {
                        CSEvaluateDialog.this.mStars = 3;
                        textView.setText(R.string.rc_cs_average);
                    } else if (f2 < 2.0f || f2 >= 3.0f) {
                        CSEvaluateDialog.this.mStars = 1;
                        textView.setText(R.string.rc_cs_very_unsatisfactory);
                    } else {
                        CSEvaluateDialog.this.mStars = 2;
                        textView.setText(R.string.rc_cs_unsatisfactory);
                    }
                }
            }
        });
        textView.setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.widget.CSEvaluateDialog.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.widget.CSEvaluateDialog.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CSEvaluateDialog.this.mSolveStatus = CustomServiceConfig.CSEvaSolveStatus.RESOLVED;
                imageView.setImageDrawable(view.getResources().getDrawable(R.drawable.rc_cs_resolved_hover));
                imageView2.setImageDrawable(view.getResources().getDrawable(R.drawable.rc_cs_follow));
                imageView3.setImageDrawable(view.getResources().getDrawable(R.drawable.rc_cs_unresolved));
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.widget.CSEvaluateDialog.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CSEvaluateDialog.this.mSolveStatus = CustomServiceConfig.CSEvaSolveStatus.RESOLVING;
                imageView.setImageDrawable(view.getResources().getDrawable(R.drawable.rc_cs_resolved));
                imageView2.setImageDrawable(view.getResources().getDrawable(R.drawable.rc_cs_follow_hover));
                imageView3.setImageDrawable(view.getResources().getDrawable(R.drawable.rc_cs_unresolved));
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.widget.CSEvaluateDialog.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CSEvaluateDialog.this.mSolveStatus = CustomServiceConfig.CSEvaSolveStatus.UNRESOLVED;
                imageView.setImageDrawable(view.getResources().getDrawable(R.drawable.rc_cs_resolved));
                imageView2.setImageDrawable(view.getResources().getDrawable(R.drawable.rc_cs_follow));
                imageView3.setImageDrawable(view.getResources().getDrawable(R.drawable.rc_cs_unresolved_hover));
            }
        });
        editText.setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.widget.CSEvaluateDialog.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        imageView4.setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.widget.CSEvaluateDialog.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ((InputMethodManager) editText.getContext().getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
                if (CSEvaluateDialog.this.mClickListener != null) {
                    CSEvaluateDialog.this.mClickListener.onEvaluateCanceled();
                }
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() { // from class: io.rong.imkit.widget.CSEvaluateDialog.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ((InputMethodManager) editText.getContext().getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
                RongIMClient.getInstance().evaluateCustomService(CSEvaluateDialog.this.mTargetId, CSEvaluateDialog.this.mStars, CSEvaluateDialog.this.mSolveStatus, editText.getText().toString(), null);
                if (CSEvaluateDialog.this.mClickListener != null) {
                    CSEvaluateDialog.this.mClickListener.onEvaluateSubmit();
                }
            }
        });
    }
}
