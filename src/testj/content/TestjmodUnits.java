package testj.content;

import mindustry.type.*;

public class TestjmodUnits {
    public static UnitType
    //cars
    rota;

    public static void load() {
        rota = new UnitType("rota") {{
            speed = 0.5f;
            hitSize = 8f;
            health = 175;
            armor = 1f;
            itemCapacity = 0;
            researchCostMultiplier = 2f;
        }};
    }}