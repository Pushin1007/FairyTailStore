package com.pd.fairytailstore.model;


//интерфейс данных
public interface StorySourse {

    StorySourse init(StorySourselResponce storySourselResponce);

    int size();
    FairyTail getFairyTail(int position);
    void clearAll();

}
