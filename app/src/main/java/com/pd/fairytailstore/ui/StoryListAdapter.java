package com.pd.fairytailstore.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.pd.fairytailstore.R;
import com.pd.fairytailstore.model.StorySourse;


//Класс который обслуживает RecyclerView
public class StoryListAdapter extends RecyclerView.Adapter<StoryListAdapter.MyViewHolder> {

    private StorySourse dataSource;
    private Fragment fragment;

    // Передаем в конструктор источник данных
    // В нашем случае это массив, но может быть и запросом к БД
   /* public StoryListAdapter(StorySourse dataSource) {
        this.dataSource = dataSource;
    }

    */
    public StoryListAdapter(Fragment fragment) {
        this.fragment = fragment;
    }

    public void setDataSource(StorySourse dataSource) {
        this.dataSource = dataSource;
        notifyDataSetChanged();
    }

    private MyClickListener listener; // Слушатель будет устанавливаться извне

    // Сеттер слушателя нажатий
    public void setOnMyClickListener(MyClickListener listener) {
        this.listener = listener;
    }

    // Создать новый элемент пользовательского интерфейса
    // Запускается менеджером
    // запускается  и переиспользуется только на элементы которые помещаются на экран
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Создаем новый элемент пользовательского интерфейса
        // Через Inflater

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new MyViewHolder(view);
    }


    // Заменить данные в пользовательском интерфейсе(здесь созданные вьюхи набиваются данными)
    // Вызывается менеджером
    // запускается на все элементы (если список из 1000 то и запускается 1000 раз)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // Получить элемент из источника данных (БД, интернет...)
        // Вынести на экран используя ViewHolder
        holder.nameStory.setText(dataSource.getFairyTail(position).getNameStory());
        holder.author.setText(dataSource.getFairyTail(position).getAuthor());
        holder.timeToRead.setText(dataSource.getFairyTail(position).getTimeToRead());

    }

    // Вернуть размер данных, вызывается менеджером
    @Override
    public int getItemCount() {
        return dataSource.size();
    }


    // Этот класс хранит связь между данными и элементами View
    // Сложные данные могут потребовать несколько View на
    // один пункт списка
    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView nameStory;
        private TextView author;
        private TextView timeToRead;
        private View card;


        public MyViewHolder(View itemView) {
            super(itemView);

            nameStory = (TextView) itemView.findViewById(R.id.nameStory);
            author = (TextView) itemView.findViewById(R.id.autor);
            timeToRead = (TextView) itemView.findViewById(R.id.time_to_read);
            card = (View) itemView.findViewById(R.id.title_descr);

            card.setOnClickListener(new View.OnClickListener() { // обработчик нажатий, можно поместить и в onCreateViewHolder
                @Override
                public void onClick(View view) {
                    listener.onMyClick(view, getAdapterPosition());
                }
            });
        }
    }


}
