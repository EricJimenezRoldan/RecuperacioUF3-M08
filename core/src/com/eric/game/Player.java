package com.eric.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Player {
    private Texture img;
    private Animation<TextureRegion> running;
    private Animation<TextureRegion> idle;
    private int x,y;
    private float stateTime;
    private int playerMode = 0;
    private int rotation = 2;

    public Player(Texture sprite, int x,int y){
        this.img = sprite;
        // Running animation
        TextureRegion runningFrame[] = new TextureRegion[5];
        runningFrame[0] = new TextureRegion(img,0,3,97,50);
        runningFrame[1] = new TextureRegion(img,98,2,97,50);
        runningFrame[2] = new TextureRegion(img,199,4,97,50);
        runningFrame[3] = new TextureRegion(img,299,4,97,50);
        runningFrame[4] = new TextureRegion(img,399,5,97,50);
        this.running = new Animation<TextureRegion>(0.08f,runningFrame);
        // Idle animation
        TextureRegion idleFrame[] = new TextureRegion[1];
        idleFrame[0] = new TextureRegion(img,0,3,97,50);
        this.idle = new Animation<TextureRegion>(0.12f,idleFrame);
        this.x=x;
        this.y=y;
    }
    private TextureRegion getPlayerFrame(){
        if(playerMode==1){
            return running.getKeyFrame(stateTime,true);
        }
        return idle.getKeyFrame(stateTime,true);
    }
    public void render(Batch batch){
        stateTime += Gdx.graphics.getDeltaTime();
        TextureRegion playerFrame = getPlayerFrame();
        batch.draw(playerFrame, x,y,0, 0,playerFrame.getRegionWidth(),playerFrame.getRegionHeight(),rotation,2,0);
    }
    public void disposeTextures(){
        img.dispose();
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getPlayerMode() {
        return playerMode;
    }

    public void setPlayerMode(int playerMode) {
        this.playerMode = playerMode;
    }

    public int getRotation() {
        return rotation;
    }

    public void setRotation(int rotation) {
        this.rotation = rotation;
    }
}
