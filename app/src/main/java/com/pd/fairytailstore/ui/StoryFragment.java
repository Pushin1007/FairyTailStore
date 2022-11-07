package com.pd.fairytailstore.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.pd.fairytailstore.R;
import com.pd.fairytailstore.model.FairyTail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StoryFragment extends Fragment {


    public StoryFragment() {
    }


    public static StoryFragment newInstance(FairyTail faireTail) {
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

        FairyTail faireTail = requireArguments().getParcelable("ARG_STORY");
        nameStory.setText(faireTail.getNameStory());


        String fileName = faireTail.getNameFile();

        try {
            // открываем поток для чтения
            BufferedReader br = new BufferedReader(new InputStreamReader(getContext().getAssets().open(fileName)));
            StringBuilder text = new StringBuilder();
            String str = "";
            // читаем содержимое
            while ((str = br.readLine()) != null) {
                text.append(str);
                text.append('\n');
            }
            br.close();

            textStory.setText(text);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}