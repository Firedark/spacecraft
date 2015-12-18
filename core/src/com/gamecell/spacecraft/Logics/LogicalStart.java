package com.gamecell.spacecraft.Logics;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.gamecell.spacecraft.DinamicBackground;
import com.gamecell.spacecraft.Screens.StartScreen;
import com.gamecell.spacecraft.SpaceCraft;

/**
 * Clase Logical, donde se inserta la logica para la pantalla de start del juego.
 * @author Sergio Jimenez Cortes *
 */
public class LogicalStart extends Table {
    //Atributos de la clase

    SpaceCraft game;
    private DinamicBackground dynBacks;
    private Texture planeta;
    private SpriteBatch batch;
    public LogicalStart(SpaceCraft game, StartScreen screen){

        this.game = game;
        dynBacks = new DinamicBackground(game,this);
        //Zona de instancia de Actores varios.
        planeta = new Texture("Images/Start-planeta.png");
        batch = new SpriteBatch();

    }

    /**
     * Metodo act se ejecuta al igual que el render, es donde insertaremos la lógica.
     */
    @Override
    public void act(float delta) {
        super.act(delta);
        //batch.begin();
        //batch.draw(planeta, game.w/2-planeta.getWidth()/2, game.h/2+100);
        //batch.end();
        dynBacks.checkMillis();
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
