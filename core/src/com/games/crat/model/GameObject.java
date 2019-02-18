package com.games.crat.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Polygon;

 abstract class GameObject {
     Polygon bound;
     Sprite object;
     GameObject (Texture texture, float x , float y , float width , float height) {
       // bound = new Polygon(x ,y,width,height);

        object = new Sprite(texture);
        object.setSize(width,height);
        object.setOrigin( width / 2f,height / 2f);

        bound = new Polygon(new float[]{0f,0f,width,0f,width,height,0f,height});
        bound.setPosition(x,y);
        bound.setOrigin(width / 2f,height / 2f);

    }
    public  void draw (SpriteBatch batch){
      //  object.setBounds(bound.getX(),bound.getY(),bound.getWidth(),bound.getHeight());//Размеры задаваемого обьека
       object.setPosition(bound.getX(),bound.getY());
       object.setRotation(bound.getRotation());
        object.draw(batch);
    }
    public Polygon getBound (){
         return bound;
    }
}
