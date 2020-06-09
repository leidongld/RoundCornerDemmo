package com.openld.roundcornerdemmo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.openld.roundcornerdemmo.cardview.CardViewActivity;
import com.openld.roundcornerdemmo.clippath.ClipPathActivity;
import com.openld.roundcornerdemmo.gradientdrawable.GradientDrawableActivity;
import com.openld.roundcornerdemmo.viewoutlineprovider.ViewOutlineProviderActivity;
import com.openld.roundcornerdemmo.xmlshape.XmlShapeActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnShapeXml;

    private Button mBtnGradientDrawable;

    private Button mBtnClipPath;

    private Button mBtnCardView;

    private Button mBtnViewOutlineProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidgets();
    }

    private void initWidgets() {
        mBtnShapeXml = findViewById(R.id.btn_xml_shape);
        mBtnShapeXml.setOnClickListener(this);

        mBtnGradientDrawable = findViewById(R.id.btn_gradient_dawable);
        mBtnGradientDrawable.setOnClickListener(this);

        mBtnClipPath = findViewById(R.id.btn_clip_path);
        mBtnClipPath.setOnClickListener(this);

        mBtnCardView = findViewById(R.id.btn_cardview);
        mBtnCardView.setOnClickListener(this);

        mBtnViewOutlineProvider = findViewById(R.id.btn_view_outline_provider);
        mBtnViewOutlineProvider.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        Intent intent = null;
        if (id == R.id.btn_xml_shape) {
            intent = new Intent(MainActivity.this, XmlShapeActivity.class);
        } else if (id == R.id.btn_gradient_dawable) {
            intent = new Intent(MainActivity.this, GradientDrawableActivity.class);
        } else if (id == R.id.btn_clip_path) {
            intent = new Intent(MainActivity.this, ClipPathActivity.class);
        } else if (id == R.id.btn_cardview) {
            intent = new Intent(MainActivity.this, CardViewActivity.class);
        } else if (id == R.id.btn_view_outline_provider) {
            intent = new Intent(MainActivity.this, ViewOutlineProviderActivity.class);
        }

        startActivity(intent);
    }
}