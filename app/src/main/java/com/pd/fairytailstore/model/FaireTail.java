package com.pd.fairytailstore.model;

import android.os.Parcel;
import android.os.Parcelable;

public class FaireTail implements Parcelable {
    private String nameStory;
    private String author;
    private String timeToRead;
    private String nameFile;

    public FaireTail(String title, String author, String timeToRead, String nameFile) {
        this.nameStory = title;
        this.author = author;
        this.timeToRead = timeToRead;
        this.nameFile = nameFile;
    }

    protected FaireTail(Parcel in) {
        nameStory = in.readString();
        author = in.readString();
        timeToRead = in.readString();
        nameFile = in.readString();
    }

    public static final Creator<FaireTail> CREATOR = new Creator<FaireTail>() {
        @Override
        public FaireTail createFromParcel(Parcel in) {
            return new FaireTail(in);
        }

        @Override
        public FaireTail[] newArray(int size) {
            return new FaireTail[size];
        }
    };

    public String getNameStory() {
        return nameStory;
    }

    public String getAuthor() {
        return author;
    }

    public String getTimeToRead() {
        return timeToRead;
    }

    public String getNameFile() {
        return nameFile;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nameStory);
        parcel.writeString(author);
        parcel.writeString(timeToRead);
        parcel.writeString(nameFile);
    }
}
