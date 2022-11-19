package testj.content;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.entities.part.RegionPart;
import mindustry.entities.pattern.ShootSpread;
import mindustry.graphics.Pal;
import mindustry.type.Category;
import mindustry.type.StatusEffect;
import mindustry.world.Block;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.draw.DrawTurret;

import static mindustry.content.Items.*;
import static mindustry.type.ItemStack.with;

public class TestjmodBlocks {
    public static Block
            //defense
            testWall, testWallLarge,
            //turrets
            venit, vitis;

    public static void load() {
        int wallHealthMultiplier = 4;
        testWall = new Wall("test-wall") {
            {
                size = 1;
                health = 70 * wallHealthMultiplier;
                requirements(Category.defense, with(Items.scrap, 8));

        testWallLarge = new Wall("test-wall-large") {
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
                                height = width = 9;
                                damage = 7;
                                splashDamage = 10f;
                                splashDamageRadius = 60f;
                                backColor = Pal.plastaniumBack;
                                frontColor = Pal.plastaniumFront;
                                hitEffect = Fx.flakExplosionBig;
                                collidesGround = true;
                            }},
                            graphite, new FlakBulletType(){{
                                speed = 4;
                                height = width = 10;
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

                    consumePower(1f);

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
                        vitis = new ItemTurret("vitis"){{
                            requirements(Category.turret, with( Items.graphite, 60, Items.titanium, 35));
                            ammo(
                                    graphite, new ArtilleryBulletType(){{
                                        speed = 4;
                                        height = width = 9;
                                        damage = 18;
                                        splashDamage = 20f;
                                        splashDamageRadius = 65f;
                                        status = new StatusEffect("burning");
                                        statusDuration = 7f;
                                        fragBullets = 5;
                                        fragLifeMin = 0.1f;
                                        hitEffect = Fx.flakExplosionBig;
                                        collidesGround = true;
                                    }},
                                    thorium, new ArtilleryBulletType(){{
                                        speed = 5;
                                        height = width = 10;
                                        damage = 24;
                                        splashDamage = 28f;
                                        splashDamageRadius = 60f;
                                        status = new StatusEffect("sapped");
                                        statusDuration = 7f;
                                        fragBullets = 5;
                                        fragLifeMin = 0.1f;
                                        hitEffect = Fx.flakExplosionBig;
                                        frontColor = Pal.sapBullet;
                                        backColor = Pal.sapBulletBack;
                                        collidesGround = true;
                                    }}
                            );

                            consumePower(3f);

                            shoot = new ShootSpread();
                            shootY = 6f;
                            reload = 220f;
                            range = 180;
                            inaccuracy = 5f;
                            shootCone = 40f;
                            ammoUseEffect = Fx.casing2;
                            health = 900;
                            size = 2;
                            rotateSpeed = 6f;
                            coolant = consumeCoolant(0.12f);
                            researchCostMultiplier = 0.05f;

                            drawer = new DrawTurret(){{
                                parts.add(new RegionPart("-side"){{
                                    progress = PartProgress.warmup;
                                    moveRot = -8f;
                                    mirror = true;
                                    moves.add(new PartMove(PartProgress.recoil, 0, -2f, -10));
                                }});
                            }};

                            limitRange();
                        }};
    }
};}}