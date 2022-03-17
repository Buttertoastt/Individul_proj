package com.company;
import java.lang.String;
import java.util.*;


public class quizQuestion {
    private String prompt;
    private ArrayList<String> options;
    private String answer;

    public quizQuestion(String prompt, String[] options, String answer) {
        this.prompt = prompt;
        this.options = new ArrayList<String>();
        this.answer = answer;
        for (int i = 0; i < options.length; i++){
            this.options.add(options[i]);
        }
        //Shuffling questions
        Collections.shuffle(this.options);
        this.answer = answer;
    }
    public String getQuizQuestion(){
        return prompt;
    }
    public ArrayList<String> getOptions(){
        return options;
    }
    public String getAnswer(){
        return answer;
    }
}
