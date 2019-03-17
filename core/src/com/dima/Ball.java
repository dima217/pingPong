package com.dima;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Ball extends Actor {
    private Texture texture;

    Ball(float x, float y, float radius, Color color) {
        createTexture((int) radius, color);
        setX(x);
        setY(y);
        setWidth(radius * 2);
        setHeight(radius * 2);
    }

    private void createTexture(int radius, Color color) {
        Pixmap pixmap = new Pixmap(radius * 2 + 1, radius * 2 + 1, Pixmap.Format.RGBA8888);
        pixmap.setColor(color);
        pixmap.fillCircle(radius, radius, radius);
//        pixmap.drawLine(0, 0, 0, 0);
//        Pixmap.setFilter(Pixmap.Filter.NearestNeighbour);

        texture = new Texture(pixmap);
        pixmap.dispose();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        Color color = getColor();
        batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
        batch.draw(texture, getX(), getY(), getWidth(), getHeight());
    }
}
