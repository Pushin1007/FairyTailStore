package com.pd.fairytailstore.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pd.fairytailstore.R;
import com.pd.fairytailstore.model.FaireTail;
import com.pd.fairytailstore.model.StorySourse;
import com.pd.fairytailstore.model.StorySourseImpl;

public class SocialNetworkFragment extends Fragment implements MyClickListener {

    private StorySourse data = new StorySourseImpl().init();// Получим источник данных для списка
    private SocialNetworkAdapter adapter;
    private RecyclerView recyclerView;
    private FragmentManager fragmentManager;

    public static SocialNetworkFragment newInstance() {
        return new SocialNetworkFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //setHasOptionsMenu(true); //говорим что в этом фрагменте есть свое меню
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_socialnetwork, container, false);

        //data = new StorySourseImpl().init();// Получим источник данных для списка

        recyclerView = view.findViewById(R.id.recycler_view_lines);        //находим ресйклер

        initRecyclerView(data, recyclerView);

        //мастырим разделитель         // Добавим разделитель карточек
//        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL);
//        dividerItemDecoration.setDrawable(getResources().getDrawable(R.drawable.separator));
//        recyclerView.addItemDecoration(dividerItemDecoration);
        return view;
    }

    private void initRecyclerView(StorySourse data, RecyclerView recyclerView) {
        //задаем менеджер как будет распологатся элементы в рейсайклер
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());         // Будем работать со встроенным менеджером
        recyclerView.setLayoutManager(layoutManager);


        recyclerView.setHasFixedSize(true);        // все элементы будут одного размера,Эта установка служит для повышения производительности системы

        adapter = new SocialNetworkAdapter(data);// Установим адаптер и передаем ему данные

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


//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.add_button:
//                data.addCardData(new CardData("new", R.drawable.nature1, "new Description", false));
//                adapter.notifyItemInserted(data.size() - 1);
//                recyclerView.smoothScrollToPosition(data.size() - 1);
//                return true;
//            case R.id.clear_button:
//                data.clearAll();
//                adapter.notifyDataSetChanged();//обновляем все данные
//                return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
}
