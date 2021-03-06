package racingcar

import racingcar.domain.Participants
import racingcar.strategy.MovingStrategy

class RacingGame(
    private val carNames: String,
    private var tryCount: Int,
    private val movingStrategy: MovingStrategy
) {
    private val participants = Participants(carNames, movingStrategy)

    fun startRound(): String {
        if (isProgress()) {
            participants.processRound()
            tryCount--
        }

        return participants.toString()
    }

    fun findWinners() = participants.findWinner()

    fun isProgress() = tryCount > 0
}
