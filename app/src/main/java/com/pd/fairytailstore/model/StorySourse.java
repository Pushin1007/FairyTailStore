package com.pd.fairytailstore.model;


//интерфейс данных
public interface StorySourse {

    int size();

    FaireTail getFairyTail(int position);

    void clearAll();

}
