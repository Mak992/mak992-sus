package testj.content;

import arc.math.geom.*;
import mindustry.gen.TankUnit;
import mindustry.type.*;

public class TestjmodUnits {
    public static UnitType
    //cars
    rota;

    public static void load() {
        rota = new UnitType("rota") {{
            hitSize = 11f;
            speed = 1.2f;
            hitSize = 8f;
            health = 175;
            armor = 1f;
            itemCapacity = 0;
            treadRects = new Rect[]{new Rect(12 - 32f, 7 - 32f, 14, 51)};
            omniMovement = true;
            researchCostMultiplier = 2f;
            constructor = TankUnit::create;
        }};
    }}