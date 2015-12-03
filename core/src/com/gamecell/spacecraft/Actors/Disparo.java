package com.gamecell.spacecraft.Actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.gamecell.spacecraft.Logics.LogicalGame;
import com.gamecell.spacecraft.SpaceCraft;

/**
 * Clase Disparo, crea un actor con una acción de movimiento ascendente.
 * @author Sergio Jimenez Cortes *
 */
public class Disparo extends GenDisparo {
    private SpaceCraft game;
    private Texture textura;
    private MoveToAction accion;
    private LogicalGame logical;
    private GenEnemigo target;
    private Nave nave;

    /**
     * Constructor de la clase.
     * @param game de la clase principal
     * @param potencia valor de potencia del disparo, cambia el ancho alto de este.
     * @param nave le pasamos la nave para ubicar el disparo.
     */
    public Disparo(SpaceCraft game, int potencia, Nave nave,LogicalGame logical){
        this.game = game;
        this.logical = logical;
        this.nave = nave;
        this.textura = game.images.manager.get("Images/disparo.png");
        this.setBounds(nave.getX()+58,nave.getY()+60,12,12);
        super.potencia = potencia;
        accion = new MoveToAction();

        accion.setDuration(7f);
        accion.setPosition(getX(),800);
        float min = 20000000;

        for (GenEnemigo a : logical.colShootables){

            if(a.getY() < 600 && a.getY() > 70 && a.estado == 1) {
                Vector2 pDisparo = new Vector2((getX()-(getWidth()/2)), getY()-(getHeight()/2));
                Vector2 pDestruible = new Vector2((a.getX()-(a.getHeight()/2)),a.getY()-(a.getWidth()/2));
                Vector2 vDistancia = pDestruible.sub(pDisparo);
                float distancia = vDistancia.len();
                if (distancia < min) {
                    min = distancia;
                    target = a;

                }
            }


        }

        this.addAction(accion);


        super.rect = new Rectangle(getX(),getY(),getWidth(),getHeight());
    }

    /**
     * Metodo de dibujo del actor.
     */
    @Override
    public void draw(Batch batch,float parentAlpha){
        try {

            if (target != null && target.estado != 0) {
                accion.setDuration(11f);
                accion.setPosition(target.getX(), target.getY());
                this.addAction(accion);
            }

            if(super.potencia == 0 || this.getActions().size == 0){
                logical.removeActor(this);
                logical.colDisparos.remove(this);
            }



        }catch (Exception e){

        }

        super.rect.set(getX(),getY(),getWidth(),getHeight());
        batch.draw(textura, getX(), getY(), getWidth(), getHeight());
    }



}
