package lotto;

public class LottoTicketCount {
    private static final int LOTTO_PRICE = 1000;
    private final int lottoTicketCount;

    private LottoTicketCount(int money) {
        this.lottoTicketCount = calculateLottoTicketCount(money);
    }

    public static LottoTicketCount getInstance(int money) {
        return new LottoTicketCount(money);
    }

    private int calculateLottoTicketCount(int money) {
        return money / LOTTO_PRICE;
    }

    public int getLottoTicketCount() {
        return lottoTicketCount;
    }
}
