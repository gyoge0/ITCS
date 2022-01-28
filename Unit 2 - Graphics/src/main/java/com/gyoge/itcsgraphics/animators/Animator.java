package com.gyoge.itcsgraphics.animators;

import com.gyoge.itcsgraphics.drawables.Drawable;

import java.util.HashMap;

public interface Animator {

    Drawable drawable = null;

    Drawable getDrawable(HashMap<String, Object> params);

}
