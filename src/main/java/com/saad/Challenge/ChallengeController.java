package com.saad.Challenge;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ChallengeController {
    private List<Challenge> challenges = new ArrayList<>();

    public ChallengeController() {
        Challenge challenge1 = new Challenge(1L, "July", "Learn springboot");
        challenges.add(challenge1);
    }

    @GetMapping("/challenges")
    public List<Challenge> getAllChallenges() {
        return challenges;
    }

    @PostMapping("/challenges")
    public String addChallenges(@RequestBody Challenge challenge) {
        challenges.add(challenge);
        return "Challenge added successfully";
    }
}
