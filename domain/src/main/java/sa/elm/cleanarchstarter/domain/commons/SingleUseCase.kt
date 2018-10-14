package sa.elm.cleanarchstarter.domain.commons

import io.reactivex.Single

interface SingleUseCase<Q : SingleUseCase.Request, T> {
    fun execute(requestValues: Q): Single<T>

    interface Request
}