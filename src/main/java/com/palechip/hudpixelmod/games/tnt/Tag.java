package com.palechip.hudpixelmod.games.tnt;

import com.palechip.hudpixelmod.components.CoinCounterComponent;
import com.palechip.hudpixelmod.components.TimerComponent;
import com.palechip.hudpixelmod.games.Game;

public class Tag extends Game {
    private static final int TIME_DISPLAY_INDEX = 0;
    private static final int COIN_DISPLAY_INDEX = 1;

    CoinCounterComponent coinCounter;
    TimerComponent timer;

    public Tag() {
        super("TNT Tag", "", "The TNT has been released!", "You earned a total of");
        this.coinCounter = new CoinCounterComponent();
        this.timer = new TimerComponent();
    }

    @Override
    public void setupNewGame() {
        this.coinCounter.setupNewGame();
        this.timer.setupNewGame();

        this.renderStrings.clear();
        this.renderStrings.add(this.timer.getRenderingString());
        this.renderStrings.add(this.coinCounter.getRenderingString());
    }

    @Override
    protected void onGameStart() {
        this.timer.onStartGame();
    }

    @Override
    protected void onGameEnd() {
    }

    @Override
    public void onTickUpdate() {
        this.timer.onTickUpdate();
        this.renderStrings.set(TIME_DISPLAY_INDEX, this.timer.getRenderingString());
    }

    @Override
    public void onChatMessage(String textMessage, String formattedMessage) {
        this.coinCounter.onChatMessage(textMessage, formattedMessage);
        if(!this.coinCounter.getRenderingString().equals(this.renderStrings.get(COIN_DISPLAY_INDEX))) {
            this.renderStrings.set(COIN_DISPLAY_INDEX, this.coinCounter.getRenderingString());
        }
    }

}
