package testj.content;

import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.entities.bullet.*;
import mindustry.entities.part.RegionPart;
import mindustry.entities.pattern.*;
import mindustry.gen.Sounds;
import mindustry.graphics.Pal;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.draw.DrawTurret;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

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
                                shootSound = Sounds.swish;
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

                    consumePower(0.25f);

                    shoot = new ShootSpread();
                    shootY = 3f;
                    reload = 150f;
                    range = 110;
                    inaccuracy = 1f;
                    shootCone = 0.1f;
                    ammoUseEffect = Fx.casing1;
                    health = 180;
                    rotateSpeed = 6f;
                    coolant = consumeCoolant(0.15f);
                    researchCostMultiplier = 0.06f;

                    limitRange();
                }};
                vitis = new ItemTurret("vitis"){{
                    requirements(Category.turret, with( Items.graphite, 50, silicon, 20, titanium, 10));
                    ammo(
                            graphite, new ArtilleryBulletType(){{
                                speed = 3f;
                                height = width = 9;
                                damage = 4;
                                splashDamage = 8f;
                                splashDamageRadius = 65f;
                                homingRange = 90f;
                                homingPower = 0.07f;
                                hitEffect = Fx.flakExplosionBig;
                                collidesGround = true;
                                collidesAir = true;
                                hitSound = Sounds.explosion;
                            }},
                            thorium, new ArtilleryBulletType(){{
                                speed = 2.5f;
                                height = width = 10;
                                damage = 9;
                                splashDamage = 14f;
                                splashDamageRadius = 45f;
                                homingRange = 80f;
                                homingPower = 0.1f;
                                hitEffect = Fx.flakExplosionBig;
                                collidesGround = true;
                                collidesAir = true;
                                hitSound = Sounds.explosion;
                            }}
                    );

                    consumePower(0.5f);

                    shoot = new ShootSine(){{
                        scl = 6f;
                        mag = 30f;
                        shots = 5;
                        shotDelay = 7f;
                    }};
                    shootY = 7f;
                    ammoPerShot = 2;
                    reload = 320f;
                    range = 180;
                    targetGround = targetAir = true;
                    inaccuracy = 16f;
                    shootCone = 30f;
                    shake = 0.8f;
                    shootSound = Sounds.sap;
                    ammoUseEffect = Fx.casing2;
                    ammoEjectBack = 4.5f;
                    health = 750;
                    size = 2;
                    rotateSpeed = 3.5f;
                    coolant = consumeCoolant(0.12f);
                    researchCostMultiplier = 0.05f;

                    drawer = new DrawTurret(){{
                        parts.add(new RegionPart("-side"){{
                            x = 5;
                            y = 5;
                            progress = PartProgress.recoil;
                            moveRot = -8f;
                            mirror = true;
                            under = true;

                            moves.add(new PartMove(PartProgress.recoil, 0, -2f, -15));
                        }});
                    }};

                    limitRange();
                }};
            }
        };}}