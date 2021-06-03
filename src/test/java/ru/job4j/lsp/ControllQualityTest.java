package ru.job4j.lsp;

import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ControllQualityTest {

    @Test
    public void fresh() {
        ControllQuality checker = new ControllQuality();
        LocalDate now = LocalDate.now();
        Milk milk = new Milk("Milk", now.minusDays(4), 60, 0);
        assertEquals(checker.fresh(milk), 80);
    }

    @Test
    public void whenDiscount() {
        ControllQuality checker = new ControllQuality();
        LocalDate now = LocalDate.now();
        Milk milk = new Milk("Milk", now.minusDays(4), 60, 0);
        Shop shop = new Shop();
        shop.add(milk, checker.fresh(milk));
        assertEquals(milk.getDiscount(), 25);
    }

    @Test
    public void notFresh() {
        ControllQuality checker = new ControllQuality();
        LocalDate now = LocalDate.now();
        Milk milk = new Milk("Milk", now.minusDays(5), 60, 0);
        assertEquals(checker.fresh(milk), 100);
    }

    @Test
    public void whenDistribute() {
        ControllQuality checker = new ControllQuality();
        LocalDate now = LocalDate.now();
        Milk milk = new Milk("Milk", now.minusDays(4), 60, 0);
        Bread bread = new Bread("Bread", now, 32, 0);
        Milk anotherMilk = new Milk("Milk", now.minusDays(2), 60, 0);
        Bread anotherBread = new Bread("Bread", now.minusDays(10), 32, 0);
        List<Food> foods = new ArrayList<Food>(List.of(milk, bread, anotherBread, anotherMilk));
        Warehouse warehouse = new Warehouse(foods);
        List<Storage> storages = List.of(warehouse, new Shop(), new Trash());
        checker.redistribute(storages);

        assertThat(new int[]{
                storages.get(0).getList().size(),
                storages.get(1).getList().size(),
                storages.get(2).getList().size()},
                is(new int[]{1, 2, 0}));
    }
}