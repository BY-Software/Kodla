package com.bysoftware.kodla.android.view.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.bysoftware.kodla.android.R;
import com.bysoftware.kodla.android.view.fragment.AndroidFragment;
import com.bysoftware.kodla.android.view.fragment.GithubFragment;
import com.bysoftware.kodla.android.view.fragment.JavaFragment;
import com.bysoftware.kodla.android.view.fragment.JsFragment;
import com.bysoftware.kodla.android.view.fragment.KotlinFragment;
import com.bysoftware.kodla.android.view.fragment.SwiftFragment;
import com.nightonke.boommenu.BoomButtons.ButtonPlaceEnum;
import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomButtons.SimpleCircleButton;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.ButtonEnum;
import com.nightonke.boommenu.Piece.PiecePlaceEnum;

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

        getFragment("github");

        assert bmb != null;
        bmb.setButtonEnum(ButtonEnum.SimpleCircle);
        bmb.setPiecePlaceEnum(PiecePlaceEnum.DOT_6_4);
        bmb.setButtonPlaceEnum(ButtonPlaceEnum.SC_6_4);
        bmb.addBuilder(getSimpleCircleButtonBuilder());
        bmb.clearBuilders();
        for (int i = 0; i < bmb.getPiecePlaceEnum().pieceNumber(); i++) {
            bmb.addBuilder(getSimpleCircleButtonBuilder()
                    .normalColor(Color.WHITE)
            );
        }
    }

    SimpleCircleButton.Builder getSimpleCircleButtonBuilder() {
        return new SimpleCircleButton.Builder().listener(new OnBMClickListener() {
            @Override
            public void onBoomButtonClick(int index) {
                if (index == 0) {
                    getFragment("github");
                } else if (index == 1) {
                    getFragment("java");
                } else if (index == 2) {
                    getFragment("js");
                } else if (index == 3) {
                    getFragment("kotlin");
                } else if (index == 4) {
                    getFragment("swift");
                } else if (index == 5) {
                    getFragment("android");
                }
            }
        }).normalImageRes(getImageResource());
    }

    @Override
    public void onBackPressed() {
        getFragment("github");
    }

    static int getImageResource() {
        if (imageResourceIndex >= imageResources.length) imageResourceIndex = 0;
        return imageResources[imageResourceIndex++];
    }

    private void getFragment(String stringFragment){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        if(stringFragment.equalsIgnoreCase("github")){
            GithubFragment fragment = new GithubFragment();
            transaction.replace(R.id.fragment_container, fragment);
        }else if(stringFragment.equalsIgnoreCase("java")){
            JavaFragment fragment = new JavaFragment();
            transaction.replace(R.id.fragment_container, fragment);
        }else if(stringFragment.equalsIgnoreCase("js")){
            JsFragment fragment = new JsFragment();
            transaction.replace(R.id.fragment_container, fragment);
        }else if(stringFragment.equalsIgnoreCase("kotlin")){
            KotlinFragment fragment = new KotlinFragment();
            transaction.replace(R.id.fragment_container, fragment);
        }else if(stringFragment.equalsIgnoreCase("swift")){
            SwiftFragment fragment = new SwiftFragment();
            transaction.replace(R.id.fragment_container, fragment);
        }else if(stringFragment.equalsIgnoreCase("android")){
            AndroidFragment fragment = new AndroidFragment();
            transaction.replace(R.id.fragment_container, fragment);
        }
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
