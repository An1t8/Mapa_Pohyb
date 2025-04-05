package game;

import commands.BigBang;
import commands.Comet;
import questions.QuestionsControler;

import java.io.Serializable;
import java.util.HashMap;

public class GameState implements Serializable {

    public static final long serialVersionUID = 1L;

    public Universe universe;
    public CrystalBag crystalBag;
    public String currentPlanetName;
    public BaseStation baseStation;
    public GalacticSailor galacticSailor;
    public QuestionsControler questionsControler;
    public Comet comet;
    public boolean gameCompleted;
    public HashMap<String, Boolean> takenCrystals;

}
