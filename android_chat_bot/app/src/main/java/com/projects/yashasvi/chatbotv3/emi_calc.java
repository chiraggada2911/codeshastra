package com.projects.yashasvi.chatbotv3;

public class emi_calc {

    static float emi_calculator(float p, float r, float t) {
        float emi;

        r = r / (12 * 100); // one month interest
        t = t ; // one month period
        emi = (p * r * (float) Math.pow(1 + r, t))
                / (float) (Math.pow(1 + r, t) - 1);

        return (emi);
    }
}

