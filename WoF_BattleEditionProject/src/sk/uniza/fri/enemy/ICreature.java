package sk.uniza.fri.enemy;

/**
 * 14. 3. 2022 - 12:47
 *
 * @author Alex-PC
 */
public interface ICreature {

    float BASE_DAMAGE = 10;
    float BASE_ARMOR = 1;

    void takeDamage(float damage);
    void doDamage(ICreature creature);
    boolean isDead();
    float getHealth();
}
