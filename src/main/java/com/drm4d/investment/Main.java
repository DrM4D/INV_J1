package com.drm4d.investment;

import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) {
        String version = "1.3a";
        String systemVersion = "J1AA5F21OC17";
        SystemC s = new SystemC();
        s.intro();
        Main.start();
    }

    public static void start() {
        SystemC s = new SystemC();

        s.inputStSm();
        s.inputPercent();
        s.getAct();

        if (s.toDo == 1) s.inputFnSm();
        else s.inputTime();

        s.calculate();
        s.askRestart();

    }
}