package com.smartfreeze.ui.fragments;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.DialogFragment;
import androidx.transition.ChangeBounds;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;

import com.smartfreeze.MainActivity;
import com.smartfreeze.R;

public class AyudaFragment extends DialogFragment {
    private ConstraintLayout constraintLayoutConnectedInsideIncludeTag;
    private ConstraintLayout v, v2;

    public AyudaFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View popupView = inflater.inflate(R.layout.pop_up_window_ajustes, container, false);

        v = (ConstraintLayout) popupView.findViewById(R.id.elem_1);
        v2 = (ConstraintLayout) popupView.findViewById(R.id.elem_2);

        return popupView;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto", "abc@gmail.com", null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Duda sobre la aplicación:");
                v.getContext().startActivity(Intent.createChooser(emailIntent, null));
            }
        });

        v2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:0123456789"));
                startActivity(intent);
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        MainActivity.bottomNavigationView.setVisibility(View.VISIBLE);
    }

}

