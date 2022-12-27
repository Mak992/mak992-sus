package testj.content;

import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import arc.struct.*;
import arc.util.*;
import mindustry.ai.*;
import mindustry.ai.types.*;
import mindustry.entities.*;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.entities.part.*;
import mindustry.entities.pattern.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.content.Items;
import mindustry.type.*;
import mindustry.type.ammo.*;
import mindustry.type.unit.*;
import mindustry.type.weapons.*;
import mindustry.world.meta.*;

import static arc.graphics.g2d.Draw.*;
import static arc.graphics.g2d.Lines.*;
import static arc.math.Angles.*;
import static mindustry.Vars.*;

public class TestjmodUnitTypes {
    public static UnitType Car,
    //cars
    rota;

    public static void load() {
        rota = new TankUnitType("rota") {
            {
                float unitRange = 20 * tilesize;
                health = 240;
                armor = 1;
                hitSize = 15;

                speed = 4f;
                accel = 0.04f;
                rotateSpeed = 1.8f;
                ammoType = new ItemAmmoType(Items.coal);

                range = unitRange;
                maxRange = unitRange;

                treadFrames = 9;
                treadPullOffset = 4;
                treadRects = new Rect[]{
                        // 0
                        new Rect(8 - 128 / 2f, 48 - 240 / 2f, 27, 142)
                };
            };
        };
    }
}
