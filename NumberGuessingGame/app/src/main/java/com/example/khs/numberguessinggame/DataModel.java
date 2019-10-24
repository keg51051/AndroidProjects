package com.example.khs.numberguessinggame;

import java.util.Random;

public class DataModel {
    private int num1, num2, answer;

    Random random = new Random();

    public DataModel(int num1, int num2, int answer) {
        this.num1 = random.nextInt(10);
        this.num2 = random.nextInt(10);
        this.answer = Math.max(this.num1, this.num2);
    }

    public DataModel() {
        this.num1 = random.nextInt(10);
        while(true) {
            this.num2 = random.nextInt(10);
            if(num1!=num2) break;
        }
        this.num2 = random.nextInt(10);
        this.answer = Math.max(this.num1, this.num2);
    }

    public void setNum1() {
        this.num1 = random.nextInt(10);
    }

    public void setNum2() {
        this.num2 = random.nextInt(10);
    }

    public void setAnswer() {
        this.answer = Math.max(this.num1, this.num2);
    }

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }

    public int getAnswer() {
        return answer;
    }
}
