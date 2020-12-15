package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoGame {

    public static void main(String[] args) {
        LottoMoney lottoMoney = new LottoMoney(InputView.inputMoney());
        LottoTicketCount lottoTicketCount = LottoTicketCount.getInstance(lottoMoney);

        LottoShop lottoShop = LottoShop.getInstance();
        PublishedLottoTicket publishedLottoTicket = lottoShop.buyLotto(lottoMoney);

        OutputView.printPublishedLottoResult(lottoTicketCount, publishedLottoTicket);

        List<Integer> winningLottoNumbers = InputView.inputWinningLottoNumbers();
        WinningLotto winningLotto = WinningLotto.ofLottoNumbers(LottoMachine.createManualLottoNumbers(winningLottoNumbers));

        LottoResult lottoResult = LottoResult.getInstance();
        lottoResult.analyzeLottoRank(publishedLottoTicket.getPublishedLottoTicket(), winningLotto);

        OutputView.printLottoStatics(lottoResult, lottoResult.calculatePrizeRate(lottoMoney));
    }

}
