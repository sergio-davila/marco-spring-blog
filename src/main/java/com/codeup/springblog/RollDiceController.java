package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;


@Controller
public class RollDiceController {
    Random rand = new Random();

    int diceRoll = rand.nextInt(6);

    @GetMapping("/roll-dice")
    public String guess(
            Model model
    ) {
        int diceRoll = rand.nextInt(6) + 1;
        model.addAttribute("diceRoll", diceRoll);
        return "rollDice";
    }

    @GetMapping("/roll-dice/{n}")
    public String results(
            @PathVariable int n,
            Model model
    ) {
        int diceRoll = rand.nextInt(6) + 1;
        model.addAttribute("diceRoll", diceRoll);
        model.addAttribute("num", n);

        return "rollDice";
    }



}
