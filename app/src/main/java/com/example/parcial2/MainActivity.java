package com.example.parcial2;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CharacterAdapter.OnCharacterClickListener {
    private RecyclerView recyclerView;
    private CharacterAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Character> characters = new ArrayList<>();
        characters.add(new Character("Rick Sanchez", "Alive", "Human",
                "https://static.wikia.nocookie.net/rick-y-morty-espanol/images/4/4f/Rick_S%C3%A1nchez_Joven.jpg/revision/latest?cb=20231130231801&path-prefix=es", "Citadel of Ricks", "Male"));
        characters.add(new Character("Morty Smith", "Offline", "Human",
                "https://static.wikia.nocookie.net/rick-y-morty-espanol/images/9/9c/Morty_smith_2.webp/revision/latest?cb=20230228215449&path-prefix=es", "Citadel of Ricks", "Male"));
        characters.add(new Character("Summer Smith", "Alive", "Human",
                "https://static.wikia.nocookie.net/rick-y-morty-espanol/images/b/b4/Summer_Smith.webp/revision/latest?cb=20230307203354&path-prefix=es", "Earth", "Woman"));
        characters.add(new Character("Beth Sanchez", "Alive", "Human",
                "https://static.wikia.nocookie.net/rick-y-morty-espanol/images/c/c0/Beth_smith.jpg/revision/latest?cb=20230301203350&path-prefix=es", "Earth", "Woman"));
        characters.add(new Character("Jerry Smith", "Alive", "Human",
                "https://static.wikia.nocookie.net/rick-y-morty-espanol/images/4/43/Jerry_Smith1.png/revision/latest?cb=20230311072148&path-prefix=es", "Earth", "Male"));

        adapter = new CharacterAdapter(characters, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onCharacterClick(Character character) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("name", character.getName());
        intent.putExtra("status", character.getStatus());
        intent.putExtra("species", character.getSpecies());
        intent.putExtra("imageUrl", character.getImageUrl());
        intent.putExtra("location", character.getLocation());
        intent.putExtra("gender", character.getGender());
        startActivity(intent);
    }
}
