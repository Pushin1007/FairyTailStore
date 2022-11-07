package com.pd.fairytailstore.model;

import androidx.annotation.NonNull;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;

import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class StorySourceRemoteImpl implements StorySourse {

    private static String STORY_COLLECTION = "stories";
    private FirebaseFirestore store = FirebaseFirestore.getInstance();
    private CollectionReference collectionReference = store.collection(STORY_COLLECTION);
    private List<FairyTail> dataSourse = new ArrayList<FairyTail>();


    @Override
    public StorySourse init(StorySourselResponce storySourselResponce) {
        collectionReference.orderBy(FairyTailTranslate.Fields.NAME_STORY, Query.Direction.DESCENDING).get()
                //делаем запрос в удеаленную базу, сортируем по имени сказки в порядке убывания
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        //заполняем новыми данными наш список данными которые пришли с сервера в метод onComplete они будут сидеть в task
                        if (task.isSuccessful()) {
                            dataSourse = new ArrayList<FairyTail>(); //обнуляем данные
                            for (QueryDocumentSnapshot docFields : task.getResult()) {
                                FairyTail fairyTail = FairyTailTranslate.documentToFairyTail(docFields.getId(),
                                        docFields.getData());
                                dataSourse.add(fairyTail);
                            }
                            storySourselResponce.initialized(StorySourceRemoteImpl.this);
                        }
                    }
                });
        return this;

    }

    @Override
    public int size() {
        return dataSourse.size();
    }

    @Override
    public FairyTail getFairyTail(int position) {
        return dataSourse.get(position);
    }

    @Override
    public void clearAll() {
        dataSourse.clear();
    }
}



