package com.dima;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

public class Rocket extends Actor implements InputProcessor {
    private Texture texture;
    private float positionX;
    private float deltaPositionX = 10;
    private boolean moveToLeftIsAllowed = false;
    private boolean moveToRightIsAllowed = false;

    Rocket(float x, float y, float width, float height, Color color) {
        createTexture((int) width, (int) height, color);
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
        positionX = x;
    }

    private void createTexture(int width, int height, Color color) {
        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        pixmap.setColor(color);
        pixmap.fillRectangle(0, 0, width, height);
        texture = new Texture(pixmap);
        pixmap.dispose();
    }

    private void moveToLeft() {
        if (positionX > 0 && moveToLeftIsAllowed) {
            float newX = positionX - deltaPositionX;
            move(newX, this::moveToLeft);
        }
    }

    private void moveToRight() {
        if (positionX < PingPongGame.SCREEN_WIDTH - PingPongGame.ROCKET_WIDTH && moveToRightIsAllowed) {
            float newX = positionX + deltaPositionX;
            move(newX, this::moveToRight);
        }
    }

    private void move(float position, Runnable method) {
        positionX = position;

        MoveToAction action = new MoveToAction();
        action.setPosition(position, 0);
        action.setDuration(0.005f);

        addAction(sequence(action, run(method)));
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        Color color = getColor();
        batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
        batch.draw(texture, getX(), getY(), getWidth(), getHeight());
    }

    public boolean keyDown(int keycode) {
        if (keycode == 21) {
            moveToLeftIsAllowed = true;
            moveToLeft();
        }
        else if (keycode == 22) {
            moveToRightIsAllowed = true;
            moveToRight();
        }
        return false;
    }

    public boolean keyUp(int keycode) {
        if (keycode == 21) {
            moveToLeftIsAllowed = false;
        }
        else if (keycode == 22) {
            moveToRightIsAllowed = false;
        }
        return false;
    }

    public boolean keyTyped(char character) {
        return false;
    }

    public boolean touchDown(int x, int y, int pointer, int button) {
        return false;
    }

    public boolean touchUp(int x, int y, int pointer, int button) {
        return false;
    }

    public boolean touchDragged(int x, int y, int pointer) {
        return false;
    }

    public boolean mouseMoved(int x, int y) {
        return false;
    }

    public boolean scrolled(int amount) {
        return false;
    }
}
