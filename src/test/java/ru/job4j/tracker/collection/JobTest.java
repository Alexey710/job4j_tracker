package ru.job4j.tracker.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class JobTest {
    @Test
    public void whenSortNameAndPriority() {
        List<Job> input = new ArrayList<>();
        input.add(new Job("a1", 2 ));
        input.add(new Job("a3", 1 ));
        input.add(new Job("a2", 0 ));
        input.add(new Job("c", 3 ));
        input.add(new Job("b", 4 ));
        List<Job> expected = List.of(
                new Job("a1", 2 ),
                new Job("a2", 0 ),
                new Job("a3", 1 ),
                new Job("b", 4 ),
                new Job("c", 3 )
        );
        Comparator<Job> comb = new ComparatorNameAsc().thenComparing(new ComparatorPriorityAsc());
        Collections.sort(input, comb);
        Assert.assertThat(input, is(expected));
    }

    @Test
    public void whenSortPriorityAsc() {
        List<Job> input = new ArrayList<>();
        input.add(new Job("a1", 2 ));
        input.add(new Job("a3", 1 ));
        input.add(new Job("a2", 0 ));
        input.add(new Job("c", 3 ));
        input.add(new Job("b", 4 ));
        List<Job> expected = List.of(
                new Job("a2", 0 ),
                new Job("a3", 1 ),
                new Job("a1", 2 ),
                new Job("c", 3 ),
                new Job("b", 4 )
        );
        Collections.sort(input, new ComparatorPriorityAsc());
        Assert.assertThat(input, is(expected));
    }

    @Test
    public void whenSortPriorityDsc() {
        List<Job> input = new ArrayList<>();
        input.add(new Job("a1", 2 ));
        input.add(new Job("a3", 1 ));
        input.add(new Job("a2", 0 ));
        input.add(new Job("c", 3 ));
        input.add(new Job("b", 4 ));
        List<Job> expected = List.of(
                new Job("b", 4 ), new Job("c", 3 ),
                new Job("a1", 2 ), new Job("a3", 1 ), new Job("a2", 0 )
        );
        Collections.sort(input, new ComparatorPriorityDsc());
        Assert.assertThat(input, is(expected));
    }

    @Test
    public void whenSortNameAsc() {
        List<Job> input = new ArrayList<>();
        input.add(new Job("a1", 2 ));
        input.add(new Job("a3", 1 ));
        input.add(new Job("a2", 0 ));
        input.add(new Job("c", 3 ));
        input.add(new Job("b", 4 ));
        List<Job> expected = List.of(
                new Job("a1", 2 ), new Job("a2", 0 ), new Job("a3", 1 ),
                new Job("b", 4 ), new Job("c", 3 )
        );
        Collections.sort(input, new ComparatorNameAsc());
        Assert.assertThat(input, is(expected));
    }

    @Test
    public void whenSortNameDsc() {
        List<Job> input = new ArrayList<>();
        input.add(new Job("a1", 2 ));
        input.add(new Job("a3", 1 ));
        input.add(new Job("a2", 0 ));
        input.add(new Job("c", 3 ));
        input.add(new Job("b", 4 ));
        List<Job> expected = List.of(
                new Job("c", 3 ), new Job("b", 4 ),
                new Job("a3", 1 ), new Job("a2", 0 ),  new Job("a1", 2 )

        );
        Collections.sort(input, new ComparatorNameDesc());
        Assert.assertThat(input, is(expected));
    }

}