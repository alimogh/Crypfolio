package com.shuayb.capstone.android.crypfolio.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.shuayb.capstone.android.crypfolio.R;

public class PortfolioFragment extends Fragment {
    private static final String TAG = "PortfolioFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.portfolio_fragment, container, false);

        return view;
    }
}