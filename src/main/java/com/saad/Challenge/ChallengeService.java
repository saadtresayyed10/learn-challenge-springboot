package com.saad.Challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChallengeService {
//    private List<Challenge> challenges = new ArrayList<>();
    private Long nextId = 1L;

    @Autowired
    ChallengeRepository challengeRepository;

    public ChallengeService() {

    }

    public List<Challenge> getAllChallenges() {
        return challengeRepository.findAll();
    }

    public boolean addChallenges(Challenge challenge) {
        if(challenge != null) {
            challenge.setId(nextId++);
            challengeRepository.save(challenge);
            return true;
        } else  {
            return false;
        }
    }

    public Challenge getAChallenge(String month) {
        Optional<Challenge> challenge = challengeRepository.findByMonthIgnoreCase(month);
        return challenge.orElse(null);
    }

    public boolean updateChallenge(Long id, Challenge updatedChallenge) {
        Optional<Challenge> challenge = challengeRepository.findById(id);
        if(challenge.isPresent()) {
            Challenge updateToChallenge = challenge.get();
            updateToChallenge.setMonth(updatedChallenge.getMonth());
            updateToChallenge.setDescription(updateToChallenge.getDescription());
            challengeRepository.save(updateToChallenge);
            return true;
        }

        return false;
    }

    public boolean deletedChallenge(Long id) {
        Optional<Challenge> challenge = challengeRepository.findById(id);
        if(challenge.isPresent()) {
            challengeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
