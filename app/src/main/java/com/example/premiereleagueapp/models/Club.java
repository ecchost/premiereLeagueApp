package com.example.premiereleagueapp.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Club implements Parcelable {
    private String name;
    private List<Player> playerList;
    private int imageId;

    public Club(String name, List<Player> playerList, int imgId) {
        this.name = name;
        this.playerList = playerList;
        this.imageId = imgId;
    }

    protected Club(Parcel in) {
        name = in.readString();
        playerList = in.createTypedArrayList(Player.CREATOR);
        imageId = in.readInt();
    }

    public static final Creator<Club> CREATOR = new Creator<Club>() {
        @Override
        public Club createFromParcel(Parcel in) {
            return new Club(in);
        }

        @Override
        public Club[] newArray(int size) {
            return new Club[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imgId) {
        this.imageId = imageId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeTypedList(playerList);
        dest.writeInt(imageId);
    }
}
