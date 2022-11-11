package com.pd.fairytailstore.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pd.fairytailstore.Navigation;
import com.pd.fairytailstore.R;
import com.pd.fairytailstore.model.FairyTail;
import com.pd.fairytailstore.model.StorySourceRemoteImpl;
import com.pd.fairytailstore.model.StorySourse;
import com.pd.fairytailstore.model.StorySourseLocalImpl;
import com.pd.fairytailstore.model.StorySourselResponce;

public class StoryListFragment extends Fragment implements MyClickListener {

    private StorySourse data;
    private StoryListAdapter adapter;
    private RecyclerView recyclerView;
    private Navigation navigation;
    private boolean[] chosenMulti = {false, false, false, false, false, false, false};

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        MainActivity activity = (MainActivity) context;
        navigation = activity.getNavigation();

    }

    @Override
    public void onDetach() {
        navigation = null;
        super.onDetach();
    }


    public static StoryListFragment newInstance() {
        return new StoryListFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true); //говорим что в этом фрагменте есть своя менюшка
        View view = inflater.inflate(R.layout.fragment_storylist, container, false);
        recyclerView = view.findViewById(R.id.recycler_view_lines);        //находим ресйклер
        // data = new StorySourseLocalImpl().init();// Получим источник данных для списка


        initRecyclerView(data, recyclerView);

//Выбор базы, из кода или из Firebase
        if (true) {
            data = new StorySourseLocalImpl().init(new StorySourselResponce() {
                @Override
                public void initialized(StorySourse storySourse) {
                }
            });
        } else {
            data = new StorySourceRemoteImpl().init(new StorySourselResponce() {
                @Override
                public void initialized(StorySourse storySourse) {
                    adapter.notifyDataSetChanged();
                }
            });
        }

        adapter.setDataSource(data);
        return view;
    }

    private void initRecyclerView(StorySourse data, RecyclerView recyclerView) {
        //задаем менеджер как будет распологатся элементы в рейсайклер
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());         // Будем работать со встроенным менеджером
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);        // все элементы будут одного размера,Эта установка служит для повышения производительности системы
        adapter = new StoryListAdapter(this);// Установим адаптер и передаем ему данные
        adapter.setOnMyClickListener(this);
        recyclerView.setAdapter(adapter);        //задаем ресайклеру наш адаптер
    }


    // Установим слушателя
    @Override
    public void onMyClick(View view, int position) {
        FairyTail faireTail = data.getFairyTail(position);

        Bundle bundle = new Bundle();
        bundle.putParcelable("ARG_STORY", faireTail);

        navigation.addFragment(StoryFragment.newInstance(faireTail), true);

    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.fragment_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search_text:
                Toast.makeText(getContext(), "Скоро здесь будет поиск по названию сказок", Toast.LENGTH_SHORT).show();
                /*
                // мягко скролим на нужную позицию списка
                recyclerView.smoothScrollToPosition(data.size() - 6);
                adapter.notifyItemChanged(data.size() - 6);
                 */

                return true;
            case R.id.review:
                //Почему читают сказки
                String[] variants = getResources().getStringArray(R.array.variants);
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Почему Вы пользуетесь приложением СКАЗКИ?")
                        .setMultiChoiceItems(variants, chosenMulti, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                                chosenMulti[i] = b;
                                Log.d("mylogs", "Choose " + variants[i]);
                            }
                        })
                        .setPositiveButton("Ответить", thanks);

                AlertDialog dialog = builder.create();
                dialog.show();

            case R.id.about_us:
                Toast.makeText(getContext(), "О нас", Toast.LENGTH_SHORT).show();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private DialogInterface.OnClickListener thanks = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setMessage("Спасибо за Ваш отзыв")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Log.d("mylogs", "Пользователь оставил отзыв" + i);
                        }
                    });
            AlertDialog dialog = builder.create();
            dialog.show();

        }
    };
}


