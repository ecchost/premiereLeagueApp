package com.example.premiereleagueapp.view.clubview;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.premiereleagueapp.models.Club;

import java.util.List;

public class ClubViewModel extends ViewModel {
    private MutableLiveData<List<Club>> clubMutable = new MutableLiveData<List<Club>>();
    private List<Club> club = null;

    public ClubViewModel(List<Club> club) {
        this.club = club;
    }

    public LiveData<List<Club>> getClub(){
        return clubMutable;
    }

    private MutableLiveData<Club> _navigateToDetail = new MutableLiveData<>();

    public LiveData<Club> navigateToDetail(){
        return _navigateToDetail;
    }

    public void onTeamClicked(Club club){
        _navigateToDetail.setValue(club);
    }

    public void onClubDetailNavigated(){
        _navigateToDetail.setValue(null);
    }

}
