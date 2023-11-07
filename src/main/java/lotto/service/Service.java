package lotto.service;

import static lotto.validation.validation.isInvalidNumber;
import static lotto.validation.validation.validateStringForSplit;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;

public class Service {
    private static final int ZERO = 0;
    private static final int MIN_NUMBER = 1;
    private static final int SIZE = 6;
    private static final int MAX_NUMBER = 45;

    public List<Lotto> createLottos(int TicketCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = ZERO; i < TicketCount; i++) {
            lottos.add(createRandomLottoNumber());
        }
        return lottos;
    }

    public Lotto createRandomLottoNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, SIZE);
        return new Lotto(numbers);
    }

    public List<Integer> splitStringToIntegerList(String winningNumber) {
        List<String> splitNumbers = validateStringForSplit(winningNumber);
        return validateNumbers(splitNumbers);
    }


    private List<Integer> validateNumbers(List<String> winningNumber) {
        List<Integer> validNumbers = new ArrayList<>();
        for (String numberString : winningNumber) {
            validNumbers.add(isInvalidNumber(numberString));
        }
        return validNumbers;
    }

}
