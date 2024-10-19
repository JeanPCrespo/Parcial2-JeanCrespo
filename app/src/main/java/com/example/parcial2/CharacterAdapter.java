package com.example.parcial2;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder> {
    private List<Character> characters;
    private OnCharacterClickListener listener;

    public interface OnCharacterClickListener {
        void onCharacterClick(Character character);
    }

    public CharacterAdapter(List<Character> characters, OnCharacterClickListener listener) {
        this.characters = characters;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_character, parent, false);
        return new CharacterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        Character character = characters.get(position);
        holder.bind(character);
    }

    @Override
    public int getItemCount() {
        return characters.size();
    }

    class CharacterViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivCharacterDetail;
        private TextView tvNameDetail, tvStatusDetail, tvSpeciesDetail, tvLocationDetail, tvGenderDetail;
        private Button btnSeeMore;
        private Character character;

        CharacterViewHolder(View itemView) {
            super(itemView);
            ivCharacterDetail = itemView.findViewById(R.id.ivCharacterDetail);
            tvNameDetail = itemView.findViewById(R.id.tvNameDetail);
            tvStatusDetail = itemView.findViewById(R.id.tvStatusDetail);
            tvSpeciesDetail = itemView.findViewById(R.id.tvSpeciesDetail);
            tvLocationDetail = itemView.findViewById(R.id.tvLocationDetail);
            tvGenderDetail = itemView.findViewById(R.id.tvGenderDetail);
            btnSeeMore = itemView.findViewById(R.id.btnSeeMore);

            btnSeeMore.setOnClickListener(v -> {
                Intent intent = new Intent(itemView.getContext(), DetailActivity.class);
                intent.putExtra("name", character.getName());
                intent.putExtra("status", character.getStatus());
                intent.putExtra("species", character.getSpecies());
                intent.putExtra("imageUrl", character.getImageUrl());
                intent.putExtra("location", character.getLocation());
                intent.putExtra("gender", character.getGender());
                itemView.getContext().startActivity(intent);
            });
        }

        void bind(Character character) {
            this.character = character;
            tvNameDetail.setText(character.getName());
            tvStatusDetail.setText(character.getStatus());
            tvSpeciesDetail.setText(character.getSpecies());
            tvLocationDetail.setText(character.getLocation());
            tvGenderDetail.setText(character.getGender());
            Picasso.get()
                    .load(character.getImageUrl())
                    .placeholder(R.drawable.placeholder)
                    .error(R.drawable.error)
                    .into(ivCharacterDetail);
        }
    }
}
