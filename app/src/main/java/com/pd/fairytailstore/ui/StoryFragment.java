package com.pd.fairytailstore.ui;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.pd.fairytailstore.R;
import com.pd.fairytailstore.model.FaireTail;

import java.io.FileInputStream;

public class StoryFragment extends Fragment {


    public StoryFragment() {

    }


    public static StoryFragment newInstance(FaireTail faireTail) {
        StoryFragment fragment = new StoryFragment();
        Bundle args = new Bundle();
        args.putParcelable("ARG_STORY", faireTail);
        fragment.setArguments(args);
        return fragment;
    }

    public static StoryFragment newInstance() {
        return new StoryFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_story, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView nameStory = view.findViewById(R.id.story);
        TextView textStory = view.findViewById(R.id.srory_text);

        FaireTail faireTail = requireArguments().getParcelable("ARG_STORY");
        nameStory.setText(faireTail.getNameStory());
        //textStory.setText(faireTail.getNameFile());

        String fileName = faireTail.getNameFile();


    }
}