package com.akhilpatoliya.videoplayerdemo;

import android.app.Activity;
import android.view.View;

public class FullScreenManager {

    private Activity mContext;
    private View[] views;

    /**
     * @param context
     * @param views to hide/show
     */
    public FullScreenManager(Activity context, View ... views) {
        mContext = context;
        this.views = views;
    }

    /**
     * call this method to enter full screen
     */
    public void enterFullScreen() {
        View decorView = mContext.getWindow().getDecorView();

        hideSystemUI(decorView);

        for(View view : views) {
            view.setVisibility(View.GONE);
            view.invalidate();
        }
    }

    /**
     * call this method to exit full screen
     */
    public void exitFullScreen() {
        View decorView = mContext.getWindow().getDecorView();

        showSystemUI(decorView);

        for(View view : views) {
            view.setVisibility(View.VISIBLE);
            view.invalidate();
        }
    }

    // hides the system bars.
    private void hideSystemUI(View mDecorView) {
        mDecorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }

    // This snippet shows the system bars.
    private void showSystemUI(View mDecorView) {
        mDecorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
//        mDecorView.setSystemUiVisibility(
//                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }
}
