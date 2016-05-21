package com.mygaienko.rt_system.model.interfaces;

import com.mygaienko.rt_system.model.WorkingArea;

/**
 * Created by enda1n on 21.05.2016.
 */
public interface Stepable {

    void step(long steps, Positionable position, WorkingArea area);
}
