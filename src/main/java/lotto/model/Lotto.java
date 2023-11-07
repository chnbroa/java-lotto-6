package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.view.exception.DuplicateNumberException;
import lotto.view.exception.InvalidLottoSizeException;
import lotto.view.exception.InvalidNumberRangeException;

public class Lotto {
    private static final int MIN_NUMBER = 1;
    private static final int SIZE = 6;
    private static final int MAX_NUMBER = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumberSize(numbers);
        validateDuplicateNumbers(numbers);
        validateNumberRange(numbers);
        this.numbers = sortNumbers(numbers);
    }

    private void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new InvalidLottoSizeException();
        }
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (numbers.size() != set.size()) {
            throw new DuplicateNumberException();
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new InvalidNumberRangeException();
            }
        }
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        List<Integer> sortedList = new ArrayList<>(numbers);
        Collections.sort(sortedList);
        return sortedList;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
