package lotto;

import java.text.MessageFormat;
import java.util.Objects;

public class LottoNumber {

    public static final int LOTTO_START_NUMBER = 1;
    public static final int LOTTO_END_NUMBER = 45;
    private final int number;

    private LottoNumber(int number) {
        validateLottoNumber(number);
        this.number = number;
    }

    public static LottoNumber ofNumber(int number) {
        return new LottoNumber(number);
    }

    private void validateLottoNumber(int number) {
        if (number < LOTTO_START_NUMBER || number > LOTTO_END_NUMBER) {
            String msg = MessageFormat.format("로또 번호는 {0}에서 {1}사이 숫자 입니다.", LOTTO_START_NUMBER, LOTTO_END_NUMBER);
            throw new IllegalArgumentException(msg);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

}
