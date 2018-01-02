package com.bysoftware.kodla.android.view.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.bysoftware.kodla.android.R;
import com.bysoftware.kodla.android.view.fragment.AndroidFragment;
import com.bysoftware.kodla.android.view.fragment.GithubFragment;
import com.bysoftware.kodla.android.view.fragment.JavaFragment;
import com.bysoftware.kodla.android.view.fragment.JsFragment;
import com.bysoftware.kodla.android.view.fragment.KotlinFragment;
import com.bysoftware.kodla.android.view.fragment.MainFragment;
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

        getFragment("main");

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
                int i = (int) (Math.random() * 4 + 1);
                if (index == 0) {
                    createDialog("github", i);
                    Toast.makeText(MainActivity.this, "GitHub", Toast.LENGTH_SHORT).show();
                } else if (index == 1) {
                    createDialog("java", i);
                    Toast.makeText(MainActivity.this, "Java", Toast.LENGTH_SHORT).show();
                } else if (index == 2) {
                    createDialog("js", i);
                    Toast.makeText(MainActivity.this, "JavaScript", Toast.LENGTH_SHORT).show();
                } else if (index == 3) {
                    createDialog("kotlin", i);
                    Toast.makeText(MainActivity.this, "Kotlin", Toast.LENGTH_SHORT).show();
                } else if (index == 4) {
                    createDialog("swift", i);
                    Toast.makeText(MainActivity.this, "Swift", Toast.LENGTH_SHORT).show();
                } else if (index == 5) {
                    createDialog("android", i);
                    Toast.makeText(MainActivity.this, "Android", Toast.LENGTH_SHORT).show();
                }
            }
        }).normalImageRes(getImageResource());
    }

    public void createDialog(final String lesson, int tip) {
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        String message = null;
        if (tip == 1) {
            if (lesson.equalsIgnoreCase("github")) {
                alertDialogBuilder.setMessage(R.string.github_tip_1);
                message = getString(R.string.github_tip_1);
            } else if (lesson.equalsIgnoreCase("java")) {
                alertDialogBuilder.setMessage(R.string.java_tip_1);
                message = getString(R.string.java_tip_1);
            } else if (lesson.equalsIgnoreCase("js")) {
                alertDialogBuilder.setMessage(R.string.js_tip_1);
                message = getString(R.string.js_tip_1);
            } else if (lesson.equalsIgnoreCase("kotlin")) {
                alertDialogBuilder.setMessage(R.string.kotlin_tip_1);
                message = getString(R.string.kotlin_tip_1);
            } else if (lesson.equalsIgnoreCase("swift")) {
                alertDialogBuilder.setMessage(R.string.swift_tip_1);
                message = getString(R.string.swift_tip_1);
            } else if (lesson.equalsIgnoreCase("android")) {
                alertDialogBuilder.setMessage(R.string.android_tip_1);
                message = getString(R.string.android_tip_1);
            }
        } else if (tip == 2) {
            if (lesson.equalsIgnoreCase("github")) {
                alertDialogBuilder.setMessage(R.string.github_tip_2);
                message = getString(R.string.github_tip_2);
            } else if (lesson.equalsIgnoreCase("java")) {
                alertDialogBuilder.setMessage(R.string.java_tip_2);
                message = getString(R.string.java_tip_2);
            } else if (lesson.equalsIgnoreCase("js")) {
                alertDialogBuilder.setMessage(R.string.js_tip_2);
                message = getString(R.string.js_tip_2);
            } else if (lesson.equalsIgnoreCase("kotlin")) {
                alertDialogBuilder.setMessage(R.string.kotlin_tip_2);
                message = getString(R.string.kotlin_tip_2);
            } else if (lesson.equalsIgnoreCase("swift")) {
                alertDialogBuilder.setMessage(R.string.swift_tip_2);
                message = getString(R.string.swift_tip_2);
            } else if (lesson.equalsIgnoreCase("android")) {
                alertDialogBuilder.setMessage(R.string.android_tip_2);
                message = getString(R.string.android_tip_2);
            }
        } else if (tip == 3) {
            if (lesson.equalsIgnoreCase("github")) {
                alertDialogBuilder.setMessage(R.string.github_tip_3);
                message = getString(R.string.github_tip_3);
            } else if (lesson.equalsIgnoreCase("java")) {
                alertDialogBuilder.setMessage(R.string.java_tip_3);
                message = getString(R.string.java_tip_3);
            } else if (lesson.equalsIgnoreCase("js")) {
                alertDialogBuilder.setMessage(R.string.js_tip_3);
                message = getString(R.string.js_tip_3);
            } else if (lesson.equalsIgnoreCase("kotlin")) {
                alertDialogBuilder.setMessage(R.string.kotlin_tip_3);
                message = getString(R.string.kotlin_tip_3);
            } else if (lesson.equalsIgnoreCase("swift")) {
                alertDialogBuilder.setMessage(R.string.swift_tip_3);
                message = getString(R.string.swift_tip_3);
            } else if (lesson.equalsIgnoreCase("android")) {
                alertDialogBuilder.setMessage(R.string.android_tip_3);
                message = getString(R.string.android_tip_3);
            }
        } else if (tip == 4) {
            if (lesson.equalsIgnoreCase("github")) {
                alertDialogBuilder.setMessage(R.string.github_tip_4);
                message = getString(R.string.github_tip_4);
            } else if (lesson.equalsIgnoreCase("java")) {
                alertDialogBuilder.setMessage(R.string.java_tip_4);
                message = getString(R.string.java_tip_4);
            } else if (lesson.equalsIgnoreCase("js")) {
                alertDialogBuilder.setMessage(R.string.js_tip_4);
                message = getString(R.string.js_tip_4);
            } else if (lesson.equalsIgnoreCase("kotlin")) {
                alertDialogBuilder.setMessage(R.string.kotlin_tip_4);
                message = getString(R.string.kotlin_tip_4);
            } else if (lesson.equalsIgnoreCase("swift")) {
                alertDialogBuilder.setMessage(R.string.swift_tip_4);
                message = getString(R.string.swift_tip_4);
            } else if (lesson.equalsIgnoreCase("android")) {
                alertDialogBuilder.setMessage(R.string.android_tip_4);
                message = getString(R.string.android_tip_4);
            }
        } else if (tip == 5) {
            if (lesson.equalsIgnoreCase("github")) {
                alertDialogBuilder.setMessage(R.string.github_tip_5);
                message = getString(R.string.github_tip_5);
            } else if (lesson.equalsIgnoreCase("java")) {
                alertDialogBuilder.setMessage(R.string.java_tip_5);
                message = getString(R.string.java_tip_5);
            } else if (lesson.equalsIgnoreCase("js")) {
                alertDialogBuilder.setMessage(R.string.js_tip_5);
                message = getString(R.string.js_tip_5);
            } else if (lesson.equalsIgnoreCase("kotlin")) {
                alertDialogBuilder.setMessage(R.string.kotlin_tip_5);
                message = getString(R.string.kotlin_tip_5);
            } else if (lesson.equalsIgnoreCase("swift")) {
                alertDialogBuilder.setMessage(R.string.swift_tip_5);
                message = getString(R.string.swift_tip_5);
            } else if (lesson.equalsIgnoreCase("android")) {
                alertDialogBuilder.setMessage(R.string.android_tip_5);
                message = getString(R.string.android_tip_5);
            }
        }
        alertDialogBuilder.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                    }
                });
        final String mes = message;

        alertDialogBuilder.setNegativeButton("SHARE",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                        sharingIntent.setType("text/plain");
                        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "New Information About Coding");
                        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, mes);
                        startActivity(Intent.createChooser(sharingIntent, "Share via"));

                    }
                });

        alertDialogBuilder.setNeutralButton("GET ALL TIPS",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (lesson.equalsIgnoreCase("github")) {
                            getFragment("github");
                        } else if (lesson.equalsIgnoreCase("java")) {
                            getFragment("java");
                        } else if (lesson.equalsIgnoreCase("js")) {
                            getFragment("js");
                        } else if (lesson.equalsIgnoreCase("kotlin")) {
                            getFragment("kotlin");
                        } else if (lesson.equalsIgnoreCase("swift")) {
                            getFragment("swift");
                        } else if (lesson.equalsIgnoreCase("android")) {
                            getFragment("android");
                        }
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    @Override
    public void onBackPressed() {
        getFragment("main");
    }

    static int getImageResource() {
        if (imageResourceIndex >= imageResources.length) imageResourceIndex = 0;
        return imageResources[imageResourceIndex++];
    }

    private void getFragment(String stringFragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        if (stringFragment.equalsIgnoreCase("github")) {
            GithubFragment fragment = new GithubFragment();
            transaction.replace(R.id.fragment_container, fragment);
        } else if (stringFragment.equalsIgnoreCase("java")) {
            JavaFragment fragment = new JavaFragment();
            transaction.replace(R.id.fragment_container, fragment);
        } else if (stringFragment.equalsIgnoreCase("js")) {
            JsFragment fragment = new JsFragment();
            transaction.replace(R.id.fragment_container, fragment);
        } else if (stringFragment.equalsIgnoreCase("kotlin")) {
            KotlinFragment fragment = new KotlinFragment();
            transaction.replace(R.id.fragment_container, fragment);
        } else if (stringFragment.equalsIgnoreCase("swift")) {
            SwiftFragment fragment = new SwiftFragment();
            transaction.replace(R.id.fragment_container, fragment);
        } else if (stringFragment.equalsIgnoreCase("android")) {
            AndroidFragment fragment = new AndroidFragment();
            transaction.replace(R.id.fragment_container, fragment);
        } else if (stringFragment.equalsIgnoreCase("main")) {
            MainFragment fragment = new MainFragment();
            transaction.replace(R.id.fragment_container, fragment);
        }
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
