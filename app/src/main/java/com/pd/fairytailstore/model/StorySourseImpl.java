package com.pd.fairytailstore.model;

import android.content.res.Resources;

import java.util.ArrayList;
import java.util.List;

public class StorySourseImpl implements StorySourse {
    private List<FaireTail> dataSourse;


    @Override
    public int size() {
        return dataSourse.size();
    }

    @Override
    public FaireTail getFairyTail(int position) {
        return dataSourse.get(position);
    }


    @Override
    public void clearAll() {
        dataSourse.clear();
    }

    public StorySourseImpl() {
        dataSourse = new ArrayList<FaireTail>();
    }

    public StorySourseImpl init() {
        dataSourse.add(new FaireTail("Свинопас", "Ханс христиан Андерсон", "10:10", "svinopas.txt"));
        dataSourse.add(new FaireTail("Свинопас", "Ханс христиан Андерсон", "10:10", "svinopas.txt"));
        dataSourse.add(new FaireTail("Свинопас", "Ханс христиан Андерсон", "10:10", "svinopas.txt"));
        return this;
    }


}
