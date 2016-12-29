package com.kilobolt.screens;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenEquations;
import aurelienribon.tweenengine.TweenManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.kilobolt.TweenAccessors.SpriteAccessor;
import com.kilobolt.screens.GameScreen;
import com.kilobolt.zbHelpers.AssetLoader;
import com.kilobolt.zombiebird.ZBGame;

public class SplashScreen implements Screen {
    private TweenManager manager;
    private SpriteBatch batcher;
    private Sprite sprite;
    private ZBGame game;

    public SplashScreen(ZBGame game) {
        this.game = game;
    }

    public void show() {
        this.sprite = new Sprite(AssetLoader.logo);
        this.sprite.setColor(1.0F, 1.0F, 1.0F, 0.0F);
        float width = (float)Gdx.graphics.getWidth();
        float height = (float)Gdx.graphics.getHeight();
        float desiredWidth = width * 0.7F;
        float scale = desiredWidth / this.sprite.getWidth();
        this.sprite.setSize(this.sprite.getWidth() * scale, this.sprite.getHeight() * scale);
        this.sprite.setPosition(width / 2.0F - this.sprite.getWidth() / 2.0F, height / 2.0F - this.sprite.getHeight() / 2.0F);
        this.setupTween();
        this.batcher = new SpriteBatch();
    }

    private void setupTween() {
        Tween.registerAccessor(Sprite.class, new SpriteAccessor());
        this.manager = new TweenManager();

        TweenCallback cb = new TweenCallback() {
            @Override
            public void onEvent(int type, BaseTween<?> source) {
                game.setScreen(new GameScreen());
            }
        };
        Tween.to(this.sprite, SpriteAccessor.ALPHA, 1.2F).target(1.0F).ease(TweenEquations.easeInOutQuad).repeatYoyo(1, 0.4F).setCallback(cb).setCallbackTriggers(TweenCallback.COMPLETE).start(this.manager);
    }

    public void render(float delta) {
        this.manager.update(delta);
        Gdx.gl.glClearColor(1.0F, 1.0F, 1.0F, 1.0F);
        Gdx.gl.glClear(16384);
        this.batcher.begin();
        this.sprite.draw(this.batcher);
        this.batcher.end();
    }

    public void resize(int width, int height) {
    }

    public void hide() {
    }

    public void pause() {
    }

    public void resume() {
    }

    public void dispose() {
    }
}
