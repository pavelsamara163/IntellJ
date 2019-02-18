package com.games.crat.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

 abstract class GameObject {
     Rectangle bound;
     Sprite object;
     GameObject (Texture texture, float x , float y , float width , float height) {
        bound = new Rectangle(x ,y,width,height);
        object = new Sprite(texture);
    }
    public  void draw (SpriteBatch batch){
        object.setBounds(bound.getX(),bound.getY(),bound.getWidth(),bound.getHeight());//Размеры задаваемого обьека
        object.draw(batch);
    }
}
