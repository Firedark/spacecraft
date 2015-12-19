package com.gamecell.spacecraft.Logics;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.gamecell.spacecraft.Screens.PauseScreen;
import com.gamecell.spacecraft.SpaceCraft;

/**
 * Lógica de la pantalla de pausa del joc
 * @author Josué Javier Campos Fernández
 */
public class LogicalPause extends Table {
    private SpaceCraft game;
    private PauseScreen screen;

    public LogicalPause (SpaceCraft game, PauseScreen screen){
        this.game = game;
        this.screen = screen;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    /**
    * Metodo Draw contiene el SpriteBatch para dibujar.
    * @param batch
    * @param parentAlpha
    */
    public void draw(SpriteBatch batch, float parentAlpha) {
        batch.setColor(Color.BLACK);
        super.draw(batch, parentAlpha);
    }
}
