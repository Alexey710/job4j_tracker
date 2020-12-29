package ru.job4j.stream.examination;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {

    public static Builder of(List<Integer> source) {
        Builder builder = new Builder();
        builder.of(source);
        return builder;
    }

    public static Builder of(Integer... numbers) {
        Builder builder = new Builder();
        builder.of(numbers);
        return builder;
    }

    static class Builder {

        private final List<Integer> listBuilder = new ArrayList<>();

        public Builder of(List<Integer> list) throws UnsupportedOperationException {
            for (Integer elem : list) {
                listBuilder.add(elem);
            }
            return this;
        }

        public Builder of(Integer... integers) throws UnsupportedOperationException {
            for (Integer elem : integers) {
                listBuilder.add(elem);
            }
            return this;
        }

        public Builder map(Function<Integer, Integer> fun) throws UnsupportedOperationException {
            int index = 0;
            for (Integer elem : listBuilder) {
                listBuilder.set(index, fun.apply(elem));
                index++;
            }
            return this;
        }

        public Builder filter(Predicate<Integer> fun) throws UnsupportedOperationException {
            List<Integer> temp = new ArrayList<>();
            for (Integer elem : listBuilder) {
                if (fun.test(elem)) {
                    temp.add(elem);
                }
            }
            listBuilder.retainAll(temp);
            return this;
        }

        public List<Integer> collect() throws UnsupportedOperationException {
            return listBuilder;
        }
    }
}