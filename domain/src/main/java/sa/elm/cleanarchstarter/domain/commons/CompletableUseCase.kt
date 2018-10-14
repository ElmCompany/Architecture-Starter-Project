package sa.elm.cleanarchstarter.domain.commons

import io.reactivex.Completable

interface CompletableUseCase<Q : CompletableUseCase.Request> {
    fun execute(requestValues: Q): Completable

    interface Request
}