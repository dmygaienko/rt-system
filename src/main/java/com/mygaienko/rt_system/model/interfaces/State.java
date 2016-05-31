package com.mygaienko.rt_system.model.interfaces;

import com.mygaienko.rt_system.model.Box;
import com.mygaienko.rt_system.model.WorkingArea;

/**
 * Created by enda1n on 21.05.2016.
 */
public interface State {

    void step(int steps, Positionable position, WorkingArea area);

    Box getPutBox(Positionable positionable, WorkingArea area);

}
