package com.openld.roundcornerdemmo.gradientdrawable;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.openld.roundcornerdemmo.R;
import com.openld.roundcornerdemmo.utils.DisplayUtils;

public class GradientDrawableActivity extends AppCompatActivity {
    private LinearLayout mLly1;

    private LinearLayout mLly2;

    private LinearLayout mLly3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gradient_drawable);

        initWidgets();
    }

    private void initWidgets() {
        mLly1 = findViewById(R.id.lly1);
        GradientDrawable gradientDrawable1 = new GradientDrawable();
        gradientDrawable1.setShape(GradientDrawable.RECTANGLE);
        gradientDrawable1.setCornerRadius(DisplayUtils.dp2px(this, 10F));
        gradientDrawable1.setColor(getResources().getColor(R.color.colorPrimary));
        mLly1.setBackground(gradientDrawable1);

        mLly2 = findViewById(R.id.lly2);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(GradientDrawable.RECTANGLE);
        gradientDrawable2.setColor(getResources().getColor(R.color.colorAccent));
        float[] radii = new float[]{
                DisplayUtils.dp2px(this, 10F), DisplayUtils.dp2px(this, 10F),
                0F, 0F,
                0F, 0F,
                DisplayUtils.dp2px(this, 10F), DisplayUtils.dp2px(this, 10F)
        };
        gradientDrawable2.setCornerRadii(radii);
        mLly2.setBackground(gradientDrawable2);

        mLly3 = findViewById(R.id.lly3);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setShape(GradientDrawable.RECTANGLE);
        gradientDrawable3.setColor(getResources().getColor(R.color.colorPrimary));
        float[] radii1 = new float[]{
                DisplayUtils.dp2px(this, 10F), DisplayUtils.dp2px(this, 10F),
                0F, 0F,
                0F, 0F,
                0F, 0F
        };
        gradientDrawable3.setCornerRadii(radii1);
        mLly3.setBackground(gradientDrawable3);
    }
}