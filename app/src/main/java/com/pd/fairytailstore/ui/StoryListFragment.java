package com.pd.fairytailstore.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pd.fairytailstore.R;
import com.pd.fairytailstore.model.FaireTail;
import com.pd.fairytailstore.model.StorySourse;
import com.pd.fairytailstore.model.StorySourseImpl;

public class StoryListFragment extends Fragment implements MyClickListener {

    private final StorySourse data = new StorySourseImpl().init();// Получим источник данных для списка
    private StoryListAdapter adapter;
    private RecyclerView recyclerView;


    public static StoryListFragment newInstance() {
        return new StoryListFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_storylist, container, false);
        recyclerView = view.findViewById(R.id.recycler_view_lines);        //находим ресйклер
        initRecyclerView(data, recyclerView);
        return view;
    }

    private void initRecyclerView(StorySourse data, RecyclerView recyclerView) {
        //задаем менеджер как будет распологатся элементы в рейсайклер
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());         // Будем работать со встроенным менеджером
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);        // все элементы будут одного размера,Эта установка служит для повышения производительности системы
        adapter = new StoryListAdapter(data);// Установим адаптер и передаем ему данные
        adapter.setOnMyClickListener(this);
        recyclerView.setAdapter(adapter);        //задаем ресайклеру наш адаптер
    }


    // Установим слушателя
    @Override
    public void onMyClick(View view, int position) {
        FaireTail faireTail = data.getFairyTail(position);

        Bundle bundle = new Bundle();
        bundle.putParcelable("ARG_STORY", faireTail);
        // Toast.makeText(getContext(), "work" + position, Toast.LENGTH_SHORT).show();
        StoryFragment fragment = StoryFragment.newInstance(faireTail); // Фрагмент, которым собираетесь заменить первый фрагмент
        FragmentTransaction transaction = getFragmentManager().beginTransaction(); // Или getSupportFragmentManager(), если используете support.v4
        transaction.replace(R.id.fragment_container, fragment); // Заменяете вторым фрагментом. Т.е. вместо метода `add()`, используете метод `replace()`
        transaction.addToBackStack(null); // Добавляете в backstack, чтобы можно было вернутся обратно

        transaction.commit(); // Коммитете
    }


}
