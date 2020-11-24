package com.example.premiereleagueapp.view.clubview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.premiereleagueapp.R;
import com.example.premiereleagueapp.databinding.FragmentClubBinding;
import com.example.premiereleagueapp.models.Player;
import com.example.premiereleagueapp.models.Club;

import java.util.ArrayList;
import java.util.List;

public class ClubFragment extends Fragment {
    private FragmentClubBinding binding;
    private ClubViewModel viewModel;
    private List<Club> clubs;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_club, container, false);
        dataInsert();
        ClubViewModelFactory factory = new ClubViewModelFactory(clubs);
        viewModel = new ViewModelProvider(this, factory).get(ClubViewModel.class);
        binding.setViewmodel(viewModel);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupRecycleviewTeam();
    }

    public void setupRecycleviewTeam(){
        binding.rvTeam.setLayoutManager(new GridLayoutManager(getContext(), 2));
        ClubAdapter adapter = new ClubAdapter(clubs, new ClubOnClickHandler() {
            @Override
            public void onClick(Club club) {
                viewModel.onTeamClicked(club);
            }
        });
        binding.rvTeam.setAdapter(adapter);

        viewModel.getClub().observe(getViewLifecycleOwner(), new Observer<List<Club>>() {
            @Override
            public void onChanged(List<Club> clubs) {
                adapter.setClubList(clubs);
            }
        });

        viewModel.navigateToDetail().observe(getViewLifecycleOwner(), new Observer<Club>() {
            @Override
            public void onChanged(Club club) {
                if(club != null) {

                    //NavDirections action =  ClubFragmentDirections.actionClubFragmentToPlayerFragment(club);
                    //Navigation.findNavController(requireView()).navigate(action);
                    viewModel.onClubDetailNavigated();
                }
            }
        });
    }

    public void dataInsert(){
        clubs = new ArrayList<>();

        List<Player> arsenal = new ArrayList<>();
        arsenal.add(new Player("David Luis"));arsenal.add(new Player("Nicolas Pepe"));arsenal.add(new Player("Mesut Ozil"));arsenal.add(new Player("Pierre"));arsenal.add(new Player("Ainsley"));arsenal.add(new Player("Reiss Nelson"));
        arsenal.add(new Player("Hector Bellerin"));arsenal.add(new Player("Bernd Leno"));arsenal.add(new Player("Alexander Lacazette"));arsenal.add(new Player("Granit Xhaka"));arsenal.add(new Player("Willian"));
        clubs.add(new Club("Arsenal", arsenal,R.drawable.arsenal));

        List<Player> asvil = new ArrayList<>();
        asvil.add(new Player("Rahim Steerling"));asvil.add(new Player("Kevin De Bruyne"));asvil.add(new Player("Sergio Aguero"));asvil.add(new Player("Riyad Mahrez"));asvil.add(new Player("Kyle Walker"));asvil.add(new Player("Fernadinho"));
        asvil.add(new Player("John Stones"));asvil.add(new Player("Bernardo Silva"));asvil.add(new Player("Phil Foden"));asvil.add(new Player("Ederson"));asvil.add(new Player("Gabriel Jesus"));
        clubs.add(new Club("Manchester City", asvil, R.drawable.aston_villa));

        List<Player> burnley = new ArrayList<>();
        burnley.add(new Player("Nick Poppe"));burnley.add(new Player("Matthew Lowton"));burnley.add(new Player("Charlie Taylor"));burnley.add(new Player("James Takowrski"));burnley.add(new Player("Erik Pieters"));burnley.add(new Player("Ben Mee"));burnley.add(new Player("Kevin Long"));
        burnley.add(new Player("Josh Brownhill"));burnley.add(new Player("Jack Cork"));burnley.add(new Player("Robbie Brady"));burnley.add(new Player("Dwight McNeil"));
        clubs.add(new Club("BurnLey", burnley, R.drawable.burnley));

        List<Player> liver = new ArrayList<>();
        liver.add(new Player("Alisson"));liver.add(new Player("Adrian"));liver.add(new Player("Caomhin Kelleher"));liver.add(new Player("Vitextles Jaros"));
        liver.add(new Player("Virgil van djik"));liver.add(new Player("Joseph Gomez"));liver.add(new Player("Andrew Robertson"));liver.add(new Player("Joel Matip"));liver.add(new Player("Neco Williams"));liver.add(new Player("Andrew Robertson"));liver.add(new Player("Nataniel Philips"));
        clubs.add(new Club("Liverpool", liver, R.drawable.liverpool));

        List<Player> fulham = new ArrayList<>();
        fulham.add(new Player("Marek Rodak"));fulham.add(new Player("Fabri"));fulham.add(new Player("Alphonse Areola"));
        fulham.add(new Player("Michael hector"));fulham.add(new Player("Denis Odoi"));fulham.add(new Player("Tim Ream"));fulham.add(new Player("Maxime Le Marchand"));fulham.add(new Player("Joe Bryan"));fulham.add(new Player("Stefan Johanson"));fulham.add(new Player("Tom Cairney"));fulham.add(new Player("Josh Onomah"));
        clubs.add(new Club("Fulham", fulham, R.drawable.fulham));

    }
}