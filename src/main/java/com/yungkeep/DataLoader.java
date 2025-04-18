package com.yungkeep;

import com.yungkeep.model.Note;
import com.yungkeep.model.User;
import com.yungkeep.repository.NoteRepository;
import com.yungkeep.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        // Charger des données de test
        loadTestData();
    }

    private void loadTestData() {
        // Créer un utilisateur de test
        User testUser = new User();
        testUser.setUsername("demo");
        testUser.setEmail("demo@example.com");
        testUser.setPassword(passwordEncoder.encode("password"));
        userRepository.save(testUser);

        // Créer quelques notes de démonstration
        Note note1 = new Note();
        note1.setTitle("Bienvenue sur yungkeep");
        note1.setContent("C'est une application similaire à Google Keep pour prendre des notes. Vous pouvez ajouter, éditer et organiser vos notes facilement.");
        note1.setColor("#ffe8b6");
        note1.setTags(new HashSet<>(Arrays.asList("bienvenue", "démo")));
        note1.setArchived(false);
        note1.setDeleted(false);
        note1.setUser(testUser);
        note1.setCreatedAt(LocalDateTime.now());
        note1.setUpdatedAt(LocalDateTime.now());
        noteRepository.save(note1);

        Note note2 = new Note();
        note2.setTitle("Liste de courses");
        note2.setContent("- Pain\n- Lait\n- Œufs\n- Fromage\n- Fruits\n- Légumes");
        note2.setColor("#b4f0b4");
        note2.setTags(new HashSet<>(Arrays.asList("courses", "alimentation")));
        note2.setArchived(false);
        note2.setDeleted(false);
        note2.setUser(testUser);
        note2.setCreatedAt(LocalDateTime.now().minusDays(1));
        note2.setUpdatedAt(LocalDateTime.now().minusDays(1));
        noteRepository.save(note2);

        Note note3 = new Note();
        note3.setTitle("Idées de projet");
        note3.setContent("1. Application de notes (en cours)\n2. Gestionnaire de tâches\n3. Blog personnel\n4. Portfolio en ligne");
        note3.setColor("#d7b6ff");
        note3.setTags(new HashSet<>(Arrays.asList("projets", "idées")));
        note3.setArchived(true);
        note3.setDeleted(false);
        note3.setUser(testUser);
        note3.setCreatedAt(LocalDateTime.now().minusDays(3));
        note3.setUpdatedAt(LocalDateTime.now().minusDays(2));
        noteRepository.save(note3);
    }
}
