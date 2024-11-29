package org.example.bowling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BowlingGameController {

    @Autowired
    private BowlingGame bowlingGame;

    @GetMapping("/")
    public String redirectToBowling() {
        return "redirect:/bowling";
    }

    @GetMapping("/bowling")
    public String showBowlingPage() {
        return "bowling";
    }

    @PostMapping("/submit-score")
    public String submitScore(BowlingScore bowlingScore, RedirectAttributes redirectAttributes) {
        try {
            int totalScore = bowlingGame.scoreBowling(bowlingScore.finalScore());
            redirectAttributes.addFlashAttribute("score", totalScore);
            return "redirect:/display-score";
        } catch (IllegalBowlingArgumentException e) {
            redirectAttributes.addFlashAttribute("errorMessages", e.getErrorMessages());
            return "redirect:/bowling";  // Redirect back to the bowling page
        }
    }

    @GetMapping("/display-score")
    public String displayScore(Model model) {
        return "display-score";  // This will correspond to a "display-score.html" view
    }
}

