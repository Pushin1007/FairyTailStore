package com.pd.fairytailstore.model;

import android.os.Parcel;
import android.os.Parcelable;

public class FairyTail implements Parcelable {

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private  String id;
    private String nameStory;
    private String author;
    private String timeToRead;
    private String nameFile;

    public FairyTail(String nameStory, String author, String timeToRead, String nameFile) {

        this.nameStory = nameStory;
        this.author = author;
        this.timeToRead = timeToRead;
        this.nameFile = nameFile;
    }

    protected FairyTail(Parcel in) {
        nameStory = in.readString();
        author = in.readString();
        timeToRead = in.readString();
        nameFile = in.readString();
    }

    public static final Creator<FairyTail> CREATOR = new Creator<FairyTail>() {
        @Override
        public FairyTail createFromParcel(Parcel in) {
            return new FairyTail(in);
        }

        @Override
        public FairyTail[] newArray(int size) {
            return new FairyTail[size];
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
