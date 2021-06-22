package ru.job4j.lsp.mistakes;

public class Battle {

    /**
     * У хилера отрицательный урон. Если он атакует, то hp увеличатся, а не уменьшатся,
     * при этом они могут превысить максимальное значение
     */
    public boolean attack(Unit unit, Unit enemy) {
        if (unit == null || enemy == null) {
            return false;
        }
       int damage = enemy.getHp() - unit.getDamage();
       if (damage < 0) {
           System.out.println("Enemy is killed");
       }
       enemy.setHp(enemy.getHp() - damage);
       return true;
    }
}
