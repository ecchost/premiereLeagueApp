package com.example.premiereleagueapp.view.clubview;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.premiereleagueapp.models.Club;

import java.util.List;

public class ClubViewModelFactory implements ViewModelProvider.Factory {
    private List<Club> club;

    public ClubViewModelFactory(List<Club> club) {
        this.club = club;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(ClubViewModel.class)){
            return (T) new ClubViewModel(club);
        }
        throw new IllegalArgumentException("TeamViewModel Required");
    }
}
