package com.kilobolt.TweenAccessors;

import aurelienribon.tweenengine.TweenAccessor;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class SpriteAccessor implements TweenAccessor<Sprite> {
    public static final int ALPHA = 1;

    public SpriteAccessor() {
    }

    public int getValues(Sprite target, int tweenType, float[] returnValues) {
        switch(tweenType) {
            case 1:
                returnValues[0] = target.getColor().a;
                return 1;
            default:
                return 0;
        }
    }

    public void setValues(Sprite target, int tweenType, float[] newValues) {
        switch(tweenType) {
            case 1:
                target.setColor(1.0F, 1.0F, 1.0F, newValues[0]);
            default:
        }
    }
}
