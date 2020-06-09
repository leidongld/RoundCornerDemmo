package com.openld.roundcornerdemmo.viewoutlineprovider;

import android.graphics.Outline;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.LinearLayout;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.openld.roundcornerdemmo.R;
import com.openld.roundcornerdemmo.utils.DisplayUtils;

public class ViewOutlineProviderActivity extends AppCompatActivity {
    private LinearLayout mLly;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_outline_provider);

        initWidgets();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void initWidgets() {
        mLly = findViewById(R.id.lly);

        mLly.setOutlineProvider(new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), DisplayUtils.dp2px(ViewOutlineProviderActivity.this, 10F));
            }
        });
        mLly.setClipToOutline(true);
    }
}