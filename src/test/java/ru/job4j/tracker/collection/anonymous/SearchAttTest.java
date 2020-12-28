package ru.job4j.tracker.collection.anonymous;

import org.junit.Assert;
import org.junit.Test;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;

public class SearchAttTest {

    @Test
    public void whenFilterSize() {
        List<Attachment> attachments = List.of(
                new Attachment("image 1", 150),
                new Attachment("bug", 100),
                new Attachment("image 2", 34),
                new Attachment("bug", 13)
        );
        List<Attachment> expected = List.of(
                new Attachment("image 1", 150)
        );
        List<Attachment> output = SearchAtt.filterSize(attachments);
        Assert.assertThat(output, is(expected));
    }

    @Test
    public void whenFilterName() {
        List<Attachment> attachments = List.of(
                new Attachment("image 1", 150),
                new Attachment("bug", 100),
                new Attachment("image 2", 34),
                new Attachment("bugs", 13)
        );
        List<Attachment> expected = List.of(
                new Attachment("bug", 100),
                new Attachment("bugs", 13)
        );
        List<Attachment> output = SearchAtt.filterName(attachments);
        Assert.assertThat(output, is(expected));
    }
}