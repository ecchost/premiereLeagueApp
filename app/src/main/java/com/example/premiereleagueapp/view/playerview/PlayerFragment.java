package com.example.premiereleagueapp.view.playerview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.premiereleagueapp.R;
import com.example.premiereleagueapp.databinding.FragmentPlayerBinding;
import com.example.premiereleagueapp.models.Club;

public class PlayerFragment extends Fragment {
    private FragmentPlayerBinding binding;
    private Club club;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_player, container, false);
        // Inflate the layout for this fragment
        assert getArguments() != null;

        //club = PlayerFragmentArgs.fromBundle(getArguments()).getTeam();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.setTeam(club);
        setupRecycleviewPlayer();
    }
    
    public void setupRecycleviewPlayer(){
        binding.rvPlayer.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvPlayer.setAdapter(new PlayerAdapter(club.getPlayerList()));
    }
}