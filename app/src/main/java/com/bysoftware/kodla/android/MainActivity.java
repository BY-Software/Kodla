package com.bysoftware.kodla.android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.nightonke.boommenu.BoomButtons.ButtonPlaceEnum;
import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomButtons.SimpleCircleButton;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.ButtonEnum;
import com.nightonke.boommenu.Piece.PiecePlaceEnum;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bmb)
    BoomMenuButton bmb;

    private static int imageResourceIndex = 0;

    private static int[] imageResources = new int[]{
            R.drawable.android,
            R.drawable.github,
            R.drawable.java,
            R.drawable.js,
            R.drawable.kotlin,
            R.drawable.swift,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        assert bmb != null;
        bmb.setButtonEnum(ButtonEnum.SimpleCircle);
        bmb.setPiecePlaceEnum(PiecePlaceEnum.DOT_6_4);
        bmb.setButtonPlaceEnum(ButtonPlaceEnum.SC_6_4);
        bmb.addBuilder(getSimpleCircleButtonBuilder());
        bmb.clearBuilders();
        for (int i = 0; i < bmb.getPiecePlaceEnum().pieceNumber(); i++) {
            bmb.addBuilder(getSimpleCircleButtonBuilder());
        }
    }

    SimpleCircleButton.Builder getSimpleCircleButtonBuilder() {
        return new SimpleCircleButton.Builder().listener(new OnBMClickListener() {
            @Override
            public void onBoomButtonClick(int index) {
                if (index == 0) {
                    Toast.makeText(MainActivity.this, "GitHub", Toast.LENGTH_SHORT).show();
                } else if (index == 1) {
                    Toast.makeText(MainActivity.this, "Java", Toast.LENGTH_SHORT).show();
                } else if (index == 2) {
                    Toast.makeText(MainActivity.this, "JavaScript", Toast.LENGTH_SHORT).show();
                } else if (index == 3) {
                    Toast.makeText(MainActivity.this, "Kotlin", Toast.LENGTH_SHORT).show();
                } else if (index == 4) {
                    Toast.makeText(MainActivity.this, "Swift", Toast.LENGTH_SHORT).show();
                } else if (index == 5) {
                    Toast.makeText(MainActivity.this, "Android", Toast.LENGTH_SHORT).show();
                }

            }
        }).normalImageRes(getImageResource());
    }

    static int getImageResource() {
        if (imageResourceIndex >= imageResources.length) imageResourceIndex = 0;
        return imageResources[imageResourceIndex++];
    }
}
