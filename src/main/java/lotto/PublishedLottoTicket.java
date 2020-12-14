package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class PublishedLottoTicket {

    private final Set<LottoTicket> publishedLottoTicket;

    private PublishedLottoTicket(int lottoTicketCount) {
        this.publishedLottoTicket = new HashSet<>();
        publishLottoTicket(lottoTicketCount);
    }

    public static PublishedLottoTicket ofLottoTicketCount(int lottoTicketCount) {
        return new PublishedLottoTicket(lottoTicketCount);
    }

    private void publishLottoTicket(int lottoTicketCounts) {
        for (int i = 0; i < lottoTicketCounts; i++) {
            Set<LottoNumber> lottoNumbers = LottoMachine.generateLottoNumber();
            this.publishedLottoTicket.add(new LottoTicket(lottoNumbers));
        }
    }

    public Set<LottoTicket> getPublishedLottoTicket() {
        return Collections.unmodifiableSet(publishedLottoTicket);
    }

}
