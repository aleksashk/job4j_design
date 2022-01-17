package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RoleStoreTest {

    @Test
    public void whenAddAndFindThenRoleNameIsCat() {
        RoleStore store = new RoleStore();
        store.add(new Role("0874", "Cat"));
        Role result = store.findById("0874");
        assertThat(result.getRoleName(), is("Cat"));
    }

    @Test
    public void whenAddAndFindThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("5478881", "Fish"));
        Role result = store.findById("352211458");
        assertNull(result);
    }

    @Test
    public void whenAddDuplicateAndFindRoleNameIsDog() {
        RoleStore store = new RoleStore();
        store.add(new Role("78", "Dog"));
        store.add(new Role("78", "Shark"));
        Role result = store.findById("78");
        assertThat(result.getRoleName(), is("Dog"));
    }

    @Test
    public void whenReplaceThenRoleNameIsSun() {
        RoleStore store = new RoleStore();
        store.add(new Role("56988", "Diablo"));
        store.replace("56988", new Role("56988", "Sun"));
        Role result = store.findById("56988");
        assertThat(result.getRoleName(), is("Sun"));
    }

    @Test
    public void whenNoReplaceRoleThenNoChangeRoleName() {
        RoleStore store = new RoleStore();
        store.add(new Role("568411", "Dog"));
        store.replace("235668885", new Role("235668885", "Crocodile"));
        Role result = store.findById("568411");
        assertThat(result.getRoleName(), is("Dog"));
    }

    @Test
    public void whenDeleteRoleThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("124458", "Elephant"));
        store.delete("124458");
        Role result = store.findById("124458");
        assertNull(result);
    }

    @Test
    public void whenNoDeleteRoleThenRoleNameIsTomato() {
        RoleStore store = new RoleStore();
        store.add(new Role("566889412", "Tomato"));
        store.delete("785544124487");
        Role result = store.findById("566889412");
        assertThat(result.getRoleName(), is("Tomato"));
    }
}