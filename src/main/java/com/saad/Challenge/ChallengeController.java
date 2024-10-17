package com.saad.Challenge;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/challenges")
public class ChallengeController {
    private ChallengeService challengeService;

    public ChallengeController(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    @GetMapping
    public ResponseEntity<List<Challenge>> getAllChallenges() {
        return new ResponseEntity<>(challengeService.getAllChallenges(), HttpStatus.OK);
    }

    @GetMapping("/{month}")
    public ResponseEntity<Challenge> getChallenge(@PathVariable String month) {
        Challenge challenge = challengeService.getAChallenge(month);
        if(challenge != null)
            return new ResponseEntity<>(challenge, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<String> addChallenges(@RequestBody Challenge challenge) {
        boolean isChallengeAdded = challengeService.addChallenges(challenge);
        if(isChallengeAdded)
            return new ResponseEntity<>("Challenge added successfully", HttpStatus.CREATED);
        else
            return new ResponseEntity<>("Challenge did not added successfully", HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateChallenge(@PathVariable Long id, @RequestBody Challenge updatedChallenge) {
        boolean isUpdatedChallenge = challengeService.updateChallenge(id, updatedChallenge);
        if(isUpdatedChallenge)
            return new ResponseEntity<>("Challenge updated successfully", HttpStatus.OK);
        else
            return new ResponseEntity<>("Challenge did not updated successfully", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteChallenge(@PathVariable Long id) {
        boolean isChallengeDeleted = challengeService.deletedChallenge(id);
        if(isChallengeDeleted)
            return new ResponseEntity<>("Challenge deleted successfully", HttpStatus.OK);
        else
            return new ResponseEntity<>("Challenge did not deleted successfully", HttpStatus.NOT_FOUND);
    }

}
