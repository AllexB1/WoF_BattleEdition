package sk.uniza.fri.enemy;

import java.util.ArrayList;

public class SkeletonLich extends Skeleton implements IHealable {

    private int roundCounter = 0;
    private static final float DAMAGE = 50;

    public SkeletonLich () {
        super.health = 20;
        //this.setHealth(20);
    }

    public void doDamage(ICreature creature) {
        this.roundCounter += 1;
        if (this.roundCounter > 2) {
            super.doDamage(creature);
            //creature.takeDamage(this.DAMAGE);
            this.roundCounter = 0;
        }
    }

    @Override
    public void healCreatures(ArrayList<ICreature> creatures) {
        float healAmount = 10;
        for (ICreature creature : creatures) {
            if (!creature.isDead()) {
                creature.heal(healAmount);
            }
        }
    }
}







