package com.example.premiereleagueapp.view.clubview;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.premiereleagueapp.databinding.ItemClubBinding;
import com.example.premiereleagueapp.models.Club;

import java.util.List;

public class ClubAdapter extends RecyclerView.Adapter<com.example.premiereleagueapp.view.clubview.ClubAdapter.ClubViewHolder> {
    private List<Club> clubs;
    private com.example.premiereleagueapp.view.clubview.ClubOnClickHandler handler;

    public ClubAdapter(List<Club> clubs, com.example.premiereleagueapp.view.clubview.ClubOnClickHandler handler) {
        this.clubs = clubs;
        this.handler = handler;
    }

    public ClubAdapter(com.example.premiereleagueapp.view.clubview.ClubOnClickHandler handler){
        this.handler=handler;
    }
    public void setClubList(List<Club> clubs){
        this.clubs = clubs;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ClubViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemClubBinding binding = ItemClubBinding.inflate(inflater, parent, false);
        return new ClubViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ClubViewHolder holder, int position) {
        Club club = clubs.get(position);
        holder.bind(club);
    }

    @Override
    public int getItemCount() {
        return clubs != null? clubs.size() : 0;
    }

    public class ClubViewHolder extends RecyclerView.ViewHolder {
        private ItemClubBinding binding;

        public ClubViewHolder(ItemClubBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public void bind(Club club){
            binding.imgTeam.setImageResource(club.getImageId());
            binding.setTeam(club);
            binding.setClickListener(handler);
            binding.executePendingBindings();
        }
    }
}
