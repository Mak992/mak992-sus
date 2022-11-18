package testj.content;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.entities.bullet.*;
import mindustry.entities.pattern.*;
import mindustry.graphics.Pal;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.blocks.defense.turrets.ItemTurret;

import static mindustry.type.ItemStack.with;

public class TestjmodBlocks {
    public static Block
            //defense
            testWall, testWallLarge,
            //turrets
            venit;

    public static void load() {
        int wallHealthMultiplier = 4;
        testWall = new Wall("testWall") {
            {
                size = 1;
                health = 70 * wallHealthMultiplier;
                requirements(Category.defense, with(Items.scrap, 8));

        testWallLarge = new Wall("testWallLarge") {
            {
                size = 2;
                health = 70 * wallHealthMultiplier * 4;
                requirements(Category.defense, with(Items.copper, 32));
            }

        };
        //enderegion; region turrets
                venit = new ItemTurret("venit"){{
                    requirements(Category.turret, with(Items.lead, 50, Items.graphite, 30));
                    ammo(
                            Items.lead, new FlakBulletType(){{
                                speed = 5;
                                height = 9;
                                width = 9;
                                damage = 7;
                                splashDamage = 10f;
                                splashDamageRadius = 60f;
                                backColor = Pal.plastaniumBack;
                                frontColor = Pal.plastaniumFront;
                                hitEffect = Fx.flakExplosionBig;
                                collidesGround = true;
                            }},
                            Items.graphite, new FlakBulletType(){{
                                speed = 4;
                                height = 10;
                                width = 10;
                                damage = 11;
                                splashDamage = 16f;
                                splashDamageRadius = 42f;
                                backColor = Pal.bulletYellowBack;
                                frontColor = Pal.bulletYellow;
                                hitEffect = Fx.flakExplosionBig;
                                collidesGround = true;
                            }},
                            Items.silicon, new FlakBulletType(){{
                                speed = 6;
                                height = 10;
                                width = 7;
                                damage = 14;
                                splashDamage = 26f;
                                splashDamageRadius = 30f;
                                backColor = Pal.bulletYellowBack;
                                frontColor = Pal.bulletYellow;
                                hitEffect = Fx.flakExplosion;
                                collidesGround = true;
                            }}
                    );

                    consumePower(3f);

                    shoot = new ShootSpread();
                    shootY = 3f;
                    reload = 150f;
                    range = 110;
                    inaccuracy = 1f;
                    shootCone = 0.1f;
                    ammoUseEffect = Fx.casing1;
                    health = 240;
                    rotateSpeed = 6f;
                    coolant = consumeCoolant(0.15f);
                    researchCostMultiplier = 0.06f;

                    limitRange();
                }};
    }
};}}