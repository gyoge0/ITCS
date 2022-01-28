package com.gyoge.itcsgraphics.animators;

import com.gyoge.itcsgraphics.drawables.Drawable;

import java.util.HashMap;

/**
 * Animator
 * <p>
 * Interface for all animators. Animators are classes that provide a way to animate Drawables in a
 * certain way. One Drawable can have multiple Animators.
 *
 * @author Yogesh Thambidurai
 * @see Drawable
 */
public interface Animator {

    /**
     * The drawable that the subclass animates. Redundant assignment, but *apparently* it's not
     * initialized.
     */
    @SuppressWarnings("unused")
    Drawable drawable = null;

    /**
     * Retrieve the drawable for an animator placed in the correct position.
     *
     * @param params Map of params for all animators, which the animator will use certain parameters
     *               from.
     * @return The drawable for the animator, which can be used to draw the drawable in the correct
     * spot.
     */
    Drawable getDrawable(HashMap<String, Object> params);

}
