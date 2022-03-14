package sk.uniza.fri.enemy;

/**
 * 14. 3. 2022 - 12:47
 *
 * @author Alex-PC
 */
public interface ICreature {

    void takeDamage(float damage);
    void doDamage(ICreature creature);
    boolean isDead();
}
